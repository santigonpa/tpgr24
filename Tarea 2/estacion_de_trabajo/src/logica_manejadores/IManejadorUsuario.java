package logica_manejadores;

import java.util.HashMap;
import java.time.LocalDate;
import java.util.ArrayList;

import logica_datatypes.DataEmpresa;
import logica_datatypes.DataOferta;
import logica_datatypes.DataPostulante;
import logica_datatypes.DataUsuario;
import logica_entidades.Empresa;
import logica_entidades.Paquete;
import logica_entidades.Postulante;
import logica_entidades.Usuario;

public interface IManejadorUsuario {

	public abstract HashMap<String, DataEmpresa> getDataEmpresas();

	//public abstract boolean nickNameYaExiste(String nickname);

	public abstract void addUsuario(Usuario post);

	public abstract Usuario obtenerUsuario(String nickName);
	
	public abstract Usuario obtenerUsuarioPorEmail(String email);

	public abstract DataEmpresa getDataEmpresa(String empresa);

	public abstract HashMap<String, DataPostulante> getDataPostulantes();
	
	public abstract DataPostulante getDataPostulante(String postulante);

	public abstract HashMap<String, DataUsuario> getDataUsuario();

	public abstract Postulante obtenerPostulante(String post);

	public abstract ArrayList<DataOferta> obtenerOfertasDeUnaEmpresa(String nickName);
	
	public abstract ArrayList<DataOferta> obtenerOfertasConfirmadasDeEmpresa(String nickName);
	
	public abstract ArrayList<DataOferta> obtenerOfertasRechazadasIngresadas(String nickName);
	
	public abstract Empresa obtenerEmpresa(String emp);
	
	public abstract void compraPaquete(Paquete paq, String empresa, LocalDate fAlta, LocalDate fVen);

	public abstract ArrayList<DataOferta> obtenerOfertasFinalizadas(String empresa);
	
	public abstract void compraDePaquete(String paq, String empresa, String fAlta);

	
}
