package co.edu.konradlorenz.logistikapp.Entities;

import java.util.ArrayList;
import java.util.List;

public class Nivel {
    private String nombre;
    private ArrayList<Integer> cajas;
    private String descripcion;
    private String creador;
    private String fecha;
    private List<Registro> registros;

    public Nivel(String nombre, ArrayList<Integer> cajas, String descripcion, String creador, String fecha) {
        this.nombre = nombre;
        this.registros = new ArrayList<>();
        this.cajas = cajas;
        this.descripcion = descripcion;
        this.creador = creador;
        this.fecha = fecha;
    }

    public Nivel() {
        this.registros = new ArrayList<>();
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

    public String getCreador() {
        return creador;
    }

    public void setCreador(String creador) {
        this.creador = creador;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Registro> getRegistros() {
        return registros;
    }

    public void setRegistros(List<Registro> registros) {
        this.registros = registros;
    }
}
