package com.example.heriberto.crash.clasesEstaticas;

/**
 * Created by heriberto on 9/05/17.
 */

public  class AlmacenSeleccionado {

    private static String id_almacenSeleccionado;
    private static String precio;

    public static String getId_almacenSeleccionado() {
        return id_almacenSeleccionado;
    }

    public static void setId_almacenSeleccionado(String id_almacenSeleccionado) {
        AlmacenSeleccionado.id_almacenSeleccionado = id_almacenSeleccionado;
    }

    public static String getPrecio() {
        return precio;
    }

    public static void setPrecio(String precio) {
        AlmacenSeleccionado.precio = precio;
    }
}
