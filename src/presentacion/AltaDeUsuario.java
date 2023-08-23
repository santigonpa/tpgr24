package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import javax.swing.JComboBox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import logica_Controladores.IControladorOferta;
import logica_Controladores.IControladorUsuario;
import excepciones.NicknameYaExisteException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import java.awt.SystemColor;
import java.util.Calendar;
import java.util.Date;


public class AltaDeUsuario extends JInternalFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// interfaz de oferta
	private static IControladorOferta ICO;
	private static IControladorUsuario ICU;
	
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldNickname;
	private JTextField textFieldEmail;
	private JTextField textFieldDescripcion;
	private JTextField textFieldLink;
	private JTextField textFieldNacionalidad;
	private JComboBox<String> seleccionTipoUsuario;
	private JSpinner spinnerNacimiento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
	public AltaDeUsuario(IControladorOferta ICO, IControladorUsuario ICU) {

		setTitle("Alta de usuario");
		setBounds(100, 100, 450, 300);
		setResizable(true);
	    setIconifiable(true);
	    setMaximizable(true);
	    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    setClosable(true);
	    getContentPane().setLayout(new MigLayout("", "[0.00px,grow,left][20.00px,grow,left][][][][][grow][][grow][20.00px,grow,left][20.00px,grow,left][70.00px,grow,left][86.00px,grow,left][70.00px,grow][grow][grow]", "[30.00][30][30][30px][][2px,grow][3px,grow][10px,grow][]"));
	    
	    JLabel lblNewLabel_5 = new JLabel("       Fecha de nacimiento :");
	    getContentPane().add(lblNewLabel_5, "cell 0 3 10 1");
	    
	    JLabel lblNewLabel_6 = new JLabel("Nacionalidad :");
	    getContentPane().add(lblNewLabel_6, "cell 11 3,alignx trailing");
	    
	    textFieldNacionalidad = new JTextField();
	    getContentPane().add(textFieldNacionalidad, "cell 12 3 4 1,growx");
	    textFieldNacionalidad.setColumns(10);
	    
	 // Crear un SpinnerDateModel para manejar la fecha
	    Date initialDate = Calendar.getInstance().getTime();
        SpinnerDateModel dateModel = new SpinnerDateModel(initialDate, null, null, Calendar.DAY_OF_MONTH);
	    JSpinner spinnerNacimiento = new JSpinner(dateModel);
	    getContentPane().add(spinnerNacimiento, "cell 3 4 2 1,grow");
	 // Personalizar la apariencia del JSpinner para mostrar solo la fecha
	    JSpinner.DateEditor de_spinnerNacimiento = new JSpinner.DateEditor(spinnerNacimiento, "dd/MM/yyyy");
	    spinnerNacimiento.setEditor(de_spinnerNacimiento);
	    
	    
	    /*JList<Object> list = new JList<Object>();
	    getContentPane().add(list, "cell 0 5,grow");*/
	    
	    
	    JLabel lblNewLabel_7 = new JLabel("   Descripción : ");
	    getContentPane().add(lblNewLabel_7, "cell 1 6 5 1");
	    
	    textFieldDescripcion = new JTextField();
	    getContentPane().add(textFieldDescripcion, "cell 6 6 9 1,growx");
	    textFieldDescripcion.setColumns(10);
	    
	    JLabel lblNewLabel_8 = new JLabel("    Link :");
	    getContentPane().add(lblNewLabel_8, "cell 1 7 4 1");
	    
	    textFieldLink = new JTextField();
	    getContentPane().add(textFieldLink, "cell 6 7 9 1,growx");
	    textFieldLink.setColumns(10);
	    
		
	    JComboBox<String> seleccionTipoUsuario = new JComboBox<String>();
	    seleccionTipoUsuario.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccione tipo usuario...", "Empresa", "Postulante"}));
	    getContentPane().add(seleccionTipoUsuario, "cell 10 0 6 1,growx");
	    seleccionTipoUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String selectedOption = (String) seleccionTipoUsuario.getSelectedItem();
                if (selectedOption.equals("Empresa")) {
                	textFieldLink.setEditable(true);
                    textFieldDescripcion.setEditable(true);
                	textFieldNacionalidad.setEditable(false);
                	spinnerNacimiento.setEnabled(false);
                } else if (selectedOption.equals("Postulante")) {
                	textFieldNacionalidad.setEditable(true);
                	spinnerNacimiento.setEnabled(true);
                	textFieldLink.setEditable(false);
                    textFieldDescripcion.setEditable(false);
                }
            }
        });
	    
	    JLabel lblNewLabel = new JLabel("Tipo de usuario :");
	    getContentPane().add(lblNewLabel, "cell 0 0 10 1,growx");
	    
	    	    
	    JLabel lblNewLabel_1 = new JLabel("Nombre :");
	    getContentPane().add(lblNewLabel_1, "cell 0 1 5 1,alignx center");
	    
	    textFieldNombre = new JTextField();
	    getContentPane().add(textFieldNombre, "cell 5 1 6 1,growx");
	    textFieldNombre.setColumns(10);
	    
	    JLabel lblNewLabel_2 = new JLabel("Apellido :");
	    getContentPane().add(lblNewLabel_2, "cell 11 1,alignx center");
	    
	    textFieldApellido = new JTextField();
	    getContentPane().add(textFieldApellido, "cell 12 1 4 1,growx");
	    textFieldApellido.setColumns(10);
	    
	    JLabel lblNewLabel_3 = new JLabel("   Nickname :");
	    getContentPane().add(lblNewLabel_3, "cell 0 2 5 1,alignx center");
	    
	    textFieldNickname = new JTextField();
	    getContentPane().add(textFieldNickname, "cell 5 2 6 1,growx");
	    textFieldNickname.setColumns(10);
	    
	    JLabel lblNewLabel_4 = new JLabel("Email :");
	    getContentPane().add(lblNewLabel_4, "cell 11 2,alignx center");
		  
	    textFieldEmail = new JTextField();
	    getContentPane().add(textFieldEmail, "cell 12 2 4 1,growx");
	    textFieldEmail.setColumns(10);
	    
	    
	    JButton btnNewButton_1 = new JButton("Aceptar");
	    btnNewButton_1.setForeground(SystemColor.windowText);
	    getContentPane().add(btnNewButton_1, "cell 12 8");
	    
	    JButton btnNewButton_2 = new JButton("Cancelar");
	    getContentPane().add(btnNewButton_2, "cell 13 8");
	    
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmdAltaDeUsuarioActionPerformed(e);
			}
		}); 
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
                setVisible(false);
			}
		});
		
	}
	protected void cmdAltaDeUsuarioActionPerformed(ActionEvent e) {
		String nickname = this.textFieldNickname.getText();
		String nombre = this.textFieldNombre.getText();
		String apellido = this.textFieldApellido.getText();
		String email = this.textFieldEmail.getText();
    	String selectedOption = (String) seleccionTipoUsuario.getSelectedItem();
    	String descripcion = this.textFieldDescripcion.getText();
    	String web = this.textFieldLink.getText();
    	Date nacimiento = (Date) spinnerNacimiento.getValue();
    	String nacionalidad = this.textFieldNacionalidad.getText();
        
    	
    	if (verificarFormularioUsuario()) {
    	    try {
    	        if (selectedOption.equals("Empresa")) {
    	            ICU.altaUsuarioEmpresa(nickname, nombre, apellido, email, descripcion, web);
    	            JOptionPane.showMessageDialog(this, "La empresa se dio de alta con exito", "Alta de Usuario", JOptionPane.INFORMATION_MESSAGE);
    	        } else if (selectedOption.equals("Postulante")) {
    	            ICU.altaUsuarioPostulante(nickname, nombre, apellido, email, nacimiento, nacionalidad);
    	            JOptionPane.showMessageDialog(this, "El usuario se dio de alta con exito", "Alta de Usuario", JOptionPane.INFORMATION_MESSAGE);
    	        }
    	    } catch (NicknameYaExisteException e2) {
    	        // Manejar la excepción NicknameYaExisteException aquí
    	        JOptionPane.showMessageDialog(this, e2.getMessage(), "Alta de Usuario", JOptionPane.ERROR_MESSAGE);
    	    }
    	    }
    	}

	
	private boolean verificarFormularioUsuario() {
		String nickname = this.textFieldNickname.getText();
		String nombre = this.textFieldNombre.getText();
		String apellido = this.textFieldApellido.getText();
		String email = this.textFieldEmail.getText();
		
		if (nickname.isEmpty() || nombre.isEmpty() || apellido.isEmpty( )|| email.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "ATENCION!!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
		String selectedOption = (String) seleccionTipoUsuario.getSelectedItem();
    	if (selectedOption.equals("Empresa")) {
    		String descripcion = this.textFieldDescripcion.getText();
    		String web = this.textFieldLink.getText();
    		if (descripcion.isEmpty() || web.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "ATENCION!!",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } else if (selectedOption.equals("Postulante")) {
        	//falta la fecha...
    		String nacionalidad = this.textFieldNacionalidad.getText();
    		if (nacionalidad.isEmpty()) { //falta condicion si no puso fecha
                JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "ATENCION!!",
                        JOptionPane.ERROR_MESSAGE);
                return false;
    		}
        }
		
		return true;
	}
	
	public void limpiarFormulario() {
		this.textFieldNickname.setText("");
		this.textFieldNombre.setText("");
		this.textFieldApellido.setText("");
		this.textFieldEmail.setText("");
    	this.textFieldDescripcion.setText("");
    	this.textFieldLink.setText("");
    	this.textFieldNacionalidad.setText("");
	}
	
}
