<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import= "com.webservices.controladores.publicar.PublicadorManejadorUsuarioService" %>
 <%@page import= "com.webservices.controladores.publicar.PublicadorManejadorUsuario" %>
 <%@page import= "com.webservices.controladores.publicar.PublicadorManejadorOfertasService" %>
 <%@page import= "com.webservices.controladores.publicar.PublicadorManejadorOfertas" %>
     <%@page import= "com.webservices.controladores.publicar.DataPostulacion" %>
     <%@page import= "com.webservices.controladores.publicar.DataUsuario" %>
     <%@page import= "java.util.Set" %>
<!DOCTYPE html>
<html lang = "es">
<head>
 <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="media/css/indexStyle.css" />
    <link rel="stylesheet" href="media/css/normalize.css" />
    <link rel="stylesheet" href="media/css/consultaUsuarioStyle.css" />
    <link rel="stylesheet" href="media/css/consultaPostulanteStyle.css" />
    <link rel="stylesheet" href="media/css/consultarEmpresaStyle.css" />

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
    <%@ page import="com.webservices.controladores.publicar.DataOferta" %>
    <%@ page import="java.time.LocalTime" %>
    <%@ page import="java.time.LocalDate" %>
    <%@ page import="com.webservices.controladores.publicar.EstadoOferta" %>
    <%@page import = "java.io.FileOutputStream" %>
    <%@page import  = "java.io.IOException" %>
    <%@page import ="java.util.Base64" %>
    <%@ page import="com.webservices.controladores.publicar.KeyWord" %>
	<%@ page import="java.util.ArrayList" %>
	<%@ page import="java.time.format.DateTimeFormatter" %>
    
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
        DataOferta oferta = (DataOferta) request.getSession().getAttribute("ofertaSeleccionada");
	 	String nombre = oferta.getNombre();
	 	String desc = oferta.getDescripcion();
	 	String ciudad = oferta.getCiudad();
	 	String dep = oferta.getDepartamento();
	 	String horaI = oferta.getHoraInicio();
	 	String horaF = oferta.getHoraFin();
	 	float remuneracion = oferta.getRemuneracion();
	 	String alta = oferta.getFechaDeAlta(); 
	 	EstadoOferta est = oferta.getEstado();
	 	String emp = oferta.getEmpresa();
        byte[] imagenBytes = oferta.getImagen();
        String base64Image = "";
        if (imagenBytes != null) {
            base64Image = Base64.getEncoder().encodeToString(imagenBytes);
        }
      
		String es = (String) request.getAttribute("queEs");
        
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
      					<h4 class = "fs-5 fw-lighter"><%= desc %></h4>
    		 	</div>
  		 	</div>
  		 	<hr>
  		 	
		  	<div class="row">
    			<div class="col">
      					<h4 class = "fs-5 fw=normal">Ciudad:</h4>
   				 </div>
    		<div class="col">
      					<h4 class = "fs-5 fw-lighter"><%= ciudad %></h4>
    		 </div>
  			</div>
  			<hr>
  			
  			<div class="row">
    			<div class="col">
      					<h4 class = "fs-5 fw=normal">Departamento:</h4>
   				 </div>
    			<div class="col">
      					<h4 class = "fs-5 fw-lighter"><%= dep %></h4>
    		 	</div>
  		 	</div>
  		 	<hr>
  		 	
  		 	<div class="row">
    		<div class="col">
      					<h4 class = "fs-5 fw=normal">Horario:</h4>
   				 </div>
    		<div class="col">
      					<h4 class = "fs-5 fw-lighter"><%= horaI %> - <%= horaF %> </h4>
    		 </div>
  			</div>
  			<hr>
  			
  			<div class="row">
    			<div class="col">
      					<h4 class = "fs-5 fw=normal">Remuneración:</h4>
   				 </div>
    			<div class="col">
      					<h4 class = "fs-5 fw-lighter"><%= remuneracion %></h4>
    		 	</div>
  		 	</div>
  		 	<hr>
  		 	
  		 	<div class="row">
    			<div class="col">
      					<h4 class = "fs-5 fw=normal">Fecha:</h4>
   				 </div>
    			<div class="col">
      					<h4 class = "fs-5 fw-lighter"><%= alta %></h4>
    		 	</div>
  		 	</div>
  		 	<hr>
  		 	
  		 	<div class="row">
    			<div class="col">
      					<h4 class = "fs-5 fw=normal">Estado:</h4>
   				 </div>
    		<div class="col">
      					<h4 class = "fs-5 fw-lighter"><%= est %> </h4>
    		 </div>
  			</div>
  			<hr>
  			
  			<div class="row">
    			<div class="col">
      					<h4 class = "fs-5 fw=normal">Empresa:</h4>
   				 </div>
    			<div class="col">
						<a>
      						<button type="button" class="btn btn-outline-secondary"><%= emp %></button>
						</a>    		 	</div>
  		 	</div>
  		 	<hr>
  		  <%
  			
  			Set<String> palabras = (Set<String>) request.getSession().getAttribute("keys");
  		  %>
			<div class="row">
    			<div class="col">
  					<h4 class = "text-uppercase fs-5 fw-bolder">Keywords</h5>
  				</div>
  				<div class="col">
					    <% for (String key : palabras) { %>
					        <div class="mb-2 mt-2"> <!-- Agregando margen superior e inferior a cada botón -->
					            <a>
					                <button type="button" class="btn btn-outline-secondary"><%= key %></button>
					            </a>
					        </div>
					    <% } %>
					</div>			
				</div>
				<hr>	
			</div>
			</div>				
			<div class="contenedorPrincipal">
							    <!-- ACA ARRANCA A MOSTRAR LAS POSTULACIONES -->
		<div class = "texto-of">
	    		<h2>Postulaciones</h2>
	    		<h5 style="color: #444;">Indique el orden, de menor a mayor, en el que quedarán las postulaciones.</h5>
				<h6 style="color: #666;">Cuanto menor sea el número que especifique, más arriba en la lista quedarán las postulaciones correspondientes.</h6>
	    		</div> 
	      
	      
	      <%
	      
	      	PublicadorManejadorUsuarioService servicePublicadorManejadorUsuarios = new PublicadorManejadorUsuarioService();
	  		PublicadorManejadorUsuario puertoManejadorUsuarios = servicePublicadorManejadorUsuarios.getPublicadorManejadorUsuarioPort();
	            	
	      	Set<String> postulantes = (Set<String>) request.getSession().getAttribute("postulantesDeOfer");
	      	if(!postulantes.isEmpty()){
	    	  
	      %>
	      <form action="SeleccionarPostulacion" method="POST" id="ordenForm">
		      <div class= "cartas-ofertas">
					<%
				        String nombrePostulante;
				        byte[] imagenOfByte;
				        for(String postu: postulantes) {
				        	
				        	DataUsuario userPostulado = puertoManejadorUsuarios.obtenerDataUsuario(postu);
				        	
				            imagenOfByte = userPostulado.getImagen();
				
				            String base64ImagenOf = Base64.getEncoder().encodeToString(imagenOfByte);
				            
				    %>
					<div class="card bg-light" style="width: 15rem;">
					    <img src="data:image/jpeg;base64, <%= base64ImagenOf %>" class="card-img-top" alt="imagen de usuario">
					    <div class="card-body">
					        <h5 class="card-title" style="color: black; margin-bottom: 10px;"><%= postu %></h5>
					        <input type="number" id="orden_<%= postu %>" name="orden_<%= postu %>" placeholder="Número de orden" style="padding: 5px; border: 1px solid #ccc; border-radius: 5px; margin-bottom: 10px;">
					        <a href="ServletConsultaDePostulacionAOfertaLaboral?id=<%= nombre %>&user=<%= postu %>" class="btn btn-dark" style="margin-top: 10px;">Ver más de la postulación</a>
					    </div>
					</div>
				<% } %>
			
				</div>
				<button type="button" id="guardarOrden" class="btn btn-dark">Guardar Orden</button>
				<input type="hidden" name="postulantesOrdenados" id="postulantesOrdenados">
		</form>
		<% }else{ %>
			<p>Esta oferta no tiene postulaciones</p>
		<%} %>
							   	
			<div id="orden"></div>		    
  		</div>
  		</div>
	</div>
		<script>
		document.getElementById('guardarOrden').addEventListener('click', function () {
		    var cartas = document.querySelectorAll('.card');

		    // Crea un objeto para mapear el número de orden al nombre del postulante
		    var ordenes = {};

		    // Crea un conjunto para rastrear los números de orden duplicados
		    var numerosOrdenDuplicados = new Set();

		    var error = false;

		    cartas.forEach(function (carta) {
		        var nombreCarta = carta.querySelector('h5').textContent;
		        var numeroOrdenInput = carta.querySelector('input');
		        var numeroOrden = parseInt(numeroOrdenInput.value);

		        // Verifica si el número de orden está duplicado o es inválido
		        if (numerosOrdenDuplicados.has(numeroOrden) || isNaN(numeroOrden)) {
		            error = true;
		            numeroOrdenInput.style.border = '2px solid red'; // Establece un borde rojo en caso de error
		        } else {
		            numerosOrdenDuplicados.add(numeroOrden);
		            ordenes[nombreCarta] = numeroOrden;
		            numeroOrdenInput.style.border = ''; // Restablecer el estilo
		        }
		    });

		    if (error) {
		        alert('Por favor, verifique los números de orden, asegúrese de que sean únicos y válidos.');
		    } else {
		        // Ordena los nombres en función del número de orden
		        var nombresOrdenados = Object.keys(ordenes).sort(function (a, b) {
		            return ordenes[a] - ordenes[b];
		        });

		        // Convierte el array de nombres ordenados en una cadena de texto delimitada por comas
		        var postulantesOrdenados = nombresOrdenados.join(',');

		        // Asigna la cadena de texto al campo oculto
		        var postulantesOrdenadosInput = document.getElementById('postulantesOrdenados');
		        postulantesOrdenadosInput.value = postulantesOrdenados;

		        // Envía el formulario al servidor
		        document.getElementById('ordenForm').submit();
		    }
		});
		</script>

	<jsp:include page="/WEB-INF/template/footer.jsp"></jsp:include>
</body>
</html>