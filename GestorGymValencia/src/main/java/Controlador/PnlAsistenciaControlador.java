package Controlador;

import Vista.AsistenciaVista;

public class PnlAsistenciaControlador {

    private final FrameControlador frameControlador;
    private final AsistenciaVista vista;

    public PnlAsistenciaControlador(FrameControlador frameControlador) {
        this.frameControlador = frameControlador;
        this.vista = new AsistenciaVista();
                
        setEvents();
    }

    public final void setEvents() {
        vista.BotonInicio.addActionListener((e) -> {
			irAInicio();
		});
        vista.BotonAsistencia.addActionListener((e) -> {
			irAAsistencia();
		});
        vista.BotonUsuarios.addActionListener((e) -> {
			irAUsuarios();
		});
        vista.BotonTrabajadores.addActionListener((e) -> {
			irATrabajadores();
		});
    }

    public void mostrar() {
        frameControlador.getFrameVista().pnlContenido.removeAll();
        frameControlador.getFrameVista().pnlContenido.add(vista);
        frameControlador.getFrameVista().pnlContenido.revalidate();
        frameControlador.getFrameVista().pnlContenido.repaint();
    }

    public AsistenciaVista getVista() {
        return vista;
    }
    
    private void irAInicio() {
    frameControlador.getInicioControlador().mostrar();
    }	
    
    private void irAAsistencia() {
    frameControlador.getAsistenciaControlador().mostrar();
    }
    
    private void irAUsuarios() {
    frameControlador.getUsuariosControlador().mostrar();
    }
    
    private void irATrabajadores() {
    frameControlador.getTrabajadoresControlador().mostrar();
    }
}
