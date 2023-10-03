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
    
      <script>
      <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
      
      <script>
      // Obtén el elemento <select> por su id
      var selectElement = document.getElementById("opciones");

      // Agrega un evento para escuchar cambios en la selección
      selectElement.addEventListener("change", function () {
          // Obtiene las opciones seleccionadas
          var selectedOptions = [];
          var options = selectElement.options;

          for (var i = 0; i < options.length; i++) {
              if (options[i].selected) {
                  selectedOptions.push(options[i].text);
              }
          }

      });
  </script>
  
  <script>
    var tarjetaSeleccionada = null;

    function seleccionarTarjeta(indice) {
        tarjetaSeleccionada = indice;
        alert("Tarjeta " + indice + " seleccionada.");
        // Puedes realizar acciones adicionales aquí, como resaltar la tarjeta seleccionada visualmente.
    }

    function guardarSeleccion() {
        if (tarjetaSeleccionada !== null) {
            // Envía la información de la tarjeta seleccionada al servidor (por ejemplo, usando una solicitud AJAX)
            // Aquí puedes enviar tarjetaSeleccionada al servidor para su procesamiento o almacenamiento.
            // Puedes utilizar AJAX para enviar la información al servidor sin recargar la página.
        } else {
            alert("No se ha seleccionado ninguna tarjeta.");
        }
    }
	</script>
    
</head>
<body>
	<jsp:include page="/WEB-INF/template/header.jsp"></jsp:include>
	<main>
	<div class="my-5"></div>
    
	
	
	<div class="row justify-content-center">
		<div class="col-md-6">
			<div class="form-container justify-content-center">			
				<div class="contenedor">
					<h2 class="-titulo-"><strong>Ingrese Los Datos</strong></h2>
					<div class="my-5">
					</div>
				</div>
				<div class="my-5">
				</div>
				<div class = "text-center"><i class="fa-solid fa-circle-info"></i>
				</div>
				<div class="my-5">
				</div>
	            <form id="alta-form" action = "/TrabajoUY/AltaDeOfertaLaboral" method = "POST" enctype="multipart/form-data">
				
	            <div class="form-floating mb-3">
					<input type="text" class="form-control" id="nombre" placeholder=""  value="<%= request.getParameter("nombre") != null ? request.getParameter("nombre") : "" %>"
>
					<label for="floatingInput">Nombre de la Oferta</label>
					
				</div>
					
					<div id="nombreHelp" class="form-text">El Nombre debe ser único en nuestra plataforma.</div>
					<div class="my-3"></div>
					
					<div class="form-floating mb-">
					<input type="text" class="form-control" id="descripcion" placeholder=""  value="<%= request.getParameter("descripcion") != null ? request.getParameter("descripcion") : "" %>">
					<label for="floatingTextarea">Descripcón</label>
				</div>
					
					<div class="form-floating mb-3">
					<input type="text" class="form-control" id="departamento" placeholder="" value="<%= request.getParameter("departamento") != null ? request.getParameter("departamento") : "" %>">
					<label for="floatingInput">Departamento</label>
				</div>
					
					<div class="form-floating mb-3">
					<input type="text" class="form-control" id="ciudad" placeholder="" value="<%= request.getParameter("ciudad") != null ? request.getParameter("ciudad") : "" %>">
					<label for="floatingInput">Ciudad</label>
				</div>
					
					<div class="form-floating mb-3">
					<input type="time" class="form-control" id="horaDeInicio" placeholder="" value="<%= request.getParameter("horaDeInicio") != null ? request.getParameter("horaDeInicio") : "" %>">
						<label for="floatingInput">Hora de Inicio</label>
				</div>
					
					<div class="form-floating mb-3">
					<input type="time" class="form-control" id="horaDeFin" placeholder="" value="<%= request.getParameter("horaDeFin") != null ? request.getParameter("horaDeFin") : "" %>">
						<label for="floatingInput">Hora de Fin</label>
				</div>
				
				<div class="form-floating mb-3">
					<input type="number" class="form-control" id="remuneracion" placeholder="" value="<%= request.getParameter("remuneracion") != null ? request.getParameter("remuneracion") : "" %>">
					<label for="floatingInput">Remuneración (En pesos uruguayos)</label>
				</div>
				
				
				<label>Seleccione una imágen para su oferta (Este campo es opcional)</label>
				<div class="form-floating mb-3">
					<!-- ESTO LE DEJA SOLO ELEGIR UNA FOTO PERO SI SACA EL FILTRO EN EL BUSCADOR DE ARCHIVOS PUEDE METER CUALQUIER COSA CUIDADO -->
					<input type="file" class="form-control" id="floatingInput" accept="image/*" >

				</div>
				
				<div class="my-5"></div>
				
				<div class="contenedor">
				<h2 class="-titulo-"><strong>Ingrese las keywords que quiera asociar a la oferta</strong></h2>
				<div class="my-5"></div>
				</div>
				
				<div class="my-5"></div>
				<div class = "text-center"><i class="fa-solid fa-search"></i></div>
				<div class="my-5"></div>
				
				
				
				<select class="form-select" multiple aria-label="Multiple select example">
				  
				  <option value="1">Tiempo Completo</option>
				  <option value="2">Medio Tiempo</option>
				  <option value="3">Remoto</option>
				  <option value="3">FreeLance</option>
				  <option value="3">Temporal</option>
				  <option value="3">Permanente</option>
				</select>
	</main>
</body>
</html>