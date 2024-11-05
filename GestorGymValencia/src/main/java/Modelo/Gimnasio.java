package Modelo;

public class Gimnasio {
    private String nombre;
    private String direccion;
    private String estado;
    
    Gimnasio(String nombre, String direccion, String estado){
        this.nombre = nombre;
        this.direccion = direccion;
        this.estado = estado;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean disponibilidad(){
        return true;
    }
}
