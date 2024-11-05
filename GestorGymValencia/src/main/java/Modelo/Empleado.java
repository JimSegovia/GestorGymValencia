package Modelo;

public class Empleado extends Persona{
    private String correoElectronico;
    private String rol;
    private int ID_Empleado;
    
    public Empleado(String nombres, String apellidos, String DNI, String correoElectronico, String rol, int ID_Empleado){
        super(nombres, apellidos, DNI);
        this.ID_Empleado = ID_Empleado;
        this.correoElectronico = correoElectronico;
        this.rol = rol;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public int getID_Empleado() {
        return ID_Empleado;
    }

    public void setID_Empleado(int ID_Empleado) {
        this.ID_Empleado = ID_Empleado;
    }
}
