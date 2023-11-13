package logica_manejadores;

import java.util.ArrayList;

import logica_datatypes.DataKeyWord;
import logica_datatypes.DataOferta;
import logica_entidades.KeyWord;
import logica_entidades.OfertaLaboral;
import logica_entidades.Postulacion;

public interface IManejadorOferta {

	public abstract OfertaLaboral obtenerOferta(String nombre);
	
	public abstract ArrayList<DataOferta> getOfertas();
	
	public abstract ArrayList<DataKeyWord> getDataKeyWord();
	
	public abstract DataOferta getDataOferta(String nombre);

	public abstract void linkearKeywords(ArrayList<String> palabrasClaveSelec, OfertaLaboral nuevaOferta);

	public abstract void addOferta(OfertaLaboral nuevaOferta);


	public abstract void addKeyword(KeyWord key);

	public abstract DataKeyWord getDataKeyWordPorNombre(String nombre);

	public abstract void addPostulacion(Postulacion pos);
	
	public abstract ArrayList<Postulacion> obtenerPostulaciones(String oferta, String empresa);

	public abstract boolean existeOferta(String string);

	public abstract ArrayList<DataOferta> obtenerOfertasConfirmadasPorKey(String keywordSeleccionada);
	
	public abstract void finalizarOferta(String oferta);

	public abstract ArrayList<OfertaLaboral> getOfertasFinalizadas();
	
	public abstract ArrayList<DataOferta> getDataOfertasFinalizadas();
	
	public abstract ArrayList<OfertaLaboral> getOfertasConfimadasOrdenadasPorVisitas();
}
