package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class OfertasMasVisitadas extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OfertasMasVisitadas frame = new OfertasMasVisitadas();
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
	public OfertasMasVisitadas() {
		setBounds(100, 100, 450, 300);

	}

}
