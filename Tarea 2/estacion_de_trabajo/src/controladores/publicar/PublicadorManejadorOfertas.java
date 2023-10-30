package controladores.publicar;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.xml.ws.Endpoint;
import logica_datatypes.DataKeyWord;
import logica_datatypes.DataOferta;
import logica_datatypes.WrapperArrayList;
import logica_entidades.KeyWord;
import logica_entidades.OfertaLaboral;
import logica_entidades.Postulacion;
import logica_manejadores.ManejadorOferta;

import java.util.ArrayList;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class PublicadorManejadorOfertas {

    private Endpoint endpoint = null;

    private ManejadorOferta manejadorOferta = ManejadorOferta.getInstance();

    @WebMethod(exclude = true)
    public void publicar() {
        String url = "http://localhost:9125/ManejadorOferta";
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
    public DataOferta obtenerOferta(String nombre) {
        return manejadorOferta.getDataOferta(nombre);
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
    	ArrayList<DataOferta> arr =  manejadorOferta.getOfertas();
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
    
    public DataOferta getDataOferta(String nombre) {
    	return manejadorOferta.getDataOferta(nombre);
    }
}
