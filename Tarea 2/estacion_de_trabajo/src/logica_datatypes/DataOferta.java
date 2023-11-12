package logica_datatypes;

import logica_entidades.OfertaLaboral.EstadoOferta;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataOferta {

		
	private String nombre;
	private String descripcion;
	private String ciudad;
	private String departamento;
	private String horaInicio; //  horario de trbaajo asociado
	private String horaFin;  // ESTOS ERAN LOCALTIME
	private float remuneracion;
	private int costoDeOfertaLaboral; 
	private String fechaDeAlta; // esto era LocalDate
	private EstadoOferta estado;
	private String empresa;
	private byte[] imagen;
	private String tipoDePago;
	private String fechaFin;
	private String fechaCalif;
	
	//private ArrayList<KeyWord> palabrasClave;

	
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

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public void setRemuneracion(float remuneracion) {
		this.remuneracion = remuneracion;
	}

	public void setCostoDeOfertaLaboral(int costoDeOfertaLaboral) {
		this.costoDeOfertaLaboral = costoDeOfertaLaboral;
	}

	public void setFechaDeAlta(String fechaDeAlta) {
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
	
	/*public void setKeyWords(ArrayList<KeyWord> keys) {
		this.palabrasClave = keys;
	}*/

	//gettes
	/*
	public ArrayList<KeyWord> getKeyWords() {
		return this.palabrasClave;
	}
	*/
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



	public String getHoraInicio() {
		return horaInicio;
	}

	
	


	public String getHoraFin() {
		return horaFin;
	}
	
	


	public float getRemuneracion() {
		return remuneracion;
	}



	public int getCostoDeOfertaLaboral() {
		return costoDeOfertaLaboral;
	}



	public String getFechaDeAlta() {
		return fechaDeAlta;
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


	public String getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}


	public String getFechaCalif() {
		return fechaCalif;
	}


	public void setFechaCalif(String fechaCalif) {
		this.fechaCalif = fechaCalif;
	}

}

