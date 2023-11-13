package controladores.publicar;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.xml.ws.Endpoint;
import logica_datatypes.DataKeyWord;
import logica_datatypes.DataOferta;
import logica_datatypes.DataPostulacion;
import logica_datatypes.WrapperArrayList;
import logica_entidades.Empresa;
import logica_entidades.KeyWord;
import logica_entidades.OfertaLaboral;
import logica_entidades.Postulacion;
import logica_manejadores.ManejadorOferta;
import logica_manejadores.ManejadorUsuario;
import utils.Config;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;


@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class PublicadorManejadorOfertas {

    private Endpoint endpoint = null;

    private ManejadorOferta manejadorOferta = ManejadorOferta.getInstance();
    private ManejadorUsuario manejadorUsuario = ManejadorUsuario.getinstance();

    @WebMethod(exclude = true)
    public void publicar() {
        String url = Config.getWebServiceBaseURL() + "/ManejadorOferta"; //"http://localhost:9128/ManejadorOferta";
        System.out.println("Publicando servicio de ManejadorOferta en " + url);
        endpoint = Endpoint.publish(url, this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
        return endpoint;
    }

    @WebMethod
    public void addUsuario(OfertaLaboral oferta) {
        manejadorOferta.addUsuario(oferta);
    }

    @WebMethod
    public DataOferta obtenerDataOferta(String nombre) {
        return manejadorOferta.getDataOferta(nombre);
    }
    @WebMethod
    public OfertaLaboral obtenerOferta(String nombre) {
        return manejadorOferta.obtenerOferta(nombre);
    }

    @WebMethod
    public void linkearKeywords(WrapperArrayList palabrasClave, DataOferta nuevaOferta) {
    	@SuppressWarnings("unchecked")
		ArrayList<String> palabrasClaveSelec = (ArrayList<String>) palabrasClave.getLista();
    	manejadorOferta.linkearKeywords(palabrasClaveSelec, manejadorOferta.obtenerOferta(nuevaOferta.getNombre()));
    }

    @WebMethod
    public void addOferta(OfertaLaboral nuevaOferta) {
        manejadorOferta.addOferta(nuevaOferta);
    }

    @WebMethod
    public WrapperArrayList getDataKeyWord() {
    	ArrayList<DataKeyWord> arr = manejadorOferta.getDataKeyWord();
    	WrapperArrayList ret = new WrapperArrayList(arr);
    	return ret;
    }
    
    @WebMethod
    public DataKeyWord getDataKeyWordPorNombre(String nombre) {
    	DataKeyWord ret = manejadorOferta.getDataKeyWordPorNombre(nombre);
    	return ret;   
  	}
    
    @WebMethod
    public void addKeyword(KeyWord key) {
        manejadorOferta.addKeyword(key);
    }

    @WebMethod
    public void addPostulacion(Postulacion pos) {
        manejadorOferta.addPostulacion(pos);
    }

    @WebMethod
    public boolean existeOferta(String nombre) {
        return manejadorOferta.existeOferta(nombre);
    }

    @WebMethod
    public WrapperArrayList getOfertas() {
    	ArrayList<DataOferta> arrOfertas =  manejadorOferta.getOfertas();
    	ArrayList<String> arr = new ArrayList<>();
    	for (DataOferta data : arrOfertas) {
    		arr.add(data.getNombre());
    	}
    	WrapperArrayList ret = new WrapperArrayList(arr);
    	return ret;
    }

    @WebMethod
    public WrapperArrayList obtenerOfertasConfirmadasPorKey(String keywordSeleccionada) {
    	ArrayList<DataOferta> arr = manejadorOferta.obtenerOfertasConfirmadasPorKey(keywordSeleccionada);
    	WrapperArrayList ret = new WrapperArrayList(arr);
    	return ret;
    }

    @WebMethod
    public WrapperArrayList obtenerPostulaciones(String oferta, String empresa) {
    	ArrayList<Postulacion> arr = manejadorOferta.obtenerPostulaciones(oferta, empresa);
    	WrapperArrayList ret = new WrapperArrayList(arr);
    	return ret;
    }
    @WebMethod
    public DataOferta getDataOferta(String nombre) {
    	return manejadorOferta.getDataOferta(nombre);
    }
    
    @WebMethod
    public WrapperArrayList obtenerPostulacionesSobreLaOferta(String nombreOferta) {
    	OfertaLaboral ofert = manejadorOferta.obtenerOferta(nombreOferta);
    	ArrayList<Postulacion> arrPostus = ofert.getPostulaciones();
    	ArrayList<DataPostulacion> dataPostus = new ArrayList<>();
    	for (Postulacion posActual : arrPostus) {
    		dataPostus.add(posActual.getDTPostulacion());
    	}
    	WrapperArrayList ret = new WrapperArrayList(dataPostus);
    	return ret;
    }
    
    @WebMethod
    public WrapperArrayList getNickPostulantes(String oferta) {
    	OfertaLaboral ofer = manejadorOferta.obtenerOferta(oferta);
    	ArrayList<Postulacion> arrPostus = ofer.getPostulaciones();
    	ArrayList<String> arr = new ArrayList<>();
    	for (Postulacion posActual : arrPostus) {
    		arr.add(posActual.getNickPostulante());
    	}
    	WrapperArrayList ret = new WrapperArrayList(arr);
    	return ret;
    }
    
    @WebMethod
    public WrapperArrayList getNickPostulantesAOferEmpresa(String oferta, String empresa) {
    	ArrayList<Postulacion> arrPostus = manejadorOferta.obtenerPostulaciones(oferta, empresa);
    	ArrayList<String> arr = new ArrayList<>();
    	for (Postulacion posActual : arrPostus) {
    		arr.add(posActual.getNickPostulante());
    	}
    	WrapperArrayList ret = new WrapperArrayList(arr);
    	return ret;
    }
    
    @WebMethod
    public WrapperArrayList getKeysPorNombreOfer(String oferta) {
    	OfertaLaboral ofer = manejadorOferta.obtenerOferta(oferta);
    	ArrayList<String> keys = ofer.getKeyWordsString();
    	WrapperArrayList ret = new WrapperArrayList(keys);
    	return ret;
    }
    
    @WebMethod
    public WrapperArrayList getOfertasConfirmadasYVencidas(String nickname) {
    	Empresa emp = manejadorUsuario.obtenerEmpresa(nickname);
		HashMap<String, OfertaLaboral> oferVencidas = emp.getOfertasAprobadasYVencidasDeEmpresa();
		ArrayList<String> oferVencidasStr = new ArrayList<>();
		for (String ofer : oferVencidas.keySet()) {
			oferVencidasStr.add(ofer); 
		}
		WrapperArrayList ret = new WrapperArrayList(oferVencidasStr);
		return ret;
    }
    
    @WebMethod 
    public void addOrdenPostulantes(WrapperArrayList wrapper, String nombreOferta) {
    	OfertaLaboral ofer = manejadorOferta.obtenerOferta(nombreOferta);
    	ofer.setFechaCalificacion(LocalDate.now());
    	ArrayList<String> ret = new ArrayList<>();
    	
    	for (Object obj :wrapper.getLista() ) {
    		String nombrePostulante = (String) obj;
    		ret.add(nombrePostulante);
    	}
    	
    	ofer.setOrdenPostulaciones(ret);
    }
    
    @WebMethod 
    public WrapperArrayList getOrdenPostulantes(String nombreOferta) {
    	OfertaLaboral ofer = manejadorOferta.obtenerOferta(nombreOferta);
    	ArrayList<String> orden = ofer.getOrdenPostulaciones();
    	WrapperArrayList ret = new WrapperArrayList(orden);
    	return ret;
    }
    
    @WebMethod 
    public void finalizarOfer(String nombreOferta) {
    	manejadorOferta.finalizarOferta(nombreOferta);
    }
    
    @WebMethod 
    public void visitaDeOferta(String nombreOferta) {
    	OfertaLaboral ofer = manejadorOferta.obtenerOferta(nombreOferta);
    	ofer.visitada();
    }
}
