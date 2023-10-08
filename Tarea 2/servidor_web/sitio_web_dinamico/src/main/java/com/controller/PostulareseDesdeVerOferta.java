package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logica_controladores.IControladorOferta;
import logica_datatypes.DataOferta;
import logica_entidades.OfertaLaboral;
import logica_entidades.Postulante;
import logica_entidades.Usuario;
import logica_manejadores.IManejadorOferta;
import utils.Fabrica;

import java.io.IOException;
import java.time.LocalDate;

import com.model.EstadoSesion;

import excepciones.campoInvalidoException;
import excepciones.yaExistePostulacionAOfertaException;

@WebServlet (description = "Servlet para postularse a una oferta laboral", urlPatterns = { "/PostulacionDesdeVerOferta" })
public class PostulareseDesdeVerOferta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Fabrica fab = Fabrica.getInstance();
    private IManejadorOferta IMO = fab.getInManejadorOferta();
    private IControladorOferta ICO = fab.getInOfer();

    public PostulareseDesdeVerOferta() {
        super();
 
    }
    public static EstadoSesion getEstado(HttpServletRequest request)
	{	//obtiene el tipo de la sesion
		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String oferta = request.getParameter("ofer");
		DataOferta of= IMO.getDataOferta(oferta);
		request.getSession().setAttribute("dataOfertaPos", of);
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
		try {
			if(usr instanceof Postulante) {
				ICO.agregarPostulacion(usr.getNickName(),dofer.getNombre(), curriculum, motiv, fechaActual);
				request.getRequestDispatcher("home").forward(request, response);
			}
		}catch (yaExistePostulacionAOfertaException e) {
			request.getRequestDispatcher("/WEB-INF/ofertasLaborales/yaExistePost.jsp").forward(request, response);
		}
		
	}

}
