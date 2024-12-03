<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
HttpSession usuario = request.getSession(false);
String username = (String) usuario.getAttribute("username");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		Bienvenido!
		<%=username%></h1>
	<li><a href="productos">mostrar productos html</a></li>
	<li><a href="login.jsp">login</a></li>
	<li><a href="logout">logout</a></li>
	<li><a href="agregar.jsp">Agregar Usuario</a></li>
</body>
</html>