package Controlador;

import Vista.FrameVista;

public class FrameControlador {

    private final FrameVista frameVista;

    private final PnlInicioControlador inicioControlador;
    private final PnlAsistenciaControlador asistenciaControlador;
    private final PnlUsuariosControlador usuariosControlador;
    private final PnlTrabajadoresControlador trabajadoresControlador;
    private final PnlInventarioControlador inventarioControlador;

    public FrameControlador() {

        frameVista = new FrameVista();

        inicioControlador = new PnlInicioControlador(this);
        asistenciaControlador = new PnlAsistenciaControlador(this); 
        usuariosControlador = new PnlUsuariosControlador(this); 
        trabajadoresControlador = new PnlTrabajadoresControlador(this); 
        inventarioControlador = new PnlInventarioControlador(this);  
    }

    public FrameVista getFrameVista() {
        return frameVista;
    }

    public void iniciar() {
        frameVista.setLocationRelativeTo(null);
        frameVista.setVisible(true);
        inicioControlador.mostrar();
    }

    public PnlInicioControlador getInicioControlador() {
        return inicioControlador;
    }
    
    public PnlAsistenciaControlador getAsistenciaControlador() {
        return asistenciaControlador;
    }
    
    public PnlUsuariosControlador getUsuariosControlador() {
    return usuariosControlador;
    }
    
    public PnlTrabajadoresControlador getTrabajadoresControlador() {
        return trabajadoresControlador;
    }
    
    public PnlInventarioControlador getInventarioControlador() {
        return inventarioControlador;
    }
}

