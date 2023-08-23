package logica_DataTypes;

public class DataKeyWord {
	
	private String palabraClave;
	
	public DataKeyWord(String palabra) {
		this.palabraClave = palabra;
	}
	
	public String getPalabraClave() {
		return this.palabraClave;
	}

	//esto es para que se muestre el nombre de la palabra clave en los comboBox
	public String toString() {
		return this.getPalabraClave(); // Devuelve el nombre de la palabra clave
	}
}
