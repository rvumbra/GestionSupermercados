package Modelo.dao;

import Modelo.pojo.Producto;
import Utils.Colores;
import Utils.Enumeraciones;
import Utils.misStrings;
import Vista.SalidaConsola;

import java.util.*;

/**
 * Patrón DAO para la gestión de los distintos productos que se pueden tener en el almacén y en los supermercados.
 */
public class ProductoDAO {

    /**
     * Añade un producto a una lista de productos dado el nombre.
     *
     * @param productos HashMap<String, Producto> al que se quiere añadir uno nuevo.
     * @param sc Scanner para leer el buffer.
     */
    public static void add(HashMap<String, Producto> productos, Scanner sc){

        Producto producto = new Producto("");

        System.out.print(misStrings.PRODUCTO_INTRODUCIR_NOMBRE);
        String tmp = sc.next();

        if (productos.containsKey(Producto.getTag()+ tmp))
            System.err.println(misStrings.ERR_PRODUCTO_YAEXISTE);
        else{
            producto.setNombre(tmp);
            insertarPrecio(producto, sc);
            insertarCantidad(producto, sc);
            insertarCategoria(producto, sc);

            productos.put(Producto.getTag()+producto.getNombre(), producto);
            System.out.println(misStrings.PRODUCTO_ADD);
        }
    }

    /**
     * Este método se asegura de insertar el precio de manera correcta.
     *
     * @param producto Producto cuyo precio se va a modificar.
     * @param sc Scanner para leer el precio del buffer.
     */
    public static void insertarPrecio(Producto producto, Scanner sc){
        String tmp;

        do{
            System.out.print(Colores.ANSI_YELLOW+ misStrings.PRODUCTO_INTRODUCIR_PRECIO);
            tmp = sc.next();
            if (validarFloat(tmp))
                do{
                    if(Float.parseFloat(tmp) < 0.0F)
                        System.out.println(Colores.ANSI_RED+ misStrings.ERR_FLOAT_NEGATIVO+Colores.ANSI_YELLOW);
                    else
                        producto.setPrecio(Float.parseFloat(tmp));
                }while (Float.parseFloat(tmp) < 0.0F);
            else
                System.err.println(misStrings.ERR_FLOAT_FORMATO);
        }while (!validarFloat(tmp));
    }

    /**
     * Este método se asegura de insertar la cantidad de manera correcta.
     *
     * @param producto Producto cuya cantidad se va a modificar.
     * @param sc Scanner para leer la cantidad del buffer.
     */
    public static void insertarCantidad(Producto producto, Scanner sc){
        String tmp;

        do{
            System.out.print(Colores.ANSI_YELLOW+ misStrings.PRODUCTO_INTRODUCIR_CANTIDAD);
            tmp = sc.next();
            if (validarFloat(tmp)){
                do{
                    if(Float.parseFloat(tmp) < 0.0F)
                        System.out.println(Colores.ANSI_RED+ misStrings.ERR_FLOAT_NEGATIVO+Colores.ANSI_YELLOW);
                    else
                        producto.setCantidad(Float.parseFloat(tmp));
                }while (Float.parseFloat(tmp) < 0.0F);
            }
            else
                System.err.println(misStrings.ERR_FLOAT_FORMATO);
        }while (!validarFloat(tmp));
    }

    /**
     * Este método muestra un menú con las dintintas categorías para añadirsela al producto.
     *
     * @param producto al que se le va a añadir la categoria.
     * @param sc Scanner para leer la entrada por teclado de elegir opción en el menú de categorías.
     */
    public static void insertarCategoria(Producto producto, Scanner sc){
        String tmp;
        String[] opciones = {"1","2","3","4","5","6","7","8","9","10","11"};
        List<String> listaOpciones = new ArrayList<>();

        for (int i=0;i<opciones.length;i++){listaOpciones.add(i, opciones[i]);}

        do{
            System.out.println(SalidaConsola.MENU_PRODUCTO_CATEGORIA);
            System.out.print(misStrings.MENU_OPCION_INTRODUCIR+ Colores.ANSI_YELLOW);
            tmp = sc.next();
            switch (tmp){
                case "1"->producto.setCategoriaProducto(Enumeraciones.CategoriaProducto.CARNE);
                case "2"->producto.setCategoriaProducto(Enumeraciones.CategoriaProducto.PESCADO);
                case "3"->producto.setCategoriaProducto(Enumeraciones.CategoriaProducto.VERDURAS);
                case "4"->producto.setCategoriaProducto(Enumeraciones.CategoriaProducto.LACTEOS);
                case "5"->producto.setCategoriaProducto(Enumeraciones.CategoriaProducto.CONGELADOS);
                case "6"->producto.setCategoriaProducto(Enumeraciones.CategoriaProducto.ENLATADOS);
                case "7"->producto.setCategoriaProducto(Enumeraciones.CategoriaProducto.CONSERVA);
                case "8"->producto.setCategoriaProducto(Enumeraciones.CategoriaProducto.HOGAR);
                case "9"->producto.setCategoriaProducto(Enumeraciones.CategoriaProducto.LIMPIEZA);
                case "10"->producto.setCategoriaProducto(Enumeraciones.CategoriaProducto.HIGIENE);
                case "11"->producto.setCategoriaProducto(Enumeraciones.CategoriaProducto.VARIOS);
                default -> System.err.println(misStrings.ERR_OPCION_INVALIDA);
            }
        }while (!listaOpciones.contains(tmp));
    }

