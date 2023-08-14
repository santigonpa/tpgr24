package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class PostulacionAOfertaLaboral extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostulacionAOfertaLaboral frame = new PostulacionAOfertaLaboral();
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
	public PostulacionAOfertaLaboral() {
		setBounds(100, 100, 450, 300);

	}

}
