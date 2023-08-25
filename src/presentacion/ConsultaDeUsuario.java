package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextPane;

import excepciones.NoTieneOfertasException;
import excepciones.UsuarioNoExisteException;
import logica_Controladores.IControladorOferta;
import logica_Controladores.IControladorUsuario;
import logica_DataTypes.DataEmpresa;
import logica_DataTypes.DataOferta;
import logica_DataTypes.DataPostulante;
import logica_DataTypes.DataUsuario;
import utils.Fabrica;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class ConsultaDeUsuario extends JInternalFrame {
	
	private JComboBox<DataUsuario> comboBoxUsuarios;
	private IControladorUsuario ICU;
	private JComboBox<DataOferta> comboOferta;
	private JLabel nombreLabel;
	private JLabel nicknameLabel;
	private JLabel fechaNacLabel;
	private JLabel linkLabel;
	private JLabel apellidoLabel;
	private JLabel nacionLabel;
	private JTextPane descPane;
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
					IControladorOferta ICO = fabrica.getInOfer();
					ConsultaDeUsuario frame = new ConsultaDeUsuario(ICU,ICO);
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
	public ConsultaDeUsuario(IControladorUsuario Icu,IControladorOferta Ico) {
		ICU =Icu;
		setBounds(100, 100, 578, 332);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Elija el Usuario que desea consultar:");
		lblNewLabel.setBounds(125, 11, 178, 14);
		getContentPane().add(lblNewLabel);
		
		comboBoxUsuarios = new JComboBox<DataUsuario>();
		comboBoxUsuarios.setBounds(83, 36, 265, 22);
		getContentPane().add(comboBoxUsuarios);
		
		comboBoxUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	DataUsuario selectedOption = (DataUsuario)comboBoxUsuarios.getSelectedItem();
      
                if (selectedOption instanceof DataEmpresa) {
                	DataEmpresa selectedEmpresa = (DataEmpresa) selectedOption;
                	nombreLabel.setText(selectedEmpresa.getNombre());
                	nicknameLabel.setText(selectedEmpresa.getNickName());
                	linkLabel.setText(selectedEmpresa.getLinkWeb());
                	apellidoLabel.setText(selectedEmpresa.getApellido());
                	descPane.setText(selectedEmpresa.getDescripcion());
                	
                	comboOferta.setVisible(true);
                	DefaultComboBoxModel<DataOferta> model = new DefaultComboBoxModel<>();
            		try {
            		Set<DataOferta> ofertas = ICU.getDataOfertasDeEmpresa(selectedEmpresa.getNickName());
            		
            	    if (ofertas!= null) {
            	    // Agregar las empresas al modelo del JComboBox
            	    for (DataOferta oferta : ofertas) {
            	        model.addElement(oferta);
            	    }
            	    
            	    // Establecer el modelo en el JComboBox
            	    comboOferta.setModel(model);}
            	    else {throw new NoTieneOfertasException("No tiene ofertas laborales");}
            		}catch(NoTieneOfertasException e22) {}
                	
                } else if (selectedOption instanceof DataPostulante) {
                	
                	comboOferta.setVisible(false);
                	
                	DataPostulante selectedPostulante = (DataPostulante) selectedOption;
                	nombreLabel.setText(selectedPostulante.getNombre());
                	nicknameLabel.setText(selectedPostulante.getNickName());
                	apellidoLabel.setText(selectedPostulante.getApellido());
                	nacionLabel.setText(selectedPostulante.getNacionalidad());
                	fechaNacLabel.setText(selectedPostulante.getFechaString());
                	
                	
                }
            }
        });
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(10, 67, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nickname:");
		lblNewLabel_2.setBounds(10, 92, 54, 14);
		getContentPane().add(lblNewLabel_2);
		
		fechaNacLabel = new JLabel("Fecha nacimiento:");
		fechaNacLabel.setBounds(10, 117, 96, 14);
		getContentPane().add(fechaNacLabel);
		
		JLabel linkDesLabel = new JLabel("Link Web:");
		linkDesLabel.setBounds(10, 142, 54, 14);
		getContentPane().add(linkDesLabel);
		
		JLabel lblNewLabel_5 = new JLabel("Descripcion:");
		lblNewLabel_5.setBounds(10, 167, 64, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Apellido:");
		lblNewLabel_6.setBounds(257, 68, 46, 14);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Email:");
		lblNewLabel_7.setBounds(257, 92, 46, 14);
		getContentPane().add(lblNewLabel_7);
		
		JLabel nacionDesLabel = new JLabel("Nacionalidad:");
		nacionDesLabel.setBounds(254, 117, 64, 14);
		getContentPane().add(nacionDesLabel);
		
		descPane = new JTextPane();
		descPane.setBounds(72, 168, 432, 68);
		getContentPane().add(descPane);
		
		JLabel ofertasDesBox = new JLabel("Ofertas:");
		ofertasDesBox.setBounds(10, 251, 46, 14);
		getContentPane().add(ofertasDesBox);
		
		comboOferta = new JComboBox<DataOferta>();
		comboOferta.setBounds(72, 247, 347, 22);
		comboOferta.setVisible(false);
		getContentPane().add(comboOferta);
		
		nombreLabel = new JLabel("");
		nombreLabel.setBounds(66, 67, 162, 14);
		getContentPane().add(nombreLabel);
		
		nicknameLabel = new JLabel("");
		nicknameLabel.setBounds(74, 92, 173, 14);
		getContentPane().add(nicknameLabel);
		
		fechaNacLabel = new JLabel("");
		fechaNacLabel.setBounds(101, 117, 112, 14);
		getContentPane().add(fechaNacLabel);
		
		apellidoLabel = new JLabel("");
		apellidoLabel.setBounds(313, 67, 191, 14);
		getContentPane().add(apellidoLabel);
		
		JLabel emailLabel = new JLabel("");
		emailLabel.setBounds(323, 92, 221, 14);
		getContentPane().add(emailLabel);
		
		nacionLabel = new JLabel("");
		nacionLabel.setBounds(326, 117, 178, 14);
		getContentPane().add(nacionLabel);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.setBounds(455, 270, 89, 23);
		getContentPane().add(btnNewButton);
		
		linkLabel = new JLabel("");
		linkLabel.setBounds(60, 142, 277, 14);
		getContentPane().add(linkLabel);

	}
	
	public void cargarUsuarios() {
		DefaultComboBoxModel<DataUsuario> model = new DefaultComboBoxModel<>();
		try {
		Set<DataUsuario> usuarios = ICU.getDataUsuarios();
		
	    
	    // Agregar las empresas al modelo del JComboBox
	    for (DataUsuario usuario : usuarios) {
	        model.addElement(usuario);
	    }
	    
	    // Establecer el modelo en el JComboBox
	    comboBoxUsuarios.setModel(model);
		}catch(UsuarioNoExisteException e) {}
	}
	
}
