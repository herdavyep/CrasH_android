package com.example.heriberto.crash.modelos;

/**
 * Created by heriberto on 5/04/17.
 */

public class Usuario {

    private int id_usuario;
    private String nombre;
    private String contraseña;
    private boolean es_cliente;
    private boolean es_proveedor;
    private boolean es_admin;

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean isEs_cliente() {
        return es_cliente;
    }

    public void setEs_cliente(boolean es_cliente) {
        this.es_cliente = es_cliente;
    }

    public boolean isEs_proveedor() {
        return es_proveedor;
    }

    public void setEs_proveedor(boolean es_proveedor) {
        this.es_proveedor = es_proveedor;
    }

    public boolean isEs_admin() {
        return es_admin;
    }

    public void setEs_admin(boolean es_admin) {
        this.es_admin = es_admin;
    }
}
