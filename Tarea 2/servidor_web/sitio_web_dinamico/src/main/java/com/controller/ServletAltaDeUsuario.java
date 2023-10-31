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
import com.webservices.controladores.publicar.CampoInvalidoException_Exception;
import com.webservices.controladores.publicar.EmailYaExisteException_Exception;
import com.webservices.controladores.publicar.NicknameYaExisteException_Exception;
import com.webservices.controladores.publicar.PublicadorControladorUsuario;
import com.webservices.controladores.publicar.PublicadorControladorUsuarioService;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import jakarta.servlet.annotation.MultipartConfig;

/**
 * Servlet implementation class ServletAltaDeUsuario
 */

@WebServlet (description = "Servlet de alta de usuario", urlPatterns = { "/AltaUsuario" })
@MultipartConfig //SI FALTA ESTO NO ANDA NADA PORFAVOR NO SE COMPLIQUEN COMO NOSOTROS xd


public class ServletAltaDeUsuario extends HttpServlet {
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
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAltaDeUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(getEstado(request) == EstadoSesion.SI_LOGEADO) {
			request.getRequestDispatcher("/WEB-INF/usuarios/UsuarioSesionYaIniciada.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/WEB-INF/usuarios/AltaUsuario.jsp").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		    	// !!!!!!!!
		    	/*Path imagePath = Paths.get("C:\\Users\\Usuario\\git\\tpgr24\\Tarea 2\\servidor_web\\sitio_web_dinamico\\src\\main\\java\\com\\controller\\userImage.jpg");
		    	 imagenBytes = Files.readAllBytes(imagePath);
		    	}*/
		    	
		    	
		    	// Obtiene el contexto del servlet
		        ServletContext context = getServletContext();

		        // Obtiene la ruta de ejecución del servlet
		        String rutaEjecucion = context.getRealPath("media/img/userImage.jpg");
		        Path imagePath = Paths.get(rutaEjecucion);
		    	 imagenBytes = Files.readAllBytes(imagePath);
		    }     
		}else {
			/*
			//String urlBase = request.getRequestURL().toString();
			// Construye la URL completa de la imagen en el servidor
			String urlImagenServidor = "http://localhost:8086/TrabajoUY/media/img/userImage.jpg";

			try {
			    // Crea una URL a partir de la cadena de URL
			    URL url = new URL(urlImagenServidor);
			    
			    // Abre una conexión HTTP
			    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			    
			    // Configura la solicitud HTTP
			    conn.setRequestMethod("GET");
			    
			    // Lee los bytes de la imagen desde la conexión
			    InputStream inputStream = conn.getInputStream();
			    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			    int nRead;
			    byte[] data = new byte[1024];
			    
			    while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
			        buffer.write(data, 0, nRead);
			    }
			    
			    buffer.flush();
			    
			    // Obtiene los bytes de la imagen
			    imagenBytes = buffer.toByteArray();
			    
			    // Cierra la conexión y el flujo de entrada
			    inputStream.close();
			    conn.disconnect();
			} catch (IOException e) {
			    e.printStackTrace();
			}

	        */
			
			// Obtiene el contexto del servlet
	        ServletContext context = getServletContext();

	        // Obtiene la ruta de ejecución del servlet
	        String rutaEjecucion = context.getRealPath("media/img/userImage.jpg");
	        Path imagePath = Paths.get(rutaEjecucion);
	    	 imagenBytes = Files.readAllBytes(imagePath);
	        // Imprime la ruta de ejecución para verificarla
	        System.out.println("Ruta de ejecución del servlet: " + rutaEjecucion);
	        
		}
	
		    // Obtén el valor del campo oculto "tipoUsuario" del formulario
		    String tipoUsuario = request.getParameter("tipoUsuario");
		    
		    
		    
		    if ("postulante".equals(tipoUsuario)) {
		        // El usuario seleccionó "Postulante"
		        // Realiza las acciones para registrar un postulante
		    	// Obtén el valor del campo de fecha de nacimiento desde la solicitud
		        String fechaNacimientoRecibida = request.getParameter("fechaNacimiento");
		        String nacionalidad = request.getParameter("nacionalidad");
		        DateTimeFormatter formatoOriginal = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		        DateTimeFormatter formatoDeseado = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		        LocalDate localDate = LocalDate.parse(fechaNacimientoRecibida, formatoOriginal);
		        String fechaFormateada = localDate.format(formatoDeseado);
		        
		        try {
		            puertoControladorUsuario.altaUsuarioPostulante(nickName, nombre, apellido, email, fechaFormateada, nacionalidad, imagenBytes, contrasenia);
		            request.getRequestDispatcher("/WEB-INF/sesion/inicioDeSesion.jsp").forward(request, response);
		        } catch (NicknameYaExisteException_Exception e) {
		        	// Agregar un atributo a la solicitud con el mensaje de error
		            request.setAttribute("errorRegistroNickname", "El nickname ya está en uso. Por favor, elige otro.");
		            
		            // Redirigir de vuelta a tu formulario de registro
		            request.getRequestDispatcher("/WEB-INF/usuarios/AltaUsuario.jsp").forward(request, response);
		            return;
		        }
		        catch (EmailYaExisteException_Exception e) {
		        	

		        	// Agregar un atributo a la solicitud con el mensaje de error
		            request.setAttribute("errorRegistroEmail", "El nickname ya está en uso. Por favor, elige otro.");
		            
		            // Redirigir de vuelta a tu formulario de registro
		            request.getRequestDispatcher("/WEB-INF/usuarios/AltaUsuario.jsp").forward(request, response);
		            return;
				} catch (CampoInvalidoException_Exception e) {
					//ESTO NO DEBERIA HACER NADA
					e.printStackTrace();
					

				}
		    	
		    } else if ("empresa".equals(tipoUsuario)) {
				        // El usuario seleccionó "Empresa"
				        // Realiza las acciones para registrar una empresa
				    	
				    	String descripcion = request.getParameter("descripcion");
				    	String linkWeb = request.getParameter("linkSitio");
				    try {
				    	puertoControladorUsuario.altaUsuarioEmpresa(nickName, nombre, apellido, email, descripcion, linkWeb, imagenBytes, contrasenia);
			            response.sendRedirect("/TrabajoUY/iniciarSesion");
			         
			            
			        } catch (NicknameYaExisteException_Exception e) {
			        	
			            request.setAttribute("errorRegistroNickname", "El nickname ya está en uso. Por favor, elige otro.");
			            
			            
			            request.getRequestDispatcher("/WEB-INF/usuarios/AltaUsuario.jsp").forward(request, response);
			            return;
			        }
			        catch (EmailYaExisteException_Exception e) {
						
			        	
			            request.setAttribute("errorRegistroEmail", "El nickname ya está en uso. Por favor, elige otro.");
			            
			            // Redirigir de vuelta a tu formulario de registro
			            request.getRequestDispatcher("/WEB-INF/usuarios/AltaUsuario.jsp").forward(request, response);
			            return;
					} catch (CampoInvalidoException_Exception e) {
						
			            request.setAttribute("campoInvalido", "Existe un campo sin rellenar. Por favor verifique, si estaba creando una empresa vuelva a seleccionar EMPRESA arriba.");
			            
			            // Redirigir de vuelta a tu formulario de registro
			            request.getRequestDispatcher("/WEB-INF/usuarios/AltaUsuario.jsp").forward(request, response);
					}
		    	
		    }
		
 		}
}

		
	


