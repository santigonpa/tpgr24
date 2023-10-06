package logica_Manejadores;

import java.util.Set;

import logica_DataTypes.DataPaquete;
import logica_DataTypes.DataTipoPublicacion;
import logica_Entidades.Paquete;
import logica_Entidades.TipoPublicacion;

public interface IManejadorPyT {

	public abstract Set<DataTipoPublicacion> getDataTipoPublicacion();
	
	public abstract Set<DataPaquete> getDataPaquete();

	public abstract TipoPublicacion obtenerTipoPublicacion(String tipoPubli);
	
	public abstract boolean TipoPubliYaExiste(String nombre);
	
	public abstract void addTipoPublicacion(TipoPublicacion tp);

	public abstract boolean NombrePaqueteYaExiste(String nombre);

	public abstract void addPaquete(Paquete paq);

	public abstract DataPaquete getDataPaquete(String nombrePaquete);

}
