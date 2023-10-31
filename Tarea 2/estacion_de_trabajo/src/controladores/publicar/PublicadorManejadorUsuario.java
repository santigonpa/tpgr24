package controladores.publicar;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.xml.ws.Endpoint;
import logica_datatypes.DataEmpresa;
import logica_datatypes.DataOferta;
import logica_datatypes.DataPostulacion;
import logica_datatypes.DataPostulante;
import logica_datatypes.DataUsuario;
import logica_datatypes.WrapperArrayList;
import logica_datatypes.WrapperHashMap;
import logica_entidades.Empresa;
import logica_entidades.Paquete;
import logica_entidades.Postulacion;
import logica_entidades.Postulante;
import logica_entidades.Usuario;
import logica_manejadores.ManejadorUsuario;

import java.util.ArrayList;
import java.util.HashMap;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class PublicadorManejadorUsuario {

    private Endpoint endpoint = null;

    private ManejadorUsuario manejadorUsuario = ManejadorUsuario.getinstance();

    @WebMethod(exclude = true)
    public void publicar() {
        String url = "http://localhost:9128/ManejadorUsuario";
        System.out.println("Publicando servicio de ManejadorUsuario en " + url);
        endpoint = Endpoint.publish(url, this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
        return endpoint;
    }

    @WebMethod
    public void addUsuario(DataUsuario usuario) {
        Usuario usu;
        if (usuario instanceof DataEmpresa) {
            usu = manejadorUsuario.obtenerEmpresa(usuario.getNickName());
        } else if (usuario instanceof DataPostulante) {
            usu = manejadorUsuario.obtenerPostulante(usuario.getNickName());
        } else {
            return;
        }
        manejadorUsuario.addUsuario(usu);
    }

    @WebMethod
    public void CompraPaquete(Paquete paq, String empresa) {
        manejadorUsuario.CompraPaquete(paq, empresa);
    }


    @WebMethod
    public DataUsuario obtenerDataUsuario(String nick) {
        Usuario usu = manejadorUsuario.obtenerUsuario(nick);
        if (usu instanceof Empresa) {
            return manejadorUsuario.getDataEmpresa(nick);
        } else if (usu instanceof Postulante) {
            return manejadorUsuario.getDataPostulante(nick);
        } else {
            return null;
        }
    }

    @WebMethod
    public DataUsuario obtenerDataUsuarioPorEmail(String email) {
        Usuario usu = manejadorUsuario.obtenerUsuarioPorEmail(email);
        if (usu instanceof Empresa) {
            return manejadorUsuario.getDataEmpresa(usu.getNickName());
        } else if (usu instanceof Postulante) {
            return manejadorUsuario.getDataPostulante(usu.getNickName());
        } else {
            return null;
        }
    }

    @WebMethod
    public WrapperHashMap getDataEmpresas() {
    	HashMap<String, DataEmpresa> mapa =  manejadorUsuario.getDataEmpresas();
    	WrapperHashMap ret = new WrapperHashMap(mapa);
    	return  ret;
    }

    @WebMethod
    public DataEmpresa getDataEmpresa(String empresa) {
        return manejadorUsuario.getDataEmpresa(empresa);
    }

    @WebMethod
    public WrapperHashMap getDataPostulantes() {
    	HashMap<String, DataPostulante> mapa =  manejadorUsuario.getDataPostulantes();
    	WrapperHashMap ret = new WrapperHashMap(mapa);
    	return ret;
    }

    @WebMethod
    public DataPostulante getDataPostulante(String postulante) {
        return manejadorUsuario.getDataPostulante(postulante);
    }

    @WebMethod
    public WrapperHashMap getDataUsuario() {
    	HashMap<String, DataUsuario> mapa =  manejadorUsuario.getDataUsuario();
    	WrapperHashMap ret = new WrapperHashMap(mapa);
    	return ret;
    }

    @WebMethod
    public WrapperArrayList obtenerOfertasDeUnaEmpresa(String nickName) {
    	ArrayList<DataOferta> arr = manejadorUsuario.obtenerOfertasDeUnaEmpresa(nickName);
    	WrapperArrayList ret = new WrapperArrayList(arr);
    	return ret;
    }

    @WebMethod
    public Empresa obteneraEmpresa(String nickName) {
    	return manejadorUsuario.obtenerEmpresa(nickName);
    }
    @WebMethod
    public WrapperArrayList obtenerOfertasConfirmadasDeEmpresa(String nickName) {
    	ArrayList<DataOferta> arr = manejadorUsuario.obtenerOfertasConfirmadasDeEmpresa(nickName);
    	WrapperArrayList ret = new WrapperArrayList(arr);
    	return ret;
    }

    @WebMethod
    public WrapperArrayList obtenerOfertasRechazadasIngresadas(String nickName) {
    	ArrayList<DataOferta> arr = manejadorUsuario.obtenerOfertasRechazadasIngresadas(nickName);
    	WrapperArrayList ret = new WrapperArrayList(arr);
    	return ret;
    }
    @WebMethod
    public  Postulante obtenerPostulante(String post) {
    	return manejadorUsuario.obtenerPostulante(post);
    }
    @WebMethod
    public  Usuario obtenerUsuario(String user) {
    	Usuario usuario = manejadorUsuario.obtenerUsuario(user);
    	if(usuario == null) {
    		usuario = new Usuario();
    		usuario.setNickName("null");
    	}
    	return usuario;
    }
    @WebMethod
    public  Usuario obtenerUsuarioPorEmail(String email) {
    	Usuario usuario =  manejadorUsuario.obtenerUsuarioPorEmail(email);
    	if(usuario == null) {
    		usuario = new Usuario();
    		usuario.setNickName("null");
    	}
    	return usuario;
    }
    
    @WebMethod
    public  WrapperArrayList obtenerDataPostulaciones(String nickName) {
    	Postulante usuario =  (Postulante) manejadorUsuario.obtenerUsuarioPorEmail(nickName);
    	WrapperArrayList arregloPostulWrapper = usuario.getPostulaciones();
    	@SuppressWarnings("unchecked")
		ArrayList<Postulacion> arregloPostul = (ArrayList<Postulacion>) arregloPostulWrapper.getLista();
    	ArrayList<DataPostulacion> arregloDataPostu = new ArrayList<>();
    	for(Postulacion posActual : arregloPostul) {
    		arregloDataPostu.add(posActual.getDTPostulacion());
    	}
    	WrapperArrayList ret = new WrapperArrayList(arregloDataPostu);
    	return ret;
    }
    
}
    

