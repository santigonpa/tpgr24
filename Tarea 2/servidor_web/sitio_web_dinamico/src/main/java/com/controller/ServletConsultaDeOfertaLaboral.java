package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logica_DataTypes.DataOferta;
import logica_DataTypes.DataUsuario;
import logica_Entidades.OfertaLaboral;
import logica_Entidades.Postulante;
import logica_Manejadores.IManejadorOferta;
import logica_Manejadores.IManejadorUsuario;
import utils.Fabrica;

import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.model.EstadoSesion;

/**
 * Servlet implementation class ServletConsultaDeOfertaLaboral
 */
@WebServlet (description = "Servlet de Consulta de oferta laboral", urlPatterns = { "/ConsultaDeOfertaLaboral" })
@MultipartConfig
public class ServletConsultaDeOfertaLaboral extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Fabrica fab = Fabrica.getInstance();
    private IManejadorOferta IMO = fab.getInManejadorOferta();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConsultaDeOfertaLaboral() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static EstadoSesion getEstado(HttpServletRequest request)
  	{	//obtiene el tipo de la sesion
  		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
  		
  	}

    protected void cargarDatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    		boolean banderaSesion;
    		if(getEstado(request) != null) {
    			banderaSesion = getEstado(request).equals(EstadoSesion.SI_LOGEADO);
    		}else {
    			banderaSesion = false;
    		}
			boolean banderaPostulante = request.getSession().getAttribute("usuario") instanceof Postulante;
			String empresaSeleccionada = request.getParameter("empresa");
			String keywordSeleccionada = request.getParameter("keyword");
			
			if(banderaSesion && banderaPostulante) {
				if(empresaSeleccionada != null) {
			    	Set<DataOferta> coleccionOfer = fab.getInManejadorUsuario().obtenerOfertasConfirmadasDeEmpresa(empresaSeleccionada);
					request.setAttribute("coleccionOfertas", coleccionOfer);
					request.getRequestDispatcher("/WEB-INF/ofertasLaborales/consultaDeOfertasLaboralesPost.jsp").forward(request,response);

				}else if(keywordSeleccionada != null){
					Set<DataOferta> coleccionOfer = IMO.obtenerOfertasConfirmadasPorKey(keywordSeleccionada);
					request.setAttribute("coleccionOfertas", coleccionOfer);
					request.getRequestDispatcher("/WEB-INF/ofertasLaborales/consultaDeOfertasLaboralesPost.jsp").forward(request,response);

			
				}else {
					request.getRequestDispatcher("/WEB-INF/ofertasLaborales/consultaDeOfertasLaboralesPost.jsp").forward(request,response);
				}
			}
			if(banderaSesion && !banderaPostulante){
					if(empresaSeleccionada != null) {
				    	Set<DataOferta> coleccionOfer = fab.getInManejadorUsuario().obtenerOfertasConfirmadasDeEmpresa(empresaSeleccionada);
						request.setAttribute("coleccionOfertas", coleccionOfer);
						request.getRequestDispatcher("/WEB-INF/ofertasLaborales/consultaDeOfertasLaboralesEmp.jsp").forward(request,response);

					}else if(keywordSeleccionada != null){
						Set<DataOferta> coleccionOfer = IMO.obtenerOfertasConfirmadasPorKey(keywordSeleccionada);
						request.setAttribute("coleccionOfertas", coleccionOfer);
						request.getRequestDispatcher("/WEB-INF/ofertasLaborales/consultaDeOfertasLaboralesEmp.jsp").forward(request,response);

				
					}else {
						request.getRequestDispatcher("/WEB-INF/ofertasLaborales/consultaDeOfertasLaboralesEmp.jsp").forward(request,response);
					}
			}	
			
			if(!banderaSesion) {
				if(empresaSeleccionada != null) {
			    	Set<DataOferta> coleccionOfer = fab.getInManejadorUsuario().obtenerOfertasConfirmadasDeEmpresa(empresaSeleccionada);
					request.setAttribute("coleccionOfertas", coleccionOfer);
					request.getRequestDispatcher("/WEB-INF/ofertasLaborales/consultaDeOfertasLaborales.jsp").forward(request,response);

				}else if(keywordSeleccionada != null){
					Set<DataOferta> coleccionOfer = IMO.obtenerOfertasConfirmadasPorKey(keywordSeleccionada);
					request.setAttribute("coleccionOfertas", coleccionOfer);
					request.getRequestDispatcher("/WEB-INF/ofertasLaborales/consultaDeOfertasLaborales.jsp").forward(request,response);

				
				}else {
					request.getRequestDispatcher("/WEB-INF/ofertasLaborales/consultaDeOfertasLaborales.jsp").forward(request,response);
				}
			}
			
			
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cargarDatos(request, response);
		
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
