package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.webservices.controladores.publicar.DataEmpresa;
import com.webservices.controladores.publicar.DataKeyWord;
import com.webservices.controladores.publicar.DataOferta;
import com.webservices.controladores.publicar.DataUsuario;
import com.webservices.controladores.publicar.PublicadorControladorOfertas;
import com.webservices.controladores.publicar.PublicadorControladorOfertasService;
import com.webservices.controladores.publicar.PublicadorControladorUsuario;
import com.webservices.controladores.publicar.PublicadorControladorUsuarioService;
import com.webservices.controladores.publicar.PublicadorManejadorOfertas;
import com.webservices.controladores.publicar.PublicadorManejadorOfertasService;
import com.webservices.controladores.publicar.PublicadorManejadorPyT;
import com.webservices.controladores.publicar.PublicadorManejadorPyTService;
import com.webservices.controladores.publicar.PublicadorManejadorUsuario;
import com.webservices.controladores.publicar.PublicadorManejadorUsuarioService;
import com.webservices.controladores.publicar.WrapperHashMap;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.model.EstadoSesion;

/**
 * Servlet implementation class buscarServlet
 */
@WebServlet("/servletBuscar")
public class buscarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PublicadorManejadorOfertasService servicePublicadorManejadorOfertas = new PublicadorManejadorOfertasService();
	private PublicadorManejadorOfertas puertoManejadorOfertas = servicePublicadorManejadorOfertas.getPublicadorManejadorOfertasPort();
	private PublicadorManejadorUsuarioService servicePublicadorUsuario = new PublicadorManejadorUsuarioService();
	private PublicadorManejadorUsuario puertoManejadorUsuario = servicePublicadorUsuario.getPublicadorManejadorUsuarioPort();
   
    /**
     * @see HttpServlet#HttpServlet()
     */
	public static EstadoSesion getEstado(HttpServletRequest request)
	{	//obtiene el tipo de la sesion
		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
	}
	
	// Función para verificar la extensión del archivo
	private boolean isValidImageExtension(String fileName) {
	    String[] allowedExtensions = { "jpg", "jpeg", "png", "gif" }; // Extensiones permitidas
	    String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
	    return Arrays.asList(allowedExtensions).contains(fileExtension);
	
	}
	
	private byte[] readImageBytes(InputStream inputStream) throws IOException {
	        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	        byte[] buffer = new byte[1024];
	        int bytesRead;
	        while ((bytesRead = inputStream.read(buffer)) != -1) {
	            outputStream.write(buffer, 0, bytesRead);
	        }
	        return outputStream.toByteArray();
	    }

    public buscarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataUsuario user = (DataUsuario) request.getSession().getAttribute("usuario");

		String busqueda = request.getParameter("busqueda");
		
		ArrayList<Object> coleccionOferWrapper = (ArrayList<Object>) puertoManejadorOfertas.getOfertas().getLista();
		ArrayList<DataOferta> coleccionOfer = new ArrayList<>();
		
		for (Object objeto2 : coleccionOferWrapper) {
		    if (objeto2 instanceof DataOferta) {
		    	DataOferta oferta = (DataOferta) objeto2;
		    	//if(oferta.tieneString(busqueda)) {
			    	coleccionOfer.add(oferta);
		    	//}
		    }
		}
		
		WrapperHashMap coleccionEmpWrapper = puertoManejadorUsuario.getDataEmpresas();
		List<com.webservices.controladores.publicar.WrapperHashMap.Mapa.Entry> claves = coleccionEmpWrapper.getMapa().getEntry();
		
		Set<DataEmpresa> empresasColeccion = new HashSet<DataEmpresa>();
		for(com.webservices.controladores.publicar.WrapperHashMap.Mapa.Entry clave : claves ) {
			DataEmpresa dataUser = (DataEmpresa) clave.getValue();
			//if(dataUser.tieneString(busqueda)) {
			empresasColeccion.add(dataUser);
			//}
		}

		request.setAttribute("coleccionDataEmpresas", empresasColeccion);
		request.setAttribute("coleccionOfertas", coleccionOfer);
		request.setAttribute("busco", busqueda);
		
    	//no hay usuario logueado, lo mandamos a iniciar sesion
    	if(getEstado(request) == EstadoSesion.NO_LOGEADO) {
    		request.getRequestDispatcher("/WEB-INF/busqueda/resultados.jsp").forward(request, response);
    	 //es una empresa todo ok
    	}else {
		request.getRequestDispatcher("/WEB-INF/busqueda/resultadosLogged.jsp").forward(request, response); //obtiene dispatcher construido con la ruta
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
