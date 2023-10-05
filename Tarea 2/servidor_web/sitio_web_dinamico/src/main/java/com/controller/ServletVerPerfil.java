package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logica_DataTypes.DataEmpresa;
import logica_DataTypes.DataOferta;
import logica_DataTypes.DataPostulante;
import logica_DataTypes.DataUsuario;
import logica_Entidades.Postulante;
import logica_Entidades.Usuario;
import logica_Manejadores.IManejadorUsuario;
import utils.Fabrica;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import com.model.EstadoSesion;

@WebServlet (description = "Servlet de ver perfil de usuario", urlPatterns = { "/VerPerfil" })
public class ServletVerPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Fabrica fab = Fabrica.getInstance();
    private static IManejadorUsuario IMU = fab.getInManejadorUsuario()  ; 

    public ServletVerPerfil() {
        super();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
    	
    }
    
    public static EstadoSesion getEstado(HttpServletRequest request)
	{	//obtiene el tipo de la sesion
		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
	}

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuarioAConsultar = (String) request.getAttribute("VerPerfil");
		Map<String,DataUsuario> usuarios = IMU.getDataUsuario();
		DataUsuario usuarioConsultar = usuarios.get(usuarioAConsultar);
		String tipoUser;
		
		if(usuarioConsultar instanceof DataPostulante) {
			tipoUser = "Postulante";
		}else {
			tipoUser = "Empresa";
		}
		
		//seteamos en el request el usuario a consultar
		request.setAttribute("consultar", usuarioConsultar);
		
		if(	(getEstado(request) == EstadoSesion.SI_LOGEADO)  ) {
				
			Usuario user = (Usuario) request.getSession().getAttribute("usuario");
			if(user instanceof Postulante) {
				System.out.println("que hago en postulante xd");
					//Esta consultando su propio perfil
				
					if(user.getNickName().equals(usuarioAConsultar)) {
						request.getRequestDispatcher("/WEB-INF/usuarios/MiUsuarioPostulante.jsp").forward(request, response);
						
					}else {
						if(usuarioConsultar instanceof DataEmpresa) {
							Set<DataOferta> ofertasConfi = IMU.obtenerOfertasConfirmadasDeEmpresa(usuarioAConsultar);
							request.setAttribute("ofertasConfirmadas",ofertasConfi);
							Set<DataOferta> ofertasRech = IMU.obtenerOfertasRechazadasIngresadas(usuarioAConsultar);
							request.setAttribute("ofertasRyI",ofertasRech);
							request.getRequestDispatcher("/WEB-INF/usuarios/Consulta"+tipoUser+"Logged.jsp").forward(request, response);
						}else {
							request.getRequestDispatcher("/WEB-INF/usuarios/Consulta"+tipoUser+"Logged.jsp").forward(request, response);
						}
					}
						
				
				
				}else {//es empresa
					
					if(usuarioConsultar instanceof DataEmpresa) {
						Set<DataOferta> ofertasConfi = IMU.obtenerOfertasConfirmadasDeEmpresa(usuarioAConsultar);
						request.setAttribute("ofertasConfirmadas",ofertasConfi);
						Set<DataOferta> ofertasRech = IMU.obtenerOfertasRechazadasIngresadas(usuarioAConsultar);
						request.setAttribute("ofertasRyI",ofertasRech);
						if(user.getNickName().equals(usuarioAConsultar)) {	
						
						//Esta consultando su propio perfil
						request.getRequestDispatcher("/WEB-INF/usuarios/MiUsuarioEmpresa.jsp").forward(request, response);
						
						}else{//Esta consultando el perfil de otro
							request.getRequestDispatcher("/WEB-INF/usuarios/ConsultaEmpresaLogged.jsp").forward(request, response);
							
						}
					}else{
							request.getRequestDispatcher("/WEB-INF/usuarios/ConsultaPostulanteLogged.jsp").forward(request, response);	
					}
				}
					
		
		}else { // LA SESION NO ESTA INICIADA
			
			if(tipoUser.equals("Empresa")) {
				Set<DataOferta> ofertasConfi = IMU.obtenerOfertasConfirmadasDeEmpresa(usuarioAConsultar);
				request.setAttribute("ofertasConfirmadas",ofertasConfi);
			}
			
			request.getRequestDispatcher("/WEB-INF/usuarios/Consulta"+tipoUser+".jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
