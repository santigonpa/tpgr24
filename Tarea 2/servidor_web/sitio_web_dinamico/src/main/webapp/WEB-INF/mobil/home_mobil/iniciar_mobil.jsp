<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="media/css/normalize.css" />
    <link rel="stylesheet" href="media/css/indexStyle.css" />

    <!-- FONTS -->
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Fira+Sans+Condensed:wght@300;500;900&display=swap"
    />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@300;500;900&display=swap"
    />

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>



    <!-- Icono de pag -->
    <link rel="icon" href="media/img/logoNuevo.png" type="image/x-icon" />

    <!-- BS -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
      crossorigin="anonymous"
    />

    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css"
    />

    <!-- ICONOS -->
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
    
    <script>
		$(document).ready(function(){
		    // Inicializa el carrusel
		    $('.carousel').carousel();
		
		    // Controla el evento de clic para el botón "Previous"
		    $('.carousel-control-prev').click(function(){
		        $('.carousel').carousel('prev');
		    });
		
		    // Controla el evento de clic para el botón "Next"
		    $('.carousel-control-next').click(function(){
		        $('.carousel').carousel('next');
		    });
		});
	</script>
    
    
    <title>TrabajoUY</title>
  </head>
  <body>

    <%@ include file="../templates_movil/header_movil.jsp" %>
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
          <h1 class="trabajo-uy-mobile">Trabajo UY</h1>
          <h2 class="slogan-uy fs-2 p-2">
            Postúlate al trabajo de tus sueños.
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
          Algunos de nuestros usuarios que ya consiguieron empleo con TrabajoUY.
        </h3>
      </div>
	
		<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img class="d-block w-100" src="media/img/jason-goodman-fXVx1opWGxM-unsplash.jpg">
		    </div>
		    <div class="carousel-item">
		      <img class="d-block w-100" src="media/img/of1.jpg">
		    </div>
		    <div class="carousel-item">
		      <img class="d-block w-100" src="media/img/of2.jpg">
		    </div>
		    <div class="carousel-item">
		      <img class="d-block w-100" src="media/img/of3.jpg">
		    </div>
		    <div class="carousel-item">
		      <img class="d-block w-100" src="media/img/k-mitch-hodge-Esi7nknKxmw-unsplash.jpg">
		    </div>
		  <div class="carousel-item">
		      <img class="d-block w-100" src="media/img/irina-2Q8bo_6lu1Y-unsplash.jpg">
		    </div>
		  </div>
		  
		  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		    <span class="sr-only">Next</span>
		  </a>
	</div>

      
    </main>

    <jsp:include page="/WEB-INF/mobil/templates_movil/footerMovil.jsp"></jsp:include>
  </body>
</html>
