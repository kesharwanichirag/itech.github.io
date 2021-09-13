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