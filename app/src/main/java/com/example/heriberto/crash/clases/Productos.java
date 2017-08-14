package com.example.heriberto.crash.clases;

/**
 * Created by heriberto on 11/04/17.
 */

public class Productos {

    private String id_almacen;//no va ir, va es id promocion
    private String id_producto;
    private String id_promocion;
    private String nombre;
    private String unidadesxcliente;
    private String productos_disponibles;
    private String presentacion;
    private String porcentaje_descuento;
    //private int imagenProducto;
    private String imagen;
    private String precio;
    private boolean estado;



    public Productos() {
    }

    public Productos(String nombre, String precio, String vencimiento_oferta, String productos_disponibles, String presentacion, String porcentaje_descuento, String id_almacen, String imagen) {
        this.nombre = nombre;
        this.precio = precio;
        this.unidadesxcliente = vencimiento_oferta;
        this.productos_disponibles = productos_disponibles;
        this.presentacion = presentacion;
        this.porcentaje_descuento = porcentaje_descuento;
        this.id_almacen = id_almacen;
        this.imagen = imagen;
    }

    public Productos(String nombre, String precio, String vencimiento_oferta, String productos_disponibles, String presentacion, String porcentaje_descuento /*, int imagenProducto*/) {
        this.nombre = nombre;
        this.unidadesxcliente = vencimiento_oferta;
        this.productos_disponibles = productos_disponibles;
        this.presentacion = presentacion;
        this.porcentaje_descuento = porcentaje_descuento;
        //this.imagenProducto = imagenProducto;
        this.precio = precio;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(String id_almacen) {
        this.id_almacen = id_almacen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUnidadesxcliente() {
        return unidadesxcliente;
    }

    public void setUnidadesxcliente(String unidadesxcliente) {
        this.unidadesxcliente = unidadesxcliente;
    }

    public String getProductos_disponibles() {
        return productos_disponibles;
    }

    public void setProductos_disponibles(String productos_disponibles) {
        this.productos_disponibles = productos_disponibles;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getPorcentaje_descuento() {
        return porcentaje_descuento;
    }

    public void setPorcentaje_descuento(String porcentaje_descuento) {
        this.porcentaje_descuento = porcentaje_descuento;
    }

    /*public int getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(int imagenProducto) {
        this.imagenProducto = imagenProducto;
    }*/

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getId_promocion() {
        return id_promocion;
    }

    public void setId_promocion(String id_promocion) {
        this.id_promocion = id_promocion;
    }
}
