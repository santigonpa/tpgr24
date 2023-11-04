package com.controller.dispositivo_movil;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.model.EstadoSesion;

/**
 * Servlet implementation class home_movil
 */@WebServlet (description = "Servlet de inicio", urlPatterns = { "/home_movil" })
 public class home_movil extends HttpServlet {
		private static final long serialVersionUID = 1L;
		
	    public home_movil() {
	        super();
	    }

	    public void init() throws ServletException {
	    
	    }
	    
	    public static void iniciarLaSession(HttpServletRequest request) {
			HttpSession session = request.getSession();
			//si la sesion no esta creada, crea una la cual le pone el estado de no logeado, si esta logeado mantiene su usuario
			if (session.getAttribute("estadoSesion") == null) {
				session.setAttribute("estadoSesion", EstadoSesion.NO_LOGEADO);
			}
		}
	    
	    public static EstadoSesion getEstado(HttpServletRequest request){	
	    	//obtiene el tipo de la sesion
			return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
		}
	    
	    
	    private void processRequest(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
	    	
	    	iniciarLaSession(request); // inicializa la sesion, le pone el atributo donde va (ver codigo arriba)
			
			switch (getEstado(request)){
				
			case NO_LOGEADO:
					// hace que se ejecute el jsp sin cambiar la url
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/mobil/home_mobil/iniciar_mobil.jsp"); //obtiene dispatcher construido con la ruta
					dispatcher.forward(request, response); // envia los datos hacia la ruta con el request y response
					break;
			case SI_LOGEADO:
					// hace que se ejecute el jsp sin cambiar la url
					RequestDispatcher dispatcher2 = request.getRequestDispatcher("/WEB-INF/mobil/home_mobil/iniciarLogged_mobil.jsp"); //obtiene dispatcher construido con la ruta
					dispatcher2.forward(request, response); // envia los datos hacia la ruta con el request y response
					break;
			default:
				break;
			}
		}
	    
	    
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			processRequest(request, response);
			
			}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			processRequest(request, response);
		}

		
		
		
	}
