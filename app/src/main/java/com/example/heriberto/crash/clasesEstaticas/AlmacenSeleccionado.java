package com.example.heriberto.crash.clasesEstaticas;

/**
 * Created by heriberto on 9/05/17.
 */

public  class AlmacenSeleccionado {

    private static String id_almacenSeleccionado;

    public static String getId_almacenSeleccionado() {
        return id_almacenSeleccionado;
    }

    public static void setId_almacenSeleccionado(String id_almacenSeleccionado) {
        AlmacenSeleccionado.id_almacenSeleccionado = id_almacenSeleccionado;
    }
}
