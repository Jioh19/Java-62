<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.edutecno.model.*"%>
<%
List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Usuarios</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet" href="./css/styles.css">
</head>
<body>
	<h1>Lista de Usuarios</h1>

	<table class="table table-striped">
		<tr>
			<th>Id</th>
			<th>Nombre</th>
			<th>Apellido</th>
			<th>Username</th>
			<th>Password</th>
			<th>Email</th>
		</tr>
		<% for(Usuario u: usuarios) { %>
			<tr>
				<td><%=u.getId() %></td>
				<td><%=u.getNombre() %></td>
				<td><%=u.getApellido() %></td>
				<td><%=u.getUsername() %></td>
				<td><%=u.getPassword() %></td>
				<td><%=u.getEmail() %></td>
			</tr>
		<% } %>
	</table>
	
	<a href="index.jsp"><button class="btn btn-danger">Volver</button></a>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>