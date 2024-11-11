package Modelo;

import java.util.Date;

public class Cliente extends Persona {
    private Date inicioMembresia;
    private Date finMembresia;
    private String tipoMembresia;
    
    public Cliente(String DNI, String nombres, String apellidos, Date inicioMembresia, Date finMembresia, String tipoMembresia) {
        super(DNI, nombres, apellidos);
        this.inicioMembresia = inicioMembresia;
        this.finMembresia = finMembresia;
        this.tipoMembresia = tipoMembresia;
    }

    public Date getInicioMembresia() {
        return inicioMembresia;
    }

    public void setInicioMembresia(Date inicioMembresia) {
        this.inicioMembresia = inicioMembresia;
    }

    public Date getFinMembresia() {
        return finMembresia;
    }

    public void setFinMembresia(Date finMembresia) {
        this.finMembresia = finMembresia;
    }

    public String getTipoMembresia() {
        return tipoMembresia;
    }

    public void setTipoMembresia(String tipoMembresia) {
        this.tipoMembresia = tipoMembresia;
    }
    
    
}

