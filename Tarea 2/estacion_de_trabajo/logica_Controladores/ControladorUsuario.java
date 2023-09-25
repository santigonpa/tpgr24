package logica_Controladores;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.time.*;

import excepciones.NicknameYaExisteException;
import excepciones.UsuarioNoExisteException;
import excepciones.campoInvalidoException;
import excepciones.yaExistePostulacionAOfertaException;
import excepciones.EmailYaExisteException;
import logica_DataTypes.DataEmpresa;
import logica_DataTypes.DataKeyWord;
import logica_DataTypes.DataOferta;
import logica_DataTypes.DataPostulante;
import logica_DataTypes.DataTipoPublicacion;
import logica_DataTypes.DataUsuario;
import utils.Fabrica;
import logica_Manejadores.IManejadorUsuario;
import logica_Manejadores.IManejadorOferta;
import logica_Manejadores.IManejadorPyT;
import logica_Manejadores.ManejadorUsuario;
import logica_Entidades.Postulacion;
import logica_Entidades.Usuario;
import logica_Entidades.Postulante;
import logica_Entidades.Empresa;
import logica_Entidades.OfertaLaboral;


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
	if((pos).estaPostulado(postulacion)) {
		throw new yaExistePostulacionAOfertaException("El postulante ya se encuentra postulado a dicha postulacion");
	}else {
	pos.agregarPostulacionAPostulante(postulacion);
	}
}

public Map<String, OfertaLaboral> obtenerOfertarDeEmpresa(DataEmpresa empresa){
	Fabrica fabrica = Fabrica.getInstance();
	IManejadorUsuario manejadorUsuario = fabrica.getInManejadorUsuario();
	
	Empresa e = (Empresa) manejadorUsuario.obtenerUsuario(empresa.getNickName());
	Map<String, OfertaLaboral> ofertas = e.getOfertas();
	return ofertas;
}

public DataUsuario listarInfoUser(String usuario) {
	Fabrica fabrica = Fabrica.getInstance();
	IManejadorUsuario manejadorUsuario = fabrica.getInManejadorUsuario();
	
	Usuario user = manejadorUsuario.obtenerUsuario(usuario);
	DataUsuario DtUser = new DataUsuario(user.getNickName(), user.getNombre(), user.getApellido(), user.getEmail());
	return DtUser;
}

public Set<Postulacion> obtenerPostulaciones(String usuario){
	Fabrica fabrica = Fabrica.getInstance();
	IManejadorUsuario manejadorUsuario = fabrica.getInManejadorUsuario();
	
	Postulante post = (Postulante)manejadorUsuario.obtenerUsuario(usuario);
	Set<Postulacion> res = post.obtenerPostulaciones();
	return res;
}

	@Override
	public Set<DataEmpresa> getDataEmpresa()throws UsuarioNoExisteException {
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario mu = fabrica.getInManejadorUsuario();
		
		Set<DataEmpresa> res = new HashSet<>();
		Map<String, DataEmpresa> m = mu.getDataEmpresas();
		if(m != null) {
			for (Map.Entry<String, DataEmpresa> entry : m.entrySet()) {
			    res.add(entry.getValue());
			}
			return res;
		}
		else  {throw new UsuarioNoExisteException("No existen Empresas");}
						
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
		IManejadorOferta mu = fabrica.getInManejadorOferta();
		
		Set<DataKeyWord> res = mu.getDataKeyWord();
		return res;
	}

	@Override
	public void altaUsuarioEmpresa(String nickname, String nombre, String apellido, String email, String descripcion,
			String web) throws NicknameYaExisteException,EmailYaExisteException, campoInvalidoException {
		ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Usuario empresa = mu.obtenerUsuario(nickname);
        Usuario emailEnUso = mu.obtenerUsuarioPorEmail(email);
        if(emailEnUso != null) {throw new EmailYaExisteException("El email " + emailEnUso.getEmail() + " ya esta registrado");}
        if ( empresa!= null)
            throw new NicknameYaExisteException("El usuario " + nickname + " ya esta registrado");
        if(nickname.equals("") || nombre.equals("") || apellido.equals("") || email.equals("") || descripcion.equals("")|| web.equals("")){
			throw new campoInvalidoException("No estan todos los campos rellenados"); 
		}
        empresa = new Empresa(nickname,nombre,apellido,email,descripcion,web);
        mu.addUsuario(empresa);
		
	}

	@SuppressWarnings("unlikely-arg-type")
	public void altaUsuarioPostulante(String nickname, String nombre, String apellido, String email, LocalDate nacimiento,
			String nacionalidad) throws NicknameYaExisteException, EmailYaExisteException, campoInvalidoException {
		ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Usuario postulante = mu.obtenerUsuario(nickname);
        Usuario emailEnUso = mu.obtenerUsuarioPorEmail(email);
        if(emailEnUso != null) {throw new EmailYaExisteException("El email " + emailEnUso.getEmail() + " ya esta registrado");}
        if (postulante != null)
            throw new NicknameYaExisteException("El usuario " + nickname + " ya esta registrado");
        if(nickname.equals("") || nombre.equals("") || apellido.equals("") || email.equals("") || nacimiento.equals("")|| nacionalidad.equals("")){
			throw new campoInvalidoException("No estan todos los campos rellenados"); 
		}
        postulante = new Postulante(nickname, nombre, apellido, email, nacimiento, nacionalidad);
        mu.addUsuario(postulante);
		
	}

	@Override
	public Set<DataUsuario> getDataUsuarios() throws UsuarioNoExisteException {
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario mu = fabrica.getInManejadorUsuario();
		
		Set<DataUsuario> res = new HashSet<>();
		Map<String, DataUsuario> m = mu.getDataUsuario();
		if(!m.isEmpty()) {
			for (Map.Entry<String, DataUsuario> entry : m.entrySet()) {
			    res.add(entry.getValue());
			}
			return res;
		}else {throw new UsuarioNoExisteException("No existen Usuarios");}
		}
	

	@Override
	public Set<DataOferta> getDataOfertasDeEmpresa(String nickName) {
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario mu = fabrica.getInManejadorUsuario();
		Set<DataOferta> res = mu.obtenerOfertasDeUnaEmpresa(nickName);
		return res;
	}
	
	@Override
	public Set<DataPostulante> getDataPostulante() {
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario mu = fabrica.getInManejadorUsuario();
		
		Set<DataPostulante> res = new HashSet<>();
		Map<String, DataPostulante> m = mu.getDataPostulantes();
		for (Map.Entry<String, DataPostulante> entry : m.entrySet()) {
		    res.add(entry.getValue());
		}
		return res;
	}
	
}
