package logica_datatypes;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataPostulante extends DataUsuario {
	//Atributos
		private String nacimiento;
		private String nacionalidad;
		
		//Constructores
		
		public DataPostulante(){
			super();
		}
		
		//getters
		
		public String getNacimineto() {
			return nacimiento;
		}
		
		public String getNacionalidad() {
			return nacionalidad;
		}

		
		
		//setters
		
		public void setNacimiento(String nacimiento) {
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
