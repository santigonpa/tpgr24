<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<%@ page import="com.webservices.controladores.publicar.Postulacion" %>
	<%@ page import="com.webservices.controladores.publicar.DataOferta" %>
	<%@ page import="com.webservices.controladores.publicar.DataPostulacion" %>
	<%@ page import="com.webservices.controladores.publicar.DataUsuario" %>
	<%@ page import="java.time.LocalDate" %>
	<%@page import ="java.util.Base64" %>
	<%@ page import="com.webservices.controladores.publicar.PublicadorManejadorOfertas" %>
	 <%@ page import="com.webservices.controladores.publicar.PublicadorManejadorOfertasService" %>
	<%@ page import="com.webservices.controladores.publicar.PublicadorManejadorUsuario" %>
	 <%@ page import="com.webservices.controladores.publicar.PublicadorManejadorUsuarioService" %>
	 
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="media/css/consultaPostulanteStyle.css" />
    <link rel="stylesheet" href="media/css/consultarEmpresaStyle.css" />
    <link rel="stylesheet" href="media/css/normalize.css" />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Fira+Sans+Condensed:wght@300;500;900&display=swap"
    />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@300;500;900&display=swap"
    />

    <link
      rel="icon"
      href="./img/logoNuevo.png"
      type="image/x-icon"
    />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
      crossorigin="anonymous"
    />
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <!-- esto capaz hay que sacarlo despues porque es la importacion del script de bootstrap y es un js y para la parte 1 no va-->
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
      crossorigin="anonymous"
    ></script>
    <title>TrabajoUY</title>
<head>
<meta charset="ISO-8859-1">
<body>
	<jsp:include page="/WEB-INF/template/headerLogged.jsp"></jsp:include>
	 <main>  
	   <%
	   	DataPostulacion post = (DataPostulacion) request.getAttribute("dtPost");
	   	String nombreO = post.getNombreOferta();
	   	
	   	PublicadorManejadorOfertasService servicePublicadorOfertas = new PublicadorManejadorOfertasService();
		PublicadorManejadorOfertas puertoManejadorOfertas = servicePublicadorOfertas.getPublicadorManejadorOfertasPort();
		PublicadorManejadorUsuarioService servicePublicadorUsuario = new PublicadorManejadorUsuarioService();
		PublicadorManejadorUsuario puertoManejadorUsuario = servicePublicadorUsuario.getPublicadorManejadorUsuarioPort();
		
	   	DataOferta ofertaLaboral = (DataOferta) puertoManejadorOfertas.getDataOferta(nombreO);
	   	

	   	DataUsuario user =  puertoManejadorUsuario.obtenerDataUsuario(post.getNickPostulante());
	   	String apellido = user.getApellido();
	   	String cvBreve = post.getCurri();
	   	String motivacion = post.getMotivacion();
	   	String fecha = post.getFecha();
	   	String nombrePostulante = post.getNickPostulante();
	   	String video = post.getVideo();
	   	
	   	
	   	byte[] imagenBytes = puertoManejadorUsuario.obtenerDataUsuario(post.getNickPostulante()).getImagen();
        String base64Image = "";
        if (imagenBytes != null) {
            base64Image = Base64.getEncoder().encodeToString(imagenBytes);
        }
	   
	   %>
	    
			<div class="row">
		<div class="col-6 col-md-4">
			<div class = "alinearImg3">
           
  				<img src="data:image/jpeg;base64, <%= base64Image %>" align = "absmiddle" class="img-thumbnail shadow" alt="...">
		
			</div>
		</div>
    	<div class="col-md-8">
			<div class="contenedor4">
				<h2 class="text-uppercase fs-4 fw-bolder">Información de la postulacion</h2>
			</div>
			<!--cargo datos-->
		  <div class = "contenedor4">
		  	<div class="row">
    			<div class="col">
      					<h4 class = "fs-5 fw=normal">Nombre de la oferta:</h4>
   				 </div>
    		<div class="col">
      					<h4 class = "fs-5 fw-lighter"><%= nombreO %></h4>
    		 </div>
  			</div>
  			<hr>
  			
  			<div class="row">
    			<div class="col">
      					<h4 class = "fs-5 fw=normal">Nombre del postulante:</h4>
   				 </div>
    		<div class="col">
      					<h4 class = "fs-5 fw-lighter"><%= nombrePostulante %></h4>
    		 </div>
  			</div>
  			<hr>
  			
  			<div class="row">
    			<div class="col">
      					<h4 class = "fs-5 fw=normal">CV:</h4>
   				 </div>
    			<div class="col">
      					<h4 class = "fs-5 fw-lighter"> <%= cvBreve %></h4>
    		 	</div>
  		 	</div>
  		 	<hr>
  		 	
		  	<div class="row">
    			<div class="col">
      					<h4 class = "fs-5 fw=normal">Motivación:</h4>
   				 </div>
    		<div class="col">
      					<h4 class = "fs-5 fw-lighter"><%= motivacion %></h4>
    		 </div>
  			</div>
  			<hr>
  			
  			<div class="row">
    			<div class="col">
      					<h4 class = "fs-5 fw=normal">Fecha de postulación:</h4>
   				 </div>
    			<div class="col">
      					<h4 class = "fs-5 fw-lighter"><%= fecha %></h4>
    		 	</div>
  		 	</div>
  		 	<hr>
  		 	
  		 	
  		 	<div class="row">
    			<div class="col">
      					<h4 class = "fs-5 fw=normal">Video de la postulación:</h4>
   				 </div>
   				 <div class = "my-3"></div>
    			<%
    			if(!(video == null) ) {
    			%>
    			<div class="col">
      					<iframe width="873" height="491" src="<%= video %>"  frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
    		 	</div>
    		 	<%
    			}else{
    		 	%>
    		 	<div class="col">
      					<h4 class = "fs-5 fw-lighter">No tiene video asociado a la postulación o envió un link incorrecto.</h4>
    		 	</div>
    		 	<%
    		 	}
    			%>
  		 	</div>
  		 	<hr>
  		 	
  			

			
  		</div>
  		</div>
	</div>
	    </main>
		<jsp:include page="/WEB-INF/template/footer.jsp"></jsp:include>
</body>
</html>