package logica_controladores;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

import logica_entidades.CompraPaquete;

import excepciones.NicknameYaExisteException;
import excepciones.UsuarioNoExisteException;
import excepciones.campoInvalidoException;
import excepciones.yaExistePostulacionAOfertaException;
import excepciones.EmailYaExisteException;
import utils.Fabrica;
import logica_datatypes.DataEmpresa;
import logica_datatypes.DataKeyWord;
import logica_datatypes.DataOferta;
import logica_datatypes.DataPostulante;
import logica_datatypes.DataTipoPublicacion;
import logica_datatypes.DataUsuario;
import logica_datatypes.WrapperArrayList;
import logica_entidades.Empresa;
import logica_entidades.OfertaLaboral;
import logica_entidades.Paquete;
import logica_entidades.Postulacion;
import logica_entidades.Postulante;
import logica_entidades.Usuario;
import logica_manejadores.IManejadorOferta;
import logica_manejadores.IManejadorPyT;
import logica_manejadores.IManejadorUsuario;


public class ControladorUsuario implements IControladorUsuario {
	//Atributos
	private static ControladorUsuario instancia;
	
	private ControladorUsuario(){
	}
	
	public static ControladorUsuario getInstance() {
        if (instancia == null) {
            instancia = new ControladorUsuario();
        }
        return instancia;
    }
	
	public void agregarPostulacionAPostulante(String postulante, Postulacion postulacion) throws yaExistePostulacionAOfertaException {
	Fabrica fabrica = Fabrica.getInstance();
	IManejadorUsuario manejadorUsuario = fabrica.getInManejadorUsuario();
	
	Postulante pos = (Postulante)  manejadorUsuario.obtenerUsuario(postulante);
	if (pos.estaPostulado(postulacion)) {
		throw new yaExistePostulacionAOfertaException("El postulante ya se encuentra postulado a dicha postulacion");
	}else {
	pos.agregarPostulacionAPostulante(postulacion);
	}
}

public HashMap<String, OfertaLaboral> obtenerOfertarDeEmpresa(DataEmpresa empresa){
	Fabrica fabrica = Fabrica.getInstance();
	IManejadorUsuario manejadorUsuario = fabrica.getInManejadorUsuario();
	
	Empresa empre = (Empresa) manejadorUsuario.obtenerUsuario(empresa.getNickName());
	HashMap<String, OfertaLaboral> ofertas = empre.getOfertas();
	return ofertas;
}

public DataUsuario listarInfoUser(String usuario) {
	Fabrica fabrica = Fabrica.getInstance();
	IManejadorUsuario manejadorUsuario = fabrica.getInManejadorUsuario();
	
	Usuario user = manejadorUsuario.obtenerUsuario(usuario);
	DataUsuario DtUser = new DataUsuario();
	DtUser.setApellido(user.getApellido());
	DtUser.setEmail(user.getEmail());
	DtUser.setImagen(user.getImagen());
	DtUser.setNickName(user.getNickName());
	DtUser.setNombre(user.getNombre());
	DtUser.setPsw(user.getPsw());
	return DtUser;
}
/*
public ArrayList<Postulacion> obtenerPostulaciones(String usuario){
	Fabrica fabrica = Fabrica.getInstance();
	IManejadorUsuario manejadorUsuario = fabrica.getInManejadorUsuario();
	
	Postulante post = (Postulante) manejadorUsuario.obtenerUsuario(usuario);
	ArrayList<Postulacion> res = post.obtenerPostulaciones();
	return res;
}*/
public ArrayList<Postulacion> obtenerPostulaciones(String usuario){
	Fabrica fabrica = Fabrica.getInstance();
	IManejadorUsuario manejadorUsuario = fabrica.getInManejadorUsuario();
	
	Postulante post = (Postulante) manejadorUsuario.obtenerUsuario(usuario);
	
	List<Postulacion> res1 = post.obtenerPostulaciones();
	ArrayList<Postulacion> res = new ArrayList<>();
	for(Postulacion pos : res1) {
		res.add(pos);
	}
	return res;
}

