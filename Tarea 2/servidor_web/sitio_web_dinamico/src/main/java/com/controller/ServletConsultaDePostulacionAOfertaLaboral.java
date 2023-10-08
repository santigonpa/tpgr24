package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logica_DataTypes.DataOferta;
import logica_DataTypes.DataPostulacion;
import logica_DataTypes.DataPostulante;
import logica_Entidades.Postulacion;
import logica_Entidades.Postulante;
import logica_Entidades.Usuario;
import logica_Manejadores.IManejadorOferta;
import logica_Manejadores.IManejadorUsuario;
import utils.Fabrica;

import java.util.HashSet;
import java.util.Set;

import java.io.IOException;


/**
 * Servlet implementation class ServletConsultaDePostulacionAOfertaLaboral
 */
@WebServlet (description = "Servlet de Consulta de Postulacion A Oferta Laboral", urlPatterns = { "/ConsultaDePostulacionAOferta" })
@MultipartConfig
public class ServletConsultaDePostulacionAOfertaLaboral extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Fabrica fab = Fabrica.getInstance();
    private static IManejadorOferta IMO = fab.getInManejadorOferta();
    private static IManejadorUsuario IMU = fab.getInManejadorUsuario();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConsultaDePostulacionAOfertaLaboral() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void cargarDatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String nombreOfer = request.getParameter("nombre");
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");    	
		String user = request.getParameter("user");
		
    	boolean banderaPostulante = request.getSession().getAttribute("usuario") instanceof Postulante;
    	
    	if(banderaPostulante || (!user.equals("noUsuario"))) {
    		if(banderaPostulante) {
    		Postulante post = (Postulante) IMU.obtenerPostulante(usuario.getNickName());
    		Postulacion dtPost = (Postulacion) post.encontrarPostulacionPorNombreOferta(nombreOfer);
    		request.setAttribute("dtPost", dtPost);
        	request.getRequestDispatcher("/WEB-INF/ofertasLaborales/informacionPostulacion.jsp").forward(request, response);
        		
    		} 
    		else {
    			Postulante post = (Postulante) IMU.obtenerPostulante(user);
        		Postulacion dtPost = (Postulacion) post.encontrarPostulacionPorNombreOferta(nombreOfer);
    			request.setAttribute("dtPost", dtPost);
        		request.getRequestDispatcher("/WEB-INF/ofertasLaborales/informacionPostulacion.jsp").forward(request, response);
        		}
    		}else{
    		Set<String> postS= IMO.obtenerOferta(nombreOfer).getPostulantesString();
    		Set<DataPostulante> post = new HashSet<>();
    		for(DataPostulante dtPos : post) {
    			//dtPos.add(IMU.getDataPostulante(usuario.getNickName()));
    		}
    		request.setAttribute("dtPos", post);
    		request.getRequestDispatcher("/WEB-INF/ofertasLaborales/postulantesAOferta.jsp").forward(request, response);
    	}
	    
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		cargarDatos(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
