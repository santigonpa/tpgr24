package logica_Manejadores;

import java.util.Set;

import logica_DataTypes.DataKeyWord;
import logica_Entidades.KeyWord;
import logica_Entidades.OfertaLaboral;

public interface IManejadorOferta {

	public abstract OfertaLaboral obtenerOferta(String nombre);
	

	public abstract Set<DataKeyWord> getDataKeyWord();

	public abstract void linkearKeywords(Set<String> palabrasClaveSelec, OfertaLaboral nuevaOferta);

	public abstract void addOferta(OfertaLaboral nuevaOferta);


	public abstract void addKeyword(KeyWord k);

}
