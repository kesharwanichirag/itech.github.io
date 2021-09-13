const search = document.querySelector("#search");
const srch_res = document.querySelector("#srch_res");

const spinner_loader = document.querySelector("#spinner_loader");

search.addEventListener('keyup',(e)=>{
	let skey = search.value.trim();
	spinner_loader.style.display = "block";
	setTimeout(()=>{
		if(skey.length>=1){
			setTimeout(()=>{ 
				searchUser('search_user.do?skey='+skey+'&user_id='+user_user_id.value)
				.then((data)=>{
					console.log(data);
					srch_res.innerHTML = '';
					spinner_loader.style.display = "none";				
					for(i=0;i<data.length;i++){
						srch_res.innerHTML += `
											<div class=" py-1 mb-2 px-2 searched_user">
												<a href="sg_user_view.do?user_id=${data[i].userId}" class="text-decoration-none">
													<div>
														<img src="show_sg_usr_pro_pic.do?user_pro_pic=${data[i].profilePic}" class="srch_user_img">
														<span class="srch_username">${data[i].userName}</span>													
													</div>
												</a>
											</div>
											`
					}
					srch_res.style.display = 'block';
				})
				.catch((err)=>{
					console.log(err);
				});
			}, 2000);	
		}else if(skey.length==0){
			srch_res.style.display = 'none';
			spinner_loader.style.display = "none";
		}
	},100);
});


const searchUser = async(url)=>{
	const response = await fetch(url);
	console
	const data = await response.json();

	return data;
};

//################ mic #################
function startDictation(){
	const search = document.getElementById('search');

    if(window.hasOwnProperty('webkitSpeechRecognition')){

      	var recognition = new webkitSpeechRecognition();

	    recognition.continuous = false;
	    recognition.interimResults = false;
	    recognition.lang = "en-US";
	    recognition.start();

	    recognition.onresult = function (e) {
	        search.value = e.results[0][0].transcript;
	        recognition.stop();
	    };
	     
	    recognition.onerror = function(e) {
	        recognition.stop();
	    }
    }
}
