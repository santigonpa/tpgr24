package logica_Entidades;

import java.util.Map;
import java.time.LocalDate;
import java.util.HashMap;

import logica_DataTypes.DataEmpresa;

public class Empresa extends Usuario{
	//Atributos
	private String descripcion;
	private String web; 
	private CompraPaquete compra;
	private Map<String, OfertaLaboral> ofertas;

	public Empresa(String nickName, String nombre, String apellido, String email, String descripcion, String web) {
		super(nickName, nombre, apellido, email);
		this.descripcion = descripcion;
		this.web = web; 
		this.compra = null;
		this.ofertas = new HashMap<>();
		
	}
	
	//getters
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public String getLinkWeb(){
		return web;
	}
	
	public CompraPaquete getCompra() {
		return compra;
	}
	
	public Map<String, OfertaLaboral> getOfertas() {
	    Map<String, OfertaLaboral> res = new HashMap<>();
	        
	    for (Map.Entry<String, OfertaLaboral> entry : this.ofertas.entrySet()) {
	        LocalDate fechaO = entry.getValue().getFecha(); // FECHA ALTA
	        int sumoDias = entry.getValue().getTipoDeOferta().getDuracion();
	        LocalDate fechaLimite = fechaO.plusDays(sumoDias);
	        
	        if (!fechaLimite.isBefore(LocalDate.now())) { // Verifica si la fecha límite no es antes de la fecha actual
	            res.put(entry.getKey(), entry.getValue());
	        }
	    }
	      
	    return res;
	}


	
	public OfertaLaboral getOferta(String nombreOfer) {
		return this.ofertas.get(nombreOfer);
	}
	

	//setters
	
	public void setDescripcion(String d) {
		this.descripcion = d;
	}
	
	public void setLinkWeb(String l) {
		this.web = l;
	}
	
	public void setCompra(CompraPaquete compra){
		this.compra = compra;
	}
	
	public void agregarOfertas(String nombreOf, OfertaLaboral of) {
		this.ofertas.put(nombreOf, of);
	}
	
	//obtener info
	
	public int costoPaqueteAsociado() {
		return this.compra.getCosto();
	} 
	
	public boolean tienePaqueteAsociado() {
		return (this.compra != null);
	}
	
	public boolean tieneOfertas() {
		return !(ofertas.isEmpty());
	}

	public DataEmpresa getDTEmpresa() {
		DataEmpresa DtEmp = new DataEmpresa(this.getNickName(), this.getNombre(), this.getApellido(), this.getEmail(), this.getDescripcion(), this.getLinkWeb());	
		return DtEmp;
	}
	
//	public void linkearOfertaEmpresa(OfertaLaboral of) {
//		this.ofertas.put(of.getNombre(), of);
		
//	}
	
	public void modificarEm(String nombre, String apellido, String descripcion, String link) {
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setDescripcion(descripcion);
		this.setLinkWeb(link);
	}

	public void linkearOfertaEmpresa(OfertaLaboral nuevaOferta,String nombreOferta) {
		this.ofertas.put(nombreOferta, nuevaOferta);
	}

}
