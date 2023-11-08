package com.controller.dispositivo_movil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.model.EstadoSesion;
import com.webservices.controladores.publicar.DataEmpresa;
import com.webservices.controladores.publicar.DataKeyWord;
import com.webservices.controladores.publicar.DataOferta;
import com.webservices.controladores.publicar.DataPostulante;
import com.webservices.controladores.publicar.DataUsuario;
import com.webservices.controladores.publicar.PublicadorControladorOfertas;
import com.webservices.controladores.publicar.PublicadorControladorOfertasService;
import com.webservices.controladores.publicar.PublicadorManejadorOfertas;
import com.webservices.controladores.publicar.PublicadorManejadorOfertasService;
import com.webservices.controladores.publicar.PublicadorManejadorUsuario;
import com.webservices.controladores.publicar.PublicadorManejadorUsuarioService;
import com.webservices.controladores.publicar.WrapperArrayList;
import com.webservices.controladores.publicar.WrapperHashMap;

/**
 * Servlet implementation class servelPostularmeAOferta
 */
public class servelPostularmeAOferta extends HttpServlet {
	private PublicadorManejadorOfertasService servicePublicadorManejadorOfertas = new PublicadorManejadorOfertasService();
	private PublicadorManejadorOfertas puertoManejadorOfertas = servicePublicadorManejadorOfertas.getPublicadorManejadorOfertasPort();
	private PublicadorManejadorUsuarioService servicePublicadorUsuario = new PublicadorManejadorUsuarioService();
	private PublicadorManejadorUsuario puertoManejadorUsuario = servicePublicadorUsuario.getPublicadorManejadorUsuarioPort();
   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servelPostularmeAOferta() {
        super();
        // TODO Auto-generated constructor stub
    }

    public static EstadoSesion getEstado(HttpServletRequest request)
	{	//obtiene el tipo de la sesion
		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//le mando al jsp las empresas -------------------------------
    	WrapperHashMap empresasWrap =  puertoManejadorUsuario.getDataEmpresas();
   	 
		List<com.webservices.controladores.publicar.WrapperHashMap.Mapa.Entry> claves = empresasWrap.getMapa().getEntry();
		
		Set<DataEmpresa> usuariosColeccion = new HashSet<DataEmpresa>();
		for(com.webservices.controladores.publicar.WrapperHashMap.Mapa.Entry clave : claves ) {
			DataEmpresa dataEmp = (DataEmpresa) clave.getValue();
			usuariosColeccion.add(dataEmp);
		}
		request.setAttribute("coleccionDataEmpresas", usuariosColeccion);
    	//le mando al jsp las keywords---------------------------------
		ArrayList<Object> coleccionKeysWrapper = (ArrayList<Object>) puertoManejadorOfertas.getDataKeyWord().getLista();
		ArrayList<DataKeyWord> coleccionKeys = new ArrayList<>();
		
		for (Object objeto2 : coleccionKeysWrapper) {
		    if (objeto2 instanceof DataKeyWord) {
		    	DataKeyWord key = (DataKeyWord) objeto2;
		    	coleccionKeys.add(key);
		    }
		}
		request.setAttribute("keys", coleccionKeys);
		//------------------------------------------------------------

    		boolean banderaSesion;
    		if (getEstado(request) != null) {
    			banderaSesion = getEstado(request).equals(EstadoSesion.SI_LOGEADO);
    		}else {
    			banderaSesion = false;
    		}
    		
			HttpSession sessionIniciada = request.getSession(false);
			DataUsuario usr = (DataUsuario) sessionIniciada.getAttribute("usuario");
				
			String empresaSeleccionada = request.getParameter("empresa");
			String keywordSeleccionada = request.getParameter("keyword");
			
			if(banderaSesion) {
				if(empresaSeleccionada != null) {
					WrapperArrayList wrapperArr = puertoManejadorUsuario.obtenerOfertasConfirmadasDeEmpresa(empresaSeleccionada);
					List<Object> ofertasConfirmadasWrapper = wrapperArr.getLista();
					Set<DataOferta> coleccionOfer = new HashSet<>();
					Set<String> nombresOfer = new HashSet<>();
					
					for (Object objeto : ofertasConfirmadasWrapper) {
					    if (objeto instanceof String) {
					    	String dataOfer = (String) objeto;
					    	nombresOfer.add(dataOfer);
					    }
					}
					for(String nombreOferta : nombresOfer ) {
						DataOferta ofertaData = puertoManejadorOfertas.getDataOferta(nombreOferta);
						coleccionOfer.add(ofertaData);
					}

					request.setAttribute("coleccionOfertas",coleccionOfer);
					request.getRequestDispatcher("/WEB-INF/mobil/postulaciones/verOfertasAPostular.jsp").forward(request,response);

					}else if(keywordSeleccionada != null){
						WrapperArrayList wrapperArr2 = puertoManejadorOfertas.obtenerOfertasConfirmadasPorKey(keywordSeleccionada);
						List<Object> ofertasConfirmadasWrapper = wrapperArr2.getLista();
						Set<DataOferta> coleccionOfer = new HashSet<>();
						Set<String> nombresOfer = new HashSet<>();
						for (Object objeto : ofertasConfirmadasWrapper) {	
						    if (objeto instanceof DataOferta) {	
						    	String dataOfer = ((DataOferta) objeto).getNombre();					    	nombresOfer.add(dataOfer);
						    }
						}
						
						for(String nombreOferta : nombresOfer ) {
							DataOferta ofertaData = puertoManejadorOfertas.getDataOferta(nombreOferta);
							coleccionOfer.add(ofertaData);
						}
						request.setAttribute("coleccionOfertas",coleccionOfer);
						request.getRequestDispatcher("/WEB-INF/mobil/postulaciones/verOfertasAPostular.jsp").forward(request,response);

				
					}else {
						request.getRequestDispatcher("/WEB-INF/mobil/postulaciones/verOfertasAPostular.jsp").forward(request,response);
					}
			}	
		
			if(!banderaSesion) { //mandamos a pagina de error, el caso de uso es solo accesible para postulantes
					request.getRequestDispatcher("/WEB-INF/mobil/postulaciones/errorVerOfertasPostulrme.jsp").forward(request,response);
			}	
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
