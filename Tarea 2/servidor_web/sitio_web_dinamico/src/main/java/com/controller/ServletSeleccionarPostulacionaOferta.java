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
			DataEmpresa demp = (DataEmpresa) request.getSession().getAttribute("usuario");
			ArrayList<Object> ofertasVencWrapper = (ArrayList<Object>) puertoManejadorOfertas.getOfertasConfirmadasYVencidas(demp.getNickName()).getLista();
			Set<DataOferta> dtofers = new HashSet<>();
			for(Object obj :ofertasVencWrapper) {
				DataOferta dofer = (DataOferta) obj;
				dtofers.add(dofer);
			}
			if(dtofers.siEmpty()) {
				request.getRequestDispatcher("/WEB-INF/usuarios/no tiene ofertas confirmadas vencidas.jsp").forward(request, response);
			}else {
				request.getSession().setAttribute("ofertasVencidas",dtofers);
				request.getRequestDispatcher("/WEB-INF/usuarios/el jsp de seleccionar la oferta confirmada pero vencida.jsp").forward(request, response);
			}
		}else {
			request.getRequestDispatcher("/WEB-INF/usuarios/el jsp de tiene que ser una empresa.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreOfer = request.getParameter("OfertaVencAConsultar");
		DataOferta dofer = puertoManejadorOfertas.getDataOferta(nombreOfer);
		request.getSession().setAttribute("ofertaVencAConsultar", dofer);
		ArrayList<Object> postuWrapper = (ArrayList<Object>) puertoManejadorOfertas.obtenerPostulacionesSobreLaOferta(nombreOfer).getLista();
		Set<String> postulaciones = new HashSet<>();
		for(Object obj: postuWrapper) {
			String postu = (String) obj;
			postulaciones.add(postu);
		}
		request.getSession().setAttribute("postulacionesDeOfer", postulaciones);
		request.getRequestDispatcher("/WEB-INF/usuarios/detalles de oferta con postulaciones.jsp").forward(request, response);
	}

}
