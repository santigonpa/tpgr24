package logica_DataTypes;

import java.time.*;

public class DataPostulacion extends DataUsuario {

	//Atributos
	private LocalTime fecha;
	private String cv;
	private String motivacion;
	private String nickPostulante;


	//Constructor
	public DataPostulacion(LocalTime fecha2, String cv, String m, String nickPost) {
		this.fecha = fecha2;
		this.cv = cv;
		this.motivacion = m;
		this.nickPostulante = nickPost;
	}
	
	
	
}
