package logica_Manejadores;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import logica.ManejadorUsuario;
import logica.Usuario;
import logica_Entidades.Empresa;

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
        String nick = usu.getNickname();
        usuarios.put(nick, usu);
    }

    public Usuario obtenerUsuario(String nick) {
        return ((Usuario) usuarios.get(nick));
    }
    
    public set<DataEmpresa> getDataEmpresas () {
    	set<DataEmpresa> res;
    	set<Empresa> temp;
    	
    	// Obtener las claves del Map
        Set<String> clavesEmpresas = this.empresas.keySet();
        for(String nombreEmpresa : clavesEmpresas) {
        	Empresa empAct = ((Empresa) this.empresas.get(nombreEmpresa));
        	temp.insert(empAct);
        }
        for(Empresa empAct: temp) {
        	DataEmpresa nuevaDTEmp = new DataEmpresa(empAct.getNombre());
        	res.insert(nuevaDTEmp);
        }
        
    	return res;
    }

}
