//comments 

const form = document.querySelector("#form");
const comment = form.comment;

const post_id = document.querySelector("#post_id");
const user_id = document.querySelector("#user_id");
const all_comment_box = document.querySelector("#all_comment_box");
const comment_field = document.querySelector("#comment_field");
const oth_users_id = document.querySelector("#oth_users_id");
const oth_users_name= document.querySelector("#oth_users_name");

var notification_message = oth_users_name.value+" commented on your photo";

//insert comment notification
const insertCommentNotificationAjax = async()=>{
	const url = "save_comment_notification.do?";
	const param = `user_id=${oth_users_id.value}&send_user_id=${user_id.value}&user_post_id=${post_id.value}&notification_message=${notification_message}`;

	const response = await fetch(url+param);

	const data = await response.json();

	return data;

};


//upload comment
const saveComments = async()=>{
	const url = "save_comments.do?"
	const param = `user_id=${user_id.value}&user_post_id=${post_id.value}&comment=${comment.value}`;
	const resp = await fetch(url+param);

	const data = await resp.json();

	return data;
};

const showComments = async()=>{
	const url = "show_comments.do?"
	const param = `user_post_id=${post_id.value}`;
	const resp = await fetch(url+param);

	const data = await resp.json();

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

form.addEventListener("submit",(e)=>{
	e.preventDefault();
	pre_loader.style.display = "block";
	saveComments()
	.then((data)=>{
		insertCommentNotificationAjax()
		.then((dyta)=>{
			console.log(dyta);
			pre_loader.style.display = "none";
			if(data.resp==1){
				window.location = "user_login.do";
			}else{
				all_comment_box.innerHTML = "";

				setTimeout((time)=>{
					comment_field.value = "";
				},'200');

				showComments()
				.then((dta)=>{
					dta.forEach((dt)=>{
						getUserNamebyId(dt.user.userId)
						.then((d)=>{
							getProfilePicById(dt.user.userId)
							.then((dtaa)=>{
								all_comment_box.innerHTML += 
										`
										<div class="my-2 all_comments_box">
											<div>
												<img src="show_sg_usr_pro_pic.do?user_pro_pic=${dtaa}" 
												class="all_comment_imgs">
												<span class=" d-inline-block ml-2 all_comment_nms">
													${d}	
												</span>
											</div>
											<div class="comment_texts mt-1">
												${dt.comment}
											</div>
											<div class="clearfix comment_time mt-1">
												<small class="float-right">	
													${dt.commentTime}
												</small>
											</div>
										</div>
										
										`
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
			}
		}).catch((eee)=>{
			console.log(eee);
		});
			
	}).catch((err)=>{
		console.log(err);
	});
});

window.addEventListener("load",(e)=>{
	all_comment_box.innerHTML = "";
	pre_loader.style.display = "block";
	showComments()
		.then((dta)=>{
			pre_loader.style.display = "none";
			dta.forEach((dt)=>{
				getUserNamebyId(dt.user.userId)
				.then((d)=>{
					getProfilePicById(dt.user.userId)
					.then((dtaa)=>{
						all_comment_box.innerHTML += 
								`
								<div class="my-2 all_comments_box">
									<div>
										<img src="show_sg_usr_pro_pic.do?user_pro_pic=${dtaa}" 
										class="all_comment_imgs">
										<span class=" d-inline-block ml-2 all_comment_nms">
											${d}	
										</span>
									</div>
									<div class="comment_texts mt-1">
										${dt.comment}
									</div>
									<div class="clearfix comment_time mt-1">
										<small class="float-right">	
											${dt.commentTime}
										</small>
									</div>
								</div>
								
								`
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