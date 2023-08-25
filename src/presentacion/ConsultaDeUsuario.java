package presentacion;

import java.awt.EventQueue;
import java.util.Set;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextPane;

import logica_Controladores.IControladorOferta;
import logica_Controladores.IControladorUsuario;
import logica_DataTypes.DataEmpresa;
import logica_DataTypes.DataUsuario;
import utils.Fabrica;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class ConsultaDeUsuario extends JInternalFrame {
	
	private JComboBox<DataUsuario> comboBoxUsuarios;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fabrica fabrica = Fabrica.getInstance();
					IControladorUsuario ICU = fabrica.getInUser();
					//IControladorOferta ICO = fabrica.getInOfer();
					ConsultaDeUsuario frame = new ConsultaDeUsuario(ICU);
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
	public ConsultaDeUsuario(IControladorUsuario ICU) {
		setBounds(100, 100, 469, 332);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Elija el Usuario que desea consultar:");
		lblNewLabel.setBounds(125, 11, 178, 14);
		getContentPane().add(lblNewLabel);
		
		comboBoxUsuarios = new JComboBox<DataUsuario>();
		comboBoxUsuarios.setBounds(83, 36, 265, 22);
		getContentPane().add(comboBoxUsuarios);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(10, 67, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nickname:");
		lblNewLabel_2.setBounds(10, 92, 54, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel fechaNacDesLabel = new JLabel("Fecha nacimiento:");
		fechaNacDesLabel.setBounds(10, 117, 96, 14);
		getContentPane().add(fechaNacDesLabel);
		
		JLabel linkDesLabel = new JLabel("Link Web:");
		linkDesLabel.setBounds(10, 142, 54, 14);
		getContentPane().add(linkDesLabel);
		
		JLabel lblNewLabel_5 = new JLabel("Descripcion:");
		lblNewLabel_5.setBounds(10, 167, 64, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Apellido:");
		lblNewLabel_6.setBounds(214, 69, 46, 14);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Email:");
		lblNewLabel_7.setBounds(214, 92, 46, 14);
		getContentPane().add(lblNewLabel_7);
		
		JLabel nacionDesLabel = new JLabel("Nacionalidad:");
		nacionDesLabel.setBounds(214, 117, 64, 14);
		getContentPane().add(nacionDesLabel);
		
		JTextPane descPane = new JTextPane();
		descPane.setBounds(72, 168, 351, 68);
		getContentPane().add(descPane);
		
		JLabel ofertasDesBox = new JLabel("Ofertas:");
		ofertasDesBox.setBounds(10, 251, 46, 14);
		getContentPane().add(ofertasDesBox);
		
		JComboBox ofertasBox = new JComboBox();
		ofertasBox.setBounds(72, 247, 265, 22);
		getContentPane().add(ofertasBox);
		
		JLabel nombreLabel = new JLabel("");
		nombreLabel.setBounds(66, 67, 128, 14);
		getContentPane().add(nombreLabel);
		
		JLabel nicknameLabel = new JLabel("");
		nicknameLabel.setBounds(74, 92, 120, 14);
		getContentPane().add(nicknameLabel);
		
		JLabel fechaNacLabel = new JLabel("");
		fechaNacLabel.setBounds(101, 117, 96, 14);
		getContentPane().add(fechaNacLabel);
		
		JLabel apellidoLabel = new JLabel("");
		apellidoLabel.setBounds(257, 69, 165, 14);
		getContentPane().add(apellidoLabel);
		
		JLabel emailLabel = new JLabel("");
		emailLabel.setBounds(244, 92, 178, 14);
		getContentPane().add(emailLabel);
		
		JLabel nacionLabel = new JLabel("");
		nacionLabel.setBounds(288, 117, 134, 14);
		getContentPane().add(nacionLabel);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.setBounds(364, 279, 89, 23);
		getContentPane().add(btnNewButton);
		
		JLabel linkLabel = new JLabel("");
		linkLabel.setBounds(60, 142, 200, 14);
		getContentPane().add(linkLabel);

	}
	
	public void cargarEmpresas() {
		Set<DataEmpresa> empresas = ICU.getDataEmpresa();
		DefaultComboBoxModel<DataEmpresa> model = new DefaultComboBoxModel<>();
	    
	    // Agregar las empresas al modelo del JComboBox
	    for (DataEmpresa empresa : empresas) {
	        model.addElement(empresa);
	    }
	    
	    // Establecer el modelo en el JComboBox
	    comboBoxEmpresa.setModel(model);
	}
}
