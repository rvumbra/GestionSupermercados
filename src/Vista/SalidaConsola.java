package Vista;

import Utils.Colores;

/**
 * Permite mostrar por consola los distintos menús de la aplicación y
 * permitir al usuario controlar de manera más intuitiva los
 * distintos supermercados y sus productos, así como el almacén.
 *
 * Cada interfaz es una cadena constante dentro de su respectivo
 * bloque region.
 */
public class SalidaConsola {

    //region Menu principal.
    public final static String MENU_PRINCIPAL = Colores.ANSI_CYAN+"""
            
            #############################
            ##      Menú principal     ##
            ##-------------------------##
            ##                         ##
            ## 1.- Almacén.            ##
            ##                         ##
            ## 2.- Supermercados.      ##
            ##                         ##
            ## 3.- Copia de seguridad. ##
            ##                         ##
            ##-------------------------##
            ## 0.- Salir del programa. ##
            ##-------------------------##
            #############################
            
            """;
    //endregion

    //region Menu almacén.
    public final static String MENU_ALMACEN = Colores.ANSI_CYAN+ """
            
            ###############################################
            ##                 ALMACÉN                   ##
            ##-------------------------------------------##
            ##                                           ##
            ## 1.- Añadir un nuevo producto al almacén.  ##
            ##                                           ##
            ## 2.- Editar un producto del almacén.       ##
            ##                                           ##
            ## 3.- Listar los productos del almacén.     ##
            ##                                           ##
            ## 4.- Eliminar un producto del almacén.     ##
            ##                                           ##
            ## 5.- Vaciar almacén.                       ##
            ##                                           ##
            ##-------------------------------------------##
            ## 0.- Volver al menú principal.             ##
            ##-------------------------------------------##
            ###############################################
            
            """;
    //endregion

    //region Menu editar producto
    public final static String MENU_ALMACEN_EDITAR = Colores.ANSI_CYAN+"""
            
            #############################
            ##     EDITAR PRODUCTO     ##
            ##-------------------------##
            ##                         ##
            ## 1.- Cambiar precio.     ##
            ##                         ##
            ## 2.- Cambiar cantidad.   ##
            ##                         ##
            ## 3.- Cambiar categoría.  ##
            ##                         ##
            ##-------------------------##
            ## 0.- Volver atras.       ##
            ##-------------------------##
            #############################
            
            """;
    //endregion

    //region Menu categoría de producto
    public final static String MENU_PRODUCTO_CATEGORIA = Colores.ANSI_CYAN +"""
            
            ###################################
            ##     Categoría                 ##
            ##-------------------------------##
            ##                               ##
            ## 1.- Carne.      7.- Conserva. ##
            ##                               ##
            ## 2.- Pescado.    8.- Hogar.    ##
            ##                               ##
            ## 3.- Verduras.   9.- Limpieza. ##
            ##                               ##
            ## 4.- Lacteos.    10.- Higiene. ##
            ##                               ##
            ## 5.- Congelados. 11.- Varios.  ##
            ##                               ##
            ## 6.- Enlatados.                ##
            ##                               ##
            ###################################
            
            """;
    //endregion

    //region Menu supermercados.
    public final static String MENU_SUPERMERCADOS = Colores.ANSI_CYAN+ """
            
            ################################################
            ##                SUPERMERCADOS               ##
            ##--------------------------------------------##
            ##                                            ##
            ## 1.- Añadir un nuevo supermercado.          ##
            ##                                            ##
            ## 2.- Editar un supermercado.                ##
            ##                                            ##
            ## 3.- Listar los supermercados existentes.   ##
            ##                                            ##
            ## 4.- Eliminar un supermercado.              ##
            ##                                            ##
            ## 5.- Vaciar lista de supermercados.         ##
            ##                                            ##
            ##--------------------------------------------##
            ## 0.- Volver al menú principal.              ##
            ##--------------------------------------------##
            ################################################
            
            """;
    //endregion

    //region Menu editar supermercados.
    public final static String MENU_SUPERMERCADO_EDITAR = Colores.ANSI_GREEN+"\n"+"""
            
            #####################################################
            ##-------------------------------------------------##
            ##               EDITAR SUPERMERCADO               ##
            ##-------------------------------------------------##
            ##                                                 ##
            ## 1.- Cambiar nombre del supermercado.            ##
            ##                                                 ##
            ## 2.- Añadir producto al supermercado.            ##
            ##                                                 ##
            ## 3.- Editar producto del supermercado.           ##
            ##                                                 ##
            ## 4.- Listar los productos del supermercado.      ##
            ##                                                 ##
            ## 5.- Quitar producto de un supermercado.         ##
            ##                                                 ##
            ## 6.- Vaciar lista de productos del supermercado. ##
            ##                                                 ##
            ##-------------------------------------------------##
            ## 0.- Volver atrás.                               ##
            ##-------------------------------------------------##
            #####################################################
            
            """+"\n+";
    //endregion

    //region Encabezado listar almacen.
    public final static String LISTAR_ALMACEN = Colores.ANSI_YELLOW+"""
            -----------------------------------------------------------------
            ----------"""+
            Colores.ANSI_WHITE+"Lista de productos en el almacén existentes."+Colores.ANSI_YELLOW+
            """
            -----------
            -----------------------------------------------------------------""";
    //endregion

    //region Encabezado listar supermercados.
    public final static String LISTAR_SUPERMERCADOS = Colores.ANSI_YELLOW+"""
            -----------------------------------------
            ---"""+
            Colores.ANSI_WHITE+"Lista de supermercados existentes:"+Colores.ANSI_YELLOW+
            """
            ---
            -----------------------------------------""";
    //endregion

    //region Encabezado listar productos de un supermercado.
    public final static String LISTAR_SUPERMERCADOS_PRODUCTOS = Colores.ANSI_YELLOW+"""
            -----------------------------------------------------------------
            --"""+
            Colores.ANSI_WHITE+"Lista de productos existentes  en el supermercado."+Colores.ANSI_YELLOW+
            """
            --
            -----------------------------------------------------------------""";
    //endregion

    //region Menu copia de seguridad.
    public final static String MENU_COPIASEGURIDAD = Colores.ANSI_CYAN+ """
            
            ############################################################
            ##                   COPIA DE SEGURIDAD                   ##
            ##--------------------------------------------------------##
            ##                                                        ##
            ## 1.- Generar datos de prueba del almacén.               ##
            ##                                                        ##
            ## 2.- Generar datos de prueba de supermercados.          ##
            ##                                                        ##
            ## 3.- Actualizar almacén de copia existente.             ##
            ##                                                        ##
            ## 4.- Actualizar un supermercado de copia existente.     ##
            ##                                                        ##
            ## 5.- Crear copia de seguridad del almacén.              ##
            ##                                                        ##
            ## 6.- Crear copia de seguridad de un supermercado.       ##
            ##                                                        ##
            ##--------------------------------------------------------##
            ## 0.- Volver al menú principal.                          ##
            ##--------------------------------------------------------##
            ############################################################
            
            """;
    //endregion














}
