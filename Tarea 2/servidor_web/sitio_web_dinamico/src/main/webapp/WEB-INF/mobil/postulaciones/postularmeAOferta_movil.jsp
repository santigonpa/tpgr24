<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          
	<%@page import= "com.webservices.controladores.publicar.DataEmpresa" %>
	<%@page import= "com.webservices.controladores.publicar.DataOferta" %>
	<%@page import= "com.webservices.controladores.publicar.DataKeyWord" %>
	<%@page import= "com.webservices.controladores.publicar.EstadoOferta" %>
    <%@page import="java.util.Set" %>
    <%@page import = "java.io.FileOutputStream" %>
    <%@page import  = "java.io.IOException" %>
    <%@page import ="java.util.Base64" %>
    <%@page import= "com.webservices.controladores.publicar.PublicadorManejadorUsuario" %>
    <%@page import="java.util.Map" %>
    <%@page import= "com.webservices.controladores.publicar.PublicadorManejadorOfertas" %>
    <%@ page import="com.webservices.controladores.publicar.WrapperArrayList" %>
    <%@ page import="java.util.ArrayList" %>
    
    
<!DOCTYPE html>
<html lang = "es">
<head>

<meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="media/css/indexStyle.css" />
    <link rel="stylesheet" href="media/css/normalize.css" />
    <link rel="stylesheet" href="media/css/consultaUsuarioStyle.css" />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Fira+Sans+Condensed:wght@300;500;900&display=swap"
    />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@300;500;900&display=swap"
    />

	<link rel="icon" href="./img/logoNuevo.png" type="image/x-icon" />

    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
      crossorigin="anonymous"
    />
  
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <!-- esto capaz hay que sacarlo despues porque es la importacion del script de bootstrap y es un js y para la parte 1 no va-->
	
	<!-- Estilos -->
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
	
	<script>
  // Obtén el elemento <select> por su ID
  var selectElement = document.getElementById("empresaSelect");

  // Agrega un event listener para el evento "change"
  selectElement.addEventListener("change", function() {
    // Obtén el formulario por su ID
    var formElement = document.getElementById("empresaForm");

    formElement.submit();
  });
	</script>


	<script>
  // Obtén el elemento <select> por su ID
  var selectElement2 = document.getElementById("keywordSelect");

  // Agrega un event listener para el evento "change"
  selectElement2.addEventListener("change", function() {
    // Obtén el formulario por su ID
    var formElement2 = document.getElementById("keywordForm");

    formElement2.submit();
  });
	</script>

	<style>
    

    </style>

    <title>Postularme a oferta laboral</title>
	</head>
