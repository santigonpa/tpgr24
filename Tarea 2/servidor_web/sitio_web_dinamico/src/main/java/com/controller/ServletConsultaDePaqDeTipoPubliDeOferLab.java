package com.controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logica_DataTypes.DataPaquete;
import logica_DataTypes.DataTipoPublicacion;
import logica_Entidades.Empresa;
import logica_Entidades.Usuario;
import logica_Manejadores.IManejadorPyT;
import utils.Fabrica;

import java.io.IOException;
import java.util.Set;

import com.model.EstadoSesion;

/**
 * Servlet implementation class ServletConsultaDePaqDeTipoPubliDeOferLab
 */

@WebServlet (description = "Servlet de consulta de paquetes", urlPatterns = { "/ConsultaDePaquetes" })
@MultipartConfig

public class ServletConsultaDePaqDeTipoPubliDeOferLab extends HttpServlet {
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
    public ServletConsultaDePaqDeTipoPubliDeOferLab() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario user = (Usuario) request.getSession().getAttribute("usuario");
		
		Set<DataPaquete> coleccionPaquetes = IPYT.getDataPaquete() ;
		
		request.setAttribute("coleccionDataPaquetes", coleccionPaquetes);
		
    	//es visitante accede igual
    	if(getEstado(request) == EstadoSesion.NO_LOGEADO) {
    		request.getRequestDispatcher("/WEB-INF/paquetes/consultarPaquetes.jsp").forward(request, response);
    	} //es una empresa todo ok
    	else if (user instanceof Empresa) {
    		request.getRequestDispatcher("/WEB-INF/paquetes/consultaPaquetesLogged.jsp").forward(request, response);
    	}//	es un postulante
    	else {
    		request.getRequestDispatcher("/WEB-INF/paquetes/consultaPaquetesErroneo.jsp").forward(request, response);
    	}
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
