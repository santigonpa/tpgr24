<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trabajo Uy</title>
 <!-- Estilos -->
    <link rel="stylesheet" href="media/css/altaDeUsuarioStyle.css" />
    <link rel="stylesheet" href="media/css/normalize.css" />
    <link rel="stylesheet" href="media/css/indexStyle.css" />

    <!-- Bootstrap -->
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
      rel="icon"
      href="C:/Users/Usuario/git/tpgr24/Tarea 2/servidor_web/img/logoNuevo.png"
      type="image/x-icon"
    />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
      crossorigin="anonymous"
    />
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
      crossorigin="anonymous"
    ></script>
 <script>
        function validarContraseñas() {
  // Obtener los valores de las contraseñas
  var contraseña1 = document.getElementById("password").value;
  var contraseña2 = document.getElementById("confirmPassword").value;

  // Comparar las contraseñas
  if (contraseña1 !== contraseña2) {
    // Si las contraseñas no coinciden, mostrar un mensaje de error
    alert("Las contraseñas no coinciden. Por favor, inténtalo de nuevo.");
    return false; // Evitar el envío del formulario
  }
  return true; // Envío del formulario si las contraseñas coinciden
}

document.addEventListener("DOMContentLoaded", function () {
  var form = document.getElementById("alta-form");
  form.addEventListener("submit", function (event) {
    if (!validarContraseñas()) {
      event.preventDefault(); // Evita que el formulario se envíe si las contraseñas no coinciden
    }
  });
});

	</script>
	<script>
    function validarFormulario() {
        
    	// Obtener el valor del campo fechaNacimiento
        var fechaNacimiento = document.getElementById("fechaNacimiento").value;

        // Expresión regular para verificar el formato de fecha (YYYY-MM-DD)
        var regexFecha = /^\d{4}-\d{2}-\d{2}$/;

        // Verificar si la fecha no está en blanco y cumple con el formato esperado
        if (!fechaNacimiento.match(regexFecha) && document.getElementById("tipoUsuario").value === "postulante") {
            document.getElementById("fechaNacimientoError").innerHTML = "Debe seleccionar una fecha válida en formato YYYY-MM-DD.";
            return false; // Detener el envío del formulario
        }

        // Restablecer el mensaje de error si la fecha es válida
        document.getElementById("fechaNacimientoError").innerHTML = "";
        return true; // Permitir el envío del formulario si la fecha es válida
    }
    
    // Agregar un evento de escucha al formulario para la validación
    document.addEventListener("DOMContentLoaded", function () {
        var form = document.getElementById("alta-form");
        form.addEventListener("submit", function (event) {
            if (!validarFormulario())  
                event.preventDefault(); // Evita que el formulario se envíe si la fecha no es válida
            }
        });
    });
