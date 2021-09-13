const cur_user_id = document.querySelector("#cur_user_id");

const following = document.querySelector("#following");
const all_following_box = document.querySelector("#all_following_box");
const following_counts = document.querySelector("#following_counts");

const followers_count = document.querySelector("#followers_count");
const all_followers_box = document.querySelector("#all_followers_box");
const followers_counts = document.querySelector("#followers_counts");

const session_user_id = document.querySelector("#session_user_id");

const followersUsersList = async()=>{
	const url = "get_followers_list.do?";
	const param = `user_id=${cur_user_id.value}`;
	const response = await fetch(url+param);
	const data = await response.json();

	return data;
};

const followingUsersList = async()=>{
	const url = "get_following_list.do?";
	const param = `user_id=${cur_user_id.value}`;
	const response = await fetch(url+param);
	const data = await response.json();

	return data;
};

const getUserNamebyId = async(usr_id)=>{
	const url = "get_username_by_id.do?"
	const param = `user_id=${usr_id}`;
	const resp = await fetch(url+param);

	const data = await resp.json();

	return data;
};

const getProfilePicById = async(usr_id)=>{
	const url = "get_propic_by_id.do?"
	const param = `user_id=${usr_id}`;
	const resp = await fetch(url+param);

	const data = await resp.json();

	return data;
};

window.addEventListener('load',(e)=>{
	//following 
	pre_loader.style.display = "block";

	all_following_box.innerHTML = "";
	following_counts.innerHTML = "";
	
	followingUsersList()
	.then((data)=>{
		pre_loader.style.display = "none";
		following.innerHTML = `${data.length}`;
		following_counts.innerHTML += `${data.length}`;
		data.forEach((dta)=>{
			getUserNamebyId(dta.userFollowingId)
			.then((dt)=>{
				getProfilePicById(dta.userFollowingId)
				.then((dataa)=>{
					if(session_user_id.value==dta.userFollowingId){
						all_following_box.innerHTML += 
												`
												<div class="following_person">
													<a href="user_profile.do" class="text-decoration-none">
														<img src="show_sg_usr_pro_pic.do?user_pro_pic=${dataa}" class="following_person_img">
														<h6 class="following_person_name d-inline-block">
															${dt}
														</h6>
													</a>					
												</div>

												`
					}else{
						all_following_box.innerHTML += 
												`
												<div class="following_person">
													<a href="sg_user_view.do?user_id=${dta.userFollowingId}" class="text-decoration-none">
														<img src="show_sg_usr_pro_pic.do?user_pro_pic=${dataa}" class="following_person_img">
														<h6 class="following_person_name d-inline-block">
															${dt}
														</h6>
													</a>
												</div>

												`
					}
				}).catch((eror)=>{
					console.log(eror);
				});
			}).catch((er)=>{
				console.log(er);
			});
		});
	}).catch((error)=>{
		console.log(error);
	});

	//followers
	pre_loader.style.display = "block";
	
	followers_counts.innerHTML = "";
	all_followers_box.innerHTML = "";
	followersUsersList()
	.then((data)=>{
		pre_loader.style.display = "none";

		followers_count.innerHTML = `${data.length}`;
		followers_counts.innerHTML += `${data.length}`;
		data.forEach((dta)=>{
			getUserNamebyId(dta.followerPersonId)
			.then((dt)=>{
				getProfilePicById(dta.followerPersonId)
				.then((dataa)=>{
					if(session_user_id.value==dta.followerPersonId){
						all_followers_box.innerHTML += 
												`
												<div class="following_person">
													<a href="user_profile.do" class="text-decoration-none">
														<img src="show_sg_usr_pro_pic.do?user_pro_pic=${dataa}" class="following_person_img">
														<h6 class="following_person_name d-inline-block">
															${dt}
														</h6>
													</a>
												</div>

												`
					}else{
						all_followers_box.innerHTML += 
												`
												<div class="following_person">
													<a href="sg_user_view.do?user_id=${dta.followerPersonId}" class="text-decoration-none">
														<img src="show_sg_usr_pro_pic.do?user_pro_pic=${dataa}" class="following_person_img">
														<h6 class="following_person_name d-inline-block">
															${dt}
														</h6>
													</a>
												</div>

												`
					}
				}).catch((eror)=>{
					console.log(eror);
				});
			}).catch((er)=>{
				console.log(er);
			});
		});
	}).catch((error)=>{
		console.log(error);
	});
});
