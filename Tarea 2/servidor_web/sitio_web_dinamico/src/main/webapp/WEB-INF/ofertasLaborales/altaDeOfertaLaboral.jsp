<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import= "com.webservices.controladores.publicar.DataTipoPublicacion" %>
    <%@page import="java.util.Set" %>
    <%@page import="java.time.LocalDate" %>
    <%@page import= "com.webservices.controladores.publicar.DataOferta" %>
    <%@page import= "com.webservices.controladores.publicar.KeyWord" %>
    <%@page import= "com.webservices.controladores.publicar.DataKeyWord" %>
    <%@ page import="com.webservices.controladores.publicar.WrapperArrayList" %>
    <%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>TrabajoUY</title>
<!-- Estilos -->
    <link rel="stylesheet" href="media/css/altaDeUsuarioStyle.css" />
    <link rel="stylesheet" href="media/css/normalize.css" />
    <link rel="stylesheet" href="media/css/consultaUsuarioStyle.css" />

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
    
      <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>  
      
      </head>
      
	<style>
		.bg{
			background-image: url(media/img/altaOfer1.jpeg);
			background-position: center center;
			background-size:cover;
		}
	</style>

<body>
	<jsp:include page="/WEB-INF/template/headerLogged.jsp"></jsp:include>
	<main>
	    <div class="container w-75 bg-dark mt-5 mb-0 rounded shadow" style="margin-bottom: 20px">
	        <div class="row align-items-strech">
	            <br>
	            <br>
	            <div class="col bg-dark p-4 rounded-end text-center">
	             	<br>
	                <!-- Contenido de la segunda columna (derecha) -->
	                <h1 class="fw-bold text-white">Alta de Oferta Laboral</h1>
	                <br>
	                <h5 class="fw-bold text-white">Seleccione el tipo de alta</h5>
	                <br>
	                <br>
	                <br>
	                <br>
	                <br>
	                <a href="/TrabajoUY/AltaDeOfertaLaboralGeneral" class="btn btn-lg btn-outline-light mx-4">General</a>
                	<a href="/TrabajoUY/AltaDeOfertaLaboralPaquete" class="btn btn-lg btn-outline-light mx-4">Paquete</a>
	                <br>
	                <br>
	                <br>
	            </div>
	            <div class="col bg d-none d-lg-block
	             col-md-5 col-lg-5 col-xl-6 rounded">
	                <!-- Contenido de la primera columna (izquierda) -->
	            </div>
	        </div>
	    </div>
	</main>

			
	<jsp:include page="/WEB-INF/template/footer.jsp"></jsp:include>

</body>
</html>