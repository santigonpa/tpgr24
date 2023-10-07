package com.controller;

import java.io.IOException;
import java.util.Set;

import com.model.EstadoSesion;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logica_DataTypes.DataOferta;
import logica_Entidades.Postulante;
import logica_Manejadores.IManejadorOferta;
import logica_Manejadores.IManejadorUsuario;
import utils.Fabrica;

/**
 * Servlet implementation class ServletPostulacionAOferta
 */
@WebServlet (description = "Servlet para postularse a una oferta laboral", urlPatterns = { "/PostulacionAOferta" })
public class ServletPostulacionAOferta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Fabrica fab = Fabrica.getInstance();
	private static IManejadorUsuario manejadorUser = fab.getInManejadorUsuario();
	private static IManejadorOferta manejadorOfer = fab.getInManejadorOferta();
	
	
	public ServletPostulacionAOferta() {
        super();
    }
    
    public static EstadoSesion getEstado(HttpServletRequest request)
   	{	//obtiene el tipo de la sesion
   		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
   	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean banderaSesion = getEstado(request).equals(EstadoSesion.SI_LOGEADO);
		boolean banderaPostulante = request.getSession().getAttribute("usuario") instanceof Postulante;
		String empresaSeleccionada = request.getParameter("empresa");
		String keywordSeleccionada = request.getParameter("keyword");
		//me fijo si esta la sesion iniciada y su vez si es postulante
		if(banderaSesion && banderaPostulante) {
			if(empresaSeleccionada != null) {
				
				// cambio el campo del select empresa
				Set<DataOferta> ofertasConfirmadas = manejadorUser.obtenerOfertasConfirmadasDeEmpresa(empresaSeleccionada);
				request.setAttribute("coleccionOfertasPostulacion", ofertasConfirmadas);
				request.getRequestDispatcher("/WEB-INF/ofertasLaborales/postulacionAOfertaLogged.jsp").forward(request, response);
			
			}else if(keywordSeleccionada != null){
				// cambio el campo del select keyword
				Set<DataOferta> ofertasConfirmadas = manejadorOfer.obtenerOfertasConfirmadasPorKey(keywordSeleccionada);
				request.setAttribute("coleccionOfertasPostulacion", ofertasConfirmadas);
				request.getRequestDispatcher("/WEB-INF/ofertasLaborales/postulacionAOfertaLogged.jsp").forward(request, response);
			
			}else {
				request.getRequestDispatcher("/WEB-INF/ofertasLaborales/postulacionAOfertaLogged.jsp").forward(request, response);
			}
		
		// NO DEBERIA PODER POSTULARSE
		}else {
			
			request.getRequestDispatcher("/WEB-INF/ofertasLaborales/errorPostulacionAOferta.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
