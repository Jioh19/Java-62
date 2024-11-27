<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.ejb.sessionbean.*"%><%@ page
	import="javax.naming.*"%>
<html>
<head>
<title>Calculator</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.mi
n.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.
js"></script>
</head>
<%
double result = (double) request.getAttribute("result");
%>
<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="form.jsp">Calculadora</a>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<form action="TestEJB" method="GET" class="form-signin">
					<h3 class="form-signin-heading">Basic Operations</h3>
					<br />
					<div align="center">
						<p>
							<b>The result is:</b>
							<%=result%>
						</p>
					</div>
				</form>
			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>
</body>
</html>