package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.webservices.controladores.publicar.DataUsuario;
import com.webservices.controladores.publicar.PublicadorManejadorUsuario;
import com.webservices.controladores.publicar.PublicadorManejadorUsuarioService;

/**
 * Servlet implementation class ValidacionAjax
 */
@WebServlet(description = "Servlet de validacion", urlPatterns = { "/ValidacionDeAjax" })
@MultipartConfig

public class ValidacionAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PublicadorManejadorUsuarioService servicePublicadorManUsuario = new PublicadorManejadorUsuarioService();
	private PublicadorManejadorUsuario puertoManejadorUsuario = servicePublicadorManUsuario.getPublicadorManejadorUsuarioPort();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ValidacionAjax() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("checkNickname".equals(action)) {
            String nickname = request.getParameter("nickname");       
            DataUsuario nuevo = puertoManejadorUsuario.obtenerDataUsuario(nickname);
            String respuesta;
            if(nuevo.getNickName().equals("null")) {
            	respuesta = "Nickname disponible.";
            } else {
            	respuesta = "El nickname ingresado se encuentra en uso, por favor ingrese otro.";
            }
            response.getWriter().write(respuesta); 
        } else if ("checkEmail".equals(action)) {
            String email = request.getParameter("correo"); 
            DataUsuario nuevo2 = puertoManejadorUsuario.obtenerDataUsuarioPorEmail(email);
            String respuesta2;
            if(nuevo2.getNickName().equals("null")) {
            	respuesta2 = "Correo disponible.";
            } else {
            	respuesta2 = "El correo ingresado se encuentra en uso, por favor ingrese otro.";
            }
            response.getWriter().write(respuesta2); 
        }
    }
}