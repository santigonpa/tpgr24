package logica_Entidades;

import logica_DataTypes.DataUsuario;

public abstract class Usuario {
	
	//Atributos
	private String nickName;
	private String nombre;
	private String apellido;
	private String email;

	//Constructor
	
	public Usuario(String nickName, String nombre, String apellido, String email) {
		this.nickName = nickName;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
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
		DataUsuario DtUser = new DataUsuario(this.nickName, this.nombre, this.apellido, this.email);
		return DtUser;
	}
}
