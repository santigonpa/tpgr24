<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import= "com.webservices.controladores.publicar.DataUsuario" %>
    
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
              <li><a class="dropdown-item" href="/TrabajoUY/ConsultaDeOfertaLaboral">Ver Ofertas</a></li>
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
                <li><a class="dropdown-item" href="ModificarUsuario">Modificar Usuario</a></li>
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
	</header>