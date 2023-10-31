package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.webservices.controladores.publicar.DataPostulacion;
import com.webservices.controladores.publicar.DataPostulante;
import com.webservices.controladores.publicar.DataUsuario;
import java.util.ArrayList;
import com.webservices.controladores.publicar.PublicadorManejadorOfertas;
import com.webservices.controladores.publicar.PublicadorManejadorOfertasService;
import com.webservices.controladores.publicar.PublicadorManejadorUsuario;
import com.webservices.controladores.publicar.PublicadorManejadorUsuarioService;

import java.io.IOException;


/**
 * Servlet implementation class ServletConsultaDePostulacionAOfertaLaboral
 */
@WebServlet (description = "Servlet de Consulta de Postulacion A Oferta Laboral", urlPatterns = { "/ConsultaDePostulacionAOferta" })
@MultipartConfig 
public class ServletConsultaDePostulacionAOfertaLaboral extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private PublicadorManejadorOfertasService servicePublicadorManejadorOfertas = new PublicadorManejadorOfertasService();
	private PublicadorManejadorOfertas puertoManejadorOfertas = servicePublicadorManejadorOfertas.getPublicadorManejadorOfertasPort();
	private PublicadorManejadorUsuarioService servicePublicadorUsuario = new PublicadorManejadorUsuarioService();
	private PublicadorManejadorUsuario puertoManejadorUsuario = servicePublicadorUsuario.getPublicadorManejadorUsuarioPort();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConsultaDePostulacionAOfertaLaboral() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void cargarDatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    	String nombreOfer = request.getParameter("id");
    	String user = request.getParameter("user");

		//DataOferta ofer = IMO.getDataOferta(nombreOfer);
		DataUsuario usuario = (DataUsuario) request.getSession().getAttribute("usuario");    	
		
    	boolean banderaPostulante = request.getSession().getAttribute("usuario") instanceof DataPostulante;
    	
    	if(banderaPostulante) {
    		DataPostulante post = (DataPostulante) puertoManejadorUsuario.obtenerDataUsuario(usuario.getNickName());
    		
    		ArrayList<DataPostulacion> postulacionesDeUsuario = (ArrayList<DataPostulacion>) puertoManejadorUsuario.obtenerDataPostulaciones(post.getNickName()).getLista();
        	
    		DataPostulacion dtPost = null;
    		for(DataPostulacion postula : postulacionesDeUsuario) {
    			if(postula.getOfer().getNombre().equals(nombreOfer)) {dtPost = postula;}
    		}
    		//Postulacion dtPost = (Postulacion) post.encontrarPostulacionPorNombreOferta(nombreOfer);
    		if (dtPost != null) {
    			request.setAttribute("dtPost", dtPost);
        		request.getRequestDispatcher("/WEB-INF/ofertasLaborales/informacionPostulacion.jsp").forward(request, response); 
    		}
    		
    	}else if(!banderaPostulante && (user == null)){
    
    		ArrayList<DataPostulacion> postulantes = (ArrayList<DataPostulacion>) puertoManejadorOfertas.obtenerPostulacionesSobreLaOferta(nombreOfer).getList();
    		request.setAttribute("postulantes", postulantes);
    		request.getRequestDispatcher("/WEB-INF/ofertasLaborales/postulantesAOferta.jsp").forward(request, response);
    	}else if(!banderaPostulante && (user != null)) {
    		DataPostulante pos = (DataPostulante) puertoManejadorUsuario.obtenerDataUsuario(user);
    		ArrayList<DataPostulacion> postulacionesDeUsuario =(ArrayList<DataPostulacion>) puertoManejadorOfertas.obtenerDataOfertasDePostulaciones(pos.getNickName()).getLista();
        	
    		DataPostulacion dtPost = null;
    		for(DataPostulacion postula : postulacionesDeUsuario) {
    			if(postula.getOfer().getNombre().equals(nombreOfer)) {dtPost = postula;}
    		}
    		//Postulacion dtPost = (Postulacion) pos.encontrarPostulacionPorNombreOferta(nombreOfer);
	    	if (dtPost != null) {
	    			request.setAttribute("dtPost", dtPost);
	        		request.getRequestDispatcher("/WEB-INF/ofertasLaborales/informacionPostulacion.jsp").forward(request, response); 
	    	}
    		
    		
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
