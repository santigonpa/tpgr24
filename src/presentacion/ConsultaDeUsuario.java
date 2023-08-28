package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
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
import javax.swing.JTextArea;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import javax.swing.JScrollPane;
import javax.swing.SwingConstants;


public class ConsultaDeUsuario extends JInternalFrame {
	
	private JComboBox<DataUsuario> comboBoxUsuarios;
	private IControladorUsuario ICU;
	private IControladorOferta ICO;
	private JComboBox<DataOferta> comboOferta;
	private JLabel nombreLabel;
	private JLabel nicknameLabel;
	private JLabel fechaNacLabel;
	private JLabel linkLabel;
	private JLabel apellidoLabel;
	private JLabel nacionLabel;
	private JLabel emailLabel;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private ConsultaDeOfertaLaboral conOfertaLab;
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
		ICO =Ico;
		
		
		
		setBounds(100, 100, 578, 600);
		getContentPane().setLayout(null);
		
		
		conOfertaLab = new ConsultaDeOfertaLaboral(ICU,ICO);
		conOfertaLab.setBounds(20, 11, 501, 456);
		//conOfertaLab.setBounds(42, 0, 496, 456);
		conOfertaLab.setMaximizable(true);
		conOfertaLab.setClosable(true);
		conOfertaLab.setVisible(false);
		getContentPane().add(conOfertaLab);
		
		JLabel lblNewLabel = new JLabel("Elija el Usuario que desea consultar:");
		lblNewLabel.setBounds(192, 11, 178, 14);
		getContentPane().add(lblNewLabel);
		
		comboBoxUsuarios = new JComboBox<DataUsuario>();
		comboBoxUsuarios.setBounds(148, 36, 265, 22);
		getContentPane().add(comboBoxUsuarios);
		
		comboBoxUsuarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	limpiarFormulario();
            	DataUsuario selectedOption = (DataUsuario)comboBoxUsuarios.getSelectedItem();
      
                if (selectedOption instanceof DataEmpresa) {
                	DataEmpresa selectedEmpresa = (DataEmpresa) selectedOption;
                	nombreLabel.setText(selectedEmpresa.getNombre());
                	nicknameLabel.setText(selectedEmpresa.getNickName());
                	emailLabel.setText(selectedEmpresa.getEmail());
                	linkLabel.setText(selectedEmpresa.getLinkWeb());
                	apellidoLabel.setText(selectedEmpresa.getApellido());
                	
                	textArea.setVisible(true);
                	textArea.setText(selectedEmpresa.getDescripcion());
                	
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
            	    else {throw new Exception("No tiene ofertas laborales");}
            		}catch(Exception e22) {}

