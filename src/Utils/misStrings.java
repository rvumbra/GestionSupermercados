package Utils;

import java.io.File;

/**
 * Esta clase contiene cadenas de texto constantes utilizadas en la aplicación.
 *
 * Cada bloque región engloba unas cadenas de texto concretas para un uso específico.
 *
 *
 * !!!!!!!!!!!!      DON'T REPEAT YOURSELF      !!!!!!!!!!!!!!!!!
 */
public class misStrings {

    //region Errores
    public final static String ERR_OPCION_INVALIDA = "\nError, la opción introducida no es válida.";
    public final static String ERR_FLOAT_FORMATO = "\nError, el formato no es válido (Si tiene decimales será 0.0, sino 0).";
    public final static String ERR_FLOAT_NEGATIVO = "\nError, el valor no puede ser negativo.";
    public final static String ERR_LISTA_VACIA = "\n\n\t\t\t\t!!!No hay datos para mostrar!!!";
    public final static String ERR_PRODUCTO_YAEXISTE = """

                    Error, ya existe un producto con ese nombre.
                    Listar los productos disponibles para más información.""";
    public final static String ERR_PRODUCTO_NOEXISTE = """

                    Error, este producto no existe.
                    Listar los productos existentes para más información.""";
    public final static String ERR_SUPERMERCADO_YAEXISTE = """
                    
                    Error, ya existe un supermercado con este nombre.
                    Listar los supermercados existentes para más información.""";
    public final static String ERR_SUPERMERCADO_NOEXISTE = """

                    Error, este supermercado no existe.
                    Listar los supermercados existentes para más información.""";
    public final static String ERR_SUPERMERCADO_NOPRODUCTOS = "\nError, un supermercado debe tener al menos un producto.";
    public final static String ERR_SUPERMERCADO_ESCRIBIRCSV = "\nError, no se ha podido crear la copia de seguridad del supermercado.";
    public final static String ERR_ALMACEN_ESCRIBIRCSV = "\nError, no se ha podido crear la copia de seguridad del almacén.";
    //endregion

    //region Menus
    public final static String MENU_SALIR  = "\nSaliendo del programa...";
    public final static String MENU_VOLVER_PRINCIPAL = "\nVolviendo al menú principal...";
    public final static String MENU_VOLVER_ATRAS = "\nVolviendo atras...";
    public final static String MENU_OPCION_INTRODUCIR = "\nIntroduce una opción para continuar: ";
    public final static String MENU_OPCION_SELECCIONADA = "Se ha seleccionado la opción ";
    //endregion

    //region Listas
    public final static String LISTA_VACIAR = "\n!!!Lista vaciada correctamente!!!";
    public final static String LISTA_VACIAR_CONTINUAR = "¿Está seguro de que quiere vaciar la lista? (s/cualquier caracter): ";
    //endregion

    //region Producto
    public final static String PRODUCTO_INTRODUCIR_NOMBRE = "\nIntroduce el nombre del producto: ";
    public final static String PRODUCTO_INTRODUCIR_PRECIO = "\nIntroduce el precio del producto (Si tiene decimales será 0.0): ";
    public final static String PRODUCTO_INTRODUCIR_CANTIDAD = "\nIntroduce la cantidad del producto (Si tiene decimales será 0.0): ";
    public final static String PRODUCTO_ADD = "\n!!!Producto añadido correctamente!!!";
    public final static String PRODUCTO_EDITAR = "\n!!!Producto editado correctamente!!!";
    public final static String PRODUCTO_ELIMINAR = "\n!!!Producto eliminado correctamente!!!";
    //endregion

    //region Supermercado
    public final static String SUPERMERCADO_INTRODUCIR_NOMBRE = "\nIntroduce el nombre del supermercado: ";
    public final static String SUPERMERCADO_INTRODUCIR_NUEVO = "\nIntroduce el nuevo nombre del supermercado: ";
    public final static String SUPERMERCADO_ADD = "\n!!!Supermercado añadido correctamente!!!";
    public final static String SUPERMERCADO_ELIMINAR = "\n!!!Supermercado eliminado correctamente!!!";
    //endregion

    //region Copia de seguridad
    public final static String SEGURIDAD_COPIA_DATOSPRUEBA = "!!!Datos de prueba insertados con éxito!!!";
    public final static String SEGURIDAD_COPIA_ALMACEN =
            System.getProperty("user.dir")+ File.separator+"src"+File.separator+"CopiasDeSeguridad"+File.separator+"Almacen.csv";
    public final static String SEGURIDAD_COPIA_ALMACEN_ACTUALIZACION = "!!!El almacén ha sido actualizado correctamente.!!!";
    public final static String SEGURIDAD_COPIA_ALMACEN_CREACION = "!!!La copia del almacén ha sido creada correctamente.!!!";
    public final static String SEGURIDAD_COPIA_SUPERMERCADO =
            System.getProperty("user.dir")+ File.separator+"src"+File.separator+"CopiasDeSeguridad"+File.separator+"Supermercado.csv";
    public final static String SEGURIDAD_COPIA_SUPERMERCADO_ACTUALIZACION = "!!!El supermercado ha sido actualizado correctamente.!!!";
    public final static String SEGURIDAD_COPIA_SUPERMERCADO_CREACION = "!!!La copia del supermercado ha sido creada correctamente.!!!";
    //endregion
}
