package com.controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import com.model.EstadoSesion;
import com.webservices.controladores.publicar.PublicadorControladorUsuario;
import com.webservices.controladores.publicar.PublicadorControladorUsuarioService;
import com.webservices.controladores.publicar.PublicadorManejadorPyT;
import com.webservices.controladores.publicar.PublicadorManejadorPyTService;
import com.webservices.controladores.publicar.PublicadorManejadorUsuario;
import com.webservices.controladores.publicar.PublicadorManejadorUsuarioService;
import com.webservices.controladores.publicar.Usuario;
import com.webservices.controladores.publicar.WrapperArrayList;
import com.webservices.controladores.publicar.DataOferta;
import com.webservices.controladores.publicar.DataPaquete;
import com.webservices.controladores.publicar.KeyWord;
import com.webservices.controladores.publicar.NoExistePublicacionException_Exception;
import com.webservices.controladores.publicar.NombreRepetidoOfertaException_Exception;
import com.webservices.controladores.publicar.DataTipoPublicacion;
import com.webservices.controladores.publicar.Empresa;
import com.webservices.controladores.publicar.PublicadorControladorOfertas;
import com.webservices.controladores.publicar.PublicadorControladorOfertasService;
import com.webservices.controladores.publicar.PublicadorManejadorOfertas;
import com.webservices.controladores.publicar.PublicadorManejadorOfertasService;

/**
 * Servlet implementation class ServletAltaOfertaLaboral
 */

@WebServlet (description = "Servlet de alta de oferta laboral", urlPatterns = { "/AltaDeOfertaLaboral" })
@MultipartConfig


