<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import= "logica_DataTypes.DataTipoPublicacion" %>
    <%@page import="java.util.Set" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TrabajoUY</title>
<!-- Estilos -->
    <link rel="stylesheet" href="media/css/altOfLabStyle.css" />
    <link rel="stylesheet" href="media/css/normalize.css" />
    <link rel="stylesheet" href="media/css/consultaUsuarioStyle.css" />
    <%@page import= "logica_DataTypes.DataOferta" %>
    

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
      
      <script>
	    $(document).ready(function () {
	        // Abrir Modal 1 al hacer clic en el botón "Abrir Modal 1"
	        $("#botonModal1").click(function () {
	            $("#modal1").modal("show");
	        });
	
	        // Abrir Modal 2 al hacer clic en el botón "Abrir Modal 2"
	        $("#botonModal2").click(function () {
	            $("#modal2").modal("show");
	        });
	    });
	</script>
      
      <script>
		function validarFormulario() {
		    var nombre = document.getElementById("nombre").value;
		    var descripcion = document.getElementById("descripcion").value;
		    var departamento = document.getElementById("departamento").value;
		    var ciudad = document.getElementById("ciudad").value;
		    var horaDeInicio = document.getElementById("horaDeInicio").value;
		    var horaDeFin = document.getElementById("horaDeFin").value;
		    var remuneracion = document.getElementById("remuneracion").value;
			
		    
		
		    if (nombre == "" || descripcion == "" || departamento == "" || ciudad == "" || horaDeInicio == "" || horaDeFin == "" || remuneracion == "") {
		        alert("Todos los campos son obligatorios");
		        return false; // Evita que el formulario se envíe si hay campos vacíos
		    }
		
		    // Aquí puedes agregar más validaciones según tus requisitos
		
		return true; // Permite que el formulario se envíe si todas las validaciones pasan
		}
		
		// Agregar un evento de escucha al formulario para la validación
	    document.addEventListener("DOMContentLoaded", function () {
	        var form = document.getElementById("alta-form");
	        form.addEventListener("submit", function (event) {
	            if (!validarFormulario()) {
	                event.preventDefault();
	            }
	        });
	    });
	</script>
      
    <script>
    // Función para obtener el botón seleccionado
    document.getElementById("obtenerSeleccion").addEventListener("click", function() {
        var botonesRadio = document.getElementsByName("btnradio");
        var botonSeleccionado = null;

        for (var i = 0; i < botonesRadio.length; i++) {
            if (botonesRadio[i].checked) {
                botonSeleccionado = botonesRadio[i].id;
                break; // Sale del bucle si se encuentra un botón seleccionado
            }
        }

        if (botonSeleccionado !== null) {
            alert("Botón seleccionado: " + botonSeleccionado);
        } else {
            alert("Ningún botón seleccionado.");
        }
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
    	<hr>
		</div>
		</div>
	</div>	
	
	<div class="cartas">

				<%
			    
				Set<DataTipoPublicacion> conjuntoDePaquetes = (Set<DataTipoPublicacion>) request.getAttribute("coleccionDataPaquetes");
			    
			    if(conjuntoDePaquetes != null && !conjuntoDePaquetes.isEmpty()){
			    
			        String nombrePaquete;
			        String descripcion;
			        int exp;
			        int duracion;
			        float costo;
			        String fecha;
			
			        for (DataTipoPublicacion dataTP : conjuntoDePaquetes) {
			        	nombrePaquete = dataTP.getNombre();
			        	descripcion = dataTP.getDescripcion();
			        	exp = dataTP.getExposicion();
			        	duracion = dataTP.getDuracion();
			        	
			        	fecha = dataTP.getFechaString();
			    %>
				
			    <div class="card" style="width: 20rem;">
			   		<div style="overflow: hidden; width: 100%; height: 5rem;"> <!-- Corta la imagen -->
           	 			<img class="card-img-top" src="media/img/imagenTP3.jpg" alt="Card image cap" style="object-fit: cover; width: 100%; height: 100%;">
        			</div>
        			
			        <div class="card-body">
    						<h5 class="card-title"><strong><%= nombrePaquete %></strong></h5>
    						<p class="card-text"><%= descripcion %></p>
    				 		<input type="radio" class="btn-check" name ="btnradio" id="<%= nombrePaquete %>" autocomplete="off">
    				 		<label class="btn btn-outline-dark" for="<%= nombrePaquete %>">Seleccionar</label>			
					</div>
		    	</div>
			    
			    <%
			        	}
			        
			        %>  
			    	
			    	</div>

		<div class="row justify-content-center">
		<div class="col-md-6">
		<div align="center">
		<h3 class="-titulo-">Ingrese los datos</h3>
			<div class="form-container justify-content-center">			
				<div class="contenedor">
					
					<div class="my-5">
					</div>
				</div>
				
				<div class="my-5">
				</div>
				
	            <form id="alta-form" action = "/TrabajoUY/AltaDeOfertaLaboral" method = "POST" enctype="multipart/form-data">
				
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
					<input type="number" class="form-control" id="remuneracion" name="remuneracion" placeholder="" value="<%= request.getParameter("remuneracion") != null ? request.getParameter("remuneracion") : "" %>">
					<label for="floatingInput">Remuneración (En pesos uruguayos)</label>
				</div>
				
				
				<label>Seleccione una imágen para su oferta (Este campo es opcional)</label>
				<div class="form-floating mb-3">
					<!-- ESTO LE DEJA SOLO ELEGIR UNA FOTO PERO SI SACA EL FILTRO EN EL BUSCADOR DE ARCHIVOS PUEDE METER CUALQUIER COSA CUIDADO -->
					<input type="file" class="form-control" id="floatingInput" accept="image/*" >

				</div>
				
				<div class="my-5"></div>
				
     			
				
				<div class="contenedor">
				<h4 class="-titulo-">Ingrese las keywords que quiera asociar a la oferta</h4>
				<div class="my-5"></div>
				</div>
				
				<div class="my-5"></div>
				<div class = "text-center"><i class="fa-solid fa-search"></i></div>
				<div class="my-5"></div>
				
				
				
				<select class="form-select" multiple aria-label="Multiple select example" name ="keys">
				  
				  <option value="1">Tiempo Completo</option>
				  <option value="2">Medio Tiempo</option>
				  <option value="3">Remoto</option>
				  <option value="3">FreeLance</option>
				  <option value="3">Temporal</option>
				  <option value="3">Permanente</option>
				</select>
				
			 <%
			 	String costoConPaquete = request.getParameter("costoConPaquete");
			    String costoo = request.getParameter("costo");
				DataOferta dtOferta = (DataOferta) request.getAttribute("dtOfer");

			 %>
				
		<button type="button" class="btn btn-dark" id="botonModal1">Pagar de manera general</button>
			<button type="button" class="btn btn-dark" id="botonModal2">Pagar por medio de un paquete</button>
			
			<div class="modal fade" id="modal1" tabindex="-1" role="dialog" aria-labelledby="modal1Label" aria-hidden="true">
			    <div class="modal-dialog" role="document">
			        <div class="modal-content">
			            <div class="modal-header">
			                <h5 class="modal-title" id="modal1Label">Confirmacion de pago</h5>
			                    <span aria-hidden="true">&times;</span>
			                </button>
			            </div>
			            <div class="modal-body">
			                El monto a pagar es : 
			            </div>
			            <div class="modal-footer">
					            <label class="btn btn-dark" for="btnradio4">Cancelar</label>
					            <label href = "Home" class="btn btn-dark" for="btnradio4">Aceptar</label>
					            
			            </div>
			        </div>
			    </div>
			</div>
			
			<!-- Modal 2 -->
			<div class="modal fade" id="modal2" tabindex="-1" role="dialog" aria-labelledby="modal2Label" aria-hidden="true">
			    <div class="modal-dialog" role="document">
			        <div class="modal-content">
			            <div class="modal-header">
			                <h5 class="modal-title" id="modal2Label">Confirmacion de pago</h5>
			                    <span aria-hidden="true">&times;</span>
			                </button>
			            </div>
			            <div class="modal-body">
			                El monto a pagar es : <%= costoConPaquete %>
			            </div>
			            <div class="modal-footer">
					            <label class="btn btn-dark" for="btnradio4">Cancelar</label>
					            <label href = "Home" class="btn btn-dark" for="btnradio4">Aceptar</label>
					           
			            </div>
			        </div>
			    </div>
			</div>
			
			<% 
			    }else{ 	
			        	%>
						    <div class="contendor2">	 
						    <div class="carta" style="width: 98vw;">       
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
	
			
	</main>
	
	<jsp:include page="/WEB-INF/template/footer.jsp"></jsp:include>
	
</body>
</html>