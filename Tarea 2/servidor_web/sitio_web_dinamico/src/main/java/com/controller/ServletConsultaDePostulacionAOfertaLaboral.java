package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logica_DataTypes.DataOferta;
import logica_DataTypes.DataPostulacion;
import logica_Entidades.Postulante;
import logica_Entidades.Usuario;
import logica_Manejadores.IManejadorOferta;
import logica_Manejadores.IManejadorUsuario;
import utils.Fabrica;

import java.io.IOException;

/**
 * Servlet implementation class ServletConsultaDePostulacionAOfertaLaboral
 */
@WebServlet (description = "Servlet de Consulta de Postulacion A Oferta Laboral", urlPatterns = { "/PostulacionAOferta" })
@MultipartConfig
public class ServletConsultaDePostulacionAOfertaLaboral extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Fabrica fab = Fabrica.getInstance();
    private static IManejadorOferta IMO = fab.getInManejadorOferta();
    private static IManejadorUsuario IMU = fab.getInManejadorUsuario();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConsultaDePostulacionAOfertaLaboral() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void cargarDatos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String nombreOfer = request.getParameter("id");
		DataOferta ofer = IMO.getDataOferta(nombreOfer);
		Usuario usuario = (Usuario) request.getSession().getAttribute("usuario");    	
		Postulante post = (Postulante) IMU.obtenerPostulante(usuario.getNickName());
		DataPostulacion dtPost = post.obtenerPostulacion(nombreOfer);
		request.setAttribute("dtPost", dtPost);
		request.getRequestDispatcher("/WEB-INF/ofertasLaborales/informacionPostulacion.jsp").forward(request, response);

	    
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
