function validate() {

	var Name = document.forms["firstform"]["name"];

	if (Name.value == '') {
		alert("name cannot be empty");
		return false;
	}
	if (!isNaN(Name.value)) {
		alert("name cannot have number");
		return false;
	}
	reg1 = /([A-Za-z][0-9])+|([0-9][A-Za-z])+/;
	if (reg1.test(Name.value)) {
		alert("name should have only alphabets");
		return false;
	}

	Email = document.forms["firstform"]["email"];
	if (Email.value == '') {
		alert("email cannot be empty");
		return false;
	}
	reg2 = /^[A-Za-z0-9]*$/;
	if (reg2.test(Email.value)) {
		alert("email should have '@' character");
		return false;
	}
	reg3 = /^[A-Za-z0-9]+\@[A-Za-z0-9]?$/;
	if (reg3.test(Email.value)) {
		alert("email should have atleast 2 character after '@' ");
		return false;
	}
	reg4 = /^[A-Za-z0-9]+\@[A-Za-z0-9]{2,}$/;
	if (reg4.test(Email.value)) {
		alert("email should have '.' character");
		return false;
	}
	reg5 = /^[A-Za-z0-9]+\@[A-Za-z0-9]{2,}\.[A-Za-z0-9]?$/;
	if (reg5.test(Email.value)) {
		alert("email should have atleast 2 character after '.' ");
		return false;
	}

	phono = document.forms["firstform"]["mobileNumber"];
	reg11 = /^[0-9]+$/;
	if (phono.value == '') {
		alert("phone number cannot be empty");
		return false;
	}
	if (!(reg11.test(phono.value))) {
		alert("phone number should have only digits");
		return false;
	}
	if (phono.value.length < 10) {
		alert("phone number should have minimum of 10 digits");
		return false;
	}
	if (phono.value.length > 10) {
		alert("phone number cannot have morethan  10 digits");
		return false;
	}

}

