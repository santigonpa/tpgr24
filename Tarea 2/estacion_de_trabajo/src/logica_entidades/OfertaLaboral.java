package logica_entidades;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import logica_datatypes.DataOferta;

@XmlAccessorType(XmlAccessType.FIELD)

@Entity
@Table(name = "OFERTA_LABORAL")
public class OfertaLaboral {
	
	//estado de oferta
	public enum EstadoOferta {
        INGRESADA,
        ACEPTADA,
        RECHAZADA,
        FINALIZADA
    }
	 //atributos de la oferta laboral
	@Id
	@GeneratedValue
	private int id;

	
	@Column(unique = true, nullable = false, name = "nombre")
	private String nombre;
	
	@Column(unique = true, name = "Descripcion")
	private String descripcion;
	
	@Column(unique = true, name = "Ciudad")
	private String ciudad;
	
	@Column(unique = true, name = "Departamento")
	private String departamento;
	
	@Column(unique = true, name = "HoraInicio")
	private LocalTime horaInicio;

	@Column(unique = true, name = "HoraFin")
	private LocalTime horaFin;
	
	@Column(unique = true, name = "Remuneracion")
	private int remuneracion;
	
	@Column(unique = true, name = "Costo")
	private int costoDeOfertaLaboral; 
	
	@Column(unique = true, name = "Fecha_Alta")
	private LocalDate fechaDeAlta; // la del momento del alta
	
	@Column(unique = true, name = "Fecha_Baja")
	private LocalDate fechaDeFinalizacion = null; // la fecha es null hasta que se finalice la oferta
	
	@Transient
	private EstadoOferta estado;
	
	@Transient
	private byte[] imagen;
	
	@Column(unique = true, name = "Paquete")
	private String tipoDePago;
	
	//en esta no se si persistirla o no
	private ArrayList<String> ordenPostulaciones = new ArrayList<>();
	
	// En la clase OfertaLaboral
	@OneToMany(mappedBy = "ofertaLaboral", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Postulacion> postulacionesSobreLaOferta = new ArrayList<>();

	
	@ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "EMPRESA_ID", nullable = false)
	private Empresa empresaAsociada;
	
	@Column(unique = true, name = "Tipo_Publicacion")
	private TipoPublicacion tipoDeOferta;
	
	@Transient
	private ArrayList<KeyWord> palabrasClave = new ArrayList<>();;
	//private DataOferta dataOferta;

	@Transient
	private LocalDate fechaCalif = null;

	@Transient
	private int visitas = 0;
	// Operaciones
	
	public OfertaLaboral() {
	}
	
	public DataOferta getDataOferta() {
		DataOferta dataOfer = new DataOferta();
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        if(this.fechaCalif != null) {
        	String formattedDateCalif = this.fechaCalif.format(formatterFecha);
        	dataOfer.setFechaCalif(formattedDateCalif);
        }
      
        String formattedDate = this.fechaDeAlta.format(formatterFecha);
        String formattedTimeHoraFin = this.horaFin.format(formatterHora);
        String formattedTimeHoraInicio = this.horaInicio.format(formatterHora);
		dataOfer.setCiudad(this.ciudad);
		dataOfer.setCostoDeOfertaLaboral(this.costoDeOfertaLaboral);
		dataOfer.setDepartamento(this.departamento);
		dataOfer.setDescripcion(this.descripcion);
		dataOfer.setEmpresa(this.empresaAsociada.getNickName());
		dataOfer.setEstado(this.estado);
		dataOfer.setFechaDeAlta(formattedDate);
		dataOfer.setHoraFin(formattedTimeHoraFin);
		dataOfer.setHoraInicio(formattedTimeHoraInicio);
		dataOfer.setImagen(this.imagen);
		dataOfer.setTipoDePago(this.tipoDePago);
		dataOfer.setRemuneracion(this.remuneracion);
		dataOfer.setNombre(this.nombre);
		
		//dataOfer.setKeyWords(this.palabrasClave);
		return dataOfer;
	}
	
	//setters
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setFechaCalificacion(LocalDate fFin) {
		this.fechaCalif= fFin;
	}
	
	public void setFechaFin(LocalDate fFin) {
		this.fechaDeFinalizacion = fFin;
	}
	
	public void setDescripcion(String desc) {
		this.descripcion = desc;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public void setDepartamento(String dep) {
		this.departamento = dep;
	}
	
	public void setHorarioIni(LocalTime horaini) {
		this.horaInicio = horaini;
	}
	
	public void setHorarioFin(LocalTime horafin) {
		this.horaFin = horafin;
	}
	
	public void setRemuneracion(int rem) {
		this.remuneracion = rem;
	}
	
	public void setCostoOfer(int costo) {
		this.costoDeOfertaLaboral = costo;
	}
		
	public void setFechaAlta(LocalDate fecha) {
		this.fechaDeAlta = fecha;
	}
	
	public void setPostulaciones(ArrayList<Postulacion> post) {
		this.postulacionesSobreLaOferta = post;
	}
	
	public void setTipoPub(TipoPublicacion publi) {
		this.tipoDeOferta = publi;
	}
	
	public void setPalabrasClav(ArrayList<KeyWord> keys) {
		this.palabrasClave = keys;
	}
	
	public void setImagen(byte[] img) {
		this.imagen = img;
	}

	
	public void setEmpresa(Empresa emp) {
		this.empresaAsociada = emp; 
	}
	
	public void setTipoPublicacion(TipoPublicacion tipo){
		this.tipoDeOferta = tipo;
	}

	
	public void setEstado(EstadoOferta estado) {
		if (estado == EstadoOferta.FINALIZADA) {
			this.fechaDeFinalizacion = LocalDate.now(); //si la oferta se finaliza se guarda la fecha de finalizacion
		}
		this.estado = estado;
	}
	
	public void setTipodePago(String pago) {
		this.tipoDePago = pago;
	}
	
	//getters
	
	public LocalDate getFechaFin() {
		return this.fechaDeFinalizacion;
	}
	
	public LocalDate getFechaCalificacion() {
		return this.fechaCalif;
	}
	
	public TipoPublicacion getTipoDeOferta() {
		return this.tipoDeOferta;
	}
	
	public Empresa getEmpresa() {
		return this.empresaAsociada;
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

	public byte[] getImagen() {
		return imagen;
	}

	public String getTipoDePago() {
		return this.tipoDePago;
	}
	public TipoPublicacion getTipoPubli() {
		return this.tipoDeOferta;
	}
	
	public ArrayList<Postulacion> getPostulaciones(){
		return (ArrayList<Postulacion>) this.postulacionesSobreLaOferta;
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

	public ArrayList<String> getOrdenPostulaciones() {
		return ordenPostulaciones;
	}

	public void setOrdenPostulaciones(ArrayList<String> ordenPostulaciones) {
		this.ordenPostulaciones = ordenPostulaciones;
	}

	public LocalDate getFechaDeFinalizacion() {
		return this.fechaDeFinalizacion;
	}

	public void setFechaDeFinalizacion(LocalDate fecha) {
		this.fechaDeFinalizacion = fecha;
	}
	
	public int getVisitas(){
		return this.visitas;
	}
	
	public void setVisitas(int visitas) {
		this.visitas = visitas;
	}
	
	public void visitada() {
		this.visitas++;
	}
}
