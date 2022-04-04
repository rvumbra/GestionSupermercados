package Modelo.Repositorio;

import Modelo.pojo.Producto;
import Modelo.pojo.Supermercado;
import Utils.Colores;
import Utils.Enumeraciones;
import Utils.misStrings;
import Utils.csvAcceso;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Esta clase será la que obtenga e inicie la lista de supermercados de valores ya definidos con anterioridad,
 * ya sea de manera estática o de un lugar remoto como una base de datos o un archivo.
 *
 * Tengo un constructor privado, ya que esta clase solo permitirá una instancia de ella, por lo que
 * obligo a llamar a getInstance() para acceder a la única instancia existente, y si no la tiene,
 * genera una nueva que será a la que se acceda a partir de su creación.
 */
public class SupermercadoRepository {
    private HashMap<String, Supermercado> listaSupermercados;
    private static SupermercadoRepository instance;

    /**
     * Añadir String = "" para acceder a la instancia
     */
    private SupermercadoRepository() {
        listaSupermercados = new HashMap<>();
    }

    /**
     * @return Devuelve una única instancia de SupermercadoRepository, si no existe una la crea.
     */
    public static SupermercadoRepository getInstance() {
        if (instance == null){
            instance = new SupermercadoRepository();
            return instance;
        }
        return instance;
    }

    public HashMap<String, Supermercado> getListaSupermercados() {
        return listaSupermercados;
    }

    private void setListaSupermercados(HashMap<String, Supermercado> listaSupermercados) {
        this.listaSupermercados = listaSupermercados;
    }

    /**
     * Inserta datos por defecto en la lista para realizar pruebas.
     */
    public void valoresDePrueba(){
        HashMap<String, Supermercado> supermercados = new HashMap<>();
        HashMap<String, Producto> productos = new HashMap<>();
        String nombreSupermercado;
        String nombreProducto;

        for(int i=1; i<=10;i++){
            nombreProducto = "producto"+i;
            productos.put(
                    Producto.getTag()+nombreProducto,
                    new Producto(
                            nombreProducto,
                            2.50F,
                            50,
                            Enumeraciones.CategoriaProducto.VERDURAS
                    )
            );
        }
        for(int i=1; i<=10;i++){
            nombreSupermercado = "supermercado"+i;
            supermercados.put(
                    Supermercado.getTag()+nombreSupermercado,
                    new Supermercado(
                            nombreSupermercado,
                            productos
                    )
            );
        }
        this.getListaSupermercados().putAll(supermercados);
        System.out.println(Colores.ANSI_YELLOW+ misStrings.SEGURIDAD_COPIA_DATOSPRUEBA);
    }

    /**
     * Restaura los almacenes desde un archivo csv.
     *
     * @param archivo archivo con los datos que se van a restaurar.
     */
    public void actualizarCopiaCSV(File archivo, Scanner sc){
        List<Producto> lista= new ArrayList<>();
        String tmp;

        System.out.print(misStrings.SUPERMERCADO_INTRODUCIR_NOMBRE);
        tmp = sc.next();

        if (!listaSupermercados.containsKey(Supermercado.getTag()+tmp))
            System.err.println(misStrings.ERR_SUPERMERCADO_NOEXISTE);
        else{
            for (List<String> linea: csvAcceso.lectorCSV(archivo)){
                lista.add(new Producto(
                        linea.get(0),
                        Float.parseFloat(linea.get(1)),
                        Float.parseFloat(linea.get(2)),
                        Enumeraciones.CategoriaProducto.valueOf(linea.get(3))));
            }
            for (int i=0;i<lista.size() - 1;i++){
                listaSupermercados.get(Supermercado.getTag()+tmp).getProductos().put(Producto.getTag()+lista.get(i).getNombre(), lista.get(i));
            }
            System.out.print(misStrings.SEGURIDAD_COPIA_SUPERMERCADO_ACTUALIZACION);
        }
    }

    /**
     * Restaura la lista de productos de un supermercado desde un archivo csv.
     *
     * @param archivo en el que se escribirá la información.
     */
    public void crearCopiaCSV(HashMap<String, Supermercado> listaSupermercados, File archivo, Scanner sc){
        List<Object> lista;
        FileWriter fw;
        PrintWriter pw;
        String tmp;

        try{
            System.out.print(misStrings.SUPERMERCADO_INTRODUCIR_NOMBRE);
            tmp = sc.next();
            if (!listaSupermercados.containsKey(Supermercado.getTag()+tmp))
                System.out.println(Colores.ANSI_RED+misStrings.ERR_SUPERMERCADO_NOEXISTE+Colores.ANSI_YELLOW);
            else{
                lista = csvAcceso.escritorCSV(archivo);
                fw = (FileWriter) Objects.requireNonNull(lista).get(0);
                pw = (PrintWriter) lista.get(1);

                for (Producto p: listaSupermercados.get(Supermercado.getTag()+tmp).getProductos().values()){
                    String linea = p.getNombre()+","+ p.getPrecio()+","+ p.getCantidad()+","+ p.getCategoriaProducto().toString();
                    pw.println(linea);
                }
                pw.close();
                fw.close();
                System.out.println(misStrings.SEGURIDAD_COPIA_SUPERMERCADO_CREACION);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println(misStrings.ERR_SUPERMERCADO_ESCRIBIRCSV);
        }
    }
}
