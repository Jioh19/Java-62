<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<% Map<String, String> errores = (Map<String, String>)request.getAttribute("errores");%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<link
			href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
			rel="stylesheet"
			integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
			crossorigin="anonymous" />
		<title>Insert title here</title>
	</head>
	<body>
		<nav class="navbar navbar-expand-lg bg-primary">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">Navbar</a>
				<button
					class="navbar-toggler"
					type="button"
					data-bs-toggle="collapse"
					data-bs-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent"
					aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item">
							<a class="nav-link active" aria-current="page" href="#">Home</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="#">Link</a>
						</li>
						<li class="nav-item dropdown">
							<a
								class="nav-link dropdown-toggle"
								href="#"
								role="button"
								data-bs-toggle="dropdown"
								aria-expanded="false">
								Dropdown
							</a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item" href="#">Action</a></li>
								<li><a class="dropdown-item" href="#">Another action</a></li>
								<li><hr class="dropdown-divider" /></li>
								<li><a class="dropdown-item" href="#">Something else here</a></li>
							</ul>
						</li>
						<li class="nav-item">
							<a class="nav-link disabled" aria-disabled="true">Disabled</a>
						</li>
					</ul>
					<form class="d-flex" role="search">
						<input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" />
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form>
				</div>
			</div>
		</nav>
		<h1>Login de Usuario</h1>

		<form class="px-5 mx-5 my-2" action="./Register" method="POST">
			<div class="mb-3">
				<label for="name" class="form-label">Name</label>
				<input type="name" class="form-control" aria-describedby="nameHelp" name="name"/>
				<% if(errores != null && errores.containsKey("name")) {
				 out.println("<div style='color: red;'>Error usuario: " + errores.get("name") + "</div>");
				 }%>
			</div>

			<div class="mb-3">
				<label for="lastName" class="form-label">LastName</label>
				<input type="lastName" class="form-control" aria-describedby="lastNameHelp" name="lastName"/>
				<% if(errores != null && errores.containsKey("lastName")) {
                				 out.println("<div style='color: red;'>Error usuario: " + errores.get("lastName") + "</div>");
                				 }%>
			</div>

			<div class="mb-3">
				<label for="rut" class="form-label">Rut</label>
				<input type="rut" class="form-control" aria-describedby="rutHelp" name="rut"/>
				<% if(errores != null && errores.containsKey("rut")) {
                				 out.println("<div style='color: red;'>Error usuario: " + errores.get("rut") + "</div>");
                				 }%>
			</div>
			<div class="mb-3">
				<label for="email" class="form-label">Email address</label>
				<input type="email" class="form-control" aria-describedby="emailHelp" name="email"/>
				<% if(errores != null && errores.containsKey("email")) {
                				 out.println("<div style='color: red;'>Error usuario: " + errores.get("email") + "</div>");
                				 }%>
			</div>
			<div class="mb-3">
				<label for="password" class="form-label">Password</label>
				<input type="password" class="form-control" name="password"/>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
		<script
			src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
			crossorigin="anonymous"></script>
	</body>
</html>