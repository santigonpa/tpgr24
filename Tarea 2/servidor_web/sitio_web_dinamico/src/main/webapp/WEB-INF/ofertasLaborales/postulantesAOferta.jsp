<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@page import= "logica_entidades.Postulacion" %>
    <%@page import = "java.io.FileOutputStream" %>
    <%@page import  = "java.io.IOException" %>
    <%@page import ="java.util.Base64" %>
    <%@page import="java.util.Set" %>  
      
    <link rel="stylesheet" href="consultaPostulanteStyle.css" />
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

    <link
      rel="icon"
      href="./img/logoNuevo.png"
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
    <title>TrabajoUY</title>
</head>
<body>
		<jsp:include page="/WEB-INF/template/headerLogged.jsp"></jsp:include>
		
		<div class="contenedor">
	  		<h2 class="titulo">Información postulantes</h2>
		</div>
		
		<div class="cartas">
			    <%
			    
			    Set<Postulacion> conjuntoDePost = (Set<Postulacion>) request.getAttribute("postulantes");
			    
			    if(!conjuntoDePost.isEmpty()){
			    
			        String motivacion;
			        String nombreUser;
			        String apellidoUser;
			        String nombreOfer;
			        byte[] imagenBytes;
			
			        for (Postulacion post : conjuntoDePost) {
			            motivacion = post.getMotivacion();
			            nombreUser = post.getNombrePostulante();
			            apellidoUser = post.getPostulante().getApellido();
			            imagenBytes = post.getPostulante().getImagen();
						nombreOfer = post.getNombreOfer();
			            String base64Image = Base64.getEncoder().encodeToString(imagenBytes);
			            
			    %>
			
			    
			    <div class="card" style="width: 18rem;">
  					<img src="data:image/jpeg;base64, <%= base64Image %>" align = "absmiddle" class="img-thumbnail shadow" alt="...">
	  				 <div class="card-body">
	    				<h5 class="card-title"><%=nombreUser %> <%=apellidoUser %></h5>
	    				<p class="card-text"><%= motivacion %></p>
						<a href="ServletConsultaDePostulacionAOfertaLaboral?id=<%= nombreOfer %>&user=<%= post.getPostulante().getNickName() %>" class="btn btn-outline-dark">Informacion postulacion</a>
	  				 </div>
				</div>
				
			    <%
			        	}
			        
			        %>  
			    	
			    	</div>
			    
			    <% 
			    }else{
			        	
			        	%>
			           
			           
			             
						   <div class = "my-5"></div>
					  			<div class="container">
							    	<div class="row">
							        	<div class="col text-center">
							            	<div class="alert alert-danger" role="alert">
							                No hay nadie postulado aun.
							            	</div>
							        	</div>
							    	</div>
								</div>
			             
			       <% 
			        }
			    %>
			
			<jsp:include page="/WEB-INF/template/footer.jsp"></jsp:include>
		
</body>
</html>