<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
    <%@ page import="logica_datatypes.DataOferta" %>
    <%@ page import="java.time.LocalTime" %>
    <%@ page import="java.time.LocalDate" %>
    <%@ page import="logica_entidades.OfertaLaboral.EstadoOferta" %>
    <%@page import = "java.io.FileOutputStream" %>
    <%@page import  = "java.io.IOException" %>
    <%@page import ="java.util.Base64" %>
    <%@ page import="logica_entidades.KeyWord" %>
	<%@ page import="java.util.Set" %>
    
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
      crossorigin="anonymous"
    ></script>
    <title>TrabajoUY</title>
</head>
<body>
	<jsp:include page="/WEB-INF/template/headerLogged.jsp"></jsp:include>
	    
	 <%
        // Recupera la ofertaSeleccionada de la solicitud
        DataOferta oferta = (DataOferta) request.getAttribute("ofer");
	 	String nombre = oferta.getNombre();
	 	String desc = oferta.getDescripcion();
	 	String ciudad = oferta.getCiudad();
	 	String dep = oferta.getDepartamento();
	 	LocalTime horaI = oferta.getHoraInicio();
	 	LocalTime horaF = oferta.getHoraFin();
	 	float remuneracion = oferta.getRemuneracion();
	 	LocalDate alta = oferta.getFechaDeAlta(); 
	 	EstadoOferta est = oferta.getEstado();
	 	String pago = oferta.getTipoDePago();
        byte[] imagenBytes = oferta.getImagen();
        String base64Image = "";
        if (imagenBytes != null) {
            base64Image = Base64.getEncoder().encodeToString(imagenBytes);
        }
        Set<KeyWord> keys = oferta.getKeyWords();

    %>
	
	<div class = "contenedor4">

  		<div class="row">
		<div class="col-6 col-md-4">
			<div class = "alinearImg3">
           
  				<img src="data:image/jpeg;base64, <%= base64Image %>" align = "absmiddle" class="img-thumbnail shadow" alt="...">
		
			</div>
		</div>
    	<div class="col-md-8">
			<div class="contenedor4">
				<h2 class="text-uppercase fs-4 fw-bolder">Información de la oferta</h2>
			</div>
			<!--cargo datos-->
		  <div class = "contenedor4">
		  	<div class="row">
    			<div class="col">
      					<h4 class = "fs-5 fw=normal">-Nombre:</h4>
   				 </div>
    		<div class="col">
      					<h4 class = "fs-5 fw-lighter"><%=nombre %> </h4>
    		 </div>
  			</div>
  			<hr>
  			
  			<div class="row">
    			<div class="col">
      					<h4 class = "fs-5 fw=normal">-Descripción:</h4>
   				 </div>
    			<div class="col">
      					<h4 class = "fs-5 fw-lighter"><%= desc %></h4>
    		 	</div>
  		 	</div>
  		 	<hr>
  		 	
		  	<div class="row">
    			<div class="col">
      					<h4 class = "fs-5 fw=normal">-Ciudad:</h4>
   				 </div>
    		<div class="col">
      					<h4 class = "fs-5 fw-lighter"><%= ciudad %></h4>
    		 </div>
  			</div>
  			<hr>
  			
  			<div class="row">
    			<div class="col">
      					<h4 class = "fs-5 fw=normal">-Departamento:</h4>
   				 </div>
    			<div class="col">
      					<h4 class = "fs-5 fw-lighter"><%= dep %></h4>
    		 	</div>
  		 	</div>
  		 	<hr>
  		 	
  		 	<div class="row">
    		<div class="col">
      					<h4 class = "fs-5 fw=normal">-Horario:</h4>
   				 </div>
    		<div class="col">
      					<h4 class = "fs-5 fw-lighter"><%= horaI %> - <%= horaF %> </h4>
    		 </div>
  			</div>
  			<hr>
  			
  			<div class="row">
    			<div class="col">
      					<h4 class = "fs-5 fw=normal">-Remuneración:</h4>
   				 </div>
    			<div class="col">
      					<h4 class = "fs-5 fw-lighter"><%= remuneracion %></h4>
    		 	</div>
  		 	</div>
  		 	<hr>
  		 	
  		 	<div class="row">
    			<div class="col">
      					<h4 class = "fs-5 fw=normal">-Fecha:</h4>
   				 </div>
    			<div class="col">
      					<h4 class = "fs-5 fw-lighter"><%= alta %></h4>
    		 	</div>
  		 	</div>
  		 	<hr>
  		 	
  		 	<div class="row">
    			<div class="col">
      					<h4 class = "fs-5 fw=normal">-Estado:</h4>
   				 </div>
    		<div class="col">
      					<h4 class = "fs-5 fw-lighter"><%= est %> </h4>
    		 </div>
  			</div>
  			<hr>
  			
  			<div class="row">
    			<div class="col">
      					<h4 class = "fs-5 fw=normal">-Tipo de pago:</h4>
   				 </div>
    			<div class="col">
						<a>
      						<button type="button" class="btn btn-outline-secondary"><%= pago %></button>
						</a>    		 	</div>
  		 	</div>
  		 	<hr>
  		  
  		  
  		  <%
  		  	Set<KeyWord> palabras = oferta.getKeyWords();
  		  
  		  %>
			<div class="row">
    			<div class="col">
  					<h4 class = "text-uppercase fs-5 fw-bolder">Keywords</h5>
  				</div>
  				<div class="col">
					<% for (KeyWord key : palabras) { %>
						<a>
      						<button type="button" class="btn btn-outline-secondary"><%= key.getPalabraClave() %></button>
						</a>
					<% } %>
				</div>
				</div>
			</div>
			</div>
			
  		</div>
  		</div>
	</div>
	
	
	<div class = "contenedor text-center mt-3">
		<a href="ServletConsultaDePostulacionAOfertaLaboral?id=<%= nombre %>" class="gap-2 py-5" align = "centre"style="text-decoration: none;">
  			<button class="btn btn-dark" type="button">Ver detalles postulantes</button>
		</a>
		
		<% 
		if (!"Sin paquete".equals(pago)) { %>
		    <a href="/TrabajoUY/DetalleDePaquete" class="gap-2 py-5" align="centre" style="text-decoration: none;">
		        <button class="btn btn-dark" type="button">Ver detalles pago con paquete</button>
		    </a>
		<% 
		} 
		%>
		
	</div>	
	<jsp:include page="/WEB-INF/template/footer.jsp"></jsp:include>
</body>
</html>