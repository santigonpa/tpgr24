package logica_Manejadores;

import java.util.HashMap;
import java.util.Map;

import logica_Entidades.OfertaLaboral;

public class ManejadorOferta {

	private static ManejadorOferta instancia;
	private Map<String,OfertaLaboral> ofertasLaborales;
	
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

}
