package presentacion;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import utils.Fabrica;
import logica_cargar_datos.datos_de_prueba.cargarDatos;
import logica_controladores.IControladorOferta;
import controladores.publicar.PublicadorManejadorPyT;
import controladores.publicar.PublicadorManejadorOfertas;
import controladores.publicar.PublicadorManejadorUsuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import controladores.publicar.PublicadorControladorOfertas;
import controladores.publicar.PublicadorControladorUsuario;
import logica_controladores.IControladorUsuario;
import logica_entidades.Empresa;
import logica_entidades.OfertaLaboral;
import logica_entidades.Postulacion;
import logica_manejadores.IManejadorOferta;
import logica_manejadores.IManejadorPyT;
import logica_manejadores.IManejadorUsuario;
import utils.Config;

import javax.swing.JMenu;
//import java.awt.Rectangle;
//import java.awt.GridBagLayout;
public class Principal {
	private JFrame trabajouy;
	private ConsultaDeUsuario conUsrInternalFrame;
//	private AddTipoPubliOfertaLabAPaq addTOfLabAPaqInternalFrame;
	private ModificarDatosDeUsuario modDatosUser;
	private AltaDeUsuario altaUser;
	private ConsultaDeTiposDePublicacionDeOfertasLaborales conPaquetes;
	private ConsultaDeOfertaLaboral conOfertaLab;
	private AltaDeOfertaLaboral altOfLab;
	private PostulacionAOfertaLaboral PosAOferLab;
	private AltaDeTipoDePublicacionDeOfertaLaboral Altideof;
	private CrearPaqueteDeTipoDePublicacionDeOfertasLaborales crearpaqtipopublioferlab;
	private AgregarTipoPubliAPaquete agregarTPubliAPaquete;
	private OfertasMasVisitadas oferMasVisitadas;
	private aceptarRechazarOferta aorOf;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Config.cargarConfiguracion();
					
					Principal window = new Principal();
					PublicadorManejadorUsuario pmuser = new PublicadorManejadorUsuario();
					PublicadorManejadorPyT pmpyt = new PublicadorManejadorPyT();
					PublicadorControladorOfertas pcofer = new PublicadorControladorOfertas();
					PublicadorControladorUsuario pcuser = new PublicadorControladorUsuario();
					PublicadorManejadorOfertas pmofer = new PublicadorManejadorOfertas();
					pmuser.publicar();
					pmpyt.publicar();
					pcofer.publicar();
					pmofer.publicar();
					pcuser.publicar();
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
		
