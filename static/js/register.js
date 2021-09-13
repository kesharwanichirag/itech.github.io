const form = document.querySelector("#register_form");

const username = form.username;
const email = form.email;
const mobile = form.mobile;
const password = form.password;
const rePassword = form.repassword;

const submitbutton = document.querySelector("#button");

const popout_validation = document.querySelector("#popout_validation");
const error_message = document.querySelector("#error_message");
const popup_close_button = document.querySelector("#popup_close_button");

//######### unique check ##########

username.onblur = uniqueCheck;
email.onblur = uniqueCheck;
mobile.onblur = uniqueCheck;

let curFld;
let request;

function uniqueCheck(){
	if(this.value.length!=0){
		curFld = this;
		request = new XMLHttpRequest();
		request.open("GET","uniquecheck.do?ukey="+this.value,true);
		request.onreadystatechange = uniqueResult;

		request.send();
	}
}

let flag1 = true,flag2 = true,flag3 = true;
function uniqueResult(){
	if(request.readyState==4&&request.status==200){
		const respData = request.responseText;
		let currentField;
		if(respData=="true"){
			popout_validation.style.display = "block";

			if(curFld.id=="username"){
				currentField = "username";
				flag1 = false;
			}else if(curFld.id=="email"){
				currentField = "email";
				flag2 = false;
			}else{
				currentField = "mobile";
				flag3 = false;
			}
			error_message.innerHTML =`Account With this ${currentField} already found..`;
		}else{
			if(curFld.id=="username"){
				flag1 = true;
			}else if(curFld.id=="email"){
				flag2 = true;
			}else{
				flag3 = true;
			}
		}
	}
}

//################ validation ############################
const check1 = document.querySelector("#check1");
const check2 = document.querySelector("#check2");
const check3 = document.querySelector("#check3");
const check4 = document.querySelector("#check4");
const check5 = document.querySelector("#check5");

const wrong1 = document.querySelector("#wrong1");
const wrong2 = document.querySelector("#wrong2");
const wrong3 = document.querySelector("#wrong3");
const wrong4 = document.querySelector("#wrong4");
const wrong5 = document.querySelector("#wrong5");

const tooltip1 = document.querySelector("#tooltip1");
const tooltip2 = document.querySelector("#tooltip2");
const tooltip3 = document.querySelector("#tooltip3");
const tooltip4 = document.querySelector("#tooltip4");
const tooltip5 = document.querySelector("#tooltip5");

//######## key up validations ############
username.addEventListener("focus",(e)=>{
	username.addEventListener("keyup",(e)=>{
		const userNamePattern = /^[a-zA-Z][a-zA-Z0-9]{5,19}$/;

		if(!userNamePattern.test(username.value)){
			
			username.className = "input error";
			check1.style.display = "none";
			wrong1.style.display = "block";
			tooltip1.style.visibility = "visible";
			tooltip1.style.opacity = "1";
			button.disabled = true;
		}else{
			tooltip1.style.visibility = "none";
			tooltip1.style.opacity = "0";
			wrong1.style.display = "none";
			check1.style.display = "block";
			button.removeAttribute("disabled");
		}
	});
});

email.addEventListener("focus",(e)=>{
	email.addEventListener("keyup",(e)=>{
		const emailPattern = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;

		if(!emailPattern.test(email.value)){
			tooltip2.style.visibility = "visible";
			tooltip2.style.opacity = "1";
			email.className = "input error";
			check2.style.display = "none";
			wrong2.style.display = "block";
			button.disabled = true;
		}else{
			tooltip2.style.visibility = "none";
			tooltip2.style.opacity = "0";
			wrong2.style.display = "none";
			check2.style.display = "block";
			button.removeAttribute("disabled");
		}
	});
});

mobile.addEventListener("focus",(e)=>{
	mobile.addEventListener("keyup",(e)=>{
		const mobilePattern = /^[0-9]{10,10}$/;

		if(!mobilePattern.test(mobile.value)){
			mobile.className = "input error";
			tooltip3.style.visibility = "visible";
			tooltip3.style.opacity = "1";
			check3.style.display = "none";
			wrong3.style.display = "block";
			button.disabled = true;
		}else{
			tooltip3.style.visibility = "none";
			tooltip3.style.opacity = "0";
			wrong3.style.display = "none";
			check3.style.display = "block";
			button.removeAttribute("disabled");
		}
	});
});

password.addEventListener("focus",(e)=>{
	password.addEventListener("keyup",(e)=>{
		const passwordPattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/;
		if(!passwordPattern.test(password.value)){
			password.className = "input error";
			tooltip4.style.visibility = "visible";
			tooltip4.style.opacity = "1";
			check4.style.display = "none";
			wrong4.style.display = "block";
			button.disabled = true;
		}else{
			tooltip4.style.visibility = "none";
			tooltip4.style.opacity = "0";
			wrong4.style.display = "none";
			check4.style.display = "block";
			button.removeAttribute("disabled");
		}
	});
});

rePassword.addEventListener("focus",(e)=>{
	rePassword.addEventListener("keyup",(e)=>{
		if(password.value!=rePassword.value){
			tooltip5.style.visibility = "visible";
			tooltip5.style.opacity = "1";
			rePassword.className = 'input error';
			check5.style.display = "none";
			wrong5.style.display = "block";
			button.disabled = true;
		}else{
			tooltip5.style.visibility = "none";
			tooltip5.style.opacity = "0";
			wrong5.style.display = "none";
			check5.style.display = "block";
			button.removeAttribute("disabled");
		}
	});
});

//validation through submit button

form.addEventListener("submit",(e)=>{
	e.preventDefault();
	let flag = true; 
	
	//username
	const userNamePattern = /^[a-zA-Z][a-zA-Z0-9]{5,19}$/;

	if(!userNamePattern.test(username.value)){
		flag = false;
		username.className = "input error";
	}
	//email
	const emailPattern = /^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/;

	if(!emailPattern.test(email.value)){
		flag = false;
		email.className = "input error";
	}
	//mobile
	const mobilePattern = /^[0-9]{10,10}$/;
	
	if(!mobilePattern.test(mobile.value)){
		flag = false;
		mobile.className = "input error";
	}
	//passwords
	const passwordPattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/;

	if(!passwordPattern.test(password.value)){
		password.className = "input error";
	}

	if(password.value!=rePassword.value){
		flag = false;
		rePassword.className = 'input error';
	}

	if(flag){
		form.submit();
	}
});

//###### pop down #######

popup_close_button.addEventListener("click",(e)=>{
	popout_validation.style.display = "none";
});

//#################### validation end #############################