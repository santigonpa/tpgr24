package logica_manejadores;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import logica_datatypes.DataKeyWord;
import logica_datatypes.DataOferta;
import logica_entidades.KeyWord;
import logica_entidades.OfertaLaboral;
import logica_entidades.Postulacion;
import logica_entidades.OfertaLaboral.EstadoOferta;
import utils.Fabrica;

public class ManejadorOferta implements IManejadorOferta{
	

	private static ManejadorOferta instancia;
	private HashMap<String, OfertaLaboral> ofertasLaborales;
	private HashMap<String, OfertaLaboral> ofertasFinalizadas;
	private HashMap<String, KeyWord> keywordsTotales;
	private	ArrayList<Postulacion> postulaciones;
	
	private ManejadorOferta() {
		this.ofertasLaborales = new HashMap<String, OfertaLaboral>();
		this.ofertasFinalizadas = new HashMap<String, OfertaLaboral>();
		this.keywordsTotales = new HashMap<String, KeyWord>();
		this.postulaciones = new ArrayList<Postulacion>();
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

	public void linkearKeywords(ArrayList<String> palabrasClaveSelec , OfertaLaboral nuevaOfertaLaboral) {
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

	public ArrayList<DataKeyWord> getDataKeyWord() {
		ArrayList<DataKeyWord> res = new ArrayList<>();
		ArrayList<KeyWord> temp = new ArrayList<>();
    	
    	// Obtener las claves del Map
		ArrayList<String> clavesKeyWord = new ArrayList<>(this.keywordsTotales.keySet());
        for (String nombreKeyword : clavesKeyWord) {
        	KeyWord keyAct = (KeyWord) this.keywordsTotales.get(nombreKeyword);
        	temp.add(keyAct);
        }
        for (KeyWord keyAct: temp) {
        	DataKeyWord nuevaDTKey = new DataKeyWord();
        	nuevaDTKey.setPalabraclave(keyAct.getPalabraClave());
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
	
	public ArrayList<DataOferta> getOfertas(){	
		ArrayList<DataOferta> res = new ArrayList<>();
		HashMap<String, OfertaLaboral> ofer = this.ofertasLaborales;
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

	
	public ArrayList<DataOferta> obtenerOfertasConfirmadasPorKey(String keywordSeleccionada) {
		ArrayList<DataOferta> res = new ArrayList<>();
		for (String ofertaNombre : this.ofertasLaborales.keySet() ) {
			OfertaLaboral ofertaReal = this.ofertasLaborales.get(ofertaNombre);
			DataOferta oferta = this.ofertasLaborales.get(ofertaNombre).getDataOferta();
			
			if (ofertaReal.getKeyWordsString().contains(keywordSeleccionada) && ofertaReal.getEstado().equals(EstadoOferta.ACEPTADA)) {
				 LocalDate fechaO = ofertaReal.getFecha();
				 int sumoDias = ofertaReal.getTipoDeOferta().getDuracion();
				 LocalDate fechaLimite = fechaO.plusDays(sumoDias);
				 
				 if (!fechaLimite.isBefore(LocalDate.now())) { // Controlo que este vigente
					 res.add(oferta);
				 } 	
			}
		}
		return res;
	}
	
	public ArrayList<Postulacion> obtenerPostulaciones(String oferta, String empresa) {
		Fabrica fab = Fabrica.getInstance();
		IManejadorOferta imo = (IManejadorOferta) fab.getInManejadorOferta();
		OfertaLaboral ofertaLab = imo.obtenerOferta(oferta); 
		ArrayList<Postulacion> postulaciones = ofertaLab.getPostulaciones();
		return postulaciones;		
	}

	public DataKeyWord getDataKeyWordPorNombre(String nombre) {
		DataKeyWord dataRes = new DataKeyWord();
		dataRes.setPalabraclave(nombre);
		return dataRes;
	}
	
	public void finalizarOferta(String oferta) {
		OfertaLaboral ofer = this.obtenerOferta(oferta);
		ofer.setEstado(EstadoOferta.FINALIZADA);
		this.ofertasFinalizadas.put(oferta, ofer);
	}
	
	public ArrayList<OfertaLaboral> getOfertasFinalizadas(){	
		ArrayList<OfertaLaboral> res = new ArrayList<>();
		HashMap<String, OfertaLaboral> oferFin = this.ofertasFinalizadas;
		
		if (!oferFin.isEmpty()) {
			for (Map.Entry<String, OfertaLaboral> entry : oferFin.entrySet()) {
			    res.add(entry.getValue());
			}
		}
		return res;
	}
	
	public ArrayList<DataOferta> getDataOfertasFinalizadas(){
		ArrayList<DataOferta> res = new ArrayList<>();
		HashMap<String, OfertaLaboral> oferFin = this.ofertasFinalizadas;
		
		if (!oferFin.isEmpty()) {
			for (Map.Entry<String, OfertaLaboral> entry : oferFin.entrySet()) {
			    res.add(entry.getValue().getDataOferta());
			}
		}
		return res;
	}
	
	public ArrayList<OfertaLaboral> getOfertasConfimadasOrdenadasPorVisitas(){
		ArrayList<OfertaLaboral> res = new ArrayList<>();
        HashMap<String, OfertaLaboral> ofertas = this.ofertasLaborales;

        if (!ofertas.isEmpty()) {
            for (Map.Entry<String, OfertaLaboral> entry : ofertas.entrySet()) {
            	if (entry.getValue().getEstado() != null) {
	                if (entry.getValue().getEstado().equals(EstadoOferta.ACEPTADA)) {
	                    res.add(entry.getValue());
	                }
            	}
            }

            // Ordenar la lista de ofertas por el número de visitas
            Collections.sort(res, Comparator.comparingInt(OfertaLaboral::getVisitas).reversed());
        }

        return res;
    }
	
} 

