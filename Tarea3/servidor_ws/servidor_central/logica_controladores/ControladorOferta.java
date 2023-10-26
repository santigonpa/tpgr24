package logica_controladores;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import excepciones.NombrePaqueteYaExiste;
import excepciones.NombreRepetidoOfertaException;
import excepciones.NombreTipoPubliYaExisteException;
import excepciones.noExistePublicacionException;
import excepciones.yaExistePostulacionAOfertaException;
import logica_datatypes.DataOferta;
import logica_entidades.Empresa;
import logica_entidades.OfertaLaboral;
import logica_entidades.Paquete;
import logica_entidades.Postulacion;
import logica_entidades.Postulante;
import logica_entidades.TipoPublicacion;
import logica_entidades.OfertaLaboral.EstadoOferta;
import logica_manejadores.IManejadorOferta;
import logica_manejadores.IManejadorPyT;
import logica_manejadores.IManejadorUsuario;
import utils.Fabrica;


public class ControladorOferta implements IControladorOferta {
	
	private static ControladorOferta instancia;
	
	private ControladorOferta() {}
	
	public static ControladorOferta getInstance() {
        if (instancia == null) {
            instancia = new ControladorOferta();
        }
        return instancia;
    }
	
	public void darAltaOferta(String nombre, String descripcion, String ciudad, String departamento, LocalTime horaInicio, LocalTime horaFin, int remuneracion, int costoDeOfertaLaboral, LocalDate fechaDeAlta, byte[]imagen, String tipoDePago) throws NombreRepetidoOfertaException{
		
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorOferta manejadorOferta = fabrica.getInManejadorOferta();
		
		if (manejadorOferta.existeOferta(nombre)) {
			throw new NombreRepetidoOfertaException("Ya existe una oferta con este nombre");
		}
		
		OfertaLaboral ofer = new OfertaLaboral();
		ofer.setCiudad(ciudad);
		ofer.setCostoOfer(costoDeOfertaLaboral);
		ofer.setDepartamento(departamento);
		ofer.setDescripcion(descripcion);
		ofer.setFechaAlta(fechaDeAlta);
		ofer.setHorarioFin(horaFin);
		ofer.setHorarioIni(horaInicio);
		ofer.setImagen(imagen);
		ofer.setNombre(nombre);
		ofer.setRemuneracion(remuneracion);
		ofer.setTipodePago(tipoDePago);
		manejadorOferta.addOferta(ofer);
		}
	
	public void crearPaqueteDeTipoDePublicacionDeOfertasLaborales(String nombre, String descripcion, int validez, int descuento, LocalDate fechadealta, int costo, byte[] imagen) throws NombrePaqueteYaExiste{
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorPyT manejadorPyT = fabrica.getInManejadorPyT();
		
		if (manejadorPyT.nombrePaqueteYaExiste(nombre)) {
			throw new NombrePaqueteYaExiste("Ya existe un paquete con este nombre");
		}
		
		Paquete paq = new Paquete();
		paq.setNombre(nombre);
		paq.setDescripcion(descripcion);
		paq.setValidez(validez);
		paq.setDescuento(descuento);
		paq.setFechaAlta(fechadealta);
		paq.setCosto(costo);
		paq.setImagen(imagen);
		manejadorPyT.addPaquete(paq);
		}


	public void altaPublicacionOfertaLaboralConPaquete(String empresa, String tipoPubli, String nombre,
			String descripcion, LocalTime horarioInicio, LocalTime horarioFin, int remuneracion, String ciudad,
			String departamento, LocalDate fecha, ArrayList<String> palabrasClaveSelec, byte[]imagen, String tipoDePago) throws NombreRepetidoOfertaException, noExistePublicacionException{
		
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario musr = fabrica.getInManejadorUsuario();
		IManejadorOferta mofer = fabrica.getInManejadorOferta();
		IManejadorPyT mpt = fabrica.getInManejadorPyT();
		

		OfertaLaboral nuevaOferta = mofer.obtenerOferta(nombre);
		if (nuevaOferta != null){
			throw new NombreRepetidoOfertaException("El nombre " + nombre + " ya esta registrado como una oferta"); 
		}

		//busco Empresa
		Empresa emp = (Empresa) musr.obtenerUsuario(empresa);
		
		//busco tipo de publicacion
		TipoPublicacion tipo = mpt.obtenerTipoPublicacion(tipoPubli);
		
		float costoOfertaLaboral = (int) tipo.getCosto();
		
		if (emp.tienePaqueteAsociado()) {
			if (emp.getCompra().existeTipoPubli(tipoPubli)) {
				costoOfertaLaboral = (int) (tipo.getCosto() - ((emp.getCompra().getPaquete().getDescuento() /100 ) * tipo.getCosto()));
				emp.getCompra().yaSeUsoTipoPubli(tipoPubli);
			}else {
				throw new noExistePublicacionException("No puede realizar el pago de esta manera. Intente de forma general");
			}
		}
		
		nuevaOferta = new OfertaLaboral();
		nuevaOferta.setCiudad(ciudad);
		nuevaOferta.setCostoOfer((int) costoOfertaLaboral);
		nuevaOferta.setDepartamento(departamento);
		nuevaOferta.setDescripcion(descripcion);
		nuevaOferta.setFechaAlta(fecha);
		nuevaOferta.setHorarioFin(horarioFin);
		nuevaOferta.setHorarioIni(horarioInicio);
		nuevaOferta.setImagen(imagen);
		nuevaOferta.setNombre(nombre);
		nuevaOferta.setRemuneracion(remuneracion);
		nuevaOferta.setTipodePago(tipoDePago);
		nuevaOferta.setEmpresa(emp);
		emp.linkearOfertaEmpresa(nuevaOferta, nombre);
		nuevaOferta.setTipoPublicacion(tipo);
		mofer.linkearKeywords(palabrasClaveSelec, nuevaOferta); //linkea la coleccion de keywords a la oferta
		mofer.addOferta(nuevaOferta);
			
	}
	
