package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logica_DataTypes.DataUsuario;
import logica_Entidades.Usuario;
import logica_Manejadores.IManejadorUsuario;
import utils.Fabrica;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.model.EstadoSesion;

/**
 * Servlet implementation class ServletConsultaUsuario
 */
@WebServlet (description = "Servlet de Consulta de usuario", urlPatterns = { "/ConsultarUsuario" })
public class ServletConsultaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Fabrica fab = Fabrica.getInstance();
    private IManejadorUsuario IMU = fab.getInManejadorUsuario();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConsultaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    public static EstadoSesion getEstado(HttpServletRequest request)
	{	//obtiene el tipo de la sesion
		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
		
	}
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map<String,DataUsuario> usuarios =  IMU.getDataUsuario();
		Set<String> claves = usuarios.keySet();
		Set<DataUsuario> usuariosColeccion = new HashSet<DataUsuario>();
		for(String clave : claves ) {
			usuariosColeccion.add(usuarios.get(clave));
		}
		request.setAttribute("coleccionDataUsuarios", usuariosColeccion);
		
		if(getEstado(request) == EstadoSesion.SI_LOGEADO) {
			//hace algo si el usuario esta correctamente logeado de una forma
			
			
			request.getRequestDispatcher("/WEB-INF/usuarios/consultaUsuariosLogged.jsp").forward(request,response);
		
		
		}else {
			//hace otra cosa dependiendo si el usuario no esta logeado
			
			
			request.getRequestDispatcher("/WEB-INF/usuarios/consultaUsuarios.jsp").forward(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("VerPerfil").forward(request, response);
	}

}
