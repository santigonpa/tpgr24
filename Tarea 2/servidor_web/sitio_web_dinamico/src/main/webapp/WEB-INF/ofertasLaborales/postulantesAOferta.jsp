<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@page import= "com.webservices.controladores.publicar.DataPostulacion" %>
    <%@page import= "com.webservices.controladores.publicar.Postulacion" %>
    <%@page import = "java.io.FileOutputStream" %>
    <%@page import  = "java.io.IOException" %>
    <%@page import ="java.util.Base64" %>
    <%@page import="java.util.ArrayList" %>  
      
    <link rel="stylesheet" href="consultaPostulanteStyle.css" />
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
</head>
<body>

		<jsp:include page="/WEB-INF/template/headerLogged.jsp"></jsp:include>
	<main>	
	 <%
		 String nombreOfer = (String) request.getAttribute("nombreOferta");
	 %>		
		<div class="contenedor">
			<h2 class="text-uppercase fs-4 fw-bolder">Usuarios postulados a <%= nombreOfer %></h2>
		</div>
		
		<div class="cartas">
			    <%
			    
			    ArrayList<String> conjuntoDePost = (ArrayList<String>) request.getAttribute("postulantes");
			    
			    if(!conjuntoDePost.isEmpty()){
			    
			        String nombre;
			        
			
			        for (String post : conjuntoDePost) {
			            nombre = post;
			            
			    %>
			
			    
			    <div class="card" style="width: 18rem;">
  					
	  				 <div class="card-body">
	    				<p class="card-text"><strong><%= post %></strong></p>
						<a href="ServletConsultaDePostulacionAOfertaLaboral?id=<%= nombreOfer %>&user=<%= post %>" class="btn btn-outline-dark">Informacion postulacion</a>
	  				 </div>
				</div>
				
			    <%
			        	}
			        
			        %>  
			    	
			    	</div>
			    
			    <% 
			    }else{     	
			        	%>
						    <div class="contendor2">	 
						    <div class="carta" style="width: 98vw;">       
							            <div class="alert alert-danger" role="alert">
							            	<div class = "text-center"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></div>
							            	<hr>
							                Hasta el momento ningún usuario se ha postulado
							            </div>
							        </div>
						</div>
						<% 
			        }
			    %>
			</main>
			<jsp:include page="/WEB-INF/template/footer.jsp"></jsp:include>
		
</body>
</html>