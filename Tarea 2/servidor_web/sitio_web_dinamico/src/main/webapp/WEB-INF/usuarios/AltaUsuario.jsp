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
      href="./img/logoNuevo.png"
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
    
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script>
      // Lógica para mostrar u ocultar los formularios según la pestaña seleccionada
      $(document).ready(function () {
        $("#postulante-tab").on("click", function () {
          $("#postulante").show();
          $("#empresa").hide();
        });

        $("#empresa-tab").on("click", function () {
          $("#postulante").hide();
          $("#empresa").show();
        });
      });
    </script>
    
    
    
  </head>
  <body>
    <header>
      
     
 	<nav class="navbar bg-dark px-5 ">
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
              href="inicioDeSesion.html"
              style="color: white"
              >Iniciar Sesion</a
            >
          </li>
  		</div>
  		
	</nav>
	
    </div>
</div>
    </header>
	
	<main>
      <div class="container mt-5">
        <div class="card">
          <div class="card-header">
            <ul class="nav nav-tabs card-header-tabs justify-content-center">
              <li class="nav-item">
                <a
                  class="nav-link active text-muted fs-3"
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
            
            
            
            
            <form id="alta-form" action = "/TrabajoUY/ServletAltaUsuario" method = "POST">
              <div class="text-center position-relative">
                <input
                  type="file"
                  name="profile-pic"
                  id="profile-pic"
                  class="position-absolute d-none"
                />
                <label for="profile-pic" class="profile-pic-label">
                  <img
                    src="https://cdn-icons-png.flaticon.com/512/3135/3135768.png"
                    alt="Foto de perfil"
                    class="profile-pic rounded-circle"
                  />
                </label>
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
                    required
                  />
                </div>
                <div class="form-group">
                  <label for="nombre">Nombre:</label>
                  <input
                    type="text"
                    class="form-control"
                    id="nombre"
                    name="nombre"
                    placeholder="Ingrese su Nombre"
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
                    required
                  />
                </div>
    
                <div class="tab-content">
                  <div class="tab-pane fade show active" id="postulante">
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
                        />
                      </div>
                      <div class="form-group">
                        <label for="nacionalidad">Nacionalidad:</label>
                        <input
                          type="text"
                          class="form-control"
                          id="nacionalidad"
                          name="nacionalidad"
                          placeholder="Ingrese su Nacionalidad"
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
                        ></textarea>
                      </div>
                    </div>
                  </div>
                </div>
                <div class="w-100 d-flex justify-content-center mt-3">
                  <button type="submit" class="btn btn-dark btn-block w-50">
                    Enviar
                  </button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>
    </main>
    
    <jsp:include page="/WEB-INF/template/footer.jsp"></jsp:include>
</body>
</html>