package logica_entidades;

import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import logica_datatypes.DataUsuario;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
public class Usuario {
	
	//Atributos
	private String nickName;
	private String nombre;
	private String apellido;
	private String email;
	private String psw;
	private byte[] imagen; // Nuevo atributo para la imagen de usuario

	//Constructor
	
	public Usuario() {

	}
	
	//Getters
	
	public String getNickName() {
		return nickName;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public String getEmail() {
		return email;
	}

	public String getPsw() {
		return psw;
	}
	
	public byte[] getImagen() {
		return imagen;
	}

	//setters
	
	public void setNickName(String nickname) {
		this.nickName = nickname;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}


	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	//obtener dataTypes
	public DataUsuario getDTUsuario(){
		DataUsuario DtUser = new DataUsuario();
		DtUser.setApellido(this.apellido);
		DtUser.setEmail(this.email);
		DtUser.setImagen(this.imagen);
		DtUser.setNickName(this.nickName);
		DtUser.setNombre(this.nombre);
		DtUser.setPsw(this.psw);
		return DtUser;
	}



}
