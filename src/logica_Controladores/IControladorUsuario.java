package logica_Controladores;

import java.util.Set;

import logica_DataTypes.DataEmpresa;
import logica_DataTypes.DataTipoPublicacion;

public interface IControladorUsuario {

	public abstract Set<DataEmpresa> getDataEmpresa();

	public abstract Set<DataTipoPublicacion> getDataTipoPublicacion();

	public abstract void altaUsuario(String nickname, String nombre, String apellido, String email, String descripcion,
			String web);

}
