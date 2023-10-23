package logica_controladores;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.HashMap;


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
import logica_entidades.Empresa;
import logica_entidades.OfertaLaboral;
import logica_entidades.Postulacion;
import logica_entidades.Postulante;
import logica_entidades.Usuario;
import logica_manejadores.IManejadorOferta;
import logica_manejadores.IManejadorPyT;
import logica_manejadores.IManejadorUsuario;
import logica_manejadores.ManejadorUsuario;


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
	DataUsuario DtUser = new DataUsuario(user.getNickName(), user.getNombre(), user.getApellido(), user.getEmail(), user.getPsw(), user.getImagen());
	return DtUser;
}

public ArrayList<Postulacion> obtenerPostulaciones(String usuario){
	Fabrica fabrica = Fabrica.getInstance();
	IManejadorUsuario manejadorUsuario = fabrica.getInManejadorUsuario();
	
	Postulante post = (Postulante) manejadorUsuario.obtenerUsuario(usuario);
	ArrayList<Postulacion> res = post.obtenerPostulaciones();
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
		ManejadorUsuario muser = ManejadorUsuario.getinstance();
        Usuario empresa = muser.obtenerUsuario(nickname);
        Usuario emailEnUso = muser.obtenerUsuarioPorEmail(email);
        if (emailEnUso != null) {
        	throw new EmailYaExisteException("El email " + emailEnUso.getEmail() + " ya esta registrado");
        }
        if ( empresa!= null)
            throw new NicknameYaExisteException("El usuario " + nickname + " ya esta registrado");
        if (nickname.equals("") || nombre.equals("") || apellido.equals("") || email.equals("") || descripcion.equals("")){
			throw new campoInvalidoException("No estan todos los campos rellenados"); 
		}
        empresa = new Empresa(nickname, nombre, apellido, email, descripcion, web, imagen, psw);
        muser.addUsuario(empresa);
		
	}

	
	public void altaUsuarioPostulante(String nickname, String nombre, String apellido, String email, LocalDate nacimiento,
			String nacionalidad, byte[]imagen , String psw) throws NicknameYaExisteException, EmailYaExisteException, campoInvalidoException {
		ManejadorUsuario muser = ManejadorUsuario.getinstance();
        Usuario postulante = muser.obtenerUsuario(nickname);
        Usuario emailEnUso = muser.obtenerUsuarioPorEmail(email);
        if (emailEnUso != null) {
        	throw new EmailYaExisteException("El email " + emailEnUso.getEmail() + " ya esta registrado");
        }
        if (postulante != null)
            throw new NicknameYaExisteException("El usuario " + nickname + " ya esta registrado");
        if (nickname.equals("") || nombre.equals("") || apellido.equals("") || email.equals("") || nacimiento.equals(null)|| nacionalidad.equals("")){
			throw new campoInvalidoException("No estan todos los campos rellenados"); 
		}
        postulante = new Postulante(nickname, nombre, apellido, email, nacimiento, nacionalidad, imagen, psw);
        muser.addUsuario(postulante);
		
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
			LocalDate nacimiento, String nacionalidad, byte[] imagen, String psw) {
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario manejadorUsuario = fabrica.getInManejadorUsuario();
		
		Postulante postulanteAModificar = manejadorUsuario.obtenerPostulante(nickname);
		postulanteAModificar.setNombre(nombre);
		postulanteAModificar.setApellido(apellido);
		postulanteAModificar.setNacimiento(nacimiento);
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
