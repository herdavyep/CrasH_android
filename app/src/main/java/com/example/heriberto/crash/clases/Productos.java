package com.example.heriberto.crash.clases;

/**
 * Created by heriberto on 11/04/17.
 */

public class Productos {

    private int id_producto;
    private String nombre;
    private String precio;
    private String vencimiento_oferta;
    private String productos_disponibles;
    private String presentacion;
    private String porcentaje_descuento;
    private int imagenProducto;
    private boolean estado;

    public Productos(String nombre, String precio, String vencimiento_oferta, String productos_disponibles, String presentacion, String porcentaje_descuento, int imagenProducto) {
        this.nombre = nombre;
        this.precio = precio;
        this.vencimiento_oferta = vencimiento_oferta;
        this.productos_disponibles = productos_disponibles;
        this.presentacion = presentacion;
        this.porcentaje_descuento = porcentaje_descuento;
        this.imagenProducto = imagenProducto;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getVencimiento_oferta() {
        return vencimiento_oferta;
    }

    public void setVencimiento_oferta(String vencimiento_oferta) {
        this.vencimiento_oferta = vencimiento_oferta;
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

    public int getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(int imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
