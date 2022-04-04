package Logica;

import Modelo.Repositorio.AlmacenRepository;
import Modelo.Repositorio.SupermercadoRepository;
import Modelo.dao.ProductoDAO;
import Modelo.dao.SupermercadoDAO;
import Modelo.pojo.Producto;
import Modelo.pojo.Supermercado;
import Utils.Colores;
import Utils.misStrings;
import Vista.SalidaConsola;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

/**
 * Esta clase controla cada una de las opciones del menú principal.
 */
public class ControlarMenus {

    /**
     * Este método gestiona el almacén completo.
     *
     * @param almacen HashMap<String, Producto> que se va a gestionar.
     * @param sc Scanner para almacenar la opción del buffer.
     */
    public static void menuAlmacen(HashMap<String, Producto> almacen, Scanner sc){
        String tmp;

        do {
            System.out.println(SalidaConsola.MENU_ALMACEN);
            System.out.print(misStrings.MENU_OPCION_INTRODUCIR + Colores.ANSI_YELLOW);
            tmp = sc.next();

            switch (tmp){
                case "1"->{
                    System.out.println(misStrings.MENU_OPCION_SELECCIONADA+"añadir un nuevo producto al almacén.");
                    ProductoDAO.add(almacen, sc);
                }
                case "2"->{
                    System.out.println(misStrings.MENU_OPCION_SELECCIONADA+"editar un producto del almacén.");
                    ProductoDAO.editar(almacen, sc);
                }
                case "3"->{
                    System.out.println(misStrings.MENU_OPCION_SELECCIONADA+"listar los productos del almacén.");
                    System.out.println(SalidaConsola.LISTAR_ALMACEN);
                    ProductoDAO.listar(almacen);
                }
                case "4"->{
                    System.out.println(misStrings.MENU_OPCION_SELECCIONADA+"eliminar un producto del almacén.");
                    ProductoDAO.eliminar(almacen, sc);
                }
                case "5"->{
                    System.out.println(misStrings.MENU_OPCION_SELECCIONADA+"vaciar el almacén.");
                    System.out.print(misStrings.LISTA_VACIAR_CONTINUAR);
                    tmp = sc.next();
                    if (tmp.toLowerCase(Locale.ROOT).equals("s"))
                        ProductoDAO.vaciarLista(almacen);
                }
                case "0"-> System.out.println(Colores.ANSI_RED+ misStrings.MENU_VOLVER_PRINCIPAL);
                default -> System.err.println(misStrings.ERR_OPCION_INVALIDA);
            }
        }while (!tmp.equals("0"));
    }

    /**
     * Este método gestiona los supermercados de manera completa.
     *
     * @param listaSupermercados HashMap<String, Supermercado> que se va a gestionar.
     * @param sc Scanner para almacenar la opción del buffer.
     */
    public static void menuSupermercados(HashMap<String, Supermercado> listaSupermercados, Scanner sc) {

        String tmp;
        do{
            System.out.println(SalidaConsola.MENU_SUPERMERCADOS);
            System.out.print(misStrings.MENU_OPCION_INTRODUCIR+Colores.ANSI_YELLOW);
            tmp = sc.next();

            switch (tmp){
                case "1"->{
                    System.out.println(misStrings.MENU_OPCION_SELECCIONADA+"añadir un nuevo supermercado.");
                    SupermercadoDAO.add(listaSupermercados, sc);
                }
                case "2"->{
                    System.out.println(misStrings.MENU_OPCION_SELECCIONADA+"editar un supermercado.");
                    SupermercadoDAO.editar(listaSupermercados, sc);
                }
                case "3"->{
                    System.out.println(misStrings.MENU_OPCION_SELECCIONADA+"listar supermercados existentes.");
                    SupermercadoDAO.listar(listaSupermercados);
                }
                case "4"->{
                    System.out.println(misStrings.MENU_OPCION_SELECCIONADA+"eliminar un supermercado.");
                    SupermercadoDAO.eliminar(listaSupermercados, sc);
                }
                case "5"->{
                    System.out.println(misStrings.MENU_OPCION_SELECCIONADA+"vaciar la lista de supermercados.");
                    System.out.print(misStrings.LISTA_VACIAR_CONTINUAR);
                    tmp = sc.next();
                    if (tmp.toLowerCase(Locale.ROOT).equals("s"))
                        SupermercadoDAO.vaciarLista(listaSupermercados);
                }
                case "0"-> System.out.println(Colores.ANSI_RED+ misStrings.MENU_VOLVER_PRINCIPAL);
                default -> System.err.println(misStrings.ERR_OPCION_INVALIDA);
            }

        }while (!tmp.equals("0"));
    }

    /**
     * Este método muestra un menú para gestionar la restauración
     * o creación de una copias de seguridad tanto del almacén
     * como de los supermercados.
     *
     * @param almacen HashMap<String, Producto>
     * @param listaSupermercados HashMap<String, Supermercado>
     * @param sc Scanner para almacenar la opción del buffer.
     */
    public static void menuCopiaSeguridad(HashMap<String, Producto> almacen, HashMap<String, Supermercado> listaSupermercados, Scanner sc) {

        String tmp;
        do{
            System.out.println(SalidaConsola.MENU_COPIASEGURIDAD);
            System.out.print(misStrings.MENU_OPCION_INTRODUCIR+ Colores.ANSI_YELLOW);
            tmp = sc.next();

            switch (tmp){
                case "1"->{
                    System.out.println(misStrings.MENU_OPCION_SELECCIONADA+"generar datos de prueba del almacén.");
                    AlmacenRepository.getInstance().valoresDePrueba();
                    almacen = AlmacenRepository.getInstance().getProductos();
                }
                case "2"->{
                    System.out.println(misStrings.MENU_OPCION_SELECCIONADA+"generar datos de prueba de supermercacados.");
                    SupermercadoRepository.getInstance().valoresDePrueba();
                    listaSupermercados = SupermercadoRepository.getInstance().getListaSupermercados();
                }
                case "3"->{
                    System.out.println(misStrings.MENU_OPCION_SELECCIONADA+"actualizar almacén de copia existente.");
                    AlmacenRepository.getInstance().actualizarCopiaCSV(new File(misStrings.SEGURIDAD_COPIA_ALMACEN));
                    almacen = AlmacenRepository.getInstance().getProductos();
                }
                case "4"->{
                    System.out.println(misStrings.MENU_OPCION_SELECCIONADA+"actualizar un supermercado de copia existente.");
                    SupermercadoRepository.getInstance().actualizarCopiaCSV(new File(misStrings.SEGURIDAD_COPIA_SUPERMERCADO), sc);
                }
                case "5"->{
                    System.out.println(misStrings.MENU_OPCION_SELECCIONADA+"crear copia de seguridad del almacén.");
                    AlmacenRepository.getInstance().crearCopiaCSV(almacen, new File(misStrings.SEGURIDAD_COPIA_ALMACEN));
                }
                case "6"->{
                    System.out.println(misStrings.MENU_OPCION_SELECCIONADA+"crear copia de seguridad de un supermercado.");
                    SupermercadoRepository.getInstance().crearCopiaCSV(listaSupermercados, new File(misStrings.SEGURIDAD_COPIA_SUPERMERCADO), sc);
                }
                case "0"-> System.out.println(Colores.ANSI_RED+ misStrings.MENU_VOLVER_PRINCIPAL);
                default -> System.err.println(misStrings.ERR_OPCION_INVALIDA);
            }
        }while (!tmp.equals("0"));
    }
}
