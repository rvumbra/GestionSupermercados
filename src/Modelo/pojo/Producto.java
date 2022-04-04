package Modelo.pojo;

import Utils.Enumeraciones.CategoriaProducto;

/**
 * Tipo de dato Producto, representa cada producto comercializable, por lo que habrá instancias de
 * este tipo tanto en los tipos de dato Almacen y Supermercado.
 */
public class Producto {
    private static final String TAG = "producto -> ";
    private String nombre;
    private float precio;
    private float cantidad;
    private CategoriaProducto categoriaProducto;

    public Producto(String ProductoVacio){}

    public Producto(String nombre, float precio, float cantidad, CategoriaProducto categoriaProducto) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
        this.categoriaProducto = categoriaProducto;
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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public CategoriaProducto getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                ", categoriaProducto=" + categoriaProducto +
                '}';
    }
}
