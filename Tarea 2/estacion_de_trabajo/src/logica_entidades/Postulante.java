package logica_entidades;


import logica_datatypes.DataPostulante;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)

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
	
	public List<Postulacion> getPostulaciones(){
		return  this.postulaciones;
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
		List<Postulacion> postulaciones = this.postulaciones;
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
		List<Postulacion> postulaciones = this.postulaciones;
		
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
	
	public List<Postulacion> obtenerPostulaciones(){
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
	    
		List<Postulacion> postulaciones = this.postulaciones;
		for (Postulacion postulacion : postulaciones) {
	        if (postulacion.getOferta().getNombreOferta().equals(nombreOfer)) {
	            pos = postulacion; 
	        }
	    }
	    return pos; 
	}

}
