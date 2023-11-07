package com.controller.dispositivo_movil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.model.EstadoSesion;

/**
 * Servlet implementation class ServletCerrarSesionMovil
 */
@WebServlet (description = "Servlet Cerrar Sesion movil", urlPatterns = { "/cerrarSesion_movil" })
public class ServletCerrarSesionMovil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ServletCerrarSesionMovil() {
        super();

    }
    public static EstadoSesion getEstado(HttpServletRequest request)
	{	//obtiene el tipo de la sesion
		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(getEstado(request) == EstadoSesion.SI_LOGEADO) {
			EstadoSesion estado = EstadoSesion.NO_LOGEADO;
			HttpSession sesion = request.getSession();
			sesion.setAttribute("estadoSesion", estado);
			request.getRequestDispatcher("/WEB-INF/mobil/home_mobil/iniciar_mobil.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
