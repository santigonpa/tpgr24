<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import= "com.webservices.controladores.publicar.DataTipoPublicacion" %>
    <%@page import= "java.util.ArrayList" %>
    <%@page import = "java.io.FileOutputStream" %>
    <%@page import  = "java.io.IOException" %>
    <%@page import ="java.util.Base64" %>
    
<!DOCTYPE html>
<html>
<head>
 	<meta charset="UTF-8">
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
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
     
      <script>
        jQuery(document).ready(function() {
            jQuery('.collapse').on('show.bs.collapse', function() {
                // Cerrar todos los elementos colapsables, excepto el que se está abriendo
                jQuery('.collapse').not(jQuery(this)).collapse('hide');
            });
        });
    </script>
<title>TrabajoUY</title>
</head>
<body>
	<jsp:include page="/WEB-INF/template/headerLogged.jsp"></jsp:include>
	<main>
	<div class="contenedor4">
  			<h2 class="-titulo-"><strong>Tipos de Publicación de Ofertas Laborales</strong></h2>
  			<hr>
		</div>	
	<div class="contenedor4">
		<div class="cartas">

				<%
			    
				ArrayList<DataTipoPublicacion> conjuntoDePaquetes = (ArrayList<DataTipoPublicacion>) request.getAttribute("coleccionDataPaquetes");
			    
			    if(conjuntoDePaquetes != null && !conjuntoDePaquetes.isEmpty()){
			    
			        String nombrePaquete;
			        String descripcion;
			        int exp;
			        int duracion;
			        float costo;
			        String fecha;
			
			        for (DataTipoPublicacion dataTP : conjuntoDePaquetes) {
			        	nombrePaquete = dataTP.getNombre();
			        	descripcion = dataTP.getDescripcion();
			        	exp = dataTP.getExposicion();
			        	duracion = dataTP.getDuracion();
			        	costo = dataTP.getCosto();
			        	fecha = dataTP.getFecha();
			    %>
				
			    <div class="card" style="width: 20rem;">
			   		<div style="overflow: hidden; width: 100%; height: 5rem;"> <!-- Corta la imagen -->
           	 			<img class="card-img-top" src="media/img/imagenTP3.jpg" alt="Card image cap" style="object-fit: cover; width: 100%; height: 100%;">
        			</div>
        			
			        <div class="card-body">
    						<h5 class="card-title"><strong><%= nombrePaquete %></strong></h5>
    						<p class="card-text"><%= descripcion %></p>
    						<hr>
    						<p class="card-text">Exposición: <%= exp %></p>
    						<p class="card-text">Duración: <%= duracion %></p>   						
    						<p class="card-text">Duración: <%= duracion %></p>
    						<p class="card-text">Costo: $<%= costo %></p>
    						<p class="card-text">Fecha de alta: <%= fecha %></p>
    						
    						
					</div>
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
							                Hasta el momento no hay tipos de publicación registrados en el sistema
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