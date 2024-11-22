<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear Usuario</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<link rel="stylesheet" href="./css/styles.css">
</head>
<body>
	<h1>Ingrese los datos del nuevo usuario</h1>
	<form method="POST" action="UsuarioServlet">
		<div class="mb-3">
			<label for="nombre">Nombre</label>
			<input type="text" name="nombre" class="form-control" required>
		</div>
		<div class="mb-3">
			<label for="apellido">Apellido</label>
			<input type="text" name="apellido" class="form-control" required>
		</div>
		<div class="mb-3">
			<label for="username">Username</label>
			<input type="text" name="username" class="form-control" required>
		</div>
		<div class="mb-3">
			<label for="password">Password</label>
			<input type="password" name="password" class="form-control" required>
		</div>
		<div class="mb-3">
			<label for="email">email</label>
			<input type="email" name="email" class="form-control" required>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
	
	<a href="index.jsp"><button class="btn btn-danger my-2">Volver</button></a>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>