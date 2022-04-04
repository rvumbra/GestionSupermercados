package Utils;

/**
 * Esta clase personalizada contiene constantes para asignar diferentes colores a la salida por consola.
 *
 * Para ello se debe sumar una de estas constantes al principio del System.out.print que usemos.
 *
 * Si se quiere cambiar el color después de mostrar algo concreto, basta con sumar una de estas constantes
 *      al final del System.out.print que usemos.
 *
 * Si se quiere reiniciar el color, la constante a utilizar debe ser ANSI_RESET.
 */
public class Colores {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
}
