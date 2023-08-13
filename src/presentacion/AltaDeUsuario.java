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
import javax.swing.SwingConstants;
import javax.swing.text.JTextComponent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JSpinner;
import java.awt.Color;
import java.awt.SystemColor;

public class AltaDeUsuario extends JInternalFrame{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField nacionalidad;
	private JTextField descripcion;
	private JTextField link;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaDeUsuario frame = new AltaDeUsuario();
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
	public AltaDeUsuario() {
		setTitle("Alta de usuario");
		setBounds(100, 100, 450, 300);
		setResizable(true);
	    setIconifiable(true);
	    setMaximizable(true);
	    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    setClosable(true);
	    getContentPane().setLayout(new MigLayout("", "[0.00px,grow,left][20.00px,grow,left][][][grow][grow][20.00px,grow,left][20.00px,grow,left][70.00px,grow,left][86.00px,grow,left][70.00px,grow][grow][grow]", "[30.00][30][30][30px][2px,grow][3px,grow][10px,grow][]"));
	    
	    JLabel lblNewLabel = new JLabel("Tipo de usuario :");
	    getContentPane().add(lblNewLabel, "cell 0 0 7 1,growx");
	    
	    String [] opcionesU = {"Empresa", "Postulante"};
	    JComboBox seleccionTipoUsuario = new JComboBox(opcionesU);
	    seleccionTipoUsuario.setModel(new DefaultComboBoxModel(new String[] {"Seleccionar", "Empresa", "Postulante"}));
	    getContentPane().add(seleccionTipoUsuario, "cell 7 0 6 1,growx");
	    seleccionTipoUsuario.setSelectedItem(null);
	    	    
	    
	    JLabel lblNewLabel_1 = new JLabel("Nombre :");
	    getContentPane().add(lblNewLabel_1, "cell 0 1 3 1,alignx center");
	    
	    textField = new JTextField();
	    getContentPane().add(textField, "cell 3 1 5 1,growx");
	    textField.setColumns(10);
	    
	    JLabel lblNewLabel_2 = new JLabel("Apellido :");
	    getContentPane().add(lblNewLabel_2, "cell 8 1,alignx center");
	    
	    textField_1 = new JTextField();
	    getContentPane().add(textField_1, "cell 9 1 4 1,growx");
	    textField_1.setColumns(10);
	    
	    JLabel lblNewLabel_3 = new JLabel("   Nickname :");
	    getContentPane().add(lblNewLabel_3, "cell 0 2 3 1,alignx center");
	    
	    textField_2 = new JTextField();
	    getContentPane().add(textField_2, "cell 3 2 5 1,growx");
	    textField_2.setColumns(10);
	    
	    JLabel lblNewLabel_4 = new JLabel("Email :");
	    getContentPane().add(lblNewLabel_4, "cell 8 2,alignx center");
		  
	    textField_3 = new JTextField();
	    getContentPane().add(textField_3, "cell 9 2 4 1,growx");
	    textField_3.setColumns(10);
	    
	    JLabel lblNewLabel_5 = new JLabel("       Fecha de nacimiento :");
	    getContentPane().add(lblNewLabel_5, "cell 0 3 7 1");
	    
	    JLabel lblNewLabel_6 = new JLabel("Nacionalidad :");
	    getContentPane().add(lblNewLabel_6, "cell 8 3,alignx trailing");
	    
	    //Escritura de la nacionalidad 
	    
	    nacionalidad = new JTextField();
	    getContentPane().add(nacionalidad, "cell 9 3 4 1,growx");
	    nacionalidad.setColumns(10);
	    
	    if(seleccion == "Empresa") {
	    	System.out.println("Empresa\n");
	    	nacionalidad.setEnabled(true);
	    }else if(seleccion == "Postulante"){
	    	System.out.println("Postulante");
	    }else {
	    	System.out.println("No funciona");
	    }
	    
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
	    
	    descripcion = new JTextField();
	    getContentPane().add(descripcion, "cell 4 5 8 1,growx");
	    descripcion.setColumns(10);
	    
	    JLabel lblNewLabel_8 = new JLabel("    Link :");
	    getContentPane().add(lblNewLabel_8, "cell 1 6 2 1");
	    
	    link = new JTextField();
	    getContentPane().add(link, "cell 4 6 8 1,growx");
	    link.setColumns(10);
	    
	    seleccionTipoUsuario.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		if(seleccionTipoUsuario.getSelectedItem().equals("Empresa")) {
	    			
	    		}
	    	}
	    });
	    
	    JButton btnNewButton_1 = new JButton("Aceptar");
	    btnNewButton_1.setForeground(SystemColor.windowText);
	    getContentPane().add(btnNewButton_1, "cell 9 7");
	    
	    JButton btnNewButton_2 = new JButton("Cancelar");
	    getContentPane().add(btnNewButton_2, "cell 10 7");
	    
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		}); 
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
	}

	
}
