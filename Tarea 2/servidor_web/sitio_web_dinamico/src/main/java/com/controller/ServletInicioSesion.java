package com.controller;

import jakarta.servlet.RequestDispatcher;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logica_entidades.Usuario;
import logica_manejadores.IManejadorUsuario;
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
    			usuario = mu.obtenerUsuarioPorEmail(usrOemail);
    		}
    		if(usuario == null) {
    			throw new UsuarioNoExisteException("Puede que tu nombre de usuario o correo electronico sea incorrecto. Vuelva a intentarlo.");
    		}
			if (!usuario.getPsw().equals(psw)) 
				estado = EstadoSesion.MAL_LOGEADO;
			else{
				estado = EstadoSesion.SI_LOGEADO;
				// setea el usuario logueado
				Usuario usr = mu.obtenerUsuario(usrOemail);
				request.getSession().setAttribute("usuario", usr);
				request.getSession().setAttribute("nicknameUsuario", usrOemail);
			}
    	} catch (UsuarioNoExisteException ex) {
			estado = EstadoSesion.NO_LOGEADO;
		}

		if(estado == EstadoSesion.MAL_LOGEADO || estado == EstadoSesion.NO_LOGEADO) {
			sesion.setAttribute("estadoSesion", estado);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/sesion/inicioDeSesionErroneo.jsp");
			dispatcher.forward(request, response);
		}else {
			sesion.setAttribute("estadoSesion", estado);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/home/iniciarLogged.jsp");
			dispatcher.forward(request, response);
		}
	}
    
    public static EstadoSesion getEstado(HttpServletRequest request)
	{	//obtiene el tipo de la sesion
		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(getEstado(request) == EstadoSesion.SI_LOGEADO) {
			request.getRequestDispatcher("/WEB-INF/usuarios/UsuarioSesionYaIniciada.jsp").forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/sesion/inicioDeSesion.jsp");
			dispatcher.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
