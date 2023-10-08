package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logica_datatypes.DataTipoPublicacion;
import logica_entidades.Empresa;
import logica_entidades.Usuario;
import logica_manejadores.IManejadorPyT;
import utils.Fabrica;

import java.io.IOException;
import java.util.Set;

import com.model.EstadoSesion;

/**
 * Servlet implementation class ServletConsultaTipoPubliOferLab
 */

@WebServlet (description = "Servlet de alta de tipo de publicacion", urlPatterns = { "/ConsultaDeTipoDePublicacionDeOfertaLaboral" })
@MultipartConfig

public class ServletConsultaTipoPubliOferLab extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Fabrica fab = Fabrica.getInstance();
	private IManejadorPyT IPYT = fab.getInManejadorPyT();   
	
	public static EstadoSesion getEstado(HttpServletRequest request)
	{	//obtiene el tipo de la sesion
		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
	}	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConsultaTipoPubliOferLab() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Set<DataTipoPublicacion> coleccionPTP = IPYT.getDataTipoPublicacion() ;
		request.setAttribute("coleccionDataPaquetes", coleccionPTP);
		
    	//es visitante accede igual
    	if(getEstado(request) == EstadoSesion.NO_LOGEADO) {
    		request.getRequestDispatcher("/WEB-INF/ofertasLaborales/consultaTipoPubliOferLab.jsp").forward(request, response);
    	} else {
    		request.getRequestDispatcher("/WEB-INF/ofertasLaborales/consultaTipoPubliOferLabLogged.jsp").forward(request, response);
    	}
    }	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
