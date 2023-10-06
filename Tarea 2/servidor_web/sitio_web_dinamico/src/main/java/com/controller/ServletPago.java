package com.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logica_DataTypes.DataOferta;
import logica_Manejadores.IManejadorOferta;
import logica_Manejadores.IManejadorUsuario;
import utils.Fabrica;

import java.io.IOException;

import excepciones.NombreRepetidoOfertaException;

/**
 * Servlet implementation class ServletPago
 */
public class ServletPago extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Fabrica fab = Fabrica.getInstance();
    private static IManejadorOferta IMO = fab.getInManejadorOferta();
    private static IManejadorUsuario IMU = fab.getInManejadorUsuario();
    
   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPago() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void mostrarEnPantalla(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	String monto = request.getParameter("id");
    	DataOferta dtOfer = (DataOferta) request.getAttribute("dtOfer");
    	String formaDePago = request.getParameter("forma");
    	
    	request.setAttribute("dtOfer", dtOfer);
    	request.setAttribute("monto", monto);
    	request.setAttribute("forma", formaDePago);
		request.getRequestDispatcher("/WEB-INF/ofertasLaborales/compraOferta.jsp").forward(request, response);
	
		
    }
    
    	
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		mostrarEnPantalla(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
