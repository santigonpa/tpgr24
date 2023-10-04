package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logica_Entidades.Usuario;

import java.io.IOException;

import com.model.EstadoSesion;

public class ServletVerPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

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
		Usuario usr = (Usuario) request.getSession().getAttribute("estadoSesion");
		if(getEstado(request) == EstadoSesion.SI_LOGEADO && usr instanceOf  ) {
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
