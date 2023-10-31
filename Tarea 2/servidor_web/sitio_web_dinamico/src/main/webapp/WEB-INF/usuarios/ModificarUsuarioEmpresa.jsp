<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import= "com.webservices.controladores.publicar.DataUsuario" %>
    <%@page import= "com.webservices.controladores.publicar.DataEmpresa" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trabajo Uy : Modificar datos del usuario</title>
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
              <li><a class="dropdown-item" href="/TrabajoUY/ConsultaDePaquetes">Comprar Paquetes</a></li>
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
	</header>	
	<main>
			<div class="card">
				<div class="card-header">
					<ul class="nav nav-tabs card-header-tabs justify-content-center">
						<li class="nav-item"><a
							class="nav-link active text-muted fs-3" id="postulante-tab"
							data-toggle="tab" href="#empresa">Modificar
								Empresa</a></li>
					</ul>
				</div>
				<div class="card-body">
					<form id="alta-form" action = "/TrabajoUY/ModificarUsuario" method = "POST" enctype="multipart/form-data">
						 <div class="text-center position-relative">
				    <label style="font-weight: bold; font-size: 18px;">Seleccione una imagen (opcional)</label>
				</div>
				<div class = "profile-container" ></div>
                
                
                <% DataEmpresa usrEmp = (DataEmpresa) usr; %>
                
               <div class = "my-4">
					
					<div class="form-floating mb-3"> 
					    <input name="profile-pic" type="file" class="form-control mx-0 px-0" id="floatingInput" accept="image/*">
					</div>
						<div class="d-flex flex-column align-items-center mt-3">
							<div>
								<div class="d-flex align-items-center">
									<p class="fs-6 me-4 pt-3">Nickname:</p>
									 <input type="text"
									class="form-control" id="nickname" name="nickname"
									  value="<%= usrEmp.getNickName() %>"  disabled/>
								</div>
								<div class="d-flex align-items-center">
									<p class="fs-6 me-4 pt-3">Correo:</p>
									<input type="text"
									class="form-control" id="correo" name="correo"
									  value="<%= usrEmp.getEmail() %>"  disabled/>
								</div>
							</div>
						</div>
						</div>
						<div class="form-container">
							<div class="form-group">
								<label for="nombre">Modificar Nombre:</label> <input type="text"
									class="form-control" id="nombre" name="nombre"
									placeholder="Ingrese su Nombre"  value="<%= usrEmp.getNombre() %>" 
									required />
							</div>
							<div class="form-group">
								<label for="apellido">Modificar Apellido:</label> <input
									type="text" class="form-control" id="apellido" name="apellido"
									placeholder="Ingrese su Apellido"  value="<%= usrEmp.getApellido() %>"
									required />
							</div>
							<div class="form-group">
								<label for="password">Modificar Contraseña:</label> <input
									type="text" class="form-control" id="password"
									name="password" placeholder="Ingrese su Contraseña"
									value="<%= usrEmp.getPsw() %>"
									 required />
							</div>
							<div class="form-group">
								<label for="confirmPassword">Repetir Contraseña la nueva Contraseña:</label> <input
									type="text" class="form-control" id="confirmPassword"
									name="confirmPassword" placeholder="Repita su Contraseña"
									required />
							</div>
							<div class="tab-content">
								
								<div class="tab-pane fade show active" id="empresa">
									<!-- Campos espec�ficos para empresas -->
									<div class="form-container">
										<div class="form-group">
											<label for="linkSitio">Modificar Link a Sitio Web:</label> 
											<input
												type="url" class="form-control" id="linkSitio"
												name="linkSitio"
												placeholder="Ingrese el Link a su Sitio Web"
												value="<%= usrEmp.getWeb() %>" 
												/>
										</div>
										<div class="form-group">
											<label for="nombre">Modificar Descripcion:</label> 
											<textarea
											  class="form-control"
											  id="descripcion"
											  name="descripcion"
											  rows="3"
											  placeholder="Ingrese una Descripción"
											><%= usrEmp.getDescripcion() %>
											</textarea>
										</div>
									</div>
								</div>
							</div>
							<div class="w-100 d-flex justify-content-center mt-3">
								<button type="submit" class="btn btn-dark btn-block w-50">
									MODIFICAR
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		
	</main>
	
	

	<jsp:include page="/WEB-INF/template/footer.jsp"></jsp:include>
</body>
</html>