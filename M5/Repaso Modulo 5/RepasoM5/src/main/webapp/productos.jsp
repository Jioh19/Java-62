<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.edutecno.model.*"%>
<%
HttpSession miSesion = request.getSession(false);
List<Producto> productos = (List<Producto>) miSesion.getAttribute("productos");
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
	<main class="m-3">
		<h1>Lista productos</h1>

		<table class="table table-striped-columns">
			<tr>
				<th>Id</th>
				<th>Nombre</th>
				<th>Categoria</th>
				<th></th>
				<th></th>
			</tr>
			<% for(Producto producto: productos) { %>
			<tr>
				<th><%=producto.getIdProducto() %></th>
				<th><%=producto.getNombre() %></th>
				<th><%=producto.getCategoria().getNombre() %></th>
				<th><a href="eliminarProducto?id=<%=producto.getIdProducto() %>"><button class="btn btn-danger">Borrar</button></a></th>
				<th><a href="actualizarProducto?id=<%=producto.getIdProducto() %>"><button class="btn btn-warning">Actualizar</button></a></th>
			</tr>
			<% } %>
		</table>
		<a href="crearProducto.jsp"><button class="btn btn-success">Crear producto</button></a>
		
	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>