const save_btn = document.querySelector("#save_btn");
const unsave_btn = document.querySelector("#unsave_btn");
const uploaded_user_id = document.querySelector("#post_user_id");

const savePost = async()=>{
	const url = "save_post.do?";
	const param = `user_post_id=${post_id.value}&user_id=${user_id.value}&post_user_id=${uploaded_user_id.value}`;

	const full = await fetch(url+param);

	const data = await full.json();

	return data;
};


const checkSavedPost = async()=>{
	const url = "check_saved_post.do?";
	const param = `user_post_id=${post_id.value}&user_id=${user_id.value}`;

	const full = await fetch(url+param);

	const data = await full.json();

	return data;
};

const unSavePost = async()=>{
	const url = "unsave.do?";
	const param = `user_post_id=${post_id.value}&user_id=${user_id.value}`;

	const response = await fetch(url+param);

	const data = response.json();

	return data;

};

unsave_btn.addEventListener('click',(e)=>{
	unSavePost().
	then((data)=>{
		save_btn.style.display = "block";
		unsave_btn.style.display = "none";
	}).catch((error)=>{
		console.log(error);
	});
});

save_btn.addEventListener("click",(e)=>{
	savePost()
	.then((data)=>{
		if(data.resp==1){
			window.location = "user_login.do";
		}else{
			save_btn.style.display = "none";
			unsave_btn.style.display = "block";
		}
		
	}).catch((error)=>{
		console.log(error);
	});
});

window.addEventListener("load",(e)=>{
	checkSavedPost()
	.then((data)=>{
		if(data==true){
			unsave_btn.style.display = "block";									
		}else{
			save_btn.style.display = "block";
		}
	}).catch((error)=>{
		console.log(error);
	});
});