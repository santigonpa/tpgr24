<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import= "com.webservices.controladores.publicar.DataUsuario" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="media/css/indexLoggedStyle.css" />
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
    <title>TrabajoUY</title>
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
              	<li><a class="dropdown-item" href="/TrabajoUY/AltaDeOfertaLaboral">Crear Oferta Laboral</a></li>
              	<li><a class="dropdown-item" href="ConsultaDeOfertaLaboral">Ver Ofertas</a></li>
              	<li><a class="dropdown-item" href="/TrabajoUY/ConsultaDeTipoDePublicacionDeOfertaLaboral">Tipos de Publicaciones</a></li>
              	<li><a class="dropdown-item" href="/TrabajoUY/SeleccionarPostulacion">Seleccionar Postulantes de Oferta</a></li>
          		<li><a class="dropdown-item" href="/TrabajoUY/FinalizarOferta">Finalizar Oferta Laboral</a></li>
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
  		
  		<div class="ml-auto mt-auto dropdown"> <!-- Alinea a la derecha -->
        <div class="nav-button"> <!-- Contenedor del botÃ³n -->
            <a href="#" class="nav-link" data-bs-toggle="dropdown" style="color: white;">
			    <% 
			    HttpSession sessionIniciada = request.getSession(false);
			    DataUsuario usr = (DataUsuario) sessionIniciada.getAttribute("usuario");
			    %>
			    <img src="<%= request.getContextPath() %>/ServletImagen" alt="BotÃ³n" width="30" height="30" style="border-radius: 50%; margin-right: 10px;">
			    Mi Usuario
			</a>
            <ul class="dropdown-menu dropdown-menu-end">
                <li><a class="dropdown-item" href="/TrabajoUY/VerPerfil">Usuario</a></li>
                <li><a class="dropdown-item" href="/TrabajoUY/ModificarUsuario">Modificar Usuario</a></li>
                <!--<li><a class="dropdown-item cerrar-sesion" href="index.html">Cerrar sesiÃ³n</a></li>-->
                <!-- no se si meter ese js-->
                <li><a class="dropdown-item cerrar-sesion" href="javascript:void(0);" onclick="confirmarCerrarSesion();">Cerrar sesión</a></li>
            </ul>
        </div>
    </div>
  		
	</nav>
	<!-- no se si meter ese js-->
	<script>
		function confirmarCerrarSesion() {
    	var confirmacion = confirm("Estás seguro de que deseas cerrar la sesión?");
    	if (confirmacion) {
			window.location.href = "/TrabajoUY/CerrarSesion";
    		}
		}
	</script>


      <div class="header-ola" style="position: relative; text-align: center; background-image: url('media/img/kenny-eliason-4FJ14D3Ly30-unsplash.jpg'); background-size: cover; background-position: center; color: white; z-index: -1;">
        <!--Content before waves-->
        <div
          class="inner-header d-flex justify-content-center align-items-center flex-column"
        >
          <h1 class="trabajo-uy">Trabajo UY</h1>
          <h2 class="slogan-uy">
            Consigue el trabajo que buscas de la manera más fácil.
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
    		
    		<div class = "titulo3" style = "text-align : center; margin-top : 50px;padding:0; font-family: 'Fira Sans Condensed';">
	    		<h3 class="galeria-titulo" style = "color : rgb(0, 0, 0); text-shadow : 6px 6px 15 black;">
	            Algunos de nuestros clientes que ya consiguieron empleo con TrabajoUY.
	          	</h3>
    		</div>
      		
      		<div class="container-galeria">
				  <section class = "galeria">
				  		<img src = "media/img/jason-goodman-fXVx1opWGxM-unsplash.jpg" >
				  		<img src = "media/img/of1.jpg" >
				  		<img src = "media/img/of2.jpg" >
				  		<img src = "media/img/of3.jpg" >
				  		<img src = "media/img/k-mitch-hodge-Esi7nknKxmw-unsplash.jpg" >
				  		<img src = "media/img/irina-2Q8bo_6lu1Y-unsplash.jpg" >
				  </section>
				</div>
      		
      		
      </main>
      
      <jsp:include page="/WEB-INF/template/footer.jsp"></jsp:include>
</body>
</html>