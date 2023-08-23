package presentacion;

import java.awt.EventQueue;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JInternalFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class AltaDeTipoDePublicacionDeOfertaLaboral extends JInternalFrame {
	private JTextField txtIngreseTexto;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaDeTipoDePublicacionDeOfertaLaboral frame = new AltaDeTipoDePublicacionDeOfertaLaboral();
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
	public AltaDeTipoDePublicacionDeOfertaLaboral() {
		setBounds(100, 100, 452, 307);
		setIconifiable(true);
		setClosable(true);
		setMaximizable(true);
		getContentPane().setLayout(null);
		
		txtIngreseTexto = new JTextField();
		txtIngreseTexto.setBounds(173, 13, 230, 20);
		getContentPane().add(txtIngreseTexto);
		txtIngreseTexto.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Descripcion :");
		lblNewLabel_1.setBounds(10, 56, 70, 24);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Induque la exposicion en formato ");
		lblNewLabel_1_1.setBounds(10, 99, 165, 31);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Duracion de la publicacion ");
		lblNewLabel_1_2.setBounds(238, 106, 165, 24);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("porcentual :");
		lblNewLabel_1_1_1.setBounds(61, 127, 57, 24);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nombre del tipo de publicacion :");
		lblNewLabel_1_3.setBounds(10, 11, 165, 24);
		getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Costo : $");
		lblNewLabel_1_1_1_1.setBounds(10, 184, 70, 43);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(90, 50, 313, 38);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 100, 1));
		spinner.setBounds(128, 130, 68, 20);
		getContentPane().add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(375, 117, 30, 20);
		getContentPane().add(spinner_1);
		
		JLabel lblNewLabel = new JLabel("(en dias) :");
		lblNewLabel.setBounds(275, 132, 70, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha de alta :");
		lblNewLabel_3.setBounds(185, 184, 70, 24);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(225, 236, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra el JFrame actual
            }
        });

		
		btnCancelar.setBounds(335, 236, 89, 23);
		getContentPane().add(btnCancelar);
		
		JSpinner spinner_4_1 = new JSpinner();
		spinner_4_1.setBounds(286, 187, 68, 20);
		getContentPane().add(spinner_4_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(61, 196, 70, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
	}
}
