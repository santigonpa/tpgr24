package presentacion;

import java.awt.EventQueue;




import java.util.Calendar;
import java.util.Date;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import excepciones.NombreTipoPubliYaExisteException;
import logica_Controladores.IControladorOferta;

import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.awt.event.ActionEvent;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.JTextArea;

public class AltaDeTipoDePublicacionDeOfertaLaboral extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombre;
	private JTextField textFieldCosto;
	private JTextField textFieldExposicion;
	private JTextArea textoDescripcion;
	private JSpinner fecha;
	private static IControladorOferta ICO;
	private JTextField textFieldDuracion;

	/**
	 * Launch the application.//
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaDeTipoDePublicacionDeOfertaLaboral frame = new AltaDeTipoDePublicacionDeOfertaLaboral(ICO);
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
	public AltaDeTipoDePublicacionDeOfertaLaboral(IControladorOferta Ico) {
		ICO = Ico;
		setTitle("Alta de Tipo de Publicacion de Oferta Laboral");
		setBounds(100, 100, 504, 307);
		setIconifiable(true);
		setClosable(true);
		setMaximizable(true);
		getContentPane().setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(210, 13, 266, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Descripcion :");
		lblNewLabel_1.setBounds(10, 56, 99, 24);
		getContentPane().add(lblNewLabel_1);
		
		JLabel labelExposicion = new JLabel("Indique la exposicion:");
		labelExposicion.setBounds(10, 124, 165, 31);
		getContentPane().add(labelExposicion);
		
		JLabel lblNewLabel_1_2 = new JLabel("Duracion de la publicacion: ");
		lblNewLabel_1_2.setBounds(280, 127, 131, 24);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Nombre del tipo de publicacion :");
		lblNewLabel_1_3.setBounds(12, 11, 200, 24);
		getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Costo : $");
		lblNewLabel_1_1_1_1.setBounds(10, 184, 70, 43);
		getContentPane().add(lblNewLabel_1_1_1_1);
		
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
		textFieldCosto.setBounds(210, 196, 61, 19);
		getContentPane().add(textFieldCosto);
		textFieldCosto.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(210, 46, 266, 61);
		getContentPane().add(scrollPane);
		
		textoDescripcion = new JTextArea();
		scrollPane.setViewportView(textoDescripcion);
		
		textFieldExposicion = new JTextField();
		textFieldExposicion.setBounds(210, 129, 61, 22);
		getContentPane().add(textFieldExposicion);
		textFieldExposicion.setColumns(10);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.setColumns(10);
		textFieldDuracion.setBounds(415, 130, 61, 19);
		getContentPane().add(textFieldDuracion);
		

		
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
        
        AbstractDocument doc3 = (AbstractDocument) textFieldDuracion.getDocument();
        doc3.setDocumentFilter(new DocumentFilter() {
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
		
		int expo = 0;
	    int costo = 0;
	    int duracion = 0;
	    Date fechaAlta = null;
		
	    try {
	        expo = Integer.parseInt(this.textFieldExposicion.getText());
	        costo = Integer.parseInt(this.textFieldCosto.getText());
	        duracion =  Integer.parseInt(this.textFieldDuracion.getText());
	        fechaAlta = (Date) fecha.getValue();
	     // Convertir java.util.Date a java.time.LocalDate
	        //LocalDate fechaAlta1 = fechaAlta.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(this, "Por favor ingrese valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
	        return; // Salir del método si ocurre una excepción
	    }
	    
		if (verificarFormularioAlta()) {
			try {
				LocalDate fechaAlta1 = fechaAlta.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				ICO.altaDeTipoDePubliDeOferLab(nombreTipoPubli, descripcion, expo, costo, duracion,fechaAlta1);
				JOptionPane.showMessageDialog(this, "El tipo de publicacion de oferta laboral fue dado de alta con exito.","Alta de Tipo de Publicacion de Oferta Laboral", JOptionPane.INFORMATION_MESSAGE);
	            limpiarFormulario();
	            setVisible(false);
			
			} catch (NombreTipoPubliYaExisteException e1) {
				 JOptionPane.showMessageDialog(this, e1.getMessage(), "Alta de Tipo de Publicacion de Oferta Laboral", JOptionPane.ERROR_MESSAGE);
	        }
		}
		
	}
	private boolean verificarFormularioAlta() {
		String nombreTipoPubli = this.txtNombre.getText();
		String descripcion = (String) this.textoDescripcion.getText();
		
		int expo = Integer.parseInt(this.textFieldExposicion.getText());
		int costo = Integer.parseInt(this.textFieldCosto.getText());
				
		
		if (nombreTipoPubli.isEmpty() || descripcion.isEmpty() || expo < 1 || costo < 1) {
            JOptionPane.showMessageDialog(this, "Revise que sus entradas sean correctas.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
		
		return true;
	}
	///
	public void limpiarFormulario() {
		this.txtNombre.setText("");
		this.textoDescripcion.setText("");
		this.textFieldExposicion.setText("0");
		this.textFieldCosto.setText("0");
		this.textFieldDuracion.setText("1");
		
	}
}

