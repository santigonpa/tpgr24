package controladores.publicar;

import java.time.LocalDate;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.xml.ws.Endpoint;

import excepciones.*;
import logica_controladores.ControladorOferta;
import logica_datatypes.DataOferta;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)

public class PublicadorControladorOfertas {

    private Endpoint endpoint = null;

    private ControladorOferta controladorOferta = ControladorOferta.getInstance();

    @WebMethod(exclude = true)
    public void publicar() {
    	String url = "http://localhost:9121/ControladorOfertas";
        System.out.println("Publicando servicio de ControladorOfertas en " + url);
        endpoint = Endpoint.publish(url, this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
        return endpoint;
    }

    @WebMethod
    public void darAltaOferta(String nombre, String descripcion, String ciudad, String departamento, LocalTime horaInicio, LocalTime horaFin, int remuneracion, int costoDeOfertaLaboral, LocalDate fechaDeAlta, byte[]imagen, String tipoDePago) throws NombreRepetidoOfertaException {
        controladorOferta.darAltaOferta(nombre, descripcion, ciudad, departamento, horaInicio, horaFin, remuneracion, costoDeOfertaLaboral, fechaDeAlta, imagen, tipoDePago);
    }

    @WebMethod
    public void crearPaqueteDeTipoDePublicacionDeOfertasLaborales(String nombre, String descripcion, int validez, int descuento, LocalDate fechadealta, int costo, byte[] imagen) throws NombrePaqueteYaExiste {
        controladorOferta.crearPaqueteDeTipoDePublicacionDeOfertasLaborales(nombre, descripcion, validez, descuento, fechadealta, costo, imagen);
    }


    @WebMethod
    public void altaPublicacionOfertaLaboralConPaquete(String empresa, String tipoPubli, String nombre,
            String descripcion, String horarioInicio, String horarioFin, int remuneracion, String ciudad,
            String departamento, LocalDate fecha, ArrayList<String> palabrasClaveSelec, byte[]imagen, String tipoDePago) throws NombreRepetidoOfertaException, noExistePublicacionException {
        
    	DateTimeFormatter formateo = DateTimeFormatter.ofPattern("HH:mm");	
    	
		LocalTime horaDeInicio = LocalTime.parse(horarioInicio, formateo);
		LocalTime horaDeFin = LocalTime.parse(horarioFin, formateo);
    	controladorOferta.altaPublicacionOfertaLaboralConPaquete(empresa, tipoPubli, nombre, descripcion, horaDeInicio, horaDeFin, remuneracion, ciudad, departamento, fecha, palabrasClaveSelec, imagen, tipoDePago);
    }

    @WebMethod
    public void altaPublicacionOfertaLaboralGeneral(String empresa, String tipoPubli, String nombre,
            String descripcion, String horarioInicio, String horarioFin, int remuneracion, String ciudad,
            String departamento, String fecha, ArrayList<String> palabrasClaveSelec, byte[]imagen, String tipoDePago) throws NombreRepetidoOfertaException {
        
    		DateTimeFormatter formateo = DateTimeFormatter.ofPattern("HH:mm");	
    		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    		LocalDate fechaAlta = LocalDate.parse(fecha, dateFormatter);
    		LocalTime horaDeInicio = LocalTime.parse(horarioInicio, formateo);
    		LocalTime horaDeFin = LocalTime.parse(horarioFin, formateo);
    		controladorOferta.altaPublicacionOfertaLaboralGeneral(empresa, tipoPubli, nombre, descripcion, horaDeInicio, horaDeFin, remuneracion, ciudad, departamento, fechaAlta, palabrasClaveSelec, imagen, tipoDePago);
    }

    @WebMethod
    public void altaDeTipoDePubliDeOferLab(String nombre, String descripcion, int exposicion,
            int costo, int duracion, String fecha) throws NombreTipoPubliYaExisteException {
    	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate fechaAlta = LocalDate.parse(fecha, dateFormatter);
    	controladorOferta.altaDeTipoDePubliDeOferLab(nombre, descripcion, exposicion, costo, duracion, fechaAlta);
    }

    @WebMethod
    public void agregarPostulacion(String post, String ofer, String curri, String mot, String fecha) throws yaExistePostulacionAOfertaException {
    	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate fechaAlta = LocalDate.parse(fecha, dateFormatter);
    	controladorOferta.agregarPostulacion(post, ofer, curri, mot, fechaAlta);
    }

    @WebMethod
    public ArrayList<String> getPostulantesString(String oferta){
        return controladorOferta.getPostulantesString(oferta);
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
