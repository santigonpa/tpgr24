package com.controller;

import jakarta.servlet.ServletException;
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
import com.webservices.controladores.publicar.PublicadorManejadorOfertas;
import com.webservices.controladores.publicar.PublicadorManejadorOfertasService;
import com.webservices.controladores.publicar.PublicadorManejadorUsuario;
import com.webservices.controladores.publicar.PublicadorManejadorUsuarioService;
import com.webservices.controladores.publicar.WrapperArrayList;

@WebServlet (description = "Servlet seleccionar Postulacion a Oferta Laboral", urlPatterns = { "/SeleccionarPostulacion" })
public class ServletSeleccionarPostulacionaOferta extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PublicadorManejadorOfertasService servicePublicadorManejadorOfertas = new PublicadorManejadorOfertasService();
	private PublicadorManejadorOfertas puertoManejadorOfertas = servicePublicadorManejadorOfertas.getPublicadorManejadorOfertasPort();
	private PublicadorManejadorUsuarioService servicePublicadorManejadorUsuarios = new PublicadorManejadorUsuarioService();
	private PublicadorManejadorUsuario puertoManejadorUsuarios = servicePublicadorManejadorUsuarios.getPublicadorManejadorUsuarioPort();
	
    public ServletSeleccionarPostulacionaOferta() {
    }
    
    public static EstadoSesion getEstado(HttpServletRequest request){	//obtiene el tipo de la sesion
   		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
   	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		if(getEstado(request).equals(EstadoSesion.SI_LOGEADO) && request.getSession().getAttribute("usuario") instanceof DataEmpresa ) {
			
			
			DataEmpresa demp = (DataEmpresa) request.getSession().getAttribute("usuario");
			ArrayList<Object> ofertasVencWrapper = (ArrayList<Object>) puertoManejadorOfertas.getOfertasConfirmadasYVencidas(demp.getNickName()).getLista();
			Set<DataOferta> dtofers = new HashSet<>();
			for(Object obj :ofertasVencWrapper) {
				String doferString = (String) obj;
				System.out.println(doferString);
				DataOferta dofer = puertoManejadorOfertas.getDataOferta(doferString);
				dtofers.add(dofer);
			}
			request.getSession().setAttribute("ofertasVencidas",dtofers);
			String ofertaSeleccionada = request.getParameter("SeleccionarPostulacion"); // nombre de la oferta seleccionada
			
			if(ofertaSeleccionada != null) {
				
				//esta seleccionada una oferta y se debe poner lo de elegir postulantes
				DataOferta dofer = puertoManejadorOfertas.getDataOferta(ofertaSeleccionada);
				
				ArrayList<Object> postuWrapper = (ArrayList<Object>) puertoManejadorOfertas.getNickPostulantes(ofertaSeleccionada).getLista();
				Set<String> postulaciones = new HashSet<>();
				for(Object obj: postuWrapper) {
					String postu = (String) obj;
					postulaciones.add(postu);
				}
				List<Object> palabrasClaveObject = (List<Object>) puertoManejadorOfertas.getKeysPorNombreOfer(dofer.getNombre()).getLista();
				Set<String> palabrasClave = new HashSet<>();
				
				for(Object obj: palabrasClaveObject) {
					String palabra = (String) obj;
					palabrasClave.add(palabra);
				}
				request.getSession().setAttribute("keys", palabrasClave);
				request.getSession().setAttribute("ofertaSeleccionada",dofer);
				request.getSession().setAttribute("postulantesDeOfer", postulaciones);
				request.getRequestDispatcher("/WEB-INF/ofertasLaborales/detalleOfertaConPostulaciones.jsp").forward(request, response);
				
			} else {
				request.getRequestDispatcher("/WEB-INF/ofertasLaborales/seleccionarOfertasVencidasConfirmadas.jsp").forward(request, response);
			}
		
		}else {request.getRequestDispatcher("/WEB-INF/ofertasLaborales/seleccionarOfertasVencidasConfirmadas.jsp").forward(request, response);}
		
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataOferta dataOfer = (DataOferta) request.getSession().getAttribute("ofertaSeleccionada");
	    String postulantesOrdenados = request.getParameter("postulantesOrdenados");
	    // divide la cadena de texto para obtener una lista de nombres
	    String[] nombres = postulantesOrdenados.split(",");
	    ArrayList<String> nombresEnOrden = new ArrayList<String>();

	    WrapperArrayList wrapper = new WrapperArrayList();
	    
	    for (String nombre : nombres) {
	    	System.out.println(nombre);
	        nombresEnOrden.add(nombre); //lo dejo para probar
	        wrapper.getLista().add(nombre);
	    }
	    
	    puertoManejadorOfertas.addOrdenPostulantes(wrapper , dataOfer.getNombre());
	    
	    request.getRequestDispatcher("/WEB-INF/home/iniciarLogged.jsp").forward(request, response);
	}

}
