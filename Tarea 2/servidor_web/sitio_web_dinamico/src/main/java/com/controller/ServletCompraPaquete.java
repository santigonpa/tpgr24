package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.model.EstadoSesion;
import com.webservices.controladores.publicar.CompraPaquete;
import com.webservices.controladores.publicar.DataEmpresa;
import com.webservices.controladores.publicar.DataPaquete;
import com.webservices.controladores.publicar.DataUsuario;
import com.webservices.controladores.publicar.Empresa;
import com.webservices.controladores.publicar.Paquete;
import com.webservices.controladores.publicar.PublicadorControladorOfertas;
import com.webservices.controladores.publicar.PublicadorControladorOfertasService;
import com.webservices.controladores.publicar.PublicadorManejadorOfertas;
import com.webservices.controladores.publicar.PublicadorManejadorOfertasService;
import com.webservices.controladores.publicar.PublicadorManejadorPyT;
import com.webservices.controladores.publicar.PublicadorManejadorPyTService;
import com.webservices.controladores.publicar.PublicadorManejadorUsuario;
import com.webservices.controladores.publicar.PublicadorManejadorUsuarioService;
import com.webservices.controladores.publicar.Usuario;

@WebServlet (description = "Servlet para comprar paquete", urlPatterns = { "/CompraPaquete" })
@MultipartConfig
/**
 * Servlet implementation class ServletCompraPaquete
 */
public class ServletCompraPaquete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 	private PublicadorManejadorOfertasService servicePublicadorManejadorOfertas = new PublicadorManejadorOfertasService();
		private PublicadorManejadorOfertas puertoManejadorOfertas = servicePublicadorManejadorOfertas.getPublicadorManejadorOfertasPort();
		private PublicadorManejadorUsuarioService servicePublicadorUsuario = new PublicadorManejadorUsuarioService();
		private PublicadorManejadorUsuario puertoManejadorUsuario = servicePublicadorUsuario.getPublicadorManejadorUsuarioPort();
		private PublicadorManejadorPyTService servicePublicadorManejadorPyT = new PublicadorManejadorPyTService();
		private PublicadorManejadorPyT puertoManejadorPyT = servicePublicadorManejadorPyT.getPublicadorManejadorPyTPort();

    public ServletCompraPaquete() {
        super();
    }

    public static EstadoSesion getEstado(HttpServletRequest request){	//obtiene el tipo de la sesion
		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");  		
  	}
    
  

    protected void cargarDatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    		
    	//no hay usuario logueado, lo mandamos a iniciar sesion
    	if(getEstado(request) == EstadoSesion.NO_LOGEADO) {
    		request.getRequestDispatcher("/WEB-INF/sesion/inicioDeSesion.jsp").forward(request, response);
    	 //es una empresa todo ok
    	}else {
	    		String nombrePaquete = request.getParameter("nombre");
	    		System.out.println(nombrePaquete);
				
	
		    	DataUsuario user = (DataUsuario) request.getSession().getAttribute("usuario");
		    	if (user instanceof DataEmpresa) {    	
			    	String nickUser = user.getNickName();
					System.out.println(nickUser);
					
					LocalDate fechaActual = LocalDate.now();
					System.out.println("Fecha antes del format: " + fechaActual.toString());

			        // Crea un formateador con el patrón "dd-MM-yyyy"
			        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

			        // Formatea la fecha en el formato deseado
			        String fechaFormateada = fechaActual.format(formatter);
 
				   puertoManejadorUsuario.compraDePaquete(nombrePaquete, nickUser, fechaFormateada);
					
					request.getRequestDispatcher("/WEB-INF/home/iniciarLogged.jsp").forward(request, response);
	    	
		    	}			
			
    		}
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cargarDatos(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
