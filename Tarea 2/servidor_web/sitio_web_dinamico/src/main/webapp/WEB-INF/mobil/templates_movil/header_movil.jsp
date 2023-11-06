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
            <ul class="navbar-nav me-auto justify-content-around w-100">

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
                  href="/TrabajoUY/iniciarSesion_movil"
                  style="color: white"
                  >Iniciar Sesión</a
                >
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </header>