	public void altaPublicacionOfertaLaboralGeneral(String empresa, String tipoPubli, String nombre,
			String descripcion, LocalTime horarioInicio, LocalTime horarioFin, int remuneracion, String ciudad,
			String departamento, LocalDate fecha, ArrayList<String> palabrasClaveSelec, byte[]imagen, String tipoDePago) throws NombreRepetidoOfertaException {
		
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario muser = fabrica.getInManejadorUsuario();
		IManejadorOferta mofer = fabrica.getInManejadorOferta();
		IManejadorPyT mpt = fabrica.getInManejadorPyT();
		
		OfertaLaboral nuevaOferta = mofer.obtenerOferta(nombre);
		if (nuevaOferta != null){
			throw new NombreRepetidoOfertaException("El nombre " + nombre + " ya esta registrado como una oferta"); 
			}
		float costoOfertaLaboral;
		//busco Empresa
		Empresa emp = (Empresa) muser.obtenerUsuario(empresa);
		
		//busco tipo de publicacion
		TipoPublicacion tipo = mpt.obtenerTipoPublicacion(tipoPubli);
		
		
		costoOfertaLaboral = (int) tipo.getCosto();
		
		
		nuevaOferta = new OfertaLaboral();
		nuevaOferta.setCiudad(ciudad);
		nuevaOferta.setCostoOfer((int) costoOfertaLaboral);
		nuevaOferta.setDepartamento(departamento);
		nuevaOferta.setDescripcion(descripcion);
		nuevaOferta.setFechaAlta(fecha);
		nuevaOferta.setHorarioFin(horarioFin);
		nuevaOferta.setHorarioIni(horarioInicio);
		nuevaOferta.setImagen(imagen);
		nuevaOferta.setNombre(nombre);
		nuevaOferta.setRemuneracion(remuneracion);
		nuevaOferta.setTipodePago(tipoDePago);
		nuevaOferta.setEmpresa(emp);
		nuevaOferta.setEmpresa(emp);
		emp.linkearOfertaEmpresa(nuevaOferta, nombre);
		nuevaOferta.setTipoPublicacion(tipo);
		mofer.linkearKeywords(palabrasClaveSelec, nuevaOferta); //linkea la coleccion de keywords a la oferta
		mofer.addOferta(nuevaOferta);
			
	}
	
	public void altaDeTipoDePubliDeOferLab(String nombre, String descripcion, int exposicion,
			int costo, int duracion, LocalDate fecha) throws NombreTipoPubliYaExisteException{
		
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorPyT manejadorPyT = fabrica.getInManejadorPyT();
		
		if (manejadorPyT.tipoPubliYaExiste(nombre)) {
			throw new NombreTipoPubliYaExisteException("Ya existe un Tipo de Publicacon de Oferta Laboral con ese nombre.");
		}
		TipoPublicacion tipo = new TipoPublicacion();
		tipo.setCosto(costo);
		tipo.setDescripcion(descripcion);
		tipo.setDuracion(duracion);
		tipo.setExposicion(exposicion);
		tipo.setFecha(fecha);
		tipo.setNombre(nombre);
		manejadorPyT.addTipoPublicacion(tipo);
	}		

	public void agregarPostulacion(String post, String ofer, String curri, String mot, LocalDate fecha) throws yaExistePostulacionAOfertaException {
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario muser = fabrica.getInManejadorUsuario();
		IManejadorOferta mofer = fabrica.getInManejadorOferta();
 
		OfertaLaboral oferta = mofer.obtenerOferta(ofer);
		Postulante postu = muser.obtenerPostulante(post);
		Postulacion nuevaPost = new Postulacion();
		nuevaPost.setCv(curri);
		nuevaPost.setFecha(fecha);
		nuevaPost.setMotivacion(mot);
		nuevaPost.setOfer(oferta);
		nuevaPost.setPost(postu);
		
		if (oferta.existePostulacion(postu.getNickName())) {
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


	public ArrayList<String> getPostulantesString(String oferta){
		Fabrica fab = Fabrica.getInstance();
		IManejadorOferta imo = fab.getInManejadorOferta();
		OfertaLaboral ofer = imo.obtenerOferta(oferta);
		
		return ofer.getPostulantesString();
	}
	public void aceptarOfertaLaboral(DataOferta dof) {
		Fabrica fab = Fabrica.getInstance();
		IManejadorOferta imo = fab.getInManejadorOferta();
		OfertaLaboral ofer = imo.obtenerOferta(dof.getNombre());
		ofer.setEstado(EstadoOferta.ACEPTADA);
	}

	public void rechazarOfertaLaboral(DataOferta dof) {
		Fabrica fab = Fabrica.getInstance();
		IManejadorOferta imo = fab.getInManejadorOferta();
		OfertaLaboral ofer = imo.obtenerOferta(dof.getNombre());
		ofer.setEstado(EstadoOferta.RECHAZADA);
		
	}
	

}
