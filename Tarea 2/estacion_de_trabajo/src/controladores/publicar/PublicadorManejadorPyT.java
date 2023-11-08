package controladores.publicar;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.xml.ws.Endpoint;
import logica_datatypes.DataPaquete;
import logica_datatypes.DataTipoPublicacion;
import logica_datatypes.WrapperArrayList;
import logica_entidades.Paquete;
import logica_entidades.TipoPublicacion;
import logica_manejadores.ManejadorPaquetesYTiposPubli;
import utils.Config;

import java.util.ArrayList;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class PublicadorManejadorPyT {

    private Endpoint endpoint = null;

    private ManejadorPaquetesYTiposPubli manejadorPaquetesYTiposPubli = ManejadorPaquetesYTiposPubli.getInstance();

    @WebMethod(exclude = true)
    public void publicar() {
        String url = Config.getWebServiceBaseURL() + "/ManejadorPaquetesYTiposPubli" ; //"http://localhost:9128/ManejadorPaquetesYTiposPubli";
        System.out.println("Publicando servicio de ManejadorPaquetesYTiposPubli en " + url);
        endpoint = Endpoint.publish(url, this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
        return endpoint;
    }

    @WebMethod
    public TipoPublicacion obtenerTipoPublicacion(String tipoPubli) {
        return manejadorPaquetesYTiposPubli.obtenerTipoPublicacion(tipoPubli);
        
    }

    @WebMethod
    public WrapperArrayList getDataTipoPublicacion() {
    	ArrayList<DataTipoPublicacion> arr =  manejadorPaquetesYTiposPubli.getDataTipoPublicacion();
    	WrapperArrayList ret = new WrapperArrayList(arr);
    	return ret;
    }

    @WebMethod
    public void addPaquete(DataPaquete paquete) {
        Paquete paq = new Paquete();
        manejadorPaquetesYTiposPubli.addPaquete(paq);
    }

    @WebMethod
    public DataPaquete getDataPaqueteIndividual(String nombre) {
        return manejadorPaquetesYTiposPubli.getDataPaquete(nombre);
    }

    @WebMethod
    public WrapperArrayList getDataPaqueteArreglo() {
    	ArrayList<DataPaquete> arr = manejadorPaquetesYTiposPubli.getDataPaquete();
    	WrapperArrayList ret = new WrapperArrayList(arr);
    	return ret;
    }

    @WebMethod
    public void addTipoPublicacion(DataTipoPublicacion tipo) {
        TipoPublicacion tipoPublicacion = new TipoPublicacion();
        manejadorPaquetesYTiposPubli.addTipoPublicacion(tipoPublicacion);
    }

    @WebMethod
    public boolean tipoPubliYaExiste(String nombre) {
        return manejadorPaquetesYTiposPubli.tipoPubliYaExiste(nombre);
    }

    @WebMethod
    public boolean nombrePaqueteYaExiste(String nombre) {
        return manejadorPaquetesYTiposPubli.nombrePaqueteYaExiste(nombre);
    }
    
    @WebMethod
    public Paquete getPaquete(String nombre) {
    	return manejadorPaquetesYTiposPubli.getPaquete(nombre);
    }
    @WebMethod
    public WrapperArrayList getDataPaquete() {
    	ArrayList<DataPaquete> arr = manejadorPaquetesYTiposPubli.getDataPaquete();
    	WrapperArrayList ret = new WrapperArrayList(arr);
    	return ret;
    }
    
}
