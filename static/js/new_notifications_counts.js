const user_id = document.querySelector("#user_id");
const likes_count= document.querySelector("#likes_count");
const followers_count = document.querySelector("#followers_count");
const comments_count = document.querySelector("#comments_count");

const likeNotificationCount = async()=>{
	const url = "new_like_notification_count.do?";
	const param = `user_id=${user_id.value}`;

	const response = await fetch(url+param);

	const data = await response.json();

	return data;
};

const commentsNotificationCount = async()=>{
	const url = "new_comments_notification_count.do?";
	const param = `user_id=${user_id.value}`;

	const response = await fetch(url+param);

	const data = await response.json();

	return data;
};

const followersNotificationCount = async()=>{
	const url = "new_followers_notification_count.do?";
	const param = `user_id=${user_id.value}`;

	const response = await fetch(url+param);

	const data = await response.json();

	return data;
};


window.addEventListener("load",(e)=>{
	likeNotificationCount()
	.then((data)=>{
		
		if(data==0){
			likes_count.style.display = "none";
		}else{
			likes_count.innerHTML = `${data}`;	
		}
	}).catch((error)=>{	
		console.log(error);
	});

	commentsNotificationCount()
	.then((data)=>{
		if(data==0){
			comments_count.style.display = "none";
		}else{
			comments_count.innerHTML = `${data}`;	
		}	
	}).catch((error)=>{	
		console.log(error);
	});

	followersNotificationCount()
	.then((data)=>{
		if(data==0){
			followers_count.style.display = "none";
		}else{
			followers_count.innerHTML = `${data}`;	
		}
		
	}).catch((error)=>{	
		console.log(error);
	});

});
