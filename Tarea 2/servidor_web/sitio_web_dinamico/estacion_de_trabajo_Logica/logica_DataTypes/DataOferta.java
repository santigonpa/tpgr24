package logica_DataTypes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

import logica_Entidades.KeyWord;
import logica_Entidades.OfertaLaboral.EstadoOferta;

public class DataOferta {

		
	private String nombre;
	private String descripcion;
	private String ciudad;
	private String departamento;
	private LocalTime horaInicio; //  horario de trbaajo asociado
	private LocalTime horaFin;
	private float remuneracion;
	private int costoDeOfertaLaboral; 
	private LocalDate fechaDeAlta;
	private EstadoOferta estado;
	private String empresa;
	private byte[] imagen;
	
	private Set<KeyWord> palabrasClave;

	
	//la del momento en el alta
	
	public DataOferta(String nombre, String descripcion, String ciudad, 
			String departamento,LocalTime horaInicio2, LocalTime horaFin2
			, float remuneracion , int costoDeOfertaLaboral, LocalDate fechaDeAlta2, EstadoOferta string, String empresa, byte[]imagen,  Set<KeyWord> palabrasClave)
	{
		this.setNombre(nombre);
		this.setCiudad(ciudad);
		this.setDescripcion(descripcion);
		this.setCostoDeOfertaLaboral(costoDeOfertaLaboral);
		this.setHoraFin(horaFin2);
		this.setHoraInicio(horaInicio2);
		this.setDepartamento(departamento);
		this.setRemuneracion(remuneracion);
		this.setFechaDeAlta(fechaDeAlta2);
		this.setEstado(string);
		this.setEmpresa(empresa);
		this.setImagen(imagen);
		this.palabrasClave = palabrasClave;
	}



	public void setEmpresa(String emp) {
		this.empresa = emp;
	}
	
	public Set<KeyWord> getKeyWords() {
		return this.palabrasClave;
	}
	
	public String getEmpresa() {
		return this.empresa;
	}
	
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	
	public byte[] getImagen() {
		return imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public String getHoraInicioString() {
		DateTimeFormatter formateo1 = DateTimeFormatter.ofPattern("HH:mm");
	    return horaInicio.format(formateo1);
	}
	
	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}
	
	public String getHoraFinString() {
		DateTimeFormatter formateo2 = DateTimeFormatter.ofPattern("HH:mm");
	    return horaFin.format(formateo2);
	}
	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}

	public float getRemuneracion() {
		return remuneracion;
	}

	public void setRemuneracion(float remuneracion) {
		this.remuneracion = remuneracion;
	}

	public int getCostoDeOfertaLaboral() {
		return costoDeOfertaLaboral;
	}

	public void setCostoDeOfertaLaboral(int costoDeOfertaLaboral) {
		this.costoDeOfertaLaboral = costoDeOfertaLaboral;
	}

	public LocalDate getFechaDeAlta() {
		return fechaDeAlta;
	}

	public void setFechaDeAlta(LocalDate fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}

	public String getFechaAltaComoString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fechaDeAlta.format(formatter);
	}
	
	public String toString() {
        return this.getNombre(); // Devuelve el nombre de la oferta
    }

	public EstadoOferta getEstado() {
		return estado;
	}

	public void setEstado(EstadoOferta estado) {
		this.estado = estado;
	}

}

