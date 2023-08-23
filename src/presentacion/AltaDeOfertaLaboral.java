package presentacion;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import javax.swing.text.*;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.text.DocumentFilter;

import excepciones.NombreRepetidoOfertaException;
import logica_DataTypes.DataEmpresa;
import logica_DataTypes.DataKeyWord;
import logica_DataTypes.DataTipoPublicacion;
import logica_Controladores.IControladorOferta;
import logica_Controladores.IControladorUsuario;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class AltaDeOfertaLaboral extends JInternalFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// interfaz de oferta
	private static IControladorOferta ICO;
	private static IControladorUsuario ICU;
	
	private JTextField textFieldNombre;
	private JTextField textFieldRemuneracion;
	private JTextField textFieldCiudad;
	private JTextField textFieldDepartamento;
	private JTextArea textAreaDescripcion;
	private JComboBox<DataEmpresa> comboBoxEmpresa;
	private JComboBox<DataTipoPublicacion> comboBoxTipoPublicacion;
	private JSpinner spinnerInicio;
	private JSpinner spinnerFin;
	private JSpinner spinnerFecha;
	private JList<DataKeyWord> listaKeyWords;
	private Set<String> seleccionados;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaDeOfertaLaboral frame = new AltaDeOfertaLaboral(ICO, ICU);
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
	public AltaDeOfertaLaboral(IControladorOferta Ico, IControladorUsuario Icu) {
		ICO = Ico;
		ICU =Icu;
		seleccionados = new HashSet<>();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Alta de Oferta Laboral");
		setBounds(100, 100, 561, 475);
		getContentPane().setLayout(null);
		
		JComboBox<DataEmpresa> comboBoxEmpresa = new JComboBox<DataEmpresa>();
		comboBoxEmpresa.setBounds(177, 7, 361, 21);
		getContentPane().add(comboBoxEmpresa);
		
		JLabel lblNewLabel = new JLabel("Selecicone la empresa");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel.setBounds(10, 10, 157, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Seleccione un tipo de oferta laboral");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_1.setBounds(10, 38, 215, 13);
		getContentPane().add(lblNewLabel_1);
		
		JComboBox<DataTipoPublicacion> comboBoxTipoDePublicacion = new JComboBox<DataTipoPublicacion>();
		comboBoxEmpresa.setBounds(235, 38, 303, 21);
		getContentPane().add(comboBoxTipoDePublicacion);
		
		JLabel lblNewLabel_2 = new JLabel("Ingrese debajo los siguientes datos acerca de la oferta laboral :");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_2.setBounds(10, 69, 385, 13);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre :");
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_3.setBounds(20, 92, 62, 13);
		getContentPane().add(lblNewLabel_3);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(10, 115, 181, 19);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.setBounds(10, 243, 528, 94);
		getContentPane().add(textAreaDescripcion);
		
		JLabel lblNewLabel_4 = new JLabel("Descripcion :");
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_4.setBounds(7, 221, 75, 12);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Horario de trabajo : ");
		lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));
		lblNewLabel_5.setBounds(10, 145, 131, 13);
		getContentPane().add(lblNewLabel_5);
        
        JLabel lblNewLabel_6 = new JLabel("INICIO");
        lblNewLabel_6.setBounds(20, 171, 45, 13);
        getContentPane().add(lblNewLabel_6);
        
        JLabel lblNewLabel_7 = new JLabel("FIN");
        lblNewLabel_7.setBounds(20, 194, 45, 13);
        getContentPane().add(lblNewLabel_7);
        
        //Configura el SpinnerDateModel solo para la parte de la hora
        JSpinner spinnerInicio = new JSpinner();
        spinnerInicio.setModel(new SpinnerDateModel(new Date(1692241200000L), null, null, Calendar.HOUR_OF_DAY));
        spinnerInicio.setBounds(76, 168, 50, 20);
        getContentPane().add(spinnerInicio);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinnerInicio, "HH:mm");
        spinnerInicio.setEditor(editor);
        
        //Configura el SpinnerDateModel solo para la parte de la hora
        JSpinner spinnerFin = new JSpinner();
        spinnerFin.setModel(new SpinnerDateModel(new Date(1692241200000L), null, null, Calendar.HOUR_OF_DAY));
        spinnerFin.setBounds(76, 191, 50, 20);
        getContentPane().add(spinnerFin);
        JSpinner.DateEditor editor2 = new JSpinner.DateEditor(spinnerFin, "HH:mm");
        spinnerFin.setEditor(editor2);
        
        
        textFieldRemuneracion = new JTextField();
        textFieldRemuneracion.setBounds(210, 115, 63, 19);
        getContentPane().add(textFieldRemuneracion);
        textFieldRemuneracion.setColumns(10);
        
        //ESTO ES PARA QUE REMUNERACION SOLO RECIBA NUMEROS
        
        AbstractDocument doc = (AbstractDocument) textFieldRemuneracion.getDocument();
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

        
        
        
        JLabel lblNewLabel_4_1 = new JLabel("Remuneración:");
        lblNewLabel_4_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));
        lblNewLabel_4_1.setBounds(200, 92, 87, 13);
        getContentPane().add(lblNewLabel_4_1);
        
        JLabel lblNewLabel_4_1_1 = new JLabel("$");
        lblNewLabel_4_1_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));
        lblNewLabel_4_1_1.setBounds(276, 117, 23, 13);
        getContentPane().add(lblNewLabel_4_1_1);
        
        JLabel lblNewLabel_4_1_2 = new JLabel("Ciudad :");
        lblNewLabel_4_1_2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));
        lblNewLabel_4_1_2.setBounds(328, 92, 50, 13);
        getContentPane().add(lblNewLabel_4_1_2);
        
        textFieldCiudad = new JTextField();
        textFieldCiudad.setColumns(10);
        textFieldCiudad.setBounds(309, 115, 96, 19);
        getContentPane().add(textFieldCiudad);
        
        JLabel lblNewLabel_4_1_2_1 = new JLabel("Departamento :");
        lblNewLabel_4_1_2_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));
        lblNewLabel_4_1_2_1.setBounds(429, 92, 109, 13);
        getContentPane().add(lblNewLabel_4_1_2_1);
        
        textFieldDepartamento = new JTextField();
        textFieldDepartamento.setColumns(10);
        textFieldDepartamento.setBounds(427, 115, 96, 19);
        getContentPane().add(textFieldDepartamento);
        
        JLabel lblNewLabel_5_1 = new JLabel("Seleccione Palabras Clave (KEYWORDS) : ");
        lblNewLabel_5_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));
        lblNewLabel_5_1.setBounds(177, 146, 243, 13);
        getContentPane().add(lblNewLabel_5_1);
        
        JList<DataKeyWord> listaKeyWords = new JList<DataKeyWord>();
        listaKeyWords.setBounds(177, 171, 228, 62);
        getContentPane().add(listaKeyWords);
        
        JButton btnSeleccionarKeyword = new JButton("Seleccionar");
        btnSeleccionarKeyword.setBounds(429, 185, 103, 30);
        getContentPane().add(btnSeleccionarKeyword);
        
        btnSeleccionarKeyword.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el elemento seleccionado
                DataKeyWord seleccion = (DataKeyWord)listaKeyWords.getSelectedValue();
                if (seleccion != null) {
                    // Agregar el identificador al conjunto de seleccionados
                    seleccionados.add(seleccion.getPalabraClave());

                    // Deshabilitar la selección en la lista
                    DefaultListModel<DataKeyWord> model = (DefaultListModel<DataKeyWord>) listaKeyWords.getModel();
                    model.removeElement(seleccion);

                    // Actualizar la JList
                    listaKeyWords.setModel(model);
                }
            }
        });
    
        
        JLabel lblNewLabel_5_2 = new JLabel("Fecha Del Alta : ");
        lblNewLabel_5_2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 12));
        lblNewLabel_5_2.setBounds(142, 349, 131, 13);
        getContentPane().add(lblNewLabel_5_2);
        
        JSpinner spinnerFecha = new JSpinner();
        spinnerFecha.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR));
        spinnerFecha.setBounds(290, 347, 105, 20);
        getContentPane().add(spinnerFecha);
        
        JButton btnCancelar = new JButton("CANCELAR");
        btnCancelar.setBounds(293, 407, 102, 21);
        getContentPane().add(btnCancelar);
        
        btnCancelar.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		limpiarFormulario();
                setVisible(false);
                
        	}
        });
        
        
        JButton btnAceptar = new JButton("ACEPTAR");
        btnAceptar.setBounds(158, 407, 102, 21);
        getContentPane().add(btnAceptar);
        //inicio evento para que cuando apreto el boton sucedan cosas, lo hago con la operacion porque es complejo lo que realiza
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cmdAltaDeOfertaLaboralActionPerformed(e);
            }
        });
        
        
        

	}
	
	// INICIO DE METODOS DE LOS EVENTOS
	
	//Esto se invoca cuando le damos a aceptar
	protected void cmdAltaDeOfertaLaboralActionPerformed(ActionEvent e) {
		//obtener los datos de los campos
		String nombre = this.textFieldNombre.getText();
		String ciudad = this.textFieldCiudad.getText();
		String descripcion = this.textAreaDescripcion.getText();
		String departamento = this.textFieldDepartamento.getText();
		String remuneracionTexto = textFieldRemuneracion.getText();
		String empresa = (String) comboBoxEmpresa.getSelectedItem();
		String tipoPubli = (String) comboBoxTipoPublicacion.getSelectedItem();
		Date fecha = (Date) spinnerFecha.getValue();

		
		// Obtener el valor seleccionado del spinner
		Date horaSeleccionadaDate = (Date) spinnerInicio.getValue();
		// Convertir el valor a un objeto LocalTime
		Instant instant = horaSeleccionadaDate.toInstant();
		LocalTime horarioInicio = instant.atZone(ZoneId.systemDefault()).toLocalTime();
		
		// Obtener el valor seleccionado del spinner
		Date horaSeleccionadaDate2 = (Date) spinnerFin.getValue();
		// Convertir el valor a un objeto LocalTime
		Instant instant2 = horaSeleccionadaDate2.toInstant();
		LocalTime horarioFin = instant2.atZone(ZoneId.systemDefault()).toLocalTime();
		
		float remuneracion = 0;
		
        //si el campo esta vacio
		if(!remuneracionTexto.isEmpty()) {
		remuneracion = (float)Integer.parseInt(remuneracionTexto);}
		//OBTENER DATOS DE LAS HORAS Y FECHAS
        
        
        if (verificarFormulario()) {
            try {
                //ESTA OPERACION DA EL ALTA
            	ICO.altaPublicacionOfertaLaboral(empresa,tipoPubli, nombre, descripcion, horarioInicio,horarioFin, remuneracion, ciudad, departamento, fecha,seleccionados);

                // Muestro éxito de la operación
                JOptionPane.showMessageDialog(this, "La oferta se ha creado con exito", "Alta de Oferta Laboral",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (NombreRepetidoOfertaException e2) {
                // Muestro error de registro
               JOptionPane.showMessageDialog(this, e2.getMessage(), "Alta de Oferta Laboral", JOptionPane.ERROR_MESSAGE);
           }

            // Limpio el internal frame antes de cerrar la ventana
            limpiarFormulario();
            setVisible(false);
        }
        
	}
	
	//Deja el formulario como cuando entras por primera vez
		
	public void limpiarFormulario() {
	    // Deshabilitar el filtro del documento
	    AbstractDocument doc = (AbstractDocument) textFieldRemuneracion.getDocument();
	    doc.setDocumentFilter(null);

	    // Limpiar el campo de texto
	    textFieldRemuneracion.setText("");
	    this.textFieldNombre.setText("");
		this.textFieldCiudad.setText("");
		this.textAreaDescripcion.setText("");
		this.textFieldDepartamento.setText("");

	    // Volver a habilitar el filtro del documento
	    doc.setDocumentFilter(new DocumentFilter() {
	        @Override
	        public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
	            if (text.matches("\\d+")) {
	                super.insertString(fb, offset, text, attr);
	            }
	        }

	        @Override
	        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
	            if (text.matches("\\d+")) {
	                super.replace(fb, offset, length, text, attrs);
	            }
	        }
	    });
	}
	
	private boolean verificarFormulario() {
		String nombreOferta = this.textFieldNombre.getText();
        String ciudadOferta = this.textFieldCiudad.getText();
        String remuneracion = this.textFieldRemuneracion.getText();
        String departamento = this.textFieldDepartamento.getText();
        String descripcion = this.textAreaDescripcion.getText();

        if (nombreOferta.isEmpty() || ciudadOferta.isEmpty() || remuneracion.isEmpty( )|| descripcion.isEmpty()|| departamento.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "ATENCION!!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        

        return true;
	}
	
	public void cargarEmpresas() {
		Set<DataEmpresa> empresas = ICU.getDataEmpresa();
		DefaultComboBoxModel<DataEmpresa> model = new DefaultComboBoxModel<>();
	    
	    // Agregar las empresas al modelo del JComboBox
	    for (DataEmpresa empresa : empresas) {
	        model.addElement(empresa);
	    }
	    
	    // Establecer el modelo en el JComboBox
	    comboBoxEmpresa.setModel(model);
	}
	
	public void cargarTiposDePublicacion() {
	    Set<DataTipoPublicacion> tiposDePublicacion = ICU.getDataTipoPublicacion();
	    DefaultComboBoxModel<DataTipoPublicacion> model = new DefaultComboBoxModel<>();
	    
	    // Agregar los tipos de publicación al modelo del JComboBox
	    for (DataTipoPublicacion tipoPublicacion : tiposDePublicacion) {
	        model.addElement(tipoPublicacion);
	    }
	    
	    // Establecer el modelo en el JComboBox
	    comboBoxTipoPublicacion.setModel(model);
	}
	
	public void cargarKeywords() {
	    Set<DataKeyWord> keywords = ICU.getDataKeyWord();
	    
	    DefaultListModel<DataKeyWord> model = new DefaultListModel<>();
	    
	    // Agregar las keywords al modelo del JList
	    for (DataKeyWord keyword : keywords) {
	        model.addElement(keyword);
	    }
	    
	    // Establecer el modelo en el JList
	    listaKeyWords.setModel(model);
	}
	
	public void chequearDatosCargados() {
		
	}
}
