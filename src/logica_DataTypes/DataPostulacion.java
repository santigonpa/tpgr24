package logica_DataTypes;

import java.time.*;

public class DataPostulacion {

	//Atributos
	private LocalDate fecha;
	private String cv;
	private String motivacion;
	private String nickPostulante;


	//Constructor
	public DataPostulacion(LocalDate f, String cv, String m, String nickPost) {
		this.fecha = f;
		this.cv = cv;
		this.motivacion = m;
		this.nickPostulante = nickPost;
	}
	
}
