package com.example.heriberto.crash.clases;

/**
 * Created by heriberto on 11/04/17.
 */

public class Categorias {

    private int id_categoria;
    private String nombre;

    public Categorias(String nombre) {
        this.nombre = nombre;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
