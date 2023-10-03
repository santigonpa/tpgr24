package logica_Entidades;

import java.util.Map;
import java.util.HashMap;

public class KeyWord {
	
	private String palabraClave;
	private Map<String,OfertaLaboral> ofertas; 
	
	public KeyWord(String palabra) {
		this.palabraClave = palabra;
		this.ofertas = new HashMap<>();
	}
	
	public String getPalabraClave() {
		return this.palabraClave;
	}
	
	public void agregarOfertaAKeyWord(OfertaLaboral nuevaOfertaLaboral) {
		this.ofertas.put(nuevaOfertaLaboral.getNombreOferta(), nuevaOfertaLaboral);
	}

}