	@Override
	public ArrayList<DataEmpresa> getDataEmpresa()throws UsuarioNoExisteException {
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario muser = fabrica.getInManejadorUsuario();
		
		ArrayList<DataEmpresa> res = new ArrayList<>();
		HashMap<String, DataEmpresa> mapa = muser.getDataEmpresas();
		if (mapa != null) {
			for (HashMap.Entry<String, DataEmpresa> entry : mapa.entrySet()) {
			    res.add(entry.getValue());
			}
			return res;
		}
		else {
			throw new UsuarioNoExisteException("No existen Empresas");
		}
						
}
	@Override
	public ArrayList<DataTipoPublicacion> getDataTipoPublicacion() {
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorPyT mpyt = fabrica.getInManejadorPyT();
		
		ArrayList<DataTipoPublicacion> res = mpyt.getDataTipoPublicacion();
		return res;
	}

	public ArrayList<DataKeyWord> getDataKeyWord() {
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorOferta musr = fabrica.getInManejadorOferta();
		
		ArrayList<DataKeyWord> res = musr.getDataKeyWord();
		return res;
	}

	@Override
	public void altaUsuarioEmpresa(String nickname, String nombre, String apellido, String email, String descripcion,
			String web,  byte[]imagen , String psw) throws NicknameYaExisteException, EmailYaExisteException,  campoInvalidoException {
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario muser = fabrica.getInManejadorUsuario();
		Usuario empresa =  muser.obtenerUsuario(nickname);
        Usuario emailEnUso = muser.obtenerUsuarioPorEmail(email);
        if (emailEnUso != null) {
        	throw new EmailYaExisteException("El email " + emailEnUso.getEmail() + " ya esta registrado");
        }
        if ( empresa!= null)
            throw new NicknameYaExisteException("El usuario " + nickname + " ya esta registrado");
        if (nickname.equals("") || nombre.equals("") || apellido.equals("") || email.equals("") || descripcion.equals("")){
			throw new campoInvalidoException("No estan todos los campos rellenados"); 
		}
        empresa = new Empresa();
        empresa.setApellido(apellido);
        empresa.setEmail(email);
        empresa.setImagen(imagen);
        empresa.setNickName(nickname);
        empresa.setNombre(nombre);
        empresa.setPsw(psw);
        ((Empresa) empresa).setLinkWeb(web);
        ((Empresa) empresa).setDescripcion(descripcion);
        muser.addUsuario(empresa);
		
	}
	
	public ArrayList<DataTipoPublicacion> getPublicacionesEmpresa(String emp){
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario muser = fabrica.getInManejadorUsuario();
		Empresa empresa = muser.obtenerEmpresa(emp);
		ArrayList<DataTipoPublicacion> res = empresa.getPublicaciones();
		return res;
	}

	
	public void altaUsuarioPostulante(String nickname, String nombre, String apellido, String email, LocalDate nacimiento,
			String nacionalidad, byte[]imagen , String psw) throws NicknameYaExisteException, EmailYaExisteException, campoInvalidoException {
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario muser = fabrica.getInManejadorUsuario();
        Postulante postulante = (Postulante) muser.obtenerUsuario(nickname);
        Usuario emailEnUso = muser.obtenerUsuarioPorEmail(email);
        if (emailEnUso != null) {
        	throw new EmailYaExisteException("El email " + emailEnUso.getEmail() + " ya esta registrado");
        }
        if (postulante != null)
            throw new NicknameYaExisteException("El usuario " + nickname + " ya esta registrado");
        if (nickname.equals("") || nombre.equals("") || apellido.equals("") || email.equals("") || nacimiento.equals(null)|| nacionalidad.equals("")){
			throw new campoInvalidoException("No estan todos los campos rellenados"); 
		}
        postulante = new Postulante();
        postulante.setApellido(apellido);
        postulante.setEmail(email);
        postulante.setImagen(imagen);
        postulante.setNickName(nickname);
        postulante.setNombre(nombre);
        postulante.setPsw(psw);
        postulante.setNacimiento(nacimiento);
        postulante.setNacionalidad(nacionalidad);
        muser.addUsuario((Usuario) postulante);
		
	}

