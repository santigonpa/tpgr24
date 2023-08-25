package logica_Entidades;
import java.time.*;
import java.util.Date;
import java.util.Set;

import logica_DataTypes.DataHorario;
import logica_DataTypes.DataOferta;
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
	private LocalTime horaInicio; // horario de trabajo asociado - mejor usar la libreria, pase de DataHorario
	private LocalTime horaFin;
	private int remuneracion;
	private int costoDeOfertaLaboral; 
	private java.sql.Date fechaDeAlta; // la del momento en el alta
	
	//Links de oferta
		
	private Set<Postulacion> postulacionesSobreLaOferta;
	private Empresa empresaAsociada;
	private TipoPublicacion tipoDeOferta;
	private Set<KeyWord> palabrasClave;
	//private DataOferta dataOferta;
	
	// Operaciones
	
	public OfertaLaboral(String nombre, String descripcion, String ciudad, 
			String departamento,LocalTime horarioInicio, LocalTime horarioFin
			, float remuneracion , float costoDeOfertaLaboral, java.util.Date fecha)
	{
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.descripcion = descripcion;
		this.costoDeOfertaLaboral = costoDeOfertaLaboral;
		this.horaFin = horarioFin;
		this.horaInicio = horarioInicio;
		this.departamento = departamento;
		this.remuneracion = remuneracion;
		this.fechaDeAlta = (java.sql.Date) fecha;
	}
	
	public DataOferta getDataOferta() {
		DataOferta DO = new DataOferta(this.nombre, this.descripcion, this.ciudad, 
				this.departamento,this.horaInicio, this.horaFin
				, this.remuneracion , this.costoDeOfertaLaboral, this.fechaDeAlta);
		return DO;
	}
	
	public void setEmpresa(Empresa e) {
		this.empresaAsociada = e; 
	}
	
	public boolean existeLaPostulacion(String postulante) {
		boolean condicion = false;
		if (this.postulacionesSobreLaOferta != null) {
			for(Postulacion pos : this.postulacionesSobreLaOferta) {
				if(pos.getNickPostulante().equals(postulante)) { //para comparar strings usamos equals
					condicion = true;
					break;
				}
					
			}
		}
		return condicion;
	}
	
	public void agregarKeywordAOferta(KeyWord key) {
		this.palabrasClave.add(key);
	}
	
	public void agregarPostulacionAOferta(Postulacion postulacion) {
		this.postulacionesSobreLaOferta.add(postulacion);
	}
	
	public void setTipoPublicacion(TipoPublicacion tp){
		this.tipoDeOferta = tp;
	}

	public String getNombreOferta() {
		return this.nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public String getCiudad() {
		return this.ciudad;
	}

	public String getDepartamento() {
		return this.departamento;
	}

	public int getRemuneracion() {
		// TODO Auto-generated method stub
		return this.remuneracion;
	}

	public String getFechaAltaComoString() {
		Date fecha = this.fechaDeAlta;
		String res = fecha.getDay() + "" + fecha.getMonth() + "" + fecha.getYear() + "";
		return res;
	}
	
	
}
