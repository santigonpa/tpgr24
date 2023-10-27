package manejadores.publicar;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;
import jakarta.jws.soap.SOAPBinding.ParameterStyle;
import jakarta.xml.ws.Endpoint;
import logica_datatypes.DataEmpresa;
import logica_datatypes.DataOferta;
import logica_datatypes.DataPostulante;
import logica_datatypes.DataUsuario;
import logica_entidades.Empresa;
import logica_entidades.Paquete;
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
    public DataUsuario obtenerUsuario(String nick) {
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
    public DataUsuario obtenerUsuarioPorEmail(String email) {
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
    public HashMap<String, DataEmpresa> getDataEmpresas() {
        return manejadorUsuario.getDataEmpresas();
    }

    @WebMethod
    public DataEmpresa getDataEmpresa(String empresa) {
        return manejadorUsuario.getDataEmpresa(empresa);
    }

    @WebMethod
    public HashMap<String, DataPostulante> getDataPostulantes() {
        return manejadorUsuario.getDataPostulantes();
    }

    @WebMethod
    public DataPostulante getDataPostulante(String postulante) {
        return manejadorUsuario.getDataPostulante(postulante);
    }

    @WebMethod
    public HashMap<String, DataUsuario> getDataUsuario() {
        return manejadorUsuario.getDataUsuario();
    }

    @WebMethod
    public ArrayList<DataOferta> obtenerOfertasDeUnaEmpresa(String nickName) {
        return manejadorUsuario.obtenerOfertasDeUnaEmpresa(nickName);
    }

    @WebMethod
    public ArrayList<DataOferta> obtenerOfertasConfirmadasDeEmpresa(String nickName) {
        return manejadorUsuario.obtenerOfertasConfirmadasDeEmpresa(nickName);
    }

    @WebMethod
    public ArrayList<DataOferta> obtenerOfertasRechazadasIngresadas(String nickName) {
        return manejadorUsuario.obtenerOfertasRechazadasIngresadas(nickName);
    }
}
