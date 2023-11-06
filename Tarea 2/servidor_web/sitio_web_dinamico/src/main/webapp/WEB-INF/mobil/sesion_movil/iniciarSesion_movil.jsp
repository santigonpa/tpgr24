<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="media/css/indexStyle.css" />
    <link rel="stylesheet" href="media/css/normalize.css" />

    <!-- FONTS -->
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Fira+Sans+Condensed:wght@300;500;900&display=swap"
    />
    <link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css2?family=Roboto+Slab:wght@300;500;900&display=swap"
    />

    <!-- Icono de pag -->
    <link rel="icon" href="media/img/logoNuevo.png" type="image/x-icon" />

    <!-- BS -->
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
      crossorigin="anonymous"
    />

    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css"
    />

    <!-- ICONOS -->
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
      integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
    <!-- esto capaz hay que sacarlo despues porque es la importacion del script de bootstrap y es un js y para la parte 1 no va-->
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
      crossorigin="anonymous"
    ></script>
    <title>TrabajoUY</title>
  </head>
  <body>
     <jsp:include page="/WEB-INF/mobil/templates_movil/header_movil.jsp"></jsp:include>
    <main>
		<div class="container w-75 bg-white mt-5 mb-0 rounded shadow"  style="margin-bottom: 20px">
			<div class="row align-items-strech">
				<div class="col bg d-none d-lg-block col-md-5 col-lg-5 col-xl-6 rounded ">
					
				</div>
				<div class="col bg-white p-4 rounded-end">
					<div class="text-end">
						<img src="media/img/logoNuevo.png" width="48" alt="">
					</div>
					<h2 class="fw-bold text-center">Bienvenido</h2>
					<h5 class="fw-bold text-center">Inicio de sesión</h5>
					
					<!--Login-->
					<form action="iniciarSesion_movil" method="POST">
						<div>
							<label for="email" class="form-label" >Usuario o Correo electrónico</label>
							<input type="text" class="form-control" name="email" required="required">
						</div>
						<div>
							<label for="password" class="form-label">Contraseña</label>
							<input type="password" class="form-control" name="password" required="required">
						</div>
						<div class="d-grid">
							<button  href="" type="submit" class="btn btn-dark">Iniciar sesión</button>
						</div>
						<div class="my-3">
							<span>¿No tienes cuenta? <a href="AltaUsuario">Regístrate.</a></span> <br>
							<span><a href="#">Recuperar contraseña.</a></span>
						</div>
					</form>
					
					
				</div>
			</div>
		</div>
	</main>

    <jsp:include page="/WEB-INF/template/footer.jsp"></jsp:include>
  </body>
</html>