	public void comprarPaquete(Paquete paq, String emp) {
		
		Fabrica fab = Fabrica.getInstance();
		IManejadorUsuario imu =  fab.getInManejadorUsuario();
		Empresa empresa = (Empresa) imu.obtenerEmpresa(emp);
    	CompraPaquete compPaq = new CompraPaquete();
    	
    	
    	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    	LocalDate fechaActual = LocalDate.now();
    	String fechaActualFormateada = fechaActual.format(dateFormatter); // Formatear a String con el formato deseado
    	LocalDate fAlta = LocalDate.parse(fechaActualFormateada, dateFormatter); // Analizar la fecha formateada

		int dias = paq.getValidez();
		LocalDate fVen = fAlta.plusDays(dias);
		
		compPaq.setFechaCompr(fAlta);
		compPaq.setFechaVenc(fVen);
		compPaq.setPaquete(paq);
		
		empresa.setCompra(compPaq);
	}
	
	@Override
	public ArrayList<DataUsuario> getDataUsuarios() throws UsuarioNoExisteException {
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario muser = fabrica.getInManejadorUsuario();
		
		ArrayList<DataUsuario> res = new ArrayList<>();
		HashMap<String, DataUsuario> mapa = muser.getDataUsuario();
		if (!mapa.isEmpty()) {
			for (HashMap.Entry<String, DataUsuario> entry : mapa.entrySet()) {
			    res.add(entry.getValue());
			}
			return res;
		}else {
			throw new UsuarioNoExisteException("No existen Usuarios");
			}
		}
	

	@Override
	public ArrayList<DataOferta> getDataOfertasDeEmpresa(String nickName) {
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario muser = fabrica.getInManejadorUsuario();
		ArrayList<DataOferta> res = muser.obtenerOfertasDeUnaEmpresa(nickName);
		return res;
	}
	
	@Override
	public ArrayList<DataPostulante> getDataPostulante() {
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario muser = fabrica.getInManejadorUsuario();
		
		ArrayList<DataPostulante> res = new ArrayList<>();
		HashMap<String, DataPostulante> mapa = muser.getDataPostulantes();
		for (HashMap.Entry<String, DataPostulante> entry : mapa.entrySet()) {
		    res.add(entry.getValue());
		}
		return res;
	}

	@Override
	public void modificarDatosPostulante(String nickname, String nombre, String apellido, String email,
			String nacimiento, String nacionalidad, byte[] imagen, String psw) {
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario manejadorUsuario = fabrica.getInManejadorUsuario();
		
		Postulante postulanteAModificar = manejadorUsuario.obtenerPostulante(nickname);
		postulanteAModificar.setNombre(nombre);
		postulanteAModificar.setApellido(apellido);
		// Define el formato del String
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Parsea el String y crea un objeto LocalDate
        LocalDate fecha = LocalDate.parse(nacimiento, formato);
		postulanteAModificar.setNacimiento(fecha);
		postulanteAModificar.setImagen(imagen);
		postulanteAModificar.setNacionalidad(nacionalidad);
		postulanteAModificar.setPsw(psw);
	}

	@Override
	public void modificarDatosEmpresa(String nickname, String nombre, String apellido, String email, String descripcion,
			String web, byte[] imagen, String psw) {
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario manejadorUsuario = fabrica.getInManejadorUsuario();
		
		Empresa EmpresaAModificar = manejadorUsuario.obtenerEmpresa(nickname);
		EmpresaAModificar.setNombre(nombre);
		EmpresaAModificar.setApellido(apellido);
		EmpresaAModificar.setDescripcion(descripcion);
		EmpresaAModificar.setImagen(imagen);
		EmpresaAModificar.setPsw(psw);
		EmpresaAModificar.setLinkWeb(web);
	}
	
}
