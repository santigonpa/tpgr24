package logica_Manejadores;

import java.util.Set;

import logica_DataTypes.DataTipoPublicacion;
import logica_Entidades.TipoPublicacion;

public interface IManejadorPyT {

	public abstract Set<DataTipoPublicacion> getDataTipoPublicacion();

	public abstract TipoPublicacion obtenerTipoPublicacion(String tipoPubli);
	
	public abstract boolean nombreTipoPubliYaExisteException(String nombre);
	
	public abstract void addTipoPublicacion(TipoPublicacion tp);

}
