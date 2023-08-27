package logica_Manejadores;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

import logica_Manejadores.ManejadorUsuario;
import logica_Entidades.Usuario;
import logica_Entidades.Empresa;
import logica_Entidades.OfertaLaboral;
import logica_Entidades.Postulante;
import logica_DataTypes.DataEmpresa;
import logica_DataTypes.DataOferta;
import logica_DataTypes.DataPostulante;
import logica_DataTypes.DataUsuario;

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
		return this.usuarios.containsKey(nickname);
	}

	public boolean emailYaExiste(String email) {
		return this.usuariosPorEmail.containsKey(email);
	}

	public DataEmpresa getDataEmpresa(String empresa) {
		Empresa emp = (Empresa) empresas.get(empresa);
		DataEmpresa res = emp.getDTEmpresa();
		return res;
	}
	public Map<String, DataPostulante> getDataPostulantes(){
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

	public Postulante obtenerPostulante(String post) {
		Postulante p = (Postulante) postulantes.get(post);
		return p;
	}
	
	public Empresa obtenerEmpresa(String emp) {
		Empresa e = (Empresa) empresas.get(emp);
		return e;
	}

	@Override
	public Map<String, DataUsuario> getDataUsuario() {
		Map<String, DataUsuario> res = new HashMap<>();;
    	Set<Usuario> temp = new HashSet<>();
    	
    	// Obtener las claves del Map
        Set<String> clavesUsuarios = this.usuarios.keySet();
        for(String nombreUsuario : clavesUsuarios) {
        	Usuario user =  this.usuarios.get(nombreUsuario);
        	temp.add(user);
        }
        for(Usuario empAct: temp) {
        	if(empAct instanceof Empresa) {
        		Empresa empAct1 =(Empresa) empAct;
        		DataEmpresa nuevaDTEmp = new DataEmpresa(empAct.getNickName(),empAct.getNombre(),empAct.getApellido(),empAct.getEmail(), empAct1.getDescripcion(),empAct1.getLinkWeb());
            	res.put(empAct.getNickName(), nuevaDTEmp);
        	}else if (empAct instanceof Postulante){
        		Postulante empAct1 =(Postulante) empAct;
        		DataPostulante nuevaDTPost = new DataPostulante(empAct.getNickName(),empAct.getNombre(),empAct.getApellido(),empAct.getEmail(), empAct1.getNacimineto(),empAct1.getNacionalidad());
            	res.put(empAct.getNickName(), nuevaDTPost);
        	}
        }
        
    	return res;
	}

	@Override
	public Set<DataOferta> obtenerOfertasDeUnaEmpresa(String nickName) {
		Set<DataOferta> res = new HashSet<>();
		Empresa emp = (Empresa) this.empresas.get(nickName);
		Map<String,OfertaLaboral> mapaOfertas = emp.getOfertas();
		Set<String> claves = mapaOfertas.keySet();
		for(String clave : claves) {
			OfertaLaboral of = mapaOfertas.get(clave);
			DataOferta ofert = new DataOferta(of.getNombreOferta(),of.getDescripcion(),of.getCiudad(),of.getDepartamento(),of.getHoraInicio(),of.getHoraFin(),of.getRemuneracion(),of.getCosto(),of.getFecha());
			res.add(ofert);
		}
		return res;
	}

	

}
