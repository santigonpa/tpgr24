package logica_Entidades;

import java.util.Map;

public class KeyWord {
	
	private String palabraClave;
	private Map<String,OfertaLaboral> ofertas; 
	
	public void agregarOfertaAKeyWord(OfertaLaboral nuevaOfertaLaboral) {
		this.ofertas.put(nuevaOfertaLaboral.getNombreOferta(), nuevaOfertaLaboral);
	}

}
