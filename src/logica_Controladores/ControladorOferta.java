package logica_Controladores;

import java.time.LocalTime;
import java.util.Date;
import java.util.Set;

import excepciones.NombreTipoPubliYaExisteException;
import excepciones.NombreRepetidoOfertaException;
import logica_Entidades.Empresa;
import logica_Entidades.TipoPublicacion;
import utils.Fabrica;
import logica_Entidades.OfertaLaboral;
import logica_Manejadores.IManejadorOferta;
import logica_Manejadores.IManejadorPyT;
import logica_Manejadores.IManejadorUsuario;


public class ControladorOferta implements IControladorOferta {
	
	private static ControladorOferta instancia;
	
	private ControladorOferta() {}
	
	public static ControladorOferta getInstance() {
        if (instancia == null) {
            instancia = new ControladorOferta();
        }
        return instancia;
    }

	public void altaPublicacionOfertaLaboral(String empresa, String tipoPubli, String nombre,
			String descripcion, LocalTime horarioInicio, LocalTime horarioFin, float remuneracion, String ciudad,
			String departamento, java.util.Date fecha, Set<String> palabrasClaveSelec) throws NombreRepetidoOfertaException {
		
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario mu = fabrica.getInManejadorUsuario();
		IManejadorOferta mo = fabrica.getInManejadorOferta();
		IManejadorPyT mpt = fabrica.getInManejadorPyT();
		
		OfertaLaboral nuevaOferta = mo.obtenerOferta(nombre);
		if(nuevaOferta != null){throw new NombreRepetidoOfertaException("El nombre " + nombre + " ya esta registrado como una oferta"); }
		float costoOfertaLaboral;
		//busco Empresa
		Empresa emp = (Empresa) mu.obtenerUsuario(empresa);
		
		//busco tipo de publicacion
		TipoPublicacion tp = mpt.obtenerTipoPublicacion(tipoPubli);
		
		//pregunto si tiene costo asociado al paquete 
		if(emp.tienePaqueteAsociado()){costoOfertaLaboral = (float) emp.costoPaqueteAsociado();}
		else{costoOfertaLaboral = (float) tp.getCosto();}
		//se crea la nueva oferta
		nuevaOferta = new OfertaLaboral(nombre,descripcion,ciudad, 
				departamento,horarioInicio,horarioFin
				, remuneracion , costoOfertaLaboral,  fecha);
		
		nuevaOferta.setEmpresa(emp);
		emp.linkearOfertaEmpresa(nuevaOferta,nombre);
		nuevaOferta.setTipoPublicacion(tp);
		mo.linkearKeywords(palabrasClaveSelec,nuevaOferta); //linkea la coleccion de keywords a la oferta
		mo.addOferta(nuevaOferta);
			
	}
	
	public void altaDeTipoDePubliDeOferLab(String nombre, String descripcion, int exposicion,
			int costo, int duracion, Date fecha) throws NombreTipoPubliYaExisteException{
		
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorPyT manejadorPyT = fabrica.getInManejadorPyT();
		
		if(manejadorPyT.nombreTipoPubliYaExisteException(nombre)) {
			throw new NombreTipoPubliYaExisteException("Ya existe un Tipo de Publicacon de Oferta Laboral con ese nombre");
		}
		TipoPublicacion tp = new TipoPublicacion(nombre, descripcion, exposicion, duracion, costo, fecha);
		manejadorPyT.addTipoPublicacion(tp);
	}		

	public void agregarPostulacion(String post, String ofer, String cv, String mot, LocalTime fecha) {
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario mu = fabrica.getInManejadorUsuario();
		IManejadorOferta mo = fabrica.getInManejadorOferta();

		OfertaLaboral oferta = mo.obtenerOferta(ofer);
		Postulante p = mu.obtenerPostulante(post);
		Postulacion nuevaPost = new Postulacion(fecha, cv, mot, p, oferta);
		
		oferta.agregarPostulacionAOferta(nuevaPost);
		IControladorUsuario icu = (IControladorUsuario) fabrica.getInUser();
		icu.agregarPostulacionApostulante(nuevaPost, post);
		
	}
	public void agregarPostulacionApostulante(Postulacion nuevaPost, String post) {
		Fabrica fab = Fabrica.getInstance();
		IManejadorUsuario imu = fab.getInManejadorUsuario();
		Postulante pos = imu.obtenerPostulante(post);
		pos.agregarPostulacionAPostulante(nuevaPost);
	}
}
