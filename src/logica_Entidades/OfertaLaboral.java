package logica_Entidades;

import java.util.Date;
import java.util.Set;

import logica_DataTypes.DataHorario;
import logica_Entidades.Empresa;
import logica_Entidades.KeyWord;
import logica_Entidades.Postulacion;
import logica_Entidades.TipoPublicacion;

public class OfertaLaboral {
	
	//atributos de la oferta laboral
	
	private String nombre;
	private String descripcion;
	private String ciudad;
	private String departamento;
	private DataHorario horaInicio; // horario de trbaajo asociado
	private DataHorario horaFin;
	private float remuneracion;
	private float costoDeOfertaLaboral; 
	private Date fechaDeAlta; // la del momento en el alta
	
	//Links de oferta
		
	private Set<Postulacion> postulacionesSobreLaOferta;
	private Empresa empresaAsociada;
	private TipoPublicacion tipoDeOferta;
	private Set<KeyWord> palabrasClave;
	
	// Operaciones
	
	
	
	
	
	
}
