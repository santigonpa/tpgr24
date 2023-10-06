<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 	<meta charset="UTF-8">
	<!-- Estilos -->
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
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
     
      <script>
        jQuery(document).ready(function() {
            jQuery('.collapse').on('show.bs.collapse', function() {
                // Cerrar todos los elementos colapsables, excepto el que se está abriendo
                jQuery('.collapse').not(jQuery(this)).collapse('hide');
            });
        });
    </script>
<title>TrabajoUY</title>
</head>
<body>
	<jsp:include page="/WEB-INF/template/headerLogged.jsp"></jsp:include>
	<main>
	<div class="contenedor4">
  			<h2 class="-titulo-"><strong>Tipos de Publicación de Ofertas Laborales</strong></h2>
  			<p>
  			<hr>
  			</p>
		</div>
	
	<div class="contenedor3">
    <div class="row mt-4">
        <div class="col-md-3">
            <div class="card" style="width: auto;">
                <div style="overflow: hidden; width: 100%; height: 5rem;"> <!-- Corta la imagen -->
           	 		<img class="card-img-top" src="media/img/imagenTP3.jpg" alt="Card image cap" style="object-fit: cover; width: 100%; height: 100%;">
        		</div>
                <div class="card-body">
                    <h5 class="card-title">Básica</h5>
                    <button class="btn btn-outline-dark" type="button" data-bs-toggle="collapse" data-bs-target="#infoBasica" aria-expanded="false" aria-controls="multiCollapseExample">Más informacion</button>
                </div>
            </div>
        </div>
        
        <div class="col-md-3">
            <div class="card" style="width: auto;">
                <div style="overflow: hidden; width: 100%; height: 5rem;"> <!-- Corta la imagen -->
           	 		<img class="card-img-top" src="media/img/imagenTP2.jpg" alt="Card image cap" style="object-fit: cover; width: 100%; height: 100%;">
        		</div>
                <div class="card-body">
                    <h5 class="card-title">Estándar</h5>
                   <button class="btn btn-outline-dark" type="button" data-bs-toggle="collapse" data-bs-target="#infoEstandar" aria-expanded="false" aria-controls="multiCollapseExample2">Más informacion</button>
                </div>
            </div>
        </div>
        
        <div class="col-md-3">
            <div class="card" style="width: auto;">
                <div style="overflow: hidden; width: 100%; height: 5rem;"> <!-- Corta la imagen -->
           	 		<img class="card-img-top" src="media/img/imagenTP5.jpg" alt="Card image cap" style="object-fit: cover; width: 100%; height: 100%;">
        		</div>
                <div class="card-body">
                    <h5 class="card-title">Premium</h5>
                    <button class="btn btn-outline-dark" type="button" data-bs-toggle="collapse" data-bs-target="#infoPremium" aria-expanded="false" aria-controls="multiCollapseExample3">Más informacion</button>
                </div>
            </div>
        </div>
        
        <div class="col-md-3">
            <div class="card" style="width: auto;">
                <div style="overflow: hidden; width: 100%; height: 5rem;"> <!-- Corta la imagen -->
           	 		<img class="card-img-top" src="media/img/imagenTP4.jpg" alt="Card image cap" style="object-fit: cover; width: 100%; height: 100%;">
        		</div>
                <div class="card-body">
                    <h5 class="card-title">Destacada</h5>
                   <button class="btn btn-outline-dark" type="button" data-bs-toggle="collapse" data-bs-target="#infoDestacada" aria-expanded="false" aria-controls="multiCollapseExample4">Más informacion</button>
                </div>
            </div>
        </div>
    </div>
</div>
	
	<div class="contenedor4">
  		<div class="col">
    		<div class="collapse multi-collapse" id="infoDestacada" >
     		 <div class="card card-body">
       <strong style="font-size: 18px;">DESTACADA: DESTACA TU ANUNCIO </strong><br>
       <span style="font-size: 18px;">Exposición: 2 <br>
       Duración: 15 días <br>
       Costo: 500 <br>
       Fecha de alta: 05/08/2023 <br>
       </span>
     	 		</div>
   	 		</div>
 		 </div>
 		 
  	<div class="col">
    	<div class="collapse multi-collapse" id="infoBasica">
      		<div class="card card-body">
       	<strong style="font-size: 18px;">BÁSICA: PUBLICA DE FORMA SENCILLA EN LA LISTA DE OFERTAS </strong><br>
       	<span style="font-size: 18px;">Exposición: 4 <br>
      	Duración: 7 días <br>
       	Costo: 50 <br>
       	Fecha de alta: 07/08/2023 <br>
       	</span>
     			 </div>
    		</div>
  		</div>
  		
  	<div class="col">
    	<div class="collapse multi-collapse" id="infoEstandar">
      		<div class="card card-body">
       	<strong style="font-size: 18px;">ESTÁNDAR: MEJORA LA POSICION DE TU ANUNCIO </strong><br>
       	<span style="font-size: 18px;">Exposición: 3 <br>
       	Duración: 20 días <br>
       	Costo: 150 <br>
       	Fecha de alta: 15/08/2023 <br>
       	</span>
     			 </div>
    		</div>
  		</div>
  		
  	<div class="col">
    	<div class="collapse multi-collapse" id="infoPremium">
      		<div class="card card-body">
       	<strong style="font-size: 18px;">PREMIUM: OBTÉN MÁXIMA VISIBILIDAD </strong><br>
        <span style="font-size: 18px;">Exposición: 1 <br>
       	Duración: 30 días <br>
       	Costo: 4000 <br>
       	Fecha de alta: 10/08/2023 <br>
       	</span>
     			 </div>
    		</div>
  		</div>
  		
	</div>	
	</main>
	<jsp:include page="/WEB-INF/template/footer.jsp"></jsp:include>
</body>
</html>