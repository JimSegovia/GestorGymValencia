package Modelo;

public class Carnet {
    private String fechaInicio;
    private String fechaFinal;
    private String tipoMembresia;
    
    Carnet(String fechaInicio, String fechaFinal, String tipoMembresia){
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.tipoMembresia = tipoMembresia;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getTipoMembresia() {
        return tipoMembresia;
    }

    public void setTipoMembresia(String tipoMembresia) {
        this.tipoMembresia = tipoMembresia;
    }
    
    public void mostrarEstado(){}
    
    public void renovarCarnet(){}
    
    public void mostrarDetalles(){}
}
