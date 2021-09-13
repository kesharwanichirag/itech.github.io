
const likeNotificationCounts = async(user_id)=>{
	const url = "new_like_notification_count.do?";
	const param = `user_id=${user_id.value}`;

	const response = await fetch(url+param);

	const data = await response.json();

	return data;
};

const commentsNotificationCounts = async(user_id)=>{
	const url = "new_comments_notification_count.do?";
	const param = `user_id=${user_id.value}`;

	const response = await fetch(url+param);

	const data = await response.json();

	return data;
};

const followersNotificationCounts = async(user_id)=>{
	const url = "new_followers_notification_count.do?";
	const param = `user_id=${user_id.value}`;

	const response = await fetch(url+param);

	const data = await response.json();

	return data;
};


window.addEventListener("load",(e)=>{
	const user_id = document.querySelector("#user_user_id");	
	const all_count_notify = document.querySelector("#all_count_notify");
	pre_loader.style.display = "block";

	likeNotificationCounts(user_id)
	.then((data)=>{
		commentsNotificationCounts(user_id)
		.then((dta)=>{
			followersNotificationCounts(user_id)
			.then((dataa)=>{
				pre_loader.style.display = "none";
				if(data+dta+dataa==0){
					all_count_notify.style.display = "none";
				}else{
					all_count_notify.style.display = "block";
					all_count_notify.innerHTML = data+dta+dataa;	
				}
			}).catch((errror)=>{	
				console.log(errror);
			});			
		}).catch((eror)=>{	
			console.log(eror);
		});

	}).catch((error)=>{	
		console.log(error);
	});
});
