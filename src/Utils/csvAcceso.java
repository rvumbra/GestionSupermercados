package Utils;

import Modelo.pojo.Producto;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Esta clase abre un flujo temporal para leer o extraer información de un csv.
 */
public class csvAcceso {

    /**
     * Lee los datos de un csv y devuelve dichos datos.
     *
     * @param archivo donde se encuentra el csv que se va a leer.
     * @return List<List<String>> con la información del csv.
     */
    public static List<List<String>> lectorCSV(File archivo){
        List<List<String>> datos = new ArrayList<>();
        String registro;
        String[] datosRegistro;
        List<String> datosTmp;

        try{
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            while ((registro = br.readLine())!=null){
                datosRegistro = registro.split(",");
                datosTmp = new ArrayList<>();
                for (String s: datosRegistro){
                    datosTmp.add(s);
                }
                datos.add(datosTmp);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al leer el archivo csv.");
        }

        return datos;
    }

    /**
     * Permite escribir cualquier cosa en un csv, ya que este método únicamente abre
     * el flujo para poder escribir en el archivo.
     *
     * Ésto se hará porque los flujos quedan abiertos, y hay que cerrarlos una vez
     * se termine de escribir en el archivo para evitar la pérdida de información.
     *
     * @param archivo donde se va a escribir.
     * @return List<Object> con 2 posiciones:
     *      -[0]->FileWriter con el archivo.
     *      -[1]->PrintWriter para escribir en dicho archivo.
     */
    public static List<Object> escritorCSV(File archivo){
        List<Object> lista = new ArrayList<>();
        FileWriter fichero;
        PrintWriter pw;

        try{
            fichero = new FileWriter(archivo);
            pw = new PrintWriter(fichero);
            lista.add(0, fichero);
            lista.add(1, pw);
            return lista;

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error, al abrir el flujo en el csv para escribir.");
            return null;
        }
    }
}
