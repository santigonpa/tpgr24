<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang = "es">
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
    <title>TrabajoUY</title>
  </head>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp"></jsp:include>
	<main>
    		
    		<div class = "titulo3" style = "text-align : center; margin-top : 50px;padding:0; font-family: 'Fira Sans Condensed';">
	    		<h3 class="galeria-titulo" style = "color : rgb(0, 0, 0); text-shadow : 6px 6px 15 black;">
	            Algunos de nuestros clientes que ya consiguieron empleo con TrabajoUY.
	          	</h3>
    		</div>
      		
      		<div class="container-galeria">
				  <section class = "galeria">
				  		<img src = "media/img/jason-goodman-fXVx1opWGxM-unsplash.jpg" >
				  		<img src = "media/img/of1.jpg" >
				  		<img src = "media/img/of2.jpg" >
				  		<img src = "media/img/of3.jpg" >
				  		<img src = "media/img/k-mitch-hodge-Esi7nknKxmw-unsplash.jpg" >
				  		<img src = "media/img/irina-2Q8bo_6lu1Y-unsplash.jpg" >
				  </section>
				</div>
      		
      		
      </main>
      
      <jsp:include page="/WEB-INF/template/footer.jsp"></jsp:include>
</body>
</html>