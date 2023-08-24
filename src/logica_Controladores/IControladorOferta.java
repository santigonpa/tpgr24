package logica_Controladores;

import java.time.LocalTime;
import java.util.Set;

import excepciones.NombreRepetidoOfertaException;

public interface IControladorOferta  {
	
	public abstract void altaPublicacionOfertaLaboral(String empresa, String tipoPubli, String nombre,
			String descripcion, LocalTime horarioInicio, LocalTime horarioFin, float remuneracion, String ciudad,
			String departamento, java.util.Date fecha, Set<String> palabrasClaveSelec) throws NombreRepetidoOfertaException;

}
