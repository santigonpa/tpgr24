package com.controller.dispositivo_movil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.model.EstadoSesion;
import com.webservices.controladores.publicar.PublicadorManejadorOfertas;
import com.webservices.controladores.publicar.PublicadorManejadorOfertasService;
import com.webservices.controladores.publicar.PublicadorManejadorUsuario;
import com.webservices.controladores.publicar.PublicadorManejadorUsuarioService;

/**
 * Servlet implementation class servletVerPostulaciones_movil
 */
@WebServlet (description = "Servlet de ver postulacines", urlPatterns = { "/servletVerPostulaciones_movil" })
public class servletVerPostulaciones_movil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PublicadorManejadorUsuarioService servicePublicadorUsuario = new PublicadorManejadorUsuarioService();
	private PublicadorManejadorUsuario puertoManejadorUsuario = servicePublicadorUsuario.getPublicadorManejadorUsuarioPort();
	private PublicadorManejadorOfertasService servicePublicadorOfertas = new PublicadorManejadorOfertasService();
	private PublicadorManejadorOfertas puertoManejadorOfertas = servicePublicadorOfertas.getPublicadorManejadorOfertasPort();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletVerPostulaciones_movil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
 

       
       protected void processRequest(HttpServletRequest request, HttpServletResponse response)
   			throws ServletException, IOException{
       	
       }
       
       public static EstadoSesion getEstado(HttpServletRequest request)
   	{	//obtiene el tipo de la sesion
   		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
   	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
