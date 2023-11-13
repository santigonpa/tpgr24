package logica_controladores;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
import logica_entidades.Empresa;
import logica_entidades.OfertaLaboral;
import logica_entidades.OfertaLaboral.EstadoOferta;
import logica_entidades.Paquete;
import logica_entidades.Postulacion;
import logica_entidades.Postulante;
import logica_entidades.TipoPublicacion;
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
		ofer.setEstado(EstadoOferta.INGRESADA);
		manejadorOferta.addOferta(ofer);
		}
	
	public byte[] getFile(String name)
            throws  IOException {
		byte[] byteArray = null;
        try {
                File file = new File("img/" + name);
                @SuppressWarnings("resource")
				FileInputStream streamer = new FileInputStream(file);
                byteArray = new byte[streamer.available()];
                streamer.read(byteArray);
        } catch (IOException e) {
                throw e;
        }
        return byteArray;
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
			String departamento, LocalDate fecha, ArrayList<String> palabrasClaveSelec, byte[]imagen, String tipoDePago) throws NombreRepetidoOfertaException, noExistePublicacionException, noExisteTipoPubli{
		
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
		if (tipo == null) {
			throw new noExistePublicacionException("El tipo de publicacion seleccionado no existe");			
		}
		
		float costoOfertaLaboral = (int) tipo.getCosto();
		boolean tieneEsaPubli = false;
		
		if (emp.tienePaqueteAsociado()) {
			if (emp.getCompra().existeTipoPubli(tipoPubli)) {
				costoOfertaLaboral = (int) (tipo.getCosto() - ((emp.getCompra().getPaquete().getDescuento() /100 ) * tipo.getCosto()));
				tieneEsaPubli = emp.getCompra().yaSeUsoTipoPubli(tipoPubli);
			}else {
				throw new noExistePublicacionException("No puede realizar el pago de esta manera. Intente de forma general");
			}
		}
		
		/*ArrayList<DataTipoPublicacion> tiposPub = emp.getPublicaciones();
		boolean existeT = false;
		for(DataTipoPublicacion pub : tiposPub) {
			if(pub.getNombre().equals(tipoPubli)) {
				existeT = true;
			}
		}*/
		
		if (!tieneEsaPubli) {
			throw new noExisteTipoPubli("No cuenta con el tipo de publicacion elegida");
		}
		
		byte[] img = null;
		if (imagen != null) {
			img = imagen;
		}else {
			try {
				img = this.getFile("imgagenDefaultOferta.jpg");
			} catch (IOException e) {
				e.printStackTrace();
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
		nuevaOferta.setImagen(img);
		nuevaOferta.setNombre(nombre);
		nuevaOferta.setRemuneracion(remuneracion);
		nuevaOferta.setTipodePago(tipoDePago);
		nuevaOferta.setEmpresa(emp);
		nuevaOferta.setEstado(EstadoOferta.INGRESADA);
		emp.linkearOfertaEmpresa(nuevaOferta, nombre);
		nuevaOferta.setTipoPublicacion(tipo);
		mofer.linkearKeywords(palabrasClaveSelec, nuevaOferta); //linkea la coleccion de keywords a la oferta
		mofer.addOferta(nuevaOferta);
			
	}
	
	public void altaPublicacionOfertaLaboralGeneral(String empresa, String tipoPubli, String nombre,
			String descripcion, LocalTime horarioInicio, LocalTime horarioFin, int remuneracion, String ciudad,
			String departamento, LocalDate fecha, ArrayList<String> palabrasClaveSelec, byte[]imagen, String tipoDePago) throws NombreRepetidoOfertaException,  noExistePublicacionException{
		
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
		if (tipo == null) {
			throw new noExistePublicacionException("El tipo de publicacion seleccionado no existe");
			
		}
		
		costoOfertaLaboral = (int) tipo.getCosto();
		
		byte[] img = null;
		if (imagen != null) {
			img = imagen;
		}else {
			try {
				img = this.getFile("imgagenDefaultOferta.jpg");
			} catch (IOException e) {
				e.printStackTrace();
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
		nuevaOferta.setImagen(img);
		nuevaOferta.setNombre(nombre);
		nuevaOferta.setRemuneracion(remuneracion);
		nuevaOferta.setTipodePago(tipoDePago);
		nuevaOferta.setEmpresa(emp);
		nuevaOferta.setEmpresa(emp);
		nuevaOferta.setEstado(EstadoOferta.INGRESADA);
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

	public void agregarPostulacion(String post, String ofer, String curri, String mot, LocalDate fecha, String linkVid) throws yaExistePostulacionAOfertaException {
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario muser = fabrica.getInManejadorUsuario();
		IManejadorOferta mofer = fabrica.getInManejadorOferta();
 
		OfertaLaboral oferta = mofer.obtenerOferta(ofer);
		Postulante postu = muser.obtenerPostulante(post);
		Postulacion nuevaPost = new Postulacion();
		nuevaPost.setCurri(curri);
		nuevaPost.setFecha(fecha);
		nuevaPost.setMotivacion(mot);
		nuevaPost.setOfer(oferta);
		nuevaPost.setPost(postu);
		String linkVidEmbed = getVideoEmbed(linkVid);
		nuevaPost.setVideo(linkVidEmbed);
		
		
		
		
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
	
	public String getVideoEmbed(String videoUrl) {
        // Verifica si la URL proporcionada es válida
        if (videoUrl == null || videoUrl.isEmpty() || videoUrl.equals("")) {
            return null;
        }

        // Patrón de expresión regular para buscar el ID del video
        String pattern = "(?<=watch\\?v=|/videos/|embed\\/|youtu.be\\/|\\/v\\/|\\/e\\/|watch\\?v%3D|watch\\?feature=player_embedded&v=|%2Fvideos%2F|embed\\?videoid=|/v/|/e/|v=)([a-zA-Z0-9-]+)";
        java.util.regex.Pattern compiledPattern = java.util.regex.Pattern.compile(pattern);
        java.util.regex.Matcher matcher = compiledPattern.matcher(videoUrl);

        if (matcher.find()) {
            String videoId = matcher.group();
            String embedCode = "https://www.youtube.com/embed/" + videoId;
            return embedCode;
        }

        return null;
	}
	
	public void agregarTPAPaquete(String NPaquete, String NTipoPubli, int cantidad) {
		Fabrica fab = Fabrica.getInstance();
		IManejadorPyT IPYT = fab.getInManejadorPyT();
		
		Paquete paquete = IPYT.getPaquete(NPaquete);
		TipoPublicacion tipopubli = IPYT.obtenerTipoPublicacion(NTipoPubli);
		
		paquete.setPublicaciones(tipopubli, cantidad);
	}

}
