package com.example.heriberto.crash.clases;

/**
 * Created by heriberto on 11/04/17.
 */

public class Almacenes {

    private String id_almacen;
    private String nombre;
    private String direccion;
    private String telefono;
    private String ciudad;
    private String imagenAlmacen;

    public Almacenes() {
    }

    public Almacenes(String nombre, String direccion, String telefono, String ciudad, String imagenAlmacen) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.imagenAlmacen = imagenAlmacen;
    }

    public String getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(String id_almacen) {
        this.id_almacen = id_almacen;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getImagenAlmacen() {
        return imagenAlmacen;
    }

    public void setImagenAlmacen(String imagenAlmacen) {
        this.imagenAlmacen = imagenAlmacen;
    }
}
