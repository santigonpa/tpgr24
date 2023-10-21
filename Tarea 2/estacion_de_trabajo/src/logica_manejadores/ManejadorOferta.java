package logica_manejadores;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import logica_datatypes.DataKeyWord;
import logica_datatypes.DataOferta;
import logica_entidades.KeyWord;
import logica_entidades.OfertaLaboral;
import logica_entidades.Postulacion;
import logica_entidades.OfertaLaboral.EstadoOferta;
import utils.Fabrica;

public class ManejadorOferta implements IManejadorOferta{
	

	private static ManejadorOferta instancia;
	private Map<String, OfertaLaboral> ofertasLaborales;
	private Map<String, KeyWord> keywordsTotales;
	private	Set<Postulacion> postulaciones;
	
	private ManejadorOferta() {
		this.ofertasLaborales = new HashMap<String, OfertaLaboral>();
		this.keywordsTotales = new HashMap<String, KeyWord>();
		this.postulaciones = new HashSet<Postulacion>();
	}
	
	public static ManejadorOferta getInstance() {
		if (instancia == null)
			instancia = new ManejadorOferta();
		
		return instancia;
	}
	
	public void addUsuario(OfertaLaboral ofer) {
        String nombre = ofer.getNombreOferta();
        this.ofertasLaborales.put(nombre, ofer);
    }

	public OfertaLaboral obtenerOferta(String nombre) {
		return (OfertaLaboral) this.ofertasLaborales.get(nombre);
	}

	public void linkearKeywords(Set<String> palabrasClaveSelec , OfertaLaboral nuevaOfertaLaboral) {
		for (String kw : palabrasClaveSelec) {
			KeyWord palabra = (KeyWord) this.keywordsTotales.get(kw);
			if (palabra != null) {
				nuevaOfertaLaboral.agregarKeywordAOferta(palabra);
				palabra.agregarOfertaAKeyWord(nuevaOfertaLaboral);
			}
		}
	}

	public void addOferta(OfertaLaboral nuevaOferta) {
		String nombre = nuevaOferta.getNombreOferta();
        this.ofertasLaborales.put(nombre, nuevaOferta);
	}

	public Set<DataKeyWord> getDataKeyWord() {
		Set<DataKeyWord> res = new HashSet<>();
    	Set<KeyWord> temp = new HashSet<>();
    	
    	// Obtener las claves del Map
        Set<String> clavesKeyWord = this.keywordsTotales.keySet();
        for (String nombreKeyword : clavesKeyWord) {
        	KeyWord keyAct = (KeyWord) this.keywordsTotales.get(nombreKeyword);
        	temp.add(keyAct);
        }
        for (KeyWord keyAct: temp) {
        	DataKeyWord nuevaDTKey = new DataKeyWord(keyAct.getPalabraClave());
        	res.add(nuevaDTKey);
        }
        
    	return res;
	}

	public void addKeyword(KeyWord key) {
		this.keywordsTotales.put(key.getPalabraClave(), key);
	
	}

	@Override
	public void addPostulacion(Postulacion pos) {
		this.postulaciones.add(pos);
		
	}

	public boolean existeOferta(String nombre) {
		OfertaLaboral ofer = this.obtenerOferta(nombre);
		return ofer != null;
	}
	
	public Set<DataOferta> getOfertas(){
			
			Set<DataOferta> res = new HashSet<>();
			Map<String, OfertaLaboral> ofer = this.ofertasLaborales;
			if (!ofer.isEmpty()) {
				for (Map.Entry<String, OfertaLaboral> entry : ofer.entrySet()) {
				    res.add(entry.getValue().getDataOferta());
				}
			}
			return res;
		}
	
	public DataOferta getDataOferta(String nombre) {
		DataOferta res = this.obtenerOferta(nombre).getDataOferta();
		return res;
	}

	
	public Set<DataOferta> obtenerOfertasConfirmadasPorKey(String keywordSeleccionada) {
		Set<DataOferta> res = new HashSet<>();
		for (String ofertaNombre : this.ofertasLaborales.keySet() ) {
			OfertaLaboral ofertaReal = this.ofertasLaborales.get(ofertaNombre);
			DataOferta oferta = this.ofertasLaborales.get(ofertaNombre).getDataOferta();
			if (ofertaReal.getKeyWordsString().contains(keywordSeleccionada) && ofertaReal.getEstado().equals(EstadoOferta.ACEPTADA)) {
				res.add(oferta);
			}
		}
		return res;
	}
	
	public Set<Postulacion> obtenerPostulaciones(String oferta, String empresa) {
		Fabrica fab = Fabrica.getInstance();
		IManejadorOferta imo = (IManejadorOferta) fab.getInManejadorOferta();
		OfertaLaboral ofertaLab = imo.obtenerOferta(oferta); 
		Set<Postulacion> postulaciones = ofertaLab.getPostulaciones();
		return postulaciones;		
	}


	} 

