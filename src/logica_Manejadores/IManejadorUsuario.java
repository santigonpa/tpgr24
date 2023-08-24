package logica_Manejadores;

import java.util.Set;
import java.util.Map;

import logica_DataTypes.DataEmpresa;
import logica_Entidades.Usuario;

public interface IManejadorUsuario {

	public abstract Map<String, DataEmpresa> getDataEmpresas();

	public abstract boolean nickNameYaExiste(String nickname);

	public abstract void addUsuario(Usuario post);

	public abstract boolean emailYaExiste(String email);

	public abstract Usuario obtenerUsuario(String nickName);



}
