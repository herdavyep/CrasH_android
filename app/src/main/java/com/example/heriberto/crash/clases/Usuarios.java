package com.example.heriberto.crash.clases;

/**
 * Created by heriberto on 10/05/17.
 */

public class Usuarios {

    private String email;
    private String password;
    private String tipoUsuario;
    private String id_almacen;

    public Usuarios() {

    }

    public Usuarios(String email, String password, String tipoUsuario, String id_almacen) {
        this.email = email;
        this.password = password;
        this.tipoUsuario = tipoUsuario;
        this.id_almacen = id_almacen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getId_almacen() {
        return id_almacen;
    }

    public void setId_almacen(String id_almacen) {
        this.id_almacen = id_almacen;
    }
}
