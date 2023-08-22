package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import utils.Fabrica;

import javax.swing.SwingConstants;
import javax.swing.text.JTextComponent;

import excepciones.NombreRepetidoOfertaException;
import logica_Controladores.IControladorOferta;
import logica_Controladores.IControladorUsuario;
import excepciones.NicknameYaExisteException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.awt.event.ItemEvent;


public class AltaDeUsuario extends JInternalFrame{
	
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
	private JComboBox seleccionTipoUsuario;

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
	    getContentPane().setLayout(new MigLayout("", "[0.00px,grow,left][20.00px,grow,left][][][grow][grow][20.00px,grow,left][20.00px,grow,left][70.00px,grow,left][86.00px,grow,left][70.00px,grow][grow][grow]", "[30.00][30][30][30px][2px,grow][3px,grow][10px,grow][]"));
	    
	    JLabel lblNewLabel_5 = new JLabel("       Fecha de nacimiento :");
	    getContentPane().add(lblNewLabel_5, "cell 0 3 7 1");
	    
	    JLabel lblNewLabel_6 = new JLabel("Nacionalidad :");
	    getContentPane().add(lblNewLabel_6, "cell 8 3,alignx trailing");
	    
	    textFieldNacionalidad = new JTextField();
	    getContentPane().add(textFieldNacionalidad, "cell 9 3 4 1,growx");
	    textFieldNacionalidad.setColumns(10);
	    
	    
	    JList list = new JList();
	    getContentPane().add(list, "cell 0 4,grow");
	    
	    //Seleccion de numeros fecha de nacimiento
	    
	    JSpinner dia = new JSpinner();
	    getContentPane().add(dia, "cell 2 4");
	    
	    JSpinner mes = new JSpinner();
	    getContentPane().add(mes, "cell 3 4");
	    
	    JSpinner anio = new JSpinner();
	    getContentPane().add(anio, "cell 4 4");
	    
	    
	    JLabel lblNewLabel_7 = new JLabel("   Descripción : ");
	    getContentPane().add(lblNewLabel_7, "cell 1 5 3 1");
	    
	    textFieldDescripcion = new JTextField();
	    getContentPane().add(textFieldDescripcion, "cell 4 5 8 1,growx");
	    textFieldDescripcion.setColumns(10);
	    
	    JLabel lblNewLabel_8 = new JLabel("    Link :");
	    getContentPane().add(lblNewLabel_8, "cell 1 6 2 1");
	    
	    textFieldLink = new JTextField();
	    getContentPane().add(textFieldLink, "cell 4 6 8 1,growx");
	    textFieldLink.setColumns(10);
	    
		
	    JComboBox<String> seleccionTipoUsuario = new JComboBox<>();
	    seleccionTipoUsuario.setModel(new DefaultComboBoxModel(new String[] {"Seleccione tipo usuario...", "Empresa", "Postulante"}));
	    getContentPane().add(seleccionTipoUsuario, "cell 7 0 6 1,growx");
	    seleccionTipoUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String selectedOption = (String) seleccionTipoUsuario.getSelectedItem();
                if (selectedOption.equals("Empresa")) {
                	textFieldLink.setEditable(true);
                    textFieldDescripcion.setEditable(true);
                	textFieldNacionalidad.setEditable(false);
                    dia.setEnabled(false);
                    mes.setEnabled(false);
                    anio.setEnabled(false);
                } else if (selectedOption.equals("Postulante")) {
                	textFieldNacionalidad.setEditable(true);
                    dia.setEnabled(true);
                    mes.setEnabled(true);
                    anio.setEnabled(true);
                	textFieldLink.setEditable(false);
                    textFieldDescripcion.setEditable(false);
                }
            }
        });
	    
	    JLabel lblNewLabel = new JLabel("Tipo de usuario :");
	    getContentPane().add(lblNewLabel, "cell 0 0 7 1,growx");
	    
	    	    
	    JLabel lblNewLabel_1 = new JLabel("Nombre :");
	    getContentPane().add(lblNewLabel_1, "cell 0 1 3 1,alignx center");
	    
	    textFieldNombre = new JTextField();
	    getContentPane().add(textFieldNombre, "cell 3 1 5 1,growx");
	    textFieldNombre.setColumns(10);
	    
	    JLabel lblNewLabel_2 = new JLabel("Apellido :");
	    getContentPane().add(lblNewLabel_2, "cell 8 1,alignx center");
	    
	    textFieldApellido = new JTextField();
	    getContentPane().add(textFieldApellido, "cell 9 1 4 1,growx");
	    textFieldApellido.setColumns(10);
	    
	    JLabel lblNewLabel_3 = new JLabel("   Nickname :");
	    getContentPane().add(lblNewLabel_3, "cell 0 2 3 1,alignx center");
	    
	    textFieldNickname = new JTextField();
	    getContentPane().add(textFieldNickname, "cell 3 2 5 1,growx");
	    textFieldNickname.setColumns(10);
	    
	    JLabel lblNewLabel_4 = new JLabel("Email :");
	    getContentPane().add(lblNewLabel_4, "cell 8 2,alignx center");
		  
	    textFieldEmail = new JTextField();
	    getContentPane().add(textFieldEmail, "cell 9 2 4 1,growx");
	    textFieldEmail.setColumns(10);
	    
	    
	    JButton btnNewButton_1 = new JButton("Aceptar");
	    btnNewButton_1.setForeground(SystemColor.windowText);
	    getContentPane().add(btnNewButton_1, "cell 9 7");
	    
	    JButton btnNewButton_2 = new JButton("Cancelar");
	    getContentPane().add(btnNewButton_2, "cell 10 7");
	    
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
        //falta la fecha...
    	String nacionalidad = this.textFieldNacionalidad.getText();
        
    	
    	if (verificarFormularioUsuario()) {
    		try {
    	    	if (selectedOption.equals("Empresa")) {
    	    		//operacion de alta
        			ICO.altaUsuario(nickname,nombre, apellido, email, descripcion, web);
        			
        			// muestro éxito de la operación
                    JOptionPane.showMessageDialog(this, "La empresa se dio de alta con exito", "Alta de Usuario",
                            JOptionPane.INFORMATION_MESSAGE);
    	    	}else if (selectedOption.equals("Postulante")) {
    	    		ICO.altaUsuario(nickname,nombre, apellido, email, nacimiento, web);
    	    		
    	    		 JOptionPane.showMessageDialog(this, "El usuario se dio de alta con exito", "Alta de Usuario",
                             JOptionPane.INFORMATION_MESSAGE);
    	    	}
    		}catch (NicknameYaExisteException e2) {
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
