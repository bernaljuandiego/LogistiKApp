package co.edu.konradlorenz.logistikapp.Entities;

public class Registro {

    private String distancia;
    private Usuario usuario;

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Registro(String distancia, Usuario usuario) {
        this.distancia = distancia;
        this.usuario = usuario;
    }

    public Registro() {
    }
}
