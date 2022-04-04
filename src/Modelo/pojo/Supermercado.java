package Modelo.pojo;

import java.util.HashMap;

/**
 * Tipo de dato Supermercado, representa cada supermercado que se va a gestionar.
 */
public class Supermercado {
    private static final String TAG = "supermercado -> ";
    private String nombre;
    private HashMap<String, Producto> productos;

    public Supermercado(String SupermercadoVacio){}

    public Supermercado(String nombre, HashMap<String, Producto> productos) {
        this.nombre = nombre;
        this.productos = productos;
    }

    public static String getTag() {
        return TAG;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HashMap<String, Producto> getProductos() {
        return productos;
    }

    public void setProductos(HashMap<String, Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Supermercado{" +
                "nombre='" + nombre + '\'' +
                ", productos=" + productos +
                '}';
    }
}
