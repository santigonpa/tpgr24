package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;

public class ConsultarUsuario extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nombre;
	private JTextField apellido;
	private JTextField nickname;
	private JTextField email;
	private JTextField nacionalidad;
	private JTextField link;

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
		setResizable(true);
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
		txtpnNombreLabel.setBounds(25, 42, 48, 20);
		getContentPane().add(txtpnNombreLabel);
		
		nombre = new JTextField();
		nombre.setEditable(false);
		nombre.setBounds(83, 42, 96, 20);
		getContentPane().add(nombre);
		nombre.setColumns(1);
		
		JTextPane txtpnApellidoLabel = new JTextPane();
		txtpnApellidoLabel.setText("Apellido:");
		txtpnApellidoLabel.setBackground(new Color(238, 238, 238));
		txtpnApellidoLabel.setBounds(229, 66, 48, 20);
		getContentPane().add(txtpnApellidoLabel);
		
		apellido = new JTextField();
		apellido.setEditable(false);
		apellido.setText("Grillo");
		apellido.setColumns(1);
		apellido.setBounds(287, 66, 131, 20);
		getContentPane().add(apellido);
		
		JTextPane txtpnNicknameLabel = new JTextPane();
		txtpnNicknameLabel.setText("Nickname:");
		txtpnNicknameLabel.setBackground(new Color(238, 238, 238));
		txtpnNicknameLabel.setBounds(25, 66, 56, 20);
		getContentPane().add(txtpnNicknameLabel);
		
		JTextPane txtpnEmailLabel = new JTextPane();
		txtpnEmailLabel.setText("Email:");
		txtpnEmailLabel.setBackground(new Color(238, 238, 238));
		txtpnEmailLabel.setBounds(242, 97, 35, 20);
		getContentPane().add(txtpnEmailLabel);
		
		JTextPane txtpnFechaDeNacimientoLabel = new JTextPane();
		txtpnFechaDeNacimientoLabel.setText("Fecha de nacimiento:");
		txtpnFechaDeNacimientoLabel.setBackground(new Color(238, 238, 238));
		txtpnFechaDeNacimientoLabel.setBounds(25, 97, 109, 20);
		getContentPane().add(txtpnFechaDeNacimientoLabel);
		
		JSpinner fechaNacimiento = new JSpinner();
		fechaNacimiento.setModel(new SpinnerDateModel(new Date(1691809200000L), null, null, Calendar.DAY_OF_YEAR));
		fechaNacimiento.setBounds(35, 149, 131, 20);
		getContentPane().add(fechaNacimiento);
		
		JTextPane txtpnMes = new JTextPane();
		txtpnMes.setText("mes");
		txtpnMes.setForeground(new Color(128, 128, 128));
		txtpnMes.setBackground(new Color(238, 238, 238));
		txtpnMes.setBounds(65, 118, 30, 20);
		getContentPane().add(txtpnMes);
		
		JTextPane txtpnDa = new JTextPane();
		txtpnDa.setText("día");
		txtpnDa.setForeground(Color.GRAY);
		txtpnDa.setBackground(new Color(238, 238, 238));
		txtpnDa.setBounds(25, 118, 30, 20);
		getContentPane().add(txtpnDa);
		
		JTextPane txtpnAo = new JTextPane();
		txtpnAo.setText("año");
		txtpnAo.setForeground(Color.GRAY);
		txtpnAo.setBackground(new Color(238, 238, 238));
		txtpnAo.setBounds(117, 118, 30, 20);
		getContentPane().add(txtpnAo);
		
		JTextPane txtpnNscionalidadLabel = new JTextPane();
		txtpnNscionalidadLabel.setText("Nacionalidad:");
		txtpnNscionalidadLabel.setBackground(new Color(238, 238, 238));
		txtpnNscionalidadLabel.setBounds(206, 118, 71, 20);
		getContentPane().add(txtpnNscionalidadLabel);
		
		nickname = new JTextField();
		nickname.setEditable(false);
		nickname.setText("PepeGrillo15");
		nickname.setColumns(1);
		nickname.setBounds(83, 66, 96, 20);
		getContentPane().add(nickname);
		
		email = new JTextField();
		email.setEditable(false);
		email.setText("Pepe@gmail.com");
		email.setColumns(1);
		email.setBounds(287, 97, 131, 20);
		getContentPane().add(email);
		
		nacionalidad = new JTextField();
		nacionalidad.setEditable(false);
		nacionalidad.setText("Peruana");
		nacionalidad.setColumns(1);
		nacionalidad.setBounds(287, 118, 131, 20);
		getContentPane().add(nacionalidad);
		
		JTextPane txtpnLinkLabel = new JTextPane();
		txtpnLinkLabel.setText("Link:");
		txtpnLinkLabel.setBackground(new Color(238, 238, 238));
		txtpnLinkLabel.setBounds(65, 240, 30, 20);
		getContentPane().add(txtpnLinkLabel);
		
		link = new JTextField();
		link.setEditable(false);
		link.setText("www.elponypisador.com");
		link.setColumns(1);
		link.setBounds(105, 240, 183, 20);
		getContentPane().add(link);
		
		JTextPane txtpnDescripcionLabel = new JTextPane();
		txtpnDescripcionLabel.setText("Descripción:");
		txtpnDescripcionLabel.setBackground(new Color(238, 238, 238));
		txtpnDescripcionLabel.setBounds(16, 180, 65, 20);
		getContentPane().add(txtpnDescripcionLabel);
		
		JTextArea descripcion = new JTextArea();
		descripcion.setEditable(false);
		descripcion.setFont(new Font("Tahoma", Font.PLAIN, 10));
		descripcion.setLineWrap(true);
		descripcion.setText("Esto es una descripción de una empresa que es muy larga y necesito que ocupe mucho para testear.");
		descripcion.setBounds(93, 180, 325, 49);
		getContentPane().add(descripcion);
		
		JMenu mnOfertas = new JMenu("Ofertas");
		mnOfertas.setBounds(229, 149, 111, 24);
		getContentPane().add(mnOfertas);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("bartender");
		mnOfertas.add(mntmNewMenuItem);
		
		JComboBox<String> tipoDeUsuario = new JComboBox<String>();
		tipoDeUsuario.setBounds(65, 10, 294, 22);
		getContentPane().add(tipoDeUsuario);
	   tipoDeUsuario.addActionListener(new ActionListener() {
		   public void actionPerformed(ActionEvent e) {
               String selectedOption = (String) tipoDeUsuario.getSelectedItem();
               if (selectedOption.equals("Empresa")) {
               	link.setEditable(true);
                   descripcion.setEditable(true);
               	nacionalidad.setEditable(false);
           
                   fechaNacimiento.setEnabled(false);
               } else if (selectedOption.equals("Postulante")) {
               	nacionalidad.setEditable(true);
               	fechaNacimiento.setEnabled(true);
               	link.setEditable(false);
                   descripcion.setEditable(false);
               }
           }
	   });
	
		
	
	
	
	
	}
}