package Modelo;

public class Persona {
    private String nombres;
    private String apellidos;
    private String DNI;
    
    Persona(String nombres, String apellidos, String DNI){
        this.nombres = nombres;
        this.apellidos = apellidos;
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

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }   
}
