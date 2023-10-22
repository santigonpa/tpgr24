package webservices;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.xml.ws.Endpoint;

import excepciones.*;
import logica_controladores.ControladorOferta;
import logica_datatypes.DataOferta;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)

public class PublicadorControladorOferta {

    private Endpoint endpoint = null;

    private ControladorOferta controladorOferta = ControladorOferta.getInstance();

    @WebMethod(exclude = true)
    public void publicar() {
        String url = ConfigHelper.getWebServiceBaseURL() + "/ControladorOferta";
        System.out.println("Publicando servicio de ControladorOferta en " + url);
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
            String descripcion, LocalTime horarioInicio, LocalTime horarioFin, int remuneracion, String ciudad,
            String departamento, LocalDate fecha, Set<String> palabrasClaveSelec, byte[]imagen, String tipoDePago) throws NombreRepetidoOfertaException, noExistePublicacionException {
        controladorOferta.altaPublicacionOfertaLaboralConPaquete(empresa, tipoPubli, nombre, descripcion, horarioInicio, horarioFin, remuneracion, ciudad, departamento, fecha, palabrasClaveSelec, imagen, tipoDePago);
    }

    @WebMethod
    public void altaPublicacionOfertaLaboralGeneral(String empresa, String tipoPubli, String nombre,
            String descripcion, LocalTime horarioInicio, LocalTime horarioFin, int remuneracion, String ciudad,
            String departamento, LocalDate fecha, Set<String> palabrasClaveSelec, byte[]imagen, String tipoDePago) throws NombreRepetidoOfertaException {
        controladorOferta.altaPublicacionOfertaLaboralGeneral(empresa, tipoPubli, nombre, descripcion, horarioInicio, horarioFin, remuneracion, ciudad, departamento, fecha, palabrasClaveSelec, imagen, tipoDePago);
    }

    @WebMethod
    public void altaDeTipoDePubliDeOferLab(String nombre, String descripcion, int exposicion,
            int costo, int duracion, LocalDate fecha) throws NombreTipoPubliYaExisteException {
        controladorOferta.altaDeTipoDePubliDeOferLab(nombre, descripcion, exposicion, costo, duracion, fecha);
    }

    @WebMethod
    public void agregarPostulacion(String post, String ofer, String curri, String mot, LocalDate fecha) throws yaExistePostulacionAOfertaException {
        controladorOferta.agregarPostulacion(post, ofer, curri, mot, fecha);
    }

    @WebMethod
    public Set<String> getPostulantesString(String oferta){
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
