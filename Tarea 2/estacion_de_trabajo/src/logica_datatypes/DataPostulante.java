package logica_datatypes;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataPostulante extends DataUsuario {
	//Atributos
		private LocalDate nacimiento;
		private String nacionalidad;
		
		//Constructores
		
		public DataPostulante(){
			super();
		}
		
		//getters
		
		public LocalDate getNacimineto() {
			return nacimiento;
		}
		
		public String getNacionalidad() {
			return nacionalidad;
		}

		public String getFechaString() {
			// Define el formato deseado
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        
	        // Convierte el LocalDate a una cadena con el formato especificado
	        String fechaFormateada = this.nacimiento.format(formatter);
		return fechaFormateada;
		}
		
		//setters
		
		public void setNacimiento(LocalDate nacimiento) {
			this.nacimiento = nacimiento;
		}
		
		public void setNacionalidad(String nacionalidad) {
			this.nacionalidad = nacionalidad;
		}

		//esto es para que se muestre el nombre del postulante en los comboBox
				public String toString() {
			        return this.getNickName(); // Devuelve el nombre del postulante
			    }
}
