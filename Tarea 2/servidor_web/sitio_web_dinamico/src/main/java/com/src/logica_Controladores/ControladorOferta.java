package logica_Controladores;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import excepciones.NombreTipoPubliYaExisteException;
import excepciones.yaExistePostulacionAOfertaException;
import excepciones.NombrePaqueteYaExiste;
import excepciones.NombreRepetidoOfertaException;
import logica_Entidades.Empresa;
import logica_Entidades.TipoPublicacion;
import utils.Fabrica;
import logica_Entidades.Paquete;
import logica_Entidades.OfertaLaboral;
import logica_Entidades.Postulacion;
import logica_Entidades.Postulante;
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
	
	public void darAltaOferta(String nombre, String descripcion, String ciudad, String departamento,LocalTime horaInicio, LocalTime horaFin,int remuneracion, int costoDeOfertaLaboral, LocalDate fechaDeAlta) throws NombreRepetidoOfertaException{
		
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorOferta manejadorOferta = fabrica.getInManejadorOferta();
		
		if(manejadorOferta.existeOferta(nombre)) {
			throw new NombreRepetidoOfertaException("Ya existe una oferta con este nombre");
		}
		
		OfertaLaboral ofer = new OfertaLaboral(nombre,descripcion,ciudad,departamento,horaInicio,horaFin,remuneracion,costoDeOfertaLaboral,fechaDeAlta);
		manejadorOferta.addOferta(ofer);
		}
	
	public void CrearPaqueteDeTipoDePublicacionDeOfertasLaborales(String nombre, String descripcion, int validez, int descuento, LocalDate fechadealta) throws NombrePaqueteYaExiste{
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorPyT manejadorPyT = fabrica.getInManejadorPyT();
		
		if(manejadorPyT.NombrePaqueteYaExiste(nombre)) {
			throw new NombrePaqueteYaExiste("Ya existe un paquete con este nombre");
		}
		
		Paquete paq = new Paquete(nombre,descripcion,validez,descuento,fechadealta);
		manejadorPyT.addPaquete(paq);
		}


	public void altaPublicacionOfertaLaboral(String empresa, String tipoPubli, String nombre,
			String descripcion, LocalTime horarioInicio, LocalTime horarioFin, int remuneracion, String ciudad,
			String departamento, LocalDate fecha, Set<String> palabrasClaveSelec) throws NombreRepetidoOfertaException {
		
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
		if(emp.tienePaqueteAsociado()){costoOfertaLaboral = (int) emp.costoPaqueteAsociado();}
		else{costoOfertaLaboral = (int) tp.getCosto();}
		//se crea la nueva oferta
		nuevaOferta = new OfertaLaboral(nombre,descripcion,ciudad, 
				departamento,horarioInicio,horarioFin
				, remuneracion , (int) costoOfertaLaboral,  fecha);
		
		nuevaOferta.setEmpresa(emp);
		emp.linkearOfertaEmpresa(nuevaOferta,nombre);
		nuevaOferta.setTipoPublicacion(tp);
		mo.linkearKeywords(palabrasClaveSelec,nuevaOferta); //linkea la coleccion de keywords a la oferta
		mo.addOferta(nuevaOferta);
			
	}
	
	public void altaDeTipoDePubliDeOferLab(String nombre, String descripcion, int exposicion,
			int costo, int duracion, LocalDate fecha) throws NombreTipoPubliYaExisteException{
		
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorPyT manejadorPyT = fabrica.getInManejadorPyT();
		
		if(manejadorPyT.TipoPubliYaExiste(nombre)) {
			throw new NombreTipoPubliYaExisteException("Ya existe un Tipo de Publicacon de Oferta Laboral con ese nombre.");
		}
		TipoPublicacion tp = new TipoPublicacion(nombre, descripcion, exposicion, duracion, costo, fecha);
		manejadorPyT.addTipoPublicacion(tp);
	}		

	public void agregarPostulacion(String post, String ofer, String cv, String mot, LocalDate fecha) throws yaExistePostulacionAOfertaException {
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario mu = fabrica.getInManejadorUsuario();
		IManejadorOferta mo = fabrica.getInManejadorOferta();
 
		OfertaLaboral oferta = mo.obtenerOferta(ofer);
		Postulante p = mu.obtenerPostulante(post);
		Postulacion nuevaPost = new Postulacion(fecha, cv, mot, p, oferta);
		
		if(oferta.existePostulacion(p.getNickName())) {
			throw new yaExistePostulacionAOfertaException("El postulante ya se encuentra postulado a esa oferta");
		}
		
		oferta.agregarPostulacionAOferta(nuevaPost);
		this.agregarPostulacionApostulante(nuevaPost, post);
		
	}
	public void agregarPostulacionApostulante(Postulacion nuevaPost, String post) {
		Fabrica fab = Fabrica.getInstance();
		IManejadorUsuario imu = fab.getInManejadorUsuario();
		Postulante pos = imu.obtenerPostulante(post);
		pos.agregarPostulacionAPostulante(nuevaPost);
	}


	public Set<String> getPostulantesString(String oferta){
		Fabrica fab = Fabrica.getInstance();
		IManejadorOferta imo = fab.getInManejadorOferta();
		OfertaLaboral of = imo.obtenerOferta(oferta);
		
		return of.getPostulantesString();
	}

}
