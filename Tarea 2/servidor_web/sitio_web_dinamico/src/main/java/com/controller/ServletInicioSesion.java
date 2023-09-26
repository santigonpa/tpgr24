package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logica_Entidades.Usuario;
import logica_Manejadores.IManejadorUsuario;
import utils.Fabrica;

import java.io.IOException;

import com.model.EstadoSesion;

import excepciones.UsuarioNoExisteException;

@WebServlet (description = "Servlet de inicio de sesion", urlPatterns = { "/iniciarSesion" })
public class ServletInicioSesion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ServletInicioSesion() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
    	HttpSession sesion = request.getSession();
    	String usrOemail = request.getParameter("email");
    	String psw= request.getParameter("password");
    	EstadoSesion estado;
    	
    	try {
    		Fabrica fabrica = Fabrica.getInstance();
    		IManejadorUsuario mu = fabrica.getInManejadorUsuario();
    		Usuario usuario = mu.obtenerUsuario(usrOemail);
    		if(usuario == null) {
    			throw new UsuarioNoExisteException("Puede que tu nombre de usuario o correo electronico sea incorrecto. Vuelva a intentarlo.");
    		}
			if (!usuario.getPsw().equals(psw)) 
				estado = EstadoSesion.MAL_LOGEADO;
			else{
				estado = EstadoSesion.SI_LOGEADO;
				// setea el usuario logueado
				request.getSession().setAttribute("usuarioLogeado", usrOemail);
			}
    	} catch (UsuarioNoExisteException ex) {
			estado = EstadoSesion.MAL_LOGEADO;
		}

		if(estado == EstadoSesion.MAL_LOGEADO) {
			sesion.setAttribute("estadoSesion", estado);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/sesion/inicioDeSesionErroneo.jsp");
			dispatcher.forward(request, response);
		}else {
			sesion.setAttribute("estadoSesion", estado);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/sesion/iniciarLogged.jsp");
			dispatcher.forward(request, response);
		}
	}

    	
    	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/sesion/inicioDeSesion.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
