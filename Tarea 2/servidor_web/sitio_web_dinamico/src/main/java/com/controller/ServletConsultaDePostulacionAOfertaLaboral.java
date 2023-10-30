package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.webservices.controladores.publicar.DataTipoPublicacion;
import com.webservices.controladores.publicar.Postulacion;
import com.webservices.controladores.publicar.Postulante;
import com.webservices.controladores.publicar.Usuario;
import com.webservices.controladores.publicar.WrapperArrayList;

import java.util.ArrayList;
import java.util.Set;

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
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");    	
		
    	boolean banderaPostulante = request.getSession().getAttribute("usuario") instanceof Postulante;
    	
    	if(banderaPostulante) {
    		Postulante post = (Postulante) puertoManejadorUsuario.obtenerPostulante(usuario.getNickName());
    		
    		ArrayList<Object> coleccionPostulacionWrapper = (ArrayList<Object>) post.getPostulaciones().getLista();
        	ArrayList<Postulacion> postulacionesDeUsuario = new ArrayList<>();

    		for (Object objeto : coleccionPostulacionWrapper) {
    		    if (objeto instanceof Postulacion) {
    		    	Postulacion postu = (Postulacion) objeto;
    		    	postulacionesDeUsuario.add(postu);
    		    }
    		}
    		
    		Postulacion dtPost = null;
    		for(Postulacion postula : postulacionesDeUsuario) {
    			if(postula.getOfer().getNombre().equals(nombreOfer)) {dtPost = postula;}
    		}
    		//Postulacion dtPost = (Postulacion) post.encontrarPostulacionPorNombreOferta(nombreOfer);
    		if (dtPost != null) {
    			request.setAttribute("dtPost", dtPost);
        		request.getRequestDispatcher("/WEB-INF/ofertasLaborales/informacionPostulacion.jsp").forward(request, response); 
    		}
    		
    	}else if(!banderaPostulante && (user == null)){
    
    		ArrayList<Postulacion> postulantes = (ArrayList<Postulacion>) puertoManejadorOfertas.obtenerOferta(nombreOfer).getPostulacionesSobreLaOferta();
    		request.setAttribute("postulantes", postulantes);
    		request.getRequestDispatcher("/WEB-INF/ofertasLaborales/postulantesAOferta.jsp").forward(request, response);
    	}else if(!banderaPostulante && (user != null)) {
    		Postulante pos = (Postulante) puertoManejadorUsuario.obtenerPostulante(user);
    		ArrayList<Object> coleccionPostulacionWrapper = (ArrayList<Object>) pos.getPostulaciones().getLista();
        	ArrayList<Postulacion> postulacionesDeUsuario = new ArrayList<>();

    		for (Object objeto : coleccionPostulacionWrapper) {
    		    if (objeto instanceof Postulacion) {
    		    	Postulacion postu = (Postulacion) objeto;
    		    	postulacionesDeUsuario.add(postu);
    		    }
    		}
    		
    		Postulacion dtPost = null;
    		for(Postulacion postula : postulacionesDeUsuario) {
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
