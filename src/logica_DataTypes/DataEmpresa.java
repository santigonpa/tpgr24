package logica_DataTypes;

public class DataEmpresa extends DataUsuario{
	//Atributos
		private String descripcion;
		private String web; 

	//Contructores
		
		public DataEmpresa(String nickName, String nombre, String apellido, String email, String descripcion, String web) {
			super(nickName, nombre, apellido, email);
			this.descripcion = descripcion;
			this.web = web; 
			
		}
		
		//getters
		
		public String getDescripcion() {
			return descripcion;
		}
		
		public String getLinkWeb(){
			return web;
		}
		
		

		//setters
		
		public void setDescripcion(String d) {
			this.descripcion = d;
		}
		
		public void setLinkWeb(String l) {
			this.web = l;
		}
		//esto es para que se muestre el nombre de la empresa en los comboBox
		public String toString() {
	        return this.getNickName(); // Devuelve el nombre de la empresa
	    }
}
