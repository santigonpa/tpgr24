<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
<meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="media/css/indexStyle.css" />
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
		body{
			margin: 0; /* Elimina el margen predeterminado del body */
			padding: 0; /* Elimina el relleno predeterminado del body */
			background: linear-gradient(to bottom, #212529 35%, #eee 55% );
			min-height: 50vh; /* Establece una altura mínima del viewport para main */
		}
		.bg{
			background-image: url(media/img/prueba.jpg);
			background-position: center center;
			background-size:cover;
		}
	</style>
<title>TrabajoUY</title>
</head>

<body>

	<header>
      <nav class="navbar navbar-expand-lg navbar-dark bg-dark px-5">
        <div class="container-fluid">
          <a class="navbar-brand" href="home">
            <img
              src="media/img/logoNuevo.png"
              alt="Logo"
              width="42"
              height="44"
            />
          </a>

          <button
            class="navbar-toggler"
            type="button"
            data-bs-toggle="collapse"
            data-bs-target="#navbarNav"
            aria-controls="navbarNav"
            aria-expanded="false"
            aria-label="Toggle navigation"
          >
            <span class="navbar-toggler-icon"></span>
          </button>

          <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav me-auto justify-content-around w-100">
              <li class="nav-item dropdown order-2">
                <a
                  class="nav-link dropdown-toggle d-none d-lg-block"
                  href="#"
                  role="button"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                  style="color: white"
                  >Usuarios</a
                >
                <ul class="dropdown-menu">
                  <li>
                    <a class="dropdown-item" href="/TrabajoUY/ConsultarUsuario"
                      >Perfiles</a
                    >
                  </li>
                </ul>
              </li>

              <li class="nav-item dropdown order-2">
                <a
                  class="nav-link dropdown-toggle"
                  href="#"
                  role="button"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                  style="color: white"
                  >Ofertas Laborales</a
                >
                <ul class="dropdown-menu mb-2 bg-light">
                  <li>
                    <a
                      class="dropdown-item"
                      href="/TrabajoUY/ConsultaDeOfertaLaboral"
                      >Ver Ofertas</a
                    >
                  </li>
                  <li>
                    <a
                      class="dropdown-item"
                      href="/TrabajoUY/ConsultaDeTipoDePublicacionDeOfertaLaboral"
                      >Tipos de Publicaciones</a
                    >
                  </li>
                </ul>
              </li>

              <li class="nav-item dropdown order-2">
                <a
                  class="nav-link dropdown-toggle d-none d-lg-block"
                  href="#"
                  role="button"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                  style="color: white"
                  >Paquetes</a
                >
                <ul class="dropdown-menu">
                  <li>
                    <a
                      class="dropdown-item"
                      href="/TrabajoUY/ConsultaDePaquetes"
                      >Ver Paquetes</a
                    >
                  </li>
                </ul>
              </li>

              <li class="nav-item order-0 order-lg-2">
                <form class="d-flex pt-4 pt-lg-0" role="search">
                  <input
                    class="form-control me-2"
                    type="search"
                    placeholder="Buscar"
                    aria-label="Buscar"
                  />
                  <button class="btn btn-secondary" type="submit">
                    <span class="d-none d-lg-block">Buscar</span>
                    <i
                      class="fa-solid fa-magnifying-glass d-block d-lg-none"
                    ></i>
                  </button>
                </form>
              </li>

              <li class="nav-item d-flex flex-column flex-lg-row order-2">
                <a
                  class="nav-link active"
                  href="/TrabajoUY/AltaUsuario"
                  style="color: white"
                  >Registrarse</a
                >

                <a
                  class="nav-link active"
                  href="/TrabajoUY/iniciarSesion"
                  style="color: white"
                  >Iniciar SesiÃ³n</a
                >
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </header>
	<main>
		<div class="container w-75 bg-white mt-5 mb-0 rounded shadow"  style="margin-bottom: 20px">
			<div class="row align-items-strech">
				<div class="col bg d-none d-lg-block col-md-5 col-lg-5 col-xl-6 rounded ">
					
				</div>
				<div class="col bg-white p-4 rounded-end">
					<div class="text-end">
						<img src="media/img/logoNuevo.png" width="48" alt="">
					</div>
					<h2 class="fw-bold text-center">Bienvenido</h2>
					<h5 class="fw-bold text-center">Inicio de sesión</h5>
					
					<!--Login-->
					<form action="iniciarSesion" method="POST">
						<div>
							<label for="email" class="form-label" >Usuario o Correo electrónico</label>
							<input type="text" class="form-control" name="email" required="required">
						</div>
						<div>
							<label for="password" class="form-label">Contraseña</label>
							<input type="password" class="form-control" name="password" required="required">
						</div>
						<div class="d-grid">
							<button  type="submit" class="btn btn-dark">Iniciar sesión</button>
						</div>
						<div class="my-3">
							<span>¿No tienes cuenta? <a href="AltaUsuario">Regístrate.</a></span> <br>
							<span><a href="#">Recuperar contraseña.</a></span>
						</div>
					</form>
					
					
				</div>
			</div>
		</div>
	</main>
	
	<jsp:include page="/WEB-INF/template/footer.jsp"></jsp:include>
	
</body>
</html>