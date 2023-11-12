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
import logica_datatypes.WrapperArrayList;
import logica_datatypes.WrapperHashMap;
import logica_entidades.Empresa;
import logica_entidades.OfertaLaboral;
import logica_entidades.Paquete;
import logica_entidades.Postulacion;
import logica_manejadores.IManejadorUsuario;
import utils.Config;
import utils.Fabrica;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)

public class PublicadorControladorUsuario {

	private Endpoint endpoint = null;
	
	private IControladorUsuario icu = Fabrica.getInstance().getInUser();
	
	
	//Constructor
	public PublicadorControladorUsuario() {
	}
	
	@WebMethod(exclude = true)
    public void publicar() {
		String url =  Config.getWebServiceBaseURL() + "/ControladorUsuario";  //"http://localhost:9128/ControladorUsuario";
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
		icu.altaUsuarioPostulante(nickname, nombre, apellido, email, fechaNacimiento, nacionalidad, imagen, psw);
	}
	
	@WebMethod
	public void altaUsuarioEmpresa(String nickname, String nombre, String apellido, String email, String descripcion,
			String web , byte[]imagen , String psw)throws NicknameYaExisteException, EmailYaExisteException, campoInvalidoException {
		
		icu.altaUsuarioEmpresa(nickname, nombre, apellido, email, descripcion, web, imagen, psw);
	}
	
	
	@WebMethod
	public void agregarPostulacionAPostulante(String postulante, Postulacion postulacion) throws yaExistePostulacionAOfertaException {
		icu.agregarPostulacionAPostulante(postulante, postulacion);
	}
	
	@WebMethod
	 public WrapperHashMap obtenerOfertarDeEmpresa(String empresa){
		//le paso un string mejor porque es mas facil usarla desde el cliente
		Fabrica fab = Fabrica.getInstance();
		IManejadorUsuario IMU = fab.getInManejadorUsuario();
		Empresa emp = IMU.obtenerEmpresa(empresa);
		DataEmpresa dataEmp = emp.getDTEmpresa();
		HashMap<String, OfertaLaboral> mapa = icu.obtenerOfertarDeEmpresa(dataEmp);
		WrapperHashMap ret = new WrapperHashMap(mapa);
		return ret;
	}
	
	@WebMethod
	public void comprarPaquete(Paquete paq, String empresa) {
		icu.comprarPaquete(paq, empresa);
	}
	
	@WebMethod
	public DataUsuario listarInfoUser(String usuario) {
		return icu.listarInfoUser(usuario);
	}
	
	@WebMethod
	public WrapperArrayList obtenerPostulaciones(String usuario){
		
		ArrayList<Postulacion> arr =  icu.obtenerPostulaciones(usuario);
		WrapperArrayList ret = new WrapperArrayList(arr);
		return ret;
	}
	
	
	@WebMethod
	public WrapperArrayList getDataTipoPublicacion() {
		ArrayList<DataTipoPublicacion> arr =  icu.getDataTipoPublicacion();
		WrapperArrayList ret = new WrapperArrayList(arr);
		return ret;
	}
	
	@WebMethod
	public WrapperArrayList getPublicacionesEmpresa(String emp) {
	    ArrayList<DataTipoPublicacion> arr = icu.getPublicacionesEmpresa(emp);
	    ArrayList<String> res = new ArrayList<>();
	    
	    if (arr != null) {
	        if (!arr.isEmpty()) {
	            for (DataTipoPublicacion data : arr) {
	                res.add(data.getNombre());
	            }
	        } else {
	            // arr no está vacío, pero está vacío
	        }
	    } else {
	        // arr es nulo
	    }
	    
	    WrapperArrayList ret = new WrapperArrayList(res);
	    return ret;
	}


	@WebMethod
	public WrapperArrayList getDataKeyWord(){
		ArrayList<DataKeyWord> arr =  icu.getDataKeyWord();
		WrapperArrayList ret = new WrapperArrayList(arr);
		return ret;
	}
	
	@WebMethod
	public WrapperArrayList getDataUsuarios() throws UsuarioNoExisteException {
		ArrayList<DataUsuario> arr =  icu.getDataUsuarios();
		WrapperArrayList ret = new WrapperArrayList(arr);
		return ret;
	}
	
	@WebMethod
	public WrapperArrayList getDataOfertasDeEmpresa(String nickName) {
		ArrayList<DataOferta> arr = icu.getDataOfertasDeEmpresa(nickName);
		WrapperArrayList ret = new WrapperArrayList(arr);
		return ret;
	}
	
	@WebMethod
	public WrapperArrayList getDataPostulante() {
		ArrayList<DataPostulante> arr = icu.getDataPostulante();
		WrapperArrayList ret = new WrapperArrayList(arr);
		return ret;
		}
	
	@WebMethod
	public void modificarDatosPostulante(String nickname, String nombre, String apellido, String email,
			String nacimiento, String nacionalidad, byte[] imagen, String psw) {
		
		
		// Define el formato de entrada
        DateTimeFormatter formatoEntrada = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fecha = LocalDate.parse(nacimiento, formatoEntrada);
        
        // Define el formato de salida
        DateTimeFormatter formatoSalida = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaFormateada = fecha.format(formatoSalida);
		icu.modificarDatosPostulante(nickname, nombre, apellido, email, fechaFormateada, nacionalidad, imagen, psw);
	}
	
	@WebMethod
	public void modificarDatosEmpresa(String nickname, String nombre, String apellido, String email, String descripcion,
			String web, byte[] imagen, String psw) {
		icu.modificarDatosEmpresa(nickname, nombre, apellido, email, descripcion, web, imagen, psw);
	}
	
}
