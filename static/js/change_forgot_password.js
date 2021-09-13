//######### validation ##########

const form = document.querySelector("#register_form");

const password = form.password;
const rePassword = form.repassword;

const check4 = document.querySelector("#check4");
const check5 = document.querySelector("#check5");

const wrong4 = document.querySelector("#wrong4");
const wrong5 = document.querySelector("#wrong5");

const tooltip1 = document.querySelector("#tooltip1");
const tooltip2 = document.querySelector("#tooltip2");

const submitbutton = document.querySelector("#button");


password.addEventListener("focus",(e)=>{
	password.addEventListener("keyup",(e)=>{
		const passwordPattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$/;
		if(!passwordPattern.test(password.value)){
			password.className = "input error";
			check4.style.display = "none";
			wrong4.style.display = "block";
			tooltip1.style.visibility = "visible";
			tooltip1.style.opacity = "1";
			submitbutton.disabled = true;
		}else{
			wrong4.style.display = "none";
			check4.style.display = "block";
			tooltip1.style.visibility = "none";
			tooltip1.style.opacity = "0";
			submitbutton.removeAttribute("disabled");
		}
	});
});

rePassword.addEventListener("focus",(e)=>{
	rePassword.addEventListener("keyup",(e)=>{
		if(password.value!=rePassword.value){
			rePassword.className = 'input error';
			check5.style.display = "none";
			wrong5.style.display = "block";
			tooltip2.style.visibility = "visible";
			tooltip2.style.opacity = "1";
			submitbutton.disabled = true;
		}else{
			wrong5.style.display = "none";
			check5.style.display = "block";
			tooltip2.style.visibility = "none";
			tooltip2.style.opacity = "0";
			submitbutton.removeAttribute("disabled");
		}
	});
});
