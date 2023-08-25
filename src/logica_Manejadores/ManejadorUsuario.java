package logica_Manejadores;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

import logica_Manejadores.ManejadorUsuario;
import logica_Entidades.Usuario;
import logica_Entidades.Empresa;
import logica_DataTypes.DataEmpresa;
import logica_DataTypes.DataPostulante;
import logica_Entidades.Postulante;

public class ManejadorUsuario implements IManejadorUsuario {
	
	private Map<String, Usuario> usuarios;
	private Map<String, Usuario> empresas;
	private Map<String,Usuario> postulantes;
    private static ManejadorUsuario instancia = null;

    private ManejadorUsuario() {
        usuarios = new HashMap<String, Usuario>();
        empresas = new HashMap<String,Usuario>();
        postulantes = new HashMap<String,Usuario>();
    }

    public static ManejadorUsuario getinstance() {
        if (instancia == null)
            instancia = new ManejadorUsuario();
        return instancia;
    }

    public void addUsuario(Usuario usu) {
        
    	if (usu instanceof Empresa) {
            // Es un objeto de tipo Empresa
    		String nick = usu.getNickName();
            this.empresas.put(nick, usu);
            this.usuarios.put(nick, usu);
        } else if (usu instanceof Postulante) {
        	String nick = usu.getNickName();
            this.postulantes.put(nick, usu);
            this.usuarios.put(nick, usu);
        }
    	
    }
    

    public Usuario obtenerUsuario(String nick) {
        return  usuarios.getOrDefault(nick,null); //si no existe deberia retornar null
    }
    
    public Map<String, DataEmpresa> getDataEmpresas () {
    	Map<String, DataEmpresa> res = new HashMap<>();;
    	Set<Empresa> temp = new HashSet<>();
    	
    	// Obtener las claves del Map
        Set<String> clavesEmpresas = this.empresas.keySet();
        for(String nombreEmpresa : clavesEmpresas) {
        	Empresa empAct = ((Empresa) this.empresas.get(nombreEmpresa));
        	temp.add(empAct);
        }
        for(Empresa empAct: temp) {
        	DataEmpresa nuevaDTEmp = new DataEmpresa(empAct.getNickName(),empAct.getNombre(),empAct.getApellido(),empAct.getEmail(), empAct.getDescripcion(),empAct.getLinkWeb());
        	res.put(empAct.getNickName(), nuevaDTEmp);
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

	public DataEmpresa getDataEmpresa(String empresa) {
		Empresa emp = (Empresa) empresas.get(empresa);
		DataEmpresa res = emp.getDTEmpresa();
		return res;
	}
	public Map<String, DataPostulante> getDataEstudiantes(){
		Map<String, DataPostulante> res = new HashMap<>();;
    	Set<Postulante> temp = new HashSet<>();
    	
    	// Obtener las claves del Map
        Set<String> clavesPostulantes = this.postulantes.keySet();
        for(String nombrePostulante : clavesPostulantes) {
        	Postulante empAct = ((Postulante) this.postulantes.get(nombrePostulante));
        	temp.add(empAct);
        }
        for(Postulante empAct: temp) {
        	DataPostulante nuevaDTPost = new DataPostulante(empAct.getNickName(),empAct.getNombre(),empAct.getApellido(),empAct.getEmail(), empAct.getNacimineto(),empAct.getNacionalidad());
        	res.put(empAct.getNickName(), nuevaDTPost);
        }
        
    	return res;
	}

}
