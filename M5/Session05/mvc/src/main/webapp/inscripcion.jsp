<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.edutecno.entities.*"%>
<% List<InscripcionDTO> inscripciones = (List<InscripcionDTO>)request.getAttribute("inscripciones"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% for(InscripcionDTO ins : inscripciones) { %>
		<p><%=ins %></p>
	<% } %>
</body>
</html>