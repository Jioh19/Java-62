<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.edutecno.entities.InscripcionDTO"%>
<%
int idInsc = (Integer) request.getAttribute("idInsc");
String nombre = (String) request.getParameter("nombre");
String telefono = (String) request.getParameter("telefono");
InscripcionDTO dto = (InscripcionDTO) request.getAttribute("dto");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Listado de inscripciones</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.c
ss">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js">
	</
script>
	<script
src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"
>
</script>
</head>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="preListarInscripciones">Mantenedor
					de Cursos</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="preListarInscripciones">Listar
						Inscripciones</a></li>
				<li><a href="preInscripcion">Inscribir Cursos</a></li>
			</ul>
		</div>
	</nav>
	<h1>Solicitud Generada Correctamente</h1>
	<div>Su nombre es:
	<%=nombre %> </div>
	<div>Su codigo de inscripción es:
	<%=idInsc%></div>
	<div>Su codigo de curso es:
	<%=dto.getIdCurso()%></div>
	<div>Su codigo de pago es:
	<%=dto.getIdFormaPago()%></div>
	
</body>
</html>