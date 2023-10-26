package logica_datatypes;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataKeyWord {
	
	private String palabraClave;
	
	public DataKeyWord() {
	}
	
	public String getPalabraClave() {
		return this.palabraClave;
	}

	public void setPalabraclave(String palabra) {
		this.palabraClave = palabra;
	}
	//esto es para que se muestre el nombre de la palabra clave en los comboBox
	public String toString() {
		return this.getPalabraClave(); // Devuelve el nombre de la palabra clave
	}
}
