package logica_manejadores;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.ArrayList;


import logica_datatypes.DataEmpresa;
import logica_datatypes.DataOferta;
import logica_datatypes.DataPostulante;
import logica_datatypes.DataUsuario;
import logica_entidades.Empresa;
import logica_entidades.OfertaLaboral;
import logica_entidades.Paquete;
import logica_entidades.Postulante;
import logica_entidades.Usuario;
import utils.Fabrica;

public class ManejadorUsuario implements IManejadorUsuario {
	
	private HashMap<String, Usuario> usuarios;
	private HashMap<String, Usuario> usuariosPorEmail; //los emails son unicos tambien
	private HashMap<String, Empresa> empresas;
	private HashMap<String, Postulante> postulantes;
	private HashMap<String, Paquete> paquetes;
    private static ManejadorUsuario instancia = null;

    private ManejadorUsuario() {
        usuarios = new HashMap<String, Usuario>();
        empresas = new HashMap<String, Empresa>();
        postulantes = new HashMap<String, Postulante>();
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
            this.empresas.put(nick, (Empresa) usu);
            this.usuarios.put(nick, usu);
            this.usuariosPorEmail.put(email, usu);
        } else if (usu instanceof Postulante) {
        	String nick = usu.getNickName();
            this.postulantes.put(nick, (Postulante) usu);
            this.usuarios.put(nick, usu);
            this.usuariosPorEmail.put(email, usu);
        }
    	
    }
    
	public void compraPaquete(Paquete paq, String empresa, LocalDate fAlta, LocalDate fVen) {
		Empresa emp =(Empresa) this.empresas.get(empresa);
	    int costo = paq.getCosto();
	    emp.comprarPaquete(paq, fVen, fAlta, costo);
	    emp.agregarPaquetes(paq.getNombre(), paq);
	}

	public void compraDePaquete(String paq, String empresa, String fAlta) {
		Fabrica fab = Fabrica.getInstance();
		IManejadorPyT MPyT = fab.getInManejadorPyT();
		Paquete paquete = MPyT.getPaquete(paq);
		
		Empresa emp =(Empresa) this.empresas.get(empresa);
		
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate fechaA = LocalDate.parse(fAlta, dateFormatter);
		LocalDate fechaV = fechaA.plusDays(paquete.getValidez());
		
		int costo = paquete.getCosto();
	    emp.comprarPaquete(paquete, fechaV, fechaA, costo);
	    emp.agregarPaquetes(paquete.getNombre(), paquete);
	}
	
    public Usuario obtenerUsuario(String nick) {
        Usuario user = usuarios.getOrDefault(nick, null);
    	 return user;
    }
    
    public Usuario obtenerUsuarioPorEmail(String email) {
    	
    	Usuario user = usuariosPorEmail.getOrDefault(email, null); //si no existe deberia retornar null
   	 	return user;
    }
    
    public HashMap<String, DataEmpresa> getDataEmpresas() {
    	HashMap<String, DataEmpresa> res = new HashMap<>();;
    	ArrayList<Empresa> temp = new ArrayList<>();
    	
    	// Obtener las claves del Map
    	ArrayList<String> clavesEmpresas = new ArrayList<>(this.empresas.keySet());
        for (String nombreEmpresa : clavesEmpresas) {
        	Empresa empAct = (Empresa) this.empresas.get(nombreEmpresa);
        	temp.add(empAct);
        }
        for (Empresa empAct: temp) {
        	DataEmpresa nuevaDTEmp = new DataEmpresa();
        	nuevaDTEmp.setNickName(empAct.getNickName()); 
	        nuevaDTEmp.setNombre(empAct.getNombre());  
	        nuevaDTEmp.setApellido(empAct.getApellido());
	        nuevaDTEmp.setEmail(empAct.getEmail());
	        nuevaDTEmp.setLinkWeb(empAct.getLinkWeb());
	        nuevaDTEmp.setDescripcion(empAct.getDescripcion());
	        nuevaDTEmp.setImagen(empAct.getImagen());
	        nuevaDTEmp.setPsw( empAct.getPsw());
        	res.put(empAct.getNickName(), nuevaDTEmp);
        }
        
    	return res;
    }
