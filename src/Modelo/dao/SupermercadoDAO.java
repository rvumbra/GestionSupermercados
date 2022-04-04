package Modelo.dao;

import Modelo.pojo.Supermercado;
import Utils.Colores;
import Utils.misStrings;
import Vista.SalidaConsola;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Patrón DAO para la gestión del almacén.
 */
public class SupermercadoDAO {

    /**
     * Añade un supermercado al hashmap si su campo nombre no
     * coincide en las keys ya existentes del hashmap.
     *
     * @param lista HashMap<String, Supermercado> donde se añadirá.
     * @param sc Buffer de donde se leera el nombre del supermercado.
     */
    public static void add(HashMap<String, Supermercado> lista, Scanner sc){
        System.out.print(misStrings.SUPERMERCADO_INTRODUCIR_NOMBRE);
        String tmp = sc.next();

        if(lista.containsKey(Supermercado.getTag()+tmp))
            System.out.println(Colores.ANSI_RED + misStrings.ERR_SUPERMERCADO_YAEXISTE+Colores.ANSI_YELLOW);
        else{
            lista.put(Supermercado.getTag()+tmp, new Supermercado(tmp, null));
            System.out.println(misStrings.SUPERMERCADO_ADD);
            System.out.println(Colores.ANSI_RED + misStrings.ERR_SUPERMERCADO_NOPRODUCTOS+Colores.ANSI_YELLOW);
            ProductoDAO.add(new HashMap<>(), sc);
            System.out.println(misStrings.SUPERMERCADO_ADD);
        }
    }

    /**
     * Muestra un menú para la edición de un supermercado.
     *
     * @param listaSupermercados HashMap<String, Supermercado> de donde se editará un supermercado.
     * @param sc Scanner para leer desde teclado las opciones de edición.
     */
    public static void editar(HashMap<String, Supermercado> listaSupermercados, Scanner sc){
        String tmp;

        do{
            System.out.println(SalidaConsola.MENU_SUPERMERCADO_EDITAR);

            System.out.print(misStrings.MENU_OPCION_INTRODUCIR+Colores.ANSI_YELLOW);
            tmp = sc.next();

            switch (tmp){
                case "1"->{
                    System.out.println(misStrings.MENU_OPCION_SELECCIONADA+"cambiar nombre del supermercado.");
                    cambiarNombreSupermercado(listaSupermercados, sc);
                }
                case "2"->{
                    System.out.println(misStrings.MENU_OPCION_SELECCIONADA+"añadir producto al supermercado.");
                    addProducto(listaSupermercados, sc);
                }
                case "3"->{
                    System.out.println(misStrings.MENU_OPCION_SELECCIONADA+"editar producto del supermercado.");
                    editarProducto(listaSupermercados, sc);
                }
                case "4"->{
                    System.out.println(misStrings.MENU_OPCION_SELECCIONADA+"listar los producto del supermercado.");
                    listarProductos(listaSupermercados, sc);
                }
                case "5"->{
                    System.out.println(misStrings.MENU_OPCION_SELECCIONADA+"quitar producto del supermercado.");
                    eliminarProducto(listaSupermercados, sc);
                }
                case "6"->{
                    System.out.println(misStrings.MENU_OPCION_SELECCIONADA+"vaciar la lista de productos del supermercado.");
                    vaciarListaProductos(listaSupermercados, sc);
                }
                case "0"-> System.out.println(Colores.ANSI_RED+ misStrings.MENU_VOLVER_ATRAS);
                default -> System.err.println(misStrings.ERR_OPCION_INVALIDA);
            }
        }while (!tmp.equals("0"));
    }

    /**
     * Modifica el valor indicado de la lista.
     *
     * @param supermercados HashMap<String, Supermercado> de la que se modificará un supermercado.
     * @param sc Scanner para leer la entrada por teclado.
     */
    private static void cambiarNombreSupermercado(HashMap<String, Supermercado> supermercados, Scanner sc){
        String tmp;
        String nombre;

        System.out.print(misStrings.SUPERMERCADO_INTRODUCIR_NOMBRE);
        tmp = sc.next();
        if (!supermercados.containsKey(Supermercado.getTag()+tmp))
            System.err.println(Colores.ANSI_RED+ misStrings.ERR_SUPERMERCADO_NOEXISTE+Colores.ANSI_YELLOW);
        else{
            do{
                System.out.print(misStrings.SUPERMERCADO_INTRODUCIR_NUEVO);
                nombre = sc.next();
                supermercados.get(Supermercado.getTag()+tmp).setNombre(nombre);
            }while (supermercados.containsKey(Supermercado.getTag()+nombre));
        }
    }

    /**
     * Añade un producto al supermercado recibido.
     *
     * @param lista HashMap<String, Supermercado> donde se buscará si existe el supermercado.
     * @param sc Scanner para asignar al producto con los valores leidos.
     */
    private static void addProducto(HashMap<String, Supermercado> lista,Scanner sc){
        String tmp;

        System.out.print(misStrings.SUPERMERCADO_INTRODUCIR_NOMBRE);
        tmp = sc.next();

        if (!lista.containsKey(Supermercado.getTag()+tmp))
            System.out.println(Colores.ANSI_RED+ misStrings.ERR_SUPERMERCADO_NOEXISTE+Colores.ANSI_YELLOW);
        else
            ProductoDAO.add(lista.get(Supermercado.getTag()+tmp).getProductos(), sc);
    }

