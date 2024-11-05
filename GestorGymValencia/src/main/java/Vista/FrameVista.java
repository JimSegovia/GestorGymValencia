package Vista;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameVista extends JFrame {

    private static final long serialVersionUID = 1L;
    public JPanel pnlContenido;

    public FrameVista() {
        setIconImage(new ImageIcon(getClass().getResource("/Images/GGV.png")).getImage());
        setTitle("Gestión Gym Valencia");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Establece un tamaño predefinido de 1140x640 píxeles
        setPreferredSize(new Dimension(1140, 640));
        setSize(1140, 640);
        setResizable(false); // Evita que el usuario redimensione la ventana

        pnlContenido = new JPanel();

        setContentPane(pnlContenido);
        pack(); // Ajusta la ventana al tamaño preferido
    }
}
