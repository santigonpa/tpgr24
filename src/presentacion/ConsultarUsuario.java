package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JSpinner;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;

public class ConsultarUsuario extends JInternalFrame {
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField textNickname;
	private JTextField textEmail;
	private JTextField textNacionalidad;
	private JTextField txtLink;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarUsuario frame = new ConsultarUsuario();
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
	public ConsultarUsuario() {
		getContentPane().setBackground(new Color(238, 238, 238));
		setTitle("Consulta de usuario");
		setIconifiable(true);
		setClosable(true);
		setMaximizable(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JTextPane txtpnNombreLabel = new JTextPane();
		txtpnNombreLabel.setBackground(new Color(238, 238, 238));
		txtpnNombreLabel.setText("Nombre:");
		txtpnNombreLabel.setBounds(25, 21, 48, 20);
		getContentPane().add(txtpnNombreLabel);
		
		txtNombre = new JTextField();
		txtNombre.setText("Pepe");
		txtNombre.setBounds(83, 21, 96, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(1);
		
		JTextPane txtpnApellidoLabel = new JTextPane();
		txtpnApellidoLabel.setText("Apellido:");
		txtpnApellidoLabel.setBackground(new Color(238, 238, 238));
		txtpnApellidoLabel.setBounds(229, 21, 48, 20);
		getContentPane().add(txtpnApellidoLabel);
		
		txtApellido = new JTextField();
		txtApellido.setText("Grillo");
		txtApellido.setColumns(1);
		txtApellido.setBounds(287, 21, 131, 20);
		getContentPane().add(txtApellido);
		
		JTextPane txtpnNicknameLabel = new JTextPane();
		txtpnNicknameLabel.setText("Nickname:");
		txtpnNicknameLabel.setBackground(new Color(238, 238, 238));
		txtpnNicknameLabel.setBounds(25, 52, 56, 20);
		getContentPane().add(txtpnNicknameLabel);
		
		JTextPane txtpnEmailLabel = new JTextPane();
		txtpnEmailLabel.setText("Email:");
		txtpnEmailLabel.setBackground(new Color(238, 238, 238));
		txtpnEmailLabel.setBounds(239, 52, 35, 20);
		getContentPane().add(txtpnEmailLabel);
		
		JTextPane txtpnFechaDeNacimientoLabel = new JTextPane();
		txtpnFechaDeNacimientoLabel.setText("Fecha de nacimiento:");
		txtpnFechaDeNacimientoLabel.setBackground(new Color(238, 238, 238));
		txtpnFechaDeNacimientoLabel.setBounds(25, 83, 109, 20);
		getContentPane().add(txtpnFechaDeNacimientoLabel);
		
		JSpinner spinnerDay1 = new JSpinner();
		spinnerDay1.setBounds(25, 133, 30, 20);
		getContentPane().add(spinnerDay1);
		
		JSpinner spinnerMonth1 = new JSpinner();
		spinnerMonth1.setBounds(65, 133, 30, 20);
		getContentPane().add(spinnerMonth1);
		
		JSpinner spinnerYear1 = new JSpinner();
		spinnerYear1.setBounds(104, 133, 30, 20);
		getContentPane().add(spinnerYear1);
		
		JTextPane txtpnMes = new JTextPane();
		txtpnMes.setText("mes");
		txtpnMes.setForeground(new Color(128, 128, 128));
		txtpnMes.setBackground(new Color(238, 238, 238));
		txtpnMes.setBounds(65, 110, 30, 20);
		getContentPane().add(txtpnMes);
		
		JTextPane txtpnDa = new JTextPane();
		txtpnDa.setText("día");
		txtpnDa.setForeground(Color.GRAY);
		txtpnDa.setBackground(new Color(238, 238, 238));
		txtpnDa.setBounds(25, 110, 30, 20);
		getContentPane().add(txtpnDa);
		
		JTextPane txtpnAo = new JTextPane();
		txtpnAo.setText("año");
		txtpnAo.setForeground(Color.GRAY);
		txtpnAo.setBackground(new Color(238, 238, 238));
		txtpnAo.setBounds(104, 110, 30, 20);
		getContentPane().add(txtpnAo);
		
		JTextPane txtpnNscionalidadLabel = new JTextPane();
		txtpnNscionalidadLabel.setText("Nacionalidad:");
		txtpnNscionalidadLabel.setBackground(new Color(238, 238, 238));
		txtpnNscionalidadLabel.setBounds(206, 83, 71, 20);
		getContentPane().add(txtpnNscionalidadLabel);
		
		textNickname = new JTextField();
		textNickname.setText("PepeGrillo15");
		textNickname.setColumns(1);
		textNickname.setBounds(83, 52, 96, 20);
		getContentPane().add(textNickname);
		
		textEmail = new JTextField();
		textEmail.setText("Pepe@gmail.com");
		textEmail.setColumns(1);
		textEmail.setBounds(287, 52, 131, 20);
		getContentPane().add(textEmail);
		
		textNacionalidad = new JTextField();
		textNacionalidad.setText("Peruana");
		textNacionalidad.setColumns(1);
		textNacionalidad.setBounds(287, 83, 131, 20);
		getContentPane().add(textNacionalidad);
		
		JTextPane txtpnLinkLabel = new JTextPane();
		txtpnLinkLabel.setText("Link:");
		txtpnLinkLabel.setBackground(new Color(238, 238, 238));
		txtpnLinkLabel.setBounds(63, 225, 30, 20);
		getContentPane().add(txtpnLinkLabel);
		
		txtLink = new JTextField();
		txtLink.setText("www.elponypisador.com");
		txtLink.setColumns(1);
		txtLink.setBounds(94, 225, 183, 20);
		getContentPane().add(txtLink);
		
		JTextPane txtpnDescripcionLabel = new JTextPane();
		txtpnDescripcionLabel.setText("Descripción:");
		txtpnDescripcionLabel.setBackground(new Color(238, 238, 238));
		txtpnDescripcionLabel.setBounds(25, 164, 65, 20);
		getContentPane().add(txtpnDescripcionLabel);
		
		JTextArea txtrDescripcion = new JTextArea();
		txtrDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtrDescripcion.setLineWrap(true);
		txtrDescripcion.setText("Esto es una descripción de una empresa que es muy larga y necesito que ocupe mucho para testear.");
		txtrDescripcion.setBounds(93, 164, 325, 49);
		getContentPane().add(txtrDescripcion);
		
		JMenu mnOfertas = new JMenu("Ofertas");
		mnOfertas.setBounds(173, 117, 111, 24);
		getContentPane().add(mnOfertas);

	}
}
