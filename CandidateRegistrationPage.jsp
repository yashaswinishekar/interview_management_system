<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CandidateRegistrationPage</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="candidate.css">

<!-- <script>
$(function(){
	  $.ajax({
		url:"http://localhost:8080/interview_proj/location/getLocation.do",
		type:"GET",
		accept:"application/json",

		success:function(resultdata){
			console.log("hello");

			$.each(resultdata,function(key,value){
				var Name=value.name;
				$("#country").append("<option >"+Name+"</option>");
			});
		}  
}); 		  
});  
</script>   -->
</head>
<script src="candidate.js"></script>
<body style="background-color: orange">
	<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<h1 style="color: white; margin-left: 380%";>Welcome</h1>
		</div>
	</div>
	</nav>
	<h1 style="color: red; text-align: center">${failure }</h1>
	<div class="div" style="margin: 30px auto 30px auto">
		<h5>Fields mentioned with * are mandatory</h5>
		<form action="signUp.do" method="post" position="observed"
			name="firstform" novalidate onsubmit="return validate()">

			<div class="div1">
				Name<sup style="color: red">*</sup><input class="input" type="text"
					name="name" placeholder="Enter your name.Ex:Yashaswini" />
			</div>

			<div class="div1">
				Email<sup style="color: red">*</sup><input class="input"
					type="email" name="email"
					placeholder="Enter your email.Ex:Yash123@gmail.com" />
			</div>

			<div class="div1">
				MobileNumber<sup style="color: red">*</sup><input class="input"
					type="text" name="mobileNumber"
					placeholder="Enter your phone number.Ex:8765432976" />
			</div>
			<div class="div1">
				DOB<sup style="color: red">*</sup><input class="input" type="date"
					name="dob" />
			</div>


			<div class="div1">
				Location<sup style="color: red">*</sup><select class="select"
					name="location" id="country">
					<option>select</option>
					<option>india</option>
					<option>srilanka</option>
					<option>china</option>
				</select>
			</div>
			<div class="div1">
				Gender<sup style="color: red">*</sup><select class="select"
					name="gender">
					<option>select</option>
					<option value="F">Female</option>
					<option value="M">Male</option>
					<option value="NS">NotSpecified</option>
				</select>
			</div>
			<div class="div1">
				JobCode<sup style="color: red">*</sup><select class="select"
					name="jobCode">
					<option>select</option>
					<option value="se001">SE001</option>
					<option value="se002">SE002</option>
					<option value="se003">SE003</option>
					<option value="se004">SE004</option>
				</select>
			</div>

			<div class="div1">
				Experiance<sup style="color: red">*</sup><select class="select"
					name="experiance">
					<option>select</option>
					<option value="fresher">fresher</option>
					<option value="0">0</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
				</select>
			</div>
			<div class="div1">
				<input class="button" type="submit" value="Register" /> 
				<input class="button" type="reset" value="Clear" />
			</div>
		</form>
	</div>
	<div class="footer"></div>
</body>
</html>
