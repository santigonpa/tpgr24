package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;

public class PostulacionAOfertaLaboral extends JInternalFrame {
	private JTextField txtCiudad;
	private JTextField txtDepartamento;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PostulacionAOfertaLaboral frame = new PostulacionAOfertaLaboral();
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
	public PostulacionAOfertaLaboral() {
		setClosable(true);
		setTitle("Postulacion a Oferta Laboral");
		setBounds(100, 100, 710, 665);
		
		JLabel txtEmpresa = new JLabel("Empresa:");
		
		JComboBox<String> seleccionDeEmpresa = new JComboBox<>();
		seleccionDeEmpresa.setModel(new DefaultComboBoxModel<>(new String[] {"Seleccione una empresa", "MCDonalds", "BurguerKing"}));
		
		JLabel txtOferta = new JLabel("Oferta laboral:");
		
		JComboBox<String> seleccionDeOfertaLaboral = new JComboBox<>();
		seleccionDeOfertaLaboral.setModel(new DefaultComboBoxModel<>(new String[] {"Seleccione una oferta laboral", "Oferta 1", "Oferta 2"}));
		
		JLabel txtDatosOferta = new JLabel("Datos de la oferta laboral");
		
		JLabel txtDescripcionOferta = new JLabel("Descripcion:");
		
		JScrollPane scrollPaneDescripcion = new JScrollPane();
		
		JLabel txtCiudadOferta = new JLabel("Ciudad:");
		
		txtCiudad = new JTextField();
		txtCiudad.setEditable(false);
		txtCiudad.setColumns(10);
		
		JLabel txtDepartamentoOferta = new JLabel("Departamento:");
		
		txtDepartamento = new JTextField();
		txtDepartamento.setEditable(false);
		txtDepartamento.setColumns(10);
		
		JLabel txtRemuneracion = new JLabel("Remuneracion:");
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		
		JLabel txtFechaAlta = new JLabel("Fecha del alta de la oferta:");
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		
		JLabel txtHorarios = new JLabel("Horarios:");
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel txtPostulante = new JLabel("Postulante:");
		
		JComboBox<String> comboBoxPostulantes = new JComboBox<>();
		comboBoxPostulantes.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccione un/a postulante", "Juan", "Juana", "Juane", "Juani"}));
		
		JLabel txtDatosPostulante = new JLabel("Ingreso de datos del postulante");
		
		JLabel txtCVReducido = new JLabel("CV reducido:");
		
		JScrollPane scrollPaneCVReducido = new JScrollPane();
		
		JLabel txtMotivacion = new JLabel("Motivacion:");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JButton btnCancelar = new JButton("Cancelar");
		
		JButton btnAceptar = new JButton("Aceptar");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtDatosOferta))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createSequentialGroup()
										.addContainerGap()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(txtEmpresa)
											.addComponent(txtOferta))
										.addGap(62))
									.addGroup(groupLayout.createSequentialGroup()
										.addGap(63)
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(txtDescripcionOferta)
											.addComponent(txtCiudadOferta, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
											.addComponent(txtRemuneracion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(txtHorarios, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.RELATED, 8, GroupLayout.PREFERRED_SIZE)))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(txtPostulante)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(txtCiudad, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtDepartamentoOferta, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
									.addComponent(txtDepartamento, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
								.addComponent(scrollPaneDescripcion, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 524, Short.MAX_VALUE)
								.addComponent(seleccionDeOfertaLaboral, Alignment.TRAILING, 0, 524, Short.MAX_VALUE)
								.addComponent(seleccionDeEmpresa, Alignment.TRAILING, 0, 524, Short.MAX_VALUE)
								.addComponent(comboBoxPostulantes, 0, 524, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(scrollPane, Alignment.LEADING)
										.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
									.addGap(18)
									.addComponent(txtFechaAlta)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtDatosPostulante))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(65)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtMotivacion, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(txtCVReducido)
									.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
									.addComponent(scrollPaneCVReducido, GroupLayout.PREFERRED_SIZE, 524, GroupLayout.PREFERRED_SIZE))))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap(484, Short.MAX_VALUE)
							.addComponent(btnAceptar)
							.addGap(18)
							.addComponent(btnCancelar)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtEmpresa)
						.addComponent(seleccionDeEmpresa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtOferta)
						.addComponent(seleccionDeOfertaLaboral, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(txtDatosOferta)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtDescripcionOferta)
						.addComponent(scrollPaneDescripcion, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCiudadOferta)
						.addComponent(txtCiudad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDepartamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDepartamentoOferta))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtRemuneracion)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFechaAlta)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtHorarios)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxPostulantes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPostulante))
					.addGap(18)
					.addComponent(txtDatosPostulante)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtCVReducido)
						.addComponent(scrollPaneCVReducido, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(14)
							.addComponent(txtMotivacion))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnAceptar))
					.addContainerGap())
		);
		
		JTextArea textAreaCVReducido = new JTextArea();
		scrollPaneCVReducido.setViewportView(textAreaCVReducido);
		
		JList <String> listaHorarios = new JList<>();
		listaHorarios.setModel(new AbstractListModel<>() {
			String[] values = new String[] {"Lunes:", "Martes:", "Miércoles:", "Jueves:", "Viernes:", "Sábado:", "Domingo:"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		listaHorarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaHorarios.setEnabled(false);
		scrollPane.setViewportView(listaHorarios);
		
		JTextArea textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setEditable(false);
		textAreaDescripcion.setDoubleBuffered(true);
		scrollPaneDescripcion.setViewportView(textAreaDescripcion);
		getContentPane().setLayout(groupLayout);

	}
}
