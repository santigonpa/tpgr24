<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TrabajoUY</title>
<!-- Estilos -->
    <link rel="stylesheet" href="media/css/altOfLabStyle.css" />
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
    
      <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>  
      
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
	
		<div class="contenedor3">
	            <div class="row mt-4">
	            <div class="contenedor">
            		<h4 class="-titulo-">Seleccione un tipo de publicacion de Oferta Laboral</h4>
     			</div>
	                <div class="col-md-3">
	                    <div class="card" style="width: auto;">
	                        <div style="overflow: hidden; width: 100%; height: 5rem;"> <!-- Corta la imagen -->
	                            <img class="card-img-top" src="media/img/imagenTP3.jpg" alt="Card image cap" style="object-fit: cover; width: 100%; height: 100%;">
	                        </div>
	                        <div class="card-body">
	                            <h5 class="card-title">Básica</h5>
	                            <input type="radio" class="btn-check" name="btnradio" id="btnradio1" autocomplete="off">
         					    <label class="btn btn-outline-dark" for="btnradio1">Seleccionar</label>
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
	                             <input type="radio" class="btn-check" name="btnradio" id="btnradio2" autocomplete="off">
					             <label class="btn btn-outline-dark" for="btnradio2">Seleccionar</label>
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
	                            <input type="radio" class="btn-check" name="btnradio" id="btnradio3" autocomplete="off">
					            <label class="btn btn-outline-dark" for="btnradio3">Seleccionar</label>
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
	                            <input type="radio" class="btn-check" name="btnradio" id="btnradio4" autocomplete="off">
					            <label class="btn btn-outline-dark" for="btnradio4">Seleccionar</label>
	                        </div>
	                    </div>
	                </div>
	            </div>
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
				
				<div class="my-5"></div>
				<div class="container text-center">
					<div class="row">
						<div class="col">
							<button type="submit" class="btn btn-dark" name ="accion" value ="paquetes">Deseo pagar con alguno de mis paquetes</button>
						</div>
						<div class="col">
							<button type="submit" class="btn btn-dark" name ="accion" value ="normal">Deseo pagar de forma normal (sin utilizar paquetes)</button>
						</div>
					</div>   	
				</div>
			</form>
		</div>
	</div>
</div>
			
	</main>
	
	<jsp:include page="/WEB-INF/template/footer.jsp"></jsp:include>
	
</body>
</html>