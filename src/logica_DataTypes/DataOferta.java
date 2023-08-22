package logica_DataTypes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class DataOferta {
	
	private String nombre;
	private String descripcion;
	private String ciudad;
	private String departamento;
	private LocalTime horaInicio; //  horario de trbaajo asociado
	private LocalTime horaFin;
	private float remuneracion;
	private float costoDeOfertaLaboral; 
	private LocalDate fechaDeAlta; //la del momento en el alta
	
	public DataOferta(String nombre, String descripcion, String ciudad, 
			String departamento,LocalTime horaInicio2, LocalTime horaFin2
			, float remuneracion , float costoDeOfertaLaboral, LocalDate fechaDeAlta2)
	{
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.descripcion = descripcion;
		this.costoDeOfertaLaboral = costoDeOfertaLaboral;
		this.horaFin = horaFin2;
		this.horaInicio = horaInicio2;
		this.departamento = departamento;
		this.remuneracion = remuneracion;
		this.fechaDeAlta = fechaDeAlta2;
		
	}
}

