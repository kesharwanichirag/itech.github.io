const user_user_id = document.querySelector("#user_user_id");
const sg_users_box = document.querySelector("#sg_users_box");
const follow_btns = document.querySelectorAll(".follow_btn");
const follow_btn_arr = Array.from(follow_btns);

const getSuggestedUsers = async()=>{
	const url = "suggested_users.do?"
	const param = `user_id=${user_user_id.value}`;
	const resp = await fetch(url+param);

	const data = await resp.json();

	return data;
};


const showSuggestedUsers = (users)=>{
	sg_users_box.innerHTML = "";
	users.forEach((user)=>{
		sg_users_box.innerHTML += 
									`
									<div class="suggested_user mb-3">
										<a href="sg_user_view.do?user_id=${user.userId}" class="text-decoration-none">
											<img src="show_sg_usr_pro_pic.do?user_pro_pic=${user.profilePic}" class="user_imgs">
											<small class="user_nm d-inline-block">
												${user.userName}
											</small>
											
										</a>
									</div>
									`;
											
	});
};


window.addEventListener("load",(e)=>{
	pre_loader.style.display = "block";
	getSuggestedUsers().
	then((data)=>{
		pre_loader.style.display = "none";
		showSuggestedUsers(data);
	}).catch((error)=>{

	});
});
