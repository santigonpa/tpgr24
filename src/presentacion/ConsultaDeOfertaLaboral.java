package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
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
import java.util.Calendar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class ConsultaDeOfertaLaboral extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textFieldRemuneracion;
	private JTextField textFieldCosto;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaDeOfertaLaboral frame = new ConsultaDeOfertaLaboral();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	s/**
	 * Create the frame.
	 */
	public ConsultaDeOfertaLaboral() {
		setIconifiable(true);
		setMaximizable(true);
		setTitle("Consulta de oferta laboral");
		setClosable(true);
		setBounds(50, 50, 392, 456);		
		getContentPane().setLayout(null);
		
		JLabel lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setBounds(10, 10, 65, 13);
		getContentPane().add(lblEmpresa);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una empresa"}));
		comboBox.setBounds(83, 6, 287, 21);
		getContentPane().add(comboBox);
		
		JLabel lblOferta = new JLabel("Oferta:");
		lblOferta.setBounds(10, 42, 65, 13);
		getContentPane().add(lblOferta);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Seleccione una oferta"}));
		comboBox_1.setBounds(83, 38, 287, 21);
		getContentPane().add(comboBox_1);
		
		JLabel lblInfoOferta = new JLabel("Informacion de la oferta laboral");
		lblInfoOferta.setBounds(146, 88, 208, 13);
		getContentPane().add(lblInfoOferta);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(10, 111, 84, 13);
		getContentPane().add(lblDescripcion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(104, 111, 266, 64);
		getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(10, 194, 65, 13);
		getContentPane().add(lblCiudad);
		
		JLabel lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setBounds(189, 194, 107, 13);
		getContentPane().add(lblDepartamento);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(104, 191, 75, 19);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(295, 191, 75, 19);
		getContentPane().add(textField_1);
		
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
		
		JLabel lblNewLabel = new JLabel("Postulaciones:");
		lblNewLabel.setBounds(10, 355, 84, 13);
		getContentPane().add(lblNewLabel);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(104, 351, 266, 21);
		getContentPane().add(comboBox_2);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(285, 396, 85, 21);
		getContentPane().add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(189, 396, 85, 21);
		getContentPane().add(btnAceptar);
	}
}