const like_buttons = document.querySelectorAll(".like_buttons");
const like_btns = Array.from(like_buttons);

const dislike_buttons = document.querySelectorAll(".dislike_buttons");
const dislike_btns = Array.from(dislike_buttons);

//delete like notification
const deleteLikeNotificationAjax = async(user_id,session_user_id,user_post_id)=>{
	const url = "delete_like_notification.do?";
	const param = `user_id=${user_id.value}&send_user_id=${session_user_id.value}&user_post_id=${user_post_id}`;

	const response = await fetch(url+param);

	const data = await response.json();

	return data;

};


//insert like notification
const insertLikeNotificationAjax = async(user_id,session_user_id,user_post_id,notification_message)=>{
	const url = "save_like_notification.do?";
	const param = `user_id=${user_id.value}&send_user_id=${session_user_id.value}&user_post_id=${user_post_id}&notification_message=${notification_message}`;

	const response = await fetch(url+param);

	const data = await response.json();

	return data;

};


//delete like or remove like
const deletePostLikeAjax = async(user_post_id,user_id)=>{
	const url = "delete_post_like.do?";
	const param = `user_post_id=${user_post_id}&user_id=${user_id.value}`;

	const response = await fetch(url+param);

	const data = response.json();

	return data;

};

let c = 0;

dislike_btns.forEach((dl_btn)=>{
	dl_btn.btns = like_btns[c++];
	dl_btn.addEventListener('click',(e)=>{
		let dl_btn_ids = e.target.getAttribute("data-delete-post");
		const user_id = document.querySelector("#user_id");

		const cur_user_id = document.querySelector("#cur_user_id");

		deletePostLikeAjax(dl_btn_ids,user_id).
		then((data)=>{
			deleteLikeNotificationAjax(cur_user_id,user_id,dl_btn_ids)
			.then((dyta)=>{
				checkLikeCountAjax(dl_btn_ids).
				then((dta)=>{	
					dl_btn.style.display = "none";
					dl_btn.btns.style.display = "block";
					dl_btn.btns.innerHTML = `<small class="like_count">${dta}</small>`;								
				}).catch((err)=>{	
					console.log(err);
				});
			}).catch((eror)=>{
				console.log(eror);
			});
				
		}).catch((error)=>{
			console.log(error);
		});
	});
});

//like count
const countdata = document.querySelectorAll(".like_count"); 

const checkLikeCountAjax = async(user_post_id)=>{
	const url = "check_like_count.do?";

	const param = `user_post_id=${user_post_id}`;

	const resp = await fetch(url+param);

	const data = await resp.json();

	return data;
};
//check likes
const checkLikes = async(user_post_id,user_id)=>{
	const url = "check_like.do?";

	const param = `user_post_id=${user_post_id}&user_id=${user_id.value}`;

	const resp = await fetch(url+param);

	const data = await resp.json();
	return data;
};

//############# insert like #####################
let dls = 0;
const likeAjax = async(user_post_id,user_id)=>{
	const url = "like_post.do?";
	const param = `user_post_id=${user_post_id}&user_id=${user_id.value}`;

	const full = await fetch(url+param);

	const data = await full.json();

	return data;
};

like_btns.forEach((like_btn)=>{
	like_btn.dislikes = dislike_btns[dls++];
	like_btn.addEventListener("click",(e)=>{

		let user_post_id = e.target.getAttribute("data-post");
		const session_user_id = document.querySelector("#user_id");

		const user_id = document.querySelector("#cur_user_id");

		checkLikes(user_post_id,session_user_id).
		then((data)=>{
			if(data==false){
				likeAjax(user_post_id,session_user_id).		
				then((data)=>{
					const user_name = document.querySelector("#user_name");
					var notification_message = user_name.value+ " likes your photo";
					
					insertLikeNotificationAjax(user_id,session_user_id,user_post_id,notification_message)
					.then((ddd)=>{
						checkLikeCountAjax(user_post_id).
						then((dta)=>{	
							like_btn.style.display = "none";
							like_btn.dislikes.style.display = "block";
							e.target.dislikes.innerHTML = `<small class="like_count">${dta}</small>`;								
						}).catch((err)=>{	
							console.log(err);		
						});
					}).catch((eee)=>{
						console.log(eee);
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
});

const user_post_ids = document.querySelectorAll(".user_post_ids");
const user_post_id_arr = Array.from(user_post_ids);

let j = 0;
let m = 0;

//on load view
window.addEventListener("load",(e)=>{
	like_btns.forEach((btn)=>{
		btn.dislikes = dislike_btns[m++];
		btn.post_id = user_post_id_arr[j++];
		
		const user_id = document.querySelector("#user_id");

		let user_post_id = btn.post_id.value; 

		checkLikeCountAjax(user_post_id).
		then((data)=>{
			checkLikes(user_post_id,user_id).
			then((dta)=>{
				if(dta==true){
					btn.dislikes.style.display = "block";
					btn.dislikes.innerHTML = `<small class="like_count">${data}</small>`;
				}else{
					btn.style.display = "block";
					btn.innerHTML = `<small class="like_count">${data}</small>`;
				}
			}).catch((err)=>{
				console.log(err);
			});
			
		}).catch((eror)=>{
			console.log(eror);
		});
	});	
});
//-----------------------------------------------------------------------------