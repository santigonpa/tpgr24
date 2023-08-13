package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class ConsultaDeOfertaLaboral extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaDeOfertaLaboral frame = new ConsultaDeOfertaLaboral();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsultaDeOfertaLaboral() {
		setBounds(100, 100, 450, 300);

	}

}
