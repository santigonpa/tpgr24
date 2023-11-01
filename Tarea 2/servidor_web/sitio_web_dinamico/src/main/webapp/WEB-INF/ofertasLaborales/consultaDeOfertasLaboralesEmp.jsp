<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          
	<%@page import= "com.webservices.controladores.publicar.DataEmpresa" %>
	<%@page import= "com.webservices.controladores.publicar.DataOferta" %>
	<%@page import= "com.webservices.controladores.publicar.DataKeyWord" %>
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
    
.row {
--bs-gutter-x: 0rem !important;
}
    
    </style>



    <title>Ofertas Laborales</title>
	</head>
<body>
	<jsp:include page="/WEB-INF/template/headerLogged.jsp"></jsp:include>
	
	<main>
				<div class="contenedor4">
			  		<h2 class="titulo"><strong>Ofertas Laborales</strong></h2>
			  		<p>
			  		<hr>
			  		</p>
				</div>

			<div class="contenedorPrincipal">
       
	        <div class="container text-center">
	            <div class="row">
	                <div class="col">
	                    <form id="empresaForm" action="/TrabajoUY/ConsultaDeOfertaLaboral" method="get"> 
						  <select id="empresaSelect" class="form-select" aria-label="Default select example" name="empresa">
						    <option selected disabled>Filtrar por empresa</option>
						    <% 
								Set<DataEmpresa> conjuntoDeEmpresas = (Set<DataEmpresa>) request.getAttribute("coleccionDataEmpresas");
							    
							    if(!conjuntoDeEmpresas.isEmpty()){  
							    	String nickEmpresa;
							    	for (DataEmpresa dataEmp : conjuntoDeEmpresas) {
							            nickEmpresa = dataEmp.getNickName();
						    %>
						    <option value="<%= nickEmpresa %>"><%= nickEmpresa %></option>
						    <% } }%>
						  </select>
						</form>
	                </div>
	                <div class="col">
	                    <form id="keywordForm" action="/TrabajoUY/ConsultaDeOfertaLaboral" method="get"> 
						  <select id="keywordSelect" class="form-select" aria-label="Default select example" name="keyword">
						    <option selected disabled>Filtrar por KeyWord</option>
						    <% 
						       ArrayList<DataKeyWord> keys = (ArrayList<DataKeyWord>) request.getAttribute("keys");
						    	if (keys != null && !keys.isEmpty()) {
						    		String palabra;
									for (DataKeyWord key : keys) {  
						         		palabra = key.getPalabraClave();
						    %>
						    <option value="<%= palabra %>"><%= palabra %></option>
						    <% }} %>
						  </select>
						</form>
	                </div>
	            </div>
	        </div>
				  
				  <%
				  
				  if (request.getAttribute("coleccionOfertas") != null) {
					 
					  
					  
					 if(request.getParameter("empresa") != null) {
					  %>
					 
					 <div class="contenedor">
	       	 					<h2 class="titulo">Ofertas de <%= request.getParameter("empresa") %></h2>
	    					</div>
					 
					  <div class="contenedorCards">
					 		<div class="row mt-4">
					 		
					 <%
					 
					 }else{
						 
						 %>
						 
						 <div class="contenedor">
		       	 					<h2 class="titulo">Ofertas Relacionadas con la palabra clave "<%= request.getParameter("keyword") %>"</h2>
		    					</div>
						 
						  <div class="contenedorCards">
						 		<div class="row mt-4">
						 		
						 <%
					 
					 }
					  
					  
						  %>
					 
					 <% 
					 	Set<DataOferta> conjDeOfer = (Set<DataOferta>) request.getAttribute("coleccionOfertas");
					    
					    if(conjDeOfer != null && !conjDeOfer.isEmpty()){
					    
					        String nombreOfer;
					        String descripcion;
					        byte[] imagenBytes;
					
					        for (DataOferta dataOfer : conjDeOfer) {
					            nombreOfer = dataOfer.getNombre();
								descripcion = dataOfer.getDescripcion();
					            imagenBytes = dataOfer.getImagen();
					            
					            String base64Image = "";
					            if (imagenBytes != null) {
					                base64Image = Base64.getEncoder().encodeToString(imagenBytes);
					            }else{
					            	//aca va la imagen default
					            }
					            
					  
				  %>
				  
				  
				    
				    <div class="col-md-4 mb-4">
				   
				      <div class="card" style="width: 20rem;">
					        <img class="card-img-top" src="data:image/jpeg;base64, <%= base64Image %>" alt="imagen de usuario" style="object-fit: cover; width: 100%; height: 100%;">
					        <div class="card-body">
		    						<h5 class="card-title"><%= nombreOfer %></h5>
		    						<p class="card-text"><%= descripcion %></p>
									<a href="ServletDetalleOferta?id=<%= dataOfer.getNombre() %>" class="btn btn-outline-dark">+info</a>					</div>
				    	</div>
				      </div>
				      
				      
				<%
					 } //endfor
					
					 }else{ 
					 %>
					  
					  </div>
					
					</div>
					
					<%
					 
					if(request.getParameter("empresa") == null){
						 
						 %>
						 
						 <div class = "my-5"></div>
						  <div class="container">
								    <div class="row">
								        <div class="col text-center">
								            <div class="alert alert-danger" role="alert">
								                No hay ofertas registradas con esa palabra clave
								            </div>
								        </div>
								    </div>
								</div>
						 
						 <%
					 }else if(request.getParameter("keyword") == null){
				%>
				  
				 	<div class = "my-5"></div>
						  <div class="container">
								    <div class="row">
								        <div class="col text-center">
								            <div class="alert alert-danger" role="alert">
								                No hay ofertas registradas en la empresa
								              
								            </div>
								        </div>
								    </div>
								</div>
				
				<%
					  }else{
					 
					  
						  %>
						  
						  <div class = "my-5"></div>
						  <div class="container">
								    <div class="row">
								        <div class="col text-center">
								            <div class="alert alert-danger" role="alert">
								                No hay ofertas registradas en la empresa o no ha seleccionado una empresa aún
								            </div>
								        </div>
								    </div>
								</div>
						  
						  <%
							}
					 	}				 
					 }else{ 
						 
						 %>
						  
						  <div class = "my-5"></div>
						  <div class="container">
								    <div class="row">
								        <div class="col text-center">
								            <div class="alert alert-success" role="alert">
								                Selecciona una Empresa o una Keyword.
								            </div>
								        </div>
								    </div>
								</div>
						  
						  <%
						 
					 }
					 
				%>
	
	    </div>
		
	</main>
    
	 <jsp:include page="/WEB-INF/template/footer.jsp"></jsp:include>
	     
	  </body>
	  
	   <!-- SCRIPTS DEL CASO DE USO PARA MOSTRAR LAS COSAS -->
	  
	
	 <!-- Esto redirige al servlet cuando selecciona una empresa -->
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
</html>