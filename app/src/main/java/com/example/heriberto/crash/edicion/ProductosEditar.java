package com.example.heriberto.crash.edicion;

import com.example.heriberto.crash.clases.Productos;

/**
 * Created by heriberto on 11/04/17.
 */

public class ProductosEditar {

    private static String id_almacen;
    private static String id_producto;
    private static String nombre;
    private static String unidxcliente;
    private static String productos_disponibles;
    private static String presentacion;
    private static String porcentaje_descuento;
    //private int imagenProducto;
    private static String imagen;
    private static String precio;
    private static boolean estado;

    public static void ProductosEditar(Productos producto){

        setNombre(producto.getNombre());
        setPrecio(producto.getPrecio());
        setPorcentaje_descuento(producto.getPorcentaje_descuento());
        setImagen(producto.getImagen());
        setPresentacion(producto.getPresentacion());
        setProductos_disponibles(producto.getProductos_disponibles());
        setId_almacen(producto.getId_almacen());
        setUnidxcliente(producto.getUnidadesxcliente());


    }

    public static String getId_producto() {
        return id_producto;
    }

    public static void setId_producto(String mid_producto) {
        id_producto = mid_producto;
    }

    public static String getPrecio() {
        return precio;
    }

    public static void setPrecio(String mprecio) {
        precio = mprecio;
    }

    public static String getId_almacen() {
        return id_almacen;
    }

    public static void setId_almacen(String mid_almacen) {
        id_almacen = mid_almacen;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String mnombre) {
        nombre = mnombre;
    }

    public static String getUnidxcliente() {
        return unidxcliente;
    }

    public static void setUnidxcliente(String mvencimiento_oferta) {
        unidxcliente = mvencimiento_oferta;
    }

    public static String getProductos_disponibles() {
        return productos_disponibles;
    }

    public static void setProductos_disponibles(String mproductos_disponibles) {
        productos_disponibles = mproductos_disponibles;
    }

    public static String getPresentacion() {
        return presentacion;
    }

    public static void setPresentacion(String mpresentacion) {
        presentacion = mpresentacion;
    }

    public static String getPorcentaje_descuento() {
        return porcentaje_descuento;
    }

    public static void setPorcentaje_descuento(String mporcentaje_descuento) {
        porcentaje_descuento = mporcentaje_descuento;
    }

    public static boolean isEstado() {
        return estado;
    }

    public static void setEstado(boolean mestado) { estado = mestado;
    }

    public static String getImagen() {
        return imagen;
    }

    public static void setImagen(String mimagen) {
        imagen = mimagen;
    }
}
