package logica_entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import logica_datatypes.DataOferta;

@XmlAccessorType(XmlAccessType.FIELD)

public class OfertaLaboral {
	
	//estado de oferta
	public enum EstadoOferta {
        INGRESADA,
        ACEPTADA,
        RECHAZADA
    }
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
	private EstadoOferta estado;
	private byte[] imagen;
	private String tipoDePago;
	
	//Links de oferta
		
	private ArrayList<Postulacion> postulacionesSobreLaOferta;
	private Empresa empresaAsociada;
	private TipoPublicacion tipoDeOferta;
	private ArrayList<KeyWord> palabrasClave;
	//private DataOferta dataOferta;
	
	// Operaciones
	
	public OfertaLaboral(String nombre, String descripcion, String ciudad, 
			String departamento, LocalTime horarioInicio, LocalTime horarioFin
			, int remuneracion2 , int costoOfertaLaboral, LocalDate fecha, byte[]imagen, String tipoDePago){
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.descripcion = descripcion;
		this.costoDeOfertaLaboral = (int) costoOfertaLaboral;
		this.horaFin = horarioFin;
		this.horaInicio = horarioInicio;
		this.departamento = departamento;
		this.remuneracion = (int) remuneracion2;
		this.fechaDeAlta = (LocalDate) fecha;
		this.palabrasClave = new ArrayList<KeyWord>();
		//this.postulacionesSobreLaOferta = new HashSet<>();
		this.postulacionesSobreLaOferta = new ArrayList<Postulacion>();
		this.estado = EstadoOferta.INGRESADA;
		this.imagen = imagen;
		this.tipoDePago = tipoDePago;
	}
	
	public DataOferta getDataOferta() {
		DataOferta dataOfer = new DataOferta(this.nombre, this.descripcion, this.ciudad, 
				this.departamento, this.horaInicio, this.horaFin
				, this.remuneracion , this.costoDeOfertaLaboral, this.fechaDeAlta, this.estado, this.empresaAsociada.getNickName(), this.imagen, this.palabrasClave, this.tipoDePago);
		return dataOfer;
	}
	
	public void setEmpresa(Empresa emp) {
		this.empresaAsociada = emp; 
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
			for (Postulacion pos : this.postulacionesSobreLaOferta) {
				if (pos.getNickPostulante().equals(postulante)) { //para comparar strings usamos equals
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
	
	public void setTipoPublicacion(TipoPublicacion tipo){
		this.tipoDeOferta = tipo;
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
		return this.remuneracion;
	}

	public String getFechaAltaComoString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fechaDeAlta.format(formatter);
    }
	
	public boolean existePostulacion(String post) {
		if (postulacionesSobreLaOferta != null) {
			for (Postulacion postulaciones : postulacionesSobreLaOferta) {
				if (postulaciones.getNickPostulante().equals(post)) {
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
	
	public ArrayList<String> getPostulantesString(){
		ArrayList<String> res = new ArrayList<>();
		if (this.postulacionesSobreLaOferta != null){
			for (Postulacion pos : postulacionesSobreLaOferta) {
				res.add(pos.getNickPostulante());
			}
		}
	return res;
	}
	
	public ArrayList<String> getKeyWordsString(){
		ArrayList<String> res = new ArrayList<>();
		
		for (KeyWord kw: this.palabrasClave) {
			res.add(kw.getPalabraClave());
		}
		return res;
	}

	public EstadoOferta getEstado() {
		return estado;
	}

	public void setEstado(EstadoOferta estado) {
		this.estado = estado;
	}
	
	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] img) {
		this.imagen = img;
	}

	public String getTipoDePago() {
		return this.tipoDePago;
	}
	public TipoPublicacion getTipoPubli() {
		return this.tipoDeOferta;
	}
	
	public ArrayList<Postulacion> getPostulaciones(){
		return this.postulacionesSobreLaOferta;
	}
}
