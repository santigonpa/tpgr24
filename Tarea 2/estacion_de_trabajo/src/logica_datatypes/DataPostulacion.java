package logica_datatypes;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataPostulacion extends DataUsuario {

	//Atributos
	private String fecha; 
	private String curri;
	private String motivacion;
	private String nickPostulante;


	//Constructor
	public DataPostulacion() {
	
	}

	//setters

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setCv(String curri) {
		this.curri = curri;
	}

	public void setMotivacion(String motivacion) {
		this.motivacion = motivacion;
	}


	public void setNickPostulante(String nickPostulante) {
		this.nickPostulante = nickPostulante;
	}
	
	//getters
	
	public String getFecha() {
		return fecha;
	}


	public String getCv() {
		return curri;
	}

	public String getMotivacion() {
		return motivacion;
	}


	public String getNickPostulante() {
		return nickPostulante;
	}


	
	
}
