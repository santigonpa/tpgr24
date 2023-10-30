package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import com.model.EstadoSesion;
import com.webservices.controladores.publicar.PublicadorManejadorOfertas;
import com.webservices.controladores.publicar.PublicadorManejadorOfertasService;
import com.webservices.controladores.publicar.Usuario;
import com.webservices.controladores.publicar.YaExistePostulacionAOfertaException_Exception;
import com.webservices.controladores.publicar.DataOferta;
import com.webservices.controladores.publicar.Postulante;
import com.webservices.controladores.publicar.PublicadorControladorOfertas;
import com.webservices.controladores.publicar.PublicadorControladorOfertasService;

@WebServlet (description = "Servlet para postularse a una oferta laboral", urlPatterns = { "/PostulacionDesdeVerOferta" })
public class PostulareseDesdeVerOferta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PublicadorManejadorOfertasService serviceManejadorOferta = new PublicadorManejadorOfertasService();
	private PublicadorManejadorOfertas puertoManejadorOferta  = serviceManejadorOferta.getPublicadorManejadorOfertasPort();
	private PublicadorControladorOfertasService servicePublicadorOfertas = new PublicadorControladorOfertasService();
	private PublicadorControladorOfertas puertoControladorOfertas = servicePublicadorOfertas.getPublicadorControladorOfertasPort();

    public PostulareseDesdeVerOferta() {
        super();
 
    }
    public static EstadoSesion getEstado(HttpServletRequest request)
	{	//obtiene el tipo de la sesion
		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oferta = request.getParameter("ofer");
		ArrayList<Object> ofertasWrapper = (ArrayList<Object>) puertoManejadorOferta.getOfertas().getLista();
		

		ArrayList<DataOferta> listaDataOferta = new ArrayList<>();

		for (Object objeto : ofertasWrapper) {
		    if (objeto instanceof DataOferta) {
		        DataOferta dataOferta = (DataOferta) objeto;
		        listaDataOferta.add(dataOferta);
		    }
		}
		DataOferta ofer = null;
		for (DataOferta ofertaIterando : listaDataOferta) {
	        if (ofertaIterando.getNombre().equals(oferta)) {
	            ofer = ofertaIterando; 
	        }
	    }
		
		request.getSession().setAttribute("dataOfertaPos", ofer);
		if(getEstado(request) == EstadoSesion.SI_LOGEADO) {
			request.getRequestDispatcher("/WEB-INF/ofertasLaborales/altaPostulacionAOfer.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String motiv = request.getParameter("motiv");
		System.out.println(motiv);
		String curriculum = request.getParameter("curriculum");
		System.out.println(curriculum);
		DataOferta dofer = (DataOferta) request.getSession().getAttribute("dataOfertaPos");
		Usuario usr = (Usuario) request.getSession().getAttribute("usuario");
		LocalDate fechaActual = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
        String fechaFormateada = fechaActual.format(formatter);
		try {
			if(usr instanceof Postulante) {
				puertoControladorOfertas.agregarPostulacion(usr.getNickName(),dofer.getNombre(), curriculum, motiv, fechaFormateada);
				request.getRequestDispatcher("home").forward(request, response);
			}
		}catch (YaExistePostulacionAOfertaException_Exception e) {
			request.getRequestDispatcher("/WEB-INF/ofertasLaborales/yaExistePost.jsp").forward(request, response);
		}
		
	}

}
