package logica_controladores;

import java.util.Set;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Map;


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

public Map<String, OfertaLaboral> obtenerOfertarDeEmpresa(DataEmpresa empresa){
	Fabrica fabrica = Fabrica.getInstance();
	IManejadorUsuario manejadorUsuario = fabrica.getInManejadorUsuario();
	
	Empresa empre = (Empresa) manejadorUsuario.obtenerUsuario(empresa.getNickName());
	Map<String, OfertaLaboral> ofertas = empre.getOfertas();
	return ofertas;
}

public DataUsuario listarInfoUser(String usuario) {
	Fabrica fabrica = Fabrica.getInstance();
	IManejadorUsuario manejadorUsuario = fabrica.getInManejadorUsuario();
	
	Usuario user = manejadorUsuario.obtenerUsuario(usuario);
	DataUsuario DtUser = new DataUsuario(user.getNickName(), user.getNombre(), user.getApellido(), user.getEmail(), user.getPsw(), user.getImagen());
	return DtUser;
}

public Set<Postulacion> obtenerPostulaciones(String usuario){
	Fabrica fabrica = Fabrica.getInstance();
	IManejadorUsuario manejadorUsuario = fabrica.getInManejadorUsuario();
	
	Postulante post = (Postulante) manejadorUsuario.obtenerUsuario(usuario);
	Set<Postulacion> res = post.obtenerPostulaciones();
	return res;
}

	@Override
	public Set<DataEmpresa> getDataEmpresa()throws UsuarioNoExisteException {
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario muser = fabrica.getInManejadorUsuario();
		
		Set<DataEmpresa> res = new HashSet<>();
		Map<String, DataEmpresa> mapa = muser.getDataEmpresas();
		if (mapa != null) {
			for (Map.Entry<String, DataEmpresa> entry : mapa.entrySet()) {
			    res.add(entry.getValue());
			}
			return res;
		}
		else {
			throw new UsuarioNoExisteException("No existen Empresas");
		}
						
}
	@Override
	public Set<DataTipoPublicacion> getDataTipoPublicacion() {
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorPyT mpyt = fabrica.getInManejadorPyT();
		
		Set<DataTipoPublicacion> res = mpyt.getDataTipoPublicacion();
		return res;
	}

	public Set<DataKeyWord> getDataKeyWord() {
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorOferta musr = fabrica.getInManejadorOferta();
		
		Set<DataKeyWord> res = musr.getDataKeyWord();
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
	public Set<DataUsuario> getDataUsuarios() throws UsuarioNoExisteException {
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario muser = fabrica.getInManejadorUsuario();
		
		Set<DataUsuario> res = new HashSet<>();
		Map<String, DataUsuario> mapa = muser.getDataUsuario();
		if (!mapa.isEmpty()) {
			for (Map.Entry<String, DataUsuario> entry : mapa.entrySet()) {
			    res.add(entry.getValue());
			}
			return res;
		}else {
			throw new UsuarioNoExisteException("No existen Usuarios");
			}
		}
	

	@Override
	public Set<DataOferta> getDataOfertasDeEmpresa(String nickName) {
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario muser = fabrica.getInManejadorUsuario();
		Set<DataOferta> res = muser.obtenerOfertasDeUnaEmpresa(nickName);
		return res;
	}
	
	@Override
	public Set<DataPostulante> getDataPostulante() {
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario muser = fabrica.getInManejadorUsuario();
		
		Set<DataPostulante> res = new HashSet<>();
		Map<String, DataPostulante> mapa = muser.getDataPostulantes();
		for (Map.Entry<String, DataPostulante> entry : mapa.entrySet()) {
		    res.add(entry.getValue());
		}
		return res;
	}
	
}