		// Inicialización de controladores
		Fabrica fabrica = Fabrica.getInstance();
		IControladorUsuario ICU = fabrica.getInUser();
		IControladorOferta ICO = fabrica.getInOfer();
		IManejadorUsuario IMU =fabrica.getInManejadorUsuario();
		IManejadorOferta IMO = fabrica.getInManejadorOferta();
		IManejadorPyT IPYT = fabrica.getInManejadorPyT();
		trabajouy.getContentPane().setLayout(null);
		trabajouy.getContentPane().setLayout(null);
		altaUser = new AltaDeUsuario(ICO, ICU);
		altaUser.setBounds(100, 100, 450, 387);
		altaUser.setMaximizable(true);
		altaUser.setClosable(true);
		altaUser.setVisible(false);
		trabajouy.getContentPane().setLayout(null);
		trabajouy.getContentPane().add(altaUser);
		altaUser.getContentPane();
		conPaquetes = new ConsultaDeTiposDePublicacionDeOfertasLaborales();
		conPaquetes.setBounds(100, 100, 550, 300);
		conPaquetes.setMaximizable(true);
		conPaquetes.setClosable(true);
		conPaquetes.setVisible(false);
		trabajouy.getContentPane().setLayout(null);
		trabajouy.getContentPane().add(conPaquetes);
		conPaquetes.getContentPane();
		trabajouy.getContentPane().setLayout(null);
		altOfLab = new AltaDeOfertaLaboral(ICO, ICU);
		altOfLab.setTitle("Alta de Oferta Laboral\r\n");
		altOfLab.setBounds(100, 100, 561, 475);
		altOfLab.setMaximizable(true);
		altOfLab.setClosable(true);
		altOfLab.setVisible(false);
		trabajouy.getContentPane().add(altOfLab);
		altOfLab.getContentPane();
		trabajouy.getContentPane().setLayout(null);
		PosAOferLab = new PostulacionAOfertaLaboral(ICU,ICO, IMU, IMO);
		PosAOferLab.setBounds(10, 10, 710, 680);
		trabajouy.getContentPane().add(PosAOferLab);
		Altideof = new AltaDeTipoDePublicacionDeOfertaLaboral(ICO);
		trabajouy.getContentPane().add(Altideof);
		Altideof.getContentPane();
		conUsrInternalFrame = new ConsultaDeUsuario(ICU,ICO,IMU);
		conUsrInternalFrame.setTitle("Consulta de Usuario");
		conUsrInternalFrame.setBounds(83, 10, 578, 600);
		conUsrInternalFrame.setMaximizable(true);
		conUsrInternalFrame.setClosable(true);
		conUsrInternalFrame.setVisible(false);
		trabajouy.getContentPane().add(conUsrInternalFrame);
		conUsrInternalFrame.getContentPane().setLayout(null);
		/*addTOfLabAPaqInternalFrame = new AddTipoPubliOfertaLabAPaq();
		addTOfLabAPaqInternalFrame.setNormalBounds(new Rectangle(100, 100, 500, 172));
		GridBagLayout gridBagLayout = (GridBagLayout) addTOfLabAPaqInternalFrame.getContentPane().getLayout();
		gridBagLayout.columnWidths = new int[]{9, 81, 0, 0, 0};
		addTOfLabAPaqInternalFrame.setMaximizable(true);
		addTOfLabAPaqInternalFrame.setBounds(79, 44, 456, 165);
		addTOfLabAPaqInternalFrame.setClosable(true);
		trabajouy.getContentPane().add(addTOfLabAPaqInternalFrame);
		*/
		modDatosUser = new ModificarDatosDeUsuario(ICO,ICU, IMU);
		modDatosUser.setBounds(100, 100, 550, 300);
		modDatosUser.setMaximizable(true);
		modDatosUser.setClosable(true);
		modDatosUser.setVisible(false);
		modDatosUser.cargarUsuarios();
		trabajouy.getContentPane().add(modDatosUser);
		modDatosUser.getContentPane();

		conOfertaLab = new ConsultaDeOfertaLaboral(ICU, ICO);
		conOfertaLab.setBounds(100, 100, 500, 456);
		conOfertaLab.setMaximizable(true);
		conOfertaLab.setClosable(true);
		conOfertaLab.setVisible(false);
		trabajouy.getContentPane().add(conOfertaLab);
		
		crearpaqtipopublioferlab = new CrearPaqueteDeTipoDePublicacionDeOfertasLaborales(ICO);
		crearpaqtipopublioferlab.setBounds(100, 100, 374, 313);
		crearpaqtipopublioferlab.setMaximizable(true);
		crearpaqtipopublioferlab.setClosable(true);
		crearpaqtipopublioferlab.setVisible(false);
		trabajouy.getContentPane().add(crearpaqtipopublioferlab);
		
		agregarTPubliAPaquete = new AgregarTipoPubliAPaquete(ICO, IPYT);
		agregarTPubliAPaquete.setBounds(100, 100, 450, 173);
		agregarTPubliAPaquete.setMaximizable(true);
		agregarTPubliAPaquete.setClosable(true);
		agregarTPubliAPaquete.setVisible(false);
		trabajouy.getContentPane().add(agregarTPubliAPaquete);
		
		oferMasVisitadas = new OfertasMasVisitadas(IMO);
		oferMasVisitadas.setBounds(100, 100, 628, 170);
		oferMasVisitadas.setMaximizable(true);
		oferMasVisitadas.setClosable(true);
		oferMasVisitadas.setVisible(false);
		trabajouy.getContentPane().add(oferMasVisitadas);
		
		aorOf = new aceptarRechazarOferta(ICO,ICU);
		aorOf.setBounds(100, 100, 438, 261);
		aorOf.setMaximizable(true);
		aorOf.setClosable(true);
		aorOf.setVisible(false);
		trabajouy.getContentPane().add(aorOf);
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		trabajouy = new JFrame();
		trabajouy.setTitle("trabajouy");
		trabajouy.setBounds(100, 100, 850, 850);
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
		
