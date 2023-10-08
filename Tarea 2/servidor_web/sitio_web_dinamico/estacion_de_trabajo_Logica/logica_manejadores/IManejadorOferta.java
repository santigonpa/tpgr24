package logica_manejadores;

import java.util.Set;

import logica_datatypes.DataKeyWord;
import logica_datatypes.DataOferta;
import logica_entidades.KeyWord;
import logica_entidades.OfertaLaboral;
import logica_entidades.Postulacion;

public interface IManejadorOferta {

	public abstract OfertaLaboral obtenerOferta(String nombre);
	
	public abstract Set<DataOferta> getOfertas();
	
	public abstract Set<DataKeyWord> getDataKeyWord();
	
	public abstract DataOferta getDataOferta(String nombre);

	public abstract void linkearKeywords(Set<String> palabrasClaveSelec, OfertaLaboral nuevaOferta);

	public abstract void addOferta(OfertaLaboral nuevaOferta);


	public abstract void addKeyword(KeyWord key);


	public abstract void addPostulacion(Postulacion pos);
	
	public abstract Set<Postulacion> obtenerPostulaciones(String oferta, String empresa);

	public abstract boolean existeOferta(String string);

	public abstract Set<DataOferta> obtenerOfertasConfirmadasPorKey(String keywordSeleccionada);
}
