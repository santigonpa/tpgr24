<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import= "com.webservices.controladores.publicar.DataEmpresa" %>
 <%@page import ="java.util.Base64" %>
 <%@page import="java.util.Set" %>
 <%@page import= "com.webservices.controladores.publicar.DataOferta" %>
  <%@page import= "com.webservices.controladores.publicar.DataUsuario" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">


<meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="media/css/consultaPostulanteStyle.css" />
  <!--   <link rel="stylesheet" href="media/css/consultarEmpresaStyle.css" /> -->
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
<title>TrabajoUY : Consultar Empresa</title>
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
	
	
	
	<div class="header-ola" style="position: relative; text-align: center; background-image: url('media/img/prueba.jpg'); background-size: cover; background-position: center; color: white; z-index: -1;">
        <!--Content before waves-->
        <div
          class="inner-header d-flex justify-content-center align-items-center flex-column"
        >
          <h1 class="trabajo-uy">Usuario</h1>
          <h2 class="slogan-uy">
            Estas consultando una empresa
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
	     	Set<DataUsuario> usuariosSeguidores = (Set<DataUsuario>) request.getAttribute("seguidores");
    			DataEmpresa empresaConsultada = (DataEmpresa)  request.getAttribute("consultar");
    			byte[] imagenBytes = empresaConsultada.getImagen();
    			String base64Image = Base64.getEncoder().encodeToString(imagenBytes);
    		%>
    	
    		<div class="contenedor-principal">
	    <div class="card" style="width: 18rem;">
	      <img src="data:image/jpeg;base64, <%= base64Image %>" class="card-img-top" alt="imagen de usuario">
	      
    	<%
    	boolean banderaPuedeSeguir = true;
    	DataUsuario userASeguir = (DataUsuario) request.getAttribute("consultar");
    	for(DataUsuario seguidorChecking : usuariosSeguidores){
    		if(seguidorChecking.getNickName().equals(usr.getNickName())){banderaPuedeSeguir = false;}
    	}
    	
    	
    	if(banderaPuedeSeguir){
    		
    		request.getSession().setAttribute("seguir","seguir");
    	%>
    	
    	 <div class="centered-button" style="margin-top: 15px;">
    	<a href="SeguirUsuario?usuarioASeguir=<%= userASeguir.getNickName() %>" class="btn btn-dark custom-button">Seguir Usuario</a>
 	 	</div>
    	
    	<%
    	}else{
    		
    		request.getSession().setAttribute("seguir","dejarDeSeguir");
    		
    	%>
    	
    	 <div class="centered-button" style="margin-top: 15px;">
    	<a href="SeguirUsuario?usuarioASeguir=<%= userASeguir.getNickName() %>" class="btn btn-dark custom-button">Dejar de Seguir Usuario</a>
 	 	</div>
    	
    	<%
    	
    	} 
    	
    	%>
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
	     <h2>Ofertas de la Empresa</h2>
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

			          <a href="/TrabajoUY/PostulacionAOferta" class="btn btn-outline-dark">Postularme</a>
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
	     <h2>Seguidores</h2>
	      </div>
	     
	     <%	
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
	     <h2>Seguidos</h2>
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