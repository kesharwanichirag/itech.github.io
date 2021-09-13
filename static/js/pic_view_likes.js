const like_btn = document.querySelector("#like_btn");

const dislike_btn = document.querySelector("#dislike_btn");
const like_count  = document.querySelector("#like_count");

//delete like or remove like
const deletePostLikeAjax = async()=>{
	const url = "delete_post_like.do?";
	const param = `user_post_id=${post_id.value}&user_id=${user_id.value}`;

	const response = await fetch(url+param);
	const data = response.json();
	return data;

};

let c = 0;

dislike_btn.addEventListener('click',(e)=>{
	deletePostLikeAjax().
	then((data)=>{
		checkLikeCountAjax().
		then((dta)=>{	
			dislike_btn.style.display = "none";
			like_btn.style.display = "block";
			like_count.innerHTML = `<small class="like_count">${dta}</small>`;								
		}).catch((err)=>{	
		
		});
	}).catch((error)=>{

	});
});

//like count
const countdata = document.querySelectorAll(".like_count"); 

const checkLikeCountAjax = async()=>{
	const url = "check_like_count.do?";

	const param = `user_post_id=${post_id.value}`;

	const resp = await fetch(url+param);

	const data = await resp.json();

	return data;
};
//check likes
const checkLikes = async()=>{
	const url = "check_like.do?";

	const param = `user_post_id=${post_id.value}&user_id=${user_id.value}`;

	const resp = await fetch(url+param);

	const data = await resp.json();
	return data;
};

//############# insert like #####################
let dls = 0;
const likeAjax = async()=>{
	const url = "like_post.do?";
	const param = `user_post_id=${post_id.value}&user_id=${user_id.value}`;

	const full = await fetch(url+param);

	const data = await full.json();

	return data;
};

like_btn.addEventListener("click",(e)=>{
	checkLikes().
	then((data)=>{
		if(data==false){
			likeAjax().		
			then((data)=>{
				checkLikeCountAjax().
				then((dta)=>{	
					like_btn.style.display = "none";
					dislike_btn.style.display = "block";
					like_count.innerHTML = `<small class="like_count">${dta}</small>`;								
				}).catch((err)=>{	
				
				});
			}).catch((error)=>{
				console.log(error);
			});
		}else{
			
		}
	}).catch((eror)=>{
		console.log(eror);
	});
});

//on load view
window.addEventListener("load",(e)=>{
	checkLikeCountAjax().
	then((data)=>{
		checkLikes().
		then((dta)=>{
			if(dta==true){
				dislike_btn.style.display = "block";
				like_count.innerHTML = `<small class="like_count">${data}</small>`;
			}else{
				like_btn.style.display = "block";
				like_count.innerHTML = `<small class="like_count">${data}</small>`;
			}
		}).catch((err)=>{
			console.log(err);
		});
		
	}).catch((eror)=>{
		console.log(eror);
	});
});	
//-----------------------------------------------------------------------------