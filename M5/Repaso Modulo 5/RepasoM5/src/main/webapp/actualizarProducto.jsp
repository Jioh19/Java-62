<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.edutecno.model.*"%>
<%
HttpSession miSesion = request.getSession(false);
List<Categoria> categorias = (List<Categoria>) miSesion.getAttribute("categorias");
List<Producto> productos = (List<Producto>) miSesion.getAttribute("productos");
Producto producto = (Producto) miSesion.getAttribute("producto");
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
		<h1>Crear Producto</h1>

		<h3><%=producto.getIdProducto() %></h3>
		<h4><%=producto.getNombre() %></h4>
		<h4><%=producto.getCategoria().getNombre() %></h4>
		<form method="POST" action="actualizarProducto">
			<input type="hidden" name="id" value="<%=producto.getIdProducto()%>">
			<label for="nombre" placeholder="<%=producto.getNombre() %>">Nombre producto</label>
			<input type="text" name="nombre"/>
			<label for="categoria">Categoria</label>
			<select name="categoria">
				<% for(Categoria categoria: categorias) { %>
					<option value="<%=categoria.getNombre() %>"><%=categoria.getNombre() %></option>
				<% } %>
			</select>
			<button type="submit" class="btn btn-success">Crear</button>
		</form>
		<a href="listarProductos"><button class="btn btn-danger">Volver</button></a>
	</main>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>