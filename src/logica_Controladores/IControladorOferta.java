package logica_Controladores;

import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

import excepciones.NombreRepetidoOfertaException;
import excepciones.NombreTipoPubliYaExisteException;
import logica_DataTypes.DataOferta;
import logica_Entidades.Postulacion;

public interface IControladorOferta  {
	
	public abstract void altaPublicacionOfertaLaboral(String empresa, String tipoPubli, String nombre,
			String descripcion, LocalTime horarioInicio, LocalTime horarioFin, float remuneracion, String ciudad,
			String departamento, java.util.Date fecha, Set<String> palabrasClaveSelec) throws NombreRepetidoOfertaException;



public abstract void altaDeTipoDePubliDeOferLab(String nombre, String descripcion, int exposicion,
		int costo, int duracion, Date fecha) throws NombreTipoPubliYaExisteException;

public abstract void agregarPostulacion(String post, String ofer, String cv, String mot, LocalTime fecha);

public abstract void agregarPostulacionApostulante(Postulacion nuevaPost, String post);



}