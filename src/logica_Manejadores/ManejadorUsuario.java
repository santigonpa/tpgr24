package logica_Manejadores;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

import logica_Manejadores.ManejadorUsuario;
import logica_Entidades.Usuario;
import logica_Entidades.Empresa;
import logica_DataTypes.DataEmpresa;
import logica_Entidades.Postulante;

public class ManejadorUsuario implements IManejadorUsuario {
	
	private Map<String, Usuario> usuarios;
	private Map<String,Usuario> usuariosPorEmail; //los emails son unicos tambien
	private Map<String, Usuario> empresas;
	private Map<String,Usuario> postulantes;
    private static ManejadorUsuario instancia = null;

    private ManejadorUsuario() {
        usuarios = new HashMap<String, Usuario>();
        empresas = new HashMap<String,Usuario>();
        postulantes = new HashMap<String,Usuario>();
        usuariosPorEmail = new HashMap<String, Usuario>();
        
    }

    public static ManejadorUsuario getinstance() {
        if (instancia == null)
            instancia = new ManejadorUsuario();
        return instancia;
    }

    public void addUsuario(Usuario usu) {
        String email = usu.getEmail();
    	if (usu instanceof Empresa) {
            // Es un objeto de tipo Empresa
    		String nick = usu.getNickName();
            this.empresas.put(nick, usu);
            this.usuarios.put(nick, usu);
            this.usuariosPorEmail.put(email, usu);
        } else if (usu instanceof Postulante) {
        	String nick = usu.getNickName();
            this.postulantes.put(nick, usu);
            this.usuarios.put(nick, usu);
            this.usuariosPorEmail.put(email, usu);
        }
    	
    }
    

    public Usuario obtenerUsuario(String nick) {
        return  usuarios.getOrDefault(nick,null); //si no existe deberia retornar null
    }
    
    public Usuario obtenerUsuarioPorEmail(String email) {
        return  usuariosPorEmail.getOrDefault(email,null); //si no existe deberia retornar null
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

}
