<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.webservices.controladores.publicar.DataTipoPublicacion" %>
<%@page import="java.util.Set" %>
<%@page import="java.time.LocalDate" %>
<%@page import="com.webservices.controladores.publicar.DataOferta" %>
<%@page import="com.webservices.controladores.publicar.KeyWord" %>
<%@page import="com.webservices.controladores.publicar.DataKeyWord" %>
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
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Fira+Sans+Condensed:wght@300;500;900&display=swap" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@300;500;900&display=swap" />

<link rel="icon" href="media/img/logoNuevo.png" type="image/x-icon" />

<link rel="icon" href="C:/Users/Usuario/git/tpgr24/Tarea 2/servidor_web/img/logoNuevo.png" type="image/x-icon" />
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
    crossorigin="anonymous"
/>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
    integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
    crossorigin="anonymous" referrerpolicy="no-referrer" />

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
    crossorigin="anonymous"
></script>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script>
    function validarFormulario() {
        var tipoPubli = document.getElementById("tipoPubli").value;
        var nombre = document.getElementById("nombre").value;
        var descripcion = document.getElementById("descripcion").value;
        var departamento = document.getElementById("departamento").value;
        var ciudad = document.getElementById("ciudad").value;
        var horaDeInicio = document.getElementById("horaDeInicio").value;
        var horaDeFin = document.getElementById("horaDeFin").value;
        var remuneracion = document.getElementById("remuneracion").value;

        if (tipoPubli == "" || nombre == "" || descripcion == "" || departamento == "" || ciudad == "" || horaDeInicio == "" || horaDeFin == "" || remuneracion == "") {
            alert("Todos los campos son obligatorios");
            return false; // Evita que el formulario se envíe si hay campos vacíos
        } else {
            return true; // Permite que el formulario se envíe si todas las validaciones pasan
        }
    }

    // Agregar un evento de escucha al formulario para la validación
    document.addEventListener("DOMContentLoaded", function () {
        var form = document.getElementById("alta-formGral");
        form.addEventListener("submit", function (event) {
            if (!validarFormulario()) {
                event.preventDefault();
            }
        });
    });
</script>


</head>

<body>
<jsp:include page="/WEB-INF/template/headerLogged.jsp"></jsp:include>
	<main>
	
	<div class="my-5"></div>

	<div class="row justify-content-center">
		<div class="col-md-6">
		<div align="center">
    	<h2><strong>Alta de Oferta Laboral</strong></h2>	
		</div>
		</div>
	</div>	
	
	<div class="container mt-5"> 
        <div class="card">
        
	 <% if (request.getAttribute("errorNombreOferta") != null) { %>
				    <div class="alert alert-danger">
				    <div class = "text-center"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></div>
					<hr>
				      <%= request.getAttribute("errorNombreOferta") %>
				      <br>
				      <a href="/TrabajoUY/AltaDeOfertaLaboralGeneral" class="text-dark">Reintentar</a>
				    </div>
				  <% } %>
				  
			<% if (request.getAttribute("errorTipoPubli") != null) { %>
			    <div class="alert alert-danger">
			        <div class="text-center"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></div>
			        <hr>
			        <%= request.getAttribute("errorTipoPubli") %>
			        <br>
			        <a href="/TrabajoUY/AltaDeOfertaLaboralGeneral" class="text-dark">Reintentar</a>
			    </div>
			<% } %>
			<% if (request.getAttribute("errorNombrePubli") != null) { %>
			    <div class="alert alert-danger">
			        <div class="text-center"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></div>
			        <hr>
			        <%= request.getAttribute("errorNombrePubli") %>
			        <br>
			        <a href="/TrabajoUY/AltaDeOfertaLaboralGeneral" class="text-dark">Reintentar</a>
			    </div>
			<% } %>
		</div>			  	
	</div>	
	
	
	
