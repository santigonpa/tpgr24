package logica_DataTypes;

import java.time.*;
import java.util.HashMap;
import java.util.Map;

import logica_Entidades.Postulacion;

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
		
}
