package logica_Controladores;

import java.util.Date;
import java.util.Set;

import excepciones.NicknameYaExisteException;
import logica_DataTypes.DataEmpresa;
import logica_DataTypes.DataKeyWord;
import logica_DataTypes.DataTipoPublicacion;

public interface IControladorUsuario {

	public abstract Set<DataEmpresa> getDataEmpresa();

	public abstract Set<DataTipoPublicacion> getDataTipoPublicacion();

	public abstract void altaUsuarioEmpresa(String nickname, String nombre, String apellido, String email, String descripcion,
			String web)throws NicknameYaExisteException;

	public abstract Set<DataKeyWord> getDataKeyWord();

	public abstract void altaUsuarioPostulante(String nickname, String nombre, String apellido, String email, Date nacimiento,
			String web)throws NicknameYaExisteException;

}
