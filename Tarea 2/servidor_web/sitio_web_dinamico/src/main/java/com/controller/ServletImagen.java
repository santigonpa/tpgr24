package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logica_Entidades.Usuario;

import java.io.IOException;


public class ServletImagen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ServletImagen() {
        super();

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Obtén el arreglo de bytes de la imagen desde la sesión
        HttpSession session = request.getSession(false);
        Usuario usr = (Usuario) session.getAttribute("usuario");
        byte[] imagenBytes = usr.getImagen();
        
        // Establece el tipo de contenido de la respuesta como una imagen
        response.setContentType("image/png"); // Cambia el tipo de contenido según el formato de tu imagen
        
        // Escribe los bytes de la imagen en la respuesta
        response.getOutputStream().write(imagenBytes);
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
