//###### pop over #######
const popout_validation = document.querySelector("#popout_validation");
const popup_close_button = document.querySelector("#popup_close_button");

popup_close_button.addEventListener("click",(e)=>{
	popout_validation.style.display = "none";
});

