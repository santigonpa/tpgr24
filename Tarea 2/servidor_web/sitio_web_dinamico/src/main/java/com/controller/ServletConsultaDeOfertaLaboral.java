package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.webservices.controladores.publicar.DataOferta;
import com.webservices.controladores.publicar.Postulante;
import java.io.IOException;
import java.util.ArrayList;
import com.model.EstadoSesion;
import com.webservices.controladores.publicar.PublicadorManejadorOfertas;
import com.webservices.controladores.publicar.PublicadorManejadorOfertasService;
import com.webservices.controladores.publicar.PublicadorManejadorUsuario;
import com.webservices.controladores.publicar.PublicadorManejadorUsuarioService;

/**
 * Servlet implementation class ServletConsultaDeOfertaLaboral
 */
@WebServlet (description = "Servlet de Consulta de oferta laboral", urlPatterns = { "/ConsultaDeOfertaLaboral" })
@MultipartConfig
public class ServletConsultaDeOfertaLaboral extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private PublicadorManejadorOfertasService servicePublicadorManejadorOfertas = new PublicadorManejadorOfertasService();
	private PublicadorManejadorOfertas puertoManejadorOfertas = servicePublicadorManejadorOfertas.getPublicadorManejadorOfertasPort();
	private PublicadorManejadorUsuarioService servicePublicadorUsuario = new PublicadorManejadorUsuarioService();
	private PublicadorManejadorUsuario puertoManejadorUsuario = servicePublicadorUsuario.getPublicadorManejadorUsuarioPort();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConsultaDeOfertaLaboral() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static EstadoSesion getEstado(HttpServletRequest request){	//obtiene el tipo de la sesion
  		return (EstadoSesion) request.getSession().getAttribute("estadoSesion");
  		
  	}

    protected void cargarDatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    		boolean banderaSesion;
    		if (getEstado(request) != null) {
    			banderaSesion = getEstado(request).equals(EstadoSesion.SI_LOGEADO);
    		}else {
    			banderaSesion = false;
    		}
			boolean banderaPostulante = request.getSession().getAttribute("usuario") instanceof Postulante;
			String empresaSeleccionada = request.getParameter("empresa");
			String keywordSeleccionada = request.getParameter("keyword");
			
			if(banderaSesion && banderaPostulante) {
				if(empresaSeleccionada != null) {
					ArrayList<Object> coleccionOferWrapper = (ArrayList<Object>)  puertoManejadorUsuario.obtenerOfertasConfirmadasDeEmpresa(empresaSeleccionada).getLista();
					ArrayList<DataOferta> coleccionOfer = new ArrayList<>();
			    	for (Object objeto : coleccionOferWrapper) {
					    if (objeto instanceof DataOferta) {
					    	DataOferta dataOferta = (DataOferta) objeto;
					    	coleccionOfer.add(dataOferta);
					    }
					}
					request.setAttribute("coleccionOfertas", coleccionOfer);
					request.getRequestDispatcher("/WEB-INF/ofertasLaborales/consultaDeOfertasLaboralesPost.jsp").forward(request,response);

				}else if(keywordSeleccionada != null){
					ArrayList<Object> coleccionOferWrapper = (ArrayList<Object>)  puertoManejadorOfertas.obtenerOfertasConfirmadasPorKey(keywordSeleccionada).getLista();
					ArrayList<DataOferta> coleccionOfer = new ArrayList<>();
			    	for (Object objeto : coleccionOferWrapper) {
					    if (objeto instanceof DataOferta) {
					    	DataOferta dataOferta = (DataOferta) objeto;
					    	coleccionOfer.add(dataOferta);
					    }
					}
					request.setAttribute("coleccionOfertas", coleccionOfer);
					request.getRequestDispatcher("/WEB-INF/ofertasLaborales/consultaDeOfertasLaboralesPost.jsp").forward(request,response);

			
				}else {
					request.getRequestDispatcher("/WEB-INF/ofertasLaborales/consultaDeOfertasLaboralesPost.jsp").forward(request,response);
				}
			}
			if(banderaSesion && !banderaPostulante){
					if(empresaSeleccionada != null) {
						ArrayList<Object> coleccionOferWrapper = (ArrayList<Object>)  puertoManejadorUsuario.obtenerOfertasConfirmadasDeEmpresa(empresaSeleccionada).getLista();
						ArrayList<DataOferta> coleccionOfer = new ArrayList<>();
				    	for (Object objeto : coleccionOferWrapper) {
						    if (objeto instanceof DataOferta) {
						    	DataOferta dataOferta = (DataOferta) objeto;
						    	coleccionOfer.add(dataOferta);
						    }
						}
						request.setAttribute("coleccionOfertas", coleccionOfer);
						request.getRequestDispatcher("/WEB-INF/ofertasLaborales/consultaDeOfertasLaboralesEmp.jsp").forward(request,response);

					}else if(keywordSeleccionada != null){
						ArrayList<Object> coleccionOferWrapper = (ArrayList<Object>)  puertoManejadorOfertas.obtenerOfertasConfirmadasPorKey(keywordSeleccionada).getLista();
						ArrayList<DataOferta> coleccionOfer = new ArrayList<>();
				    	for (Object objeto : coleccionOferWrapper) {
						    if (objeto instanceof DataOferta) {
						    	DataOferta dataOferta = (DataOferta) objeto;
						    	coleccionOfer.add(dataOferta);
						    }
						}
						request.setAttribute("coleccionOfertas", coleccionOfer);
						request.getRequestDispatcher("/WEB-INF/ofertasLaborales/consultaDeOfertasLaboralesEmp.jsp").forward(request,response);

				
					}else {
						request.getRequestDispatcher("/WEB-INF/ofertasLaborales/consultaDeOfertasLaboralesEmp.jsp").forward(request,response);
					}
			}	
			
			if(!banderaSesion) {
				if(empresaSeleccionada != null) {
					ArrayList<Object> coleccionOferWrapper = (ArrayList<Object>) puertoManejadorUsuario.obtenerOfertasConfirmadasDeEmpresa(empresaSeleccionada).getLista();
					ArrayList<DataOferta> coleccionOfer = new ArrayList<>();
			    	for (Object objeto : coleccionOferWrapper) {
					    if (objeto instanceof DataOferta) {
					    	DataOferta dataOferta = (DataOferta) objeto;
					    	coleccionOfer.add(dataOferta);
					    }
					}
					request.setAttribute("coleccionOfertas", coleccionOfer);
					request.getRequestDispatcher("/WEB-INF/ofertasLaborales/consultaDeOfertasLaborales.jsp").forward(request,response);

				}else if(keywordSeleccionada != null){
					ArrayList<Object> coleccionOferWrapper = (ArrayList<Object>) puertoManejadorOfertas.obtenerOfertasConfirmadasPorKey(keywordSeleccionada).getLista();
					ArrayList<DataOferta> coleccionOfer = new ArrayList<>();
			    	for (Object objeto : coleccionOferWrapper) {
					    if (objeto instanceof DataOferta) {
					    	DataOferta dataOferta = (DataOferta) objeto;
					    	coleccionOfer.add(dataOferta);
					    }
					}
					request.setAttribute("coleccionOfertas", coleccionOfer);
					request.getRequestDispatcher("/WEB-INF/ofertasLaborales/consultaDeOfertasLaborales.jsp").forward(request,response);

				
				}else {
					request.getRequestDispatcher("/WEB-INF/ofertasLaborales/consultaDeOfertasLaborales.jsp").forward(request,response);
				}
			}
			
			
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		cargarDatos(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
