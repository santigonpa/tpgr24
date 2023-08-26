package logica_Controladores;

import java.util.Date;
import java.util.Map;
import java.util.Set;

import excepciones.NicknameYaExisteException;
import excepciones.UsuarioNoExisteException;
import logica_DataTypes.DataEmpresa;
import logica_DataTypes.DataKeyWord;
import logica_DataTypes.DataOferta;
import logica_DataTypes.DataTipoPublicacion;
import logica_DataTypes.DataUsuario;
import logica_Entidades.OfertaLaboral;


public interface IControladorUsuario {

	public abstract Set<DataEmpresa> getDataEmpresa()throws UsuarioNoExisteException;

	public abstract Set<DataTipoPublicacion> getDataTipoPublicacion();

	public abstract void altaUsuarioEmpresa(String nickname, String nombre, String apellido, String email, String descripcion,
			String web)throws NicknameYaExisteException;

	public abstract Set<DataKeyWord> getDataKeyWord();

	public abstract void altaUsuarioPostulante(String nickname, String nombre, String apellido, String email, Date nacimiento,
			String nacionalidad)throws NicknameYaExisteException;

	public abstract Map<String, OfertaLaboral> obtenerOfertarDeEmpresa(DataEmpresa empresa);

	public abstract Set<DataUsuario> getDataUsuarios() throws UsuarioNoExisteException;

	public abstract Set<DataOferta> getDataOfertasDeEmpresa(String nickName);

}
