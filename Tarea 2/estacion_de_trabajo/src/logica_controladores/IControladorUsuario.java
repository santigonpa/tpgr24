package logica_controladores;

import java.time.LocalDate;

import java.util.HashMap;
import java.util.ArrayList;

import excepciones.EmailYaExisteException;
import excepciones.NicknameYaExisteException;
import excepciones.UsuarioNoExisteException;
import excepciones.campoInvalidoException;
import excepciones.yaExistePostulacionAOfertaException;
import logica_datatypes.DataEmpresa;
import logica_datatypes.DataKeyWord;
import logica_datatypes.DataOferta;
import logica_datatypes.DataPostulante;
import logica_datatypes.DataTipoPublicacion;
import logica_datatypes.DataUsuario;
import logica_entidades.OfertaLaboral;
import logica_entidades.Paquete;
import logica_entidades.Postulacion;


public interface IControladorUsuario {

	public abstract ArrayList<DataEmpresa> getDataEmpresa()throws UsuarioNoExisteException;
	
	public abstract void comprarPaquete(Paquete paq, String emp);

	public abstract ArrayList<DataTipoPublicacion> getDataTipoPublicacion();
	
	public abstract ArrayList<DataTipoPublicacion> getPublicacionesEmpresa(String emp);

	public abstract void altaUsuarioEmpresa(String nickname, String nombre, String apellido, String email, String descripcion,
			String web , byte[]imagen , String psw)throws NicknameYaExisteException, EmailYaExisteException, campoInvalidoException;

	public abstract ArrayList<DataKeyWord> getDataKeyWord();

	public abstract void altaUsuarioPostulante(String nickname, String nombre, String apellido, String email, LocalDate nacimiento,
			String nacionalidad, byte[]imagen , String psw)throws NicknameYaExisteException, EmailYaExisteException, campoInvalidoException;

	public abstract HashMap<String, OfertaLaboral> obtenerOfertarDeEmpresa(DataEmpresa empresa);

	public abstract ArrayList<DataUsuario> getDataUsuarios() throws UsuarioNoExisteException;

	public abstract ArrayList<DataOferta> getDataOfertasDeEmpresa(String nickName);

	public abstract ArrayList<DataPostulante> getDataPostulante();

	public abstract void agregarPostulacionAPostulante(String nickName, Postulacion postulacion1) throws yaExistePostulacionAOfertaException;

	public abstract DataUsuario listarInfoUser(String nickName);
	
	public abstract void modificarDatosPostulante(String nickname, String nombre, String apellido, String email, String nacimiento,
			String nacionalidad, byte[]imagen , String psw);
	
	public abstract void modificarDatosEmpresa(String nickname, String nombre, String apellido, String email, String descripcion,
			String web , byte[]imagen , String psw);

	public abstract ArrayList<Postulacion> obtenerPostulaciones(String usuario);
	

}
