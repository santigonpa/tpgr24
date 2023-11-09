package presentacion;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import excepciones.NombrePaqueteYaExiste;
import excepciones.UsuarioNoExisteException;
import logica_controladores.IControladorOferta;
import logica_controladores.IControladorUsuario;
import logica_datatypes.DataEmpresa;
import logica_datatypes.DataOferta;
import logica_datatypes.DataPaquete;
import logica_datatypes.DataTipoPublicacion;
import logica_manejadores.IManejadorPyT;
import utils.Fabrica;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class AgregarTipoPubliAPaquete extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private  IControladorOferta ICO;
	private  IManejadorPyT IPYT;
	
	private JComboBox<DataPaquete> comboBoxPaquetes;
	private JComboBox<DataTipoPublicacion> comboBoxTipoPubli;
	private JSpinner spinner; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fabrica fabrica = Fabrica.getInstance();
					IManejadorPyT IPYT = fabrica.getInManejadorPyT();
					IControladorOferta ICO = fabrica.getInOfer();
					AgregarTipoPubliAPaquete frame = new AgregarTipoPubliAPaquete(ICO, IPYT);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param Icu 
	 * @param Ico 
	 */
	public AgregarTipoPubliAPaquete(IControladorOferta Ico, IManejadorPyT Ipyt) {
		ICO = Ico;
		IPYT = Ipyt;

		
		setTitle("Agregar Tipo de publicación de Oferta Laboral a Paquete");
		setBounds(100, 100, 450, 163);
		getContentPane().setLayout(null);
		
		JLabel lblPaquetes = new JLabel("Seleccione el paquete:");
		lblPaquetes.setBounds(10, 26, 194, 14);
		getContentPane().add(lblPaquetes);
		
		comboBoxPaquetes = new JComboBox<DataPaquete>();
		comboBoxPaquetes.setBounds(214, 22, 210, 22);
		getContentPane().add(comboBoxPaquetes);
		
		JLabel lblTipoPubli = new JLabel("Tipo de publicación y cantidad:");
		lblTipoPubli.setBounds(10, 59, 186, 14);
		getContentPane().add(lblTipoPubli);
		
		comboBoxTipoPubli = new JComboBox<DataTipoPublicacion>();
		comboBoxTipoPubli.setBounds(214, 55, 144, 22);
		getContentPane().add(comboBoxTipoPubli);
		
		spinner = new JSpinner();
		spinner.setBounds(368, 55, 56, 22);
		
		// Configurar el SpinnerNumberModel con mínimo de 1
		SpinnerNumberModel model = new SpinnerNumberModel(1, 1, null, 1);
		spinner.setModel(model);

		getContentPane().add(spinner);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(115, 104, 89, 23);
		getContentPane().add(btnAceptar);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmdAceptar(e);
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(214, 104, 89, 23);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmdCancelar(e);
			}
		});
	}
	
	public void cargarPaquetes() {
		DefaultComboBoxModel<DataPaquete> model1 = new DefaultComboBoxModel<>();
		ArrayList<DataPaquete> paquetes = IPYT.getDataPaquete();
		
	    if(paquetes != null) {
	    // Agregar las empresas al modelo del JComboBox
		    for (DataPaquete paquete : paquetes) {
		        model1.addElement(paquete);
		    }
		    
		    // Establecer el modelo en el JComboBox
		    comboBoxPaquetes.setModel(model1);
	    }
	}
	public void cargarTipoPubli() {
		DefaultComboBoxModel<DataTipoPublicacion> model2 = new DefaultComboBoxModel<>();
		ArrayList<DataTipoPublicacion> publis = IPYT.getDataTipoPublicacion();
		
	    if(publis != null) {
		    // Agregar las empresas al modelo del JComboBox
		    for (DataTipoPublicacion publi : publis) {
		        model2.addElement(publi);
		    }
	    
		    // Establecer el modelo en el JComboBox
		    comboBoxTipoPubli.setModel(model2);
	    }
	}
	
	protected void cmdAceptar(ActionEvent e) {
		DataPaquete dtPaquete = (DataPaquete) comboBoxPaquetes.getSelectedItem();
		DataTipoPublicacion dtTPubli = (DataTipoPublicacion) comboBoxTipoPubli.getSelectedItem();
		int numeroSeleccionado = (int) spinner.getValue();
		if (dtPaquete == null || dtTPubli == null) {
	        JOptionPane.showMessageDialog(this, "Debe seleccionar opciones válidas", "Error",
	                JOptionPane.ERROR_MESSAGE);
	        return;
	    }
            ICO.agregarTPAPaquete(dtPaquete.getNombre(), dtTPubli.getNombre(), numeroSeleccionado);
            // Muestro éxito de la operación
            JOptionPane.showMessageDialog(this, "El tipo de publicacion ha sido añadido", "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);

        // Limpio el internal frame antes de cerrar la ventana
        limpiarFormulario();
        setVisible(false);	
	}
	
	protected void cmdCancelar(ActionEvent e) {
		limpiarFormulario();
		setVisible(false);
	}
	
	public void limpiarFormulario() {
		comboBoxPaquetes.setSelectedIndex(-1);
		comboBoxTipoPubli.setSelectedIndex(-1);
		spinner.setValue(1);
	}
}