            		//parte para hacer aparecer el caso de uso de consulta de ofertaLaboral
            		
            		
            		
                } else if (selectedOption instanceof DataPostulante) {
                	textArea.setVisible(false);
                	comboOferta.setVisible(false);
                	

                	
                	DataPostulante selectedPostulante = (DataPostulante) selectedOption;
                	nombreLabel.setText(selectedPostulante.getNombre());
                	nicknameLabel.setText(selectedPostulante.getNickName());
                	apellidoLabel.setText(selectedPostulante.getApellido());
                	emailLabel.setText(selectedPostulante.getEmail());
                	nacionLabel.setText(selectedPostulante.getNacionalidad());
                	fechaNacLabel.setText(selectedPostulante.getFechaString());
                	
                	
                	
                	
                }
            }
        });
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(10, 67, 64, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nickname:");
		lblNewLabel_2.setBounds(10, 92, 76, 14);
		getContentPane().add(lblNewLabel_2);
		
		fechaNacLabel = new JLabel("Fecha nacimiento:");
		fechaNacLabel.setBounds(10, 117, 112, 14);
		getContentPane().add(fechaNacLabel);
		
		JLabel linkDesLabel = new JLabel("Link Web:");
		linkDesLabel.setBounds(10, 142, 78, 14);
		getContentPane().add(linkDesLabel);
		
		JLabel lblNewLabel_5 = new JLabel("Descripcion:");
		lblNewLabel_5.setBounds(10, 167, 94, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Apellido:");
		lblNewLabel_6.setBounds(257, 68, 80, 14);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Email:");
		lblNewLabel_7.setBounds(257, 92, 80, 14);
		getContentPane().add(lblNewLabel_7);
		
		JLabel nacionDesLabel = new JLabel("Nacionalidad:");
		nacionDesLabel.setBounds(257, 117, 94, 14);
		getContentPane().add(nacionDesLabel);
		
		JLabel ofertasDesBox = new JLabel("Ofertas:");
		ofertasDesBox.setBounds(76, 251, 64, 14);
		getContentPane().add(ofertasDesBox);
		
		comboOferta = new JComboBox<DataOferta>();
		comboOferta.setBounds(148, 247, 265, 22);
		comboOferta.setVisible(false);
		getContentPane().add(comboOferta);
		
		nombreLabel = new JLabel("");
		nombreLabel.setBounds(64, 67, 164, 14);
		getContentPane().add(nombreLabel);
		
		nicknameLabel = new JLabel("");
		nicknameLabel.setBounds(76, 92, 171, 14);
		getContentPane().add(nicknameLabel);
		
		fechaNacLabel = new JLabel("");
		fechaNacLabel.setBounds(119, 117, 94, 14);
		getContentPane().add(fechaNacLabel);
		
		apellidoLabel = new JLabel("");
		apellidoLabel.setBounds(313, 67, 191, 14);
		getContentPane().add(apellidoLabel);
		
		emailLabel = new JLabel("");
		emailLabel.setVerticalAlignment(SwingConstants.TOP);
		emailLabel.setBounds(295, 92, 243, 22);
		getContentPane().add(emailLabel);
		
		nacionLabel = new JLabel("");
		nacionLabel.setBounds(340, 117, 164, 14);
		getContentPane().add(nacionLabel);
		
		JButton btnNewButton = new JButton("Salir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        		limpiarFormulario();
		        		conOfertaLab.limpiarFormulario();//cambio para que al salir desde el frame Consulta de usuario se vaya tmb consulta de oferta
		        		conOfertaLab.setVisible(false);
		                setVisible(false);
			}
		});
		
		addInternalFrameListener(new InternalFrameAdapter() {
            @Override
            public void internalFrameClosing(InternalFrameEvent e) {
                limpiarFormulario();
            }
        });
		
		btnNewButton.setBounds(449, 513, 89, 23);
		getContentPane().add(btnNewButton);
		
		linkLabel = new JLabel("");
		linkLabel.setBounds(72, 142, 265, 14);
		getContentPane().add(linkLabel);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(96, 167, 386, 73); // Posición y tamaño del JScrollPane

        getContentPane().add(scrollPane);
        
        
        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        
        JButton btnDesplegarConsulta = new JButton("Consultar Oferta");
        btnDesplegarConsulta.setBounds(148, 514, 145, 21);
        getContentPane().add(btnDesplegarConsulta);
        btnDesplegarConsulta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    DataUsuario selectedOption = (DataUsuario) comboBoxUsuarios.getSelectedItem();
                    if (selectedOption instanceof DataEmpresa) {
                        DataEmpresa emp = (DataEmpresa) selectedOption;
                        DataOferta of = (DataOferta) comboOferta.getSelectedItem();
                        conOfertaLab.asignarValoresConsultaDeUsuario(emp, of);
                        conOfertaLab.setVisible(true);
                        conOfertaLab.toFront();
                    } else {
                        throw new Exception("Debe estar seleccionada una empresa");
                    }
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(ConsultaDeUsuario.this, e1.getMessage(), "Consulta de Usuario", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

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
	
	
	public void limpiarFormulario() {
		nombreLabel.setText("");
    	nicknameLabel.setText("");
    	linkLabel.setText("");
    	apellidoLabel.setText("");
    	emailLabel.setText("");
    	textArea.setText("");
    	nacionLabel.setText("");
    	fechaNacLabel.setText("");
	}
}
