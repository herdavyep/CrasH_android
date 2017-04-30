package com.example.heriberto.crash.clases;

/**
 * Created by heriberto on 11/04/17.
 */

public class Almacenes {

    private int id_almacen;
    private String nombre;
    private String direccion;
    private String telefono;
    private String ciudad;
    private int imagenAlmacen;

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Almacenes(String nombre, String direccion, String telefono, String ciudad, int imagenAlmacen) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.imagenAlmacen = imagenAlmacen;
    }

    public int getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(int id_almacen) {
        this.id_almacen = id_almacen;
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

    public int getImagenAlmacen() {
        return imagenAlmacen;
    }

    public void setImagenAlmacen(int imagenAlmacen) {
        this.imagenAlmacen = imagenAlmacen;
    }
}
