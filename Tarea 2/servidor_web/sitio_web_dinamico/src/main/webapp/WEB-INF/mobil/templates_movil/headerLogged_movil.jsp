<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header>
      <nav class="navbar navbar-expand-lg navbar-dark bg-dark px-5">
        <div class="container-fluid">
          <a class="navbar-brand" href="/TrabajoUY/home_movil">
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
            <ul class="navbar-nav w-100 justify-content-around">
              <li class="nav-item dropdown pt-4 pt-lg-0 order-lg-1 order-3">
                <a
                  class="nav-link dropdown-toggle"
                  href="#"
                  role="button"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                  >Ofertas Laborales</a
                >
                <ul class="dropdown-menu mb-2 bg-light">
                  <li>
                    <a class="dropdown-item" href="/TrabajoUY/ConsultaDeOfertaLaboral_movil"
                      >Ver Ofertas</a
                    >
                  </li>
                
                  <li>
                    <a class="dropdown-item" href="/TrabajoUY/servelPostularmeAOferta"
                      >Postularme a oferta laboral</a
                    >
                  </li>
                </ul>
                

              <li class="nav-item order-2">
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
              <li class="nav-item dropdown pt-4 pt-lg-0 order-0 order-lg-3">
                <a class="nav-link dropdown-toggle" href="#" data-bs-toggle="dropdown">
                  <img
                    src="<%= request.getContextPath() %>/ServletImagen"
                    onerror="this.src = '/media/img/userImage.jpg'"
                    alt="Foto Perfil"
                    width="30"
                    height="30"
                    style="border-radius: 50%; margin-right: 10px"
                  />
                  Mi Usuario
                </a>
                <ul class="dropdown-menu dropdown-menu-end">
                  <li>
                    <a class="dropdown-item" href="/TrabajoUY/verPostulaciones_movil"
                      >Ver mis postulaciones</a
                    >
                  </li>
                  <li>
                    <a
                      class="dropdown-item cerrar-sesion"
                      href="javascript:void(0);"
                      onclick="confirmarCerrarSesionMovil();"
                      >Cerrar sesion</a
                    >
                  </li>
                </ul>
              </li>

             
            </ul>
          </div>
        </div>
      </nav>
      <script>
		function confirmarCerrarSesionMovil() {
    	var confirmacion = confirm("¿Estás seguro de que deseas cerrar la sesión?");
    	if (confirmacion) {
			window.location.href = "/TrabajoUY/cerrarSesion_movil";
    		}
		}
	</script>
    </header>