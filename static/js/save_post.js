const saved = document.querySelectorAll(".saved_btns");
const savedPostsArr = Array.from(saved);

const unsave = document.querySelectorAll(".unsave");
const unsaveArr = Array.from(unsave);

const savePost = async(user_post_id,user_id,post_user_id)=>{
	const url = "save_post.do?";
	const param = `user_post_id=${user_post_id}&user_id=${user_id.value}&post_user_id=${post_user_id.value}`;

	const full = await fetch(url+param);

	const data = await full.json();

	return data;
};


const checkSavedPost = async(user_post_id,user_id)=>{
	const url = "check_saved_post.do?";
	const param = `user_post_id=${user_post_id}&user_id=${user_id.value}`;

	const full = await fetch(url+param);

	const data = await full.json();

	return data;
};

const unSavePost = async(user_post_id,user_id)=>{
	const url = "unsave.do?";
	const param = `user_post_id=${user_post_id}&user_id=${user_id.value}`;

	const response = await fetch(url+param);

	const data = response.json();

	return data;

};


let savedbtnsc = 0;
unsaveArr.forEach((unsavebtns)=>{
	
	unsavebtns.btns = savedPostsArr[savedbtnsc++];

	unsavebtns.addEventListener('click',(e)=>{
		let btn_ids = e.target.getAttribute("data-unsave-post");
		const user_id = document.querySelector("#user_id");
		
		unSavePost(btn_ids,user_id).
		then((data)=>{
			unsavebtns.style.display = "none";
			unsavebtns.btns.style.display = "block";
		}).catch((error)=>{
			console.log(error);
		});		
	});
});


let conters = 0;
let id = 0;

savedPostsArr.forEach((save_btn)=>{
	const user_post_ids = document.querySelectorAll(".user_post_ids");
	const user_post_ids_arr = Array.from(user_post_ids);
	
	save_btn.unsaved_btn = unsaveArr[conters++];
	save_btn.ids = user_post_ids_arr[id++];

	save_btn.addEventListener("click",(e)=>{
		let user_post_id = e.target.getAttribute("data-post-id");
		
		const user_id = document.querySelector("#user_id");

		const cur_user_id = document.querySelector("#cur_user_id");
		
		checkSavedPost(user_post_id,user_id)
		.then((dataa)=>{
			if(dataa==false){
				savePost(user_post_id,user_id,cur_user_id)
				.then((data)=>{
					save_btn.style.display = "none";
					save_btn.unsaved_btn.style.display = "block";
				}).catch((error)=>{
					console.log(error);
				});
			}else if(dataa==true){
				console.log("already saved");
			}
			
		}).catch((eror)=>{
			console.log(eror);
		});
			
	});
});

let save = 0;
let unsavec = 0;

window.addEventListener("load",(e)=>{
	savedPostsArr.forEach((save_btn)=>{
		const user_id = document.querySelector("#user_id");

		const user_post_ids = document.querySelectorAll(".user_post_ids");
		const user_post_ids_arr = Array.from(user_post_ids);
		
		save_btn.postId = user_post_ids_arr[save++];
		
		save_btn.unsaved_btn = unsaveArr[unsavec++];

		checkSavedPost(save_btn.postId.value,user_id)
		.then((data)=>{
			if(data==true){
				save_btn.unsaved_btn.style.display = "block";									
			}else{
				save_btn.style.display = "block";
			}
		}).catch((error)=>{
			console.log(error);
		});
		
	});
});