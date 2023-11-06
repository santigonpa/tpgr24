package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.model.EstadoSesion;
import com.webservices.controladores.publicar.DataEmpresa;
import com.webservices.controladores.publicar.DataOferta;
import com.webservices.controladores.publicar.Empresa;
import com.webservices.controladores.publicar.PublicadorManejadorOfertas;
import com.webservices.controladores.publicar.PublicadorManejadorOfertasService;
import com.webservices.controladores.publicar.PublicadorManejadorUsuario;
import com.webservices.controladores.publicar.PublicadorManejadorUsuarioService;

@WebServlet (description = "Servlet seleccionar Postulacion a Oferta Laboral", urlPatterns = { "/SeleccionarPostulacion" })
public class ServletSeleccionarPostulacionaOferta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PublicadorManejadorOfertasService servicePublicadorManejadorOfertas = new PublicadorManejadorOfertasService();
	private PublicadorManejadorOfertas puertoManejadorOfertas = servicePublicadorManejadorOfertas.getPublicadorManejadorOfertasPort();
	private PublicadorManejadorUsuarioService servicePublicadorManejadorUsuarios = new PublicadorManejadorUsuarioService();
	private PublicadorManejadorUsuario puertoManejadorUsuarios = servicePublicadorManejadorUsuarios.getPublicadorManejadorUsuarioPort();
	
    public ServletSeleccionarPostulacionaOferta() {
    }
    
    public static EstadoSesion getEstado(HttpServletRequest request){	//obtiene el tipo de la sesion
   		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
   	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(getEstado(request).equals(EstadoSesion.SI_LOGEADO) && request.getSession().getAttribute("usuario") instanceof DataEmpresa) {
			
			request.getSession().setAttribute("esEmpresa",true);
			DataEmpresa demp = (DataEmpresa) request.getSession().getAttribute("usuario");
			ArrayList<Object> ofertasVencWrapper = (ArrayList<Object>) puertoManejadorOfertas.getOfertasConfirmadasYVencidas(demp.getNickName()).getLista();
			Set<DataOferta> dtofers = new HashSet<>();
			for(Object obj :ofertasVencWrapper) {
				DataOferta dofer = (DataOferta) obj;
				dtofers.add(dofer);
			}
			request.getSession().setAttribute("ofertasVencidas",dtofers);
			String ofertaSeleccionada = request.getParameter("SeleccionarPostulacion"); // nombre de la oferta seleccionada
			
			if(ofertaSeleccionada != null) {
				
				//esta seleccionada una oferta y se debe poner lo de elegir postulantes
				DataOferta dofer = puertoManejadorOfertas.getDataOferta(ofertaSeleccionada);
				request.getSession().setAttribute("ofertaSeleccionada",dofer);
				ArrayList<Object> postuWrapper = (ArrayList<Object>) puertoManejadorOfertas.obtenerPostulacionesSobreLaOferta(ofertaSeleccionada).getLista();
				Set<String> postulaciones = new HashSet<>();
				for(Object obj: postuWrapper) {
					String postu = (String) obj;
					postulaciones.add(postu);
				}
				request.getSession().setAttribute("postulacionesDeOfer", postulaciones);
				request.getRequestDispatcher("/WEB-INF/usuarios/detalleOfertaConPostulaciones.jsp").forward(request, response);
				
			}else {
				request.getRequestDispatcher("/WEB-INF/usuarios/seleccionarOfertasVencidasConfirmadas.jsp").forward(request, response);
			}
		
		}else {
			request.getSession().setAttribute("esEmpresa",false);
		}
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
