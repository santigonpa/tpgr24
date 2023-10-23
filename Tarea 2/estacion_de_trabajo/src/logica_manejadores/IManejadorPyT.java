package logica_manejadores;

import java.util.ArrayList;

import logica_datatypes.DataPaquete;
import logica_datatypes.DataTipoPublicacion;
import logica_entidades.Paquete;
import logica_entidades.TipoPublicacion;

public interface IManejadorPyT {

	public abstract ArrayList<DataTipoPublicacion> getDataTipoPublicacion();
	
	public abstract ArrayList<DataPaquete> getDataPaquete();

	public abstract TipoPublicacion obtenerTipoPublicacion(String tipoPubli);
	
	public abstract boolean tipoPubliYaExiste(String nombre);
	
	public abstract void addTipoPublicacion(TipoPublicacion tipo);

	public abstract boolean nombrePaqueteYaExiste(String nombre);

	public abstract void addPaquete(Paquete paq);

	public abstract DataPaquete getDataPaquete(String nombrePaquete);
	
	public abstract Paquete getPaquete(String nombre); 

	}
