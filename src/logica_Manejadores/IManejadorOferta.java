package logica_Manejadores;

import java.util.Set;

import logica_DataTypes.DataKeyWord;
import logica_Entidades.OfertaLaboral;

public interface IManejadorOferta {

	public abstract OfertaLaboral obtenerOferta(String nombre);

	public abstract Set<DataKeyWord> getDataKeyWord();

}
