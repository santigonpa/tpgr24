package com.controller;

import java.io.IOException;

import com.model.EstadoSesion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logica_Manejadores.IManejadorUsuario;
import utils.Fabrica;

/**
 * Servlet implementation Alta Usuario
 */
@WebServlet (description = "Servlet de alta de usuario", urlPatterns = { "/AltaUsuario" })
public class ServletAltaUsuario extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public ServletAltaUsuario () {
		super();
	}

	private Fabrica fab = Fabrica.getInstance();
	private IManejadorUsuario IMU = fab.getInManejadorUsuario();
    
    public static EstadoSesion getEstado(HttpServletRequest request)
	{	//obtiene el tipo de la sesion
		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(getEstado(request) == EstadoSesion.SI_LOGEADO) {
			//el usuario estaria logeado y no tendria sentido registrar
			//ver como implementar esto despues si con una pagina de error que diga algo
		}
		
		request.getRequestDispatcher("/WEB-INF/usuarios/AltaUsuario.jsp").forward(request,response);
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//me falta terminar implementar el doPost y el form del alta usuario jsp
 	}
	
	
}
