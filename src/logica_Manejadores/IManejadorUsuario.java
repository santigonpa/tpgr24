package logica_Manejadores;

import java.util.Map;
import java.util.Set;

import logica_DataTypes.DataEmpresa;
import logica_DataTypes.DataOferta;
import logica_DataTypes.DataPostulante;
import logica_DataTypes.DataUsuario;
import logica_Entidades.Postulante;
import logica_Entidades.Usuario;
import logica_Entidades.Empresa;

public interface IManejadorUsuario {

	public abstract Map<String, DataEmpresa> getDataEmpresas();

	//public abstract boolean nickNameYaExiste(String nickname);

	public abstract void addUsuario(Usuario post);

	//public abstract boolean emailYaExiste(String email);

	public abstract Usuario obtenerUsuario(String nickName);

	public abstract DataEmpresa getDataEmpresa(String empresa);

	public abstract Map<String, DataPostulante> getDataPostulantes();

	public abstract Map<String, DataUsuario> getDataUsuario();

	public abstract Postulante obtenerPostulante(String post);

	public abstract Set<DataOferta> obtenerOfertasDeUnaEmpresa(String nickName);

	public abstract Empresa obtenerEmpresa(String emp);
}
