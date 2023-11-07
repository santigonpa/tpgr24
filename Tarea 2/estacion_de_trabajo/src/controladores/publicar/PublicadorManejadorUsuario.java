package controladores.publicar;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.xml.ws.Endpoint;
import logica_datatypes.DataEmpresa;
import logica_datatypes.DataOferta;
import logica_datatypes.DataPaquete;
import logica_datatypes.DataPostulacion;
import logica_datatypes.DataPostulante;
import logica_datatypes.DataUsuario;
import logica_datatypes.WrapperArrayList;
import logica_datatypes.WrapperHashMap;
import logica_entidades.Empresa;
import logica_entidades.OfertaLaboral;
import logica_entidades.Paquete;
import logica_entidades.Postulacion;
import logica_entidades.Postulante;
import logica_entidades.Usuario;
import logica_manejadores.ManejadorUsuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        if(usu == null) {
        	DataUsuario usuar = new DataUsuario();
        	 usuar.setNickName("null");
        	return usuar;
    	}
        else if (usu instanceof Empresa) {
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
        if(usu == null) {
        	DataUsuario usuar = new DataUsuario();
        	 usuar.setNickName("null");
        	return usuar;
    	}
        else if (usu instanceof Empresa) {
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
    	ArrayList<String> arrString = new ArrayList<>();
    	for(DataOferta ofActual : arr) {
    		arrString.add(ofActual.getNombre());
    	}
    	WrapperArrayList ret = new WrapperArrayList(arrString);
    	return ret;
    }

    @WebMethod
    public WrapperArrayList obtenerOfertasRechazadasIngresadas(String nickName) {
    	ArrayList<DataOferta> arr = manejadorUsuario.obtenerOfertasRechazadasIngresadas(nickName);
    	ArrayList<String> arrString = new ArrayList<>();
    	for(DataOferta ofActual : arr) {
    		arrString.add(ofActual.getNombre());
    	}
    	WrapperArrayList ret = new WrapperArrayList(arrString);
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
    public  WrapperArrayList obtenerDataPostulaciones(String nickName) { //obtiene las postulaciones del postulante nickName
    	Postulante usuario =  (Postulante) manejadorUsuario.obtenerUsuario(nickName);
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
    
    @WebMethod
    public  WrapperArrayList obtenerDataPaquetes(String nickName) { //obtiene los paquetes de nickName
    	Empresa usuario =  (Empresa) manejadorUsuario.obtenerUsuario(nickName);
    	Map<String,Paquete> paquetes = usuario.getPaquetes();
    	ArrayList<DataPaquete> dataPaquetes = new ArrayList<>();
    	for(Paquete paqActual : paquetes.values()) {
    		dataPaquetes.add(paqActual.getDTPaquete());
    	}
    	WrapperArrayList ret = new WrapperArrayList(dataPaquetes);
    	return ret;
    }
    
    @WebMethod
    public WrapperArrayList obtenerDataOfertasDePostulaciones(String nickUser) { //son las ofertas a las que esta postulado nickUser
    	Postulante usuario =  (Postulante) manejadorUsuario.obtenerUsuario(nickUser);
    	WrapperArrayList arregloPostulWrapper = usuario.getPostulaciones();
    	@SuppressWarnings("unchecked")
		ArrayList<Postulacion> arregloPostul = (ArrayList<Postulacion>) arregloPostulWrapper.getLista();
    	ArrayList<String> arregloDeOfertas = new ArrayList<>();
    	for(Postulacion postul : arregloPostul) {
    		String ofert = postul.getOferta().getNombreOferta();
    		arregloDeOfertas.add(ofert);
    	}
    	WrapperArrayList ret = new WrapperArrayList(arregloDeOfertas);
    	return ret;
    }
    
    @WebMethod
    public WrapperArrayList obtenerDataOfertasDeEmpresa(String nickUser) { // ESTO DEVUELVE las ofertas de la empresa en data
    	Empresa usuario =  (Empresa) manejadorUsuario.obtenerUsuario(nickUser);
    	Map<String,OfertaLaboral> ofertas = usuario.getOfertas();
    	ArrayList<DataOferta> dataOfertas = new ArrayList<>();
    	for(OfertaLaboral oferActual : ofertas.values()) {
    		dataOfertas.add(oferActual.getDataOferta());
    	}
    	WrapperArrayList ret = new WrapperArrayList(dataOfertas);
    	return ret;
    }
    
    @WebMethod
    public  String obtenerNombrePaquete(String nickName) {
    	Empresa usuario =  (Empresa) manejadorUsuario.obtenerUsuario(nickName);
    	return usuario.getCompra().getPaquete().getNombre();
    }
    
    @WebMethod
    public  String tienePaquetePregunta(String nickName) {
    	Empresa usuario =  (Empresa) manejadorUsuario.obtenerUsuario(nickName);
    	if( usuario.getCompra() != null ) {
    		return "si";
    	}else {
    		return "no";
    	}
    }
    
    @WebMethod
    public DataPostulacion obtenerDataPostulacion(Postulacion pos) {
    	return pos.getDTPostulacion();
    }
    
    @WebMethod
    public WrapperArrayList obtenerOfertasFinalizadas(String nickName) {
    	ArrayList<DataOferta> arr = manejadorUsuario.obtenerOfertasFinalizadas(nickName);
    	ArrayList<String> arrString = new ArrayList<>();
    	for(DataOferta ofActual : arr) {
    		arrString.add(ofActual.getNombre());
    	}
    	WrapperArrayList ret = new WrapperArrayList(arrString);
    	return ret;
    }
    
    @WebMethod
    public void agregarSeguidor(String usuarioSeguidor, String usuarioASeguir ) {
        Usuario userSeguidor = manejadorUsuario.obtenerUsuario(usuarioSeguidor);
        Usuario userASeguir = manejadorUsuario.obtenerUsuario(usuarioASeguir);
        userSeguidor.seguirAUsuario(userASeguir);
        userASeguir.agregarSeguidor(userSeguidor);
    }

    @WebMethod
    public void quitarSeguidor(String usuarioSeguidor, String usuarioASeguir ) {
        Usuario userSeguidor = manejadorUsuario.obtenerUsuario(usuarioSeguidor);
        Usuario userASeguir = manejadorUsuario.obtenerUsuario(usuarioASeguir);
        userSeguidor.dejarDeSeguirAUsuario(userASeguir);
        userASeguir.quitarSeguidor(userSeguidor);
    }

    @WebMethod
    public WrapperArrayList obtenerSeguidos(String nickUser) {
        Usuario usuario =   manejadorUsuario.obtenerUsuario(nickUser);
        ArrayList<String> dataUsuarios = new ArrayList<>();
        for(Usuario user : usuario.getUsuariosQueYoSigo()) {
            dataUsuarios.add(user.getNickName());
        }
        WrapperArrayList ret = new WrapperArrayList(dataUsuarios);

        return ret;
    }

    @WebMethod
    public WrapperArrayList obtenerSeguidores(String nickUser) {
        Usuario usuario =   manejadorUsuario.obtenerUsuario(nickUser);
        ArrayList<String> dataUsuarios = new ArrayList<>();
        for(Usuario user : usuario.getUsuariosQueMeSiguen()) {
            dataUsuarios.add(user.getNickName());
        }
        WrapperArrayList ret = new WrapperArrayList(dataUsuarios);

        return ret;
    }
}
    

