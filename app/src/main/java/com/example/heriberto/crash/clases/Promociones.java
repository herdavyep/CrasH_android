package com.example.heriberto.crash.clases;

/**
 * Created by heriberto on 11/04/17.
 */

public class Promociones {

    private int id_promocion;
    private String id_almacen;
    private String imagen;
    private String nombre;

    public Promociones() {
    }

    public Promociones(int id_promocion, String id_almacen, String imagen, String nombre) {
        this.id_promocion = id_promocion;
        this.id_almacen = id_almacen;
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public Promociones(String nombre) {
        this.nombre = nombre;
    }

    public int getId_promocion() {
        return id_promocion;
    }

    public void setId_promocion(int id_promocion) {
        this.id_promocion = id_promocion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(String id_almacen) {
        this.id_almacen = id_almacen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
