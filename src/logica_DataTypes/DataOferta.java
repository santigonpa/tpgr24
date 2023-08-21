package logica_DataTypes;

import java.util.Date;

public class DataOferta {
	
	private String nombre;
	private String descripcion;
	private String ciudad;
	private String departamento;
	private DataHorario horaInicio; // horario de trbaajo asociado
	private DataHorario horaFin;
	private float remuneracion;
	private float costoDeOfertaLaboral; 
	private Date fechaDeAlta; //la del momento en el alta
	
	public DataOferta(String nombre, String descripcion, String ciudad, 
			String departamento,DataHorario horaInicio, DataHorario horaFin
			, float remuneracion , float costoDeOfertaLaboral, Date fechaDeAlta)
	{
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.descripcion = descripcion;
		this.costoDeOfertaLaboral = costoDeOfertaLaboral;
		this.horaFin = horaFin;
		this.horaInicio = horaInicio;
		this.departamento = departamento;
		this.remuneracion = remuneracion;
		this.fechaDeAlta = fechaDeAlta;
		
	}
}

