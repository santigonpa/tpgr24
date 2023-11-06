package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.SpinnerDateModel;

import logica_controladores.IControladorOferta;
import logica_controladores.IControladorUsuario;
import logica_datatypes.DataEmpresa;
import logica_datatypes.DataOferta;
import logica_datatypes.DataPostulante;
import logica_entidades.OfertaLaboral;
import logica_manejadores.IManejadorOferta;
import logica_manejadores.IManejadorUsuario;
import utils.Fabrica;
import excepciones.UsuarioNoExisteException;
import excepciones.yaExistePostulacionAOfertaException;

import javax.swing.JSpinner;
import javax.swing.JTextField;



public class PostulacionAOfertaLaboral extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IControladorUsuario ICU;
	private IControladorOferta ICO;
	private IManejadorOferta IMO;
	private IManejadorUsuario IMU;
	private JLabel txtEmpresa;
	private JLabel txtOferta;
	private JComboBox<DataOferta> comboBoxOferta;
	private JLabel txtDatosOferta;
	private JLabel txtDescripcionOferta;
	private JScrollPane scrollPaneDescripcion;
	private JLabel txtCiudadOferta;
	private JLabel txtDepartamentoOferta;
	private JLabel txtRemuneracion;
	private JLabel txtFechaAlta;
	private JLabel txtHorarios;
	private JLabel txtPostulante;	
	private JLabel txtDatosPostulante;
	private JLabel txtCVReducido;
	private JScrollPane scrollPaneCVReducido;
	private JLabel txtMotivacion;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JTextArea ciudad;
	private JTextArea remuneracion;
	private JTextArea departamento;
	private JTextArea fechaAlta;
	private JTextArea motTextArea;
	private JTextArea CVReducido;
	private JTextArea Descripcion;
	private JSpinner spinner;
	private JComboBox<DataPostulante> comboBoxPost;
	private JComboBox<DataEmpresa> comboBoxEmp;
	private JTextField linkvideo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fabrica fabrica = Fabrica.getInstance();
					IControladorUsuario ICU = fabrica.getInUser();
					IControladorOferta ICO = fabrica.getInOfer();
					IManejadorUsuario IMU =fabrica.getInManejadorUsuario();
					IManejadorOferta IMO = fabrica.getInManejadorOferta();
					PostulacionAOfertaLaboral frame = new PostulacionAOfertaLaboral(ICU,ICO,IMU,IMO);
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
	public PostulacionAOfertaLaboral(IControladorUsuario Icu,IControladorOferta Ico,IManejadorUsuario Imu,IManejadorOferta Imo) {
		
		ICU = Icu;
		ICO = Ico;
		IMO = Imo;
		IMU = Imu;
		setClosable(true);
		setTitle("Postulacion a Oferta Laboral");
		setBounds(100, 100, 710, 680);
		
		txtEmpresa = new JLabel("Empresa:");
		txtEmpresa.setBounds(12, 19, 55, 16);
		//seleccionDeEmpresa.setModel(new DefaultComboBoxModel<>(new String[] {"Seleccione una empresa", "MCDonalds", "BurguerKing"}));
		
		txtOferta = new JLabel("Oferta laboral:");
		txtOferta.setBounds(12, 50, 121, 16);
		
		comboBoxOferta = new JComboBox<DataOferta>();
		comboBoxOferta.setBounds(158, 46, 533, 24);
		
		comboBoxEmp = new JComboBox<DataEmpresa>();
		comboBoxEmp.setBounds(158, 15, 533, 24);
		
		comboBoxPost = new JComboBox<DataPostulante>();
		comboBoxPost.setBounds(194, 355, 485, 24);

		
						
		comboBoxOferta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DataOferta oferta = (DataOferta) comboBoxOferta.getSelectedItem();
					Descripcion.setText(oferta.getDescripcion());
					ciudad.setText(oferta.getCiudad());
					departamento.setText(oferta.getDepartamento());
					remuneracion.setText(oferta.getRemuneracion()+ "");
					fechaAlta.setText(oferta.getFechaDeAlta());
				
				}
			});
				
		txtDatosOferta = new JLabel("Datos de la oferta laboral");
		txtDatosOferta.setBounds(292, 83, 145, 16);
		
		txtDescripcionOferta = new JLabel("Descripcion:");
		txtDescripcionOferta.setBounds(63, 122, 87, 16);
		
		scrollPaneDescripcion = new JScrollPane();
		scrollPaneDescripcion.setBounds(158, 122, 533, 85);
		
		txtCiudadOferta = new JLabel("Ciudad:");
		txtCiudadOferta.setBounds(63, 234, 70, 16);
		
		txtDepartamentoOferta = new JLabel("Departamento:");
		txtDepartamentoOferta.setBounds(348, 234, 109, 16);
		
		txtRemuneracion = new JLabel("Remuneracion:");
		txtRemuneracion.setBounds(63, 274, 109, 16);
		
		txtFechaAlta = new JLabel("Fecha del alta de la oferta:");
		txtFechaAlta.setBounds(348, 274, 165, 16);
		
		txtHorarios = new JLabel("Horarios:");
		txtHorarios.setBounds(63, 311, 70, 16);
		
		txtPostulante = new JLabel("Postulante:");
		txtPostulante.setBounds(63, 359, 113, 16);

		
		txtDatosPostulante = new JLabel("Ingreso de datos del postulante");
		txtDatosPostulante.setBounds(292, 392, 180, 16);
		
		txtCVReducido = new JLabel("CV reducido:");
		txtCVReducido.setBounds(93, 436, 107, 16);
		
		scrollPaneCVReducido = new JScrollPane();
		scrollPaneCVReducido.setBounds(193, 431, 486, 85);
		
		txtMotivacion = new JLabel("Motivacion:");
		txtMotivacion.setBounds(63, 534, 74, 16);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(573, 617, 118, 25);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(452, 617, 109, 25);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					altaPostulacion(e);
				} catch (yaExistePostulacionAOfertaException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		
		ciudad = new JTextArea();
		ciudad.setBounds(158, 231, 165, 22);
		ciudad.setEditable(false);
		
		remuneracion = new JTextArea();
		remuneracion.setBounds(158, 271, 165, 22);
		remuneracion.setEditable(false);
		
		departamento = new JTextArea();
		departamento.setBounds(515, 231, 165, 22);
		departamento.setEditable(false);
		
		fechaAlta = new JTextArea();
		fechaAlta.setBounds(515, 271, 165, 22);
		fechaAlta.setEditable(false);
		
		
		
		JLabel fechaDePostulacion = new JLabel("Fecha de Inscripcion :");
		fechaDePostulacion.setBounds(396, 590, 150, 16);
		
		spinner = new JSpinner();
		spinner.setBounds(520, 584, 159, 22);
        spinner.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR));

		
		motTextArea = new JTextArea();
		motTextArea.setBounds(133, 530, 546, 48);
		
		comboBoxEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultComboBoxModel<DataOferta> model = new DefaultComboBoxModel<>();
				try {
					DataEmpresa emp = (DataEmpresa) comboBoxEmp.getSelectedItem();
					ArrayList<DataOferta> ofertas = IMU.obtenerOfertasConfirmadasDeEmpresa(emp.getNickName());
					if (ofertas!= null) {
					// Agregar las empresas al modelo del JComboBox
						for (DataOferta oferta : ofertas) {
						model.addElement(oferta);
			    }
			    
			    // Establecer el modelo en el JComboBox
						comboBoxOferta.setModel(model);}
						else {throw new Exception("No tiene ofertas laborales");}
				}catch(Exception e22) {}
			}
		});
		
		CVReducido = new JTextArea();
		scrollPaneCVReducido.setViewportView(CVReducido);
		
		Descripcion = new JTextArea();
		Descripcion.setEditable(false);
		Descripcion.setDoubleBuffered(true);
		scrollPaneDescripcion.setViewportView(Descripcion);
		getContentPane().setLayout(null);
		getContentPane().add(txtDatosOferta);
		getContentPane().add(txtOferta);
		getContentPane().add(txtDescripcionOferta);
		getContentPane().add(txtCiudadOferta);
		getContentPane().add(txtRemuneracion);
		getContentPane().add(txtHorarios);
		getContentPane().add(txtPostulante);
		getContentPane().add(txtEmpresa);
		getContentPane().add(scrollPaneDescripcion);
		getContentPane().add(comboBoxOferta);
		getContentPane().add(comboBoxEmp);
		getContentPane().add(comboBoxPost);
		getContentPane().add(ciudad);
		getContentPane().add(remuneracion);
		getContentPane().add(txtDepartamentoOferta);
		getContentPane().add(departamento);
		getContentPane().add(txtFechaAlta);
		getContentPane().add(fechaAlta);
		getContentPane().add(txtDatosPostulante);
		getContentPane().add(btnAceptar);
		getContentPane().add(btnCancelar);
		getContentPane().add(txtCVReducido);
		getContentPane().add(txtMotivacion);
		getContentPane().add(motTextArea);
		getContentPane().add(scrollPaneCVReducido);
		getContentPane().add(fechaDePostulacion);
		getContentPane().add(spinner);	
		
		JLabel txtLinkVideo = new JLabel("Link Video:");
		txtLinkVideo.setBounds(63, 590, 74, 16);
		getContentPane().add(txtLinkVideo);
		
		linkvideo = new JTextField();
		linkvideo.setBounds(133, 589, 253, 20);
		getContentPane().add(linkvideo);
		linkvideo.setColumns(10);
	}
	protected void altaPostulacion(ActionEvent e) throws yaExistePostulacionAOfertaException {
        String cv = CVReducido.getText();
        String mot = motTextArea.getText();
        Date fechaD = (Date) spinner.getValue();
        String linkVid = linkvideo.getText();
        if(linkVid.isEmpty()) {
        	linkVid=null;
        }
        Instant instant = fechaD.toInstant();
        LocalDate fechalocalDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        //String empr = (String) comboBoxEmp.getSelectedItem();
        DataOferta ofer =(DataOferta) comboBoxOferta.getSelectedItem();
        DataPostulante post = (DataPostulante) comboBoxPost.getSelectedItem();
        if(verificarFormulario()) {
        //OfertaLaboral oferta = (OfertaLaboral) IMO.obtenerOferta(ofer.getNombre()); 
            /*try {
                if(oferta.existePostulacion(post.getNickName())) { 
                    throw new yaExistePostulacionAOfertaException("El postulante ya se encuentra postulado a esta oferta \n" + "Intente de nuevo reingresando alguno (o todos) de los siguientes: \n" + "-Empresa \n" + "-Oferta laboral \n" + "-Postulante \n"  );
                }
            }catch (yaExistePostulacionAOfertaException e5) {
                JOptionPane.showMessageDialog(null, e5.getMessage(), "Error de Postulación", JOptionPane.ERROR_MESSAGE);
            }*/
        try {
        	ICO.agregarPostulacion(post.getNickName(), ofer.getNombre(), cv, mot, fechalocalDate,linkVid);
            JOptionPane.showMessageDialog(this, "La postulacion a la oferta laboral se realizo con exito", "Postulacion a Oferta Laboral", JOptionPane.INFORMATION_MESSAGE);
            limpiarFormulario();
            setVisible(false);
        } catch (yaExistePostulacionAOfertaException e5) {
        	JOptionPane.showMessageDialog(this, e5.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        	}
        }   
    }
	
	public void cargarDatos() {
		//Para las empresas
		DefaultComboBoxModel<DataEmpresa> modelEmp = new DefaultComboBoxModel<>();
		try {
			ArrayList<DataEmpresa> empresas = ICU.getDataEmpresa();
		for(DataEmpresa emp : empresas) {
			modelEmp.addElement(emp);
		}
		comboBoxEmp.setModel(modelEmp);
		
		//Para los postulantes
		DefaultComboBoxModel<DataPostulante> modelPost = new DefaultComboBoxModel<>();
		ArrayList<DataPostulante> postulantes = ICU.getDataPostulante();
		for(DataPostulante post : postulantes) {
			modelPost.addElement(post);
		}
		comboBoxPost.setModel(modelPost);
		}catch(UsuarioNoExisteException e) {}
	}
	
	private boolean verificarFormulario() {
		String cv = CVReducido.getText();
		String mot = motTextArea.getText();
		DataEmpresa empr = (DataEmpresa) comboBoxEmp.getSelectedItem();
		DataOferta ofer = (DataOferta) comboBoxOferta.getSelectedItem();
		DataPostulante post = (DataPostulante) comboBoxPost.getSelectedItem();
		
		if(cv.isEmpty() || mot.isEmpty() || empr==null || ofer==null || post==null) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "ATENCION!!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
		}
		OfertaLaboral oferta = (OfertaLaboral) IMO.obtenerOferta(ofer.getNombre());
        if (oferta.existePostulacion(post.getNickName())) {
        	JOptionPane.showMessageDialog(this, "El postulante ya se encuentra postulado a esta oferta", "ATENCION!!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }       
		return true;
	} 
	
	public void limpiarFormulario() {
		this.CVReducido.setText("");
		this.motTextArea.setText("");
		this.linkvideo.setText("");
	}
}