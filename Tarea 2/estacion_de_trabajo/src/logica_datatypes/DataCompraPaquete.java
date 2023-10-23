package logica_datatypes;

import java.time.LocalDate;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataCompraPaquete {
	//Atributos
	private LocalDate fechaCompra;
	private LocalDate fechaVenc;
	
	//Constructor
	public DataCompraPaquete() {
	}

	public LocalDate getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(LocalDate fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public LocalDate getFechaVenc() {
		return fechaVenc;
	}

	public void setFechaVenc(LocalDate fechaVenc) {
		this.fechaVenc = fechaVenc;
	}
	

}
