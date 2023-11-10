<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          
        <%@ page import="com.webservices.controladores.publicar.PublicadorManejadorPyT" %>
     <%@ page import="com.webservices.controladores.publicar.PublicadorManejadorPyTService" %>
    <%@page import="java.util.Set" %>
    <%@page import = "java.io.FileOutputStream" %>
    <%@page import  = "java.io.IOException" %>
        <%@ page import="java.util.ArrayList" %>
    <%@ page import="java.util.List" %>
    <%@ page import="com.webservices.controladores.publicar.WrapperArrayList" %>
        <%@ page import="com.webservices.controladores.publicar.Usuario" %>
        <%@ page import="com.webservices.controladores.publicar.TipoPublicacion" %>
    
    <%@page import ="java.util.Base64" %>
        <%@ page import="com.webservices.controladores.publicar.DataPaquete" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<!-- Estilos -->
    <link rel="stylesheet" href="media/css/normalize.css" />
    <link rel="stylesheet" href="media/css/consultaUsuarioStyle.css" />
	
	<link rel="stylesheet"
		href="https://fonts.googleapis.com/css2?family=Fira+Sans+Condensed:wght@300;500;900&display=swap" />
	<link rel="stylesheet"
		href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@300;500;900&display=swap" />
	
	<link rel="icon" href="./img/logoNuevo.png" type="image/x-icon" />
	
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
		crossorigin="anonymous" />
	
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<!-- esto capaz hay que sacarlo despues porque es la importacion del script de bootstrap y es un js y para la parte 1 no va-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp"></jsp:include>
	<main>
	<div class="contenedor4">
	  		<h2 class="-titulo-"><strong>Paquetes de Tipos de Publicación de Ofertas Laborales</strong></h2>
	  		<hr>
		</div>
		<div class="contenedor4">
			<div class="cartas">

				<%
                ArrayList<DataPaquete> listaDePaquetes = (ArrayList<DataPaquete>) request.getAttribute("coleccionDataPaquetes");
                
                if (listaDePaquetes != null && !listaDePaquetes.isEmpty()) {
                    for (DataPaquete dataTP : listaDePaquetes) {
                        String nombreOfer = dataTP.getNombre();
                        byte[] imagenBytes = dataTP.getImagen();
                        imagenBytes = dataTP.getImagen();
			            
			            String base64Image = "";
			            if (imagenBytes != null) {
			                base64Image = Base64.getEncoder().encodeToString(imagenBytes);
			            }else{
			            	//aca va la imagen default
			            }
            %>
				
			    <div class="card" style="width: 20rem;">				
			    <img class="card-img-top" src="data:image/jpeg;base64, <%= base64Image %>" alt="imagen de paquete" style="object-fit: cover; width: 100%; height: 100%;">
			        <div class="card-body">
    						<h5 class="card-title"><strong><%= nombreOfer %></strong></h5>
    						<hr>
							<a href="ServletPaqueteDetallado?id=<%= dataTP.getNombre() %>" class="btn btn-outline-dark">Más información</a>					</div>
		    	</div>
			    
			    <%
			        	}
			        
			        %>  
			    	
			    	</div>
			    </div>
			    <% 
			    }else{ 	
			        	%>
						    <div class="contendor2">	 
						    <div class="carta" style="width: 88vw;">       
							            <div class="alert alert-danger" role="alert">
							            	<div class = "text-center"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></div>
							            	<hr>
							                Hasta el momento no hay paquetes registrados en el sistema
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