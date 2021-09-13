
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


window.addEventListener("load",(e)=>{
	let i = 0;
	let k = 0;
	let m = 0;
	const post_owner_ids = document.querySelectorAll(".post_owner_ids");
	const post_owner_id_arr = Array.from(post_owner_ids);

	const user_post_ids = document.querySelectorAll(".user_post_ids");
	const user_post_id_arr = Array.from(user_post_ids);

	const post_unn = document.querySelectorAll(".post_unn");
	const post_unn_arr = Array.from(post_unn);

	const pro_pic_cont = document.querySelectorAll(".pro_pic_cont");
	const pro_pic_cont_arr = Array.from(pro_pic_cont);

	user_post_id_arr.forEach((id)=>{
		id.user_id = post_owner_id_arr[i++];
		id.unm = post_unn_arr[k++];
		id.conts = pro_pic_cont_arr[m++];
		getUserNamebyId(id.user_id.value)
		.then((data)=>{
			id.unm.innerHTML =`${data}`;			
		}).catch((error)=>{
			console.log(error);
		});

		getProfilePicById(id.user_id.value)
		.then((data)=>{
			id.conts.innerHTML = `<img src="show_sg_usr_pro_pic.do?user_pro_pic=${data}" class="post_uprofpc">`;
		}).catch((error)=>{
			console.log(error);
		});
	});
});