public class ServletAltaOfertaLaboral extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PublicadorManejadorPyTService servicePublicadorManejadorPyT = new PublicadorManejadorPyTService();
	private PublicadorManejadorPyT puertoManejadorPyT = servicePublicadorManejadorPyT.getPublicadorManejadorPyTPort();
	private PublicadorControladorOfertasService servicePublicadorOfertas = new PublicadorControladorOfertasService();
	private PublicadorControladorOfertas puertoControladorOfertas = servicePublicadorOfertas.getPublicadorControladorOfertasPort();
	private PublicadorManejadorOfertasService servicePublicadorManejadorOfertas = new PublicadorManejadorOfertasService();
	private PublicadorManejadorOfertas puertoManejadorOfertas = servicePublicadorManejadorOfertas.getPublicadorManejadorOfertasPort();
	private PublicadorManejadorUsuarioService servicePublicadorUsuario = new PublicadorManejadorUsuarioService();
	private PublicadorManejadorUsuario puertoManejadorUsuario = servicePublicadorUsuario.getPublicadorManejadorUsuarioPort();
	
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

	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAltaOfertaLaboral() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ArrayList<Object> coleccionPTPWrapper = (ArrayList<Object>) puertoManejadorPyT.getDataTipoPublicacion().getLista();
    	ArrayList<DataTipoPublicacion> coleccionPTP = new ArrayList<>();

		for (Object objeto : coleccionPTPWrapper) {
		    if (objeto instanceof DataTipoPublicacion) {
		        DataTipoPublicacion dataTipoPublicacion = (DataTipoPublicacion) objeto;
		        coleccionPTP.add(dataTipoPublicacion);
		    }
		}
		
		ArrayList<Object> coleccionKeysWrapper = (ArrayList<Object>) puertoManejadorOfertas.getDataKeyWord().getLista();
		ArrayList<KeyWord> coleccionKeys = new ArrayList<>();
		
		for (Object objeto2 : coleccionKeysWrapper) {
		    if (objeto2 instanceof KeyWord) {
		    	KeyWord key = (KeyWord) objeto2;
		    	coleccionKeys.add(key);
		    }
		}
		request.setAttribute("coleccionDataPaquetes", coleccionPTP);
		
    	Usuario user = (Usuario) request.getSession().getAttribute("usuario");
		
    	//no hay usuario logueado, lo mandamos a iniciar sesion
    	if(getEstado(request) == EstadoSesion.NO_LOGEADO) {
    		request.getRequestDispatcher("/WEB-INF/sesion/inicioDeSesion.jsp").forward(request, response);
    	} //es una empresa todo ok
    	else if (user instanceof Empresa) {
    		ArrayList<Object> coleccionDataTWrapper = (ArrayList<Object>) puertoManejadorPyT.getDataTipoPublicacion().getLista();
        	ArrayList<DataTipoPublicacion> tiposPubli = new ArrayList<>();

    		for (Object objeto3 : coleccionDataTWrapper) {
    		    if (objeto3 instanceof DataTipoPublicacion) {
    		        DataTipoPublicacion dataTipoPublicacion = (DataTipoPublicacion) objeto3;
    		        tiposPubli.add(dataTipoPublicacion);
    		    }
    		}

    		request.setAttribute("keys", coleccionKeys);
    		request.setAttribute("tiposPubli", tiposPubli);
    		request.getRequestDispatcher("/WEB-INF/ofertasLaborales/altaDeOfertaLaboral.jsp").forward(request, response);
    	}//	es un postulante
    	else {
    		//request.getRequestDispatcher("/WEB-INF/ofertasLaborales/altaDeOfertaLaboralErroneo.jsp").forward(request, response);
    		request.getRequestDispatcher("/WEB-INF/ofertasLaborales/altaDeOfertaLaboralErroneo.jsp").forward(request, response);
    	}
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");
    	
    	
    	
		
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String departamento = request.getParameter("departamento");
		String ciudad = request.getParameter("ciudad");
		String horaDeInicioo = request.getParameter("horaDeInicio");
		String horaDeFinn = request.getParameter("horaDeFin");
		
		DateTimeFormatter formateo = DateTimeFormatter.ofPattern("HH:mm");	
	
		LocalTime horaDeInicio = LocalTime.parse(horaDeInicioo, formateo);
		LocalTime horaDeFin = LocalTime.parse(horaDeFinn, formateo);
	
    	
		String remuneracionn = request.getParameter("remuneracion");
		int remuneracion = Integer.parseInt(remuneracionn);
		
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
				    	// Obtiene el contexto del servlet
				        ServletContext context = getServletContext();

				        // Obtiene la ruta de ejecución del servlet
				        String rutaEjecucion = context.getRealPath("media/img/imgagenDefaultOferta");
				        Path imagePath = Paths.get(rutaEjecucion);
				    	 imagenBytes = Files.readAllBytes(imagePath);
				    }     
				}else {
					// Obtiene el contexto del servlet
			        ServletContext context = getServletContext();

			        // Obtiene la ruta de ejecución del servlet
			        String rutaEjecucion = context.getRealPath("media/img/imgagenDefaultOferta.jpg");
			        Path imagePath = Paths.get(rutaEjecucion);
			    	 imagenBytes = Files.readAllBytes(imagePath);
			        // Imprime la ruta de ejecución para verificarla
			        System.out.println("Ruta de ejecución del servlet: " + rutaEjecucion);
			        
				}
		
    
		String opcionSeleccionadaTP;
		String botonSeleccionado = request.getParameter("btnradio");

	    if ("basica".equals(botonSeleccionado)) {
	        opcionSeleccionadaTP = "Básica";
	    } else if ("estandar".equals(botonSeleccionado)) {
	        opcionSeleccionadaTP = "Estándar";
	    } else if ("premium".equals(botonSeleccionado)) {
	    	opcionSeleccionadaTP =  "Premium";
	    } else {
	    	opcionSeleccionadaTP = "Destacada";
	    }
	    
		String[] opcionesSeleccionadasKey = request.getParameterValues("keys");
		Set<String> conjuntoOpciones = new HashSet<>();

		if (opcionesSeleccionadasKey != null) {
		    conjuntoOpciones = new HashSet<>(Arrays.asList(opcionesSeleccionadasKey));
		}

		Set<KeyWord> keys = new HashSet<>();
		for (String iter : conjuntoOpciones) {
			KeyWord clave = new KeyWord();
			clave.setPalabraClave(iter);
		    keys.add(clave);
		}
		
		WrapperArrayList conjuntoOpcionesWrapper = new WrapperArrayList();
		for(String key : conjuntoOpciones) {
			conjuntoOpcionesWrapper.getLista().add(key);
		}
	
		
		String tipoPago = request.getParameter("tipoPago");
		
		LocalDate fechaActual = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MM yyyy");
		DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm");
        String fechaFormateada = fechaActual.format(formatter);
		
		System.out.println("El" + tipoPago);
		
		if(tipoPago.equals("pagoGeneral")) {
			try {
				puertoControladorOfertas.altaPublicacionOfertaLaboralGeneral(usuario.getNickName(), opcionSeleccionadaTP, nombre, descripcion, horaDeInicio.format(formatterHora), horaDeFin.format(formatterHora), remuneracion, ciudad, departamento, fechaFormateada, conjuntoOpcionesWrapper, imagenBytes, "Sin paquete");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/home/iniciarLogged.jsp");
				dispatcher.forward(request, response);
			}catch (NombreRepetidoOfertaException_Exception e){	
	           request.setAttribute("errorNombreOferta", "El nombre de la oferta ya está en uso");
	           request.getRequestDispatcher("/WEB-INF/ofertasLaborales/altaDeOfertaLaboral.jsp").forward(request, response);     
	            return;
	        }
		}else {
			String nombrePaq;
		try {
			Empresa empr = (Empresa) puertoManejadorUsuario.obtenerEmpresa(usuario.getNickName());
			
			if(empr.getCompra() != null) {
				nombrePaq = empr.getCompra().getPaqCompr().getNombre(); //esto cambie de getPaquete a getPaqCompr chequear (el que esta generado es el que puse yo)
			}else {
				nombrePaq = "Servlet";
			}
			
			puertoControladorOfertas.altaPublicacionOfertaLaboralConPaquete(usuario.getNickName(), opcionSeleccionadaTP, nombre, descripcion, horaDeInicio.format(formatterHora), horaDeFin.format(formatterHora), remuneracion, ciudad, departamento, fechaFormateada, conjuntoOpcionesWrapper, imagenBytes, nombrePaq);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/home/iniciarLogged.jsp");
			dispatcher.forward(request, response);
		}catch (NombreRepetidoOfertaException_Exception e){
				request.setAttribute("errorNombreOferta", "El nombre de la oferta ya está en uso");
	        	request.getRequestDispatcher("/WEB-INF/ofertasLaborales/altaDeOfertaLaboral.jsp").forward(request, response);     
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/home/iniciarLogged.jsp");
			dispatcher.forward(request, response);
		} catch (NoExistePublicacionException_Exception e) {
	        	request.setAttribute("errorTipoPubli", "El tipo de publicacion ingresada no se encunetra disponible");
	        	request.getRequestDispatcher("/WEB-INF/ofertasLaborales/altaDeOfertaLaboral.jsp").forward(request, response);     
		}
		}
    }	
}
