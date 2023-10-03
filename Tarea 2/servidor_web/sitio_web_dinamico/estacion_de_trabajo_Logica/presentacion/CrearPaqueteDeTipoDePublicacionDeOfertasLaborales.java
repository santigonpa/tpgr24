package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;

import javax.swing.JLabel;
import logica_Controladores.IControladorOferta;
import excepciones.NombrePaqueteYaExiste;
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
		nombrePaq.setBounds(10, 22, 101, 14);
		getContentPane().add(nombrePaq);
		
		nombrepaquete = new JTextField();
		nombrepaquete.setBounds(125, 19, 96, 20);
		getContentPane().add(nombrepaquete);
		nombrepaquete.setColumns(10);
		
		JLabel DescPaq = new JLabel("Descripcion:");
		DescPaq.setBounds(10, 65, 101, 14);
		getContentPane().add(DescPaq);
		
		descripcionpaquete = new JTextField();
		descripcionpaquete.setBounds(125, 62, 96, 20);
		getContentPane().add(descripcionpaquete);
		descripcionpaquete.setColumns(10);
		
		validez = new JTextField();
		validez.setBounds(175, 107, 96, 20);
		getContentPane().add(validez);
		validez.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Periodo de validez (en dias)");
		lblNewLabel.setBounds(10, 110, 155, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel descuentoLabel = new JLabel("Descuento %");
		descuentoLabel.setBounds(10, 158, 79, 14);
		getContentPane().add(descuentoLabel);
		
		descuento = new JTextField();
		descuento.setBounds(110, 155, 96, 20);
		getContentPane().add(descuento);
		descuento.setColumns(10);
		
		fechadealtaSpinner = new JSpinner();
		fechadealtaSpinner.setModel((new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR)));
		JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(fechadealtaSpinner, "dd/MM/yyyy");
		fechadealtaSpinner.setEditor(dateEditor);
		fechadealtaSpinner.setBounds(113, 204, 93, 20);
		getContentPane().add(fechadealtaSpinner);
		
		lblNewLabel_1 = new JLabel("Fecha De Alta:");
		lblNewLabel_1.setBounds(10, 207, 79, 14);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(63, 237, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(248, 237, 89, 23);
		getContentPane().add(btnCancelar);
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cmdCrearPaqueteDeTipoDePublicacionDeOfertaLaboral(e);
				} catch (NombrePaqueteYaExiste e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}); 
		
		}
		
		
	protected void cmdCrearPaqueteDeTipoDePublicacionDeOfertaLaboral(ActionEvent e) throws NombrePaqueteYaExiste{
		String nombre = this.nombrepaquete.getText();
		String descripcion = this.descripcionpaquete.getText();
		int validez = Integer.parseInt(this.validez.getText());
    	int descuento = Integer.parseInt(this.descuento.getText());
    	 Date fechaDeAltaDate = (Date) fechadealtaSpinner.getValue();
         LocalDate fechaDeAlta = fechaDeAltaDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();    	//try {
    	ICO.CrearPaqueteDeTipoDePublicacionDeOfertasLaborales(nombre,descripcion,validez,descuento,fechaDeAlta);
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
