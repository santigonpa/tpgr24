<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<header> 
		<nav class="navbar bg-dark px-5">
    	<a class="navbar-brand" href="/TrabajoUY/home">
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
              >Iniciar Sesión</a
            >
          </li>
  		</div>
  		
	</nav>
	</header>