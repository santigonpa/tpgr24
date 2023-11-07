<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import= "com.webservices.controladores.publicar.DataUsuario" %>
    <%@page import= "com.webservices.controladores.publicar.DataPaquete" %>
    <%@page import= "com.webservices.controladores.publicar.DataEmpresa" %>
    <%@page import= "com.webservices.controladores.publicar.DataOferta" %>
    <%@page import= "com.webservices.controladores.publicar.PublicadorManejadorUsuarioService" %>
 <%@page import= "com.webservices.controladores.publicar.PublicadorManejadorUsuario" %>
 <%@page import= "com.webservices.controladores.publicar.PublicadorManejadorPyTService" %>
 <%@page import= "com.webservices.controladores.publicar.PublicadorManejadorPyT" %>
    <%@page import="java.util.Set" %>
    <%@page import="java.util.ArrayList" %>
    <%@page import = "java.io.FileOutputStream" %>
    <%@page import  = "java.io.IOException" %>
    <%@page import ="java.util.Base64" %>
    <%@page import= "java.util.Map" %>
    <%@page import= "java.util.List" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">


<meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="media/css/consultaPostulanteStyle.css" />
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
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
    <style>
		    .carta-oferta {
    width: calc(50% - 10px); /* Ajusta el ancho para que se muestren dos cartas por fila */
    margin-right: 20px; /* Espacio entre las cartas */
    display: inline-block; /* Alinea las cartas en línea */
    vertical-align: top; /* Alinea las cartas en la parte superior de la fila */
}
    
    </style>
    <style>
    
		.row {
		--bs-gutter-x: 0rem !important;
		}
    
    </style>
    
    
