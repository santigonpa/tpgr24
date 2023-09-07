package logica_DataTypes;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class DataPostulante extends DataUsuario {
	//Atributos
		private LocalDate nacimiento;
		private String nacionalidad;
		
		//Constructores
		
		public DataPostulante(String nickName, String nombre, String apellido, String email, LocalDate nacimiento, String nacionalidad){
			super(nickName, nombre, apellido, email);
			this.nacimiento = nacimiento;
			this.nacionalidad = nacionalidad;
		}
		
		//getters
		
		public LocalDate getNacimineto() {
			return nacimiento;
		}
		
		public String getNacionalidad() {
			return nacionalidad;
		}
		
		//setters
		
		public void setNacimiento(LocalDate nacimiento) {
			this.nacimiento = nacimiento;
		}
		
		public void setNacionalidad(String nacionalidad) {
			this.nacionalidad = nacionalidad;
		}

		public String getFechaString() {
			// Define el formato deseado
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        
	        // Convierte el LocalDate a una cadena con el formato especificado
	        String fechaFormateada = this.nacimiento.format(formatter);
		return fechaFormateada;
		}
		//esto es para que se muestre el nombre del postulante en los comboBox
				public String toString() {
			        return this.getNickName(); // Devuelve el nombre del postulante
			    }
}
