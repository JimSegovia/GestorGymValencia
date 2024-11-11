package Controlador;

import Vista.InicioVista;

public class PnlInicioControlador {

    private final FrameControlador frameControlador;
    private final InicioVista vista;

    public PnlInicioControlador(FrameControlador frameControlador) {
        this.frameControlador = frameControlador;
        this.vista = new InicioVista();
                
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
        vista.BotonInventario.addActionListener((e) -> {
			irAInventario();
		});
    }

    public void mostrar() {
        frameControlador.getFrameVista().pnlContenido.removeAll();
        frameControlador.getFrameVista().pnlContenido.add(vista);
        frameControlador.getFrameVista().pnlContenido.revalidate();
        frameControlador.getFrameVista().pnlContenido.repaint();
    }

    public InicioVista getVista() {
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
    private void irAInventario() {
    frameControlador.getInventarioControlador().mostrar();
    }
}
