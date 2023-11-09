package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.JLabel;

import excepciones.NombrePaqueteYaExiste;
import logica_cargar_datos.datos_de_prueba.cargarDatos;
import logica_controladores.IControladorOferta;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import java.util.Calendar;
import java.util.Date;

public class CrearPaqueteDeTipoDePublicacionDeOfertasLaborales extends JInternalFrame{
	private static final long serialVersionUID = 1L;
	private static IControladorOferta ICO;

	private JTextField nombrepaquete;
	private JTextField descripcionpaquete;
	private JTextField validez;
	private JTextField descuento;
	private JSpinner fechadealtaSpinner;
	private JLabel lblNewLabel_1;
	public CrearPaqueteDeTipoDePublicacionDeOfertasLaborales(IControladorOferta Ico) {
		ICO = Ico;
		setTitle("Crear Paquete De Tipo De Publicacion De Ofertas Laborales");
		setBounds(100, 100, 374, 313);
		getContentPane().setLayout(null);
		
		JLabel nombrePaq = new JLabel("Nombre de paquete:");
		nombrePaq.setBounds(10, 22, 155, 14);
		getContentPane().add(nombrePaq);
		
		nombrepaquete = new JTextField();
		nombrepaquete.setBounds(175, 19, 162, 20);
		getContentPane().add(nombrepaquete);
		nombrepaquete.setColumns(10);
		
		JLabel DescPaq = new JLabel("Descripcion:");
		DescPaq.setBounds(10, 65, 155, 14);
		getContentPane().add(DescPaq);
		
		descripcionpaquete = new JTextField();
		descripcionpaquete.setBounds(175, 62, 162, 20);
		getContentPane().add(descripcionpaquete);
		descripcionpaquete.setColumns(10);
		
		validez = new JTextField();
		validez.setBounds(175, 107, 162, 20);
		getContentPane().add(validez);
		validez.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Periodo de validez (en dias)");
		lblNewLabel.setBounds(10, 110, 155, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel descuentoLabel = new JLabel("Descuento %");
		descuentoLabel.setBounds(10, 158, 155, 14);
		getContentPane().add(descuentoLabel);
		
		descuento = new JTextField();
		descuento.setBounds(175, 155, 162, 20);
		getContentPane().add(descuento);
		descuento.setColumns(10);
		
		fechadealtaSpinner = new JSpinner();
		fechadealtaSpinner.setModel((new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR)));
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(fechadealtaSpinner, "dd/MM/yyyy");
		fechadealtaSpinner.setEditor(dateEditor);
		fechadealtaSpinner.setBounds(175, 204, 162, 20);
		getContentPane().add(fechadealtaSpinner);
		
		lblNewLabel_1 = new JLabel("Fecha De Alta:");
		lblNewLabel_1.setBounds(10, 207, 155, 14);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(76, 249, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(175, 249, 89, 23);
		getContentPane().add(btnCancelar);
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cmdCrearPaqueteDeTipoDePublicacionDeOfertaLaboral(e);
				} catch (NombrePaqueteYaExiste | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}); 
		
		}
		
		
	protected void cmdCrearPaqueteDeTipoDePublicacionDeOfertaLaboral(ActionEvent e) throws NombrePaqueteYaExiste, IOException{
		String nombre = this.nombrepaquete.getText();
		String descripcion = this.descripcionpaquete.getText();
		int validez = Integer.parseInt(this.validez.getText());
    	int descuento = Integer.parseInt(this.descuento.getText());
    	Date fechaDeAltaDate = (Date) fechadealtaSpinner.getValue();
    	
    	cargarDatos cargador = new cargarDatos();
		byte[] fotoPredeterminada = cargador.getFile("imagenDefaultPaquete.jpg");
    	
        LocalDate fechaDeAlta = fechaDeAltaDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();    	//try {
    	ICO.crearPaqueteDeTipoDePublicacionDeOfertasLaborales(nombre,descripcion,validez,descuento,fechaDeAlta, 0, fotoPredeterminada);
        JOptionPane.showMessageDialog(this, "El paquete se creo con exito", "Crear Paquete De Tipo De Publicacion De Oferta Laboral", JOptionPane.INFORMATION_MESSAGE);
    	limpiarFormulario();
    	//}catch(NombrePaqueteYaExiste e1){
	       // JOptionPane.showMessageDialog(this, e1.getMessage(), "Crear Paquete De Tipo  De Publicacion De Ofertas Laborales", JOptionPane.ERROR_MESSAGE);

    	//}
    	}
	
	public void limpiarFormulario() {
		this.nombrepaquete.setText("");
		this.descripcionpaquete.setText("");
		this.validez.setText("");
		this.descuento.setText("");
	}
}
