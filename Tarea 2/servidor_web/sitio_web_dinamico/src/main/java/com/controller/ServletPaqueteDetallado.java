package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import com.model.EstadoSesion;
import com.webservices.controladores.publicar.DataPaquete;
import com.webservices.controladores.publicar.PublicadorManejadorPyT;
import com.webservices.controladores.publicar.PublicadorManejadorPyTService;

@WebServlet (description = "Servlet de detalle de paquete", urlPatterns = { "/DetalleDePaquete" })
@MultipartConfig

/**
 * Servlet implementation class ServletPaqueteDetallado
 */

public class ServletPaqueteDetallado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PublicadorManejadorPyTService servicePublicadorManejadorPyT = new PublicadorManejadorPyTService();
	private PublicadorManejadorPyT puertoManejadorPyT = servicePublicadorManejadorPyT.getPublicadorManejadorPyTPort();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPaqueteDetallado() {
        super();
        // TODO Auto-generated constructor stub
    }

    public static EstadoSesion getEstado(HttpServletRequest request)
	{	//obtiene el tipo de la sesion
		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
	}
    
    protected void cargarPa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
    	String nombrePaquete = request.getParameter("id");
		DataPaquete paquete = puertoManejadorPyT.getDataPaqueteIndividual(nombrePaquete);
		request.setAttribute("paquete", paquete);
		
		if(getEstado(request) == EstadoSesion.NO_LOGEADO) {	
			request.getRequestDispatcher("/WEB-INF/paquetes/detallePaquete.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/paquetes/detallePaqueteLogged.jsp").forward(request, response);
		}
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cargarPa(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
