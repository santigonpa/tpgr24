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

public class ConsultaDeOfertaLaboral extends JInternalFrame {
	private final JTextField textField = new JTextField();
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

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

	/**
	 * Create the frame.
	 */
	public ConsultaDeOfertaLaboral() {
		setIconifiable(true);
		setMaximizable(true);
		setTitle("Consulta de oferta laboral");
		setClosable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("49px"),
				ColumnSpec.decode("93px:grow"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("96px:grow"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("42px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("96px:grow"),},
			new RowSpec[] {
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		JLabel lblNewLabel_1 = new JLabel("Tipo de publicación");
		getContentPane().add(lblNewLabel_1, "2, 2, left, center");
		
		textField_1 = new JTextField();
		getContentPane().add(textField_1, "4, 2, left, top");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Empresa");
		getContentPane().add(lblNewLabel, "5, 2, 3, 1, right, center");
		textField.setText("");
		getContentPane().add(textField, "8, 2, left, top");
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		getContentPane().add(lblNewLabel_2, "2, 4, right, default");
		
		textField_2 = new JTextField();
		getContentPane().add(textField_2, "4, 4, left, default");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Horario");
		getContentPane().add(lblNewLabel_3, "6, 4, right, default");
		
		textField_3 = new JTextField();
		getContentPane().add(textField_3, "8, 4, left, default");
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Remuneración UYU$");
		getContentPane().add(lblNewLabel_1_1, "1, 6, 2, 1, right, default");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		getContentPane().add(textField_4, "4, 6, left, default");
		
		JLabel lblNewLabel_1_2 = new JLabel("Ciudad");
		getContentPane().add(lblNewLabel_1_2, "6, 6, right, default");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		getContentPane().add(textField_5, "8, 6, left, default");
		
		JLabel lblNewLabel_2_1 = new JLabel("Departamento");
		getContentPane().add(lblNewLabel_2_1, "2, 8, right, default");
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		getContentPane().add(textField_8, "4, 8, left, default");
		
		JLabel lblNewLabel_2_2 = new JLabel("Nombre");
		getContentPane().add(lblNewLabel_2_2, "6, 8, right, default");
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		getContentPane().add(textField_6, "8, 8, left, default");
		
		JLabel lblNewLabel_2_3 = new JLabel("Fecha de Alta");
		getContentPane().add(lblNewLabel_2_3, "2, 10, right, default");
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		getContentPane().add(textField_9, "4, 10, left, default");
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Keywords");
		getContentPane().add(lblNewLabel_2_3_1, "6, 10, 2, 1, right, default");
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		getContentPane().add(textField_7, "8, 10, left, default");
		
		JLabel lblNewLabel_4 = new JLabel("Descripción");
		getContentPane().add(lblNewLabel_4, "2, 14");
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		getContentPane().add(textArea, "2, 16, 3, 3, fill, fill");

	}

}
