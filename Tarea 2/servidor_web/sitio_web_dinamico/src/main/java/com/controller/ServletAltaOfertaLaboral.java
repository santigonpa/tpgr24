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
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import logica_Controladores.IControladorOferta;
import logica_DataTypes.DataOferta;
import logica_DataTypes.DataTipoPublicacion;
import logica_Entidades.Empresa;
import logica_Entidades.KeyWord;
import logica_Entidades.TipoPublicacion;
import logica_Entidades.Usuario;
import logica_Manejadores.IManejadorPyT;
import logica_Manejadores.IManejadorUsuario;
import utils.Fabrica;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import com.model.EstadoSesion;
import excepciones.NombreRepetidoOfertaException;
import excepciones.noExistePublicacionException;



/**
 * Servlet implementation class ServletAltaOfertaLaboral
 */

@WebServlet (description = "Servlet de alta de oferta laboral", urlPatterns = { "/AltaDeOfertaLaboral" })
@MultipartConfig


public class ServletAltaOfertaLaboral extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Fabrica fab = Fabrica.getInstance();
	private IManejadorPyT IPYT = fab.getInManejadorPyT();
	private static IControladorOferta ICO = fab.getInOfer();

	
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
    	Set<DataTipoPublicacion> coleccionPTP = IPYT.getDataTipoPublicacion();
		request.setAttribute("coleccionDataPaquetes", coleccionPTP);
		
		
    	
    	Usuario user = (Usuario) request.getSession().getAttribute("usuario");
		
    	//no hay usuario logueado, lo mandamos a iniciar sesion
    	if(getEstado(request) == EstadoSesion.NO_LOGEADO) {
    		request.getRequestDispatcher("/WEB-INF/sesion/inicioDeSesion.jsp").forward(request, response);
    	} //es una empresa todo ok
    	else if (user instanceof Empresa) {
    		Set<DataTipoPublicacion> tiposPubli = fab.getInManejadorPyT().getDataTipoPublicacion();
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
    	
    	HttpSession sesion = request.getSession();
    	String nick = request.getParameter("nickName");
    	String nickName = usuario.getNickName();
    	
    	Fabrica fabrica = Fabrica.getInstance();
		IManejadorUsuario mu = fabrica.getInManejadorUsuario();
		IControladorOferta ico = fabrica.getInOfer();
		IManejadorPyT ipt = fabrica.getInManejadorPyT();
		
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
		Set<String> conjuntoOpciones = new HashSet<>(Arrays.asList(opcionesSeleccionadasKey));
		Set<KeyWord> keys = new HashSet<>();
		for(String iter : conjuntoOpciones) {
			keys.add(new KeyWord(iter));
		}
		
		String accion = request.getParameter("accion");
		
		String tipoPago = request.getParameter("tipoPago");
		
		LocalDate fechaActual = LocalDate.now();
		
		
		if(tipoPago.equals("pagoGeneral")) {
			try {
				ICO.altaPublicacionOfertaLaboralGeneral(usuario.getNickName(), opcionSeleccionadaTP, nombre, descripcion, horaDeInicio, horaDeFin, remuneracion, ciudad, departamento, fechaActual, conjuntoOpciones, imagenBytes, "Sin paquete");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/home/iniciarLogged.jsp");
				dispatcher.forward(request, response);
			}catch (NombreRepetidoOfertaException e){	
	           request.setAttribute("errorNombreOferta", "El nombre de la oferta ya está en uso");
	           request.getRequestDispatcher("/WEB-INF/ofertasLaborales/altaDeOfertaLaboral.jsp").forward(request, response);     
	            return;
	        }
		}else {
		try {
			Empresa empr = (Empresa) mu.obtenerEmpresa(usuario.getNickName());
			String nombrePaq = empr.getCompra().getPaquete().getNombre();
			ICO.altaPublicacionOfertaLaboralConPaquete(usuario.getNickName(), opcionSeleccionadaTP, nombre, descripcion, horaDeInicio, horaDeFin, remuneracion, ciudad, departamento, fechaActual, conjuntoOpciones, imagenBytes, nombrePaq);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/home/iniciarLogged.jsp");
			dispatcher.forward(request, response);
		}catch (NombreRepetidoOfertaException e){
				request.setAttribute("errorNombreOferta", "El nombre de la oferta ya está en uso");
	        	request.getRequestDispatcher("/WEB-INF/ofertasLaborales/altaDeOfertaLaboral.jsp").forward(request, response);     
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/home/iniciarLogged.jsp");
			dispatcher.forward(request, response);
		} catch (noExistePublicacionException e) {
	        	request.setAttribute("errorTipoPubli", "El tipo de publicacion ingresada no se encunetra disponible");
	        	request.getRequestDispatcher("/WEB-INF/ofertasLaborales/altaDeOfertaLaboral.jsp").forward(request, response);     
		}
		}
    }	
}
