package logica_Entidades;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import logica_DataTypes.DataOferta;

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
	private LocalDate fechaDeAlta; // la del momento en el alta
	
	//Links de oferta
		
	private Set<Postulacion> postulacionesSobreLaOferta;
	private Empresa empresaAsociada;
	private TipoPublicacion tipoDeOferta;
	private Set<KeyWord> palabrasClave;
	//private DataOferta dataOferta;
	
	// Operaciones
	
	public OfertaLaboral(String nombre, String descripcion, String ciudad, 
			String departamento,LocalTime horarioInicio, LocalTime horarioFin
			, int remuneracion2 , int costoOfertaLaboral, LocalDate fecha)
	{
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.descripcion = descripcion;
		this.costoDeOfertaLaboral = (int) costoOfertaLaboral;
		this.horaFin = horarioFin;
		this.horaInicio = horarioInicio;
		this.departamento = departamento;
		this.remuneracion = (int) remuneracion2;
		this.fechaDeAlta = (LocalDate) fecha;
		this.palabrasClave = new HashSet<KeyWord>();
		//this.postulacionesSobreLaOferta = new HashSet<>();
		this.postulacionesSobreLaOferta = new HashSet<Postulacion>();
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
	public TipoPublicacion getTipoDeOferta() {
		return this.tipoDeOferta;
	}
	
	public Empresa getEmpresa() {
		return this.empresaAsociada;
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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fechaDeAlta.format(formatter);
    }
	
	public boolean existePostulacion(String post) {
		if(postulacionesSobreLaOferta != null) {
			for(Postulacion postulaciones : postulacionesSobreLaOferta) {
				if(postulaciones.getNickPostulante().equals(post)) {
					return true;
				}
			}
		}
		return false;
	}

	public LocalTime getHoraInicio() {
		
		return this.horaInicio;
	}
public LocalTime getHoraFin() {
		
		return this.horaFin;
	}

	public int getCosto() {
		// Auto-generated method stub
		return this.costoDeOfertaLaboral;
	}

	public LocalDate getFecha() {
		
		return this.fechaDeAlta;
	}
	
	public Set<String> getPostulantesString(){
		Set<String> res = new HashSet<>();
		if(this.postulacionesSobreLaOferta != null){
			for(Postulacion pos : postulacionesSobreLaOferta) {
				res.add(pos.getNickPostulante());
			}
		}
	return res;
	}
	
	public Set<String> getKeyWordsString(){
		Set<String> res = new HashSet<>();
		
		for (KeyWord kw: this.palabrasClave) {
			res.add(kw.getPalabraClave());
		}
		return res;
	}
}
