<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CandidateSuccessPage</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style>
.footer {
	position: absolute;
	left: 0;
	right: 0;
	bottom: 0;
	background-color: black;
	height: 70px;
}
</style>
</head>
<body style="background-color: orange">
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<h1 style="color: white; margin-left: 380%";>Welcome</h1>
		</div>
	</div>
	</nav>
	<h1 style="text-align: center">${cdto.name }successfully
		registered</h1>

	<div class="footer"></div>
</body>
</html>
