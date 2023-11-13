<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>TrabajoUY</title>

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
    function validarFormulario() {
    	  // Obtener el valor del campo fechaNacimiento
    	  var fechaNacimiento = document.getElementById("fechaNacimiento").value;

    	  // Verificar si el campo está vacío o no es una fecha válida
    	  if (!fechaNacimiento) {
    	    document.getElementById("fechaNacimientoError").innerHTML = "Debe seleccionar una fecha válida.";
    	    return false; // Detener el envío del formulario
    	  }

    	  // Restablecer el mensaje de error si la fecha es válida
    	  document.getElementById("fechaNacimientoError").innerHTML = "";
    	  return true; // Permitir el envío del formulario si la fecha es válida
    	}

 </script>
    
	
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
      // Lógica para mostrar u ocultar los formularios según la pestaña seleccionada
      $(document).ready(function () {
  $("#postulante-tab").on("click", function () {
    $("#postulante").show();
    $("#empresa").hide();
    $("#tipoUsuario").val("postulante"); // Actualiza el valor del campo oculto
  });

  $("#empresa-tab").on("click", function () {
    $("#postulante").hide();
    $("#empresa").show();
    $("#tipoUsuario").val("empresa"); // Actualiza el valor del campo oculto
  });
});

    </script>
    
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
	    $(document).ready(function () {
	        $("#nickname").on("input", function () {
	            var nickname = $(this).val();
	            $.ajax({
	                type: "POST",
	                url: "/TrabajoUY/ValidacionDeAjax",
	                data: { action: "checkNickname", nickname: nickname },
	                success: function (response) {
	                    $("#nicknameStatus").html(response);
	                }
	            });
	        });
	    });
	</script>
	
	
	<script>
	    $(document).ready(function () {
	        $("#correo").on("input", function () {
	            var correo = $(this).val();
	            $.ajax({
	                type: "POST",
	                url: "ValidacionDeAjax",
	                data: { action: "checkEmail", correo: correo },
	                success: function (response) {
	                	console.log("Despues de llamar a email");
	                    $("#emailStatus").html(response);
	                }
	            });
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
            if (!validarFormulario()) {
                event.preventDefault(); // Evita que el formulario se envíe si la fecha no es válida
            }
        });
    });
