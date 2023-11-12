package logica_entidades;

import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.Iterator;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import logica_datatypes.DataUsuario;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)

@Entity
@Table(name = "USUARIO")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "USER_TYPE", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("USUARIO")
public abstract class Usuario {
	
	//Atributos
	
	//me dicen que los usuario van a tener un pk id
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
	@Column(unique = true, nullable = false, name = "NickName")
	private String nickName;
    
	@Column(nullable = false, name = "Nombre")
    private String nombre;
    
	@Column(nullable = false, name = "Apellido")
    private String apellido;
    
	@Column(nullable = false, name = "Email")
    private String email;
	
	@OneToOne(mappedBy = "user", cascade = CascadeType.PERSIST)
    private Empresa empresa;

	@OneToOne(mappedBy = "user", cascade = CascadeType.PERSIST)
    private Postulante postulante;
    
	@Transient
	private String psw;
    
	@Lob
	private byte[] imagen; // Nuevo atributo para la imagen de usuario
    
	@Transient
	private ArrayList<Usuario> usuariosQueMeSiguen = new ArrayList<>();
    
	@Transient
    private ArrayList<Usuario> usuariosQueYoSigo = new ArrayList<>();
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


	public ArrayList<Usuario> getUsuariosQueMeSiguen() {
		return usuariosQueMeSiguen;
	}

	public void setUsuariosQueMeSiguen(ArrayList<Usuario> usuariosQueMeSiguen) {
		this.usuariosQueMeSiguen = usuariosQueMeSiguen;
	}

	public ArrayList<Usuario> getUsuariosQueYoSigo() {
		return usuariosQueYoSigo;
	}

	public void setUsuariosQueYoSigo(ArrayList<Usuario> usuariosQueYoSigo) {
		this.usuariosQueYoSigo = usuariosQueYoSigo;
	}

	public void agregarSeguidor(Usuario userSeguidor) {
		if (!this.nickName.equals(userSeguidor.getNickName())) {
		this.usuariosQueMeSiguen.add(userSeguidor);
		}
	}
	public void seguirAUsuario(Usuario userASeguir) {
		if (!this.nickName.equals(userASeguir.getNickName())) {
		this.usuariosQueYoSigo.add(userASeguir);
		}
	}

	public void dejarDeSeguirAUsuario(Usuario userASeguir) {
	    Iterator<Usuario> iterator = this.usuariosQueYoSigo.iterator();
	    while (iterator.hasNext()) {
	        Usuario user = iterator.next();
	        if (user.getNickName().equals(userASeguir.getNickName())) {
	            iterator.remove();
	        }
	    }
	}

	public void quitarSeguidor(Usuario userSeguidor) {
	    Iterator<Usuario> iterator = this.usuariosQueMeSiguen.iterator();
	    while (iterator.hasNext()) {
	        Usuario user = iterator.next();
	        if (user.getNickName().equals(userSeguidor.getNickName())) {
	            iterator.remove();
	        }
	    }
	}




}

