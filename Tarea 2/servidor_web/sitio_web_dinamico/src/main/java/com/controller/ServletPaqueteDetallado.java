package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logica_datatypes.DataPaquete;
import logica_entidades.Usuario;
import logica_manejadores.IManejadorPyT;
import utils.Fabrica;

import java.io.IOException;

import com.model.EstadoSesion;

@WebServlet (description = "Servlet de detalle de paquete", urlPatterns = { "/DetalleDePaquete" })
@MultipartConfig

/**
 * Servlet implementation class ServletPaqueteDetallado
 */

public class ServletPaqueteDetallado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Fabrica fab = Fabrica.getInstance();
	private static IManejadorPyT IPYT = fab.getInManejadorPyT();
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
		DataPaquete paquete = IPYT.getDataPaquete(nombrePaquete);
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
