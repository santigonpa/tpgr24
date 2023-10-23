package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import excepciones.UsuarioNoExisteException;
import logica_controladores.IControladorOferta;
import logica_controladores.IControladorUsuario;
import logica_datatypes.DataEmpresa;
import logica_datatypes.DataOferta;
import logica_entidades.OfertaLaboral.EstadoOferta;
import utils.Fabrica;

public class aceptarRechazarOferta extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private  IControladorOferta ICO;
	private  IControladorUsuario ICU;
	
	private JComboBox<DataEmpresa> comboBoxEmpresas;
	private JComboBox<DataOferta> comboBoxOfertas;
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
					aceptarRechazarOferta frame = new aceptarRechazarOferta(ICO,ICU);
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
	public aceptarRechazarOferta(IControladorOferta Ico, IControladorUsuario Icu) {
		ICO = Ico;
		ICU = Icu;
		setTitle("Aceptar o Rechazar Oferta Laboral");
		setBounds(100, 100, 438, 261);
		getContentPane().setLayout(null);
		
		comboBoxEmpresas = new JComboBox<DataEmpresa>();
		comboBoxEmpresas.setBounds(72, 53, 269, 22);
		getContentPane().add(comboBoxEmpresas);
		
		comboBoxEmpresas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	DataEmpresa selectedEmpresa = (DataEmpresa)comboBoxEmpresas.getSelectedItem();
            
            	DefaultComboBoxModel<DataOferta> model = new DefaultComboBoxModel<>();
        		try {
        			 ArrayList<DataOferta> ofertas = ICU.getDataOfertasDeEmpresa(selectedEmpresa.getNickName());
        		
        	    if (ofertas!= null) {
	        	    for (DataOferta oferta : ofertas) {
	        	    	if(oferta.getEstado()== EstadoOferta.INGRESADA) {
	        	        model.addElement(oferta);
	        	    	}
        	    }
        	    comboBoxOfertas.setModel(model);}
        	    else {throw new Exception("No tiene ofertas laborales");}
        		}catch(Exception e22) {}
            }
		});
		
		comboBoxOfertas = new JComboBox<DataOferta>();
		comboBoxOfertas.setBounds(72, 126, 269, 22);
		getContentPane().add(comboBoxOfertas);
		
		JButton btnAceptar = new JButton("Aceptar Oferta");
		btnAceptar.setBounds(72, 182, 123, 23);
		getContentPane().add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmdAceptarOferta(e);
			}
		});
		
		
		JButton btnCancelar = new JButton("Rechazar Oferta");
		btnCancelar.setBounds(205, 182, 136, 23);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmdRechazarOferta(e);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Seleccione la empresa para ver sus ofertas:");
		lblNewLabel.setBounds(72, 28, 291, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblSeleccioneLaOferta = new JLabel("Seleccione la Oferta que desea Aceptar o Rechazar:");
		lblSeleccioneLaOferta.setBounds(53, 101, 342, 14);
		getContentPane().add(lblSeleccioneLaOferta);

	}
	
	public void cargarEmpresas() {
		DefaultComboBoxModel<DataEmpresa> model1 = new DefaultComboBoxModel<>();
		try {
			 ArrayList<DataEmpresa> empresas = ICU.getDataEmpresa();
		
	    
	    // Agregar las empresas al modelo del JComboBox
	    for (DataEmpresa empresa : empresas) {
	        model1.addElement(empresa);
	    }
	    
	    // Establecer el modelo en el JComboBox
	    comboBoxEmpresas.setModel(model1);
		}catch(UsuarioNoExisteException e) {}
	}
	public void limpiarFormulario() {
		comboBoxOfertas.setSelectedIndex(-1);
	}
	protected void cmdAceptarOferta(ActionEvent e) {
		DataOferta dOfer = (DataOferta) comboBoxOfertas.getSelectedItem();
		DataEmpresa dEmp = (DataEmpresa) comboBoxEmpresas.getSelectedItem();
		if (dOfer == null || dEmp == null) {
	        JOptionPane.showMessageDialog(this, "Debe seleccionar una empresa válida", "Error",
	                JOptionPane.ERROR_MESSAGE);
	        return;
	    }
            ICO.aceptarOfertaLaboral(dOfer);
            // Muestro éxito de la operación
            JOptionPane.showMessageDialog(this, "La oferta ha sido Aceptada", "Aceptar Oferta",
                    JOptionPane.INFORMATION_MESSAGE);


        // Limpio el internal frame antes de cerrar la ventana
        limpiarFormulario();
        setVisible(false);
		
		
	}
	protected void cmdRechazarOferta(ActionEvent e) {
		DataOferta dOfer = (DataOferta) comboBoxOfertas.getSelectedItem();
		DataEmpresa dEmp = (DataEmpresa) comboBoxEmpresas.getSelectedItem();
		if (dOfer == null || dEmp == null) {
	        JOptionPane.showMessageDialog(this, "Debe seleccionar una empresa válida", "Error",
	                JOptionPane.ERROR_MESSAGE);
	        return;
	    }
		 ICO.rechazarOfertaLaboral(dOfer);
         // Muestro éxito de la operación
         JOptionPane.showMessageDialog(this, "La oferta ha sido Rechazada", "Rechazar Oferta",
                 JOptionPane.INFORMATION_MESSAGE);
         // Limpio el internal frame antes de cerrar la ventana
         limpiarFormulario();
         setVisible(false);
	}
	
	
}
