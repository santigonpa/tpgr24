package logica_Manejadores;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import logica_Controladores.ControladorUsuario;
import logica_DataTypes.DataEmpresa;
import logica_DataTypes.DataKeyWord;
import logica_Entidades.Empresa;
import logica_Entidades.KeyWord;
import logica_Entidades.OfertaLaboral;

public class ManejadorOferta implements IManejadorOferta{
	

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

	@SuppressWarnings("null")
	public Set<DataKeyWord> getDataKeyWord() {
		Set<DataKeyWord> res = null;
    	Set<KeyWord> temp = null;
    	
    	// Obtener las claves del Map
        Set<String> clavesKeyWord = this.keywordsTotales.keySet();
        for(String nombreKeyword : clavesKeyWord) {
        	KeyWord keyAct = ((KeyWord) this.keywordsTotales.get(nombreKeyword));
        	temp.add(keyAct);
        }
        for(KeyWord keyAct: temp) {
        	DataKeyWord nuevaDTKey = new DataKeyWord(keyAct.getPalabraClave());
        	res.add(nuevaDTKey);
        }
        
    	return res;
	}

}
