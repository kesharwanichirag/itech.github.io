const follow_btn = document.querySelector("#follow_btn");
const unfollow_btn = document.querySelector("#unfollow_btn");

const oth_user_id = document.querySelector("#oth_user_id");

const user_name = document.querySelector("#user_name");

const notification_message = user_name.value+ " Started Following You";

const deleteFollowersNotification = async()=>{
	const url = "delete_followers_notification.do?";
	const param = `user_id=${oth_user_id.value}&send_user_id=${user_user_id.value}`;
	const response = await fetch(url+param);
	const data = await response.json();

	return data;
}


const followersNotification = async()=>{
	const url = "save_followers_notification.do?";
	const param = `user_id=${oth_user_id.value}&send_user_id=${user_user_id.value}&notification_message=${notification_message}`;
	const response = await fetch(url+param);
	const data = await response.json();

	return data;
}


const deleteFollowers = async()=>{
	const url = "delete_followers.do?";
	const param = `ses_user_id=${user_user_id.value}&user_id=${oth_user_id.value}`;
	const response = await fetch(url+param);
	const data = await response.json();

	return data;
}

//insert followers
const followers = async()=>{
	const url = "followers.do?";
	const param = `ses_user_id=${user_user_id.value}&user_id=${oth_user_id.value}`;
	const response = await fetch(url+param);
	const data = await response.json();

	return data;
}

// following
const followUser = async()=>{
	const url = "follow_user.do?";
	const param = `user_id=${user_user_id.value}&oth_user_id=${oth_user_id.value}`;
	const response = await fetch(url+param);
	const data = await response.json();

	return data;
};

//check already following
const checkFollowing = async()=>{
	const url = "check_user_following.do?";
	const param = `user_id=${user_user_id.value}&oth_user_id=${oth_user_id.value}`;
	const response = await fetch(url+param);
	const data = await response.json();

	return data;
};

// unfollow
const unfollowUser = async()=>{
	const url = "unfollow_user.do?";
	const param = `user_id=${user_user_id.value}&oth_user_id=${oth_user_id.value}`;
	const response = await fetch(url+param);
	const data = await response.json();

	return data;
};

//click on follow btn
follow_btn.addEventListener("click",(e)=>{
	all_followers_box.innerHTML = "";
	followers_counts.innerHTML = "";
	checkFollowing()
	.then((dta)=>{
		if(dta==false){
			followUser()
			.then((data)=>{
				followers()
				.then((ddt)=>{
					followersNotification()
					.then((follow)=>{
						follow_btn.style.display = "none";
						unfollow_btn.style.display = "block";
						
						followersUsersList()
						.then((daataa)=>{
							followers_count.innerHTML = `${daataa.length}`;
							followers_counts.innerHTML += `${daataa.length}`;
							
							daataa.forEach((dta)=>{
								getUserNamebyId(dta.followerPersonId)
								.then((dt)=>{
									getProfilePicById(dta.followerPersonId)
									.then((dataa)=>{
																		
										if(session_user_id.value==dta.followerPersonId){
											all_followers_box.innerHTML += 
																	`
																	<div class="following_person">
																		<img src="show_sg_usr_pro_pic.do?user_pro_pic=${dataa}" class="following_person_img">
																		<h5 class="following_person_name d-inline-block">
																			${dt}
																		</h5>
																		<a href="user_profile.do" class="btn view_following_profile_btn float-right mr-3 ">
																			View Profile
																		</a>
																	</div>

																	`
										}else{
											all_followers_box.innerHTML += 
																	`
																	<div class="following_person">
																		<img src="show_sg_usr_pro_pic.do?user_pro_pic=${dataa}" class="following_person_img">
																		<h5 class="following_person_name d-inline-block">
																			${dt}
																		</h5>
																		<a href="sg_user_view.do?user_id=${dta.followerPersonId}" class="btn view_following_profile_btn float-right mr-3 ">
																			View Profile
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
						}).catch((errorr)=>{
							console.log(errorr);
						});
					}).catch((notfollow)=>{
						console.log(notfollow);
					});
						
					
				}).catch((eror)=>{
					console.log(eror);
				});	
				
			}).catch((error)=>{
				console.log(error);
			});
		}else{

		}
	}).catch((err)=>{
		console.log(err);
	});
});

//click on unfollow btn
unfollow_btn.addEventListener("click",(e)=>{
	all_followers_box.innerHTML = "";
	followers_counts.innerHTML = "";
	unfollowUser()
	.then((data)=>{
		deleteFollowers()
		.then((dta)=>{
			deleteFollowersNotification()
			.then((follower)=>{
				unfollow_btn.style.display = "none";
				follow_btn.style.display = "block";
				
				followersUsersList()
				.then((daataa)=>{
					followers_count.innerHTML = `${daataa.length}`;
					followers_counts.innerHTML += `${daataa.length}`;
					
					daataa.forEach((dta)=>{
						getUserNamebyId(dta.followerPersonId)
						.then((dt)=>{
							getProfilePicById(dta.followerPersonId)
							.then((dataa)=>{
								
								if(session_user_id.value==dta.followerPersonId){
									all_followers_box.innerHTML += 
															`
															<div class="following_person">
																<img src="show_sg_usr_pro_pic.do?user_pro_pic=${dataa}" class="following_person_img">
																<h5 class="following_person_name d-inline-block">
																	${dt}
																</h5>
																<a href="user_profile.do" class="btn view_following_profile_btn float-right mr-3 ">
																	View Profile
																</a>
															</div>

															`
								}else{
									all_followers_box.innerHTML += 
															`
															<div class="following_person">
																<img src="show_sg_usr_pro_pic.do?user_pro_pic=${dataa}" class="following_person_img">
																<h5 class="following_person_name d-inline-block">
																	${dt}
																</h5>
																<a href="sg_user_view.do?user_id=${dta.followerPersonId}" class="btn view_following_profile_btn float-right mr-3 ">
																	View Profile
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
				}).catch((errorr)=>{
					console.log(errorr);
				});
			}).catch((failed)=>{
				console.log(failed);
			});
			
		}).catch((eror)=>{
			console.log(eror);
		});
		
	}).catch((error)=>{
		console.log(error);
	});
});

//screen load
window.addEventListener('load',(e)=>{
	checkFollowing()
	.then((dta)=>{
		if(dta==true){
			unfollow_btn.style.display = "block";			
		}else{
			follow_btn.style.display = "block";
		}
	}).catch((err)=>{
		console.log(err);
	});
});