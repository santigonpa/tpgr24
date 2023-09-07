package presentacion;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import javax.swing.JInternalFrame;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import excepciones.UsuarioNoExisteException;
import logica_Controladores.IControladorOferta;
import logica_Controladores.IControladorUsuario;
import logica_Manejadores.IManejadorUsuario;
import logica_DataTypes.DataEmpresa;
import logica_DataTypes.DataPostulante;
import logica_DataTypes.DataUsuario;
import logica_Entidades.Empresa;
import logica_Entidades.Postulante;
import logica_Entidades.Usuario;
import utils.Fabrica;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
public class ModificarDatosDeUsuario extends JInternalFrame {
private static final long serialVersionUID = 1L;
private static IControladorUsuario ICU;
private static IManejadorUsuario IMU;
private JTextField nombre;
private JTextField apellido;
private JTextField nickname;
private JTextField email;
private JTextField descripcion;
private JTextField nacionalidad;
private JTextField link;
private JComboBox<DataUsuario> comboBoxUSUARIOS;
private JSpinner dateSpinner;
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
Fabrica fabrica = Fabrica.getInstance();
IManejadorUsuario IMU = fabrica.getInManejadorUsuario();
IControladorUsuario ICU = fabrica.getInUser();
IControladorOferta ICO = fabrica.getInOfer();
ModificarDatosDeUsuario frame = new ModificarDatosDeUsuario(ICO, ICU, IMU);
frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}
public ModificarDatosDeUsuario(IControladorOferta Ico, IControladorUsuario Icu, IManejadorUsuario Imu) {
ICU = Icu;
IMU = Imu;
setTitle("Modificar datos de usuario");
setBounds(100, 100, 450, 300);
JLabel lblNewLabel = new JLabel("Seleccione el usuario :");
comboBoxUSUARIOS = new JComboBox<DataUsuario>();
comboBoxUSUARIOS.setBounds(83, 6, 389, 21);
getContentPane().add(comboBoxUSUARIOS);
JButton btnAceptar = new JButton("Aceptar");
comboBoxUSUARIOS.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
DataUsuario selectedUsuario = (DataUsuario) comboBoxUSUARIOS.getSelectedItem();
nombre.setText(String.valueOf(selectedUsuario.getNombre()));
apellido.setText(String.valueOf(selectedUsuario.getApellido()));
nickname.setText(selectedUsuario.getNickName());
email.setText(selectedUsuario.getEmail());
if (selectedUsuario instanceof DataPostulante) {
DataPostulante postulante = (DataPostulante) selectedUsuario;
dateSpinner.setToolTipText(postulante.getFechaString());
nacionalidad.setText(postulante.getNacionalidad());
} else if (selectedUsuario instanceof DataEmpresa) {
DataEmpresa empresa = (DataEmpresa) selectedUsuario;
link.setText(empresa.getLinkWeb());
descripcion.setText(empresa.getDescripcion());
}
}
});
btnAceptar.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
cmdAltaDeUsuarioModificadoActionPerformed(e);
}
});
nombre = new JTextField();
nombre.setColumns(10);
apellido = new JTextField();
apellido.setColumns(10);
JLabel lblNewLabel_1 = new JLabel("Nombre :");
JLabel lblNewLabel_2 = new JLabel("Apellido :");
JLabel lblNewLabel_1_1 = new JLabel("nickName :");
nickname = new JTextField();
nickname.setColumns(10);
JLabel lblNewLabel_2_1 = new JLabel("Email :");
email = new JTextField();
email.setColumns(10);
JLabel lblNewLabel_3 = new JLabel("Fecha de nacimiento :");
dateSpinner = new JSpinner(new SpinnerDateModel());
JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd/MM/yyyy");
dateSpinner.setEditor(dateEditor);
JLabel lblNewLabel_4 = new JLabel("Descripcion :");
descripcion = new JTextField();
descripcion.setColumns(10);
JLabel lblNewLabel_5 = new JLabel("Nacionalidad :");
nacionalidad = new JTextField();
nacionalidad.setColumns(10);
JLabel lblNewLabel_6 = new JLabel("Link :");
link = new JTextField();
link.setColumns(10);
JButton btnCancelar = new JButton("Cancelar");
GroupLayout groupLayout = new GroupLayout(getContentPane());
groupLayout.setHorizontalGroup(
groupLayout.createParallelGroup(Alignment.TRAILING)
.addGroup(groupLayout.createSequentialGroup()
.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
.addGap(22)
.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
.addGap(18)
.addComponent(comboBoxUSUARIOS, GroupLayout.PREFERRED_SIZE, 245, GroupLayout.PREFERRED_SIZE))
.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
.addGap(18)
.addComponent(lblNewLabel_1)
.addPreferredGap(ComponentPlacement.UNRELATED)
.addComponent(nombre, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
.addComponent(lblNewLabel_2)
.addGap(18)
.addComponent(apellido, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE))
.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
.addGap(18)
.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
.addPreferredGap(ComponentPlacement.UNRELATED)
.addComponent(nickname, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
.addGap(18)
.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
.addGap(18)
.addComponent(email, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE))
.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
.addGap(18)
.addComponent(lblNewLabel_3)
.addPreferredGap(ComponentPlacement.RELATED)
.addComponent(dateSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
.addPreferredGap(ComponentPlacement.RELATED)
.addComponent(lblNewLabel_5)
.addGap(10)
.addComponent(nacionalidad, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
.addGap(18)
.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
.addGroup(groupLayout.createSequentialGroup()
.addComponent(lblNewLabel_6)
.addGap(40)
.addComponent(link, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))
.addGroup(groupLayout.createSequentialGroup()
.addComponent(lblNewLabel_4)
.addPreferredGap(ComponentPlacement.RELATED)
.addComponent(descripcion, GroupLayout.DEFAULT_SIZE, 341, Short.MAX_VALUE))))
.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
.addContainerGap(272, Short.MAX_VALUE)
.addComponent(btnAceptar)
.addPreferredGap(ComponentPlacement.RELATED)
.addComponent(btnCancelar)))
.addContainerGap())
);
groupLayout.setVerticalGroup(
groupLayout.createParallelGroup(Alignment.LEADING)
.addGroup(groupLayout.createSequentialGroup()
.addContainerGap()
.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
.addComponent(comboBoxUSUARIOS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
.addGroup(groupLayout.createSequentialGroup()
.addGap(8)
.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
.addComponent(lblNewLabel_1)
.addComponent(nombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
.addComponent(lblNewLabel_2)))
.addGroup(groupLayout.createSequentialGroup()
.addPreferredGap(ComponentPlacement.UNRELATED)
.addComponent(apellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
.addGroup(groupLayout.createSequentialGroup()
.addGap(18)
.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
.addComponent(lblNewLabel_1_1)
.addComponent(nickname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
.addGroup(groupLayout.createSequentialGroup()
.addGap(18)
.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
.addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
.addComponent(lblNewLabel_2_1))))
.addGap(18)
.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
.addComponent(lblNewLabel_3)
.addComponent(dateSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
.addComponent(lblNewLabel_5)
.addComponent(nacionalidad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
.addGap(18)
.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
.addComponent(descripcion, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
.addComponent(lblNewLabel_4))
.addPreferredGap(ComponentPlacement.RELATED)
.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
.addComponent(link, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
.addComponent(lblNewLabel_6))
.addPreferredGap(ComponentPlacement.RELATED)
.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
.addComponent(btnAceptar)
.addComponent(btnCancelar))
.addGap(18))
);
getContentPane().setLayout(groupLayout);
}
public void cargarUsuarios() {
DefaultComboBoxModel<DataUsuario> model = new DefaultComboBoxModel<>();
try {
Set<DataUsuario> usuarios = ICU.getDataUsuarios();
// Agregar usuarios al modelo del JComboBox
for (DataUsuario usuario : usuarios) {
model.addElement(usuario);
}
// Establecer el modelo en el JComboBox
comboBoxUSUARIOS.setModel(model);
} catch (UsuarioNoExisteException e) {
}
}
protected void cmdAltaDeUsuarioModificadoActionPerformed(ActionEvent e) {
String nickname = this.nickname.getText();
String nombre = this.nombre.getText();
String apellido = this.apellido.getText();
String email = this.email.getText();
DataUsuario selectedUsuario = (DataUsuario) comboBoxUSUARIOS.getSelectedItem();
String descripcion = this.descripcion.getText();
String web = this.link.getText();
//Date nacimiento = (Date) dateSpinner.getValue(); no se usa no se por que
String nacionalidad = this.nacionalidad.getText();
//Instant instant = nacimiento.toInstant(); no se usa no se por que
//LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate(); no se usa no se por que
Usuario user = IMU.obtenerUsuario(nickname);
if (verificarFormularioUsuario()) {

	
	if (!nickname.equals(selectedUsuario.getNickName())) {
		/*	 selectedUsuario.setNickName(nickname);
	user.setNickName(nickname);*/
		 JOptionPane.showMessageDialog(this, "No puede modificar el nickname", "Modificar Datos De Usuario", JOptionPane.INFORMATION_MESSAGE);

}
			if (!nombre.equals(selectedUsuario.getNombre())) {
			 selectedUsuario.setNombre(nombre);
				user.setNombre(nombre);
	}
			if (!apellido.equals(selectedUsuario.getApellido())) {
			 selectedUsuario.setApellido(apellido);
				user.setApellido(apellido);
			}
			if (!email.equals(selectedUsuario.getEmail())) {
				 JOptionPane.showMessageDialog(this, "No puede modificar el email", "Modificar Datos De Usuario", JOptionPane.INFORMATION_MESSAGE);

			 /*selectedUsuario.setEmail(email);
				user.setEmail(email);*/
			}
			
			if (selectedUsuario instanceof DataEmpresa && user instanceof Empresa) {
			 DataEmpresa empresa = (DataEmpresa) selectedUsuario;
			 Empresa emp = (Empresa)user;
			 if (!descripcion.equals(empresa.getDescripcion())) {
			 empresa.setDescripcion(descripcion);
			 	emp.setDescripcion(descripcion);
			 }
			 if (!web.equals(empresa.getLinkWeb())) {
			 empresa.setLinkWeb(web);
			 	emp.setLinkWeb(web);
			 }
			 JOptionPane.showMessageDialog(this, "La empresa se modificó con éxito", "Modificar Datos De Usuario", JOptionPane.INFORMATION_MESSAGE);
			 limpiarFormulario();
			 setVisible(false);
			}
			if (selectedUsuario instanceof DataPostulante && user instanceof Postulante) {
			 DataPostulante postulante = (DataPostulante) selectedUsuario;
			 Postulante post = (Postulante) user;
			 
			 if (!nacionalidad.equals(postulante.getNacionalidad())) {
			 postulante.setNacionalidad(nacionalidad);
			 post.setNacionalidad(nacionalidad);
			 }
			 /*if (!nacimiento.equals(postulante.getNacimineto()))
			 postulante.setNacimiento(nacimiento);*/
			 JOptionPane.showMessageDialog(this, "El postulante se modificó con éxito", "Modificar Datos De Usuario", JOptionPane.INFORMATION_MESSAGE);
			 limpiarFormulario();
			 setVisible(false);
			}
}
}
public void limpiarFormulario() {
this.nickname.setText("");
this.nombre.setText("");
this.apellido.setText("");
this.email.setText("");
this.descripcion.setText("");
this.link.setText("");
this.nacionalidad.setText("");
}
private boolean verificarFormularioUsuario() {
String nickname = this.nickname.getText();
String nombre = this.nombre.getText();
String apellido = this.apellido.getText();
String email = this.email.getText();
if (nickname.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || email.isEmpty()) {
JOptionPane.showMessageDialog(this, "No puede haber campos vacíos ", "ATENCIÓN!!",
JOptionPane.ERROR_MESSAGE);
return false;
}
return true; // Retorna verdadero si no hay problemas con el formulario.
}
}
