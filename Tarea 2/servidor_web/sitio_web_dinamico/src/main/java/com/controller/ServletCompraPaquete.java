package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.webservices.controladores.publicar.DataEmpresa;
import com.webservices.controladores.publicar.DataPaquete;

import com.webservices.controladores.publicar.Empresa;
import com.webservices.controladores.publicar.Usuario;
import com.webservices.controladores.publicar.Paquete;
import com.webservices.controladores.publicar.PublicadorControladorOfertas;
import com.webservices.controladores.publicar.PublicadorControladorOfertasService;
import com.webservices.controladores.publicar.PublicadorManejadorOfertas;
import com.webservices.controladores.publicar.PublicadorManejadorOfertasService;

import java.io.IOException;

import com.model.EstadoSesion;
import com.webservices.controladores.publicar.PublicadorManejadorPyT;
import com.webservices.controladores.publicar.PublicadorManejadorPyTService;
import com.webservices.controladores.publicar.PublicadorManejadorUsuario;
import com.webservices.controladores.publicar.PublicadorManejadorUsuarioService;

@WebServlet (description = "Servlet para comprar paquete", urlPatterns = { "/CompraPaquete" })
@MultipartConfig
/**
 * Servlet implementation class ServletCompraPaquete
 */
public class ServletCompraPaquete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PublicadorManejadorPyTService servicePublicadorManejadorPyT = new PublicadorManejadorPyTService();
	private PublicadorManejadorPyT puertoManejadorPyT = servicePublicadorManejadorPyT.getPublicadorManejadorPyTPort();
	private PublicadorControladorOfertasService servicePublicadorOfertas = new PublicadorControladorOfertasService();
	private PublicadorControladorOfertas puertoControladorOfertas = servicePublicadorOfertas.getPublicadorControladorOfertasPort();
	private PublicadorManejadorOfertasService servicePublicadorManejadorOfertas = new PublicadorManejadorOfertasService();
	private PublicadorManejadorOfertas puertoManejadorOfertas = servicePublicadorManejadorOfertas.getPublicadorManejadorOfertasPort();
	private PublicadorManejadorUsuarioService servicePublicadorUsuario = new PublicadorManejadorUsuarioService();
	private PublicadorManejadorUsuario puertoManejadorUsuario = servicePublicadorUsuario.getPublicadorManejadorUsuarioPort();

    public ServletCompraPaquete() {
        super();
    }

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
			String paq = (String)request.getParameter("id");
			Usuario user = (Usuario) request.getSession().getAttribute("usuario");
			Empresa emp = (Empresa) puertoManejadorUsuario.obtenerEmpresa(user.getNickName());
			Paquete paquete= puertoManejadorPyT.getPaquete(paq);
			DataPaquete dtpaq = puertoManejadorPyT.getDataPaquete(paq);
			puertoManejadorUsuario.CompraPaquete(paquete, emp.getNickName());
			DataEmpresa DTemp = puertoManejadorUsuario.getDataEmpresa(emp.getNickName());
			request.setAttribute("paquete", dtpaq);
			request.getRequestDispatcher("/WEB-INF/home/iniciarLogged.jsp").forward(request, response);
			}			
			
			if(!banderaSesion) {
			request.getRequestDispatcher("/WEB-INF/sesion/inicioDeSesion.jsp").forward(request, response);
			
			}
			
			
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        cargarDatos(request, response);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