</script>
</head>
<body>
 <header>
      <!-- donde dice/buscar es la direccion donde va a llevar, y variable q es la que almacena la busqueda -->
      <!-- esto se debe implementar mas adelante  
            
                <img class = "logotipo-trabajouy" src="logotipoTrabajoUy-transformed.png" alt="Logotipo de Mi Sitio">
            
            
            -->

	<nav class="navbar bg-dark px-5">
    	<a class="navbar-brand" href="index.html">
      		<img src="./img/logoNuevo.png"
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
              <li><a class="dropdown-item" href="consultaDeUsuario.html">Perfiles</a></li>
              
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
	</header>	
	<main>
	<label for="profile-pic" class="profile-pic-label">
                  <img
                    src="media/img/userImage.jpg"
                    alt="Foto de perfil"
                    class="profile-pic rounded-circle"
                  />
                </label>
                
               <div class = "my-4"></div>
					
					<div class="form-floating mb-3"> 
					    <input name="profile-pic" type="file" class="form-control mx-0 px-0" id="floatingInput" accept="image/*">
					</div>
		<div class="container mt-5">
			<div class="card">
				<div class="card-header">
					<ul class="nav nav-tabs card-header-tabs justify-content-center">
						<li class="nav-item"><a
							class="nav-link active text-muted fs-3" id="postulante-tab"
							data-toggle="tab" href="#postulante">Modificar
								Usuario</a></li>
					</ul>
				</div>
				<div class="card-body">
					<form id="alta-form">
						<div class="text-center position-relative">
							<input type="file" name="profile-pic" id="profile-pic"
								class="position-absolute d-none" /> <label
								for="profile-pic" class="profile-pic-label"> <img
								src="https://imgv3.fotor.com/images/gallery/a-woman-linkedin-picture-with-grey-background-made-by-LinkedIn-Profile-Picture-Maker.jpg" alt="Foto de perfil"
								class="profile-pic rounded-circle" />
							</label>
						</div>
						<div class="d-flex flex-column align-items-center mt-3">
							<div>
								<div class="d-flex align-items-center">
									<p class="fs-6 me-4 pt-3">Nickname:</p>
									 <input type="text"
									class="form-control" id="nickname" name="nickname"
									  value="<%= request.getParameter("nickname") != null ? request.getParameter("nickname") : "" %>"  disabled/>
								</div>
								<div class="d-flex align-items-center">
									<p class="fs-6 me-4 pt-3">Correo:</p>
									<input type="text"
									class="form-control" id="correo" name="correo"
									  value="<%= request.getParameter("correo") != null ? request.getParameter("correo") : "" %>"  disabled/>
								</div>
							</div>
						</div>
						<div class="form-container">
							<div class="form-group">
								<label for="nombre">Modificar Nombre:</label> <input type="text"
									class="form-control" id="nombre" name="nombre"
									placeholder="Ingrese su Nombre"  value="<%= request.getParameter("nombre") != null ? request.getParameter("nombre") : "" %>" 
									required />
							</div>
							<div class="form-group">
								<label for="apellido">Modificar Apellido:</label> <input
									type="text" class="form-control" id="apellido" name="apellido"
									placeholder="Ingrese su Apellido"  value="<%= request.getParameter("apellido") != null ? request.getParameter("apellido") : "" %>"
									required />
							</div>
							<div class="form-group">
								<label for="password">Modificar Contraseña:</label> <input
									type="password" class="form-control" id="password"
									name="password" placeholder="Ingrese su Contraseña"
									value="<%= request.getParameter("password") != null ? request.getParameter("password") : "" %>"
									 required />
							</div>
							<div class="form-group">
								<label for="confirmPassword">Repetir Contraseña:</label> <input
									type="password" class="form-control" id="confirmPassword"
									name="confirmPassword" placeholder="Repita su Contraseña"
									required />
							</div>
							<div class="tab-content">
								<div class="tab-pane fade show active" id="postulante">
									<!-- Campos espec�ficos para personas -->
									<div class="form-container">
										<div class="form-group">
											<label for="fechaNacimiento">Modificar Fecha de
												Nacimiento:</label> <input type="date" class="form-control"
												id="fechaNacimiento" name="fechaNacimiento"
												placeholder="Ingrese su Fecha de Nacimiento"
												value="<%= request.getParameter("fechaNacimiento") != null ? request.getParameter("fechaNacimiento") : "" %>" />
										</div>
										
                   					     <div id="fechaNacimientoError" class="text-danger"></div>
									
										<div class="form-group">
											<label for="nacionalidad">Modificar Nacionalidad:</label> <input
												type="text" class="form-control" id="nacionalidad"
												name="nacionalidad" placeholder="Ingrese su Nacionalidad"
												value="<%= request.getParameter("nacionalidad") != null ? request.getParameter("nacionalidad") : "" %>"/>
										</div>
									</div>
								</div>
								<div class="tab-pane fade" id="empresa">
									<!-- Campos espec�ficos para empresas -->
									<div class="form-container">
										<div class="form-group">
											<label for="linkSitio">Modificar Link a Sitio Web:</label> <input
												type="url" class="form-control" id="linkSitio"
												name="linkSitio"
												placeholder="Ingrese el Link a su Sitio Web"
												value="<%= request.getParameter("linkSitio") != null ? request.getParameter("linkSitio") : "" %>" />
										</div>
										<div class="form-group">
											<label for="descripcion" class="mb-3">Modificar
												Descripci�n:</label>
											<textarea class="form-control" id="descripcion"
												name="descripcion" rows="3"
												placeholder="Ingrese una Descripci�n"
												value="<%= request.getParameter("descripcion") != null ? request.getParameter("descripcion") : "" %>">
												</textarea>
										</div>
									</div>
								</div>
							</div>
							<div class="w-100 d-flex justify-content-center mt-3">
								<button type="submit" class="btn btn-dark btn-block w-50">
									Enviar</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</main>

	<!--Footer-->
       <footer class="bs-light text-dark pt-5">
		   <div class="contenedor5 text-center text-md-start">
			   <div class ="row text-center text-md-start">
	  
				   <div class="col-md-3 col-lg-3 col-xl-3 mx-auto mt-3">
					   <h5 class="text-uppercase mb-4 font-weight-bold text-dark">Nosotros</h5>
					   <hr class="mb-3">
					  <p> 
       				  Desde nuestra creación en 2023, hemos sido una plataforma dedicada a facilitar la conexión entre empresas y postulantes en busca de oportunidades laborales emocionantes. Ya seas una empresa en busca de un talento o un postulante en búsqueda de tu próximo desafío, estamos aquí para ayudarte a alcanzar tus metas.
    				  </p>
    				 <p>
        			Nuestra misión es servir como el puente que une a empleadores y futuros empleados, ayudando a construir equipos exitosos y carreras sólidas. ¡Únete a nuestra comunidad y da el siguiente paso en tu camino profesional!
    				</p>
					</div>
					   
					   <div class = "col-md-2 col-lg-2 col-xl-2 mx-auto mt-3">
							<h5 class="text-uppercase mb-4 font-weight-bold text-dark">Déjanos ayudarte</h5> 
							<hr class="mb-3">
							<p>
								<a href="inicioDeSesion.html" class="text-dark">Tu cuenta</a>
							</p>
							<p>
								<a href="consultaDeOfertasLaborales.html" class="text-dark">Ofertas</a>
							</p>
							<p>
								<a href="consultaDeTiposDePublicacionDeOfertasLaborales.html" class="text-dark">Tipos de publicación</a>
							</p>
							<p>
								<a href="#" class="text-dark">Ayuda</a>
							</p>
					   </div>
					   
					    <div class = "col-md-2 col-lg-2 col-xl-2 mx-auto mt-3">
							<h5 class="text-uppercase mb-4 font-weight-bold text-dark">Contacto</h5> 
							<hr class="mb-3">
							<p>
								<li class="fas fa-map me-3"></li>Av. Julio Herrera y Reissig 565
							</p>
							<p>
								<li class="fas fa-envelope me-3"></li>trabajouy@jobs.com
							</p>
							<p>
								<li class="fas fa-phone me-3"></li>2714 2714
							</p>
							<p>
								<li class="fas fa-university me-3"></li>FING
							</p>
					   </div>
					   
					   <div class = "col-md-2 col-lg-2 col-xl-2 mx-auto mt-3">
						<h5 class="text-uppercase mb-4 font-weight-bold text-dark">Newsletter</h5> 
						<hr class="mb-3">
						
						<form action="">
                        	<div class="form-group">
                            	<input type="email" class="form-control" placeholder="Email"
                                 required="required"/>
                        	</div>
                        	<div>
                            	<button class="btn btn-outline-dark" type="submit">Suscribirme</button>
                        	</div>
                    	</form>
					   </div>
					   
				
					   
					<div class="text-center mb-2">
					<p>	
						© 2023 FRAGSESAMA & Cía. S.A.
					</p>
					<p>
						Todos los derechos reservados.
					</p>
					</div>
					
					<div class="text-center">
						<ul class="list-unstyled list-inline">
							<li class="list-inline-item">
								<a href="#" class="text-dark"><i class = "fab fa-facebook"></i>
								</a>
							</li>
							<li class="list-inline-item">
								<a href="#" class="text-dark"><i class = "fab fa-twitter"></i>
								</a>
							</li>
							<li class="list-inline-item">
								<a href="#" class="text-dark"><i class = "fab fa-google-plus"></i>
								</a>
							</li>
							<li class="list-inline-item">
								<a href="#" class="text-dark"><i class = "fab fa-linkedin-in"></i>
								</a>
							</li>
							<li class="list-inline-item">
								<a href="#" class="text-dark"><i class = "fab fa-youtube"></i>
								</a>
							</li>
						</ul>
				    </div>
				    
        		</div>
        	</div>
 
	</footer>
</body>
</html>