package logica_entidades;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import logica_datatypes.DataPostulacion;

@XmlAccessorType(XmlAccessType.FIELD)

public class Postulacion {

	//Atributos
	private LocalDate fecha;
	private String curri;
	private String motivacion;
	private Postulante post;
	private OfertaLaboral ofer;
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
		this.post = postu;
	}
	
	public void setOfer(OfertaLaboral ofer) {
		this.ofer = ofer;
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
			return post;
		}
		
		public String getNickPostulante() {
			return post.getNickName();
		}
		
		public String getNombrePostulante() {
			return post.getNombre();
		}
		
		public OfertaLaboral getOferta() {
			return this.ofer;
		}
		
		public String getNombreOfer() {
			return ofer.getNombreOferta();
		}
		
		public DataPostulacion getDTPostulacion() {
			DataPostulacion DtPost = new DataPostulacion();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        String formattedDate = this.fecha.format(formatter);
			DtPost.setCurri(this.curri);
			DtPost.setMotivacion(this.motivacion);
			DtPost.setFecha(formattedDate);
			DtPost.setNickPostulante(this.post.getNickName());
			DtPost.setNombreOferta(this.ofer.getNombreOferta());
			DtPost.setVideo(this.getVideo());
			return DtPost;
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
	               Objects.equals(post, that.post) &&
	               Objects.equals(ofer, that.ofer);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(fecha, curri, motivacion, post, ofer);
	    }

		public String getVideo() {
			return video;
		}

		public void setVideo(String video) {
			this.video = video;
		}
	
}
