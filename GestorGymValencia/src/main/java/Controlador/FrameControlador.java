package Controlador;

import Vista.FrameVista;

public class FrameControlador {

    // VISTA DEL CONTROLADOR AL INICIAR EL PROGRAMA
    private final FrameVista frameVista;

    // TODOS LOS DEMÁS CONTROLADORES
    private final PnlInicioControlador inicioControlador;
    private final PnlAsistenciaControlador asistenciaControlador;
    private final PnlUsuariosControlador usuariosControlador;
    private final PnlTrabajadoresControlador trabajadoresControlador;
    // CONSTRUCTOR DEL CONTROLADOR DEL FRAME
    public FrameControlador() {
        // INSTANCIACIÓN DEL FRAME PRINCIPAL
        frameVista = new FrameVista();
                
        // INSTANCIAMOS LOS DEMÁS CONTROLADORES
        inicioControlador = new PnlInicioControlador(this); // Solo pasamos this sin conexión a la base de datos
        asistenciaControlador = new PnlAsistenciaControlador(this); 
        usuariosControlador = new PnlUsuariosControlador(this); 
        trabajadoresControlador = new PnlTrabajadoresControlador(this); 
        
    }

    // Getter para obtener la vista del Frame
    public FrameVista getFrameVista() {
        return frameVista;
    }

    // Método para iniciar el programa
    public void iniciar() {
        frameVista.setLocationRelativeTo(null);
        frameVista.setVisible(true);
        inicioControlador.mostrar();
    }

    // Método para retornar el controlador de inicio
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
}

