<% String nombre = (String)request.getAttribute("NOMBRE");
	String saludo = request.getParameter("saludo");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Saludo</title>
</head>
<body>
	<h2><%out.println(saludo + " " + nombre); %></h2>
</body>
</html>