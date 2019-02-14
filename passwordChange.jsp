<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>change password</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>


<link rel="stylesheet" href="candidate.css">
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
<script src=""></script>
<body style="background-color: orange">
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header"></div>
	</div>
	</nav>
</head>
<script src="login.js"></script>

<body>
<h1 style="color:red;text-align:center;">${failure}</h1>
	<div class="div" style="width: 20%; margin-top: 30px;">
		<form action="passwordChange.do" name="firstform" method="post" position="observed" novalidate onsubmit="return loginValidate()">
			<div class="div1">
				OldPassword<input class="input" type="text" name="oldPassword"
					style="width: 78%" />
			</div>
			<div class="div1">
				NewPassword<input class="input"  type="text" name="password"
					style="width: 78%" />
			</div>
			<div class="div1">
				ConfirmPassword<input class="input" type="text"
					name="confirmPassword" style="width: 78%" />
			</div>
			<div class="div1">
				<input class="button" type="submit" value="submit" /> <input
					class="button" type="reset" value="clear" />
			</div>
		</form>
	</div>
	<div class="footer"></div>
</body>
</html>