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
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.DocumentFilter.FilterBypass;

public class AltaDeTipoDePublicacionDeOfertaLaboral extends JInternalFrame {
	private JTextField txtNombre;
	private JTextField textFieldDescripcion;
	private JTextField textFieldCosto;

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
		
		txtNombre = new JTextField();
		txtNombre.setBounds(173, 13, 230, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Descripcion :");
		lblNewLabel_1.setBounds(10, 56, 70, 24);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Indique la exposicion en formato ");
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
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(90, 50, 313, 38);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		JSpinner duracion = new JSpinner();
		duracion.setBounds(375, 117, 30, 20);
		getContentPane().add(duracion);
		
		JLabel lblNewLabel = new JLabel("(en dias) :");
		lblNewLabel.setBounds(275, 132, 70, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha de alta :");
		lblNewLabel_3.setBounds(185, 184, 70, 24);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				darAlta(e);
			}
		});
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
		
		JSpinner fecha = new JSpinner();
		fecha.setBounds(286, 187, 68, 20);
		getContentPane().add(fecha);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setBounds(61, 196, 70, 19);
		getContentPane().add(textFieldCosto);
		textFieldCosto.setColumns(10);
		
		JSpinner exp = new JSpinner();
		exp.setModel(new SpinnerNumberModel(0, 0, 0, 1));
		exp.setBounds(128, 130, 30, 20);
		getContentPane().add(exp);
		
		//ESTO ES PARA QUE REMUNERACION SOLO RECIBA NUMEROS
        
        AbstractDocument doc = (AbstractDocument) textFieldCosto.getDocument();
        doc.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                if (text != null && text.matches("\\d+")) {
                    super.insertString(fb, offset, text, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text != null && text.matches("\\d+")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });         
	}
	
	protected void darAlta(ActionEvent e) {
		String nombre = this.txtNombre.getText();
		String descripcion = this.textFieldDescripcion.getText();
		int exposicion = (int) exp.getValue();
		int dur = duracion.getValue();
		
	}
}
