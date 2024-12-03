<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crear nuevo usuario</title>
</head>
<body>
	<form method="POST" action="crearUsuario">
		<label for="nombre">Nombre</label>
		<input type="text" name="nombre"/>
		<label for="apellido">Apelldio</label>
		<input type="text" name="apellido"/>
		<label for="username">Username</label>
		<input type="text" name="username"/>
		<label for="password">Password</label>
		<input type="password" name="password"/>
		<button type="submit">Enviar</button>
	</form>
</body>
</html>