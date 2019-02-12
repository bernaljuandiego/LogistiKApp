package co.edu.konradlorenz.logistikapp.Entities;

import java.util.ArrayList;

public class Nivel {
    private String nombre;
    private ArrayList<Integer> cajas;
    private String descripcion;

    public Nivel() {
    }

    public Nivel(String nombre, ArrayList<Integer> cajas, String descripcion) {
        this.nombre = nombre;
        this.cajas = cajas;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Integer> getCajas() {
        return cajas;
    }

    public void setCajas(ArrayList<Integer> cajas) {
        this.cajas = cajas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
