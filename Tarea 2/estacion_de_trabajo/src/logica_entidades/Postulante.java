package logica_entidades;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.ArrayList;



@Entity
@DiscriminatorValue("POSTULANTE")
public class Postulante extends Usuario {
	
	//Atributos
	
    @Column(nullable = false, name = "Fecha de Nacimiento", columnDefinition = "DATE")
    private LocalDate nacimiento;
    
    @Column(nullable = false, name = "Nacionalidad")
    private String nacionalidad;
	
    @MapsId
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "USUARIO_ID", nullable = true, unique = true)
    private Usuario user;
	
 // En la clase Postulante
    @OneToMany(mappedBy = "postulante", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Postulacion> postulaciones = new ArrayList<>();

    
   
	public Postulante(){
		super();
		
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
		ArrayList<Postulacion> postulaciones = (ArrayList<Postulacion>) this.postulaciones;
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
		ArrayList<Postulacion> postulaciones = (ArrayList<Postulacion>) this.postulaciones;
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
	
	public ArrayList obtenerPostulaciones(){
		return (ArrayList) this.postulaciones;
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
		ArrayList<Postulacion> postulaciones = (ArrayList<Postulacion>) this.postulaciones;
		for (Postulacion postulacion : postulaciones) {
	        if (postulacion.getOferta().getNombreOferta().equals(nombreOfer)) {
	            pos = postulacion; 
	        }
	    }
	    return pos; 
	}

}
