function validation(){
}
 validation.prototype.validatePassword=function (password) {
	var result=!(/[^A-Za-z0-9~_&*%@$]+/).test(password);
	passwdLen=password.length;
	if(passwdLen<6){
		result=false;
	}	
		
	if(result==false){
		
		return false;
	}
}

validation.prototype.validaterRePassword = function (password,rePassword) {
	if(password!=rePassword){
		return false;
	}
}
validation.prototype.validateEmail = function (Email){

    var email = document.getElementById('txtEmail');
    var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;

    if (!filter.test(email.value)) {
    alert('Please provide a valid email address');
    email.focus;
    return false;
			}
 }