package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.webservices.controladores.publicar.DataOferta;
import com.webservices.controladores.publicar.Empresa;
import com.webservices.controladores.publicar.OfertaLaboral;
import com.webservices.controladores.publicar.Postulacion;
import com.webservices.controladores.publicar.Postulante;
import com.webservices.controladores.publicar.Usuario;
import com.webservices.controladores.publicar.WrapperHashMap.Mapa.Entry;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.model.EstadoSesion;
import com.webservices.controladores.publicar.PublicadorManejadorOfertas;
import com.webservices.controladores.publicar.PublicadorManejadorOfertasService;
import com.webservices.controladores.publicar.PublicadorManejadorUsuario;
import com.webservices.controladores.publicar.PublicadorManejadorUsuarioService;

@WebServlet (description = "Servlet de Consulta de oferta laboral detllada", urlPatterns = { "/DetalleOferta" })
@MultipartConfig
/**
 * Servlet implementation class ServletDetalleOferta
 */
public class ServletDetalleOferta extends HttpServlet {
	private static final long serialVersionUID = 1L;

    private PublicadorManejadorOfertasService servicePublicadorManejadorOfertas = new PublicadorManejadorOfertasService();
	private PublicadorManejadorOfertas puertoManejadorOfertas = servicePublicadorManejadorOfertas.getPublicadorManejadorOfertasPort();
	private PublicadorManejadorUsuarioService servicePublicadorUsuario = new PublicadorManejadorUsuarioService();
	private PublicadorManejadorUsuario puertoManejadorUsuario = servicePublicadorUsuario.getPublicadorManejadorUsuarioPort();
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
			DataOferta ofer = puertoManejadorOfertas.getDataOferta(nombreOfer);
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
	    		List<Postulacion> postulaciones = puertoManejadorOfertas.obtenerOferta(nombreOfer).getPostulacionesSobreLaOferta();
	    		boolean estaPost = false;
	    		for(Postulacion postu : postulaciones) {
	    			if(postu.getPost().getNickName().equals(nickName)) {estaPost = true;}
	    		}
	    		String post = request.getParameter("id");
	    		if(estaPost){
	    			request.getRequestDispatcher("/WEB-INF/ofertasLaborales/detalleOfertaPost.jsp").forward(request, response);
	    		}else {
	    			String queEs = "Postulante";
					request.setAttribute("queEs", queEs);
	    			request.getRequestDispatcher("/WEB-INF/ofertasLaborales/detalleOfertaLogged.jsp").forward(request, response);
	    		}
			}
			if(banderaSesion && !banderaPostulante){
				Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");    	
	    		String nickName = usuario.getNickName();
	    		boolean esSuOferta;
	    		Empresa enterprise = puertoManejadorUsuario.obteneraEmpresa(nickName);
	    		OfertaLaboral ofertaDeEnter = null;
				List<Empresa.Ofertas.Entry> ofertasDeEnter =  enterprise.getOfertas().getEntry();
	    		for(Empresa.Ofertas.Entry entry : ofertasDeEnter) {
	    			if(entry.getKey().equals(nombreOfer)) {ofertaDeEnter = entry.getValue();}
	    		}
	    		if(ofertaDeEnter == null) {
	    			esSuOferta = false;
	    		}else {
	    			esSuOferta = true;
	    		}
	    		if(esSuOferta){
					request.getRequestDispatcher("/WEB-INF/ofertasLaborales/detalleOfertaEmp.jsp").forward(request, response);
	    		}else {
	    			String queEs = "Empresa";
					request.setAttribute("queEs", queEs);
	    			request.getRequestDispatcher("/WEB-INF/ofertasLaborales/detalleOfertaLogged.jsp").forward(request, response);
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
