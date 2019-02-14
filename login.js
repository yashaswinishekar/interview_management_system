function loginValidate(){
	Password=document.forms["firstform"]["password"];
    if(Password.value == '')
	  {
		  alert("passwd cannot be empty");
		  return false;
	  }
	 
   
	  reg7=/[A-Za-z\!\@\#\$\%\^\&\*\{\}\[\]\(\)\_\-\.\:\~\?\,\']{8,}/;
	  if(reg7.test(Password.value))
	  {
		  alert("passwd should contain atleast 1 number");
		  return false;
	  }
	   reg8=/[A-Za-z0-9]{8,}/;
	  if(reg8.test(Password.value))
	  {
		  alert("passwd should contain atlest 1 special character");
		  return false;
	  }
	  reg9=/[a-z0-9\!\@\#\$\%\^\&\*\{\}\[\]\(\)\_\-\.\:\~\?\,\']{8,}/;
    if(reg9.test(Password.value))
	  {
		  alert("passwd should contain atlest 1 character in upper case");
		  return false;
	  }
	  regg=/[A-Za-z0-9]{1,7}/;
	  if(Password.value.length<8)
	  {
		  alert("passwd should contain atlest 8 character ");
		  return false;
	  }

	  ConfirmPassword = document.forms["firstform"]["confirmPassword"];
    
	  if(ConfirmPassword.value == '')
	  {
		  alert("confirm password cannot be empty");
		  return false;
	  }
    if(!(ConfirmPassword.value == Password.value))
	  {
		  alert("confirm password does not match with password");
      return false;
	  }
}