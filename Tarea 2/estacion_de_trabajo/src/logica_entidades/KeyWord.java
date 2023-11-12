package logica_entidades;

import java.util.HashMap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)

public class KeyWord {
	
	private String palabraClave;
	private HashMap<String, OfertaLaboral> ofertas = new HashMap<String, OfertaLaboral>();
	
	public KeyWord() {

	}
	
	//setters
	
	public void setPalabra(String pal) {
		this.palabraClave = pal;
	}
	
	public void setOfertas(HashMap<String, OfertaLaboral> ofertas) {
		this.ofertas = ofertas;
	}
	
	//getters
	
	public String getPalabraClave() {
		return this.palabraClave;
	}
	
	public HashMap<String, OfertaLaboral> getOfertas() {
		return this.ofertas;
	}
	
	public void agregarOfertaAKeyWord(OfertaLaboral nuevaOfertaLaboral) {
		this.ofertas.put(nuevaOfertaLaboral.getNombreOferta(), nuevaOfertaLaboral);
	}

}
