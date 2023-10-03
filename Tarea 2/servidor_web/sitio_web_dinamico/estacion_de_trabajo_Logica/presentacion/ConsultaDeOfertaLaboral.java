package presentacion;

import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import excepciones.UsuarioNoExisteException;
import logica_Controladores.IControladorOferta;
import logica_Controladores.IControladorUsuario;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.util.Set;
import javax.swing.JButton;

import logica_DataTypes.DataEmpresa;
import logica_DataTypes.DataOferta;
import utils.Fabrica;



public class ConsultaDeOfertaLaboral extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldCiudad;
	private JTextField textFieldDepartamento;
	private JTextField textFieldRemuneracion;
	private JTextField textFieldCosto;
	private JComboBox<DataEmpresa> comboBoxEmpresas;
	private JComboBox<DataOferta> comboBoxOfertas;
	private JTextArea textAreaDescripcion;


	private  IControladorOferta ICO;
	private  IControladorUsuario ICU;
	
	private JTextField textFieldHoraInicio;
	private JTextField textFieldHoraFin;
	private JTextField textFieldFechaDeAlta;
	private JComboBox<String> comboBoxPostulaciones;

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
					ConsultaDeOfertaLaboral frame = new ConsultaDeOfertaLaboral(ICU, ICO);
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
	public ConsultaDeOfertaLaboral(IControladorUsuario Icu,IControladorOferta Ico) {
		ICU = Icu;
		ICO = Ico;
		setIconifiable(true);
		setMaximizable(true);
		setTitle("Consulta de oferta laboral");
		setClosable(true);
		setBounds(50, 50, 500, 456);		
		getContentPane().setLayout(null);
		
		JLabel lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setBounds(10, 10, 65, 13);
		getContentPane().add(lblEmpresa);
		
		comboBoxEmpresas = new JComboBox<DataEmpresa>();
		comboBoxEmpresas.setBounds(83, 6, 389, 21);
		getContentPane().add(comboBoxEmpresas);
		
		comboBoxEmpresas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	DataEmpresa selectedEmpresa = (DataEmpresa)comboBoxEmpresas.getSelectedItem();
            
            	DefaultComboBoxModel<DataOferta> model = new DefaultComboBoxModel<>();
        		try {
        		Set<DataOferta> ofertas = ICU.getDataOfertasDeEmpresa(selectedEmpresa.getNickName());
        		
        	    if (ofertas!= null) {
	        	    for (DataOferta oferta : ofertas) {
	        	        model.addElement(oferta);
        	    }
        	    comboBoxOfertas.setModel(model);}
        	    else {throw new Exception("No tiene ofertas laborales");}
        		}catch(Exception e22) {}
            }
		});
		
		comboBoxOfertas = new JComboBox<DataOferta>();
		comboBoxOfertas.setBounds(83, 38, 389, 21);
		getContentPane().add(comboBoxOfertas);
			
		comboBoxOfertas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e1) {
            	DataOferta selectedOferta = (DataOferta)comboBoxOfertas.getSelectedItem();
            	if (selectedOferta != null) {
            	textAreaDescripcion.setText(selectedOferta.getDescripcion());
            	textFieldCosto.setText(String.valueOf(selectedOferta.getCostoDeOfertaLaboral()));
            	textFieldRemuneracion.setText(String.valueOf(selectedOferta.getRemuneracion()));
            	textFieldCiudad.setText(selectedOferta.getCiudad());
            	textFieldDepartamento.setText(selectedOferta.getDepartamento());

            	textFieldHoraFin.setText(selectedOferta.getHoraFinString());
            	textFieldHoraInicio.setText(selectedOferta.getHoraInicioString());
            	textFieldFechaDeAlta.setText(selectedOferta.getFechaAltaComoString());
            	
            	DefaultComboBoxModel<String> model3 = new DefaultComboBoxModel<>();
            	Set<String> postulantes = ICO.getPostulantesString(selectedOferta.getNombre());
            	for(String postulante : postulantes) {
            		model3.addElement(postulante);	
            	}
            	comboBoxPostulaciones.setModel(model3);         	    	
            	}
            }
		
		});
		
		JLabel lblOferta = new JLabel("Oferta:");
		lblOferta.setBounds(10, 42, 65, 13);
		getContentPane().add(lblOferta);
		
		JLabel lblInfoOferta = new JLabel("Informacion de la oferta laboral");
		lblInfoOferta.setBounds(186, 88, 208, 13);
		getContentPane().add(lblInfoOferta);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(10, 111, 84, 13);
		getContentPane().add(lblDescripcion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(104, 111, 368, 64);
		getContentPane().add(scrollPane);
		
		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setEditable(false);
		scrollPane.setViewportView(textAreaDescripcion);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(10, 194, 84, 13);
		getContentPane().add(lblCiudad);
		
		JLabel lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setBounds(247, 194, 107, 13);
		getContentPane().add(lblDepartamento);
		
		textFieldCiudad = new JTextField();
		textFieldCiudad.setEditable(false);
		textFieldCiudad.setBounds(104, 191, 120, 19);
		getContentPane().add(textFieldCiudad);
		textFieldCiudad.setColumns(10);
		
		textFieldDepartamento = new JTextField();
		textFieldDepartamento.setEditable(false);
		textFieldDepartamento.setColumns(10);
		textFieldDepartamento.setBounds(352, 190, 120, 19);
		getContentPane().add(textFieldDepartamento);
		
		JLabel lblHoraInicio = new JLabel("Hora inicio:");
		lblHoraInicio.setBounds(10, 232, 84, 13);
		getContentPane().add(lblHoraInicio);
		
		JLabel lblHoraFin = new JLabel("Hora fin");
		lblHoraFin.setBounds(257, 232, 89, 13);
		getContentPane().add(lblHoraFin);	
		
		JLabel lblRemuneracion = new JLabel("Remuneracion:");
		lblRemuneracion.setBounds(10, 273, 107, 13);
		getContentPane().add(lblRemuneracion);
		
		JLabel lblCosto = new JLabel("Costo:");
		lblCosto.setBounds(257, 273, 84, 13);
		getContentPane().add(lblCosto);
		
		textFieldRemuneracion = new JTextField();
		textFieldRemuneracion.setEditable(false);
		textFieldRemuneracion.setColumns(10);
		textFieldRemuneracion.setBounds(104, 270, 120, 19);
		getContentPane().add(textFieldRemuneracion);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setEditable(false);
		textFieldCosto.setColumns(10);
		textFieldCosto.setBounds(352, 269, 120, 19);
		getContentPane().add(textFieldCosto);
		
		JLabel lblFechaDeAlta = new JLabel("Fecha de alta:");
		lblFechaDeAlta.setBounds(10, 312, 84, 13);
		getContentPane().add(lblFechaDeAlta);
		
		
		JLabel lblPostulaciones = new JLabel("Postulaciones:");
		lblPostulaciones.setBounds(10, 355, 99, 13);
		getContentPane().add(lblPostulaciones);
		
		comboBoxPostulaciones = new JComboBox<>();
		comboBoxPostulaciones.setBounds(104, 351, 368, 21);
		getContentPane().add(comboBoxPostulaciones);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		
		btnSalir.setBounds(285, 396, 85, 21);
		getContentPane().add(btnSalir);
		
		textFieldHoraInicio = new JTextField();
		textFieldHoraInicio.setEditable(false);
		textFieldHoraInicio.setColumns(10);
		textFieldHoraInicio.setBounds(104, 227, 120, 19);
		getContentPane().add(textFieldHoraInicio);
		
		textFieldHoraFin = new JTextField();
		textFieldHoraFin.setEditable(false);
		textFieldHoraFin.setColumns(10);
		textFieldHoraFin.setBounds(352, 228, 120, 19);
		getContentPane().add(textFieldHoraFin);
		
		textFieldFechaDeAlta = new JTextField();
		textFieldFechaDeAlta.setEditable(false);
		textFieldFechaDeAlta.setColumns(10);
		textFieldFechaDeAlta.setBounds(104, 307, 120, 19);
		getContentPane().add(textFieldFechaDeAlta);
	}
	
	public void cargarEmpresas() {
		DefaultComboBoxModel<DataEmpresa> model1 = new DefaultComboBoxModel<>();
		try {
		Set<DataEmpresa> empresas = ICU.getDataEmpresa();
		
	    
	    // Agregar las empresas al modelo del JComboBox
	    for (DataEmpresa empresa : empresas) {
	        model1.addElement(empresa);
	    }
	    
	    // Establecer el modelo en el JComboBox
	    comboBoxEmpresas.setModel(model1);
		}catch(UsuarioNoExisteException e) {}
	}
	public void limpiarFormulario() {
		textAreaDescripcion.setText("");
		textFieldCiudad.setText("");
		textFieldDepartamento.setText("");
		textFieldHoraInicio.setText("");
		textFieldHoraFin.setText("");
		textFieldRemuneracion.setText("");
		textFieldCosto.setText("");
		textFieldFechaDeAlta.setText("");
		comboBoxPostulaciones.setSelectedIndex(-1);
	}
	
	public void asignarValoresConsultaDeUsuario(DataEmpresa emp, DataOferta of) {
		DefaultComboBoxModel<DataEmpresa> model1 = new DefaultComboBoxModel<>();
		model1.addElement(emp);
		comboBoxEmpresas.setModel(model1);
		
		comboBoxEmpresas.setSelectedItem(emp); // Establecer el valor deseado
       // comboBoxEmpresas.setEnabled(false); // Desactivar el JComboBox
        comboBoxOfertas.setSelectedItem(of.getNombre());
        //comboBoxOfertas.setEnabled(false);
        
        textAreaDescripcion.setText(of.getDescripcion());
    	textFieldCosto.setText(String.valueOf(of.getCostoDeOfertaLaboral()));
    	textFieldRemuneracion.setText(String.valueOf(of.getRemuneracion()));
    	textFieldCiudad.setText(of.getCiudad());
    	textFieldDepartamento.setText(of.getDepartamento());
    	
    	
    	

    	
    	textFieldHoraFin.setText(of.getHoraFinString());
    	textFieldHoraInicio.setText(of.getHoraInicioString());
    	textFieldFechaDeAlta.setText(of.getFechaAltaComoString());
    	
    	DefaultComboBoxModel<String> model3 = new DefaultComboBoxModel<>();
    	Set<String> postulantes = ICO.getPostulantesString(of.getNombre());
    	for(String postulante : postulantes) {
    		model3.addElement(postulante);	
    	}
    	comboBoxPostulaciones.setModel(model3);         	    	
    }
	
        
        
	
}