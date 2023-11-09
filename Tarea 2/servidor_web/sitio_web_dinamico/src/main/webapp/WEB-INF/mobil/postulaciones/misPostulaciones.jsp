<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@page import="java.util.ArrayList" %>
     <%@page import= "com.webservices.controladores.publicar.DataOferta" %>
      <%@page import ="java.util.Base64" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="media/css/indexStyle.css" />
    <link rel="stylesheet" href="media/css/normalize.css" />
    <link rel="stylesheet" href="media/css/consultaUsuarioStyle.css" />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Fira+Sans+Condensed:wght@300;500;900&display=swap"
    />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@300;500;900&display=swap"
    />

	<link rel="icon" href="./img/logoNuevo.png" type="image/x-icon" />

    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
      crossorigin="anonymous"
    />
  
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <!-- esto capaz hay que sacarlo despues porque es la importacion del script de bootstrap y es un js y para la parte 1 no va-->
	
	<!-- Estilos -->
    <link rel="stylesheet" href="media/css/normalize.css" />
    <link rel="stylesheet" href="media/css/consultaUsuarioStyle.css" />

    <!-- Bootstrap -->
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
      href="media/img/logoNuevo.png"
      type="image/x-icon"
    />
	
    <link
      rel="icon"
      href="C:/Users/Usuario/git/tpgr24/Tarea 2/servidor_web/img/logoNuevo.png"
      type="image/x-icon"
    />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
      crossorigin="anonymous"
    />
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
      crossorigin="anonymous"
    ></script>
    
<title>TrabajoUY</title>
</head>
<body>
	<%@ include file="../templates_movil/headerLogged_movil.jsp" %>
	<main>
	
	<div class = "texto-of">
	    		<h2 class="h1 fw-bold text-center pt-5 pb-2">Mis Postulaciones</h2>
	    		</div> 
	<% 
		ArrayList<DataOferta> ofertasDePostulacion = (ArrayList<DataOferta>) request.getAttribute("coleccionPostulaciones");

		if(!ofertasDePostulacion.isEmpty()){
	    	  
	      %>
	       	 <div class="container">
		     	 <div class= "cartas-ofertas d-flex flex-column align-items-center px-2">
		     	 
					<%
				        String nombreOf;
				        byte[] imagenOfByte;
				        for(DataOferta oferta: ofertasDePostulacion) {
				            nombreOf = oferta.getNombre();
				            imagenOfByte = oferta.getImagen();
				
				            String base64ImagenOf = Base64.getEncoder().encodeToString(imagenOfByte);
				            
				    %>
					
					<div class="card bg-light w-100">
				  <img src="data:image/jpeg;base64, <%= base64ImagenOf %>" class="card-img-top" alt="imagen de usuario">
				  <div class="card-body">
				    <h5 class="card-title" style="color: black;"><%= nombreOf %></h5>
				    <p> </p>
				    
				    <a href="/TrabajoUY/ServletVerPostulacion_movil?id=<%= nombreOf %>" class="btn btn-dark">Ver más de la postulación</a>
				  </div>
				</div>
				<% } %>
			
				</div>
		<% }else{ %>
			<p>Actualmente no se postuló a ninguna oferta.</p>
		<%} %>
		   
		</div>	
		
	</main>
	<jsp:include page="/WEB-INF/mobil/templates_movil/footerMovil.jsp"></jsp:include>
</body>
</html>