    /**
     *Valida si una cadena de texto se puede convertir en flotante o no.
     *
     * @param s Cadena que se va a intentar parsear.
     * @return True si se pudo realizar la validación, false en caso contrario.
     */
    public static boolean validarFloat(String s){
        try{
            Float.parseFloat(s);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * Muestra por pantalla la lista de productos recibida por parámetro si no está vacía.
     *
     * @param productos HashMap<String, Producto> que se va a listar.
     */
    public static void listar(HashMap<String, Producto> productos){

        if(productos.isEmpty() || productos.values() == null)
            System.out.println(Colores.ANSI_RED+ misStrings.ERR_LISTA_VACIA);
        else{
            for(Producto p:productos.values()){
                System.out.println(p.toString());
            }
        }
    }

    /**
     * Vacía la lista de productos recibida por parámetro.
     *
     * @param lista HashMap<String, Producto> que se va a vaciar.
     */
    public static void vaciarLista(HashMap<String, Producto> lista){
        lista.clear();
        System.out.println(Colores.ANSI_YELLOW+ misStrings.LISTA_VACIAR);
    }

    /**
     * Elimina un producto a especificar de la lista recibida por parámetro.
     *
     *  @param lista HashMap<String, Producto> de donde se quiere eliminar el producto.
     * @param sc Scanner para leer el buffer con el nombre del producto a eliminar.
     */
    public static void eliminar(HashMap<String, Producto> lista, Scanner sc){

        System.out.print(misStrings.PRODUCTO_INTRODUCIR_NOMBRE);
        String tmp = sc.next();

        if(!lista.containsKey(Producto.getTag()+ tmp))
            System.err.println(misStrings.ERR_PRODUCTO_NOEXISTE);
        else{
            lista.remove(Producto.getTag()+ tmp);
            System.out.println(misStrings.PRODUCTO_ELIMINAR);
        }
    }

    /**
     * Muestra un menú para elegir el campo a editar de un producto.
     *
     * @param lista HashMap<String, Producto> de donde proviene el producto que se quiere modificar.
     * @param sc Scanner que leera el buffer para la edición de un producto.
     */
    public static void editar(HashMap<String, Producto> lista, Scanner sc){
        String tmp;
        Producto producto;

        System.out.print(misStrings.PRODUCTO_INTRODUCIR_NOMBRE);
        tmp = sc.next();

        if(!lista.containsKey(Producto.getTag()+ tmp))
            System.err.println(misStrings.ERR_PRODUCTO_NOEXISTE);
        else{
            producto = lista.get(Producto.getTag()+tmp);
            do{
                System.out.println(SalidaConsola.MENU_ALMACEN_EDITAR);
                System.out.print(misStrings.MENU_OPCION_INTRODUCIR);
                tmp = sc.next();

                switch (tmp){
                    case "1"-> insertarPrecio(producto, sc);
                    case "2"-> insertarCantidad(producto, sc);
                    case "3"-> insertarCategoria(producto, sc);
                    case "0"-> {
                        lista.put(Producto.getTag()+producto.getNombre(), producto);
                        System.out.println(misStrings.PRODUCTO_EDITAR);
                        System.out.println(Colores.ANSI_RED+ misStrings.MENU_VOLVER_ATRAS);
                    }
                    default ->System.err.println(misStrings.ERR_OPCION_INVALIDA);
                }
            }while (!tmp.equals("0"));
        }
    }
}
