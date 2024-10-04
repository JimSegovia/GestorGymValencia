package ggv.gestorgymvalencia;

public class Cliente {
    private String nombres;
    private String apellidos;
    private int DNI;

    public Cliente(){} // Constructor vacio

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
}
}