<title>TrabajoUY : MI USUARIO</title>
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
              <li><a class="dropdown-item" href="/TrabajoUY/ConsultarUsuario">Perfiles</a></li>
              
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
              <li><a class="dropdown-item" href="/TrabajoUY/AltaDeOfertaLaboral">Crear Oferta Laboral</a></li>
              <li><a class="dropdown-item" href="/TrabajoUY/ConsultaDeOfertaLaboral">Ver Ofertas</a></li>
              <li><a class="dropdown-item" href="/TrabajoUY/ConsultaDeTipoDePublicacionDeOfertaLaboral">Tipos de Publicaciones</a></li>
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
              <li><a class="dropdown-item" href="/TrabajoUY/ConsultaDePaquetes">Ver Paquetes</a></li>
            </ul>
          </li>
          </div>
  	
  		<div class = button-grup>
  			<form class="d-flex" role="search">
      		<input class="form-control me-2" type="search" placeholder="Buscar" aria-label="Buscar">
    		<button class="btn btn-secondary" type="submit">Buscar</button>
    		</form>
  		</div>
  		
  		<div class="ml-auto mt-auto dropdown"> <!-- Alinea a la derecha -->
        <div class="nav-button"> <!-- Contenedor del botón -->
            <a href="#" class="nav-link" data-bs-toggle="dropdown" style="color: white;">
			    <% 
			    HttpSession sessionIniciada = request.getSession(false);
			    DataUsuario usr = (DataUsuario) sessionIniciada.getAttribute("usuario");
			    %>
			    <img src="<%= request.getContextPath() %>/ServletImagen" alt="Botón" width="30" height="30" style="border-radius: 50%; margin-right: 10px;">
			    Mi Usuario
			</a>
            <ul class="dropdown-menu dropdown-menu-end">
                <li><a class="dropdown-item" href="/TrabajoUY/VerPerfil">Usuario</a></li>
                <li><a class="dropdown-item" href="/TrabajoUY/ModificarUsuario">Modificar Usuario</a></li>
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
	
	
	
	<div class="header-ola" style="position: relative; text-align: center; background-image: url('media/img/prueba.jpg'); background-size: cover; background-position: center; color: white; z-index: -1;">
        <!--Content before waves-->
        <div
          class="inner-header d-flex justify-content-center align-items-center flex-column"
        >
          <h1 class="trabajo-uy">Mi Usuario</h1>
          <h2 class="slogan-uy">
            
          </h2>
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
    	
    	
    		<%
    			DataEmpresa empresaConsultada = (DataEmpresa)  request.getAttribute("consultar");
    			byte[] imagenBytes = empresaConsultada.getImagen();
    			String base64Image = Base64.getEncoder().encodeToString(imagenBytes);
    		%>
    	
    		<div class="contenedor-principal">
	    <div class="card" style="width: 18rem;">
	      <img src="data:image/jpeg;base64, <%= base64Image %>" class="card-img-top" alt="imagen de usuario">
	      <div class="card-body">
	        <b>DESCRIPCIÓN</b>
	        <div class = "my-2"></div>
	        <p class="card-text" style = "text-align : left;"><%= empresaConsultada.getDescripcion() %></p>
	      </div>
	    </div>
	    <div class="contenedor-form">
	      
	        <fieldset disabled>
	          <legend class= "nombre-user"><%= empresaConsultada.getNickName() %></legend>
	          <div class="mb-3">
	            <label for="disabledTextInput" class="form-label">NOMBRE</label>
	            <input type="text" id="disabledTextInput" class="form-control" placeholder="<%= empresaConsultada.getNombre() %>">
	          </div>
	          <div class="mb-3">
	            <label for="disabledTextInput" class="form-label">APELLIDO</label>
	            <input type="text" id="disabledTextInput" class="form-control" placeholder="<%= empresaConsultada.getApellido() %>">
	          </div>
	          <div class="mb-3">
	            <label for="disabledTextInput" class="form-label">EMAIL</label>
	            <input type="text" id="disabledTextInput" class="form-control" placeholder="<%= empresaConsultada.getEmail() %>">
	          </div>
	          <div class="mb-3">
	            <label for="disabledTextInput" class="form-label">SITIO WEB</label>
	          </div>
	        </fieldset>
	        <a href="<%= empresaConsultada.getWeb() %>"><%= empresaConsultada.getWeb() %></a>
	        
	         
	        	
	      
	     
	     
	      
	      
	      
	    </div>
	  </div>
    	</main>
    	
    	<div class="contenedorPrincipal">
    	
    	<div class = "texto-of ">
	     <h2>Ofertas Confirmadas de tu Empresa</h2>
	      </div>
	     
	     <%	
	     	Set<DataOferta> oferConfirmadas = (Set<DataOferta>) request.getAttribute("ofertasConfirmadas");
	     	//si hay ofertas confirmadas las muestro si no no
	     	if(!oferConfirmadas.isEmpty()){
	     %>
	     
	       <div class="contenedorCards">
				 		<div class="row mt-4">
				
				
				<%  //initfor
				String nombreOferta;
		        String nombreUser;
		        String descripcion;
		        byte[] imagenBytesOferta;
		
		        for (DataOferta ofertaActual : oferConfirmadas) {
		            nombreOferta = ofertaActual.getNombre();
					imagenBytesOferta = ofertaActual.getImagen();
					descripcion = ofertaActual.getDescripcion();
					imagenBytesOferta = ofertaActual.getImagen();
		            String base64ImageOferta = Base64.getEncoder().encodeToString(imagenBytesOferta);
					
				%>
			  
			  
			    
			    <div class="col-md-4 mb-4">
			      <div class="card" style="width: 18rem;">
			        <img src="data:image/jpeg;base64, <%= base64ImageOferta %>" class="card-img-top" alt="...">
			        <div class="card-body">
			          <h5 class="card-title"><%= nombreOferta %></h5>
			          <p class="card-text"><%= descripcion %></p>
			          <a href="ServletDetalleOferta?id=<%= nombreOferta %>" class="btn btn-outline-dark">Consultar datos de la oferta</a>
			        </div>
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
					  <div class = "my-5"></div>
					  <div class="container">
							    <div class="row">
							        <div class="col text-center">
							            <div class="alert alert-danger" role="alert">
							                No hay ofertas confirmadas para esta empresa
							            </div>
							        </div>
							    </div>
							</div>
					  
					  <%
				  }
			%>
    	
    	</div>
    	
    	<div class="contenedorPrincipal">
    	
    	<div class = "texto-of ">
	     <h2>Ofertas Ingresadas o Rechazadas de tu Empresa</h2>
	      </div>
	     
	     <%	
	     	Set<DataOferta> oferRechazadas = (Set<DataOferta>) request.getAttribute("ofertasRyI");
	     	//si hay ofertas confirmadas las muestro si no no
	     	if(!oferRechazadas.isEmpty() || oferRechazadas == null){
	     %>
	     
	       <div class="contenedorCards">
				 		<div class="row mt-4">
				
				
				<%  //initfor
				String nombreOferta2;
		        String nombreUser2;
		        String descripcion2;
		        byte[] imagenBytesOferta2;
		
		        for (DataOferta ofertaActual2 : oferRechazadas) {
		            nombreOferta2 = ofertaActual2.getNombre();
					imagenBytesOferta2 = ofertaActual2.getImagen();
					descripcion2 = ofertaActual2.getDescripcion();
					imagenBytesOferta2 = ofertaActual2.getImagen();
		            String base64ImageOferta2 = Base64.getEncoder().encodeToString(imagenBytesOferta2);
					
				%>
			  
			  
			    
			    <div class="col-md-4 mb-4">
			      <div class="card" style="width: 18rem;">
			        <img src="data:image/jpeg;base64, <%= base64ImageOferta2 %>" class="card-img-top" alt="...">
			        <div class="card-body">
			          <h5 class="card-title"><%= nombreOferta2 %></h5>
			          <p class="card-text"><%= descripcion2 %></p>
			          <a href="ServletDetalleOferta?id=<%= nombreOferta2 %>" class="btn btn-outline-dark">Consultar datos de la oferta</a>
			        </div>
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
					  <div class = "my-5"></div>
					  <div class="container">
							    <div class="row">
							        <div class="col text-center">
							            <div class="alert alert-danger" role="alert">
							                No hay ofertas Ingresadas o Rechazadas para esta empresa
							            </div>
							        </div>
							    </div>
							</div>
					  
					  <%
				  }
			%>
    	
    	</div>
    	<div class="contenedorPrincipal">
    	
    	<div class = "texto-of ">
	     <h2>Ofertas Finalizadas de tu Empresa</h2>
	      </div>
	     
	     <%	
	     	Set<DataOferta> oferFin = (Set<DataOferta>) request.getAttribute("oferFin");
	     	//si hay ofertas confirmadas las muestro si no no
	     	
	     	if( !oferFin.isEmpty()){
	     		
	     %>
	     
	    
	       <div class="contenedorCards">
				 		<div class="row mt-4">
				
				
				<%  //initfor
				String nombreOferta3;
		        String nombreUser3;
		        String descripcion3;
		        byte[] imagenBytesOferta3;
		
		        for (DataOferta ofertaActual3 : oferFin) {
		        	nombreOferta3 = ofertaActual3.getNombre();
		        	imagenBytesOferta3 = ofertaActual3.getImagen();
		        	descripcion3 = ofertaActual3.getDescripcion();
					imagenBytesOferta3 = ofertaActual3.getImagen();
		            String base64ImageOferta3 = Base64.getEncoder().encodeToString(imagenBytesOferta3);
					
				%>
			  
			  
			    
			    <div class="col-md-4 mb-4">
			      <div class="card" style="width: 18rem;">
			        <img src="data:image/jpeg;base64, <%= base64ImageOferta3 %>" class="card-img-top" alt="...">
			        <div class="card-body">
			          <h5 class="card-title"><%= nombreOferta3 %></h5>
			          <p class="card-text"><%= descripcion3 %></p>
			          <a href="ServletDetalleOferta?id=<%= nombreOferta3 %>" class="btn btn-outline-dark">Consultar datos de la oferta</a>
			        </div>
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
					  <div class = "my-5"></div>
					  <div class="container">
							    <div class="row">
							        <div class="col text-center">
							            <div class="alert alert-danger" role="alert">
							                No hay ofertas Finalizadas para esta empresa
							            </div>
							        </div>
							    </div>
							</div>
					  
					  <%
				  }
			%>
    	
    	</div>
    	
    	<div class="contenedorPrincipal">
    	
    	<div class = "texto-of ">
	      <h2>Paquetes comprados por la empresa.</h2>
	    </div>
	      
    	<%	
    		PublicadorManejadorUsuarioService servicePublicadorUsuario = new PublicadorManejadorUsuarioService();
    		PublicadorManejadorUsuario puertoManejadorUsuario = servicePublicadorUsuario.getPublicadorManejadorUsuarioPort();
    		
    		PublicadorManejadorPyTService servicePublicadorPyT = new PublicadorManejadorPyTService();
    		PublicadorManejadorPyT puertoManejadorPyT = servicePublicadorPyT.getPublicadorManejadorPyTPort();
    		
    		DataEmpresa emp = (DataEmpresa) usr;
    		String nickNameEmpresa = emp.getNickName();
    		List<Object> listaObjetos = puertoManejadorUsuario.obtenerDataPaquetes(emp.getNickName()).getLista();
    		ArrayList<DataPaquete> paquetes = new ArrayList<>();
    		
    		
    		for (Object objeto : listaObjetos) {
    		    if (objeto instanceof String) {
    		    	paquetes.add(puertoManejadorPyT.getDataPaqueteIndividual((String)objeto));
    		    }
    		} 
    		
    		if(!paquetes.isEmpty() || paquetes == null){
	     %>
	     
	       <div class="contenedorCards">
				 		<div class="row mt-4">
				
				
				<%  //initfor
				String nombrePaq;
		        String descPaq;
		        byte[] imagenBytesPaquete;
		
		        for (DataPaquete paqAct : paquetes ) {
		        	nombrePaq = paqAct.getNombre();
					imagenBytesPaquete = paqAct.getImagen();
					descPaq = paqAct.getDescripcion();
		            String base64ImageOferta2 = Base64.getEncoder().encodeToString(imagenBytesPaquete);
					
				%>
			  
			  
			    
			    <div class="col-md-4 mb-4">
			      <div class="card" style="width: 18rem;">
			        <img src="data:image/jpeg;base64, <%= base64ImageOferta2 %>" class="card-img-top" alt="...">
			        <div class="card-body">
			          <h5 class="card-title"><%= nombrePaq %></h5>
			          <p class="card-text"><%= descPaq %></p>
			          <a href="DetalleDePaquete?id=<%= nombrePaq %>" class="btn btn-outline-dark">Consultar datos del Paquete</a>
			        </div>
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
					  <div class = "my-5"></div>
					  <div class="container">
							    <div class="row">
							        <div class="col text-center">
							            <div class="alert alert-danger" role="alert">
							                No tiene paquetes adquiridos.
							            </div>
							        </div>
							    </div>
							</div>
					  
					  <%
				  }
			%>
	</div>
	
	
	
    	<div class="contenedorPrincipal">
    	
    	<div class = "texto-of ">
	     <h2>Seguidores de tu Empresa</h2>
	      </div>
	     
	     <%	
	     	Set<DataUsuario> usuariosSeguidores = (Set<DataUsuario>) request.getAttribute("seguidores");
	     	//si hay ofertas confirmadas las muestro si no no
	     	
	     	if( !usuariosSeguidores.isEmpty()){
	     		
	     %>
	     
	    
	       <div class="contenedorCards">
				 		<div class="row mt-4">
				
				
				<%  //initfor
				String nickNameSeguidor; 
		        byte[] imagenBytesSeguidor;
		
		        for (DataUsuario seguidor : usuariosSeguidores) {
		        	nickNameSeguidor = seguidor.getNickName();
		        	imagenBytesSeguidor = seguidor.getImagen();
		            String base64ImageSeguidor = Base64.getEncoder().encodeToString(imagenBytesSeguidor);
					
				%>
			  
			  
			    
			    <div class="col-md-4 mb-4">
			      <div class="card" style="width: 13rem;">
			        <img src="data:image/jpeg;base64, <%= base64ImageSeguidor %>" class="card-img-top" alt="...">
			        <div class="card-body">
			          <h5 class="card-title"><%= nickNameSeguidor  %></h5>
			          <a href="?VerPerfil=<%= nickNameSeguidor  %>" class="btn btn-outline-dark">Consultar datos del Usuario</a>
			        </div>
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
					  <div class = "my-5"></div>
					  <div class="container">
							    <div class="row">
							        <div class="col text-center">
							            <div class="alert alert-danger" role="alert">
							                Este Usuario no tiene seguidores
							            </div>
							        </div>
							    </div>
							</div>
					  
					  <%
				  }
			%>
    	
    	</div>
    	
    	<div class="contenedorPrincipal">
    	
    	<div class = "texto-of ">
	     <h2>Seguidos de tu Empresa</h2>
	      </div>
	     
	     <%	
	     	Set<DataUsuario> usuariosSeguidos = (Set<DataUsuario>) request.getAttribute("seguidos");
	     	//si hay ofertas confirmadas las muestro si no no
	     	
	     	if( !usuariosSeguidos.isEmpty()){
	     		
	     %>
	     
	    
	       <div class="contenedorCards">
				 		<div class="row mt-4">
				
				
				<%  //initfor
				String nickNameSeguido; 
		        byte[] imagenBytesSeguido;
		
		        for (DataUsuario seguido : usuariosSeguidos) {
		        	nickNameSeguido = seguido.getNickName();
		        	imagenBytesSeguido = seguido.getImagen();
		            String base64ImageSeguido = Base64.getEncoder().encodeToString(imagenBytesSeguido);
					
				%>
			  
			  
			    
			    <div class="col-md-4 mb-4">
			      <div class="card" style="width: 13rem;">
			        <img src="data:image/jpeg;base64, <%= base64ImageSeguido %>" class="card-img-top" alt="...">
			        <div class="card-body">
			          <h5 class="card-title"><%= nickNameSeguido  %></h5>
			          <a href="?VerPerfil=<%= nickNameSeguido  %>" class="btn btn-outline-dark">Consultar datos del Usuario</a>
			        </div>
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
					  <div class = "my-5"></div>
					  <div class="container">
							    <div class="row">
							        <div class="col text-center">
							            <div class="alert alert-danger" role="alert">
							                Este Usuario no tiene seguidos
							            </div>
							        </div>
							    </div>
							</div>
					  
					  <%
				  }
			%>
    	
    	</div>
    	
    	<jsp:include page="/WEB-INF/template/footer.jsp"></jsp:include>
    
</body>
</html>