		JMenuItem cgMenuItem = new JMenuItem("Cargar Datos");
		mnNewMenu.add(cgMenuItem);
		mnNewMenu.add(mntmNewMenuItem);
		cgMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDatos cargador = new cargarDatos();
		 try {
			cargador.cargar();

			
				/*EntityManagerFactory emf = null;
				EntityManager enM = null;
				try {	
				//En algún lugar de tu aplicación (puede ser un inicializador, un servlet, etc.)
				emf = Persistence.createEntityManagerFactory("persistir");
				enM = emf.createEntityManager();
				
				//Iniciar transacción
				Fabrica fabrica = Fabrica.getInstance();
				IManejadorOferta IMO = fabrica.getInManejadorOferta();

				OfertaLaboral o5 = IMO.obtenerOferta("Content Manager");
				EntityTransaction tx = enM.getTransaction();
				tx.begin();
				enM.persist(o5);
				Empresa emp = o5.getEmpresa();
				enM.persist(emp);
				ArrayList<Postulacion> post = o5.getPostulaciones();
				for(Postulacion postulacion : post){
					enM.persist(postulacion.getPostulante());
					enM.persist(postulacion);
				}
				tx.commit();
				System.out.println("Se cargaron los datos correctamente");

				 
					} catch (Exception e2) {
						e2.printStackTrace();
						enM.getTransaction().rollback();
					} finally {
						// Cerrar EntityManager
						enM.close();
						emf.close();
						}*/
				
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
}
		});
		
		JMenu mnNewMenu_1 = new JMenu("Usuarios");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Consulta usuario");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	conUsrInternalFrame.cargarUsuarios();
	conUsrInternalFrame.setVisible(true);
}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Modificar usuario");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
	modDatosUser.cargarUsuarios();
	modDatosUser.setVisible(true);
}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("Paquete");
		menuBar.add(mnNewMenu_2);
			
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Agregar Tipo de publicación de Oferta Laboral a Paquete");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eprox) {
				agregarTPubliAPaquete.setVisible(true);
				agregarTPubliAPaquete.cargarPaquetes();
				agregarTPubliAPaquete.cargarTipoPubli();
				agregarTPubliAPaquete.limpiarFormulario();
			}
		});
		
		//JFrame frame = new JFrame("");
		
		
		
		JMenuItem mntmProximamente = new JMenuItem("Crear Paquetes De Tipo De publicacion de Ofertas Laborales");
		mntmProximamente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eprox) {
				crearpaqtipopublioferlab.setVisible(true);
				crearpaqtipopublioferlab.limpiarFormulario();
			}
		});
		mnNewMenu_2.add(mntmProximamente);
		
		
		
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		/*JMenuItem mntmNewMenuItem_3 = new JMenuItem("Agregar Tipo Oferta Laboral");
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
		
		*/
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Alta de usuarios");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaUser.setVisible(true);
				altaUser.limpiarFormulario();
}
		});
		mnNewMenu_1.add(mntmNewMenuItem_5);
		
		
		JMenu mnNewMenu_3 = new JMenu("Ofertas");
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Consulta de oferta laboral");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				conOfertaLab.setVisible(true);
				conOfertaLab.cargarEmpresas();
				conOfertaLab.limpiarFormulario();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_6);
						
		menuBar.add(mnNewMenu_3);
			
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("Alta de Oferta Laboral");
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e2) {
				altOfLab.setVisible(true);
				altOfLab.cargarEmpresas();
				altOfLab.cargarTiposDePublicacion();
				altOfLab.cargarKeywords();
				altOfLab.limpiarFormulario();
}
		});
		mnNewMenu_3.add(mntmNewMenuItem_7);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Postulacion a Oferta Laboral");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evento) {
	PosAOferLab.cargarDatos();
				PosAOferLab.setVisible(true);
}
		});
		mnNewMenu_3.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItemAltaDePubliDeTipoOferLab = new JMenuItem("Alta de tipo de publicacion de oferta laboral");
		mntmNewMenuItemAltaDePubliDeTipoOferLab.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Altideof.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItemAltaDePubliDeTipoOferLab);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Aceptar o Rechazar Oferta Laboral");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				aorOf.setVisible(true);
				aorOf.cargarEmpresas();
				aorOf.limpiarFormulario();
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("Ofertas mas visitadas");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				oferMasVisitadas.cargarOfertas();
				oferMasVisitadas.actualizarTabla();
				oferMasVisitadas.setVisible(true);	
			}
		});;
		mnNewMenu_3.add(mntmNewMenuItem_9);
	
	}
}
