package Modelo;

public class Persona {
    private String DNI;
    private String nombres;
    private String apellidos;
    
    Persona(String DNI, String nombres, String apellidos) {
        this.DNI = DNI;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

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
}
