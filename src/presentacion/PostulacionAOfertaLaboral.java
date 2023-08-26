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

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.SpinnerDateModel;

import logica_Controladores.IControladorOferta;
import logica_Controladores.IControladorUsuario;
import logica_DataTypes.DataEmpresa;
import logica_DataTypes.DataPostulante;
import logica_DataTypes.DataOferta;
import logica_Entidades.OfertaLaboral;
import logica_Manejadores.IManejadorOferta;
import logica_Manejadores.IManejadorUsuario;
import utils.Fabrica;
import excepciones.NoTieneOfertasException;
import excepciones.UsuarioNoExisteException;
import excepciones.yaExistePostulacionAOfertaException;

import javax.swing.JSpinner;



public class PostulacionAOfertaLaboral extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IControladorUsuario ICU;
	private IControladorOferta ICO;
	private IManejadorOferta IMO;
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
		setClosable(true);
		setTitle("Postulacion a Oferta Laboral");
		setBounds(100, 100, 710, 665);
		
		txtEmpresa = new JLabel("Empresa:");
		//seleccionDeEmpresa.setModel(new DefaultComboBoxModel<>(new String[] {"Seleccione una empresa", "MCDonalds", "BurguerKing"}));
		
		txtOferta = new JLabel("Oferta laboral:");
		
		comboBoxOferta = new JComboBox<DataOferta>();
		
		comboBoxEmp = new JComboBox<DataEmpresa>();
		
		comboBoxPost = new JComboBox<DataPostulante>();

		
						
		comboBoxOferta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DataOferta oferta = (DataOferta) comboBoxOferta.getSelectedItem();
					Descripcion.setText(oferta.getDescripcion());
					ciudad.setText(oferta.getCiudad());
					departamento.setText(oferta.getDepartamento());
					remuneracion.setText(oferta.getRemuneracion()+ "");
					fechaAlta.setText(oferta.getFechaAltaComoString());
				
				}
			});
				
		txtDatosOferta = new JLabel("Datos de la oferta laboral");
		
		txtDescripcionOferta = new JLabel("Descripcion:");
		
		scrollPaneDescripcion = new JScrollPane();
		
		txtCiudadOferta = new JLabel("Ciudad:");
		
		txtDepartamentoOferta = new JLabel("Departamento:");
		
		txtRemuneracion = new JLabel("Remuneracion:");
		
		txtFechaAlta = new JLabel("Fecha del alta de la oferta:");
		
		txtHorarios = new JLabel("Horarios:");
		
		txtPostulante = new JLabel("Postulante:");

		
		txtDatosPostulante = new JLabel("Ingreso de datos del postulante");
		
		txtCVReducido = new JLabel("CV reducido:");
		
		scrollPaneCVReducido = new JScrollPane();
		
		txtMotivacion = new JLabel("Motivacion:");
		
		btnCancelar = new JButton("Cancelar");
		
		btnAceptar = new JButton("Aceptar");
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
		ciudad.setEnabled(false);
		ciudad.setEditable(false);
		
		remuneracion = new JTextArea();
		remuneracion.setEnabled(false);
		remuneracion.setEditable(false);
		
		departamento = new JTextArea();
		departamento.setEnabled(false);
		departamento.setEditable(false);
		
		fechaAlta = new JTextArea();
		fechaAlta.setEnabled(false);
		fechaAlta.setEditable(false);
		
		
		
		JLabel fechaDePostulacion = new JLabel("Fecha de Inscripcion :");
		
		spinner = new JSpinner();
        spinner.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR));

		
		motTextArea = new JTextArea();
		
		comboBoxEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultComboBoxModel<DataOferta> model = new DefaultComboBoxModel<>();
				try {
					DataEmpresa emp = (DataEmpresa) comboBoxEmp.getSelectedItem();
					Set<DataOferta> ofertas = ICU.getDataOfertasDeEmpresa(emp.getNickName());
				
					if (ofertas!= null) {
					// Agregar las empresas al modelo del JComboBox
						for (DataOferta oferta : ofertas) {
						model.addElement(oferta);
			    }
			    
			    // Establecer el modelo en el JComboBox
						comboBoxOferta.setModel(model);}
						else {throw new NoTieneOfertasException("No tiene ofertas laborales");}
				}catch(NoTieneOfertasException e22) {}
			}
		});
		
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtDatosOferta))
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addGroup(groupLayout.createSequentialGroup()
											.addContainerGap()
											.addComponent(txtOferta)
											.addGap(62))
										.addGroup(groupLayout.createSequentialGroup()
											.addGap(63)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addComponent(txtDescripcionOferta)
												.addComponent(txtCiudadOferta, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtRemuneracion, GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
												.addComponent(txtHorarios, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED, 8, GroupLayout.PREFERRED_SIZE)))
									.addGroup(groupLayout.createSequentialGroup()
										.addContainerGap()
										.addComponent(txtPostulante)
										.addPreferredGap(ComponentPlacement.RELATED)))
								.addGroup(groupLayout.createSequentialGroup()
									.addContainerGap()
									.addComponent(txtEmpresa)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPaneDescripcion, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
								.addComponent(comboBoxOferta, 0, 533, Short.MAX_VALUE)
								.addComponent(comboBoxEmp, 0, 533, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(comboBoxPost, GroupLayout.PREFERRED_SIZE, 533, GroupLayout.PREFERRED_SIZE)
										.addGroup(groupLayout.createSequentialGroup()
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
												.addComponent(ciudad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(remuneracion, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
											.addGap(25)
											.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(txtDepartamentoOferta, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
													.addGap(30)
													.addComponent(departamento, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
												.addGroup(groupLayout.createSequentialGroup()
													.addComponent(txtFechaAlta)
													.addPreferredGap(ComponentPlacement.UNRELATED)
													.addComponent(fechaAlta, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))))))))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(txtDatosPostulante))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(65)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, 455, Short.MAX_VALUE)
									.addComponent(btnAceptar)
									.addGap(18)
									.addComponent(btnCancelar))
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(txtCVReducido)
										.addComponent(txtMotivacion, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
									.addGap(44)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(motTextArea, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
										.addComponent(scrollPaneCVReducido, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(motTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(66)
							.addComponent(fechaDePostulacion)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(15)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBoxEmp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEmpresa))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtOferta)
						.addComponent(comboBoxOferta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(txtDatosOferta)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtDescripcionOferta)
						.addComponent(scrollPaneDescripcion, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCiudadOferta)
						.addComponent(ciudad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDepartamentoOferta)
						.addComponent(departamento, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtRemuneracion)
						.addComponent(remuneracion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtFechaAlta)
						.addComponent(fechaAlta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(txtHorarios)
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtPostulante)
						.addComponent(comboBoxPost, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(txtDatosPostulante)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(txtCVReducido)
						.addComponent(scrollPaneCVReducido, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(14)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtMotivacion)
								.addComponent(motTextArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(motTextArea, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(fechaDePostulacion))
					.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelar)
						.addComponent(btnAceptar))
					.addContainerGap())
		);
		
		CVReducido = new JTextArea();
		scrollPaneCVReducido.setViewportView(CVReducido);
		
		Descripcion = new JTextArea();
		Descripcion.setEditable(false);
		Descripcion.setDoubleBuffered(true);
		scrollPaneDescripcion.setViewportView(Descripcion);
		getContentPane().setLayout(groupLayout);
		

		

		

		
	}
	protected void altaPostulacion(ActionEvent e) throws yaExistePostulacionAOfertaException {
		String cv = CVReducido.getText();
		String mot = motTextArea.getText();
		Date fechaD = (Date) spinner.getValue();
		Instant instant = fechaD.toInstant();
		LocalDate fechalocalDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
		//String empr = (String) comboBoxEmp.getSelectedItem();
		DataOferta ofer =(DataOferta) comboBoxOferta.getSelectedItem();
		DataPostulante post = (DataPostulante) comboBoxPost.getSelectedItem();
		if(verificarFormulario()) {
		OfertaLaboral oferta = (OfertaLaboral) IMO.obtenerOferta(ofer.getNombre()); 
				
			if(oferta.existePostulacion(post.getNickName())) { 
				throw new yaExistePostulacionAOfertaException("El postulante ya se encuentra postulado a esta oferta \n" + "Intente de nuevo reingresando alguno (o todos) de los siguientes: \n" + "-Empresa \n" + "-Oferta laboral \n" + "-Postulante \n"  );
			}
		}
	
			ICO.agregarPostulacion(post.getNickName(), ofer.getNombre(), cv, mot, fechalocalDate);
			limpiarFormulario();
			JOptionPane.showMessageDialog(this, "La postulacion a la oferta laboral se realizo con exito", "Postulacion a Oferta Laboral", JOptionPane.INFORMATION_MESSAGE);
			setVisible(false);
		}
		
	
	public void cargarDatos() {
		//Para las empresas
		DefaultComboBoxModel<DataEmpresa> modelEmp = new DefaultComboBoxModel<>();
		try {
		Set<DataEmpresa> empresas = ICU.getDataEmpresa();
		for(DataEmpresa emp : empresas) {
			modelEmp.addElement(emp);
		}
		comboBoxEmp.setModel(modelEmp);
		
		//Para los postulantes
		DefaultComboBoxModel<DataPostulante> modelPost = new DefaultComboBoxModel<>();
		Set<DataPostulante> postulantes = ICU.getDataPostulante();
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
		return true;
	} 
	
	public void limpiarFormulario() {
		this.CVReducido.setText("");
		this.motTextArea.setText("");
		this.comboBoxEmp.setSelectedItem(null);
		this.comboBoxOferta.setSelectedItem(null);
		this.comboBoxPost.setSelectedItem(null);
	}
}