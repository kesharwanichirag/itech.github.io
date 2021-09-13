const getProfilePicById = async(send_user_id)=>{
	const url = "get_propic_by_id.do?"
	const param = `user_id=${send_user_id}`;
	const resp = await fetch(url+param);

	const data = await resp.json();

	return data;
};

window.addEventListener('load',(e)=>{
	const send_user_ids = document.querySelectorAll(".send_user_ids");
	const send_user_id_arr = Array.from(send_user_ids);

	const send_user_pro_pic_cont = document.querySelectorAll(".send_user_pro_pic_cont");
	const send_user_pro_pic_cont_arr = Array.from(send_user_pro_pic_cont);

	let k = 0;

	send_user_id_arr.forEach((ids)=>{
		ids.conts = send_user_pro_pic_cont_arr[k++];
		getProfilePicById(ids.value)
		.then((data)=>{
			ids.conts.innerHTML = `<img src="show_sg_usr_pro_pic.do?user_pro_pic=${data}" class="notify_profs ml-2 float-top">`;
			
		}).catch((error)=>{
			console.log(error);
		});
	});
	
});