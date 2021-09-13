//comment box open close
/*const comments_btn = document.querySelectorAll(".comments_btn");
const comments_btn_arr = Array.from(comments_btn);

const comment_box = document.querySelectorAll(".comment_box");
const comment_box_arr = Array.from(comment_box);

const close_cmnt_box = document.querySelectorAll(".close_cmnt_box");
const close_cmnt_arr = Array.from(close_cmnt_box);


const all_comments_box = document.querySelectorAll(".all_comments_box");
const all_comments_box_arr = Array.from(all_comments_box);

let arr = 0;

comments_btn_arr.forEach((btn)=>{
	btn.cmnt_box = comment_box_arr[arr++];
	btn.addEventListener("click",(e)=>{
		let t = e.target;
		
		t.cmnt_box.style.display = "block";
		t.className = "fa fa-comment fa-2x posts_button d-block comments_btn comment_active";
	});
});

let arr2 = 0;
let arr3 = 0;

close_cmnt_arr.forEach((btn)=>{
	btn.cmnnt_box = comment_box_arr[arr2++];
	btn.cmnt_btn = comments_btn_arr[arr3++];
	btn.addEventListener("click",(e)=>{
		let t = e.target;
		
		t.cmnnt_box.style.display = "none";
		t.cmnt_btn.className = "fa fa-comment fa-2x posts_button d-block comments_btn";
	});
});
*/