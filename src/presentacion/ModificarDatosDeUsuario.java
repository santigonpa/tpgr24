package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarDatosDeUsuario extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarDatosDeUsuario frame = new ModificarDatosDeUsuario();
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
	public ModificarDatosDeUsuario() {
		setTitle("Modificar datos de usuario");
		setBounds(100, 100, 450, 300);
		
		JLabel lblNewLabel = new JLabel("Seleccione el usuario :");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Seleccione el usuario por su nickName..."}));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre :");
		
		JLabel lblNewLabel_2 = new JLabel("Apellido :");
		
		JLabel lblNewLabel_1_1 = new JLabel("nickName :");
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Email :");
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Fecha de nacimiento :");
		
		JSpinner spinner = new JSpinner();
		
		JSpinner spinner_1 = new JSpinner();
		
		JSpinner spinner_2 = new JSpinner();
		
		JLabel lblNewLabel_4 = new JLabel("Descripcion :");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Nacionalidad :");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Link :");
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		JButton btnNewButton = new JButton("Aceptar");
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(22)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNewLabel_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
							.addComponent(lblNewLabel_2)
							.addGap(18)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(18)
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_5)
							.addGap(10)
							.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_6)
									.addGap(40)
									.addComponent(textField_6, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lblNewLabel_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addContainerGap(272, Short.MAX_VALUE)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_1)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(8)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2)))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_1_1)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2_1))))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(spinner_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addGap(18))
		);
		getContentPane().setLayout(groupLayout);

	}
}
