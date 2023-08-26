package logica_Controladores;

import java.util.Set;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.time.*;

import excepciones.NicknameYaExisteException;
import excepciones.RegistroAPostulacionYaExisteException;
import excepciones.UsuarioNoExisteException;
import excepciones.campoInvalidoException;
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
	
	//alta postulante
	public void darAltaUsuario(String nickname, String nombre, String apellido, String email, LocalDate nacimiento, String nacionalidad) throws NicknameYaExisteException, EmailYaExisteException, campoInvalidoException{
		
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario manejadorUsuario = fabrica.getInManejadorUsuario();
		
		if(manejadorUsuario.emailYaExiste(nickname)) {
			throw new NicknameYaExisteException("Ya existe un usuario con este nickName");
		}
		if(manejadorUsuario.nickNameYaExiste(email)) {
			throw new EmailYaExisteException("Ya existe un usuario con este email");
		}
		if(nickname.equals(null) || nombre.equals(null) || apellido.equals(null) || email.equals(null) || nacimiento.equals(null)|| nacionalidad.equals(null)){
			throw new campoInvalidoException("No estan todos los campos rellenados"); 
		}
		
		Usuario post = new Postulante(nickname, nombre, apellido, email, nacimiento, nacionalidad);
		manejadorUsuario.addUsuario(post);
		
	}
 
	//alta empresa
public void darAltaUsuario(String nickname, String nombre, String apellido, String email, String descripcion, String web) throws NicknameYaExisteException, EmailYaExisteException, campoInvalidoException{
		
	Fabrica fabrica = Fabrica.getInstance();
	IManejadorUsuario manejadorUsuario = fabrica.getInManejadorUsuario();
		
		if(manejadorUsuario.nickNameYaExiste(nickname)) {
			throw new NicknameYaExisteException("Ya existe un usuario con este nickName");
		}
		if(manejadorUsuario.emailYaExiste(email)) {
			throw new EmailYaExisteException("Ya existe un usuasio con este email");
		}
		if(nickname.equals(null) || nombre.equals(null) || apellido.equals(null) || email.equals(null) || descripcion.equals(null)|| web.equals(null)){
			throw new campoInvalidoException("No estan todos los campos rellenados"); 
		}
		Usuario emp = new Empresa(nickname, nombre, apellido, email, descripcion, web);
		manejadorUsuario.addUsuario(emp);
	}

public void agregarPostulacionAPostulante(String postulante, Postulacion postulacion) throws RegistroAPostulacionYaExisteException {
	Fabrica fabrica = Fabrica.getInstance();
	IManejadorUsuario manejadorUsuario = fabrica.getInManejadorUsuario();
	
	Postulante pos = (Postulante)  manejadorUsuario.obtenerUsuario(postulante);
	if((pos).estaPostulado(postulacion)) {
		throw new RegistroAPostulacionYaExisteException("El postulante ya se encuentra postulado a dicha postulacion");
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
			String web) throws NicknameYaExisteException,EmailYaExisteException {
		ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Usuario empresa = mu.obtenerUsuario(nickname);
        Usuario emailEnUso = mu.obtenerUsuarioPorEmail(email);
        if(emailEnUso != null) {throw new EmailYaExisteException("El email " + emailEnUso.getEmail() + " ya esta registrado");}
        if ( empresa!= null)
            throw new NicknameYaExisteException("El usuario " + nickname + " ya esta registrado");

        empresa = new Empresa(nickname,nombre,apellido,email,descripcion,web);
        mu.addUsuario(empresa);
		
	}

	public void altaUsuarioPostulante(String nickname, String nombre, String apellido, String email, Date nacimiento,
			String nacionalidad) throws NicknameYaExisteException, EmailYaExisteException {
		ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Usuario postulante = mu.obtenerUsuario(nickname);
        Usuario emailEnUso = mu.obtenerUsuarioPorEmail(email);
        if(emailEnUso != null) {throw new EmailYaExisteException("El email " + emailEnUso.getEmail() + " ya esta registrado");}
        if (postulante != null)
            throw new NicknameYaExisteException("El usuario " + nickname + " ya esta registrado");
     // Convertir Date a Instant
        Instant instant = nacimiento.toInstant();

        // Convertir Instant a LocalDate
        LocalDate nacLD = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        postulante = new Postulante(nickname, nombre, apellido, email, nacLD, nacionalidad);
        mu.addUsuario(postulante);
		
	}

	@Override
	public Set<DataUsuario> getDataUsuarios() throws UsuarioNoExisteException {
		Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario mu = fabrica.getInManejadorUsuario();
		
		Set<DataUsuario> res = new HashSet<>();
		Map<String, DataUsuario> m = mu.getDataUsuario();
		if(m!=null) {
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
