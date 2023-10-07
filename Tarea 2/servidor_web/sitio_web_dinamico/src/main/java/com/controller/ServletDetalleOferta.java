package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logica_Controladores.IControladorUsuario;
import logica_DataTypes.DataOferta;
import logica_Entidades.Postulante;
import logica_Entidades.Usuario;
import logica_Manejadores.IManejadorOferta;
import logica_Manejadores.IManejadorUsuario;
import utils.Fabrica;

import java.io.IOException;
import java.util.Set;

import com.model.EstadoSesion;

@WebServlet (description = "Servlet de Consulta de oferta laboral detllada", urlPatterns = { "/DetalleOferta" })
@MultipartConfig
/**
 * Servlet implementation class ServletDetalleOferta
 */
public class ServletDetalleOferta extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Fabrica fab = Fabrica.getInstance();
    private static IManejadorOferta IMO = fab.getInManejadorOferta();
    private static IManejadorUsuario IMU = fab.getInManejadorUsuario();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetalleOferta() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static EstadoSesion getEstado(HttpServletRequest request)
  	{	//obtiene el tipo de la sesion
  		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
  		
  	}
    
    protected void cargarPlat(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    		

	    	boolean banderaSesion;
	    	String nombreOfer = request.getParameter("id");
			DataOferta ofer = IMO.getDataOferta(nombreOfer);
			request.setAttribute("ofer", ofer);
	    	boolean banderaPostulante = request.getSession().getAttribute("usuario") instanceof Postulante;

			
			if(getEstado(request) != null) {
				banderaSesion = getEstado(request).equals(EstadoSesion.SI_LOGEADO);
		    	}else {
				banderaSesion = false;
		    	}	    	
			
	    	if(banderaSesion && banderaPostulante) {
	    		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");    	
	    		String nickName = usuario.getNickName();
	    		boolean estaPost = IMO.obtenerOferta(nombreOfer).existeLaPostulacion(nickName);
	    		String post = request.getParameter("id");
	    		if(estaPost){
	    			request.getRequestDispatcher("/WEB-INF/ofertasLaborales/detalleOfertaPost.jsp").forward(request, response);
	    		}else {
	    			request.getRequestDispatcher("/WEB-INF/ofertasLaborales/detalleOferta.jsp").forward(request, response);
	    		}
			}
			if(banderaSesion && !banderaPostulante){
				Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");    	
	    		String nickName = usuario.getNickName();
	    		boolean esSuOferta;
	    		if(IMU.obtenerEmpresa(nickName).getOferta(nombreOfer) == null) {
	    			esSuOferta = false;
	    		}else {
	    			esSuOferta = true;
	    		}
	    		if(esSuOferta){
					request.getRequestDispatcher("/WEB-INF/ofertasLaborales/detalleOfertaEmp.jsp").forward(request, response);
	    		}else {
	    			request.getRequestDispatcher("/WEB-INF/ofertasLaborales/detalleOferta.jsp").forward(request, response);
	    		}

			}	
			
			if(!banderaSesion) {
				request.getRequestDispatcher("/WEB-INF/ofertasLaborales/detalleOferta.jsp").forward(request, response);
			}
    
    }		
			
    
    	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cargarPlat(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
