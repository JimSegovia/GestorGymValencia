package Modelo;

public class Cliente extends Persona{
    private int ID_Cliente;
    private Carnet carnet;
    
    Cliente(String nombres, String apellidos, String DNI, int ID_Cliente, Carnet carnet){
        super(nombres, apellidos, DNI);
        this.ID_Cliente = ID_Cliente;
        this.carnet = carnet;
    }

    public int getID_Cliente() {
        return ID_Cliente;
    }

    public void setID_Cliente(int ID_Cliente) {
        this.ID_Cliente = ID_Cliente;
    }

    public Carnet getCarnet() {
        return carnet;
    }

    public void setCarnet(Carnet carnet) {
        this.carnet = carnet;
    }
    
    public void crearCarnet(){}
}
