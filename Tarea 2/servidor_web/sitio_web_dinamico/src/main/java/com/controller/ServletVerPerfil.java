package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.model.EstadoSesion;
import com.webservices.controladores.publicar.DataEmpresa;
import com.webservices.controladores.publicar.DataOferta;
import com.webservices.controladores.publicar.DataPostulante;
import com.webservices.controladores.publicar.DataUsuario;
import com.webservices.controladores.publicar.PublicadorManejadorOfertas;
import com.webservices.controladores.publicar.PublicadorManejadorOfertasService;
import com.webservices.controladores.publicar.PublicadorManejadorUsuario;
import com.webservices.controladores.publicar.PublicadorManejadorUsuarioService;
import com.webservices.controladores.publicar.WrapperArrayList;
import com.webservices.controladores.publicar.WrapperHashMap;

@WebServlet (description = "Servlet de ver perfil de usuario", urlPatterns = { "/VerPerfil" })
public class ServletVerPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private PublicadorManejadorUsuarioService servicePublicadorUsuario = new PublicadorManejadorUsuarioService();
	private PublicadorManejadorUsuario puertoManejadorUsuario = servicePublicadorUsuario.getPublicadorManejadorUsuarioPort();
	private PublicadorManejadorOfertasService servicePublicadorOfertas = new PublicadorManejadorOfertasService();
	private PublicadorManejadorOfertas puertoManejadorOfertas = servicePublicadorOfertas.getPublicadorManejadorOfertasPort();
    public ServletVerPerfil() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
    	
    }
    
    public static EstadoSesion getEstado(HttpServletRequest request)
	{	//obtiene el tipo de la sesion
		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
	}

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String usuarioAConsultar;
		
		if(request.getParameter("VerPerfil") != null){ 
			
			usuarioAConsultar = (String) request.getParameter("VerPerfil");
			 
		
		}else if (request.getAttribute("VerPerfil") == null)  {
			
			
			
			 DataUsuario usuarioVerPerfil = (DataUsuario) request.getSession().getAttribute("usuario");
			 usuarioAConsultar = usuarioVerPerfil.getNickName();
			
	
		
		}else {
		 usuarioAConsultar = (String) request.getAttribute("VerPerfil");
		 System.out.println(usuarioAConsultar);
		}
		
		DataUsuario usuarioConsultar = null;
		
		List<WrapperHashMap.Mapa.Entry> usuarios =  puertoManejadorUsuario.getDataUsuario().getMapa().getEntry();
		for(WrapperHashMap.Mapa.Entry dtUser : usuarios) {
			if(((DataUsuario) dtUser.getValue()).getNickName().equals(usuarioAConsultar)) {usuarioConsultar = (DataUsuario) dtUser.getValue();}
		}
		//DataUsuario usuarioConsultar = usuarios.get(usuarioAConsultar);
		String tipoUser;
		
		if(usuarioConsultar instanceof DataPostulante) {
			tipoUser = "Postulante";
		}else {
			tipoUser = "Empresa";
		}
		
		WrapperArrayList wrapperSeguidores = puertoManejadorUsuario.obtenerSeguidores(usuarioConsultar.getNickName());
		WrapperArrayList wrapperSeguidos = puertoManejadorUsuario.obtenerSeguidos(usuarioConsultar.getNickName());
		
		Set<DataUsuario> usuariosSeguidores = new HashSet<>();
		Set<DataUsuario> usuariosSeguidos = new HashSet<>();
		
		for(Object obj : wrapperSeguidores.getLista()) {
			String objString = (String) obj;
			DataUsuario user = puertoManejadorUsuario.obtenerDataUsuario(objString);
			usuariosSeguidores.add(user);
		}
		
		for(Object obj : wrapperSeguidos.getLista()) {
			String objString = (String) obj;
			DataUsuario user = puertoManejadorUsuario.obtenerDataUsuario(objString);
			usuariosSeguidos.add(user);
		}
		
		//seteamos en el request el usuario a consultar
		request.setAttribute("consultar", usuarioConsultar);
		
		// setteo los seguidos y los seguidores del usuario a consultar
		request.setAttribute("seguidos", usuariosSeguidos);
		request.setAttribute("seguidores", usuariosSeguidores);
		
		
		if(	(getEstado(request) == EstadoSesion.SI_LOGEADO)  ) {
				
			DataUsuario user = (DataUsuario) request.getSession().getAttribute("usuario");
			if(user instanceof DataPostulante) {		
					//Esta consultando su propio perfil
				
					if(user.getNickName().equals(usuarioAConsultar)) {
						request.getRequestDispatcher("/WEB-INF/usuarios/MiUsuarioPostulante.jsp").forward(request, response);
						
					}else {
						if(usuarioConsultar instanceof DataEmpresa) {
							WrapperArrayList wrapperArr = puertoManejadorUsuario.obtenerOfertasConfirmadasDeEmpresa(usuarioAConsultar);
							List<Object> ofertasConfirmadasWrapper = wrapperArr.getLista();
							Set<DataOferta> ofertasConfi = new HashSet<>();
							Set<String> nombresOfer = new HashSet<>();
							
							for (Object objeto : ofertasConfirmadasWrapper) {
							    if (objeto instanceof String) {
							    	String dataOfer = (String) objeto;
							    	nombresOfer.add(dataOfer);
							    }
							}
							for(String nombreOferta : nombresOfer ) {
								DataOferta ofertaData = puertoManejadorOfertas.getDataOferta(nombreOferta);
								ofertasConfi.add(ofertaData);
							}
							request.setAttribute("ofertasConfirmadas",ofertasConfi);
							
							request.getRequestDispatcher("/WEB-INF/usuarios/Consulta"+tipoUser+"Logged.jsp").forward(request, response);
						}else {
							request.getRequestDispatcher("/WEB-INF/usuarios/Consulta"+tipoUser+"Logged.jsp").forward(request, response);
						}
					}
						
				
				
				}else {//es empresa
					
					if(usuarioConsultar instanceof DataEmpresa) {
						WrapperArrayList wrapperArr = puertoManejadorUsuario.obtenerOfertasConfirmadasDeEmpresa(usuarioAConsultar);
						List<Object> ofertasConfirmadasWrapper = wrapperArr.getLista();
						Set<DataOferta> ofertasConfi = new HashSet<>();
						Set<String> nombresOfer = new HashSet<>();
						
						for (Object objeto : ofertasConfirmadasWrapper) {
						    if (objeto instanceof String) {
						    	String dataOfer = (String) objeto;
						    	nombresOfer.add(dataOfer);
						    }
						}
						for(String nombreOferta : nombresOfer ) {
							DataOferta ofertaData = puertoManejadorOfertas.getDataOferta(nombreOferta);
							ofertasConfi.add(ofertaData);
						}
						request.setAttribute("ofertasConfirmadas",ofertasConfi);
						
						WrapperArrayList wrapperArray = puertoManejadorUsuario.obtenerOfertasRechazadasIngresadas(usuarioAConsultar);
						List<Object> ofertasRechWrapper = wrapperArray.getLista();
						Set<DataOferta> ofertasRech = new HashSet<>();
						Set<String> ofertasRechString = new HashSet<>();
						
						for (Object objeto : ofertasRechWrapper) {
						    if (objeto instanceof String) {
						    	String dataOferRech = (String) objeto;
						    	ofertasRechString.add(dataOferRech);
						    }
						}
						
						for(String nombreOfertaRech : ofertasRechString ) {
							DataOferta ofertaDataRech = puertoManejadorOfertas.getDataOferta(nombreOfertaRech);
							ofertasRech.add(ofertaDataRech);
						}
						
						WrapperArrayList wrapperOferFin = puertoManejadorUsuario.obtenerOfertasFinalizadas(usuarioAConsultar);
						List<Object> oferFinWrapper = wrapperOferFin.getLista();
						Set<DataOferta> oferFin = new HashSet<>();
						Set<String> oferFinString = new HashSet<>();
						
						for (Object objeto : oferFinWrapper) {
						    if (objeto instanceof String) {
						    	String dataOferFin = (String) objeto;
						    	oferFinString.add(dataOferFin);
						    }
						}
						
						for(String nombreOfertaFin : oferFinString ) {
							DataOferta ofertaDataFin = puertoManejadorOfertas.getDataOferta(nombreOfertaFin);
							oferFin.add(ofertaDataFin);
						}
						
						request.setAttribute("ofertasRyI",ofertasRech);
						request.setAttribute("oferFin", oferFin);
						if(user.getNickName().equals(usuarioAConsultar)) {	
						
						//Esta consultando su propio perfil
						request.getRequestDispatcher("/WEB-INF/usuarios/MiUsuarioEmpresa.jsp").forward(request, response);
						
						}else{//Esta consultando el perfil de otro
							request.getRequestDispatcher("/WEB-INF/usuarios/ConsultaEmpresaLogged.jsp").forward(request, response);
							
						}
					}else{
							request.getRequestDispatcher("/WEB-INF/usuarios/ConsultaPostulanteLogged.jsp").forward(request, response);	
					}
				}
					
		
		}else { // LA SESION NO ESTA INICIADA
			
			if(tipoUser.equals("Empresa")) {
				WrapperArrayList wrapperArr = puertoManejadorUsuario.obtenerOfertasConfirmadasDeEmpresa(usuarioAConsultar);
				List<Object> ofertasConfirmadasWrapper = wrapperArr.getLista();
				Set<DataOferta> ofertasConfi = new HashSet<>();
				Set<String> nombresOfer = new HashSet<>();
				
				for (Object objeto : ofertasConfirmadasWrapper) {
				    if (objeto instanceof String) {
				    	String dataOfer = (String) objeto;
				    	nombresOfer.add(dataOfer);
				    }
				}
				for(String nombreOferta : nombresOfer ) {
					DataOferta ofertaData = puertoManejadorOfertas.getDataOferta(nombreOferta);
					ofertasConfi.add(ofertaData);
				}
				
				request.setAttribute("ofertasConfirmadas",ofertasConfi);
			}
			
			request.getRequestDispatcher("/WEB-INF/usuarios/Consulta"+tipoUser+".jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
