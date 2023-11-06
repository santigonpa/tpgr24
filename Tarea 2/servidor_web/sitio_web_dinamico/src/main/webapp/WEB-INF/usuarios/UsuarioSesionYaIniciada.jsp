<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import= "com.webservices.controladores.publicar.DataUsuario" %>
<!DOCTYPE html>
<html lang = "es">
<head>
	<meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="media/css/indexLoggedStyle.css" />
    <link rel="stylesheet" href="media/cssnormalize.css" />
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
	<style>
	    /* Estilos personalizados para centrar el mensaje verticalmente */
	    main {
	        display: flex;
	        align-items: center;
	        justify-content: center;
	        height: 100vh;
	        margin: 0;
	    }
	</style>
	<title>TrabajoUY: Tu usuario ya está registrado</title>
</head>
<body>
    <jsp:include page="/WEB-INF/template/headerLogged.jsp"></jsp:include>
    <main>
        <!-- Mensaje de error de Bootstrap -->
        
        <% 
        
        HttpSession sessionIniciada = request.getSession(false);
        DataUsuario usr =  (DataUsuario) sessionIniciada.getAttribute("usuario");
       	String nombre = usr.getNombre();
       	String apellido = usr.getApellido();
       	
        
        
        	
        %>
        
        <div class="alert alert-danger text-center" role="alert">
            Usted tiene una sesion iniciada como: <strong><%= nombre %></strong> <strong><%= apellido %></strong>
            <div class="mt-3">
                <!-- Botones -->
                <a href="/TrabajoUY/home" class="btn btn-danger">Cancelar</a>
                <a href="/TrabajoUY/ServletCerrarSesion" class="btn btn-danger">Cerrar Sesión</a>

            </div>
        </div>
    </main>
    <jsp:include page="/WEB-INF/template/footer.jsp"></jsp:include>
    <!-- Script de Bootstrap (debes incluir jQuery y Popper.js si no lo has hecho) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
