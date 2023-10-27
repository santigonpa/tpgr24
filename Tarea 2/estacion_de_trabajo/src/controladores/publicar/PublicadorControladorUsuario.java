package controladores.publicar;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import excepciones.EmailYaExisteException;
import excepciones.NicknameYaExisteException;
import excepciones.campoInvalidoException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.xml.ws.Endpoint;
import logica_controladores.IControladorUsuario;
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
	public void modificarDatosPostulante(String nickname, String nombre, String apellido, String email, LocalDate nacimiento,
			String nacionalidad, byte[]imagen , String psw) {
		
		ICU.modificarDatosPostulante(nickname, nombre, apellido, email, nacimiento, nacionalidad, imagen, psw);
	}
}
