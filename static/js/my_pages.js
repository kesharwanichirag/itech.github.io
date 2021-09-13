const pages_container = document.querySelector("#pages_container");

const getMyPages = async()=>{
	const url = "get_my_pages.do?";
	const param = `user_id=${user_user_id.value}`;

	const response = await fetch(url+param);

	const data = await response.json();

	return data;

};

const showPages = (pages)=>{
	pages_container.innerHTML = "";
	pages.forEach((dta)=>{
		pages_container.innerHTML += `
								<div class="my_pages_list py-2 mb-1">
									<div class="d-inline-block">
										<div>
											<img src="static/images/maa3.jpg" class="pages_images">
											<div class=" d-inline-block my_pages_names">
												${dta.userPageName}
											</div>
										</div>
										<small class="fa fa-globe mt-2 ml-3 page_type">
											${dta.pageType}
										</small>
									</div>
								</div>
									`;
	});
	
};

window.addEventListener("load",(e)=>{
	getMyPages()
	.then((data)=>{
		showPages(data);
	})
	.catch((error)=>{
		console.log(error);
	});
});