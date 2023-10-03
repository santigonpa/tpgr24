package logica_DataTypes;

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
	
	public DataUsuario(String nickName, String nombre, String apellido, String email , String psw, byte[] imagen) {
		this.nickName = nickName;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.setImagen(imagen);
		this.setPsw(psw);
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

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}
}
