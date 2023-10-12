package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logica_entidades.Empresa;
import logica_entidades.Usuario;
import logica_entidades.Paquete;



import logica_manejadores.IManejadorPyT;
import utils.Fabrica;

import java.io.IOException;

import com.model.EstadoSesion;

@WebServlet (description = "Servlet para comprar paquete", urlPatterns = { "/ServletCompraPaquete" })

/**
 * Servlet implementation class ServletCompraPaquete
 */
public class ServletCompraPaquete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private Fabrica fab = Fabrica.getInstance();
	    private IManejadorPyT IMPYT = fab.getInManejadorPyT();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCompraPaquete() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

    public static EstadoSesion getEstado(HttpServletRequest request){	//obtiene el tipo de la sesion
  		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
  		
  	}
    
  

    protected void cargarDatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    		boolean banderaSesion;
    		if (getEstado(request) != null) {
    			banderaSesion = getEstado(request).equals(EstadoSesion.SI_LOGEADO);
    		}else {
    			banderaSesion = false;
    		}
			
			if(banderaSesion) {
			String paq = (String)request.getAttribute("id");
			Usuario user = (Usuario) request.getSession().getAttribute("usuario");
			Empresa emp = (Empresa) user;
			Paquete paquete=fab.getInManejadorPyT().getPaquete(paq);
			fab.getInManejadorUsuario().CompraPaquete(paquete, user.getNombre());
			request.getRequestDispatcher("/WEB-INF/ofertasLaborales/miUsuarioEmpresa.jsp").forward(request, response);
			}			
			
			if(!banderaSesion) {
			request.getRequestDispatcher("/WEB-INF/ofertasLaborales/inicioDeSesion.jsp").forward(request, response);
			
			}
			
			
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
