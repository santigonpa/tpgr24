package controladores.publicar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

import excepciones.EmailYaExisteException;
import excepciones.NicknameYaExisteException;
import excepciones.UsuarioNoExisteException;
import excepciones.campoInvalidoException;
import excepciones.yaExistePostulacionAOfertaException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.xml.ws.Endpoint;
import logica_controladores.IControladorUsuario;
import logica_datatypes.DataEmpresa;
import logica_datatypes.DataKeyWord;
import logica_datatypes.DataOferta;
import logica_datatypes.DataPostulante;
import logica_datatypes.DataTipoPublicacion;
import logica_datatypes.DataUsuario;
import logica_entidades.Empresa;
import logica_entidades.OfertaLaboral;
import logica_entidades.Postulacion;
import logica_manejadores.IManejadorUsuario;
import utils.Fabrica;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)

public class PublicadorControladorUsuario {

	private Endpoint endpoint = null;
	
	private IControladorUsuario ICU = Fabrica.getInstance().getInUser();
	
	
	//Constructor
	public PublicadorControladorUsuario() {
	}
	
	@WebMethod(exclude = true)
    public void publicar() {
		String url = "http://localhost:9123/ControladorUsuario";
        System.out.println("Publicando servicio de ControladorUsuario en " + url);
        endpoint = Endpoint.publish(url, this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
        return endpoint;
    }
	
	//Operaciones a ser publicadas
	
	@WebMethod
	public void altaUsuarioPostulante(String nickname, String nombre, String apellido, String email, String nacimiento,
			String nacionalidad, byte[]imagen , String psw)throws NicknameYaExisteException, EmailYaExisteException, campoInvalidoException {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate fechaNacimiento = LocalDate.parse(nacimiento, dateFormatter);
		ICU.altaUsuarioPostulante(nickname, nombre, apellido, email, fechaNacimiento, nacionalidad, imagen, psw);
	}
	
	@WebMethod
	public void altaUsuarioEmpresa(String nickname, String nombre, String apellido, String email, String descripcion,
			String web , byte[]imagen , String psw)throws NicknameYaExisteException, EmailYaExisteException, campoInvalidoException {
		
		ICU.altaUsuarioEmpresa(nickname, nombre, apellido, email, descripcion, web, imagen, psw);
	}
	
	
	@WebMethod
	public void agregarPostulacionAPostulante(String postulante, Postulacion postulacion) throws yaExistePostulacionAOfertaException {
		ICU.agregarPostulacionAPostulante(postulante, postulacion);
	}
	
	@WebMethod
	 public HashMap<String, OfertaLaboral> obtenerOfertarDeEmpresa(String empresa){
		//le paso un string mejor porque es mas facil usarla desde el cliente
		Fabrica fab = Fabrica.getInstance();
		IManejadorUsuario IMU = fab.getInManejadorUsuario();
		Empresa emp = IMU.obtenerEmpresa(empresa);
		DataEmpresa dataEmp = emp.getDTEmpresa();
		return ICU.obtenerOfertarDeEmpresa(dataEmp);
	}
	
	@WebMethod
	public DataUsuario listarInfoUser(String usuario) {
		return ICU.listarInfoUser(usuario);
	}
	
	@WebMethod
	public ArrayList<Postulacion> obtenerPostulaciones(String usuario){
		
		return ICU.obtenerPostulaciones(usuario);
		
	}
	
	
	@WebMethod
	public ArrayList<DataTipoPublicacion> getDataTipoPublicacion() {
		return ICU.getDataTipoPublicacion();
	}
	
	@WebMethod
	public ArrayList<DataKeyWord> getDataKeyWord(){
		return ICU.getDataKeyWord();
	}
	
	@WebMethod
	public ArrayList<DataUsuario> getDataUsuarios() throws UsuarioNoExisteException {
		return ICU.getDataUsuarios();
	}
	
	@WebMethod
	public ArrayList<DataOferta> getDataOfertasDeEmpresa(String nickName) {
		return getDataOfertasDeEmpresa(nickName);
	}
	
	@WebMethod
	public ArrayList<DataPostulante> getDataPostulante() {
		return ICU.getDataPostulante();
		}
	
	@WebMethod
	public void modificarDatosPostulante(String nickname, String nombre, String apellido, String email,
			String nacimiento, String nacionalidad, byte[] imagen, String psw) {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate fechaNacimiento = LocalDate.parse(nacimiento, dateFormatter);
		ICU.modificarDatosPostulante(nickname, nombre, apellido, email, fechaNacimiento, nacionalidad, imagen, psw);
	}
	
	@WebMethod
	public void modificarDatosEmpresa(String nickname, String nombre, String apellido, String email, String descripcion,
			String web, byte[] imagen, String psw) {
		ICU.modificarDatosEmpresa(nickname, nombre, apellido, email, descripcion, web, imagen, psw);
	}
	
}
