package logica_Entidades;

import java.util.Map;

public class KeyWord {
	
	private String palabraClave;
	private Map<String,OfertaLaboral> ofertas; 
	
	public KeyWord(String palabra) {
		this.palabraClave = palabra;
	}
	
	public String getPalabraClave() {
		return this.palabraClave;
	}
	
	public void agregarOfertaAKeyWord(OfertaLaboral nuevaOfertaLaboral) {
		this.ofertas.put(nuevaOfertaLaboral.getNombreOferta(), nuevaOfertaLaboral);
	}

}
