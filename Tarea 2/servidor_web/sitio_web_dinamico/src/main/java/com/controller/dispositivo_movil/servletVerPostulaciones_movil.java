package com.controller.dispositivo_movil;

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
import com.webservices.controladores.publicar.DataOferta;
import com.webservices.controladores.publicar.DataUsuario;
import com.webservices.controladores.publicar.PublicadorManejadorOfertas;
import com.webservices.controladores.publicar.PublicadorManejadorOfertasService;
import com.webservices.controladores.publicar.PublicadorManejadorUsuario;
import com.webservices.controladores.publicar.PublicadorManejadorUsuarioService;
import com.webservices.controladores.publicar.WrapperArrayList;

/**
 * Servlet implementation class servletVerPostulaciones_movil
 */
@WebServlet (description = "Servlet de ver postulacines", urlPatterns = { "/verPostulaciones_movil" })
public class servletVerPostulaciones_movil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PublicadorManejadorUsuarioService servicePublicadorUsuario = new PublicadorManejadorUsuarioService();
	private PublicadorManejadorUsuario puertoManejadorUsuario = servicePublicadorUsuario.getPublicadorManejadorUsuarioPort();
	private PublicadorManejadorOfertasService servicePublicadorOfertas = new PublicadorManejadorOfertasService();
	private PublicadorManejadorOfertas puertoManejadorOfertas = servicePublicadorOfertas.getPublicadorManejadorOfertasPort();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletVerPostulaciones_movil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
 

       protected void processRequest(HttpServletRequest request, HttpServletResponse response)
   			throws ServletException, IOException{
       	
       }
       
       public static EstadoSesion getEstado(HttpServletRequest request)
   	{	//obtiene el tipo de la sesion
   		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
   	}
    
       protected void cargarDatos(HttpServletRequest request, HttpServletResponse response)
   			throws ServletException, IOException {
       	   
			DataUsuario usuario = (DataUsuario) request.getSession().getAttribute("usuario");   
			String nickUser = usuario.getNickName();
			    			   
			WrapperArrayList wrapperArr = puertoManejadorUsuario.obtenerDataOfertasDePostulaciones(nickUser);
			List<Object> oferObj = wrapperArr.getLista();
			ArrayList<DataOferta> ofertasDePostulacion = new ArrayList<>();
			Set<String> nombresOfer = new HashSet<>();
						
			for (Object objeto : oferObj) {
				if (objeto instanceof String) {
					String dataOfer = (String) objeto;
					nombresOfer.add(dataOfer);
				}
			}
			for(String nombreOferta : nombresOfer ) {
				DataOferta ofertaData = puertoManejadorOfertas.getDataOferta(nombreOferta);
				ofertasDePostulacion.add(ofertaData);
			}
			
			request.setAttribute("coleccionPostulaciones", ofertasDePostulacion);
			request.getRequestDispatcher("/WEB-INF/mobil/postulaciones/misPostulaciones.jsp").forward(request,response);

       }   
       
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
