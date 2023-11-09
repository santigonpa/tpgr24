package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.model.EstadoSesion;
import com.webservices.controladores.publicar.DataUsuario;
import com.webservices.controladores.publicar.PublicadorManejadorUsuario;
import com.webservices.controladores.publicar.PublicadorManejadorUsuarioService;

/**
 * Servlet implementation class seguirUsuarioServlet
 */
@WebServlet (description = "Servlet de dejar o empezar a seguir un usuario", urlPatterns = { "/SeguirUsuario" })
public class seguirUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PublicadorManejadorUsuarioService servicePublicadorUsuario = new PublicadorManejadorUsuarioService();
	private PublicadorManejadorUsuario puertoManejadorUsuario = servicePublicadorUsuario.getPublicadorManejadorUsuarioPort();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public seguirUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
    
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seguir = (String) request.getSession().getAttribute("seguir");
		DataUsuario userSeguidor = (DataUsuario) request.getSession().getAttribute("usuario");
		String userASeguir  = request.getParameter("usuarioASeguir");
		if(seguir.equals("seguir")) {
			 
			puertoManejadorUsuario.agregarSeguidor(userSeguidor.getNickName(), userASeguir);
			
		
		}else if(seguir.equals("dejarDeSeguir")){
			
			puertoManejadorUsuario.quitarSeguidor(userSeguidor.getNickName(), userASeguir);
			
		
		}else {
			//no hace nada es por si entra de otro lado
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/home/iniciarLogged.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
