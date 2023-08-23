package logica_Manejadores;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import logica_Manejadores.ManejadorUsuario;
import logica_Entidades.Usuario;
import logica_Entidades.Empresa;
import logica_DataTypes.DataEmpresa;
import logica_Entidades.Postulante;

public class ManejadorUsuario {
	
	private Map<String, Usuario> usuarios;
	private Map<String,Empresa> empresas;
	private Map<String,Postulante> postulantes;
    private static ManejadorUsuario instancia = null;

    private ManejadorUsuario() {
        usuarios = new HashMap<String, Usuario>();
    }

    public static ManejadorUsuario getinstance() {
        if (instancia == null)
            instancia = new ManejadorUsuario();
        return instancia;
    }

    public void addUsuario(Usuario usu) {
        String nick = usu.getNickName();
        usuarios.put(nick, usu);
    }

    public Usuario obtenerUsuario(String nick) {
        return ((Usuario) usuarios.get(nick));
    }
    
    @SuppressWarnings("null")
	public Set<DataEmpresa> getDataEmpresas () {
    	Set<DataEmpresa> res = null;
    	Set<Empresa> temp = null;
    	
    	// Obtener las claves del Map
        Set<String> clavesEmpresas = this.empresas.keySet();
        for(String nombreEmpresa : clavesEmpresas) {
        	Empresa empAct = ((Empresa) this.empresas.get(nombreEmpresa));
        	temp.add(empAct);
        }
        for(Empresa empAct: temp) {
        	DataEmpresa nuevaDTEmp = new DataEmpresa(empAct.getNickName(),empAct.getNombre(),empAct.getApellido(),empAct.getEmail(), empAct.getDescripcion(),empAct.getLinkWeb());
        	res.add(nuevaDTEmp);
        }
        
    	return res;
    }

	public boolean nickNameYaExiste(String nickname) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean emailYaExiste(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	public Postulante obtenerPostulante(String postulante) {
		// TODO Auto-generated method stub
		return null;
	}

}
