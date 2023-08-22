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

public class AltaDeTipoDePublicacionDeOfertaLaboral extends JInternalFrame {
	private JTextField txtIngreseTexto;
	private JTextField textField;

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
		setBounds(100, 100, 450, 300);
		setIconifiable(true);
		setClosable(true);
		setMaximizable(true);
		getContentPane().setLayout(null);
		
		txtIngreseTexto = new JTextField();
		txtIngreseTexto.setBounds(173, 13, 230, 20);
		getContentPane().add(txtIngreseTexto);
		txtIngreseTexto.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("                Descripcion :");
		lblNewLabel_1.setBounds(10, 57, 165, 24);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Induque la exposicion en formato ");
		lblNewLabel_1_1.setBounds(10, 99, 165, 38);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Duracion de la publicacion ");
		lblNewLabel_1_2.setBounds(238, 106, 165, 24);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("porcentual :");
		lblNewLabel_1_1_1.setBounds(61, 127, 165, 24);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nombre del tipo de publicacion :");
		lblNewLabel_1_3.setBounds(10, 11, 165, 24);
		getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Costo :      $");
		lblNewLabel_1_1_1_1.setBounds(10, 171, 165, 51);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(173, 50, 230, 38);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(196, 117, 30, 20);
		getContentPane().add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(375, 117, 30, 20);
		getContentPane().add(spinner_1);
		
		JLabel lblNewLabel = new JLabel("(en dias) :");
		lblNewLabel.setBounds(275, 132, 70, 14);
		getContentPane().add(lblNewLabel);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(77, 186, 30, 20);
		getContentPane().add(spinner_2);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha de alta :");
		lblNewLabel_3.setBounds(159, 161, 91, 24);
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
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(238, 186, 30, 20);
		getContentPane().add(spinner_3);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBounds(308, 186, 30, 20);
		getContentPane().add(spinner_4);
		
		JSpinner spinner_4_1 = new JSpinner();
		spinner_4_1.setBounds(375, 186, 30, 20);
		getContentPane().add(spinner_4_1);
		
		JLabel lblNewLabel_2 = new JLabel("dia :");
		lblNewLabel_2.setBounds(209, 189, 30, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("mes :");
		lblNewLabel_4.setBounds(275, 189, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("anio :");
		lblNewLabel_5.setBounds(346, 189, 46, 14);
		getContentPane().add(lblNewLabel_5);
	}
}
