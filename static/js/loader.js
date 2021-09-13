const pre_loader = document.querySelector("#pre_loader");
const not_connected = document.querySelector("#not_connected");


window.addEventListener("load",(e)=>{
	pre_loader.style.display = "none";

	if(navigator.onLine){
		not_connected.style.display = "none";
	}else{
		not_connected.style.display = "block";
	}
});

window.addEventListener("offline",(event)=>{
	not_connected.style.display = "block";
});

window.addEventListener("online",(event)=>{
	not_connected.style.display = "none";
});