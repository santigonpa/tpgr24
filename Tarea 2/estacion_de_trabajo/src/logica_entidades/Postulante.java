package logica_entidades;


import logica_datatypes.DataPostulante;
import logica_datatypes.WrapperArrayList;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)

public class Postulante extends Usuario{
	
	//Atributos
	private LocalDate nacimiento;
	private String nacionalidad;
	//private ArrayList<Postulacion> postulaciones = new ArrayList<>();
	private WrapperArrayList postulaciones = new WrapperArrayList();
	//Constructores
	
	public Postulante(){
		super();
		
	}
	
	//getters
	
	public WrapperArrayList getPostulaciones(){
		return this.postulaciones;
	}
	
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
		DataPostulante DtPost = new DataPostulante();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = this.nacimiento.format(formatter);
		DtPost.setNickName(this.getNickName());
		DtPost.setNombre(this.getNombre());
		DtPost.setApellido(this.getApellido());
		DtPost.setEmail(this.getEmail());
		DtPost.setNacimiento(formattedDate);
		DtPost.setNacionalidad(nacionalidad);
		DtPost.setPsw(this.getPsw());
		DtPost.setImagen(this.getImagen());
		return DtPost;
	}
	
	//public void agregarPostulacionAPostulante(Postulacion post){
		//String nombreOfer = this.post.getNombreOferta();
		
	//}
	
	public void modificarPos(String nombre, String apellido, int dia, int mes, int anio, String nacionalidad) {
		LocalDate fechaIn = LocalDate.of(anio,  mes, dia);
		if (this.nacimiento.isEqual(fechaIn)){
		}else {
			this.setNacimiento(fechaIn);
		}
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setNacionalidad(nacionalidad);
	}
/*
	public void agregarPostulacionAPostulante(Postulacion postulacion) {
		this.postulaciones.add(postulacion);
	} */
	
	public void agregarPostulacionAPostulante(Postulacion postulacion) {
		@SuppressWarnings("unchecked")
		ArrayList<Postulacion> postulaciones = (ArrayList<Postulacion>) this.postulaciones.getLista();
		postulaciones.add(postulacion);
	}
	/*
	public boolean estaPostulado(Postulacion postu) {
		if (this.postulaciones.isEmpty()) {
			return false;
		}else {
		return this.postulaciones.contains(postu);
		}
	} */
	
	public boolean estaPostulado(Postulacion postu) {
		@SuppressWarnings("unchecked")
		ArrayList<Postulacion> postulaciones = (ArrayList<Postulacion>) this.postulaciones.getLista();
		if (postulaciones.isEmpty()) {
			return false;
		}else {
		return postulaciones.contains(postu);
		}
	}
	
	/*
	public ArrayList<Postulacion> obtenerPostulaciones(){
		return this.postulaciones;
	}	*/
	
	public WrapperArrayList obtenerPostulaciones(){
		return this.postulaciones;
	}
	/*
	public Postulacion encontrarPostulacionPorNombreOferta(String nombreOfer) {
	    Postulacion pos = null;
		for (Postulacion postulacion : postulaciones) {
	        if (postulacion.getOferta().getNombreOferta().equals(nombreOfer)) {
	            pos = postulacion; 
	        }
	    }
	    return pos; 
	} */
	
	public Postulacion encontrarPostulacionPorNombreOferta(String nombreOfer) {
	    Postulacion pos = null;
	    @SuppressWarnings("unchecked")
		ArrayList<Postulacion> postulaciones = (ArrayList<Postulacion>) this.postulaciones.getLista();
		for (Postulacion postulacion : postulaciones) {
	        if (postulacion.getOferta().getNombreOferta().equals(nombreOfer)) {
	            pos = postulacion; 
	        }
	    }
	    return pos; 
	}

}
