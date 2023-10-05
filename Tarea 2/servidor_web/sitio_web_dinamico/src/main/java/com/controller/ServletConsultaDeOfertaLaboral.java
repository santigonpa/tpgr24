package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logica_DataTypes.DataOferta;
import logica_DataTypes.DataUsuario;
import logica_Entidades.OfertaLaboral;
import logica_Manejadores.IManejadorOferta;
import utils.Fabrica;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.model.EstadoSesion;

/**
 * Servlet implementation class ServletConsultaDeOfertaLaboral
 */
@WebServlet (description = "Servlet de Consulta de oferta laboral", urlPatterns = { "/ConsultaDeOfertaLaboral" })
@MultipartConfig
public class ServletConsultaDeOfertaLaboral extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Fabrica fab = Fabrica.getInstance();
    private IManejadorOferta IMO = fab.getInManejadorOferta();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConsultaDeOfertaLaboral() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static EstadoSesion getEstado(HttpServletRequest request)
  	{	//obtiene el tipo de la sesion
  		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
  		
  	}

    protected void cargarDatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	    	Set<DataOferta> coleccionOfer = IMO.getOfertas();
			
			request.setAttribute("coleccionDataOfertas", coleccionOfer);
			
			if(getEstado(request) == EstadoSesion.SI_LOGEADO) {				
				request.getRequestDispatcher("/WEB-INF/ofertasLaborales/consultaDeOfertasLaboralesLogged.jsp").forward(request,response);
			
			
			}else {
				//hace otra cosa dependiendo si el usuario no esta logeado
				
				
				request.getRequestDispatcher("/WEB-INF/ofertasLaborales/consultaDeOfertasLaborales.jsp").forward(request,response);
			}
			

    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cargarDatos(request, response);
		
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
