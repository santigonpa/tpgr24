package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ConsultaDeTiposDePublicacionDeOfertasLaborales extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaDeTiposDePublicacionDeOfertasLaborales frame = new ConsultaDeTiposDePublicacionDeOfertasLaborales();
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
	public ConsultaDeTiposDePublicacionDeOfertasLaborales() {
		setBounds(100, 100, 450, 300);
		setTitle("Consulta de Paquetes de Tipo de publicacion de Ofertas Laborales");
		setBounds(100, 100, 450, 300);
		setResizable(true);
	    setIconifiable(true);
	    setMaximizable(true);
	    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    setClosable(true);
		JLabel lblNewLabel = new JLabel("Paquetes :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"Seleccione paquete..."}));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Nombre", "Descripcion", "CantDeTipos", "Validez", "Descuento", "Costo"},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Nombre", "Descripcion", "CantDeTipos", "Validez", "Descuento", "Costo"
			}
		));
		
		JLabel lblNewLabel_1 = new JLabel("Tipos de publicacion :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox<String> comboBox_1 = new JComboBox<>();
		comboBox_1.setModel(new DefaultComboBoxModel<>(new String[] {"Seleccione tipo..."}));
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{"Nombre", "Descripcion", "Exposicion", "Duracion", "Costo", "Cantidad"},
				{null, null, null, null, null, null},
			},
			new String[] {
				"Nombre", "Descripcion", "Exposicion", "Duracion", "Costo", "Cantidad"
			}
		));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(29)
							.addComponent(lblNewLabel)
							.addGap(26)
							.addComponent(comboBox, 0, 290, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(table, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)))
					.addGap(19))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(table_1, GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(13)
							.addComponent(lblNewLabel_1)
							.addGap(18)
							.addComponent(comboBox_1, 0, 235, Short.MAX_VALUE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_1)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(table_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(58, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
