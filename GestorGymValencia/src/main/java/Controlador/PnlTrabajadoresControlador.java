package Controlador;

import Vista.TrabajadoresVista;

public class PnlTrabajadoresControlador {

    private final FrameControlador frameControlador;
    private final TrabajadoresVista vista;

    public PnlTrabajadoresControlador(FrameControlador frameControlador) {
        this.frameControlador = frameControlador;
        this.vista = new TrabajadoresVista();
                
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

    public TrabajadoresVista getVista() {
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
