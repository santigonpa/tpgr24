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
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tipo de publicación");
		lblNewLabel_1.setBounds(10, 7, 127, 13);
		getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(163, 4, 86, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Empresa");
		lblNewLabel.setBounds(259, 7, 66, 13);
		getContentPane().add(lblNewLabel);
		textField.setBounds(325, 4, 86, 19);
		textField.setText("");
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setBounds(10, 33, 149, 13);
		getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(163, 30, 86, 19);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Horario");
		lblNewLabel_3.setBounds(259, 33, 62, 13);
		getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(325, 30, 86, 19);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Remuneración UYU$");
		lblNewLabel_1_1.setBounds(10, 58, 149, 13);
		getContentPane().add(lblNewLabel_1_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(163, 55, 86, 19);
		textField_4.setColumns(10);
		getContentPane().add(textField_4);
		
		JLabel lblNewLabel_1_2 = new JLabel("Ciudad");
		lblNewLabel_1_2.setBounds(259, 58, 62, 13);
		getContentPane().add(lblNewLabel_1_2);
		
		textField_5 = new JTextField();
		textField_5.setBounds(325, 55, 86, 19);
		textField_5.setColumns(10);
		getContentPane().add(textField_5);
		
		JLabel lblNewLabel_2_1 = new JLabel("Departamento");
		lblNewLabel_2_1.setBounds(10, 83, 149, 13);
		getContentPane().add(lblNewLabel_2_1);
		
		textField_8 = new JTextField();
		textField_8.setBounds(163, 80, 86, 19);
		textField_8.setColumns(10);
		getContentPane().add(textField_8);
		
		JLabel lblNewLabel_2_2 = new JLabel("Nombre");
		lblNewLabel_2_2.setBounds(259, 83, 62, 13);
		getContentPane().add(lblNewLabel_2_2);
		
		textField_6 = new JTextField();
		textField_6.setBounds(325, 80, 86, 19);
		textField_6.setColumns(10);
		getContentPane().add(textField_6);
		
		JLabel lblNewLabel_2_3 = new JLabel("Fecha de Alta");
		lblNewLabel_2_3.setBounds(10, 108, 149, 13);
		getContentPane().add(lblNewLabel_2_3);
		
		textField_9 = new JTextField();
		textField_9.setBounds(163, 105, 86, 19);
		textField_9.setColumns(10);
		getContentPane().add(textField_9);
		
		JLabel lblNewLabel_2_3_1 = new JLabel("Keywords");
		lblNewLabel_2_3_1.setBounds(259, 108, 66, 13);
		getContentPane().add(lblNewLabel_2_3_1);
		
		textField_7 = new JTextField();
		textField_7.setBounds(325, 105, 86, 19);
		textField_7.setColumns(10);
		getContentPane().add(textField_7);
		
		JLabel lblNewLabel_4 = new JLabel("Descripción");
		lblNewLabel_4.setBounds(49, 160, 110, 13);
		getContentPane().add(lblNewLabel_4);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(49, 179, 226, 54);
		textArea.setWrapStyleWord(true);
		getContentPane().add(textArea);

	}

}
