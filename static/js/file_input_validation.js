const ok_invalid = document.querySelector("#ok_invalid");

//upload pic validation
function postValidation(){
    var fileInput = document.querySelector("#select_post");
    const invalid_ext = document.querySelector("#invalid_ext");
    const filePath = fileInput.value;

    var allowedExtensions = /(\.jpg|\.jpeg|\.png|\.gif)$/i;
    if(!allowedExtensions.exec(filePath)){
        //alert('Please upload file having extensions .jpeg/.jpg/.png/.gif only.');
        invalid_ext.style.display = "block";
        fileInput.value = '';
        return false;
    }
}

//##################################

//profile pic validation
function profileValidation(){
    var profile_pic_edit = document.querySelector("#profile_pic_edit");
    const invalid_ext = document.querySelector("#invalid_ext");
    const filePath = profile_pic_edit.value;

    var allowedExtensions = /(\.jpg|\.jpeg|\.png|\.gif)$/i;
    if(!allowedExtensions.exec(filePath)){
        invalid_ext.style.display = "block";
        profile_pic_edit.value = '';
        return false;
    }
}

//profile pic validation
function coverValidation(){
    var cover_change_btn = document.querySelector("#cover_change_btn");
    const invalid_ext = document.querySelector("#invalid_ext");
    const filePath = cover_change_btn.value;

    var allowedExtensions = /(\.jpg|\.jpeg|\.png|\.gif)$/i;
    if(!allowedExtensions.exec(filePath)){
        invalid_ext.style.display = "block";
        cover_change_btn.value = '';
        return false;
    }
}


//##################################
ok_invalid.addEventListener("click",(e)=>{
    invalid_ext.style.display = "none";
});
