package com.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.model.EstadoSesion;
import com.webservices.controladores.publicar.DataUsuario;
import com.webservices.controladores.publicar.PublicadorManejadorUsuario;
import com.webservices.controladores.publicar.PublicadorManejadorUsuarioService;
import com.webservices.controladores.publicar.WrapperHashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class ServletConsultaUsuario
 */
@WebServlet (description = "Servlet de Consulta de usuario", urlPatterns = { "/ConsultarUsuario" })
public class ServletConsultaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PublicadorManejadorUsuarioService servicePublicadorUsuario = new PublicadorManejadorUsuarioService();
	private PublicadorManejadorUsuario puertoControladorUsuario = servicePublicadorUsuario.getPublicadorManejadorUsuarioPort();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConsultaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    public static EstadoSesion getEstado(HttpServletRequest request)
	{	//obtiene el tipo de la sesion
		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
		
	}
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	String nickUser = request.getParameter("VerPerfil");
    	if(nickUser==null) {
	    	WrapperHashMap usuariosWrap =  puertoControladorUsuario.getDataUsuario();
	    	 
			List<com.webservices.controladores.publicar.WrapperHashMap.Mapa.Entry> claves = usuariosWrap.getMapa().getEntry();
			
			Set<DataUsuario> usuariosColeccion = new HashSet<DataUsuario>();
			for(com.webservices.controladores.publicar.WrapperHashMap.Mapa.Entry clave : claves ) {
				DataUsuario dataUser = (DataUsuario) clave.getValue();
				usuariosColeccion.add(dataUser);
			}
			request.setAttribute("coleccionDataUsuarios", usuariosColeccion);
			
			if(getEstado(request) == EstadoSesion.SI_LOGEADO) {
				//hace algo si el usuario esta correctamente logeado de una forma
				
				
				request.getRequestDispatcher("/WEB-INF/usuarios/consultaUsuariosLogged.jsp").forward(request,response);
			
			
			}else {
				//hace otra cosa dependiendo si el usuario no esta logeado
				
				
				request.getRequestDispatcher("/WEB-INF/usuarios/consultaUsuarios.jsp").forward(request,response);
			}
    	}else {
    		request.setAttribute("VerPerfil", nickUser);
			
			request.getRequestDispatcher("VerPerfil").forward(request, response);
    	}
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
