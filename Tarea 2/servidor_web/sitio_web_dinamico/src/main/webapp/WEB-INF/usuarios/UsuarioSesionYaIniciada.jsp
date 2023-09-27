<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang = "es">
<head>
<meta charset="UTF-8">
<title>TrabajoUY: Tu usuario ya está registrado</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
    /* Estilos personalizados para centrar el mensaje verticalmente */
    body {
        display: flex;
        align-items: center;
        justify-content: center;
        height: 100vh;
        margin: 0;
    }
</style>
</head>
<body>
    <jsp:include page="/WEB-INF/template/header.jsp"></jsp:include>
    <main>
        <!-- Mensaje de error de Bootstrap -->
        
        <% 
        
        HttpSession sessionIniciada = request.getSession(false);
        String nombreUsuario =  (String) sessionIniciada.getAttribute("nombreUser");
        
        	
        %>
        
        <div class="alert alert-danger text-center" role="alert">
            Ya estás registrado como: <strong><%= nombreUsuario %></strong>
            <div class="mt-3">
                <!-- Botones -->
                <a href="/TuAplicacion/home" class="btn btn-danger">Cancelar</a>
                <a href="/TuAplicacion/ServletCerrarSesion" class="btn btn-danger">Cerrar Sesión</a>

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
