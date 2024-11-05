package Modelo;

public class Objeto {
    private String nomObjeto;
    private String estado;
    private int cantidad;
    
    Objeto(String nomObjeto, String estado, int cantidad){
        this.nomObjeto = nomObjeto;
        this.estado = estado;
        this.cantidad = cantidad;
    }

    public String getNomObjeto() {
        return nomObjeto;
    }

    public void setNomObjeto(String nomObjeto) {
        this.nomObjeto = nomObjeto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