<% if (request.getAttribute("errorTipoPubli") == null && request.getAttribute("errorNombrePubli") == null) { %>
    <div class="container mt-5"> 
        <div class="card">
            <div class="card-header">
                <ul class="nav nav-tabs card-header-tabs justify-content-center">
                    <li class="nav-item">
                        <a
                            class="nav-link active text-muted fs-3"
                            id="pagoGen-tab"
                            data-toggle="tab"
                            href="#pagoGeneral"
                            >Pago General</a
                        >
                    </li>
                </ul>
            </div>
  
<% } %>
   
            <div class="cartas">

				<%
			    
				ArrayList<DataTipoPublicacion> conjuntoDePaquetes = (ArrayList<DataTipoPublicacion>) request.getAttribute("coleccionDataPaquetesCompleta");
				ArrayList<DataKeyWord> keys = (ArrayList<DataKeyWord>) request.getAttribute("keys");
				
				
			    if(conjuntoDePaquetes != null && !conjuntoDePaquetes.isEmpty()){
			    
			        String nombrePaquete;
			        String descripcion;
			        int exp;
			        int duracion;
			        float costo;
			        String fecha;
			
			        for (DataTipoPublicacion dataTP : conjuntoDePaquetes) {
			        	nombrePaquete = dataTP.getNombre();

			    %>
				
				
				
			    <div class="card" style="width: 20rem;">
			   		<div style="overflow: hidden; width: 100%; height: 5rem;"> <!-- Corta la imagen -->
           	 			<img class="card-img-top" src="media/img/imagenTP3.jpg" alt="Card image cap" style="object-fit: cover; width: 100%; height: 100%;">
        			</div>
        			
			        <div class="card-body">
    						<h5 class="card-title"><strong><%= nombrePaquete %></strong></h5>
    				 		<input type="radio" class="btn-check" name ="btnradio" id="<%= nombrePaquete %>" autocomplete="off">		
					</div>
		    	</div>
			    
			    <%
			        	}
			        
			        %>  
			    	
			    	</div>	    

		<div class="card-body">
		
		<h3 class="-titulo-">Ingrese los datos</h3>
			<div class="form-container justify-content-center">			
				<div class="contenedor">
					
					<div class="my-5"></div>
					</div>
				</div>
				
				<div class="my-5"></div>
				
				
	            <form id="alta-formGral" action = "/TrabajoUY/AltaDeOfertaLaboralGeneral" method = "POST" enctype="multipart/form-data">
				
				<input type="hidden" id="tipoPago" name="tipoPago" value="<%= request.getParameter("tipoPago") != null ? request.getParameter("tipoPago") : "pagoGeneral" %>" />
				
				 <div class="form-floating mb-3">
					<input type="text" class="form-control" id="tipoPubli" name="tipoPubli" placeholder="" value="<%= request.getParameter("tipoPubli") != null ? request.getParameter("tipoPubli") : "" %>">					
					<label for="floatingInput">Tipo de publicación de la Oferta</label>
					
				</div>
				
				<% if (request.getAttribute("errorPubli") != null) { %>
				    <div class="alert alert-danger">
				      <%= request.getAttribute("errorPubli") %>
				    </div>
				  <% } %>
				
	            <div class="form-floating mb-3">
					<input type="text" class="form-control" id="nombre" name="nombre" placeholder="" value="<%= request.getParameter("nombre") != null ? request.getParameter("nombre") : "" %>">					
					<label for="floatingInput">Nombre de la Oferta</label>
					
				</div>
					
					
					
					<div id="nombreHelp" class="form-text">El Nombre debe ser único en nuestra plataforma.</div>
					<div class="my-3"></div>
					
					<div class="form-floating mb-">
					<input type="text" class="form-control" id="descripcion" name="descripcion" placeholder="" value="<%= request.getParameter("descripcion") != null ? request.getParameter("descripcion") : "" %>">
					<label for="floatingTextarea">Descripcón</label>
				</div>
					
					<div class="form-floating mb-3">
					<input type="text" class="form-control" id="departamento" name ="departamento" placeholder="" value="<%= request.getParameter("departamento") != null ? request.getParameter("departamento") : "" %>">
					<label for="floatingInput">Departamento</label>
				</div>
					
					<div class="form-floating mb-3">
					<input type="text" class="form-control" id="ciudad" name="ciudad" placeholder="" value="<%= request.getParameter("ciudad") != null ? request.getParameter("ciudad") : "" %>">
					<label for="floatingInput">Ciudad</label>
				</div>
					
					<div class="form-floating mb-3">
					<input type="time" class="form-control" id="horaDeInicio" name="horaDeInicio" placeholder="" value="<%= request.getParameter("horaDeInicio") != null ? request.getParameter("horaDeInicio") : "" %>">
						<label for="floatingInput">Hora de Inicio</label>
				</div>
					
					<div class="form-floating mb-3">
					<input type="time" class="form-control" id="horaDeFin" name ="horaDeFin"placeholder="" value="<%= request.getParameter("horaDeFin") != null ? request.getParameter("horaDeFin") : "" %>">
						<label for="floatingInput">Hora de Fin</label>
				</div>
				
				
				<div class="form-floating mb-3">
	    			<input type="number" class="form-control" id="remuneracion" name="remuneracion" placeholder=""
		           		value="<%= request.getParameter("remuneracion") != null ? request.getParameter("remuneracion") : "" %>"
		          		 min="0">
	    			<label for="floatingInput">Remuneración (En pesos uruguayos)</label>
				</div>


				<div class = "my-3"></div>
					
					<div class="form-floating mb-3"> 
					    <input name="profile-pic" type="file" class="form-control mx-0 px-0" id="floatingInput" accept="image/*">
					</div>
					
				<div class = "my-4"></div>
               
				<div id="nombreHelp" class="form-text">Si lo desea puede seleccionar una imagen.</div>

				<div class="my-5"></div>
				
				<div class="contenedor">
				<h4 class="-titulo-">Seleccione las keywords que desee asociar a la oferta</h4>
				<div class="my-5"></div>
				</div>

				<select class="form-select" multiple aria-label="Multiple select example" name="keys">
				    <%
				    if (keys != null && !keys.isEmpty()) {
				        for (DataKeyWord key : keys) {
				    %>
				    <option value="<%= key.getPalabraClave() %>"><%= key.getPalabraClave() %></option>
				    <%
				        }
				    }
				    %>
				</select>
			
			<div class="w-100 d-flex justify-content-center mt-3">	 
				
				<button type="submit" class="btn btn-dark btn-lg" id="botonModal1">Dar de alta</button>
				
			</div>
			<% 
			    }else{ 	
			        	%>
						    <div class="contendor2">	 
						    <div class="carta" style="width: 62vw;">       
							            <div class="alert alert-danger" role="alert">
							            	<div class = "text-center"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></div>
							            	<hr>
							                Hasta el momento no hay tipos de publicación registrados en el sistema
							            </div>
							        </div>
						</div>
			       <% 
			        }
			    %>
				</form>	
        	</div>
       	</div>
	</div>

	</main>
	<jsp:include page="/WEB-INF/template/footer.jsp"></jsp:include>
</body>
</html>
