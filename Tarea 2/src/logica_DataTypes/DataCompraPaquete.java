package logica_DataTypes;

import java.time.*;

public class DataCompraPaquete {
	//Atributos
	private LocalDate fechaCompra;
	private LocalDate fechaVenc;
	
	//Constructor
	public DataCompraPaquete(LocalDate fechaCompra, LocalDate fechaVenc) {
		this.setFechaCompra(fechaCompra);
		this.setFechaVenc(fechaVenc);
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
