package logica_manejadores;

import java.util.Map;
import java.util.Set;

import logica_datatypes.DataEmpresa;
import logica_datatypes.DataOferta;
import logica_datatypes.DataPostulante;
import logica_datatypes.DataUsuario;
import logica_entidades.Empresa;
import logica_entidades.Postulante;
import logica_entidades.Usuario;

public interface IManejadorUsuario {

	public abstract Map<String, DataEmpresa> getDataEmpresas();

	//public abstract boolean nickNameYaExiste(String nickname);

	public abstract void addUsuario(Usuario post);

	//public abstract boolean emailYaExiste(String email);

	public abstract Usuario obtenerUsuario(String nickName);
	
	public abstract Usuario obtenerUsuarioPorEmail(String email);

	public abstract DataEmpresa getDataEmpresa(String empresa);

	public abstract Map<String, DataPostulante> getDataPostulantes();
	
	public abstract DataPostulante getDataPostulante(String postulante);


	public abstract Map<String, DataUsuario> getDataUsuario();

	public abstract Postulante obtenerPostulante(String post);

	public abstract Set<DataOferta> obtenerOfertasDeUnaEmpresa(String nickName);
	
	public abstract Set<DataOferta> obtenerOfertasConfirmadasDeEmpresa(String nickName);
	
	public abstract Set<DataOferta> obtenerOfertasRechazadasIngresadas(String nickName);
	
	public abstract Empresa obtenerEmpresa(String emp);

	
}
