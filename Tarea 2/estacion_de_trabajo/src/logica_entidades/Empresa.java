package logica_entidades;

import java.util.ArrayList;
import java.util.HashMap;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;

import java.time.LocalDate;

import logica_datatypes.DataEmpresa;
import logica_datatypes.DataTipoPublicacion;
import logica_entidades.OfertaLaboral.EstadoOferta;

@XmlAccessorType(XmlAccessType.FIELD)

public class Empresa extends Usuario{
	//Atributos
	private String descripcion;
	private String web; 
	private CompraPaquete compra;
	private HashMap<String, OfertaLaboral> ofertas = new HashMap<String, OfertaLaboral>();
	private HashMap<String, Paquete> paquetes = new HashMap<String, Paquete>();

	
	public Empresa() {
		super();
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
	
	public HashMap<String, OfertaLaboral> getOfertasVencidas() {
	    HashMap<String, OfertaLaboral> res = new HashMap<>();
	        
	    for (HashMap.Entry<String, OfertaLaboral> entry : this.ofertas.entrySet()) {
	        LocalDate fechaO = entry.getValue().getFecha(); // FECHA ALTA
	        int sumoDias = entry.getValue().getTipoDeOferta().getDuracion();
	        LocalDate fechaLimite = fechaO.plusDays(sumoDias);
	        
	        if (fechaLimite.isBefore(LocalDate.now())) { // Verifica si esta vencida la oferta
	            res.put(entry.getKey(), entry.getValue());
	        }
	    }
	      
	    return res;
	}
	
	
	public OfertaLaboral getOferta(String nombreOfer) {
		return this.ofertas.get(nombreOfer);
	}
	
	
	public HashMap<String, Paquete> getPaquetes(){
		return this.paquetes;
	}
	
	public ArrayList<DataTipoPublicacion> getPublicaciones(){
		if(this.tienePaqueteAsociado()) {
			
			CompraPaquete paquete = this.compra;
			ArrayList<TipoPublicacion> tipoPub = paquete.getTipoDePublicacionesDisp();
			ArrayList<DataTipoPublicacion> res = new ArrayList<>();
			for (TipoPublicacion tipo : tipoPub) {
			    res.add(tipo.getDTTipoPublicacion());
			
			}
			return res;
			
		}else {
			return null;
		}
	}


	public DataEmpresa getDTEmpresa() {
		DataEmpresa DtEmp = new DataEmpresa();
		DtEmp.setApellido(this.getApellido());
		DtEmp.setDescripcion(this.getDescripcion());
		DtEmp.setEmail(this.getEmail());
		DtEmp.setImagen(this.getImagen());
		DtEmp.setLinkWeb(this.getLinkWeb());
		DtEmp.setNickName(this.getNickName());
		DtEmp.setNombre(this.getNombre());
		DtEmp.setPsw(this.getPsw());
		return DtEmp;
	}
	
	public HashMap<String, OfertaLaboral> getOfertasRechazadasIngresadas(){
		HashMap<String, OfertaLaboral> res = new HashMap<>();
        HashMap<String,OfertaLaboral> mapa = this.getOfertas();
	    for (String ofertaNombre : mapa.keySet()) {
	    	OfertaLaboral oferta = this.ofertas.get(ofertaNombre);
	    		if (!oferta.getEstado().equals(EstadoOferta.ACEPTADA)) {
	    			res.put(ofertaNombre, oferta);
	    		}
	    }
	    return res;
	}
	
	public HashMap<String, OfertaLaboral> getOfertasAprobadasDeEmpresa(){
		HashMap<String, OfertaLaboral> res = new HashMap<>();
		HashMap<String,OfertaLaboral> mapa = this.getOfertas();
	    for (String ofertaNombre : mapa.keySet()) {
	    	OfertaLaboral oferta = this.ofertas.get(ofertaNombre);
	    		if (oferta.getEstado().equals(EstadoOferta.ACEPTADA)) {
	    			res.put(ofertaNombre, oferta);
	    		}
	    }
	    return res;
	}
	public HashMap<String, OfertaLaboral> getOfertasFinalizadas(){
		HashMap<String, OfertaLaboral> res = new HashMap<>();
		HashMap<String,OfertaLaboral> mapa = this.ofertas;
	    for (String ofertaNombre : mapa.keySet()) {
	    	OfertaLaboral oferta = this.ofertas.get(ofertaNombre);
	    		if (oferta.getEstado().equals(EstadoOferta.FINALIZADA)) {
	    			res.put(ofertaNombre, oferta);
	    		}
	    }
	    return res;
		
	}
	public HashMap<String, OfertaLaboral> getOfertasAprobadasYVencidasDeEmpresa(){
		HashMap<String, OfertaLaboral> res = new HashMap<>();
		HashMap<String,OfertaLaboral> mapa = this.getOfertasVencidas();
	    for (String ofertaNombre : mapa.keySet()) {
	    	OfertaLaboral oferta = this.ofertas.get(ofertaNombre);
	    		if (oferta.getEstado().equals(EstadoOferta.ACEPTADA)) {
	    			res.put(ofertaNombre, oferta);
	    		}
	    }
	    return res;
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
	
	public void setOfertas(HashMap<String, OfertaLaboral> ofer) {
		this.ofertas = ofer;
	}
	
	public void setPaquetes(HashMap<String, Paquete> paq) {
		this.paquetes = paq;
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
	
	
	public boolean tieneOfertas() {
		return !(ofertas.isEmpty());
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

	
	
	public void comprarPaquete(Paquete paq, LocalDate fechaVenc,LocalDate fechaDeAlta, int Costo) {
		CompraPaquete compraPaq = new CompraPaquete();
		compraPaq.setFechaCompr(fechaDeAlta);
		compraPaq.setFechaVenc(fechaVenc);
		compraPaq.setPaquete(paq);
		this.compra=compraPaq;
	}
	public void agregarOfertas(String nombreOf, OfertaLaboral ofer) {
		this.ofertas.put(nombreOf, ofer);
	}
}
