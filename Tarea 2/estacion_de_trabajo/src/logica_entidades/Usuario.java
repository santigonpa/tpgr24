package logica_entidades;

import logica_datatypes.DataUsuario;

public class Usuario {
	
	//Atributos
	private String nickName;
	private String nombre;
	private String apellido;
	private String email;
	private String psw;
	private byte[] imagen; // Nuevo atributo para la imagen de usuario

	//Constructor
	
	public Usuario(String nickName, String nombre, String apellido, String email , String psw, byte[] imagen) {
		this.nickName = nickName;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.imagen = imagen;
		this.psw = psw;
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

	//obtener dataTypes
	
	public DataUsuario getDTUsuario(){
		DataUsuario DtUser = new DataUsuario(this.nickName, this.nombre, this.apellido, this.email, this.psw, this.imagen);
		return DtUser;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
}
