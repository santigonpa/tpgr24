<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <ul class="navbar-nav w-100 justify-content-around">
              <li class="nav-item dropdown d-none d-lg-block order-1">
                <a
                  class="nav-link dropdown-toggle"
                  href="#"
                  role="button"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                  >Usuarios</a
                >
                <ul class="dropdown-menu">
                  <li>
                    <a class="dropdown-item" href="ConsultarUsuario"
                      >Perfiles</a
                    >
                  </li>
                </ul>
              </li>

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
                  <li class="d-none d-lg-block">
                    <a
                      class="dropdown-item"
                      href="/TrabajoUY/AltaDeOfertaLaboral"
                      >Crear Oferta Laboral</a
                    >
                  </li>
                  <li>
                    <a class="dropdown-item" href="ConsultaDeOfertaLaboral"
                      >Ver Ofertas</a
                    >
                  </li>
                  <li class="d-none d-md-block">
                    <a
                      class="dropdown-item"
                      href="/TrabajoUY/ConsultaDeTipoDePublicacionDeOfertaLaboral"
                      >Tipos de Publicaciones</a
                    >
                  </li>
                </ul>
              </li>

              <li class="nav-item dropdown d-none d-lg-block order-1">
                <a
                  class="nav-link dropdown-toggle"
                  href="#"
                  role="button"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
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

              <li class="nav-item ml-auto mt-auto dropdown order-1 order-lg-3">
                <a class="nav-link" href="#" data-bs-toggle="dropdown">
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
                <ul class="dropdown-menu dropdown-menu-end d-none">
                  <li>
                    <a class="dropdown-item" href="/TrabajoUY/VerPerfil"
                      >Usuario</a
                    >
                  </li>
                  <li>
                    <a class="dropdown-item" href="/TrabajoUY/ModificarUsuario"
                      >Modificar Usuario</a
                    >
                  </li>
                  <li>
                    <a
                      class="dropdown-item cerrar-sesion"
                      href="javascript:void(0);"
                      onclick="confirmarCerrarSesion();"
                      >Cerrar sesion</a
                    >
                  </li>
                </ul>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </header>