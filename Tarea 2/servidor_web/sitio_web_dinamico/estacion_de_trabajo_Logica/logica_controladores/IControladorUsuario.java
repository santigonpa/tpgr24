package logica_controladores;

import java.time.LocalDate;

import java.util.Map;
import java.util.Set;

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
import logica_entidades.Postulacion;


public interface IControladorUsuario {

	public abstract Set<DataEmpresa> getDataEmpresa()throws UsuarioNoExisteException;

	public abstract Set<DataTipoPublicacion> getDataTipoPublicacion();

	public abstract void altaUsuarioEmpresa(String nickname, String nombre, String apellido, String email, String descripcion,
			String web , byte[]imagen , String psw)throws NicknameYaExisteException, EmailYaExisteException, campoInvalidoException;

	public abstract Set<DataKeyWord> getDataKeyWord();

	public abstract void altaUsuarioPostulante(String nickname, String nombre, String apellido, String email, LocalDate nacimiento,
			String nacionalidad, byte[]imagen , String psw)throws NicknameYaExisteException, EmailYaExisteException, campoInvalidoException;

	public abstract Map<String, OfertaLaboral> obtenerOfertarDeEmpresa(DataEmpresa empresa);

	public abstract Set<DataUsuario> getDataUsuarios() throws UsuarioNoExisteException;

	public abstract Set<DataOferta> getDataOfertasDeEmpresa(String nickName);

	public abstract Set<DataPostulante> getDataPostulante();

	public abstract void agregarPostulacionAPostulante(String nickName, Postulacion postulacion1) throws yaExistePostulacionAOfertaException;

	public abstract DataUsuario listarInfoUser(String nickName);

}
