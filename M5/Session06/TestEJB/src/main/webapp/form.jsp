<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>

<title>Calculator</title>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js">
</script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
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
					<br /> <input type="text" placeholder="numero 1" name="num1"
						size="25" class="form-control" /> <br /> <input type="text"
						placeholder="numero 2" name="num2" size="25" class="form-control" /><br />
					<div align="center">
						<p>
							<b>Select your choice:</b><br> <input type="radio"
								name="group1" value="add">Addition<br> <input
								type="radio" name="group1" value="sub">Subtraction<br>
							<input type="radio" name="group1" value="multi">Multiplication<br>
							<input type="radio" name="group1" value="div">Division<br>
						</p>
					</div>
					<input class="btn btn-lg btn-primary btn-block" value="Submit"
						type="submit"> <input
						class="btn btn-lg btn-primary btn-block" value="Reset"
						type="reset">
				</form>
			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>
</body>
</html>