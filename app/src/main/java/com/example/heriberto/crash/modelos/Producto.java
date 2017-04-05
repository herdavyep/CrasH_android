package com.example.heriberto.crash.modelos;

/**
 * Created by heriberto on 5/04/17.
 */

public class Producto {

    private int id_producto;
    private String nombre;
    private float precio;
    private int vencimiento_oferta;
    private int productos_disponibles;
    private String presentacion;
    private String porcentaje_descuento;
    private boolean estado;


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

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getVencimiento_oferta() {
        return vencimiento_oferta;
    }

    public void setVencimiento_oferta(int vencimiento_oferta) {
        this.vencimiento_oferta = vencimiento_oferta;
    }

    public int getProductos_disponibles() {
        return productos_disponibles;
    }

    public void setProductos_disponibles(int productos_disponibles) {
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

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
