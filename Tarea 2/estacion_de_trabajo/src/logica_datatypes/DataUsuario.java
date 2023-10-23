package logica_datatypes;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataUsuario {

	//Atributos
		private String nickName;
		private String nombre;
		private String apellido;
		private String email;
		private String psw;
		private byte[] imagen; // Nuevo atributo para la imagen de usuario

	//constructores
	
	public DataUsuario() {
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

	public byte[] getImagen() {
		return imagen;
	}

	public String getPsw() {
		return psw;
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

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}
}
