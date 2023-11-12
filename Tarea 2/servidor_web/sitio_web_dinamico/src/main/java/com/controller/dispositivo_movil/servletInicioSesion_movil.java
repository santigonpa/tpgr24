package com.controller.dispositivo_movil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.model.EstadoSesion;
import com.webservices.controladores.publicar.DataOferta;
import com.webservices.controladores.publicar.DataPostulante;
import com.webservices.controladores.publicar.DataUsuario;
import com.webservices.controladores.publicar.PublicadorManejadorUsuario;
import com.webservices.controladores.publicar.PublicadorManejadorUsuarioService;
import com.webservices.controladores.publicar.WrapperArrayList;

@WebServlet (description = "Servlet de inicio de sesion movil", urlPatterns = { "/iniciarSesion_movil" })
public class servletInicioSesion_movil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public servletInicioSesion_movil() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
    	
    	
    	HttpSession sesion = request.getSession();
    	String usrOemail = request.getParameter("email");
    	String psw= request.getParameter("password");
    	EstadoSesion estado;
    	

    		PublicadorManejadorUsuarioService servicePublicadorUsuario = new PublicadorManejadorUsuarioService();
    		PublicadorManejadorUsuario puertoManejadorUsuario = servicePublicadorUsuario.getPublicadorManejadorUsuarioPort();
    		
    		DataUsuario dusuario = puertoManejadorUsuario.obtenerDataUsuario(usrOemail);
      		
    		
    		if(dusuario instanceof DataPostulante) {
    		if(dusuario.getNickName().equals("null")) {
    			dusuario = puertoManejadorUsuario.obtenerDataUsuarioPorEmail(usrOemail);
    		}
    		if(dusuario.getNickName().equals("null")) {
    			estado = EstadoSesion.NO_LOGEADO;
    		}else {
			
    			if (!dusuario.getPsw().equals(psw)) {
    				estado = EstadoSesion.MAL_LOGEADO;
    			}
    			else{
	    				estado = EstadoSesion.SI_LOGEADO;
	    				// setea el usuario logueado
					
	    				request.getSession().setAttribute("usuario", dusuario);
	    				request.getSession().setAttribute("nicknameUsuario", dusuario.getNickName());
    			}
    		}
		

		if(estado == EstadoSesion.MAL_LOGEADO || estado == EstadoSesion.NO_LOGEADO) {
			sesion.setAttribute("estadoSesion", estado);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mobil/sesion_movil/inicioDeSesionErroneo_movil.jsp");
			dispatcher.forward(request, response);
		}else {
			sesion.setAttribute("estadoSesion", estado);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mobil/home_mobil/iniciarLogged_mobil.jsp");
			dispatcher.forward(request, response);
	
		}
    	}else {
    		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mobil/sesion_movil/inicioDeSesionErroneoNoPost_movil.jsp");
			dispatcher.forward(request, response);
    	}
	}
    
    public static EstadoSesion getEstado(HttpServletRequest request)
	{	//obtiene el tipo de la sesion
		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(getEstado(request) == EstadoSesion.SI_LOGEADO) {
			request.getRequestDispatcher("/WEB-INF/mobil/usuarios_movil/UsuarioSesionYaIniciada_movil.jsp").forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mobil/sesion_movil/iniciarSesion_movil.jsp");
			dispatcher.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}