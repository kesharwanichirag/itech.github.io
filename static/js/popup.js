const popup_close_button = document.getElementById("popup_close_button");
const popout_validation = document.getElementById("popout_validation");

popup_close_button.addEventListener('click',(e)=>{
	popout_validation.style.display = "none";
});