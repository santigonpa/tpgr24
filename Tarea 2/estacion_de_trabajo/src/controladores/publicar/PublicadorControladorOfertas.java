package controladores.publicar;

import java.time.LocalDate;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import excepciones.NombrePaqueteYaExiste;
import excepciones.NombreRepetidoOfertaException;
import excepciones.NombreTipoPubliYaExisteException;
import excepciones.noExistePublicacionException;
import excepciones.noExisteTipoPubli;
import excepciones.yaExistePostulacionAOfertaException;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.xml.ws.Endpoint;
import logica_controladores.ControladorOferta;
import logica_datatypes.DataOferta;
import logica_datatypes.WrapperArrayList;
import utils.Config;


@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)

public class PublicadorControladorOfertas {

    private Endpoint endpoint = null;

    private ControladorOferta controladorOferta = ControladorOferta.getInstance();

    @WebMethod(exclude = true)
    public void publicar() {
    	String url =  Config.getWebServiceBaseURL() + "/ControladorOfertas";     //"http://localhost:9128/ControladorOfertas";
        System.out.println("Publicando servicio de ControladorOfertas en " + url);
        endpoint = Endpoint.publish(url, this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
        return endpoint;
    }

    @WebMethod
    public void darAltaOferta(String nombre, String descripcion, String ciudad, String departamento, String horaInicio, String horaFin, int remuneracion, int costoDeOfertaLaboral, String fechaDeAlta, byte[]imagen, String tipoDePago) throws NombreRepetidoOfertaException {
    	DateTimeFormatter formateo = DateTimeFormatter.ofPattern("HH:mm");	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalTime horaDeInicio = LocalTime.parse(horaInicio, formateo);
		LocalTime horaDeFin = LocalTime.parse(horaFin, formateo);
    	LocalDate fecha = LocalDate.parse(fechaDeAlta, formatter);
    	controladorOferta.darAltaOferta(nombre, descripcion, ciudad, departamento, horaDeInicio, horaDeFin, remuneracion, costoDeOfertaLaboral, fecha, imagen, tipoDePago);
    }

    @WebMethod
    public void crearPaqueteDeTipoDePublicacionDeOfertasLaborales(String nombre, String descripcion, int validez, int descuento, String fechaDeAlta, int costo, byte[] imagen) throws NombrePaqueteYaExiste {
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	LocalDate fecha = LocalDate.parse(fechaDeAlta, formatter);
    	controladorOferta.crearPaqueteDeTipoDePublicacionDeOfertasLaborales(nombre, descripcion, validez, descuento, fecha, costo, imagen);
    }


    @WebMethod
    public void altaPublicacionOfertaLaboralConPaquete(String empresa, String tipoPubli, String nombre,
            String descripcion, String horarioInicio, String horarioFin, int remuneracion, String ciudad,
            String departamento, String fecha, WrapperArrayList palabrasClaveSelec, byte[]imagen, String tipoDePago) throws NombreRepetidoOfertaException, noExistePublicacionException, noExisteTipoPubli {
        
    	DateTimeFormatter formateo = DateTimeFormatter.ofPattern("HH:mm");	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	LocalDate fechaLocalDate = LocalDate.parse(fecha, formatter);
		LocalTime horaDeInicio = LocalTime.parse(horarioInicio, formateo);
		LocalTime horaDeFin = LocalTime.parse(horarioFin, formateo);
		
		@SuppressWarnings("unchecked")
		ArrayList<String> palabrasClave = (ArrayList<String>) palabrasClaveSelec.getLista();
		
    	controladorOferta.altaPublicacionOfertaLaboralConPaquete(empresa, tipoPubli, nombre, descripcion, horaDeInicio, horaDeFin, remuneracion, ciudad, departamento, fechaLocalDate, palabrasClave, imagen, tipoDePago);
    }

    @WebMethod
    public void altaPublicacionOfertaLaboralGeneral(String empresa, String tipoPubli, String nombre,
            String descripcion, String horarioInicio, String horarioFin, int remuneracion, String ciudad,
            String departamento, String fecha, WrapperArrayList palabrasClaveSelec, byte[]imagen, String tipoDePago) throws NombreRepetidoOfertaException, noExistePublicacionException {
        
    	DateTimeFormatter formateo = DateTimeFormatter.ofPattern("HH:mm");	
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    	LocalDate fechaLocalDate = LocalDate.parse(fecha, formatter);
		LocalTime horaDeInicio = LocalTime.parse(horarioInicio, formateo);
		LocalTime horaDeFin = LocalTime.parse(horarioFin, formateo);
		
		@SuppressWarnings("unchecked")
		ArrayList<String> palabrasClave = (ArrayList<String>) palabrasClaveSelec.getLista();
    		controladorOferta.altaPublicacionOfertaLaboralGeneral(empresa, tipoPubli, nombre, descripcion, horaDeInicio, horaDeFin, remuneracion, ciudad, departamento, fechaLocalDate, palabrasClave, imagen, tipoDePago);
    }

    @WebMethod
    public void altaDeTipoDePubliDeOferLab(String nombre, String descripcion, int exposicion,
            int costo, int duracion, String fecha) throws NombreTipoPubliYaExisteException {
    	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate fechaAlta = LocalDate.parse(fecha, dateFormatter);
    	controladorOferta.altaDeTipoDePubliDeOferLab(nombre, descripcion, exposicion, costo, duracion, fechaAlta);
    }

    @WebMethod
    public void agregarPostulacion(String post, String ofer, String curri, String mot, String fecha, String linkVid) throws yaExistePostulacionAOfertaException {
    	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate fechaAlta = LocalDate.parse(fecha, dateFormatter);
    	controladorOferta.agregarPostulacion(post, ofer, curri, mot, fechaAlta, linkVid);
    }

    @WebMethod
    public WrapperArrayList getPostulantesString(String oferta){
    	ArrayList<String> list =  controladorOferta.getPostulantesString(oferta);
    	WrapperArrayList ret = new WrapperArrayList(list);
        return ret;
    }

    @WebMethod
    public void aceptarOfertaLaboral(DataOferta dof) {
        controladorOferta.aceptarOfertaLaboral(dof);
    }

    @WebMethod
    public void rechazarOfertaLaboral(DataOferta dof) {
        controladorOferta.rechazarOfertaLaboral(dof);
    }

}
