<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import= "java.time.LocalDate" %> 
 <%@page import= "java.time.LocalTime" %> 
 <%@page import= "java.time.format.DateTimeFormatter" %> 
 <%@page import= "java.time.format.DateTimeFormatter" %> 
 <%@page import= "logica_DataTypes.DataPostulante" %>
 <%@page import="java.util.Set" %>
 <%@page import = "java.io.FileOutputStream" %>
 <%@page import  = "java.io.IOException" %>
 <%@page import ="java.util.Base64" %>
 <%@page import= "logica_Entidades.Postulacion" %>
 <%@page import= "logica_Entidades.OfertaLaboral" %>
 <%@page import= "logica_Entidades.Postulante" %>
 <%@page import= "utils.Fabrica" %>
 <%@page import= "logica_Manejadores.IManejadorUsuario" %>

 
 
<!DOCTYPE html>
<html lang="es">
 
  <head>
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
      href="media/img/logoNuevo.png"
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
    <title>TrabajoUY: Consulta Postulante</title>
  </head>
  <body>
    <header>
      <!-- donde dice/buscar es la direccion donde va a llevar, y variable q es la que almacena la busqueda -->
      <!-- esto se debe implementar mas adelante  
            
                <img class = "logotipo-trabajouy" src="logotipoTrabajoUy-transformed.png" alt="Logotipo de Mi Sitio">
            
            
            -->

	<nav class="navbar bg-dark px-5">
    	<a class="navbar-brand" href="home">
      		<img src="media/img/logoNuevo.png"
      		alt="Logo" 
      		width="42" 
      		height="44">
    	</a>
          
          <div class = button-grup>
  	        <li class="nav-item dropdown">
            	<a
              	class="nav-link dropdown-toggle"
              	href="#"
              	role="button"
              	data-bs-toggle="dropdown"
              	aria-expanded="false"
              	style="color: white"
            	>Usuarios

            </a>
              <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="ConsultarUsuario">Perfiles</a></li>
              
            </ul>
          </li>
          </div>
          
          <div class = button-grup>
  	        <li class="nav-item dropdown">
            	<a
              	class="nav-link dropdown-toggle"
              	href="#"
              	role="button"
              	data-bs-toggle="dropdown"
              	aria-expanded="false"
              	style="color: white"
            	>Ofertas Laborales

            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="altaDeOfertaLaboral.html">Crear Oferta Laboral</a></li>
              <li><a class="dropdown-item" href="consultaDeOfertasLaborales.html">Ver Ofertas</a></li>
              <li><a class="dropdown-item" href="consultaDeTiposDePublicacionDeOfertasLaborales.html">Tipos de Publicaciones</a></li>
            </ul>
          </li>
          </div>
          
          <div class = button-grup>
  	        <li class="nav-item dropdown" >
            	<a
              	class="nav-link dropdown-toggle"
              	href="#"
              	role="button"
              	data-bs-toggle="dropdown"
              	aria-expanded="false"
              	style="color: white"
            	>Paquetes

            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="compraDePaqueteDeTiposDePubliDeOfertaLab.html">Ver Paquetes</a></li>
            </ul>
          </li>
          </div>
  	
  		<div class = button-grup>
  			<form class="d-flex" role="search">
      		<input class="form-control me-2" type="search" placeholder="Buscar" aria-label="Buscar">
    		<button class="btn btn-secondary" type="submit">Buscar</button>
    		width: 200px;
    		</form>
  		</div>
  		
  		<div class="ml-auto mt-auto dropdown"> <!-- Alinea a la derecha -->
        <div class="nav-button"> <!-- Contenedor del botón -->
            <a href="#" class="nav-link" data-bs-toggle="dropdown" style="color: white;">
                <img src="https://imgv3.fotor.com/images/gallery/a-woman-linkedin-picture-with-grey-background-made-by-LinkedIn-Profile-Picture-Maker.jpg" alt="Botón" width="30" height="30" style="border-radius: 50%; margin-right: 10px;">
                Mi Usuario
            </a>
            <ul class="dropdown-menu dropdown-menu-end">
                <li><a class="dropdown-item" href="consultaPostulante.html">Usuario</a></li>
                <li><a class="dropdown-item" href="modificarDatosDeUsuario.html">Modificar Usuario</a></li>
                <!--<li><a class="dropdown-item cerrar-sesion" href="index.html">Cerrar sesión</a></li>-->
                <!-- no se si meter ese js-->
                <li><a class="dropdown-item cerrar-sesion" href="javascript:void(0);" onclick="confirmarCerrarSesion();">Cerrar sesión</a></li>
            </ul>
        </div>
    </div>
  		
	</nav>
	<script>
		function confirmarCerrarSesion() {
    	var confirmacion = confirm("¿Estás seguro de que deseas cerrar la sesión?");
    	if (confirmacion) {
			window.location.href = "/TrabajoUY/CerrarSesion";
    		}
		}
	</script>

      <div class="header-ola">
        <!--Content before waves-->
        <div
          class="inner-header d-flex justify-content-center align-items-center flex-column"
        >
          <h1 class="trabajo-uy"> Mi Usuario</h1>
        </div>

        <!--Waves Container-->
        <div>
          <svg
            class="waves"
            xmlns="http://www.w3.org/2000/svg"
            xmlns:xlink="http://www.w3.org/1999/xlink"
            viewBox="0 24 150 28"
            preserveAspectRatio="none"
            shape-rendering="auto"
          >
            <defs>
              <path
                id="gentle-wave"
                d="M-160 44c30 0 58-18 88-18s 58 18 88 18 58-18 88-18 58 18 88 18 v44h-352z"
              />
            </defs>
            <g class="parallax">
              <use
                xlink:href="#gentle-wave"
                x="48"
                y="0"
                fill="rgba(255,255,255,0.7"
              />
              <use
                xlink:href="#gentle-wave"
                x="48"
                y="3"
                fill="rgba(255,255,255,0.5)"
              />
              <use
                xlink:href="#gentle-wave"
                x="48"
                y="5"
                fill="rgba(255,255,255,0.3)"
              />
              <use xlink:href="#gentle-wave" x="48" y="7" fill="#fff" />
            </g>
          </svg>
        </div>
        <!--Waves end-->
      </div>
      <!--Header ends-->

      <!--Content starts-->

      <!--Content ends-->
    </header>
    
    
    
	    <main>
	  <div class="contenedor-principal">
	  <%
	    
	    String nickUser;
        String nombreUser;
        String apellidoUser;
        LocalDate nac;
      	String email;
        byte[] imagenBytes;
        String nacionalidad;
		
		DataPostulante dataUser = (DataPostulante) request.getAttribute("consultar");
        nickUser = dataUser.getNickName();
        nombreUser = dataUser.getNombre();
        apellidoUser = dataUser.getApellido();
        email = dataUser.getEmail();
        imagenBytes = dataUser.getImagen();
        nac= dataUser.getNacimineto();
        nacionalidad = dataUser.getNacionalidad();
        String base64Image = Base64.getEncoder().encodeToString(imagenBytes);
        
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String fechaFormateada = nac.format(dateFormatter);
        
        
	    %>
	    <div class="card" style="width: 18rem;">
	      <img src="data:image/jpeg;base64, <%= base64Image %>" class="card-img-top" alt="imagen de usuario">
	    </div>
	    <div class="contenedor-form">
	      <form>
	        <fieldset disabled>
	          <legend class= "nombre-user"><%= nickUser %></legend>
	          <div class="mb-3">
	            <label for="disabledTextInput" class="form-label">NOMBRE</label>
	            <input type="text" id="disabledTextInput" class="form-control" placeholder="<%= nombreUser %>">
	          </div>
	          <div class="mb-3">
	            <label for="disabledTextInput" class="form-label">APELLIDO</label>
	            <input type="text" id="disabledTextInput" class="form-control" placeholder="<%= apellidoUser %>">
	          </div>
	          <div class="mb-3">
	            <label for="disabledTextInput" class="form-label">EMAIL</label>
	            <input type="text" id="disabledTextInput" class="form-control" placeholder="<%= email %>">
	          </div>
	          <div class="mb-3">
	            <label for="disabledTextInput" class="form-label">FECHA DE NACIMIENTO</label>
	            <input type="text" id="disabledTextInput" class="form-control" placeholder="<%= nac %>">
	          </div>
	          <div class="mb-3">
	            <label for="disabledTextInput" class="form-label">NACIONALIDAD</label>
	            <input type="text" id="disabledTextInput" class="form-control" placeholder="<%= nacionalidad %>">
	          </div>
	        </fieldset>
	      
	   
	      </form>
	      
	      
	      <div class = "texto-of">
	    		<h2>Consulta Postulaciones del Usuario</h2>
	    		</div> 
	      
	      
	      
	      <div class= "cartas-ofertas">
				<%
			        String nombreOf;
			        byte[] imagenOfByte;
	            	Fabrica fab = Fabrica.getInstance();
	            	IManejadorUsuario imu = fab.getInManejadorUsuario();
	            	Postulante usr = (Postulante) imu.obtenerUsuario(nickUser);
	            	Set<Postulacion> postulaciones = usr.obtenerPostulaciones();
			
			        for (Postulacion postulacion: postulaciones) {
			        	OfertaLaboral oferta = postulacion.getOferta();
			            nombreOf = oferta.getNombreOferta();
			            imagenOfByte = oferta.getImagen();
			
			            String base64ImagenOf = Base64.getEncoder().encodeToString(imagenOfByte);
			            
			    %>
				
				<div class="card bg-light" style="width: 15rem;">
			  <img src="data:image/jpeg;base64, <%= base64ImagenOf %>" class="card-img-top" alt="imagen de usuario">
			  <div class="card-body">
			    <h5 class="card-title" style="color: black;"><%= nombreOf %></h5>
			    <p> </p>
			    
			    <a href="consultaPostulacionPostulante.html" class="btn btn-dark">Ver más de la postulación</a>
			  </div>
			</div>
			<% } %>
			
			</div>
	      
	      
	      
	    </div>
	  

	  
	  </div>
	</main>
	
  <jsp:include page="/WEB-INF/template/footer.jsp"></jsp:include>  
  
  </body>
</html>