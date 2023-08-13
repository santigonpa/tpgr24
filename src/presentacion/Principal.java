package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Rectangle;
import java.awt.GridBagLayout;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;

public class Principal {

	private JFrame trabajouy;
	private ConsultarUsuario conUsrInternalFrame;
	private AddTipoPubliOfertaLabAPaq addTOfLabAPaqInternalFrame;
	private ModificarDatosDeUsuario modDatosUser;
	private AltaDeUsuario altaUser;
	private ConsultaDePaqueteDeTiposDePublicacionDeOfertasLaborales conPaquetes;
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.trabajouy.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Principal() {
		initialize();
		
		conUsrInternalFrame = new ConsultarUsuario();
		conUsrInternalFrame.setBounds(163, 79, 444, 302);
		conUsrInternalFrame.setMaximizable(true);
		conUsrInternalFrame.setClosable(true);
        conUsrInternalFrame.setVisible(false);
        trabajouy.getContentPane().setLayout(null);
        
        trabajouy.getContentPane().add(conUsrInternalFrame);
        conUsrInternalFrame.getContentPane().setLayout(null);
        
        addTOfLabAPaqInternalFrame = new AddTipoPubliOfertaLabAPaq();
        addTOfLabAPaqInternalFrame.setNormalBounds(new Rectangle(100, 100, 500, 172));
        GridBagLayout gridBagLayout = (GridBagLayout) addTOfLabAPaqInternalFrame.getContentPane().getLayout();
        gridBagLayout.columnWidths = new int[]{9, 81, 0, 0, 0};
        addTOfLabAPaqInternalFrame.setMaximizable(true);
        addTOfLabAPaqInternalFrame.setBounds(100, 100, 456, 165);
        addTOfLabAPaqInternalFrame.setClosable(true);
        trabajouy.getContentPane().add(addTOfLabAPaqInternalFrame);
        
        modDatosUser = new ModificarDatosDeUsuario();
        modDatosUser.setBounds(100, 100, 550, 300);
        modDatosUser.setMaximizable(true);
        modDatosUser.setClosable(true);
        modDatosUser.setVisible(false);
        trabajouy.getContentPane().setLayout(null);
        
        trabajouy.getContentPane().add(modDatosUser);
        modDatosUser.getContentPane();
        
        altaUser = new AltaDeUsuario();
        altaUser.setBounds(100, 100, 550, 300);
        altaUser.setMaximizable(true);
        altaUser.setClosable(true);
        altaUser.setVisible(false);
        trabajouy.getContentPane().setLayout(null);
        
        trabajouy.getContentPane().add(altaUser);
        altaUser.getContentPane();
        
        conPaquetes = new ConsultaDePaqueteDeTiposDePublicacionDeOfertasLaborales();
        conPaquetes.setBounds(100, 100, 550, 300);
        conPaquetes.setMaximizable(true);
        conPaquetes.setClosable(true);
        conPaquetes.setVisible(false);
        trabajouy.getContentPane().setLayout(null);
        
        trabajouy.getContentPane().add(conPaquetes);
        conPaquetes.getContentPane();
        
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		trabajouy = new JFrame();
		trabajouy.setTitle("trabajouy");
		trabajouy.setBounds(100, 100, 703, 564);
		trabajouy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		trabajouy.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Sistema");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Salir");
		mntmNewMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // Salgo de la aplicación
            	trabajouy.setVisible(false);
            	trabajouy.dispose();
            }
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Usuarios");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Consulta usuario");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	conUsrInternalFrame.setVisible(true);
            }
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Modificar usuario");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	modDatosUser.setVisible(true);
            }
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("Paquete");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Agregar Tipo Oferta Laboral");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				addTOfLabAPaqInternalFrame.setVisible(true);
            }
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Consulta de Paquetes");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				conPaquetes.setVisible(true);
            }
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Alta de usuarios");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUser.setVisible(true);
            }
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		

		
		JMenu mnNewMenu_3 = new JMenu("Ofertas");
		menuBar.add(mnNewMenu_3);
	}

}
