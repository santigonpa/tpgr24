package logica_entidades;


import java.time.LocalDate;
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
	
	//Constructor
	public Postulacion(LocalDate fPos5, String curriculum, String motiv, Postulante postu, OfertaLaboral ofer) {
		this.fecha = fPos5;
		this.curri = curriculum;
		this.motivacion = motiv;
		this.post = postu;
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
			DataPostulacion DtPost = new DataPostulacion(this.fecha, this.curri, this.motivacion, this.post.getNickName());
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
	
}
