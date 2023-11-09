package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.model.EstadoSesion;
import com.webservices.controladores.publicar.DataEmpresa;
import com.webservices.controladores.publicar.DataKeyWord;
import com.webservices.controladores.publicar.DataTipoPublicacion;
import com.webservices.controladores.publicar.DataUsuario;
import com.webservices.controladores.publicar.KeyWord;
import com.webservices.controladores.publicar.NoExistePublicacionException_Exception;
import com.webservices.controladores.publicar.NombreRepetidoOfertaException_Exception;
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
import com.webservices.controladores.publicar.WrapperArrayList;

/**
 * Servlet implementation class ServletAltaDeOfertaLaboralGeneral
 */
@WebServlet (description = "Servlet de alta de oferta laboral general", urlPatterns = { "/AltaDeOfertaLaboralGeneral" })
@MultipartConfig

public class ServletAltaDeOfertaLaboralGeneral extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PublicadorManejadorPyTService servicePublicadorManejadorPyT = new PublicadorManejadorPyTService();
	private PublicadorManejadorPyT puertoManejadorPyT = servicePublicadorManejadorPyT.getPublicadorManejadorPyTPort();
	private PublicadorControladorOfertasService servicePublicadorOfertas = new PublicadorControladorOfertasService();
	private PublicadorControladorOfertas puertoControladorOfertas = servicePublicadorOfertas.getPublicadorControladorOfertasPort();
	private PublicadorManejadorOfertasService servicePublicadorManejadorOfertas = new PublicadorManejadorOfertasService();
	private PublicadorManejadorOfertas puertoManejadorOfertas = servicePublicadorManejadorOfertas.getPublicadorManejadorOfertasPort();
	private PublicadorManejadorUsuarioService servicePublicadorManUsuario = new PublicadorManejadorUsuarioService();
	private PublicadorManejadorUsuario puertoManejadorUsuario = servicePublicadorManUsuario.getPublicadorManejadorUsuarioPort();
	private PublicadorControladorUsuarioService servicePublicadorUsuario = new PublicadorControladorUsuarioService();
	private PublicadorControladorUsuario puertoControladorUsuario = servicePublicadorUsuario.getPublicadorControladorUsuarioPort();
    
    
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
    public ServletAltaDeOfertaLaboralGeneral() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataUsuario user = (DataUsuario) request.getSession().getAttribute("usuario");

    	//no hay usuario logueado, lo mandamos a iniciar sesion
    	if(getEstado(request) == EstadoSesion.NO_LOGEADO) {
    		request.getRequestDispatcher("/WEB-INF/sesion/inicioDeSesion.jsp").forward(request, response);
    	 //es una empresa todo ok
    	}else if (user instanceof DataEmpresa) {
    	
    		ArrayList<Object> coleccionPTPWrapperCompleta = (ArrayList<Object>) puertoManejadorPyT.getDataTipoPublicacion().getLista();
        	ArrayList<DataTipoPublicacion> coleccionPTPCompleta = new ArrayList<>();

    		for (Object objeto : coleccionPTPWrapperCompleta) {
    		    if (objeto instanceof DataTipoPublicacion) {
    		        DataTipoPublicacion dataTipoPublicacion = (DataTipoPublicacion) objeto;
    		        coleccionPTPCompleta.add(dataTipoPublicacion);
    		    }
    		}
        	
    		ArrayList<Object> coleccionKeysWrapper = (ArrayList<Object>) puertoManejadorOfertas.getDataKeyWord().getLista();
    		ArrayList<DataKeyWord> coleccionKeys = new ArrayList<>();
    		
    		for (Object objeto2 : coleccionKeysWrapper) {
    		    if (objeto2 instanceof DataKeyWord) {
    		    	DataKeyWord key = (DataKeyWord) objeto2;
    		    	coleccionKeys.add(key);
    		    }
    		}
    		
    		request.setAttribute("coleccionDataPaquetesCompleta", coleccionPTPCompleta);
    		request.setAttribute("keys", coleccionKeys);
    		request.getRequestDispatcher("/WEB-INF/ofertasLaborales/altaDeOfertaLaboralGeneral.jsp").forward(request, response);
    	}else {
    		request.getRequestDispatcher("/WEB-INF/ofertasLaborales/altaDeOfertaLaboralErroneo.jsp").forward(request, response);
    	}
    }	
    	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DataUsuario usuario = (DataUsuario) request.getSession().getAttribute("usuario");
		
		String nombre = request.getParameter("nombre");
		String descripcion = request.getParameter("descripcion");
		String departamento = request.getParameter("departamento");
		String ciudad = request.getParameter("ciudad");
		String horaDeInicioo = request.getParameter("horaDeInicio");
		String horaDeFinn = request.getParameter("horaDeFin");
		String opcionSeleccionadaTP = request.getParameter("tipoPubli");
		System.out.println(opcionSeleccionadaTP);
		
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
	

		LocalDate fechaActual = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm");
        String fechaFormateada = fechaActual.format(formatter);
		
			try {
				puertoControladorOfertas.altaPublicacionOfertaLaboralGeneral(usuario.getNickName(), opcionSeleccionadaTP, nombre, descripcion, horaDeInicio.format(formatterHora), horaDeFin.format(formatterHora), remuneracion, ciudad, departamento, fechaFormateada, conjuntoOpcionesWrapper, imagenBytes, "Sin paquete");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/home/iniciarLogged.jsp");
				dispatcher.forward(request, response);
			}catch (NombreRepetidoOfertaException_Exception e){	
	           request.setAttribute("errorNombreOferta", "El nombre de la oferta ya está en uso");
	           request.getRequestDispatcher("/WEB-INF/ofertasLaborales/altaDeOfertaLaboralGeneral.jsp").forward(request, response);     
	            return;
	        }catch(NoExistePublicacionException_Exception e) {
	        	request.setAttribute("errorNombrePubli", "El tipo de publicacion seleccionada no existe");
		        request.getRequestDispatcher("/WEB-INF/ofertasLaborales/altaDeOfertaLaboralGeneral.jsp").forward(request, response);     
		        return;
	        }
		}

	}
