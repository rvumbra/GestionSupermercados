package Logica;

import Modelo.Repositorio.AlmacenRepository;
import Modelo.Repositorio.SupermercadoRepository;
import Modelo.pojo.Producto;
import Modelo.pojo.Supermercado;
import Utils.misStrings;
import Utils.Colores;
import Vista.SalidaConsola;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Gestiona un almacen que vende productos a varios supermercados, cada uno con su respectiva lista de productos.
 *
 * Esta gestión permite realizar operaciones CRUD sobre cada supermercado y sus productos, así como del almacén.
 *
 * Además de permitir realizar y/o restaurar copias de seguridad.
 */
public class Main {

    public static void main(String[] args) {
        HashMap<String, Supermercado> listaSupermercados = SupermercadoRepository.getInstance().getListaSupermercados();
        HashMap<String, Producto> almacen = AlmacenRepository.getInstance().getProductos();

        Scanner sc = new Scanner(System.in);
        String tmp;

        do{

            System.out.println(SalidaConsola.MENU_PRINCIPAL);

            System.out.print(misStrings.MENU_OPCION_INTRODUCIR+Colores.ANSI_YELLOW);
            tmp = sc.next();

            switch (tmp){
                case "1"->{
                    System.out.println(misStrings.MENU_OPCION_SELECCIONADA+"almacén.");
                    ControlarMenus.menuAlmacen(almacen, sc);
                }
                case "2"->{
                    System.out.println(misStrings.MENU_OPCION_SELECCIONADA+"supermercados.");
                    ControlarMenus.menuSupermercados(listaSupermercados,sc);
                }
                case "3"->{
                    System.out.println(misStrings.MENU_OPCION_SELECCIONADA+"copia de seguridad.");
                    ControlarMenus.menuCopiaSeguridad(almacen, listaSupermercados, sc);
                }
                case "0"-> System.out.println(Colores.ANSI_RED+ misStrings.MENU_SALIR);
                default -> System.err.println(misStrings.ERR_OPCION_INVALIDA);
            }
        }while (!tmp.equals("0"));
    }
}
