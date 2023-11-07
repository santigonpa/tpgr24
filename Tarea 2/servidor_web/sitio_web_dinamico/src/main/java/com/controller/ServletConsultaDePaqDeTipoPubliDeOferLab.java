package com.controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import com.model.EstadoSesion;
import com.webservices.controladores.publicar.DataEmpresa;
import com.webservices.controladores.publicar.DataPaquete;
import com.webservices.controladores.publicar.DataUsuario;
import com.webservices.controladores.publicar.PublicadorManejadorPyT;
import com.webservices.controladores.publicar.PublicadorManejadorPyTService;

/**
 * Servlet implementation class ServletConsultaDePaqDeTipoPubliDeOferLab
 */

@WebServlet (description = "Servlet de consulta de paquetes", urlPatterns = { "/ConsultaDePaquetes" })
@MultipartConfig

public class ServletConsultaDePaqDeTipoPubliDeOferLab extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PublicadorManejadorPyTService servicePublicadorManejadorPyT = new PublicadorManejadorPyTService();
	private PublicadorManejadorPyT puertoManejadorPyT = servicePublicadorManejadorPyT.getPublicadorManejadorPyTPort();
	
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
		DataUsuario user = (DataUsuario) request.getSession().getAttribute("usuario");
		ArrayList<Object> coleccionPaquetesWrapper = (ArrayList<Object>) puertoManejadorPyT.getDataPaqueteArreglo().getLista();
		ArrayList<DataPaquete> coleccionPaquetes = new ArrayList<>();
		
		for (Object objeto : coleccionPaquetesWrapper) {
		    if (objeto instanceof DataPaquete) {
		    	DataPaquete dtpaq = (DataPaquete) objeto;
		    	coleccionPaquetes.add(dtpaq);
		    }
		}
		
		request.setAttribute("coleccionDataPaquetes", coleccionPaquetes);
		
    	//es visitante accede igual
    	if(getEstado(request) == EstadoSesion.NO_LOGEADO) {
    		request.getRequestDispatcher("/WEB-INF/paquetes/consultarPaquetes.jsp").forward(request, response);
    	} //es una empresa todo ok
    	else if (user instanceof DataEmpresa) {
    		request.setAttribute("empresa", user.getNickName());
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
