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
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.chrono.ChronoZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;

import logica_Controladores.IControladorOferta;
import logica_Controladores.IControladorUsuario;
import logica_DataTypes.DataEmpresa;
import logica_DataTypes.DataPostulante;
import logica_Entidades.Empresa;
import logica_Entidades.OfertaLaboral;
import logica_Manejadores.IManejadorOferta;
import logica_Manejadores.IManejadorUsuario;
import utils.Fabrica;
import excepciones.yaExistePostulacionAOfertaException;

import javax.swing.AbstractListModel;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;

public class PostulacionAOfertaLaboral extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static IControladorUsuario ICU;
	private static IControladorOferta ICO;
	private static IManejadorUsuario IMU;
	private static IManejadorOferta IMO;
	
	private JComboBox<String> seleccionDeEmpresa;
	private JLabel txtEmpresa;
	private JLabel txtOferta;
	private JComboBox<String> seleccionDeOfertaLaboral;
	private JLabel txtDatosOferta;
	private JLabel txtDescripcionOferta;
	private JScrollPane scrollPaneDescripcion;
	private JLabel txtCiudadOferta;
	private JLabel txtDepartamentoOferta;
	private JLabel txtRemuneracion;
	private JLabel txtFechaAlta;
	private JLabel txtHorarios;
	private JLabel txtPostulante;	
	private JComboBox<String> Postulantes;
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
	private JTextArea motivacion;
	private JTextArea CVReducido;
	private JTextArea Descripcion;
	private JSpinner spinner;
	
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
		IMU = Imu;
		IMO = Imo;
		setClosable(true);
		setTitle("Postulacion a Oferta Laboral");
		setBounds(100, 100, 710, 665);
		
		txtEmpresa = new JLabel("Empresa:");
		
		seleccionDeEmpresa = new JComboBox<>();
		seleccionDeEmpresa.setModel(new DefaultComboBoxModel<>(new String[] {"Seleccione una empresa", "MCDonalds", "BurguerKing"}));
		
		txtOferta = new JLabel("Oferta laboral:");
		
		seleccionDeOfertaLaboral = new JComboBox<>();
		
		seleccionDeOfertaLaboral.setModel(new DefaultComboBoxModel<>(new String[] {"Seleccione una oferta laboral", "Oferta 1", "Oferta 2"}));
		
		//Dependiendo de que empresa selecciono que ofertas laborales se van a mostrar
		seleccionDeEmpresa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					seleccionDeOfertaLaboral.removeAllItems();
					String emp = (String) seleccionDeEmpresa.getSelectedItem();
					DataEmpresa DtEmp = (DataEmpresa) IMU.getDataEmpresa(emp);
					Map<String, OfertaLaboral> ofertas = ICU.obtenerOfertarDeEmpresa(DtEmp);
					for(Map.Entry<String, OfertaLaboral> entry : ofertas.entrySet()) {
					seleccionDeOfertaLaboral.addItem(entry.getKey());
					}
				}
			});
				
		seleccionDeOfertaLaboral.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String ofer = (String) seleccionDeOfertaLaboral.getSelectedItem();
					OfertaLaboral oferta = IMO.obtenerOferta(ofer);
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
		
		Postulantes = new JComboBox<>();
		Postulantes.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccione un/a postulante", "Juan", "Juana", "Juane", "Juani"}));
		Map<String, DataPostulante> postulantes = IMU.getDataPostulantes();
		for (Map.Entry<String, DataPostulante> entry : postulantes.entrySet()) {
		    String key = entry.getKey();
		    Postulantes.addItem(key);
		}
		
		txtDatosPostulante = new JLabel("Ingreso de datos del postulante");
		
		txtCVReducido = new JLabel("CV reducido:");
		
		scrollPaneCVReducido = new JScrollPane();
		
		txtMotivacion = new JLabel("Motivacion:");
		
		btnCancelar = new JButton("Cancelar");
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				altaPostulacion(e);
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
		
		
		
		motivacion = new JTextArea();
		
		JLabel fechaDePostulacion = new JLabel("Fecha de Inscripcion :");
		
		spinner = new JSpinner();
        spinner.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR));

		
		JTextArea textArea = new JTextArea();
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
									.addGroup(groupLayout.createSequentialGroup()
										.addContainerGap()
										.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
											.addComponent(txtEmpresa)
											.addComponent(txtOferta))
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
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPaneDescripcion, GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
								.addComponent(seleccionDeOfertaLaboral, 0, 533, Short.MAX_VALUE)
								.addComponent(seleccionDeEmpresa, 0, 533, Short.MAX_VALUE)
								.addComponent(Postulantes, 0, 533, Short.MAX_VALUE)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
										.addComponent(ciudad)
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
											.addComponent(fechaAlta, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)))
									.addGap(38))))
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
										.addComponent(scrollPaneCVReducido, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
										.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(motivacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(fechaDePostulacion)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtEmpresa)
						.addComponent(seleccionDeEmpresa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtOferta)
						.addComponent(seleccionDeOfertaLaboral, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
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
						.addComponent(Postulantes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtPostulante))
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
								.addComponent(motivacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnCancelar)
								.addComponent(btnAceptar))
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(37)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(fechaDePostulacion)
								.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
		);
		
		CVReducido = new JTextArea();
		scrollPaneCVReducido.setViewportView(CVReducido);
		
		Descripcion = new JTextArea();
		Descripcion.setEditable(false);
		Descripcion.setDoubleBuffered(true);
		scrollPaneDescripcion.setViewportView(Descripcion);
		getContentPane().setLayout(groupLayout);
		

		//Obtengo la interfaz del manejador 
		
		//Cargo el JComboBox de los nombre de las empresas
		
		Map<String, DataEmpresa> empresas = IMU.getDataEmpresas();
		for (Map.Entry<String, DataEmpresa> entry : empresas.entrySet()) {
		    String key = entry.getKey();
		    seleccionDeEmpresa.addItem(key);
		}
		

		
	}
	protected void altaPostulacion(ActionEvent e) {
		String cv = CVReducido.getText();
		String mot = motivacion.getText();
		Instant instant =  spinner.toInstant();
		LocalTime horarioInicio = instant.atZone(ZoneId.systemDefault()).toLocalTime();
		String empr = (String) seleccionDeEmpresa.getSelectedItem();
		String ofer = (String) seleccionDeOfertaLaboral.getSelectedItem();
		String post = (String) Postulantes.getSelectedItem();
		
		OfertaLaboral oferta = (OfertaLaboral) IMO.obtenerOferta(ofer); 
				
		if(oferta.existePostulacion(post)) { 
			throw new yaExistePostulacionAOfertaException("El postulante ya se encuentra postulado a esta oferta \n" + "Intente de nuevo reingresando alguno (o todos) de los siguientes: \n" + "-Empresa \n" + "-Oferta laboral \n" + "-Postulante \n"  );
		}
	
		if(verificarFormulario()) {
			ICO.agregarPostulacion(post, ofer, cv, mot, fecha);
			limpiarFormulario();
			JOptionPane.showMessageDialog(this, "La postulacion a la oferta laboral se realizo con exito", "Postulacion a Oferta Laboral", JOptionPane.INFORMATION_MESSAGE);
			setVisible(false);
		}
		
	}
	
	private boolean verificarFormulario() {
		String cv = CVReducido.getText();
		String mot = motivacion.getText();
		LocalTime fecha = (LocalTime) spinner.getValue();
		String empr = (String) seleccionDeEmpresa.getSelectedItem();
		String ofer = (String) seleccionDeOfertaLaboral.getSelectedItem();
		String post = (String) Postulantes.getSelectedItem();
		
		if(cv.isEmpty() || mot.isEmpty() || fecha.equals(null) || empr.isEmpty() || ofer.isEmpty() || post.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "ATENCION!!",
                    JOptionPane.ERROR_MESSAGE);
            return false;
		}
		return true;
	} 
	
	public void limpiarFormulario() {
		this.CVReducido.setText("");
		this.motivacion.setText("");
		this.seleccionDeEmpresa.setSelectedItem(null);
		this.seleccionDeOfertaLaboral.setSelectedItem(null);
		this.Postulantes.setSelectedItem(null);
	}
		
	
}
