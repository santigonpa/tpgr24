<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          
    <%@page import= "logica_DataTypes.DataOferta" %>
    <%@page import="java.util.Set" %>
    <%@page import = "java.io.FileOutputStream" %>
    <%@page import  = "java.io.IOException" %>
    <%@page import ="java.util.Base64" %>
    
    
<!DOCTYPE html>
<html lang = "es">
<head>

<meta charset="UTF-8" />
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
    
    <link rel="stylesheet" href="media/css/altaOfLabStyle.css" />
    <link rel="stylesheet" href="media/css/normalize.css" />
    <link rel="stylesheet" href="media/css/indexStyle.css" />
    
    
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <!-- esto capaz hay que sacarlo despues porque es la importacion del script de bootstrap y es un js y para la parte 1 no va-->
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
      crossorigin="anonymous"
    ></script>





    <title>Ofertas Laborales</title>
	</head>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp"></jsp:include>
	
	<main>
				<div class="contenedor4">
			  		<h2 class="titulo"><strong>Ofertas Laborales</strong></h2>
			  		<p>
			  		<hr>
			  		</p>
				</div>
				<div class = "contenedorPrincipal">
				<div class="contenedor4">
			  		<div class="row">
			   		<div class="col">
			      		<select class="form-select" aria-label="Default select example">
			  				<option selected>Filtrar por empresa</option>
			  				<option value="1">EcoTech</option>
						</select>
			    	</div>
			    	<div class="col">
			      		<select class="form-select" aria-label="Default select example">
			  				<option selected>Filtrar por keyword</option>
			  				<option value="k1">Tiempo completo</option>
			  				<option value="k2">Medio tiempo</option>
			  				<option value="k3">Remoto</option>
			  				<option value="k3">Freelance</option>
			  				<option value="k1">Temporal</option>
			  				<option value="k2">Permanente</option>
			
						</select>
			    	</div>
			  	</div>
				</div>
				</div>
			
				<div class="cartas">

				<%
			    
				Set<DataOferta> conjuntoDeOfertas = (Set<DataOferta>) request.getAttribute("coleccionDataOfertas");
			    
			    if(conjuntoDeOfertas != null && !conjuntoDeOfertas.isEmpty()){
			    
			        String nombreOfer;
			        String descripcion;
			        byte[] imagenBytes;
			
			        for (DataOferta dataOfer : conjuntoDeOfertas) {
			            nombreOfer = dataOfer.getNombre();
						descripcion = dataOfer.getDescripcion();
			            imagenBytes = dataOfer.getImagen();
			            
			            String base64Image = "";
			            if (imagenBytes != null) {
			                base64Image = Base64.getEncoder().encodeToString(imagenBytes);
			            }else{
			            	//aca va la imagen default
			            }
			            
			            
			    %>
				
			    <div class="card" style="width: 20rem;">
			        <img class="card-img-top" src="data:image/jpeg;base64, <%= base64Image %>" alt="imagen de usuario" style="object-fit: cover; width: 100%; height: 100%;">
			        <div class="card-body">
    						<h5 class="card-title"><%= nombreOfer %></h5>
    						<p class="card-text"><%= descripcion %></p>
							<a href="ServletDetalleOferta?id=<%= dataOfer.getNombre() %>" class="btn btn-outline-dark">+info</a>					</div>
		    	</div>
			    
			    <%
			        	}
			        
			        %>  
			    	
			    	</div>
			    
			    <% 
			    }else{
			        	
			        	%>
			           
			           
			             
						    <div class="container">
							    <div class="row">
							        <div class="col text-center">
							            <div class="alert alert-danger" role="alert">
							                No hay ofertas registradas en la p�gina hasta el momento
							            </div>
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