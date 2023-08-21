package logica_entidades;

import logica_dataTypes.dataHorario;
import logica_entidades.postulacion;
import logica_entidades.empresa;
import logica_entidades.tipoPublicacion;
import logica_entidades.KeyWord;

import java.util.Date;
import java.util.Set;

public class ofertaLaboral {
	
	//atributos de la oferta laboral
	
	private String nombre;
	private String descripcion;
	private String ciudad;
	private String departamento;
	private dataHorario horaInicio; // horario de trbaajo asociado
	private dataHorario horaFin;
	private float remuneracion;
	private float costoDeOfertaLaboral; 
	private Date fechaDeAlta; // la del momento en el alta
	
	//Links de oferta
		
	private Set<postulacion> postulacionesSobreLaOferta;
	private empresa empresaAsociada;
	private tipoPublicacion tipoDeOferta;
	private Set<KeyWord> palabrasClave;
	
	// Operaciones
	
	
	
	
	
	
}
