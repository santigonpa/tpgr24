package logica_Entidades;

import java.time.*;

import logica_DataTypes.DataPostulacion;

public class Postulacion {

	//Atributos
	private LocalTime fecha;
	private String cv;
	private String motivacion;
	private Postulante post;
	private OfertaLaboral ofer;
	
	//Constructor
	public Postulacion(LocalTime fecha2, String cv, String m, Postulante p, OfertaLaboral ofer) {
		this.fecha = fecha2;
		this.cv = cv;
		this.motivacion = m;
		this.post = p;
		this.ofer = ofer;
	}
	
	//getters
		public Postulante getPostulante() {
			return post;
		}
		
		public String getNickPostulante() {
			return post.getNickName();
		}
		
		public OfertaLaboral getOferta() {
			return ofer;
		}
		
		public String getNombreOfer() {
			return ofer.getNombreOferta();
		}
		
		public DataPostulacion getDTPostulacion() {
			DataPostulacion DtPost = new DataPostulacion(this.fecha, this.cv, this.motivacion, this.post.getNickName());
			return DtPost;
		}
	
}
