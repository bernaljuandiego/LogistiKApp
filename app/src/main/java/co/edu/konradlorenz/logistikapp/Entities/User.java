package co.edu.konradlorenz.logistikapp.Entities;

import android.net.Uri;

public class User {

    private String uid;
    private String nombre;
    private String correo;
    private String fotoPerfil;
    private String tipoUsuario;

    public User() {
    }

    public User(String uid, String nombre, String correo, String fotoPerfil, String tipoUsuario) {
        this.uid = uid;
        this.nombre = nombre;
        this.correo = correo;
        this.fotoPerfil = fotoPerfil;
        this.tipoUsuario = tipoUsuario;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getFotoPerfil() {
        return fotoPerfil;
    }

    public void setFotoPerfil(String fotoPerfil) {
        this.fotoPerfil = fotoPerfil;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }
}