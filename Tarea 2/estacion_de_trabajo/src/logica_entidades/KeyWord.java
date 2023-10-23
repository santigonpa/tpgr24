package logica_entidades;

import java.util.HashMap;

public class KeyWord {
	
	private String palabraClave;
	private HashMap<String, OfertaLaboral> ofertas; 
	
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
