package helpers;

import com.model.EstadoSesion;

import logica_DataTypes.DataEmpresa;
import logica_DataTypes.DataPostulante;
import logica_DataTypes.DataUsuario;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpServletRequest;


public class estadoSesionHelper {
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
		return getUsuarioLogueado(request) instanceof DataEmpresa;
	}

	public static boolean hayPostulanteLogueado(HttpServletRequest request) {
		if (!hayUsuarioLogueado(request)) {
			return false;
		}
		return getUsuarioLogueado(request) instanceof DataPostulante;
	}

	public static DataUsuario getUsuarioLogueado(HttpServletRequest request) {
		return (DataUsuario) request.getSession().getAttribute("estadoSesion");
	}

	public static void setUsuarioLogueado(HttpServletRequest request, DataUsuario usuario) {
		request.getSession().setAttribute("estadoSesion", usuario);
	}
}
