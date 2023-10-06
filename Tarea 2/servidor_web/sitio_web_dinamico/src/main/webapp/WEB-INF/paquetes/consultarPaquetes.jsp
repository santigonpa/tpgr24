<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8" />
	<link rel="stylesheet" href="media/css/indexStyle.css" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<link rel="stylesheet" href="indexStyle.css" />
	<link rel="stylesheet" href="normalize.css" />
	<link rel="stylesheet"
		href="https://fonts.googleapis.com/css2?family=Fira+Sans+Condensed:wght@300;500;900&display=swap" />
	<link rel="stylesheet"
		href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@300;500;900&display=swap" />
	
	<link rel="icon" href="./img/logoNuevo.png" type="image/x-icon" />
	
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
		rel="stylesheet"
		integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
		crossorigin="anonymous" />
	
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
	<!-- esto capaz hay que sacarlo despues porque es la importacion del script de bootstrap y es un js y para la parte 1 no va-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp"></jsp:include>
	<main>
	<div class="contenedor4">
	  		<h2 class="-titulo-"><strong>Paquetes de Tipos de Publicación de Ofertas Laborales</strong></h2>
	  		<hr>
		</div>
		
		<div class="contenedor3">
	    	<div class="row mt-4">
	        	<div class="col-md-3">
					<div class="card" style="width: auto;">
	  					<div style="overflow: hidden; width: 100%; height: 20rem;"> <!-- Corta la imagen -->
	           	 			<img class="card-img-top" src="media/img/imagenPaquete1.jpg" alt="Card image cap" style="object-fit: cover; width: 100%; height: 100%;">
	        			</div>
	 					<div class="card-body">
	    				<h5 class="card-title">Básico</h5>
	    				<a href="consultaPaqueteBasico.html" class="btn btn-outline-dark w-100">Más informacion</a>
	  					</div>
					</div>
				</div>
	
	        	<div class="col-md-3">
					<div class="card" style="width: auto;">
						<div style="overflow: hidden; width: 100%; height: 20rem;"> <!-- Corta la imagen -->
	           	 			<img class="card-img-top" src="media/img/imagenPaquete2.jpg" alt="Card image cap" style="object-fit: cover; width: 100%; height: 100%;">
	        			</div>
						<div class="card-body">
	   					<h5 class="card-title">Destacado</h5>
	   					<a href="consultaPaqueteDestacado.html" class="btn btn-outline-dark w-100">Más informacion</a>
	  					</div>
					</div>
				</div>
				
				<div class="col-md-3">
					<div class="card" style="width: auto;">
						<div style="overflow: hidden; width: 100%; height: 20rem;"> <!-- Corta la imagen -->
	           	 			<img class="card-img-top" src="media/img/imagenDefaultPaquete2.jpg" alt="Card image cap" style="object-fit: cover; width: 100%; height: 100%;">
	        			</div>
						<div class="card-body">
	   					<h5 class="card-title">Premium</h5>
	   					<a href="consultaPaqueteBasico.html" class="btn btn-outline-dark w-100">Más informacion</a>
	  					</div>
					</div>
				</div>
				
				<div class="col-md-3">
					<div class="card" style="width: auto;">
						<div style="overflow: hidden; width: 100%; height: 20rem;"> <!-- Corta la imagen -->
	           	 			<img class="card-img-top" src="media/img/imagenDefaultPaquete2.jpg" alt="Card image cap" style="object-fit: cover; width: 100%; height: 100%;">
	        			</div>
						<div class="card-body">
	   					<h5 class="card-title">Express</h5>
	   					<a href="consultaPaqueteBasico.html" class="btn btn-outline-dark w-100">Más informacion</a>
	  					</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<jsp:include page="/WEB-INF/template/footer.jsp"></jsp:include>
</body>
</html>