package logica_Entidades;

import java.time.*;
import java.util.Set;
import java.util.HashSet;



import logica_DataTypes.DataPostulante;

public class Postulante extends Usuario{
	
	//Atributos
	private LocalDate nacimiento;
	private String nacionalidad;
	private Set<Postulacion> postulaciones;
	//Constructores
	
	public Postulante(String nickName, String nombre, String apellido, String email, LocalDate nacimiento, String nacionalidad){
		super(nickName, nombre, apellido, email);
		this.nacimiento = nacimiento;
		this.nacionalidad = nacionalidad;
		this.postulaciones = new HashSet<>();
	}
	
	//getters
	
	public LocalDate getNacimineto() {
		return nacimiento;
	}
	
	public String getNacionalidad() {
		return nacionalidad;
	}
	
	//setters
	
	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
	}
	
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	
	public DataPostulante getDTPostulante() {
		DataPostulante DtPost = new DataPostulante(this.getNickName(), this.getNombre(), this.getApellido(), this.getEmail(), this.nacimiento, this.nacionalidad);
		return DtPost;
	}
	
	//public void agregarPostulacionAPostulante(Postulacion post){
		//String nombreOfer = this.post.getNombreOferta();
		
	//}
	
	public void modificarPos(String nombre, String apellido, int dia, int mes, int anio, String nacionalidad) {
		LocalDate fechaIn = LocalDate.of(dia,  mes, anio);
		if(this.nacimiento.isEqual(fechaIn)){
		}else {
			this.setNacimiento(fechaIn);
		}
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setNacionalidad(nacionalidad);
	}

		public void agregarPostulacionAPostulante(Postulacion postulacion) {
		this.postulaciones.add(postulacion);
	}
	
	public boolean estaPostulado(Postulacion p) {
		if(this.postulaciones.isEmpty()) {
			return false;
		}else {
		return this.postulaciones.contains(p);}
	}
	
	public Set<Postulacion> obtenerPostulaciones(){
		return this.postulaciones;
	}	
	
}
