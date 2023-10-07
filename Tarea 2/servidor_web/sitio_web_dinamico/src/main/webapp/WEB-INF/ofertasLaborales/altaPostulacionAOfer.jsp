<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import= "logica_Entidades.Usuario" %>

    
<!DOCTYPE html>
<html lang="es">
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
    
    
    
   
    <style>
    
.row {
--bs-gutter-x: 0rem !important;
}
    
    </style>
    
    
    <title>TrabajoUY: Postulacion a Oferta</title>
  </head>
  <body>
    <header>
    
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
              <li><a class="dropdown-item" href="AltaOfertaLaboral">Crear Oferta Laboral</a></li>
              <li><a class="dropdown-item" href="ConsultaDeOfertaLaboral">Ver Ofertas</a></li>
              <li><a class="dropdown-item" href="ConsultaDeTipoDePublicacionDeOfertaLaboral">Tipos de Publicaciones</a></li>
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
    		</form>
  		</div>
  		
  		<div class="ml-auto mt-auto dropdown"> <!-- Alinea a la derecha -->
        <div class="nav-button"> <!-- Contenedor del botón -->
            <a href="#" class="nav-link" data-bs-toggle="dropdown" style="color: white;">
			    <% 
			    HttpSession sessionIniciada = request.getSession(false);
			    Usuario usr = (Usuario) sessionIniciada.getAttribute("usuario");
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


      <div class="header-ola" style="position: relative; text-align: center; background-image: url('media/img/jobApplication.jpg'); background-size: cover; background-position: center; color: white; z-index: -1;">
        <!--Content before waves-->
        <div
          class="inner-header d-flex justify-content-center align-items-center flex-column"
        >
          <h1 class="trabajo-uy">Postular a una Oferta Laboral</h1>
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
			    <div class="contenedor4">
			        <div class="row justify-content-center">
			            <div class="col-6 col-md-4">
			                <div class="alinearImg3">
			                    <img src="https://tinyurl.com/45nsf34m" class="img-thumbnail shadow" alt="...">
			                </div>
			            </div>
			            <div class="col-md-8">
			                <div class="contenedor4">
			                    <h2 class="text-uppercase fs-4 fw-bolder">Información de la oferta</h2>
			                </div>
			                <!-- Cargar datos -->
			                <div class="contenedor4">
			                    <div class="row">
			                        <div class="col">
			                            <h4 class="fs-5 fw-normal">- Nombre:</h4>
			                        </div>
			                        <div class="col">
			                            <h4 class="fs-5 fw-lighter">Desarrollador Frontend</h4>
			                        </div>
			                    </div>
			                    <hr>
			                    <div class="row">
			                        <div class="col">
			                            <h4 class="fs-5 fw-normal">- Descripción:</h4>
			                        </div>
			                        <div class="col">
			                            <h4 class="fs-5 fw-lighter">Únete a nuestro equipo de desarrollo frontend y crea experiencias de usuario excepcionales.</h4>
			                        </div>
			                    </div>
			                    <hr>
			                    <div class="row">
			                        <div class="col">
			                            <h4 class="fs-5 fw-normal">- Ciudad:</h4>
			                        </div>
			                        <div class="col">
			                            <h4 class="fs-5 fw-lighter">Montevideo</h4>
			                        </div>
			                    </div>
			                    <hr>
			                    <div class="row">
			                        <div class="col">
			                            <h4 class="fs-5 fw-normal">- Departamento:</h4>
			                        </div>
			                        <div class="col">
			                            <h4 class="fs-5 fw-lighter">Montevideo</h4>
			                        </div>
			                    </div>
			                    <hr>
			                    <div class="row">
			                        <div class="col">
			                            <h4 class="fs-5 fw-normal">- Horario:</h4>
			                        </div>
			                        <div class="col">
			                            <h4 class="fs-5 fw-lighter">09:00 - 18:00</h4>
			                        </div>
			                    </div>
			                    <hr>
			                    <div class="row">
			                        <div class="col">
			                            <h4 class="fs-5 fw-normal">- Remuneración:</h4>
			                        </div>
			                        <div class="col">
			                            <h4 class="fs-5 fw-lighter">$90000</h4>
			                        </div>
			                    </div>
			                    <hr>
			                    <div class="row">
			                        <div class="col">
			                            <h4 class="fs-5 fw-normal">- Fecha:</h4>
			                        </div>
			                        <div class="col">
			                            <h4 class="fs-5 fw-lighter">14/08/2023</h4>
			                        </div>
			                    </div>
			                    <hr>
			                    <div class="row">
			                        <div class="col">
			                            <h4 class="fs-5 fw-normal">- Estado:</h4>
			                        </div>
			                        <div class="col">
			                            <h4 class="fs-5 fw-lighter">Activa</h4>
			                        </div>
			                    </div>
			                    <hr>
			                    <div class="row">
			                        <div class="col">
			                            <h4 class="fs-5 fw-normal">- Empresa:</h4>
			                        </div>
			                        <div class="col">
			                            <a href="#">
			                                <button type="button" class="btn btn-outline-secondary">EcoTech</button>
			                            </a>
			                        </div>
			                    </div>
			                    <hr>
			                </div>
			
			                
			            </div>
			        </div>
			    </div>
			    
				<div class = "contenedor4">
			    <div class="row justify-content-center">
			        <div class="col-md-6">
			            <div class="form-container justify-content-center">
			                
			                <div class="contenedorPrincipal">
			                    <div class="container">
			                        <h5 class="text-uppercase fs-5 fw-bolder">KeyWords Asociadas</h5>
			                        <div class="container">
			                            <a href="#">
			                                <button type="button" class="btn btn-outline-dark">Tiempo completo</button>
			                            </a>
			                            <a href="#">
			                                <button type="button" class="btn btn-outline-secondary">Medio tiempo</button>
			                            </a>
			                            <a href="#">
			                                <button type="button" class="btn btn-outline-secondary">Remoto</button>
			                            </a>
			                            <a href="#">
			                                <button type="button" class="btn btn-outline-secondary">Freelance</button>
			                            </a>
			                            <a href="#">
			                                <button type="button" class="btn btn-outline-secondary">Temporal</button>
			                            </a>
			                            <a href="#">
			                                <button type="button" class="btn btn-outline-secondary">Permanente</button>
			                            </a>
			                        </div>
			                    </div>
			                </div>
			                <div class="my-5"></div>
			                <div class="contenedor">
			                    <h2 class="-titulo-"><strong>Ingrese Los Datos</strong></h2>
			                    <div class="my-5"></div>
			                </div>
			                <div class="my-5"></div>
			                <div class="text-center"><i class="fa-solid fa-circle-info"></i></div>
			                <div class="my-5"></div>
			
			                <form>
			                    <div class="form-floating mb-3">
			                        <input type="text" class="form-control" id="floatingInput" placeholder="">
			                        <label for="floatingInput">Motivación de la Postulación</label>
			                    </div>
			
			                    <div class="form-floating">
			                        <textarea class="form-control" placeholder="" id="floatingTextarea" style="height: 250px"></textarea>
			                        <label for="floatingTextarea">Escriba un CV breve</label>
			                    </div>
			
			                    <div class="my-5"></div>
			
			                    <div class="container text-center">
			                        <button type="submit" class="btn btn-dark">POSTULARME</button>
			                    </div>
			                </form>
			            </div>
			        </div>
			    </div>
			</div>
		</main>
			
   <jsp:include page="/WEB-INF/template/footer.jsp"></jsp:include>
           
  </body>
</html>