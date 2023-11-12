package logica_entidades;


import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "POSTULACION")
@IdClass(PostulacionId.class)
public class Postulacion implements Serializable {

	  @Id
	    @ManyToOne
	    @JoinColumn(name = "OFERTA_LABORAL_ID", nullable = false)
	    private OfertaLaboral ofertaLaboral;

	    @Id
	    @ManyToOne
	    @JoinColumn(name = "POSTULANTE_ID", nullable = false)
	    private Postulante postulante;
	
	//Atributos    
	
	@Column(nullable = false, name = "Fecha_de_postulacion", columnDefinition = "DATE")
	private LocalDate fecha;
	@Column(nullable = false, name = "Cv")
	private String curri;
	@Column(nullable = false, name = "Motivacion")
	private String motivacion;
	

    
	@Transient
	private String video;
	
	//Constructor
	public Postulacion() {
	}
	
	//setters
	
	public void setFecha(LocalDate fPos5) {
		this.fecha = fPos5;
	}
	
	public void setMotivacion(String motiv) {
		this.motivacion = motiv;
	}
	
	public void setCurri(String curriculum) {
		this.curri = curriculum;
	}
	
	public void setPost(Postulante postu) {
		this.postulante = postu;
	}
	
	public void setOfer(OfertaLaboral ofer) {
		this.ofertaLaboral = ofer;
	}
	//getters
		public String getCV() {
			return this.curri;
		}
	
		public String getMotivacion() {
			return this.motivacion;
		}
		
		public LocalDate getFecha() {
			return this.fecha;
		}
		
		public Postulante getPostulante() {
			return postulante;
		}
		
		public String getNickPostulante() {
			return postulante.getNickName();
		}
		
		public String getNombrePostulante() {
			return postulante.getNombre();
		}
		
		public OfertaLaboral getOferta() {
			return this.ofertaLaboral;
		}
		
		public String getNombreOfer() {
			return ofertaLaboral.getNombreOferta();
		}
		

		
		//SI QUEREMOS QUE ANDEN ESTOS METODOS EN OTRAS CLASES HAY QUE IMPLEMENTARLOS ASI Y FACILITAN BASTANTE LAS COSAS
		@Override
	    public boolean equals(Object obj) {
	        if (this == obj) {
	            return true;
	        }
	        if (obj == null || getClass() != obj.getClass()) {
	            return false;
	        }
	        Postulacion that = (Postulacion) obj;
	        return Objects.equals(fecha, that.fecha) &&
	               Objects.equals(curri, that.curri) &&
	               Objects.equals(motivacion, that.motivacion) &&
	               Objects.equals(postulante, that.postulante) &&
	               Objects.equals(ofertaLaboral, that.ofertaLaboral);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(fecha, curri, motivacion, postulante, ofertaLaboral);
	    }

		public String getVideo() {
			return video;
		}

		public void setVideo(String video) {
			this.video = video;
		}
	
}
