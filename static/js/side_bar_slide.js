//element selectors
const side_bar_btn = document.querySelector(".side_bar_btn");

const sidenv_data = document.querySelectorAll(".sidenv_data");
const sidenv_data_arr = Array.from(sidenv_data);

const side_nav_box = document.querySelector("#mySidenav");

let side_Bar_open = false;

//click on btns
side_bar_btn.addEventListener("click",(e)=>{
	if(!side_Bar_open){
		side_nav_box.style.display = "block";

		setTimeout(()=>{
			side_bar_btn.classList.add("open");

			side_nav_box.style.width = "300px"
			
			sidenv_data_arr.forEach((data)=>{

				setTimeout(()=>{
					data.style.display = "block";
				},500);
			});

		},100);
		
		side_Bar_open = true;
	
	}else{
		side_bar_btn.classList.remove("open");
		side_nav_box.style.width = "0";

		setTimeout(()=>{
			side_nav_box.style.display = "none";	
		},400);
			
		sidenv_data_arr.forEach((data)=>{
			data.style.display = "none";
		});

		side_Bar_open = false;
	}
});