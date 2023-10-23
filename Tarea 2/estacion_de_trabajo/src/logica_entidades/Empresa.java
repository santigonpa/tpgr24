package logica_entidades;

import java.util.HashMap;
import java.time.LocalDate;

import logica_datatypes.DataEmpresa;
import logica_entidades.OfertaLaboral.EstadoOferta;

public class Empresa extends Usuario{
	//Atributos
	private String descripcion;
	private String web; 
	private CompraPaquete compra;
	private HashMap<String, OfertaLaboral> ofertas;
	private HashMap<String, Paquete> paquetes;

	
	public Empresa(String nickName, String nombre, String apellido, String email, String descripcion, String web, byte[]imagen , String psw) {
		super(nickName, nombre, apellido, email, psw, imagen);
		this.descripcion = descripcion;
		this.web = web; 
		this.compra = null;
		this.ofertas = new HashMap<>();
		this.paquetes = new HashMap<>();
		
		
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
	
	public HashMap<String, OfertaLaboral> getOfertas() {
	    HashMap<String, OfertaLaboral> res = new HashMap<>();
	        
	    for (HashMap.Entry<String, OfertaLaboral> entry : this.ofertas.entrySet()) {
	        LocalDate fechaO = entry.getValue().getFecha(); // FECHA ALTA
	        int sumoDias = entry.getValue().getTipoDeOferta().getDuracion();
	        LocalDate fechaLimite = fechaO.plusDays(sumoDias);
	        
	        if (!fechaLimite.isBefore(LocalDate.now())) { // Verifica si la fecha límite no es antes de la fecha actual
	            res.put(entry.getKey(), entry.getValue());
	        }
	    }
	      
	    return res;
	}

	public void comprarPaquete(Paquete paq, LocalDate fechaVenc,LocalDate fechaDeAlta, int Costo) {
		CompraPaquete compraPaq = new CompraPaquete(Costo,fechaDeAlta,fechaVenc,paq);
		this.compra=compraPaq;
	}

	
	public OfertaLaboral getOferta(String nombreOfer) {
		return this.ofertas.get(nombreOfer);
	}
	

	//setters
	
	public void setDescripcion(String desc) {
		this.descripcion = desc;
	}
	
	public void setLinkWeb(String link) {
		this.web = link;
	}
	
	public void setCompra(CompraPaquete compra){
		this.compra = compra;
	}
	
	public void agregarOfertas(String nombreOf, OfertaLaboral ofer) {
		this.ofertas.put(nombreOf, ofer);
	}
	
	public void agregarPaquetes(String nombrePaq, Paquete paq){
		this.paquetes.put(nombrePaq, paq);
	}

	//obtener info
	
	public int costoPaqueteAsociado() {
		return this.compra.getCosto();
	} 
	
	public boolean tienePaqueteAsociado() {
		return this.compra != null;
	}
	
	public HashMap<String, OfertaLaboral> getOfertasAprobadasDeEmpresa(){
		HashMap<String, OfertaLaboral> res = new HashMap<>();
        
	    for (String ofertaNombre : this.ofertas.keySet()) {
	    	OfertaLaboral oferta = this.ofertas.get(ofertaNombre);
	    		if (oferta.getEstado().equals(EstadoOferta.ACEPTADA)) {
	    			res.put(ofertaNombre, oferta);
	    		}
	    }
	    return res;
	}
	
	public HashMap<String, OfertaLaboral> getOfertasRechazadasIngresadas(){
		HashMap<String, OfertaLaboral> res = new HashMap<>();
        
	    for (String ofertaNombre : this.ofertas.keySet()) {
	    	OfertaLaboral oferta = this.ofertas.get(ofertaNombre);
	    		if (!oferta.getEstado().equals(EstadoOferta.ACEPTADA)) {
	    			res.put(ofertaNombre, oferta);
	    		}
	    }
	    return res;
	}
	
	public boolean tieneOfertas() {
		return !(ofertas.isEmpty());
	}

	public DataEmpresa getDTEmpresa() {
		DataEmpresa DtEmp = new DataEmpresa(this.getNickName(), this.getNombre(), this.getApellido(), this.getEmail(), this.getDescripcion(), this.getLinkWeb(), this.getImagen(), this.getPsw());	
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

	public void linkearOfertaEmpresa(OfertaLaboral nuevaOferta, String nombreOferta) {
		this.ofertas.put(nombreOferta, nuevaOferta);
	}
	
	public HashMap<String, Paquete> getPaquetes(){
		return this.paquetes;
	}

}
