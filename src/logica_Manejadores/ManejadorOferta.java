package logica_Manejadores;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import logica_Entidades.KeyWord;
import logica_Entidades.OfertaLaboral;

public class ManejadorOferta {

	private static ManejadorOferta instancia;
	private Map<String,OfertaLaboral> ofertasLaborales;
	private Map<String,KeyWord> keywordsTotales;
	
	private ManejadorOferta() {
		this.ofertasLaborales = new HashMap<String, OfertaLaboral>();
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
		return ((OfertaLaboral)this.ofertasLaborales.get(nombre));
	}

	public void linkearKeywords(Set<String> palabrasClaveSelec , OfertaLaboral nuevaOfertaLaboral) {
		for (String kw : palabrasClaveSelec) {
			KeyWord palabra = ((KeyWord)this.keywordsTotales.get(kw));
			if(palabra != null) {
				nuevaOfertaLaboral.agregarKeywordAOferta(palabra);
				palabra.agregarOfertaAKeyWord(nuevaOfertaLaboral);
			}
		}
	}

	public void addOferta(OfertaLaboral nuevaOferta) {
		String nombre = nuevaOferta.getNombreOferta();
        this.ofertasLaborales.put(nombre, nuevaOferta);
	}

}
