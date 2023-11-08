package com.controller.dispositivo_movil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.webservices.controladores.publicar.DataPostulacion;
import com.webservices.controladores.publicar.DataPostulante;
import com.webservices.controladores.publicar.DataUsuario;
import com.webservices.controladores.publicar.PublicadorManejadorOfertas;
import com.webservices.controladores.publicar.PublicadorManejadorOfertasService;
import com.webservices.controladores.publicar.PublicadorManejadorUsuario;
import com.webservices.controladores.publicar.PublicadorManejadorUsuarioService;

/**
 * Servlet implementation class ServletVerPostulacion_movil
 */
@WebServlet (description = "Servlet de ver postulacines", urlPatterns = { "/servletVerPostulacion_movil" })
public class ServletVerPostulacion_movil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PublicadorManejadorOfertasService servicePublicadorManejadorOfertas = new PublicadorManejadorOfertasService();
	private PublicadorManejadorOfertas puertoManejadorOfertas = servicePublicadorManejadorOfertas.getPublicadorManejadorOfertasPort();
	private PublicadorManejadorUsuarioService servicePublicadorUsuario = new PublicadorManejadorUsuarioService();
	private PublicadorManejadorUsuario puertoManejadorUsuario = servicePublicadorUsuario.getPublicadorManejadorUsuarioPort();
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletVerPostulacion_movil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreOfer = request.getParameter("id"); //es el nombre de la oferta
		
		DataUsuario usuario = (DataUsuario) request.getSession().getAttribute("usuario");    	
		    	
    		DataPostulante post = (DataPostulante) puertoManejadorUsuario.obtenerDataUsuario(usuario.getNickName());
    		
    		List<Object> listaObjetos = puertoManejadorUsuario.obtenerDataPostulaciones(post.getNickName()).getLista();
    		ArrayList<DataPostulacion> postulacionesDeUsuario = new ArrayList<>();

    		for (Object objeto : listaObjetos) {
    		    if (objeto instanceof DataPostulacion) {
    		        postulacionesDeUsuario.add((DataPostulacion) objeto);
    		    }
    		}

        	
    		DataPostulacion dtPost = null;
    		for(DataPostulacion postula : postulacionesDeUsuario) {
    			if(postula.getNombreOferta().equals(nombreOfer)) {dtPost = postula;}
    		}

    		if (dtPost != null) {
    			System.out.println(dtPost.getNickPostulante());
    			request.setAttribute("dtPost", dtPost);
        		request.getRequestDispatcher("/WEB-INF/mobil/postulaciones/infoPostulacion_movil.jsp").forward(request, response); 
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
