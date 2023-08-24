package presentacion;

import java.awt.EventQueue;



import java.util.Calendar;
import java.util.Date;

import javax.swing.JInternalFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import logica_Controladores.IControladorOferta;

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
import javax.swing.JTextArea;

public class AltaDeTipoDePublicacionDeOfertaLaboral extends JInternalFrame {
	private JTextField txtNombre;
	private JTextField textFieldCosto;
	private JTextField textFieldExposicion;
	private JTextArea textoDescripcion;
	private JSpinner fecha;
	private JSpinner spinnerDuracion;
	private JTextField txtFieldCosto;
	
	private static IControladorOferta ICO;

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
		setTitle("Alta de Tipo de Publicacion de Oferta Laboral");
		setBounds(100, 100, 504, 307);
		setIconifiable(true);
		setClosable(true);
		setMaximizable(true);
		getContentPane().setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(204, 13, 272, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Descripcion :");
		lblNewLabel_1.setBounds(10, 56, 99, 24);
		getContentPane().add(lblNewLabel_1);
		
		JLabel labelExposicion = new JLabel("Indique la exposicion:");
		labelExposicion.setBounds(10, 124, 131, 31);
		getContentPane().add(labelExposicion);
		
		JLabel lblNewLabel_1_2 = new JLabel("Duracion de la publicacion: ");
		lblNewLabel_1_2.setBounds(280, 127, 165, 24);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nombre del tipo de publicacion :");
		lblNewLabel_1_3.setBounds(10, 11, 185, 24);
		getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Costo : $");
		lblNewLabel_1_1_1_1.setBounds(10, 184, 70, 43);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
		spinnerDuracion = new JSpinner();
		spinnerDuracion.setModel(new SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
		spinnerDuracion.setBounds(446, 129, 30, 20);
		getContentPane().add(spinnerDuracion);
		
		JLabel lblNewLabel = new JLabel("(en dias)");
		lblNewLabel.setBounds(321, 154, 70, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha de alta :");
		lblNewLabel_3.setBounds(280, 193, 89, 24);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmdAltaDeTipoDePublicacionDeOferta(e);
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
		
		fecha = new JSpinner();
		fecha.setModel(new SpinnerDateModel(new Date(1692759600000L), null, null, Calendar.DAY_OF_YEAR));
		fecha.setBounds(381, 195, 95, 20);
		getContentPane().add(fecha);
		
		 // Personalizar la apariencia del JSpinner para mostrar solo la fecha
	    JSpinner.DateEditor de_fecha = new JSpinner.DateEditor(fecha, "dd/MM/yyyy");
	    fecha.setEditor(de_fecha);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setBounds(204, 195, 61, 19);
		getContentPane().add(textFieldCosto);
		textFieldCosto.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(204, 46, 272, 61);
		getContentPane().add(scrollPane);
		
		textoDescripcion = new JTextArea();
		scrollPane.setViewportView(textoDescripcion);
		
		textFieldExposicion = new JTextField();
		textFieldExposicion.setBounds(204, 128, 61, 22);
		getContentPane().add(textFieldExposicion);
		textFieldExposicion.setColumns(10);
		

		
		//ESTO ES PARA QUE COSTO SOLO RECIBA NUMEROS
        
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
        
        AbstractDocument doc2 = (AbstractDocument) textFieldExposicion.getDocument();
        doc2.setDocumentFilter(new DocumentFilter() {
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
	protected void cmdAltaDeTipoDePublicacionDeOferta(ActionEvent e) {
		String nombreTipoPubli = this.txtNombre.getText();
		String descripcion = (String) this.textoDescripcion.getText();
		
		int expo = Integer.parseInt(this.textFieldExposicion.getText());
		int costo = Integer.parseInt(this.textFieldCosto.getText());
		int duracion = (int) spinnerDuracion.getValue();
				
		Date fechaAlta = (Date) fecha.getValue();
		
		
		/*if (verificarFormularioAlta()) {
			ICO.TipoPublicacion(nombreTipoPubli, descripcion, expo, duracion, costo);
		}
		*/
	}
	private boolean verificarFormularioAlta() {
		String nombreTipoPubli = this.txtNombre.getText();
		String descripcion = (String) this.textoDescripcion.getText();
		
		int expo = Integer.parseInt(this.textFieldExposicion.getText());
		int costo = Integer.parseInt(this.textFieldCosto.getText());
				
		
		if (nombreTipoPubli.isEmpty() || descripcion.isEmpty() || expo < 1 || costo < 1) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos y el costo y la exposicion deben ser mayores a 0", "ATENCION",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
		
		return true;
	}
}