    /**
     * Añade un producto al supermercado recibido.
     *
     * @param lista HashMap<String, Supermercado> donde se buscará si existe el supermercado.
     * @param sc Scanner para asignar al producto con los valores leidos.
     */
    private static void editarProducto(HashMap<String, Supermercado> lista,Scanner sc){
        String tmp;

        System.out.print(misStrings.SUPERMERCADO_INTRODUCIR_NOMBRE);
        tmp = sc.next();

        if (!lista.containsKey(Supermercado.getTag()+tmp))
            System.out.println(Colores.ANSI_RED+ misStrings.ERR_SUPERMERCADO_NOEXISTE+Colores.ANSI_YELLOW);
        else
            ProductoDAO.editar(lista.get(Supermercado.getTag()+tmp).getProductos(), sc);
    }

    /**
     * Muestra por pantalla la lista de productos de un supermercado específico.
     *
     * @param lista HashMap<String, Supermercado> listaSupermercados donde se encuentra el supermercado.
     * @param sc Scanner para leer el nombre del supermercado desde teclado.
     */
    private static void listarProductos(HashMap<String, Supermercado> lista, Scanner sc){
        String tmp;

        System.out.print(misStrings.SUPERMERCADO_INTRODUCIR_NOMBRE);
        tmp = sc.next();

        if (!lista.containsKey(Supermercado.getTag()+tmp))
            System.out.println(Colores.ANSI_RED+ misStrings.ERR_SUPERMERCADO_NOEXISTE+Colores.ANSI_YELLOW);
        else
            System.out.println(SalidaConsola.LISTAR_SUPERMERCADOS_PRODUCTOS);
            ProductoDAO.listar(lista.get(Supermercado.getTag()+tmp).getProductos());
    }

    /**
     * Elimina un producto de un supermercado específico.
     *
     * @param lista HashMap<String, Supermercado> donde se buscará si existe el supermercado.
     * @param sc Scanner para buscar las coincidencias para borrar un producto de un supermercado concretos.
     */
    private static void eliminarProducto(HashMap<String, Supermercado> lista,Scanner sc){
        String tmp;

        System.out.print(misStrings.SUPERMERCADO_INTRODUCIR_NOMBRE);
        tmp = sc.next();

        if (!lista.containsKey(Supermercado.getTag()+tmp))
            System.out.println(Colores.ANSI_RED+ misStrings.ERR_SUPERMERCADO_NOEXISTE+Colores.ANSI_YELLOW);
        else
            ProductoDAO.eliminar(lista.get(Supermercado.getTag()+tmp).getProductos(), sc);
    }

    private static void vaciarListaProductos(HashMap<String, Supermercado> lista,Scanner sc){
        String tmp;

        System.out.print(misStrings.SUPERMERCADO_INTRODUCIR_NOMBRE);
        tmp = sc.next();

        if (!lista.containsKey(Supermercado.getTag()+tmp))
            System.out.println(Colores.ANSI_RED+misStrings.ERR_SUPERMERCADO_NOEXISTE+Colores.ANSI_YELLOW);
        else{
            ProductoDAO.vaciarLista(lista.get(Supermercado.getTag()+tmp).getProductos());
            System.out.println(misStrings.LISTA_VACIAR);
        }
    }

    /**
     * Muestra por pantalla la lista de supermercados recibida por parámetro si no está vacía.
     *
     * @param lista HashMap<String, Supermercado> que se va a listar.
     */
    public static void listar(HashMap<String, Supermercado> lista){

        System.out.println(SalidaConsola.LISTAR_SUPERMERCADOS);

        if(lista.isEmpty())
            System.out.println(Colores.ANSI_RED+ misStrings.ERR_LISTA_VACIA);
        else{
            for(Supermercado s:lista.values()){
                System.out.println("\t\t"+s.getNombre());
            }
        }
    }

    /**
     * Elimina un supermercado según el nombre introducido.
     * @param lista HashMap<String, Supermercado> de donde se quiere eliminar un valor.
     * @param sc String Nombre del supermercado que se quiere borrar.
     */
    public static void eliminar(HashMap<String, Supermercado> lista, Scanner sc){
        String tmp;

        System.out.print(misStrings.SUPERMERCADO_INTRODUCIR_NOMBRE);
        tmp = sc.next();

        if(!lista.containsKey(Supermercado.getTag()+tmp))
            System.err.println(Colores.ANSI_RED+ misStrings.ERR_SUPERMERCADO_NOEXISTE+Colores.ANSI_YELLOW);
        else{
            lista.remove(Supermercado.getTag()+tmp);
            System.out.println(misStrings.SUPERMERCADO_ELIMINAR);
        }
    }

    /**
     * Vacía la lista de supermercados recibida por parámetro.
     *
     * @param lista HashMap<String, Supermercado> que se va a vaciar.
     */
    public static void vaciarLista(HashMap<String, Supermercado> lista){
        lista.clear();
        System.out.println(Colores.ANSI_YELLOW+ misStrings.LISTA_VACIAR);
    }
}
