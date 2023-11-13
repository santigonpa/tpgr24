package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.model.EstadoSesion;
import com.webservices.controladores.publicar.DataEmpresa;
import com.webservices.controladores.publicar.DataOferta;
import com.webservices.controladores.publicar.DataPostulacion;
import com.webservices.controladores.publicar.DataPostulante;
import com.webservices.controladores.publicar.DataUsuario;
import com.webservices.controladores.publicar.KeyWord;
import com.webservices.controladores.publicar.PublicadorManejadorOfertas;
import com.webservices.controladores.publicar.PublicadorManejadorOfertasService;
import com.webservices.controladores.publicar.PublicadorManejadorUsuario;
import com.webservices.controladores.publicar.PublicadorManejadorUsuarioService;
import com.webservices.controladores.publicar.WrapperArrayList;

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
			
			puertoManejadorOfertas.visitaDeOferta(nombreOfer);
			
			List<Object> keys = puertoManejadorOfertas.getKeysPorNombreOfer(nombreOfer).getLista();
			ArrayList<String> keysEnviar = new ArrayList<>();
			for (Object objetoK : keys) {
    		    if (objetoK instanceof String) {
    		    	keysEnviar.add((String) objetoK);
    		    }
    		}
			request.setAttribute("keys", keysEnviar);
			
	    	boolean banderaPostulante = request.getSession().getAttribute("usuario") instanceof DataPostulante;

			
			if(getEstado(request) != null) {
				banderaSesion = getEstado(request).equals(EstadoSesion.SI_LOGEADO);
		    	}else {
				banderaSesion = false;
		    	}	    	
			
	    	if(banderaSesion && banderaPostulante) {
	    		DataUsuario usuario = (DataUsuario) request.getSession().getAttribute("usuario");    	
	    		String nickName = usuario.getNickName();
	    		
	    		WrapperArrayList listaObjetos = puertoManejadorUsuario.obtenerDataPostulaciones(nickName);
	    		List<Object> postulacionesWrapper = listaObjetos.getLista();
	    		ArrayList<DataPostulacion> postulaciones = new ArrayList<>();
	    		
	    		for (Object objeto : postulacionesWrapper) {
	    		    if (objeto instanceof DataPostulacion) {
	    		        postulaciones.add((DataPostulacion) objeto);
	    		    }
	    		}

	    		String nombreOfertaConsultada = request.getParameter("id");
	    		boolean estaPost = false;
	    		
	    		List<Object> listaObjetosOfertasDePostulante = puertoManejadorUsuario.obtenerDataOfertasDePostulaciones(nickName).getLista();
	    		
	    		
	    		for(Object ofert : listaObjetosOfertasDePostulante) {
	    			if(ofert instanceof String) {
	    				DataOferta ofertaData = puertoManejadorOfertas.getDataOferta( (String) ofert);
	    				if(ofertaData.getNombre().equals(nombreOfertaConsultada)) {estaPost = true;}
	    			}
	    		}
	    		
	    		if(estaPost){
	    			request.getRequestDispatcher("/WEB-INF/ofertasLaborales/detalleOfertaPost.jsp").forward(request, response);
	    		}else {
	    			String queEs = "Postulante";
					request.setAttribute("queEs", queEs);
	    			request.getRequestDispatcher("/WEB-INF/ofertasLaborales/detalleOfertaLogged.jsp").forward(request, response);
	    		}
			}
			if(banderaSesion && !banderaPostulante){
				DataUsuario usuario = (DataUsuario) request.getSession().getAttribute("usuario");    	
	    		String nickName = usuario.getNickName();
	    		boolean esSuOferta = false;
	    		
	    		WrapperArrayList wrapperArr = puertoManejadorUsuario.obtenerOfertasConfirmadasDeEmpresa(nickName);
				List<Object> ofertasConfirmadasWrapper = wrapperArr.getLista();
				Set<String> nombresOfer = new HashSet<>();
				
				for (Object objeto : ofertasConfirmadasWrapper) {
				    if (objeto instanceof String) {
				    	String dataOfer = (String) objeto;
				    	nombresOfer.add(dataOfer);
				    }
				}
				
	    		for(String ofertaActual : nombresOfer) {
	    			if(ofertaActual.equals(nombreOfer)) {esSuOferta = true;}
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