</script>






	
    
    
    
  </head>
  <body>
    <jsp:include page="/WEB-INF/template/header.jsp"></jsp:include>
	
	<main>
      <div class="container mt-5">
        <div class="card">
          <div class="card-header">
            <ul class="nav nav-tabs card-header-tabs justify-content-center">
              <li class="nav-item">
                <a
                  class="nav-link text-muted fs-3"
                  id="postulante-tab"
                  data-toggle="tab"
                  href="#postulante"
                  >Postulante</a
                >
              </li>
              <li class="nav-item">
                <a
                  class="nav-link text-muted fs-3"
                  id="empresa-tab"
                  data-toggle="tab"
                  href="#empresa"
                  >Empresa</a
                >
              </li>
            </ul>
          </div>
          <div class="card-body">
            
            
            
            
            <form id="alta-form" action = "/TrabajoUY/AltaUsuario" method = "POST" enctype="multipart/form-data">
              
              
              <input type="hidden" id="tipoUsuario" name="tipoUsuario" value="<%= request.getParameter("tipoUsuario") != null ? request.getParameter("tipoUsuario") : "postulante" %>" />
              
              
              <div class="text-center position-relative">
                
                <div class="text-center position-relative">
				    <label style="font-weight: bold; font-size: 18px;">Seleccione una imagen (opcional)</label>
				</div>
				<div class = "my-3"></div>
                
                
                <label for="profile-pic" class="profile-pic-label">
                  <img
                    src="media/img/userImage.jpg"
                    alt="Foto de perfil"
                    class="profile-pic rounded-circle"
                  />
                </label>
                
                <% if (request.getAttribute("campoInvalido") != null) { %>
				    <div class="alert alert-danger">
				      <%= request.getAttribute("campoInvalido") %>
				    </div>
				  <% } %>
                
               <div class = "my-4"></div>
					
					<div class="form-floating mb-3"> 
					    <input name="profile-pic" type="file" class="form-control mx-0 px-0" id="floatingInput" accept="image/*">
					</div>
									
                
              </div>
              
              <div class="form-container">
                <div class="form-group">
                  <label for="nickname">Nickname:</label>
                  <input
                    type="text"
                    class="form-control"
                    id="nickname"
                    name="nickname"
                    placeholder="Ingrese su Nickname"
                    value="<%= request.getParameter("nickname") != null ? request.getParameter("nickname") : "" %>"
                    required
                  />
                  
                  <% if (request.getAttribute("errorRegistroNickname") != null) { %>
				    <div class="alert alert-danger">
				      <%= request.getAttribute("errorRegistroNickname") %>
				    </div>
				  <% } %>
                  
                </div>
                <span id = "nicknameStatus" style="color:red;"></span>
                
                <div class="form-group">
                  <label for="nombre">Nombre:</label>
                  <input
                    type="text"
                    class="form-control"
                    id="nombre"
                    name="nombre"
                    placeholder="Ingrese su Nombre"
                    value="<%= request.getParameter("nombre") != null ? request.getParameter("nombre") : "" %>"
                    required
                  />
                </div>
                <div class="form-group">
                  <label for="apellido">Apellido:</label>
                  <input
                    type="text"
                    class="form-control"
                    id="apellido"
                    name="apellido"
                    placeholder="Ingrese su Apellido"
                    value="<%= request.getParameter("apellido") != null ? request.getParameter("apellido") : "" %>"
                    required
                  />
                </div>
                <div class="form-group">
                  <label for="password">Contraseña:</label>
                  <input
                    type="password"
                    class="form-control"
                    id="password"
                    name="password"
                    placeholder="Ingrese su Contraseña"
                    value="<%= request.getParameter("password") != null ? request.getParameter("password") : "" %>"
                    required
                  />
                </div>
                <div class="form-group">
                  <label for="confirmPassword">Repetir Contraseña:</label>
                  <input
                    type="password"
                    class="form-control"
                    id="confirmPassword"
                    name="confirmPassword"
                    placeholder="Repita su Contraseña"
                    value="<%= request.getParameter("password") != null ? request.getParameter("password") : "" %>"
                    required
                  />
                </div>
                
                <div class="form-group">
                  <label for="correo">Correo:</label>
                  <input
                    type="email"
                    class="form-control"
                    id="correo"
                    name="correo"
                    placeholder="Ingrese su Correo"
                    value="<%= request.getParameter("correo") != null ? request.getParameter("correo") : "" %>"
                    required
                  />
                  
                  <% if (request.getAttribute("errorRegistroEmail") != null) { %>
				    <div class="alert alert-danger">
				      <p>El email que estas ingresando ya está registrado en la plataforma</p>
				    </div>
				  <% } %>
				                  
                </div>
    			<span id = "emailStatus" style="color: red;"></span>
    			
                <div class="tab-content">
                  <div class="tab-pane fade" id="postulante">
                    <!-- Campos específicos para personas -->
                    <div class="form-container">
                      <div class="form-group">
                        <label for="fechaNacimiento">Fecha de Nacimiento:</label>
                        <input
                          type="date"
                          class="form-control"
                          id="fechaNacimiento"
                          name="fechaNacimiento"
                          placeholder="Ingrese su Fecha de Nacimiento"
                          value="<%= request.getParameter("fechaNacimiento") != null ? request.getParameter("fechaNacimiento") : "" %>"
                        />
                        
                        <div id="fechaNacimientoError" class="text-danger"></div>
  						</div>
                     
                     
                      </div>
                      <div class="form-group">
                        <label for="nacionalidad">Nacionalidad:</label>
                        <input
                          type="text"
                          class="form-control"
                          id="nacionalidad"
                          name="nacionalidad"
                          placeholder="Ingrese su Nacionalidad"
                          value="<%= request.getParameter("nacionalidad") != null ? request.getParameter("nacionalidad") : "" %>"
                        />
                      </div>
                    </div>
                  </div>
                  <div class="tab-pane fade" id="empresa">
                    <!-- Campos específicos para empresas -->
                    <div class="form-container">
                      <div class="form-group">
                        <label for="linkSitio">Link a Sitio Web:</label>
                        <input
                          type="url"
                          class="form-control"
                          id="linkSitio"
                          name="linkSitio"
                          placeholder="Ingrese el Link a su Sitio Web"
                          value="<%= request.getParameter("linkSitio") != null ? request.getParameter("linkSitio") : "" %>"
                        />
                      </div>
                      <div class="form-group">
                        <label for="descripcion" class="mb-3">Descripción:</label>
                        <textarea
						  class="form-control"
						  id="descripcion"
						  name="descripcion"
						  rows="3"
						  placeholder="Ingrese una Descripción"
						><%= request.getParameter("descripcion") != null ? request.getParameter("descripcion") : "" %></textarea>

                      </div>
                    </div>
                  </div>
                </div>
                <div class="w-100 d-flex justify-content-center mt-3">
                  <button type="submit" class="btn btn-dark btn-block w-50">
                    Enviar
                  </button>
                </div>
               </form>
              </div>
          </div>
        </div>
    </main>
    
    <script>
  // Obtener el valor de tipoUsuario
  
  var tipoUsuario = "<%= request.getParameter("tipoUsuario") != null ? request.getParameter("tipoUsuario") : "postulante" %>";

  // Verificar el valor y seleccionar la pestaña correspondiente
  if (tipoUsuario === "empresa") {
    // Selecciona la pestaña de Empresa
    $("#empresa-tab").tab("show");
  } else {
    // Selecciona la pestaña de Postulante (predeterminado)
    $("#postulante-tab").tab("show");
  }
</script>


    
    <jsp:include page="/WEB-INF/template/footer.jsp"></jsp:include>
</body>
</html>