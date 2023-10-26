package logica_datatypes;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataEmpresa extends DataUsuario{
	//Atributos
		private String descripcion;
		private String web; 

	//Contructores
		
		public DataEmpresa() {
			super();	 
			
		}
		
		//getters
		
		public String getDescripcion() {
			return descripcion;
		}
		
		public String getLinkWeb(){
			return web;
		}
		
		

		//setters
		
		public void setDescripcion(String desc) {
			this.descripcion = desc;
		}
		
		public void setLinkWeb(String link) {
			this.web = link;
		}
		//esto es para que se muestre el nombre de la empresa en los comboBox
		public String toString() {
	        return this.getNickName(); // Devuelve el nombre de la empresa
	    }
}