<body>
    <%@ include file="../templates_movil/headerLogged_movil.jsp" %>
	
	    </header>
    <%
        // Recupera la ofertaSeleccionada de la solicitud
        DataOferta oferta = (DataOferta) request.getSession().getAttribute("dataOfertaPos");
	 	String nombre = oferta.getNombre();
	 	String desc = oferta.getDescripcion();
	 	String ciudad = oferta.getCiudad();
	 	String dep = oferta.getDepartamento();
	 	String horaI = oferta.getHoraInicio();
	 	String horaF = oferta.getHoraFin();
	 	float remuneracion = oferta.getRemuneracion();
	 	String alta = oferta.getFechaDeAlta();
	 	EstadoOferta est = oferta.getEstado();
	 	String emp = oferta.getEmpresa();
        byte[] imagenBytes = oferta.getImagen();
        String base64Image = "";
        if (imagenBytes != null) {
            base64Image = Base64.getEncoder().encodeToString(imagenBytes);
        }
       // Set<KeyWord> keys = oferta.getKeyWords(); 
        ArrayList<String> palabrasClave = (ArrayList<String>) request.getAttribute("keys");
        
    %>
    
			   <main>
			    <div class="contenedor4">
			        <div class="row justify-content-center">
			            <div class="col-12">
			                    <img src="data:image/jpeg;base64, <%= base64Image %>" class="img-thumbnail shadow" alt="...">
			            </div>
			            <div class="col-md-8">
			                <div class="contenedor4">
			                    <h2 class="text-uppercase fs-4 fw-bolder">Información de la oferta</h2>
			                </div>
			                <!-- Cargar datos -->
			                <div class="contenedor4">
			                    <div class="row">
			                        <div class="col">
			                            <h4 class="fs-5 fw-normal">Nombre:</h4>
			                        </div>
			                        <div class="col">
			                            <h4 class="fs-5 fw-lighter"><%= nombre %></h4>
			                        </div>
			                    </div>
			                    <hr>
			                    <div class="row">
			                        <div class="col">
			                            <h4 class="fs-5 fw-normal">Descripción:</h4>
			                        </div>
			                        <div class="col">
			                            <h4 class="fs-5 fw-lighter"><%= desc %></h4>
			                        </div>
			                    </div>
			                    <hr>
			                    <div class="row">
			                        <div class="col">
			                            <h4 class="fs-5 fw-normal">Ciudad:</h4>
			                        </div>
			                        <div class="col">
			                            <h4 class="fs-5 fw-lighter"><%= ciudad %></h4>
			                        </div>
			                    </div>
			                    <hr>
			                    <div class="row">
			                        <div class="col">
			                            <h4 class="fs-5 fw-normal">Departamento:</h4>
			                        </div>
			                        <div class="col">
			                            <h4 class="fs-5 fw-lighter"><%= dep %></h4>
			                        </div>
			                    </div>
			                    <hr>
			                    <div class="row">
			                        <div class="col">
			                            <h4 class="fs-5 fw-normal">Horario:</h4>
			                        </div>
			                        <div class="col">
			                            <h4 class="fs-5 fw-lighter"><%= horaI %> - <%= horaF %></h4>
			                        </div>
			                    </div>
			                    <hr>
			                    <div class="row">
			                        <div class="col">
			                            <h4 class="fs-5 fw-normal">Remuneración:</h4>
			                        </div>
			                        <div class="col">
			                            <h4 class="fs-5 fw-lighter">$<%= remuneracion %></h4>
			                        </div>
			                    </div>
			                    <hr>
			                    <div class="row">
			                        <div class="col">
			                            <h4 class="fs-5 fw-normal">Fecha:</h4>
			                        </div>
			                        <div class="col">
			                            <h4 class="fs-5 fw-lighter"><%= alta %></h4>
			                        </div>
			                    </div>
			                    <hr>
			                    <div class="row">
			                        <div class="col">
			                            <h4 class="fs-5 fw-normal">Estado:</h4>
			                        </div>
			                        <div class="col">
			                            <h4 class="fs-5 fw-lighter"><%= est %></h4>
			                        </div>
			                    </div>
			                    <hr>
			                    <div class="row">
			                        <div class="col">
			                            <h4 class="fs-5 fw-normal">Empresa:</h4>
			                        </div>
			                        <div class="col">
			                            <a href="#">
			                                <button type="button" class="btn btn-outline-secondary"><%= emp %></button>
			                            </a>
			                        </div>
			                    </div>
			                    <hr>
			                </div>
			
			                
			            </div>
			        </div>
			    </div>
			    
				<div class = "contenedor4">
			    <div class="row justify-content-center">
			        <div class="col-md-6">
			            <div class="form-container justify-content-center">
			                
			                <div class="contenedorPrincipal">
							    <div class="container">
							        <h5 class="text-uppercase fs-5 fw-bolder">Keywords Asociadas</h5>
							        <div class="container">
							            <p class="fs-6 fw-lighter">
							                <%
							                	boolean firstKeyword = true;
							                    for (String keyword : palabrasClave) {
							                        if (!firstKeyword) {
							                            out.print("<span style='margin-right: 5px;'>,</span>"); // Agregar coma y espacio entre las keywords, excepto la primera
							                        }
							                        out.print("<span>" + keyword + "</span>"); // Mostrar el nombre de la keyword
							                        firstKeyword = false;
							                    }
							                %>
							            </p>
							        </div>
							    </div>
							</div>
			                </div>
			                <div class="my-5"></div>
			                <div class="contenedor">
			                    <h2 class="-titulo- fst-italic"><strong>Ingrese los datos</strong></h2>
			                    <div class="my-5"></div>
			                </div>
			                <div class="my-5"></div>
			                <div class="text-center"><i class="fa-solid fa-circle-info"></i></div>
			                <div class="my-5"></div>
			
			                <form action = "postularmeDesdeConsultaOferta_movil" method = "POST">
			                    <div class="form-floating mb-3">
			                        <input type="text" class="form-control" id="motiv" name="motiv" placeholder="" required>
			                        <label for="floatingInput">Motivación de la Postulación</label>
			                    </div>
			
			                    <div class="form-floating">
			                        <textarea class="form-control" placeholder="" id="curriculum" name="curriculum" style="height: 250px" required></textarea>
			                        <label for="floatingTextarea">Escriba un CV breve</label>
			                    </div>
			                    
			                    <div class="form-floating mb-3">
			                        <input type="url" class="form-control" id="video" name="video" placeholder="">
			                        <label for="floatingInput">Ingrese un link a un video de YouTube si lo desea</label>
			                    </div>
			
			                    <div class="my-5"></div>
			
			                    <div class="container text-center">
			                        <button type="submit" class="btn btn-dark">POSTULARME</button>
			                    </div>
			                </form>
			            </div>
			        </div>
			    </div>
		</main>
			
	<jsp:include page="/WEB-INF/template/footer.jsp"></jsp:include>
           
  </body>
</html>