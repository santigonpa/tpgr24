package logica_datatypes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import logica_entidades.KeyWord;
import logica_entidades.OfertaLaboral.EstadoOferta;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
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
	private String tipoDePago;
	
	private ArrayList<KeyWord> palabrasClave;

	
	//la del momento en el alta
	
	public DataOferta(){
	}


	//setters
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}

	public void setRemuneracion(float remuneracion) {
		this.remuneracion = remuneracion;
	}

	public void setCostoDeOfertaLaboral(int costoDeOfertaLaboral) {
		this.costoDeOfertaLaboral = costoDeOfertaLaboral;
	}

	public void setFechaDeAlta(LocalDate fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}
	
	public void setEstado(EstadoOferta estado) {
		this.estado = estado;
	}
	
	public void setEmpresa(String emp) {
		this.empresa = emp;
	}
	
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	
	public void setTipoDePago(String tipo) {
		this.tipoDePago = tipo;
	}
	
	public void setKeyWords(ArrayList<KeyWord> keys) {
		this.palabrasClave = keys;
	}

	//gettes
	
	public ArrayList<KeyWord> getKeyWords() {
		return this.palabrasClave;
	}
	
	public String getEmpresa() {
		return this.empresa;
	}
	

	
	public byte[] getImagen() {
		return imagen;
	}

	public String getNombre() {
		return nombre;
	}



	public String getDescripcion() {
		return descripcion;
	}


	public String getCiudad() {
		return ciudad;
	}



	public String getDepartamento() {
		return departamento;
	}



	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public String getHoraInicioString() {
		DateTimeFormatter formateo1 = DateTimeFormatter.ofPattern("HH:mm");
	    return horaInicio.format(formateo1);
	}
	


	public LocalTime getHoraFin() {
		return horaFin;
	}
	
	public String getHoraFinString() {
		DateTimeFormatter formateo2 = DateTimeFormatter.ofPattern("HH:mm");
	    return horaFin.format(formateo2);
	}


	public float getRemuneracion() {
		return remuneracion;
	}



	public int getCostoDeOfertaLaboral() {
		return costoDeOfertaLaboral;
	}



	public LocalDate getFechaDeAlta() {
		return fechaDeAlta;
	}



	public String getFechaAltaComoString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fechaDeAlta.format(formatter);
	}
	

	public EstadoOferta getEstado() {
		return estado;
	}


	public String getTipoDePago() {
		return this.tipoDePago;
	}

	public String toString() {
        return this.getNombre(); // Devuelve el nombre de la oferta
    }

}

