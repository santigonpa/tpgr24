package logica_Controladores;

import java.util.Set;
import java.util.Date;
import java.util.Map;
import java.time.*;

import excepciones.NicknameYaExisteException;
import excepciones.RegistroAPostulacionYaExisteException;
import excepciones.EmailYaExisteException;
import logica_DataTypes.DataEmpresa;
import logica_DataTypes.DataKeyWord;
import logica_DataTypes.DataTipoPublicacion;
import logica_DataTypes.DataUsuario;
import utils.Fabrica;
import logica_Manejadores.ManejadorOferta;
import logica_Manejadores.ManejadorPaquetesYTiposPubli;
import logica_Manejadores.ManejadorUsuario;
import logica_Entidades.Postulacion;
import logica_Entidades.Usuario;
import logica_Entidades.Postulante;
import logica_Entidades.Empresa;
import logica_Entidades.OfertaLaboral;


public class ControladorUsuario implements IControladorUsuario {
	
	//Atributos
	private ManejadorUsuario manejador;
	
	private static ControladorUsuario instancia;
	
	private ControladorUsuario(){
	}
	
	public void setManejador(ManejadorUsuario m) {
		this.manejador = m;
	}
	
	public static ControladorUsuario getInstance() {
        if (instancia == null) {
            instancia = new ControladorUsuario();
        }
        return instancia;
    }
	
	//alta postulante
	public void darAltaUsuario(String nickname, String nombre, String apellido, String email, LocalDate nacimiento, String nacionalidad) throws NicknameYaExisteException, EmailYaExisteException{
		
		if(manejador.nickNameYaExiste(nickname)) {
			throw new NicknameYaExisteException("Ya existe un usuario con este nickName");
		}
		if(manejador.emailYaExiste(email)) {
			throw new EmailYaExisteException("Ya existe un usuario con este email");
		}
		
		Postulante post = new Postulante(nickname, nombre, apellido, email, nacimiento, nacionalidad);
		this.manejador.addUsuario(post);
		
	}
 
	//alta empresa
public void darAltaUsuario(String nickname, String nombre, String apellido, String email, String descripcion, String web) throws NicknameYaExisteException, EmailYaExisteException{
		
		if(manejador.nickNameYaExiste(nickname)) {
			throw new NicknameYaExisteException("Ya existe un usuario con este nickName");
		}
		if(manejador.emailYaExiste(email)) {
			throw new EmailYaExisteException("Ya existe un usuasio con este email");
		}
		
		Empresa emp = new Empresa(nickname, nombre, apellido, email, descripcion, web);
		this.manejador.addUsuario(emp);
	}

public void agregarPostulacionAPostulante(String postulante, Postulacion postulacion) throws RegistroAPostulacionYaExisteException {
	Postulante pos = this.manejador.obtenerPostulante(postulante);
	if(pos.estaPostulado(postulacion)) {
		throw new RegistroAPostulacionYaExisteException("El postulante ya se encuentra postulado a dicha postulacion");
	}else {
	pos.agregarPostulacionAPostulante(postulacion);
	}
}

public Map<String, OfertaLaboral> obtenerOfertarDeEmpresa(DataEmpresa empresa){
	Empresa e = (Empresa) this.manejador.obtenerUsuario(empresa.getNickName());
	Map<String, OfertaLaboral> ofertas = e.getOfertas();
	return ofertas;
}

public DataUsuario listarInfoUser(String usuario) {
	Usuario user = this.manejador.obtenerUsuario(usuario);
	DataUsuario DtUser = new DataUsuario(user.getNickName(), user.getNombre(), user.getApellido(), user.getEmail());
	return DtUser;
}

public Set<Postulacion> obtenerPostulaciones(String usuario){
	Postulante post = (Postulante)this.manejador.obtenerUsuario(usuario);
	Set<Postulacion> res = post.obtenerPostulaciones();
	return res;
}

	@Override
	public Set<DataEmpresa> getDataEmpresa() {
		Fabrica fabrica = Fabrica.getInstance();
		ManejadorUsuario mu = fabrica.getManejadorUsuario();
		
		Set<DataEmpresa> res = mu.getDataEmpresas();
		return res;
	}

	@Override
	public Set<DataTipoPublicacion> getDataTipoPublicacion() {
		Fabrica fabrica = Fabrica.getInstance();
		ManejadorPaquetesYTiposPubli mu = fabrica.getManejadorPaquetesYTiposPubli();
		
		Set<DataTipoPublicacion> res = mu.getDataTipoPublicacion();
		return res;
	}

	public Set<DataKeyWord> getDataKeyWord() {
		Fabrica fabrica = Fabrica.getInstance();
		ManejadorOferta mu = fabrica.getManejadorOferta();
		
		Set<DataKeyWord> res = mu.getDataKeyWord();
		return res;
	}

	@Override
	public void altaUsuarioEmpresa(String nickname, String nombre, String apellido, String email, String descripcion,
			String web) throws NicknameYaExisteException {
		ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Usuario empresa = mu.obtenerUsuario(nickname);
        if ( empresa!= null)
            throw new NicknameYaExisteException("El usuario " + nickname + " ya esta registrado");

        empresa = new Empresa(nickname,nombre,apellido,email,descripcion,web);
        mu.addUsuario(empresa);
		
	}

	@Override
	public void altaUsuarioPostulante(String nickname, String nombre, String apellido, String email, Date nacimiento,
			String web) throws NicknameYaExisteException {
		ManejadorUsuario mu = ManejadorUsuario.getinstance();
        Usuario postulante = mu.obtenerUsuario(nickname);
        if (postulante != null)
            throw new NicknameYaExisteException("El usuario " + nickname + " ya esta registrado");
     // Convertir Date a Instant
        Instant instant = nacimiento.toInstant();

        // Convertir Instant a LocalDate
        LocalDate nacLD = instant.atZone(ZoneId.systemDefault()).toLocalDate();
        postulante = new Postulante(nickname, nombre, apellido, email, nacLD, web);
        mu.addUsuario(postulante);
		
	}
	
}
