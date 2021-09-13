//side cont
const side_controller_post = document.querySelectorAll(".side_controller_post");
const side_controller_post_arr = Array.from(side_controller_post);

const uploaded_pic_side = document.querySelectorAll(".uploaded_pic_side");
const uploaded_pic_controller_arr  = Array.from(uploaded_pic_side);

const close_side_controller_post = document.querySelectorAll(".close_side_controller_post");
const close_side_controller_post_arr = Array.from(close_side_controller_post);

let checker = 0;
let checkercls = 0;

side_controller_post_arr.forEach((cont)=>{
	cont.box = uploaded_pic_controller_arr[checker++];
	cont.addEventListener("click",(e)=>{
		cont.box.style.display = "block";
	});
});

close_side_controller_post_arr.forEach((cont)=>{
	cont.box = uploaded_pic_controller_arr[checkercls++];
	cont.addEventListener("click",(e)=>{
		cont.box.style.display = "none";
	});
});

//cover pic
const cover_pic_btn = document.querySelector("#cover_pic_btn");
const cover_pic_box = document.querySelector("#cover_pic_box");

const close_cover_pic = document.querySelector("#close_cover_pic");

cover_pic_btn.addEventListener("click",(e)=>{
	cover_pic_box.style.display = "block";
});

close_cover_pic.addEventListener("click",(e)=>{
	cover_pic_box.style.display = "none";
});


//profile pic
const prof_pic_btn = document.querySelector("#prof_pic_btn");
const prof_pic_box = document.querySelector("#prof_pic_box");

const close_prof_btn = document.querySelector("#close_prof_btn");

prof_pic_btn.addEventListener("click",(e)=>{
	prof_pic_box.style.display = "block";
});

close_prof_btn.addEventListener("click",(e)=>{
	prof_pic_box.style.display = "none";
});


//edit profile
const edit_profile_btn = document.querySelector("#edit_profile_btn");
const edit_profile_box = document.querySelector("#edit_profile_box");

const close_edit_profile_btn = document.querySelector("#close_edit_profile_btn");

edit_profile_btn.addEventListener("click",(e)=>{
	edit_profile_box.style.display = "block";
});

close_edit_profile_btn.addEventListener("click",(e)=>{
	edit_profile_box.style.display = "none";
});

//upload pic
const upload_pic_btn = document.querySelector("#upload_pic_btn");
const upload_pic_box = document.querySelector("#upload_pic_box");

const close_upload_pic_btn = document.querySelector("#close_upload_pic_btn");

upload_pic_btn.addEventListener("click",(e)=>{
	upload_pic_box.style.display = "block";
});

close_upload_pic_btn.addEventListener("click",(e)=>{
	upload_pic_box.style.display = "none";
});


//show following
const following_box = document.querySelector("#following_box");
const following_btn = document.querySelector("#following_btn");

const close_following = document.querySelector("#close_following");

following_btn.addEventListener("click",(e)=>{
	following_box.style.display = "block";
});

close_following.addEventListener("click",(e)=>{
	following_box.style.display = "none";
});

//show followers

const followers_box = document.querySelector("#followers_box");
const followers_btn = document.querySelector("#followers_btn");

const close_followers = document.querySelector("#close_followers");


followers_btn.addEventListener("click",(e)=>{
	followers_box.style.display = "block";
});

close_followers.addEventListener("click",(e)=>{
	followers_box.style.display = "none";
});

//delete post from user_profile
const delete_pic_btn = document.querySelectorAll(".delete_pic_btn");
const delete_pic_btn_arr = Array.from(delete_pic_btn);

const deletePost = async(user_id,post_id)=>{
	const url = "delete_post_pic.do?"
	const param = `user_id=${user_id.value}&user_post_id=${post_id}`;
	const resp = await fetch(url+param);

	const data = await resp.json();

	return data;
};

let ids = 0;

delete_pic_btn_arr.forEach((delete_btn)=>{
	const user_id = document.querySelector("#user_id");
	const user_post_ids = document.querySelectorAll(".user_post_ids");
	const user_post_id_arr = Array.from(user_post_ids);

	delete_btn.postIds = user_post_id_arr[ids++];
	
	let postId = delete_btn.postIds.value;

	delete_btn.addEventListener("click",(e)=>{	
		deletePost(user_id,postId)
		.then((dta)=>{
			if(dta.resp==1){
				window.location = "user_login.do";
			}else{
				window.location = "user_profile.do";
			}
		}).catch((error)=>{
			console.log(error);
		})
	});
});

//pages open 
const create_page_btn = document.querySelector("#create_page_btn");
const create_pages_box = document.querySelector("#create_pages_box");
const close_pages_btn = document.querySelector("#close_pages_btn");

create_page_btn.addEventListener("click",(e)=>{
	create_pages_box.style.display = "block";
});

close_pages_btn.addEventListener('click',(e)=>{
	create_pages_box.style.display = "none";
});

//side nav
const profile_side_nav = document.querySelector("#profile_side_nav"); 
const list_nav = document.querySelector("#list_nav");

const profile_side_nav_close = document.querySelector("#profile_side_nav_close");

profile_side_nav.addEventListener("click",()=>{
	list_nav.style.display = "block";
	profile_side_nav.style.display = "none";
	profile_side_nav_close.style.display = "block";
});

profile_side_nav_close.addEventListener("click",()=>{
	list_nav.style.display = "none";
	profile_side_nav.style.display = "block";
	profile_side_nav_close.style.display = "none";
});
