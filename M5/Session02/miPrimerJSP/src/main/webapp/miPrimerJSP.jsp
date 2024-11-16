<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% boolean errorNombre = false;
if(request.getAttribute("error") != null) {
	errorNombre = (boolean)request.getAttribute("error"); } %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mi primer JSP</title>
</head>
<body>
	<h1>Bienvenidos a mi primer JSP</h1>
	<%
	int edad = 15;
	if (edad >= 18) {
	%>
	<h4>Felicidades, eres mayor de edad!!!!</h4>
	<%
	} else {
	%>
	<h4 style="color: red;">Oh no!!, eres menor de edad!!!!</h4>
	<%
	}
	%>
	<h2>Enviando Saludo</h2>
	<form action="./GetServlet">
        <label for="saludo">saludo</label>
        <input type="text" name="saludo">
        <label for="nombre">Nombre</label>
        <input type="text" name="nombre">
        
        <button type="submit">Submit</button>
        <% if(errorNombre) {
        	out.println("<div style='color: red;'>Error en el nombre, debe ser de mas de 4 letras </div>");
        	}%>
	</form>
<!-- <a href="./GetServlet?nombre=Juan&saludo=HOLAA!!! "><button>Enviar</button></a> -->
</body>
</html>