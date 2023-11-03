<!DOCTYPE html>
<html>
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

    <link rel="icon" href="media/img/logoNuevo.png" type="image/x-icon" />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
      crossorigin="anonymous"
    />

    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
      integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
    <!-- esto capaz hay que sacarlo despues porque es la importacion del script de bootstrap y es un js y para la parte 1 no va-->
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
      crossorigin="anonymous"
    ></script>
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

    <main>
      <div
        class="header-ola"
        style="
          position: relative;
          text-align: center;
          background-image: url('media/img/kenny-eliason-4FJ14D3Ly30-unsplash.jpg');
          background-size: cover;
          background-position: center;
          color: white;
          z-index: -1;
        "
      >
        <!--Content before waves-->
        <div
          class="inner-header d-flex justify-content-center align-items-center flex-column"
        >
          <h1 class="trabajo-uy">Trabajo UY</h1>
          <h2 class="slogan-uy">
            Consigue el trabajo que buscas de la manera más fácil.
          </h2>
        </div>

        <!--Waves Container-->
        <div>
          <svg
            class="waves d-none d-lg-block"
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
                fill="rgba(255,255,255,0.7)"
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
      <div
        class="titulo3"
        style="
          text-align: center;
          margin-top: 50px;
          padding: 0;
          font-family: 'Fira Sans Condensed';
        "
      >
        <h3
          class="galeria-titulo"
          style="color: rgb(0, 0, 0); text-shadow: 6px 6px 15 black"
        >
          Algunos de nuestros clientes que ya consiguieron empleo con TrabajoUY.
        </h3>
      </div>

      <div class="container-galeria">
        <section class="galeria">
          <img src="media/img/jason-goodman-fXVx1opWGxM-unsplash.jpg" />
          <img src="media/img/of1.jpg" />
          <img src="media/img/of2.jpg" />
          <img src="media/img/of3.jpg" />
          <img src="media/img/k-mitch-hodge-Esi7nknKxmw-unsplash.jpg" />
          <img src="media/img/irina-2Q8bo_6lu1Y-unsplash.jpg" />
        </section>
      </div>
    </main>

    <!-- no se si meter ese js-->
    <script>
      function confirmarCerrarSesion() {
        var confirmacion = confirm(
          "¿Estás seguro de que deseas cerrar la sesión?"
        );
        if (confirmacion) {
          window.location.href = "/TrabajoUY/CerrarSesion";
        }
      }
    </script>

    <jsp:include page="/WEB-INF/template/footer.jsp"></jsp:include>
  </body>
</html>
