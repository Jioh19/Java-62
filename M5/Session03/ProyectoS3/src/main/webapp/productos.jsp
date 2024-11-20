<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, model.*" %>
<%
HttpSession sesion = request.getSession();
String username = (String) sesion.getAttribute("username");
List<Producto> productos = (List<Producto>) sesion.getAttribute("productos");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar navbar-expand-lg bg-body-primary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">Navbar</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="./logout">Logout</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Features</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<h1 class="mx-5">
		Bienvenido
		<%=username%></h1>
	<table>
		<tr>
			<th>id</th>
			<th>nombre</th>
			<th>precio</th>
			<th>stock</th>
			<th>agregar</th>
		</tr>
		<% for(Producto p: productos) { %>
			<tr>
				<td><%=p.getId()%></td>
				<td><%=p.getNombre() %></td>
				<td><%=p.getPrecio() %></td>
				<td><%=p.getStock() %></td>
				<td><a href=<%="./carro/agregar?id=" + p.getId() %>>Agregar al Carro</a></td>
			</tr>
		<% } %>
	</table>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>