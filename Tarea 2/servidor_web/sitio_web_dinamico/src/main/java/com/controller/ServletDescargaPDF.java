package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.webservices.controladores.publicar.DataOferta;
import com.webservices.controladores.publicar.DataPostulacion;
import com.webservices.controladores.publicar.DataPostulante;
import com.webservices.controladores.publicar.PublicadorManejadorOfertas;
import com.webservices.controladores.publicar.PublicadorManejadorOfertasService;
import com.webservices.controladores.publicar.PublicadorManejadorUsuario;
import com.webservices.controladores.publicar.PublicadorManejadorUsuarioService;
import com.webservices.controladores.publicar.WrapperArrayList;

@WebServlet (description = "Servlet seleccionar Postulacion a Oferta Laboral", urlPatterns = { "/DescargaPDF" })
public class ServletDescargaPDF extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	private PublicadorManejadorOfertasService servicePublicadorManejadorOfertas = new PublicadorManejadorOfertasService();
	private PublicadorManejadorOfertas puertoManejadorOfertas = servicePublicadorManejadorOfertas.getPublicadorManejadorOfertasPort();
	private PublicadorManejadorUsuarioService servicePublicadorManejadorUsuarios = new PublicadorManejadorUsuarioService();
	private PublicadorManejadorUsuario puertoManejadorUsuarios = servicePublicadorManejadorUsuarios.getPublicadorManejadorUsuarioPort();

    public ServletDescargaPDF() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String nombreOferta = request.getParameter("nombreOferta");
		String nickPostulante = request.getParameter("nombrePostulante");
		DataOferta oferta = puertoManejadorOfertas.getDataOferta(nombreOferta);
		String fechaDeResultados = oferta.getFechaCalif();
		DataPostulante dataPostulante = puertoManejadorUsuarios.getDataPostulante(nickPostulante);
		String nombrePostulante = dataPostulante.getNombre();
		String apellidoPostulante = dataPostulante.getApellido();
		
		
		String nombreOfer = oferta.getNombre();
		String nombreEmpresa = oferta.getEmpresa();		
		
		WrapperArrayList wrap = puertoManejadorOfertas.getOrdenPostulantes(nombreOfer);
	    List<Object> ordenPostulantes = (List<Object>) wrap.getLista();
	    ArrayList<String> ordenPostulaciones = new ArrayList<>();
	    for(Object objetoPostu :ordenPostulantes){
	    	String objString = (String) objetoPostu;
	  		ordenPostulaciones.add(objString);
	    }
		String resultado = "No obtuvo resultado";
		int iterando = 1;
		for(String nombrePostu : ordenPostulaciones) {
			if(nombrePostu.equals(nickPostulante)) {
				resultado = String.valueOf(iterando);
				break;
			}
			iterando = iterando + 1;
		} 
		
		
		
		List<Object> listaObjetos = puertoManejadorUsuarios.obtenerDataPostulaciones(nickPostulante).getLista();
		ArrayList<DataPostulacion> postulacionesDeUsuario = new ArrayList<>();

		for (Object objeto : listaObjetos) {
		    if (objeto instanceof DataPostulacion) {
		        postulacionesDeUsuario.add((DataPostulacion) objeto);
		    }
		}

    	
		DataPostulacion dtPost = null;
		for(DataPostulacion postula : postulacionesDeUsuario) {
			if(postula.getNombreOferta().equals(nombreOfer)) {dtPost = postula;}
		}
		
		String fechaPostulacion = dtPost.getFecha();
		
		// Configura la respuesta HTTP para indicar que se está generando un documento PDF
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=resultado_postulacion"+nombreOfer+"_"+nickPostulante+".pdf");

		
		
		try {
		
		// Crea el documento PDF
		Document document = new Document();
		PdfWriter.getInstance(document, response.getOutputStream());

		// Abre el documento para escribir contenido
		document.open();

		// Agrega contenido al PDF
		document.add(new Paragraph("Nombre del Postulante: " + nombrePostulante));
		document.add(new Paragraph("Apellido del Postulante: " + apellidoPostulante));
		document.add(new Paragraph("Nombre de la Empresa: " + nombreEmpresa ));
		document.add(new Paragraph("Nombre de la Oferta: " + nombreOfer ));
		document.add(new Paragraph("Resultado de la Postulacion: " + resultado ));
		document.add(new Paragraph("Fecha De La Postulacion: " + fechaPostulacion ));
		document.add(new Paragraph("Fecha De Los Resultados: " + fechaDeResultados ));
		
		// Cierra el documento
		document.close();
		
		
	}catch(Exception e) {
		e.printStackTrace();
		// podriamos redireccionar a una pagina de error de ser necesario, no debería
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
