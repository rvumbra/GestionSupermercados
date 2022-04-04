package Modelo.Repositorio;

import Modelo.pojo.Producto;
import Utils.misStrings;
import Utils.Colores;
import Utils.Enumeraciones;
import Utils.csvAcceso;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * Esta clase será la que obtenga e inicie la lista de productos del almacén de valores ya definidos
 * con anterioridad, ya sea de manera estática o de un archivo externo.
 *
 * Tengo un constructor privado, ya que esta clase solo permitirá una instancia de ella, por lo que
 * obligo a llamar a getInstance() para acceder a la única instancia existente, y si no la tiene,
 * genera una nueva que será a la que se acceda a partir de su creación.
 */
public class AlmacenRepository {
    private HashMap<String, Producto> productos;
    private static AlmacenRepository instance;

    /**
     * Añadir String = "" para crear a la instancia.
     *
     * @param Instancia_Del_Repositorio String vacío para llamar a este constructor y no al de por defecto.
     */
    private AlmacenRepository(String Instancia_Del_Repositorio) {
        productos = new HashMap<>();
    }

    public static AlmacenRepository getInstance() {
        if (instance == null){
            instance = new AlmacenRepository("");
            return instance;
        }
        return instance;
    }

    public HashMap<String, Producto> getProductos() {
        return productos;
    }

    private void setAlmacen(HashMap<String, Producto> almacen) {
        this.productos = almacen;
    }

    /**
     * Inserta datos por defecto en la lista para realizar pruebas.
     */
    public void valoresDePrueba(){
        HashMap<String, Producto> lista = new HashMap<>();
        HashMap<String, Producto> productosTMP;
        String nombreProducto;

        for(int i=1; i<=10;i++){
            nombreProducto = "producto" + i;
            lista.put(
                    Producto.getTag()+nombreProducto,
                    new Producto(
                            nombreProducto,
                            2.50F,
                            50,
                            Enumeraciones.CategoriaProducto.VERDURAS
                    )
            );
        }
        this.getProductos().putAll(lista);
        System.out.println(Colores.ANSI_YELLOW+"!!!Datos de prueba insertados con éxito!!!");
    }

    /**
     * Restaura los almacenes desde un archivo csv.
     *
     * @param archivo archivo con los datos que se van a restaurar.
     */
    public void actualizarCopiaCSV(File archivo){
        List<Producto> lista= new ArrayList<>();

        for (List<String> linea: csvAcceso.lectorCSV(archivo)){
            lista.add(new Producto(
                    linea.get(0),
                    Float.parseFloat(linea.get(1)),
                    Float.parseFloat(linea.get(2)),
                    Enumeraciones.CategoriaProducto.valueOf(linea.get(3))));
        }
        for (Producto p: lista){
            this.getProductos().put(Producto.getTag()+p.getNombre(), p);
        }
        System.out.print(misStrings.SEGURIDAD_COPIA_ALMACEN_ACTUALIZACION);
    }

    /**
     * Restaura la lista de productos del almacén desde un archivo csv.
     *
     * @param archivo en el que se escribirá la información.
     */
    public void crearCopiaCSV(HashMap<String, Producto> productos, File archivo){

        List<Object> lista;
        FileWriter fw;
        PrintWriter pw;

        try{
            lista = csvAcceso.escritorCSV(archivo);
            fw = (FileWriter) Objects.requireNonNull(lista).get(0);
            pw = (PrintWriter) lista.get(1);

            for(var p: productos.values()){
                String linea = p.getNombre()+","+ p.getPrecio()+","+ p.getCantidad()+","+ p.getCategoriaProducto().toString();
                pw.println(linea);
            }
            pw.close();
            fw.close();
            System.out.println(misStrings.SEGURIDAD_COPIA_ALMACEN_CREACION);

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(misStrings.ERR_ALMACEN_ESCRIBIRCSV);
        }

    }
}