/*
    public boolean nickNameYaExiste(String nickname) {
        for (String user : this.usuarios.keySet()) {
            if (user==nickname) {
            	return true;
            }
        }
        return false;
    }


	public boolean emailYaExiste(String email) {
	    for (String user : this.usuariosPorEmail.keySet()) {
	        if (user.equals(email)) {
	            return true;
	        }
	    }
	    return false;
	}*/


	public DataEmpresa getDataEmpresa(String empresa) {
		Empresa emp =  empresas.get(empresa);
		DataEmpresa res = emp.getDTEmpresa();
		return res;
	}
	
	public HashMap<String, DataPostulante> getDataPostulantes() {
	    HashMap<String, DataPostulante> res = new HashMap<>();
	    
	    for (Postulante empAct : this.postulantes.values()) {
	        
	    	DataPostulante nuevaDTPost = new DataPostulante();
	    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        String formattedDate = empAct.getNacimineto().format(formatter);
	           nuevaDTPost.setNickName(empAct.getNickName()); 
	           nuevaDTPost.setNombre(empAct.getNombre());  
	           nuevaDTPost.setApellido(empAct.getApellido());
	           nuevaDTPost.setEmail(empAct.getEmail());
	           nuevaDTPost.setNacimiento(formattedDate);
	           nuevaDTPost.setNacionalidad(empAct.getNacionalidad());
	           nuevaDTPost.setImagen(empAct.getImagen());
	           nuevaDTPost.setPsw( empAct.getPsw());
	        ;
	        res.put(empAct.getNickName(), nuevaDTPost);
	    }
	    
	    return res;
	}

	public DataPostulante getDataPostulante(String postulante) {
	    Postulante empAct = this.postulantes.get(postulante);
	    DataPostulante nuevaDTPost = new DataPostulante();
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = empAct.getNacimineto().format(formatter);
           nuevaDTPost.setNickName(empAct.getNickName()); 
           nuevaDTPost.setNombre(empAct.getNombre());  
           nuevaDTPost.setApellido(empAct.getApellido());
           nuevaDTPost.setEmail(empAct.getEmail());
           nuevaDTPost.setNacimiento(formattedDate);
           nuevaDTPost.setNacionalidad(empAct.getNacionalidad());
           nuevaDTPost.setImagen(empAct.getImagen());
           nuevaDTPost.setPsw( empAct.getPsw());
	    
	    return nuevaDTPost;
	}
	
	public Postulante obtenerPostulante(String post) {
		Postulante postu = (Postulante) postulantes.get(post);
		return postu;
	}
	
	public Empresa obtenerEmpresa(String emp) {
		Empresa empre = (Empresa) empresas.get(emp);
		return empre;
	}

	@Override
	public HashMap<String, DataUsuario> getDataUsuario() {
		HashMap<String, DataUsuario> res = new HashMap<>();
		ArrayList<Usuario> temp = new ArrayList<>();
    	
    	// Obtener las claves del Map
		ArrayList<String> clavesUsuarios = new ArrayList<>(this.usuarios.keySet());
        for (String nombreUsuario : clavesUsuarios) {
        	Usuario user =  this.usuarios.get(nombreUsuario);
        	temp.add(user);
        }
        for (Usuario empAct: temp) {
        	if (empAct instanceof Empresa) {
        		Empresa empAct1 =(Empresa) empAct;
        		DataEmpresa nuevaDTEmp = new DataEmpresa();
        		nuevaDTEmp.setNickName(empAct.getNickName()); 
 	           	nuevaDTEmp.setNombre(empAct.getNombre());  
 	           	nuevaDTEmp.setApellido(empAct.getApellido());
 	           	nuevaDTEmp.setEmail(empAct.getEmail());
 	           	nuevaDTEmp.setLinkWeb(empAct1.getLinkWeb());
 	           	nuevaDTEmp.setDescripcion(empAct1.getDescripcion());
 	           	nuevaDTEmp.setImagen(empAct.getImagen());
 	           	nuevaDTEmp.setPsw( empAct.getPsw());
        		res.put(empAct.getNickName(), nuevaDTEmp);
        	}else if (empAct instanceof Postulante){
        		Postulante empAct1 =(Postulante) empAct;
        		DataPostulante nuevaDTPost = new DataPostulante();
        		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String formattedDate = empAct1.getNacimineto().format(formatter);
        		nuevaDTPost.setNickName(empAct1.getNickName()); 
 	           	nuevaDTPost.setNombre(empAct1.getNombre());  
 	           	nuevaDTPost.setApellido(empAct1.getApellido());
 	           	nuevaDTPost.setEmail(empAct1.getEmail());
 	           	nuevaDTPost.setNacimiento(formattedDate);
 	           	nuevaDTPost.setNacionalidad(empAct1.getNacionalidad());
 	           	nuevaDTPost.setImagen(empAct1.getImagen());
 	           	nuevaDTPost.setPsw( empAct1.getPsw());
        		res.put(empAct.getNickName(), nuevaDTPost);
        	}
        }
        
    	return res;
	}

	@Override
	public ArrayList<DataOferta> obtenerOfertasDeUnaEmpresa(String nickName) {
		ArrayList<DataOferta> res = new ArrayList<>();
		Empresa emp = (Empresa) this.empresas.get(nickName);
		HashMap<String, OfertaLaboral> mapaOfertas = emp.getOfertas();
		ArrayList<String> claves = new ArrayList<>(mapaOfertas.keySet());
		for (String clave : claves) {
			OfertaLaboral oferta = mapaOfertas.get(clave);
			DataOferta ofert = new DataOferta();
			DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm");
	        DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        String formattedDate = oferta.getFecha().format(formatterFecha);
	        String formattedTimeHoraFin = oferta.getHoraFin().format(formatterHora);
	        String formattedTimeHoraInicio = oferta.getHoraInicio().format(formatterHora);
			ofert.setCiudad(oferta.getCiudad());
			ofert.setCostoDeOfertaLaboral(oferta.getCosto());
			ofert.setDepartamento(oferta.getDepartamento());
			ofert.setDescripcion(oferta.getDescripcion());
			ofert.setEmpresa(oferta.getEmpresa().getNickName());
			ofert.setEstado(oferta.getEstado());
			ofert.setFechaDeAlta(formattedDate);
			ofert.setHoraFin(formattedTimeHoraFin);
			ofert.setHoraInicio(formattedTimeHoraInicio);
			ofert.setImagen(oferta.getImagen());
			ofert.setTipoDePago(oferta.getTipoDePago());
			ofert.setRemuneracion(oferta.getRemuneracion());
			ofert.setNombre(oferta.getNombreOferta());
			res.add(ofert);
		}
		return res;
	}

	public ArrayList<DataOferta> obtenerOfertasConfirmadasDeEmpresa(String nickName){
		ArrayList<DataOferta> res = new ArrayList<>();
		Empresa emp = (Empresa) this.empresas.get(nickName);
		HashMap<String, OfertaLaboral> mapaOfertas = emp.getOfertasAprobadasDeEmpresa();
		ArrayList<String> claves = new ArrayList<>(mapaOfertas.keySet());
		for (String clave : claves) {
			OfertaLaboral oferta = mapaOfertas.get(clave);
			DataOferta ofert = new DataOferta();
			DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm");
	        DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        String formattedDate = oferta.getFecha().format(formatterFecha);
	        String formattedTimeHoraFin = oferta.getHoraFin().format(formatterHora);
	        String formattedTimeHoraInicio = oferta.getHoraInicio().format(formatterHora);
			ofert.setCiudad(oferta.getCiudad());
			ofert.setCostoDeOfertaLaboral(oferta.getCosto());
			ofert.setDepartamento(oferta.getDepartamento());
			ofert.setDescripcion(oferta.getDescripcion());
			ofert.setEmpresa(oferta.getEmpresa().getNickName());
			ofert.setEstado(oferta.getEstado());
			ofert.setFechaDeAlta(formattedDate);
			ofert.setHoraFin(formattedTimeHoraFin);
			ofert.setHoraInicio(formattedTimeHoraInicio);
			ofert.setImagen(oferta.getImagen());
			ofert.setTipoDePago(oferta.getTipoDePago());
			ofert.setRemuneracion(oferta.getRemuneracion());
			ofert.setNombre(oferta.getNombreOferta());
			res.add(ofert);
		}
		return res;
	} 
	
	public ArrayList<DataOferta> obtenerOfertasRechazadasIngresadas(String nickName){
		ArrayList<DataOferta> res = new ArrayList<>();
		Empresa emp = (Empresa) this.empresas.get(nickName);
		HashMap<String, OfertaLaboral> mapaOfertas = emp.getOfertasRechazadasIngresadas();
		ArrayList<String> claves = new ArrayList<>(mapaOfertas.keySet());
		for (String clave : claves) {
			OfertaLaboral oferta = mapaOfertas.get(clave);
			DataOferta ofert = new DataOferta();
			DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm");
	        DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        String formattedDate = oferta.getFecha().format(formatterFecha);
	        String formattedTimeHoraFin = oferta.getHoraFin().format(formatterHora);
	        String formattedTimeHoraInicio = oferta.getHoraInicio().format(formatterHora);
			ofert.setCiudad(oferta.getCiudad());
			ofert.setCostoDeOfertaLaboral(oferta.getCosto());
			ofert.setDepartamento(oferta.getDepartamento());
			ofert.setDescripcion(oferta.getDescripcion());
			ofert.setEmpresa(oferta.getEmpresa().getNickName());
			ofert.setEstado(oferta.getEstado());
			ofert.setFechaDeAlta(formattedDate);
			ofert.setHoraFin(formattedTimeHoraFin);
			ofert.setHoraInicio(formattedTimeHoraInicio);
			ofert.setImagen(oferta.getImagen());
			ofert.setTipoDePago(oferta.getTipoDePago());
			ofert.setRemuneracion(oferta.getRemuneracion());
			ofert.setNombre(oferta.getNombreOferta());
			res.add(ofert);
		}
		return res;
	}



	public HashMap<String, Paquete> getPaquetes() {
		return paquetes;
	}



	public void setPaquetes(HashMap<String, Paquete> paquetes) {
		this.paquetes = paquetes;
	}
	
	public ArrayList<DataOferta> obtenerOfertasFinalizadas(String empresa){
		ArrayList<DataOferta> res = new ArrayList<>();
		Empresa emp = (Empresa) this.empresas.get(empresa);
		HashMap<String, OfertaLaboral> mapaOfertas = emp.getOfertasFinalizadas();
		ArrayList<String> claves = new ArrayList<>(mapaOfertas.keySet());
		for (String clave : claves) {
			OfertaLaboral oferta = mapaOfertas.get(clave);
			DataOferta ofert = new DataOferta();
			DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm");
	        DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        String formattedDate = oferta.getFecha().format(formatterFecha);
	        String formattedTimeHoraFin = oferta.getHoraFin().format(formatterHora);
	        String formattedTimeHoraInicio = oferta.getHoraInicio().format(formatterHora);
			ofert.setCiudad(oferta.getCiudad());
			ofert.setCostoDeOfertaLaboral(oferta.getCosto());
			ofert.setDepartamento(oferta.getDepartamento());
			ofert.setDescripcion(oferta.getDescripcion());
			ofert.setEmpresa(oferta.getEmpresa().getNickName());
			ofert.setEstado(oferta.getEstado());
			ofert.setFechaDeAlta(formattedDate);
			ofert.setHoraFin(formattedTimeHoraFin);
			ofert.setHoraInicio(formattedTimeHoraInicio);
			ofert.setImagen(oferta.getImagen());
			ofert.setTipoDePago(oferta.getTipoDePago());
			ofert.setRemuneracion(oferta.getRemuneracion());
			ofert.setNombre(oferta.getNombreOferta());
			res.add(ofert);
		}
		return res;
	}

}
