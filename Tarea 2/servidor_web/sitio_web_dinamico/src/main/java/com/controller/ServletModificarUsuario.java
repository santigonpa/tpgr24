package com.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import com.model.EstadoSesion;
import com.webservices.controladores.publicar.DataPostulante;
import com.webservices.controladores.publicar.DataUsuario;
import com.webservices.controladores.publicar.PublicadorControladorUsuario;
import com.webservices.controladores.publicar.PublicadorControladorUsuarioService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import jakarta.servlet.annotation.MultipartConfig;

/**
 * Servlet implementation class ServletAltaDeUsuario
 */

@WebServlet (description = "Servlet de modificar usuario", urlPatterns = { "/ModificarUsuario" })
@MultipartConfig 
/**
 * Servlet implementation class ServletModificarUsuario
 */
public class ServletModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private PublicadorControladorUsuarioService servicePublicadorUsuario = new PublicadorControladorUsuarioService();
	private PublicadorControladorUsuario puertoControladorUsuario = servicePublicadorUsuario.getPublicadorControladorUsuarioPort();
    public static EstadoSesion getEstado(HttpServletRequest request)
	{	//obtiene el tipo de la sesion
		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
	}
	// Función para verificar la extensión del archivo
				
				private boolean isValidImageExtension(String fileName) {
				    String[] allowedExtensions = { "jpg", "jpeg", "png" }; // Extensiones permitidas
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
    public ServletModificarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(getEstado(request) == EstadoSesion.SI_LOGEADO) {
			HttpSession sessionIniciada = request.getSession(false);
		    DataUsuario usr = (DataUsuario) sessionIniciada.getAttribute("usuario");
		    
		    if(usr instanceof DataPostulante) {
		    	request.getRequestDispatcher("/WEB-INF/usuarios/ModificarUsuarioPostulante.jsp").forward(request, response);
		    }else {
		    	request.getRequestDispatcher("/WEB-INF/usuarios/ModificarUsuarioEmpresa.jsp").forward(request, response);
		    }
		    
			
		}else {
			request.getRequestDispatcher("/WEB-INF/usuarios/ModificarUsuarioError.jsp").forward(request,response);
		}	
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessionIniciada = request.getSession(false);
	    DataUsuario usr = (DataUsuario) sessionIniciada.getAttribute("usuario");
	    
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String contrasenia = request.getParameter("password");
		
		
		
		//FOTO
		Part filePart = request.getPart("profile-pic");
		byte[] imagenBytes = null;
		
		if (filePart != null && filePart.getSize() > 0) {
		    // Obtén el nombre del archivo
		    String fileName = filePart.getSubmittedFileName();
		    // Verifica si el nombre del archivo tiene una extensión de imagen válida
		    if (isValidImageExtension(fileName)) {
		        // Procede a procesar y adjuntar la imagen al usuario
		        /// Lee el flujo de entrada de la imagen
	            InputStream fileContent = filePart.getInputStream();
	            try {
	            // Convierte el flujo de entrada de la imagen en un byte[]
	             imagenBytes = readImageBytes(fileContent);
	            }catch(Exception e) {}
		    
		     
		    
		    }else{
		    	
		    	imagenBytes = usr.getImagen();
		    }     
		}else {
			
			imagenBytes = usr.getImagen();
	        
		}
		
		if (usr instanceof DataPostulante) {
	        // El usuario seleccionó "Postulante"
	        // Realiza las acciones para registrar un postulante
	    	// Obtén el valor del campo de fecha de nacimiento desde la solicitud
			
	        String fechaNacimientoStr = request.getParameter("fechaNacimiento");
	        
	        // Crea un formateador para el patrón de fecha (yyyy-MM-dd)
	        String nacionalidad = request.getParameter("nacionalidad");
	         
	       
	            puertoControladorUsuario.modificarDatosPostulante(usr.getNickName(), nombre, apellido, usr.getEmail(), fechaNacimientoStr, nacionalidad, imagenBytes, contrasenia);
	            //le cierro la sesion porque cambio la contrasenia
	            
	            request.getRequestDispatcher("/CerrarSesion").forward(request, response);
	       
	    	
	    } else  {
			        // El usuario seleccionó "Empresa"
			        // Realiza las acciones para registrar una empresa
			    	
			    	String descripcion = request.getParameter("descripcion");
			    	String linkWeb = request.getParameter("linkSitio");
			    
			    	puertoControladorUsuario.modificarDatosEmpresa(usr.getNickName() , nombre, apellido, usr.getEmail(), descripcion, linkWeb, imagenBytes, contrasenia);
			    	//le cierro la sesion porque cambio la contrasenia
			    	request.getRequestDispatcher("/CerrarSesion").forward(request, response);
		         
		            
		        
	    	
	    }
	}
		
 }


