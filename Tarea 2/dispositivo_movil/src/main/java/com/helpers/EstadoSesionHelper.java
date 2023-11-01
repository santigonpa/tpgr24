package com.helpers;

import com.model.EstadoSesion;

import jakarta.servlet.http.HttpSession;

import jakarta.servlet.http.HttpServletRequest;


public class EstadoSesionHelper {
	/**
	 * inicializa la sesión si no estaba creada
	 * 
	 * @param request
	 */
	public static void initSession(HttpServletRequest request) {
		HttpSession session = request.getSession();

		if (session.getAttribute("estadoSesion") == null) {
			session.setAttribute("estadoSesion", EstadoSesion.NO_LOGEADO);
		}
	}

	public static EstadoSesion getEstado(HttpServletRequest request) {
		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
	}

	public static void setEstado(HttpServletRequest request, EstadoSesion estado) {
		request.getSession().setAttribute("estadoSesion", estado);
	}

	public static boolean hayUsuarioLogueado(HttpServletRequest request) {
		return getEstado(request) == EstadoSesion.SI_LOGEADO;
	}

	public static boolean hayEmpresaLogueado(HttpServletRequest request) {
		if (!hayUsuarioLogueado(request)) {
			return false;
		}
		return getUsuarioLogueado(request) instanceof com.webservices.controladores.publicar.DataEmpresa;
	}

	public static boolean hayPostulanteLogueado(HttpServletRequest request) {
		if (!hayUsuarioLogueado(request)) {
			return false;
		}
		return getUsuarioLogueado(request) instanceof com.webservices.controladores.publicar.DataPostulante;
	}

	public static com.webservices.controladores.publicar.DataUsuario getUsuarioLogueado(HttpServletRequest request) {
		return (com.webservices.controladores.publicar.DataUsuario) request.getSession().getAttribute("estadoSesion");
	}

	public static void setUsuarioLogueado(HttpServletRequest request, com.webservices.controladores.publicar.DataUsuario usuario) {
		request.getSession().setAttribute("estadoSesion", usuario);
	}
}
