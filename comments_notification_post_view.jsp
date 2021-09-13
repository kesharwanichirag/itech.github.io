<!doctype html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Post</title>
		
		<!------------- CSS CDN bs-4.6 ---------------->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

		<!-- Favicons -->
		<link href="static/images/logo.png" rel="icon">

		<!------------- CSS CDN bs-5.0 beta ---------------->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

		<!----------- font awersome data --------------->
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

		<!-------------- CSS custom files  ------------------>

		<link rel="stylesheet" type="text/css" href="static/css/common.css">
		<link rel="stylesheet" type="text/css" href="static/css/loader.css">
		<link rel="stylesheet" type="text/css" href="static/css/show_other_pics.css">
		
	</head>
	<body>
		<!-----offline detector------->
		<div id="not_connected" class="bg-danger text-center">
			<i class="fa fa-globe" aria-hidden="true"></i>
			<span>
				You are not connected to Internet
			</span>
		</div>
		<!-----offline detector end------->

		<div id="container" class="m-lg-5 m-md-0 m-sm-0 m-0">
			<div id="contbox" class="justify-content-center px-2 container-lg">
				<div class="container-fluid ">
					<div class="row">
						<div class="col-xxl-9 col-xl-8 col-lg-8 col-md-7 pic_view">
							<div>
								<a href="comment_notification.do" class="fa fa-arrow-left back_btn mt-3 ml-2 py-1 px-2"></a>
								<div class="img_view">
									<img src="show_post_pics.do?user_id=${post_view.user.userId}&user_post_id=${post_view.userPostId}">
								</div>
							</div>
						</div>			
						<div class="col-xxl-3 col-xl-4 col-lg-4 col-md-5 comments_view">
							<div class="mt-2 clearfix pb-2" style="border-bottom: 1px solid #aaa;">
								<img src="show_sg_usr_pro_pic.do?user_pro_pic=${othusers.profilePic}" class="post_user_img">
								<h6 class="d-inline-block post_user_name">
									${othusers.userName}
								</h6>
								<input type="hidden" value="${othusers.userId}" id="oth_users_id">
								<input type="hidden" value="${user.userName}" id="oth_users_name">
								<br>
								<br>
								<!--<small class="post_dt float-right">
									2021-05-28 16:36:50
								</small>-->
							</div>
							<div style="border-bottom: 1px solid #aaa;">
								<div class="btn_holder d-inline-block">
									<small id="like_count" class="d-inline-block float-right float-top"></small>
									
									<i class="fa fa-heart btns like_btns" id="like_btn">

									</i>
									<i class="fa fa-heart btns like_btns" id="dislike_btn">

									</i>
								</div>
								<div class="btn_holder d-inline-block">
									<i class="fa fa-share btns">

									</i>
								</div>
								<!---save---->
								<div class="btn_holder d-inline-block">
									<input type="hidden" value="${post_view.user.userId}" id="post_user_id">
									<input type="hidden" value="${post_view.userPostId}" id="user_post_id">



									<i class="fa fa-bookmark-o btns" id="save_btn">

									</i>
									<i class="fa fa-bookmark btns" id="unsave_btn">

									</i>
								</div>
								<div class="btn_holder d-inline-block">
									<i class="fa fa-ellipsis-h btns">

									</i>
								</div>
							</div>
							<div class="comment_label mt-2 px-4 d-inline-block">
								Comments
							</div>
							<div class="all_comments_view_box" id="all_comment_box">
								
							</div>
							<div class="post_comment pt-2">
								<form id="form">
									<input type="hidden"
									 value="${post_view.userPostId}" name="post_id" id="post_id">
									 <input type="hidden"
									 value="${user.userId}" name="user_id" id="user_id">

									<img src="show_profile_pic.do" class="commentor_pic d-inline-block">

									<textarea class="d-inline-block mx-0" name="comment" id="comment_field">
									</textarea>
									
									<button type="submit" class="btn btn-primary float-right ml-0 post_btn">
										Post
									</button>
								</form>
							</div>	
						</div>
					</div>
				</div>
			</div>
		</div>
		<!------preloader------->
		<div id="pre_loader" class="text-center align-middle">
			<div class="spinner-border text-primary"
			role="status">
			  	<span class="visually-hidden">Loading...</span>
			</div>
		</div>
		
		<!---------------- JavaScript CDN 4.6 ----------------->
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
		
		<!--------------- Java Script CDN 5.0 beta------------->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
		
		<!-------------------------------------->
		<script src="static/js/pic_view_likes.js"></script>
		<script src="static/js/post_comment.js"></script>
		<script src="static/js/loader.js"></script>
		<script src="static/js/post_view_save_posts.js"></script>
		
	</body>
</html>