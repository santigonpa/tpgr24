package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.JLabel;

import utils.Fabrica;
import excepciones.ContraseniaDiferenteException;
import excepciones.EmailYaExisteException;
import excepciones.NicknameYaExisteException;
import excepciones.campoInvalidoException;
import logica_cargar_datos.datos_de_prueba.cargarDatos;
import logica_controladores.IControladorOferta;
import logica_controladores.IControladorUsuario;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JPasswordField;


public class AltaDeUsuario extends JInternalFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static IControladorUsuario ICU;
	
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldEmail;
	private JTextField textFieldLink;
	private JTextField textFieldNacionalidad;
	private JComboBox<String> seleccionTipoUsuario;
	private JSpinner spinnerNacimiento;
	private String[] arreglo;
	private JTextArea textAreaDescripcion;
	private JScrollPane scrollPane;
	private JTextField textField;
	private JPasswordField textFieldContra1;
	private JPasswordField textFieldContra2;

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
					AltaDeUsuario frame = new AltaDeUsuario(ICO,ICU);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AltaDeUsuario(IControladorOferta Ico, IControladorUsuario Icu) {
		ICU = Icu;
		setTitle("Alta de usuario");
		setBounds(100, 100, 450, 387);
		setResizable(true);
	    setIconifiable(true);
	    setMaximizable(true);
	    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    setClosable(true);
	    getContentPane().setLayout(null);
	    
	    JLabel lblNewLabel_5 = new JLabel("       Fecha de nacimiento :");
	    lblNewLabel_5.setBounds(166, 149, 164, 14);
	    getContentPane().add(lblNewLabel_5);
	    
	    JLabel lblNewLabel_6 = new JLabel("Nacionalidad :");
	    lblNewLabel_6.setBounds(187, 117, 96, 14);
	    getContentPane().add(lblNewLabel_6);
	    
	    textFieldNacionalidad = new JTextField();
	    textFieldNacionalidad.setBounds(266, 114, 146, 20);
	    getContentPane().add(textFieldNacionalidad);
	    textFieldNacionalidad.setColumns(10);
	    
	 // Crear un SpinnerDateModel para manejar la fecha
	    Date initialDate = Calendar.getInstance().getTime();
        SpinnerDateModel dateModel = new SpinnerDateModel(initialDate, null, null, Calendar.DAY_OF_MONTH);
	    spinnerNacimiento = new JSpinner(dateModel);
	    spinnerNacimiento.setBounds(332, 145, 80, 23);
	    getContentPane().add(spinnerNacimiento);
	 // Personalizar la apariencia del JSpinner para mostrar solo la fecha
	    JSpinner.DateEditor de_spinnerNacimiento = new JSpinner.DateEditor(spinnerNacimiento, "dd/MM/yyyy");
	    spinnerNacimiento.setEditor(de_spinnerNacimiento);
	    
	    
	    /*JList<Object> list = new JList<Object>();
	    getContentPane().add(list, "cell 0 5,grow");*/
	    
	    
	    JLabel lblNewLabel_7 = new JLabel("   Descripción : ");
	    lblNewLabel_7.setBounds(0, 188, 96, 14);
	    getContentPane().add(lblNewLabel_7);
	    
	    scrollPane = new JScrollPane();
        scrollPane.setBounds(93, 183, 319, 92); // Misma posición y tamaño que el JTextArea
        getContentPane().add(scrollPane);

        textAreaDescripcion = new JTextArea();
        textAreaDescripcion.setWrapStyleWord(true);
        textAreaDescripcion.setLineWrap(true);
        scrollPane.setViewportView(textAreaDescripcion);

	    
	    JLabel lblNewLabel_8 = new JLabel("    Link :");
	    lblNewLabel_8.setBounds(11, 289, 72, 14);
	    getContentPane().add(lblNewLabel_8);
	    
	    textFieldLink = new JTextField();
	    textFieldLink.setBounds(93, 286, 319, 20);
	    getContentPane().add(textFieldLink);
	    textFieldLink.setColumns(10);
	    
		
	    seleccionTipoUsuario = new JComboBox<String>();
	    seleccionTipoUsuario.setBounds(166, 12, 261, 20);
	    arreglo = new String[] {"Seleccione tipo usuario...", "Empresa", "Postulante"};
	    seleccionTipoUsuario.setModel(new DefaultComboBoxModel<String>(arreglo));
	    getContentPane().add(seleccionTipoUsuario);
	    seleccionTipoUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String selectedOption = (String) seleccionTipoUsuario.getSelectedItem();
                if (selectedOption.equals("Empresa")) {
                	textFieldLink.setEditable(true);
                    textAreaDescripcion.setEditable(true);
                	textFieldNacionalidad.setEditable(false);
                	spinnerNacimiento.setEnabled(false);
                } else if (selectedOption.equals("Postulante")) {
                	textFieldNacionalidad.setEditable(true);
                	spinnerNacimiento.setEnabled(true);
                	textFieldLink.setEditable(false);
                    textAreaDescripcion.setEditable(false);
                }
            }
        });
	    
	    JLabel lblNewLabel = new JLabel("Tipo de usuario :");
	    lblNewLabel.setBounds(7, 15, 126, 14);
	    getContentPane().add(lblNewLabel);
	    
	    	    
	    JLabel lblNewLabel_1 = new JLabel("Nombre :");
	    lblNewLabel_1.setBounds(19, 49, 57, 14);
	    getContentPane().add(lblNewLabel_1);
	    
	    textFieldNombre = new JTextField();
	    textFieldNombre.setBounds(93, 46, 79, 20);
	    getContentPane().add(textFieldNombre);
	    textFieldNombre.setColumns(10);
	    
	    JLabel lblNewLabel_2 = new JLabel("Apellido :");
	    lblNewLabel_2.setBounds(193, 49, 63, 14);
	    getContentPane().add(lblNewLabel_2);
	    
	    textFieldApellido = new JTextField();
	    textFieldApellido.setBounds(265, 46, 147, 20);
	    getContentPane().add(textFieldApellido);
	    textFieldApellido.setColumns(10);
	    
	    JLabel lblNewLabel_3 = new JLabel("Nickname :");
	    lblNewLabel_3.setBounds(19, 80, 77, 14);
	    getContentPane().add(lblNewLabel_3);
	    
	    JLabel lblNewLabel_4 = new JLabel("Email :");
	    lblNewLabel_4.setBounds(193, 80, 49, 14);
	    getContentPane().add(lblNewLabel_4);
		  
	    textFieldEmail = new JTextField();
	    textFieldEmail.setBounds(265, 80, 147, 20);
	    getContentPane().add(textFieldEmail);
	    textFieldEmail.setColumns(10);
	    
	    
	    JButton btnNewButton_1 = new JButton("Aceptar");
	    btnNewButton_1.setBounds(222, 327, 84, 23);
	    btnNewButton_1.setForeground(new Color(61, 56, 70));
	    getContentPane().add(btnNewButton_1);
	    
	    JButton btnNewButton_2 = new JButton("Cancelar");
	    btnNewButton_2.setForeground(new Color(61, 56, 70));
	    btnNewButton_2.setBounds(316, 327, 96, 23);
	    getContentPane().add(btnNewButton_2);
	    
	    JLabel lblNewLabel_3_1 = new JLabel("Contraseña:");
	    lblNewLabel_3_1.setBounds(19, 114, 77, 14);
	    getContentPane().add(lblNewLabel_3_1);
	    
	    JLabel lblNewLabel_3_1_1 = new JLabel("Confirmar");
	    lblNewLabel_3_1_1.setBounds(19, 139, 77, 14);
	    getContentPane().add(lblNewLabel_3_1_1);
	    
	    JLabel lblNewLabel_3_1_2 = new JLabel("contraseña:");
	    lblNewLabel_3_1_2.setBounds(19, 154, 77, 14);
	    getContentPane().add(lblNewLabel_3_1_2);
	    
	    textField = new JTextField();
	    textField.setColumns(10);
	    textField.setBounds(93, 77, 79, 20);
	    getContentPane().add(textField);
	    
	    textFieldContra1 = new JPasswordField();
	    textFieldContra1.setBounds(93, 114, 79, 20);
	    getContentPane().add(textFieldContra1);
	    
	    textFieldContra2 = new JPasswordField();
	    textFieldContra2.setBounds(93, 146, 79, 20);
	    getContentPane().add(textFieldContra2);
	    
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cmdAltaDeUsuarioActionPerformed(e);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}); 
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
                setVisible(false);
			}
		});
		
	}
	protected void cmdAltaDeUsuarioActionPerformed(ActionEvent e) throws IOException {
		String nickname = this.textField.getText();
		String nombre = this.textFieldNombre.getText();
		String apellido = this.textFieldApellido.getText();
		String email = this.textFieldEmail.getText();
		char[] contra1char = this.textFieldContra1.getPassword();
		char[] contra2char = this.textFieldContra2.getPassword();
		String contra1 = new String(contra1char);
		String contra2 = new String(contra2char);
    	String selectedOption = (String) seleccionTipoUsuario.getSelectedItem();
    	String descripcion = this.textAreaDescripcion.getText();
    	String web = this.textFieldLink.getText();
    	Date nacimiento = (Date) spinnerNacimiento.getValue();
    	String nacionalidad = this.textFieldNacionalidad.getText();
    	Instant instant = nacimiento.toInstant();
    	LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
    	
    	if (verificarFormularioUsuario()) {
    	    try {
    	    	if(contra1.equals(contra2)) {
    	    		cargarDatos cargador = new cargarDatos();
    	    		byte[] fotoPredeterminada = cargador.getFile("userImage.jpg");
	    	        if (selectedOption.equals("Empresa")) {
	    	            ICU.altaUsuarioEmpresa(nickname, nombre, apellido, email, descripcion, web,fotoPredeterminada,contra1);
	    	            JOptionPane.showMessageDialog(this, "La empresa se dio de alta con exito", "Alta de Usuario", JOptionPane.INFORMATION_MESSAGE);
	    	            limpiarFormulario();
	                    setVisible(false);
	    	        } else if (selectedOption.equals("Postulante")) {
	    	            ICU.altaUsuarioPostulante(nickname, nombre, apellido, email, localDate, nacionalidad,fotoPredeterminada,contra1);
	    	            JOptionPane.showMessageDialog(this, "El usuario se dio de alta con exito", "Alta de Usuario", JOptionPane.INFORMATION_MESSAGE);
	    	            limpiarFormulario();
	                    setVisible(false);
	    	        }
    	    	}else{
    	    		throw new ContraseniaDiferenteException("Las contraseñas ingresadas no coinciden.");
    	    	}
    	    } catch (NicknameYaExisteException |EmailYaExisteException |campoInvalidoException |ContraseniaDiferenteException e2) {
    	        // Manejar la excepción NicknameYaExisteException aquí
    	        JOptionPane.showMessageDialog(this, e2.getMessage(), "Alta de Usuario", JOptionPane.ERROR_MESSAGE);
    	    } 
    	    }
    	}

	
	private boolean verificarFormularioUsuario() {
		String nickname = this.textField.getText();
		String nombre = this.textFieldNombre.getText();
		String apellido = this.textFieldApellido.getText();
		String email = this.textFieldEmail.getText();
		String selectedOption1 = (String) seleccionTipoUsuario.getSelectedItem();
		
		if (nickname.isEmpty() || nombre.isEmpty() || apellido.isEmpty( ) ||email.isEmpty() ||selectedOption1.equals("Seleccione tipo usuario...") ) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos y debe seleccionar empresa o postulante", "ATENCION!!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
		String selectedOption = (String) seleccionTipoUsuario.getSelectedItem();
    	if (selectedOption.equals("Empresa")) {
    		String descripcion = this.textAreaDescripcion.getText();
    		//String web = this.textFieldLink.getText(); LA WEB NO ES OBLIGATORIA
    		if (descripcion.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "ATENCION!!",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else if (selectedOption.equals("Postulante")) {
    		String nacionalidad = this.textFieldNacionalidad.getText();
    		if (nacionalidad.isEmpty()) { 
                JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "ATENCION!!",
                        JOptionPane.ERROR_MESSAGE);
                return false;
    		}
        }
		
		return true;
	}
	
	public void limpiarFormulario() {
		this.seleccionTipoUsuario.setSelectedItem(arreglo[0]);
		this.textField.setText("");
		this.textFieldContra1.setText("");
		this.textFieldNombre.setText("");
		this.textFieldApellido.setText("");
		this.textFieldEmail.setText("");
		this.textFieldContra1.setText("");
		this.textFieldContra2.setText("");
    	this.textAreaDescripcion.setText("");
    	this.textFieldLink.setText("");
    	this.textFieldNacionalidad.setText("");
	}
}
