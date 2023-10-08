<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

	<%@ page import="logica_entidades.Postulacion" %>
	<%@ page import="logica_entidades.OfertaLaboral" %>
	<%@ page import="logica_datatypes.DataPostulacion" %>
	<%@ page import="java.time.LocalDate" %>
	<%@page import ="java.util.Base64" %>
	
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="consultaPostulanteStyle.css" />
    <link rel="stylesheet" href="consultarEmpresaStyle.css" />
    <link rel="stylesheet" href="normalize.css" />
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
	   
	   <%
	   	Postulacion post = (Postulacion) request.getAttribute("dtPost");
	   	String nombreO = post.getNombreOfer();
	   	
	   	OfertaLaboral ofertaLaboral = post.getOferta();
	   	
	   	
	   	String apellido = post.getNombreOfer();
	   	String cvBreve = post.getCV();
	   	String motivacion = post.getMotivacion();
	   	LocalDate fecha = post.getFecha();
	   	String nombrePostulante = post.getNombrePostulante();
	   	
	   	byte[] imagenBytes = post.getPostulante().getImagen();
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
  		 	
  		 	
  		 	
  		 	
  			

			
  		</div>
  		</div>
	</div>
	    
</body>
</html>