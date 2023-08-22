package logica_DataTypes;

import java.time.*;

public class DataCompraPaquete {
	
	//Atributos
	private LocalDate fechaCompra;
	private LocalDate fechaVenc;
	
	//Contrusctor
	public DataCompraPaquete(LocalDate fechaCompra, LocalDate fechaVenc) {
		this.fechaCompra = fechaCompra;
		this.fechaVenc = fechaVenc;
	}
	

}
