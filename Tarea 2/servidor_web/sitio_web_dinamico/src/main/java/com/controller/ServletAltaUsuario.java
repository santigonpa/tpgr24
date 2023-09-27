package com.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import com.model.EstadoSesion;

import excepciones.EmailYaExisteException;
import excepciones.NicknameYaExisteException;
import excepciones.campoInvalidoException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import logica_Controladores.IControladorUsuario;
import utils.Fabrica;

/**
 * Servlet implementation Alta Usuario
 */
@WebServlet (description = "Servlet de alta de usuario", urlPatterns = { "/AltaUsuario" })
public class ServletAltaUsuario extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public ServletAltaUsuario () {
		super();
	}

	private Fabrica fab = Fabrica.getInstance();
	private IControladorUsuario ICU = fab.getInUser();
    
    public static EstadoSesion getEstado(HttpServletRequest request)
	{	//obtiene el tipo de la sesion
		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(getEstado(request) == EstadoSesion.SI_LOGEADO) {
			request.getRequestDispatcher("/WEB-INF/usuarios/UsuarioSesionYaIniciada.jsp").forward(request,response);
		}
		
		request.getRequestDispatcher("/WEB-INF/usuarios/AltaUsuario.jsp").forward(request,response);
		
		
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
			
			
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		System.out.println("llegue al servlet");
		
		String nickName = request.getParameter("nickname");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String contrasenia = request.getParameter("password");
		String email = request.getParameter("correo");
		
		
		//FOTO
		Part filePart = request.getPart("profile-pic");
		byte[] imagenBytes = null;
		
		if (filePart != null && filePart.getSize() > 0) {
		    // Obtén el nombre del archivo
		    String fileName = filePart.getSubmittedFileName();
		    System.out.println("llegue ala fotona");
		    // Verifica si el nombre del archivo tiene una extensión de imagen válida
		    if (isValidImageExtension(fileName)) {
		        // Procede a procesar y adjuntar la imagen al usuario
		        /// Lee el flujo de entrada de la imagen
	            InputStream fileContent = filePart.getInputStream();

	            // Convierte el flujo de entrada de la imagen en un byte[]
	             imagenBytes = readImageBytes(fileContent);
		    }
		     
		    
		    }else{
		    	System.out.println("llegue al servlet pamba");
		    	// Ruta de la imagen predeterminada en la carpeta "img"
		        String defaultImagePath = "userImage.jpg"; // Reemplaza con la ruta real de tu imagen predeterminada

		        // Lee los bytes de la imagen predeterminada
		        Path imagePath = Paths.get(defaultImagePath);
		    	 imagenBytes = Files.readAllBytes(imagePath);
		    }
		
		
		
		System.out.println("llegue al servlet ando aca en la vuelta");
		    // Obtén el valor del campo oculto "tipoUsuario" del formulario
		    String tipoUsuario = request.getParameter("tipoUsuario");
		    
		    if ("postulante".equals(tipoUsuario)) {
		        // El usuario seleccionó "Postulante"
		        // Realiza las acciones para registrar un postulante
		    	// Obtén el valor del campo de fecha de nacimiento desde la solicitud
		        String fechaNacimientoStr = request.getParameter("fechaNacimiento");
		        System.out.println("llegue al seeeeeeeeeeeeeeeeeeeeeeeeeeeeervlet");
		        // Crea un formateador para el patrón de fecha (yyyy-MM-dd)
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		        
		        try {
		            // Intenta analizar la fecha en un objeto LocalDate
		            LocalDate fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);
		            ICU.altaUsuarioPostulante(nickName, nombre, apellido, email, fechaNacimiento, email, imagenBytes, contrasenia);
		            response.sendRedirect("/WEB-INF/usuarios/iniciarSesion.jsp");
		            System.out.println("llegue al servtermine activo let");

		         
		            
		        } catch (NicknameYaExisteException e) {
		        	
		        	System.out.println("Hola, mundo!");

		        	// Agregar un atributo a la solicitud con el mensaje de error
		            request.setAttribute("errorRegistroNickname", "El nickname ya está en uso. Por favor, elige otro.");
		            
		            // Redirigir de vuelta a tu formulario de registro
		            request.getRequestDispatcher("/WEB-INF/usuarios/AltaUsuario.jsp").forward(request, response);
		            return;
		        }
		        catch (EmailYaExisteException e) {
		        	

		        	// Agregar un atributo a la solicitud con el mensaje de error
		            request.setAttribute("errorRegistroEmail", "El nickname ya está en uso. Por favor, elige otro.");
		            
		            // Redirigir de vuelta a tu formulario de registro
		            request.getRequestDispatcher("/WEB-INF/usuarios/AltaUsuario.jsp").forward(request, response);
		            return;
				} catch (campoInvalidoException e) {
					//ESTO NO DEBERIA HACER NADA
					e.printStackTrace();
					

				}
		    	
		    } else if ("empresa".equals(tipoUsuario)) {
		        // El usuario seleccionó "Empresa"
		        // Realiza las acciones para registrar una empresa
		    	
		    	String descripcion = request.getParameter("descripcion");
		    	String linkWeb = request.getParameter("linkSitio");
		    try {
		    	ICU.altaUsuarioEmpresa(nickName, nombre, apellido, email, descripcion, linkWeb, imagenBytes, tipoUsuario);
	            request.getRequestDispatcher("/WEB-INF/usuarios/iniciarSesion.jsp").forward(request, response);
	         
	            
	        } catch (NicknameYaExisteException e) {
	        	// Agregar un atributo a la solicitud con el mensaje de error
	            request.setAttribute("errorRegistroNickname", "El nickname ya está en uso. Por favor, elige otro.");
	            
	            // Redirigir de vuelta a tu formulario de registro
	            request.getRequestDispatcher("/WEB-INF/usuarios/AltaUsuario.jsp").forward(request, response);
	            return;
	        }
	        catch (EmailYaExisteException e) {
				
	        	// Agregar un atributo a la solicitud con el mensaje de error
	            request.setAttribute("errorRegistroEmail", "El nickname ya está en uso. Por favor, elige otro.");
	            
	            // Redirigir de vuelta a tu formulario de registro
	            request.getRequestDispatcher("/WEB-INF/usuarios/AltaUsuario.jsp").forward(request, response);
	            return;
			} catch (campoInvalidoException e) {
				//ESTO NO DEBERIA HACER NADA
				e.printStackTrace();
			}
		    	
		    	
		    }
		    
		   
		

		
		
 	}
	
	
}
