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
import java.util.Set;

import com.model.EstadoSesion;

import excepciones.EmailYaExisteException;
import excepciones.NicknameYaExisteException;
import excepciones.campoInvalidoException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import logica_Controladores.ControladorOferta;
import logica_Controladores.IControladorOferta;
import logica_DataTypes.DataTipoPublicacion;
import jakarta.servlet.annotation.MultipartConfig;
import utils.Fabrica;

@WebServlet (description = "Servlet de alta de oferta laboral", urlPatterns = { "/altaDeOfertaLaboral" })
@MultipartConfig

public class ServletAltaDeOfertaLaboral {
	private static final long serialVersionUID = 1L;
	
	private static Fabrica fab = Fabrica.getInstance();
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
	public ServletAltaDeOfertaLaboral() {
		super();
	// TODO Auto-generated constructor stub
	}

	/**
 	* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	*/
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ErrorHandler.guardarErrorDelQueryEnAttributeDelRequest(request);

        if (EstadoSesionHelper.hayProveedorLogueado(request)) {
            try {
                
                Set<DataTipoPublicacion> tiposPubli = fab.getInManejadorPyT().getDataTipoPublicacion();
                
                String cardContent = "";
                for (DataTipoPublicacion tipoP : tiposPubli) {
                    
                	// Genera dinámicamente el contenido de la tarjeta
                    String titulo = tipoP.getNombre();
                    
                    
                    // Construye la tarjeta de Bootstrap
                    cardContent += "<div class='card'>";
                    cardContent += "<div class='card-body'>";
                    cardContent += "<h5 class='card-title'>" + titulo + "</h5>";
                    cardContent += "<a href='#' class='btn btn-primary' onclick='seleccionarTarjeta(" + "Seleccionar" + ")'>Seleccionar</a>";
                    cardContent += "</div>";
                    cardContent += "</div>";
                    
                }

                request.setAttribute("cardContent", cardContent);

                RequestDispatcher dispatcher = request.getRequestDispatcher("/cards.jsp");
                dispatcher.forward(request, response);

            } catch (NoHayEntidadesParaListarException e) {
                //TODO tiene que saltar un error
                response.sendRedirect(request.getContextPath() + Endpoints.HOME_SERVLET);
            }
            return;
        }

        if (EstadoSesionHelper.hayTuristaLogueado(request)) {
            ErrorHandler.redirigirAPaginaDeError(request, response, 401);
            return;
        }

        response.sendRedirect(request.getContextPath() + Endpoints.INICIAR_SESION_SERVLET);
    }
}
