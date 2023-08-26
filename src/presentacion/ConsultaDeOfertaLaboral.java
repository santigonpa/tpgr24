package presentacion;

import java.awt.EventQueue;


import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import excepciones.NoTieneOfertasException;
import excepciones.UsuarioNoExisteException;
import logica_Controladores.IControladorOferta;
import logica_Controladores.IControladorUsuario;

import javax.swing.JTextArea;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Set;
import java.util.Calendar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import logica_DataTypes.DataEmpresa;
import logica_DataTypes.DataOferta;
import logica_DataTypes.DataPostulante;
import logica_DataTypes.DataUsuario;
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

	private  IControladorOferta ICO;
	private  IControladorUsuario ICU;

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
		setBounds(50, 50, 392, 456);		
		getContentPane().setLayout(null);
		
		JLabel lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setBounds(10, 10, 65, 13);
		getContentPane().add(lblEmpresa);
		
		comboBoxEmpresas = new JComboBox<DataEmpresa>();
		comboBoxEmpresas.setBounds(83, 6, 287, 21);
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
        	    else {throw new NoTieneOfertasException("No tiene ofertas laborales");}
        		}catch(NoTieneOfertasException e22) {}
            }
		});
		
		JLabel lblOferta = new JLabel("Oferta:");
		lblOferta.setBounds(10, 42, 65, 13);
		getContentPane().add(lblOferta);
		
		comboBoxOfertas = new JComboBox<DataOferta>();
		comboBoxOfertas.setBounds(83, 38, 287, 21);
		getContentPane().add(comboBoxOfertas);
		
		JLabel lblInfoOferta = new JLabel("Informacion de la oferta laboral");
		lblInfoOferta.setBounds(146, 88, 208, 13);
		getContentPane().add(lblInfoOferta);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(10, 111, 84, 13);
		getContentPane().add(lblDescripcion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(104, 111, 266, 64);
		getContentPane().add(scrollPane);
		
		JTextArea textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setEditable(false);
		scrollPane.setViewportView(textAreaDescripcion);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(10, 194, 65, 13);
		getContentPane().add(lblCiudad);
		
		JLabel lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setBounds(189, 194, 107, 13);
		getContentPane().add(lblDepartamento);
		
		textFieldCiudad = new JTextField();
		textFieldCiudad.setEditable(false);
		textFieldCiudad.setBounds(104, 191, 75, 19);
		getContentPane().add(textFieldCiudad);
		textFieldCiudad.setColumns(10);
		
		textFieldDepartamento = new JTextField();
		textFieldDepartamento.setEditable(false);
		textFieldDepartamento.setColumns(10);
		textFieldDepartamento.setBounds(295, 191, 75, 19);
		getContentPane().add(textFieldDepartamento);
		
		JLabel lblHoraInicio = new JLabel("Hora inicio:");
		lblHoraInicio.setBounds(10, 232, 65, 13);
		getContentPane().add(lblHoraInicio);
		
		JLabel lblHoraFin = new JLabel("Hora fin");
		lblHoraFin.setBounds(189, 232, 89, 13);
		getContentPane().add(lblHoraFin);
		
		JSpinner spinnerHoraInicio = new JSpinner();
		spinnerHoraInicio.setEnabled(false);
		spinnerHoraInicio.setModel(new SpinnerDateModel(new Date(1693018800000L), null, null, Calendar.HOUR_OF_DAY));
		JSpinner.DateEditor editor1 = new JSpinner.DateEditor(spinnerHoraInicio, "HH:mm");
		spinnerHoraInicio.setEditor(editor1);
		spinnerHoraInicio.setBounds(104, 229, 75, 20);
		getContentPane().add(spinnerHoraInicio);
		
		JSpinner spinnerHoraFin = new JSpinner();
		spinnerHoraFin.setEnabled(false);
		spinnerHoraFin.setModel(new SpinnerDateModel(new Date(1693018800000L), null, null, Calendar.HOUR_OF_DAY));
		JSpinner.DateEditor editor2 = new JSpinner.DateEditor(spinnerHoraFin, "HH:mm");
		spinnerHoraFin.setEditor(editor2);
		spinnerHoraFin.setBounds(295, 229, 75, 20);
		getContentPane().add(spinnerHoraFin);
		
		JLabel lblRemuneracion = new JLabel("Remuneracion:");
		lblRemuneracion.setBounds(10, 273, 107, 13);
		getContentPane().add(lblRemuneracion);
		
		JLabel lblCosto = new JLabel("Costo:");
		lblCosto.setBounds(189, 273, 84, 13);
		getContentPane().add(lblCosto);
		
		textFieldRemuneracion = new JTextField();
		textFieldRemuneracion.setEditable(false);
		textFieldRemuneracion.setColumns(10);
		textFieldRemuneracion.setBounds(104, 270, 75, 19);
		getContentPane().add(textFieldRemuneracion);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setEditable(false);
		textFieldCosto.setColumns(10);
		textFieldCosto.setBounds(295, 270, 75, 19);
		getContentPane().add(textFieldCosto);
		
		JLabel lblFechaDeAlta = new JLabel("Fecha de alta:");
		lblFechaDeAlta.setBounds(10, 312, 84, 13);
		getContentPane().add(lblFechaDeAlta);
		
		JSpinner spinnerFechaAlta = new JSpinner();
		spinnerFechaAlta.setEnabled(false);
		spinnerFechaAlta.setModel(new SpinnerDateModel(new Date(1672542000000L), null, null, Calendar.DAY_OF_YEAR));
		JSpinner.DateEditor editor3 = new JSpinner.DateEditor(spinnerFechaAlta, "dd/MM/yyyy");
		spinnerFechaAlta.setEditor(editor3);
		spinnerFechaAlta.setBounds(104, 309, 75, 20);
		getContentPane().add(spinnerFechaAlta);
		
		JLabel lblPostulaciones = new JLabel("Postulaciones:");
		lblPostulaciones.setBounds(10, 355, 84, 13);
		getContentPane().add(lblPostulaciones);
		
		JComboBox comboBoxPostulaciones = new JComboBox();
		comboBoxPostulaciones.setBounds(104, 351, 266, 21);
		getContentPane().add(comboBoxPostulaciones);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(285, 396, 85, 21);
		getContentPane().add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(189, 396, 85, 21);
		getContentPane().add(btnAceptar);
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
}