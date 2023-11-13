package logica_controladores;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import excepciones.NombrePaqueteYaExiste;
import excepciones.NombreRepetidoOfertaException;
import excepciones.NombreTipoPubliYaExisteException;
import excepciones.noExistePublicacionException;
import excepciones.noExisteTipoPubli;
import excepciones.yaExistePostulacionAOfertaException;
import logica_datatypes.DataOferta;
import logica_entidades.Postulacion;

public interface IControladorOferta  {
	
	public abstract void altaPublicacionOfertaLaboralConPaquete(String empresa, String tipoPubli, String nombre,
			String descripcion, LocalTime horarioInicio, LocalTime horarioFin, int remuneracion, String ciudad,
			String departamento, LocalDate fecha, ArrayList<String> palabrasClaveSelec, byte[]imagen, String tipoDePago) throws NombreRepetidoOfertaException, noExistePublicacionException, noExisteTipoPubli;

	public abstract void altaPublicacionOfertaLaboralGeneral(String empresa, String tipoPubli, String nombre,
			String descripcion, LocalTime horarioInicio, LocalTime horarioFin, int remuneracion, String ciudad,
			String departamento, LocalDate fecha, ArrayList<String> palabrasClaveSelec, byte[]imagen, String tipoDePago) throws NombreRepetidoOfertaException, noExistePublicacionException;
	
public abstract void darAltaOferta(String nombre, String descripcion, String ciudad, String departamento, LocalTime horaInicio, LocalTime horaFin, int remuneracion, int costoDeOfertaLaboral, LocalDate fechaDeAlta, byte[]imagen, String tipoDePago) throws NombreRepetidoOfertaException;


public abstract void altaDeTipoDePubliDeOferLab(String nombre, String descripcion, int exposicion,
		int costo, int duracion, LocalDate fecha) throws NombreTipoPubliYaExisteException;

public abstract void agregarPostulacion(String post, String ofer, String curriculum, String mot, LocalDate fecha, String linkVid) throws yaExistePostulacionAOfertaException;

public abstract void agregarPostulacionApostulante(Postulacion nuevaPost, String post);

public abstract ArrayList<String> getPostulantesString(String oferta);

public abstract void crearPaqueteDeTipoDePublicacionDeOfertasLaborales(String nombre, String descripcion,
		int validez, int descuento, LocalDate fechaDeAlta, int costo, byte[] imagen) throws NombrePaqueteYaExiste;

public abstract void aceptarOfertaLaboral(DataOferta dof);

public abstract void rechazarOfertaLaboral(DataOferta dOf);

public abstract void agregarTPAPaquete(String NPaquete, String NTipoPubli, int cantidad);

public abstract String getVideoEmbed(String videoUrl);

}