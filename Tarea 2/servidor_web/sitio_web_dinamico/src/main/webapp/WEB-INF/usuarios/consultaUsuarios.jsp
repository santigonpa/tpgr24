<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import= "com.webservices.controladores.publicar.DataUsuario" %>
    <%@page import="java.util.Set" %>
    <%@page import = "java.io.FileOutputStream" %>
    <%@page import  = "java.io.IOException" %>
    <%@page import ="java.util.Base64" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    
    <!-- Agrega la referencia a Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.5.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="media/css/consultaUsuarioStyle.css" />
    
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
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.5.0/dist/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
     
    
<title>TrabajoUY : Consultar Usuarios</title>
</head>
<body>
		<header>
      <!-- donde dice/buscar es la direccion donde va a llevar, y variable q es la que almacena la busqueda -->
      <!-- esto se debe implementar mas adelante  
            
                <img class = "logotipo-trabajouy" src="logotipoTrabajoUy-transformed.png" alt="Logotipo de Mi Sitio">
            
            
            -->

	<nav class="navbar bg-dark px-5">
    	<a class="navbar-brand" href="index.html">
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
    		width: 200px;
    		</form>
  		</div>
  		
  		<div class = button-grup>
  		  <li class="nav-item">
            <a
              class="nav-link active"
              aria-current="page"
              href="/TrabajoUY/AltaUsuario"
              style="color: white"
              >Registrarse</a
            >
          </li>
  		</div>
  		
  		<div class = button-grup>
  		  <li class="nav-item">
            <a
              class="nav-link active"
              aria-current="page"
              href="/TrabajoUY/iniciarSesion"
              style="color: white"
              >Iniciar Sesion</a
            >
          </li>
  		</div>
  		
	</nav>


      <div class="header-ola" style="position: relative; text-align: center; background-image: url('media/img/fotoUsuarios2.jpg'); background-size: cover; background-position: center; color: white; z-index: -1;">
        <!--Content before waves-->
        <div
          class="inner-header d-flex justify-content-center align-items-center flex-column"
        >
          <h1 class="trabajo-uy">Consulta Usuarios</h1>
          <h2 class="slogan-uy">
            elige el usuario que quieras consultar.
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
			
			
				<div class="cartas">
			    <%
			    
			    Set<DataUsuario> conjuntoDeUsers = (Set<DataUsuario>) request.getAttribute("coleccionDataUsuarios");
			    
			    if(!conjuntoDeUsers.isEmpty()){
			    
			        String nickUser;
			        String nombreUser;
			        String apellidoUser;
			        byte[] imagenBytes;
			
			        for (DataUsuario dataUser : conjuntoDeUsers) {
			            nickUser = dataUser.getNickName();
			            nombreUser = dataUser.getNombre();
			            apellidoUser = dataUser.getApellido();
			            imagenBytes = dataUser.getImagen();
			
			            String base64Image = Base64.getEncoder().encodeToString(imagenBytes);
			            
			    %>
			
			    <div class="card bg-dark" style="width: 15rem;">
			        <img src="data:image/jpeg;base64, <%= base64Image %>" class="card-img-top" alt="imagen de usuario">
			        <div class="card-body">
			            <h5 class="card-title" style="color: #FFFF;"><%= nickUser %></h5>
			            <br>
			            <p class="card-text" style="color: #FFFF;">NOMBRE : <%= nombreUser %></p>
			            <p class="card-text" style="color: #FFFF;">APELLIDO : <%= apellidoUser %></p>
			            <a href="?VerPerfil=<%= nickUser  %>" class="btn btn-secondary">Ver Perfil Completo</a>
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
							                Hasta el momento no hay usuarios registrados en el sistema
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