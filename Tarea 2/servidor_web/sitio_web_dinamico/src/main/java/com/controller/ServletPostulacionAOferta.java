package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import com.model.EstadoSesion;
import com.webservices.controladores.publicar.DataOferta;
import com.webservices.controladores.publicar.DataPostulante;
import com.webservices.controladores.publicar.PublicadorManejadorOfertas;
import com.webservices.controladores.publicar.PublicadorManejadorOfertasService;
import com.webservices.controladores.publicar.PublicadorManejadorUsuario;
import com.webservices.controladores.publicar.PublicadorManejadorUsuarioService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletPostulacionAOferta
 */
@WebServlet (description = "Servlet para postularse a una oferta laboral", urlPatterns = { "/PostulacionAOferta" })
public class ServletPostulacionAOferta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PublicadorManejadorOfertasService servicePublicadorManejadorOfertas = new PublicadorManejadorOfertasService();
	private PublicadorManejadorOfertas puertoManejadorOfertas = servicePublicadorManejadorOfertas.getPublicadorManejadorOfertasPort();
	private PublicadorManejadorUsuarioService servicePublicadorUsuario = new PublicadorManejadorUsuarioService();
	private PublicadorManejadorUsuario puertoManejadorUsuario = servicePublicadorUsuario.getPublicadorManejadorUsuarioPort();
	
	
	public ServletPostulacionAOferta() {
        super();
    }
    
    public static EstadoSesion getEstado(HttpServletRequest request){	//obtiene el tipo de la sesion
   		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
   	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean banderaSesion = getEstado(request).equals(EstadoSesion.SI_LOGEADO);
		boolean banderaPostulante = request.getSession().getAttribute("usuario") instanceof DataPostulante;
		String empresaSeleccionada = request.getParameter("empresa");
		String keywordSeleccionada = request.getParameter("keyword");
		//me fijo si esta la sesion iniciada y su vez si es postulante
		if (banderaSesion && banderaPostulante) {
			if (empresaSeleccionada != null) {
				
				// cambio el campo del select empresa
				ArrayList<Object> ofertasConfirmadasWrapper = (ArrayList<Object>) puertoManejadorUsuario.obtenerOfertasConfirmadasDeEmpresa(empresaSeleccionada).getLista();
		    	ArrayList<DataOferta> ofertasConfirmadas = new ArrayList<>();

				for (Object objeto : ofertasConfirmadasWrapper) {
				    if (objeto instanceof String) {
				    	DataOferta dataTipoPublicacion = puertoManejadorOfertas.getDataOferta((String) objeto) ;
				        ofertasConfirmadas.add(dataTipoPublicacion);
				    }
				}
				
				request.setAttribute("coleccionOfertasPostulacion", ofertasConfirmadas);
				request.getRequestDispatcher("/WEB-INF/ofertasLaborales/postulacionAOfertaLogged.jsp").forward(request, response);
			
			}else if (keywordSeleccionada != null){
				// cambio el campo del select keyword
				ArrayList<Object> ofertasConfirmadasWrapper = (ArrayList<Object>) puertoManejadorOfertas.obtenerOfertasConfirmadasPorKey(keywordSeleccionada).getLista();
		    	ArrayList<DataOferta> ofertasConfirmadas = new ArrayList<>();

				for (Object objeto : ofertasConfirmadasWrapper) {
				    if (objeto instanceof DataOferta) {
				    	DataOferta dataTipoPublicacion = (DataOferta) objeto;
				        ofertasConfirmadas.add(dataTipoPublicacion);
				    }
				}
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
