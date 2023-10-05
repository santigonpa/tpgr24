package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logica_DataTypes.DataOferta;
import logica_Manejadores.IManejadorOferta;
import utils.Fabrica;

import java.io.IOException;

@WebServlet (description = "Servlet de Consulta de oferta laboral detllada", urlPatterns = { "/DetalleOferta" })
@MultipartConfig
/**
 * Servlet implementation class ServletDetalleOferta
 */
public class ServletDetalleOferta extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Fabrica fab = Fabrica.getInstance();
    private static IManejadorOferta IMO = fab.getInManejadorOferta();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetalleOferta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombreOfer = request.getParameter("id");
		DataOferta ofer = IMO.getDataOferta(nombreOfer);
		request.setAttribute("ofer", ofer);
		request.getRequestDispatcher("ofertasLaborales/detalleOferta.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
