package tempRunner;

import Controlador.FrameControlador;

public class App {

	// METODO MAIN PARA INCIAR EL PROGRAMA
	public static void main(String[] args) {



		// INSTANCIACION DEL CONTROLADOR MAESTRO
		FrameControlador frameControlador = new FrameControlador();

		// METODO QUE CARGA EL JFRAME INICIAL (LA VENTANA)
		frameControlador.iniciar();

	}
}
