<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />	
	<link rel="stylesheet" href="media/css/indexStyle.css" />
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
    
        <%@ page import="com.webservices.controladores.publicar.PublicadorManejadorPyT" %>
     <%@ page import="com.webservices.controladores.publicar.PublicadorManejadorPyTService" %>
    <%@page import="java.util.Set" %>
    <%@page import = "java.io.FileOutputStream" %>
    <%@page import  = "java.io.IOException" %>
        <%@ page import="java.util.ArrayList" %>
    <%@ page import="java.util.List" %>
    <%@ page import="com.webservices.controladores.publicar.WrapperArrayList" %>
        <%@ page import="com.webservices.controladores.publicar.Paquete" %>
        <%@ page import="com.webservices.controladores.publicar.TipoPublicacion" %>
    <%@page import ="java.util.Base64" %>
        <%@ page import="com.webservices.controladores.publicar.DataPaquete" %>
    
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
      crossorigin="anonymous"
    ></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>  
      
    <title>TrabajoUY</title>
</head>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp"></jsp:include>
	<main>
	<%
        // Recupera la ofertaSeleccionada de la solicitud
        DataPaquete paqueteDet = (DataPaquete) request.getAttribute("paquete");
	 	String nombre = paqueteDet.getNombre();
	 	String descripcion = paqueteDet.getDescripcion();
	 	int validez = paqueteDet.getValidez();
	 	String fechaAlta = paqueteDet.getFechadealta(); 
	 	int descuento = paqueteDet.getDescuento();
	 	float costo = paqueteDet.getCosto();
	 	
	 	byte[] imagenBytes = paqueteDet.getImagen();
        String base64Image = "";
        if (imagenBytes != null) {
            base64Image = Base64.getEncoder().encodeToString(imagenBytes);
        }

    %>
	
	<div class="contenedor4">
	  		<h2 class="-titulo-"><strong>Paquete de Tipo de Publicación de Ofertas Laborales</strong></h2>
	  		<hr>
		</div>
	
	<div class = "contenedor4">

  		<div class="row">
		<div class="col-6 col-md-4">
			<div class = "alinearImg3">
           
  				<img src="data:image/jpeg;base64, <%= base64Image %>" align = "absmiddle" class="img-thumbnail shadow" alt="...">
		
			</div>
		</div>
    	<div class="col-md-8">
			<div class="contenedor4">
				<h2 class="text-uppercase fs-4 fw-bolder">Información del paquete</h2>
			</div>
			<!--cargo datos-->
		  <div class = "contenedor4">
		  	<div class="row">
    			<div class="col">
      					<h4 class = "fs-5 fw=normal">Nombre:</h4>
   				 </div>
    		<div class="col">
      					<h4 class = "fs-5 fw-lighter"><%=nombre %> </h4>
    		 </div>
  			</div>
  			<hr>
  			
  			<div class="row">
    			<div class="col">
      					<h4 class = "fs-5 fw=normal">Descripción:</h4>
   				 </div>
    			<div class="col">
      					<h4 class = "fs-5 fw-lighter"><%= descripcion %></h4>
    		 	</div>
  		 	</div>
  		 	<hr>
    
    		<div class="row">
    			<div class="col">
      					<h4 class = "fs-5 fw=normal">Período:</h4>
   				 </div>
    			<div class="col">
      					<h4 class = "fs-5 fw-lighter"><%= validez %> días</h4>
    		 	</div>
  		 	</div>
  		 	<hr>
    
    		<div class="row">
    			<div class="col">
      					<h4 class = "fs-5 fw=normal">Descuento:</h4>
   				 </div>
    			<div class="col">
      					<h4 class = "fs-5 fw-lighter"><%= descuento %> % </h4>
    		 	</div>
  		 	</div>
  		 	<hr>
    
    		<div class="row">
    			<div class="col">
      					<h4 class = "fs-5 fw=normal">Fecha:</h4>
   				 </div>
    			<div class="col">
      					<h4 class = "fs-5 fw-lighter"><%= fechaAlta %></h4>
    		 	</div>
  		 	</div>
  		 	<hr>
    
    		<div class="row">
    			<div class="col">
      					<h4 class = "fs-5 fw=normal">Costo:</h4>
   				 </div>
    			<div class="col">
      					<h4 class = "fs-5 fw-lighter">$ <%= costo %></h4>
    		 	</div>
  		 	</div>
    
  		  </div>
		</div>
	</div>
</div>
	
	</main>
	<jsp:include page="/WEB-INF/template/footer.jsp"></jsp:include>
</body>
</html>