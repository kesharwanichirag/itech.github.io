<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Welcome</title>
		
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
		<link rel="stylesheet" type="text/css" href="static/css/header_menu.css">
		<link rel="stylesheet" type="text/css" href="static/css/
		top_header.css">
		<link rel="stylesheet" type="text/css" href="static/css/index.css">
		<link rel="stylesheet" type="text/css" href="static/css/side_bar.css">
		<link rel="stylesheet" type="text/css" href="static/css/resp_header.css">
		<link rel="stylesheet" type="text/css" href="static/css/loader.css">
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
		<!---- header Directive---->
		<!------ header ------>
		<div class="m-lg-3 m-md-0 m-sm-0 m-0">
			<div id="contbox" class="justify-content-center px-2 container-lg">
				<div class="container-fluid">
					<div class="row">

						<!----### header Directive ###----->
						<%@ include file="responsive_header.jsp"%>

						<%@ include file="top_header.jsp"%>

						<!------- Side Header --------->
						<div class="col-2">
							<!--<div>
								<a href="index.do" class=" 
							 	mt-3 d-none d-lg-block" >
									<img src="static/images/logo.png" class="m-1 py-2 px-3" id="logo">
								</a>
							</div>-->
							<div class="menu_container mt-3">
								<div class="menu py-2 menu_selected">
									<a href="index.do"class="menu_links">
										<i class="fa fa-home menu_icons menu_selected_text"></i>
										<span class="d-none
										d-lg-inline-block menu_messages menu_selected_text">Home</span>
									</a>
								</div>
								<div class="menu py-2">
									<a href="inbox.do" class="menu_links">
										<i class="fa fa-commenting menu_icons"></i>
										<span class="d-none
										d-lg-inline-block menu_messages">Message</span>
									</a>
								</div>
								<div class="menu py-sm-2">
									<a href="all_notification.do" class="menu_links">
										<i class="fa fa-bell menu_icons">
											
										</i>
										<span id="notfication_text_seperate" class="menu_messages d-none
										d-lg-inline-block">Notifications</span>
										<span id="all_count_notify" class="float-right">
											
										</span>
									</a>
								</div>
								<div class="menu py-2">
									<a href="user_profile.do" class="menu_links">
										<i class="fa fa-user menu_icons"></i>
										<span class="d-none
										d-lg-inline-block menu_messages">Profile</span>
									</a>
								</div>
								<div class="menu py-2">
									<a href="" class="menu_links">
										<i class="fa fa-gear menu_icons"></i>
										<span class="menu_messages d-none
										d-lg-inline-block">Settings</span>
									</a>
								</div>
								<!--<div class="menu py-2 d-none d-lg-inline-block">
									<a href="logout_user.do" class="menu_links">
										<i class="fa fa-sign-out menu_icons"></i>
										<span class="menu_messages">Logout</span>
									</a>
								</div>-->
							</div>
							<hr>
							<div class="head_text_label d-none d-lg-inline-block px-3">
								<span>Account</span>
							</div>
							<div class="session_user d-none d-lg-inline-block mx-2 mt-3">
								<div class="mt-3">
									<img src="show_profile_pic.do" class="session_user_image"/>
									<span class="ml-0 session_user_nm">
										${user.userName}
									</span>
								</div>
							</div>
						</div>
						<!----### header Directive End ###----->
							
						<!--#### Main Body ####-->
						<div class="col-10 col-lg-7 main_body">
							<!--- Story ---->
							<div class="status_box mt-2">
								<div class="story">
									<img src="static/images/maa3.jpg" class="display_stories mystory actived_stories">
								</div>

								<div class="story">
									<img src="static/images/mail.jpg" class="display_stories watched">
								</div>
								<div class="story">
									<img src="static/images/maa2.jpg" class="display_stories watched">
								</div>
								<div class="story">
									<img src="static/images/nobi.png" class="display_stories actived_stories">
								</div>
								<div class="story">
									<img src="static/images/dora.jfif" class="display_stories actived_stories">
								</div>
								<div class="story">
									<img src="static/images/maa5.jpg" class="display_stories actived_stories">
								</div>
								<div class="story ">
									<img src="static/images/rg.jfif" class="display_stories actived_stories">
								</div>
								<div class="story">
									<img src="static/images/welcome.jpg" class="display_stories actived_stories">
								</div>
								<div class="story">
									<img src="static/images/maa1.jpg" class="display_stories actived_stories">
								</div>	
							</div>
							<!--- Story End ---->
							
							<!--- Feeds ---->
							<div>
								<div class="head_text_box mt-1 mb-0" >
									<div class="d-inline-block head_text_label px-3 p-2">
										Feeds
									</div>
									<!--<div class="d-inline-block feedlinks float-right">
										<a href="" class="d-inline-block feed_active">
											All
										</a>
										<a href="" class="d-inline-block feed_deactive">
											Following
										</a>
									</div>-->
								</div>
								<div class="text-center py-2 px-xxl-5 px-xl-4 px-lg-4 px-md-3 px-sm-2 px-2 feed_box">
									<c:forEach var="post"
									items="${posts_list}">
										<div class="post_container mt-3 mb-5 text-center">	
											<input type="hidden" value="${user.userId}" id="user_id">

											<input type="hidden" value="${post.userPostId}" id="user_post_id" class="user_post_ids">

											<input type="hidden" value="${user.userId}" id="cur_user_id">

											<input type="hidden" value="${user.userId}" id="user_id">

											<input type="hidden" value="${user.userName}"
											id="user_name">
											
											<input type="hidden" 
											value="${post.user.userId}" class="post_owner_ids">

											<div class="post_u_dt text-left">
												<a class="text-decoration-none" href="sg_user_view.do?user_id=${post.user.userId}" style="color:#000;">
													<span class="pro_pic_cont">
														
													</span>
													<span class="post_unn ml-1">
														
													</span>
												</a>

											</div>
											<div>
												<div class="posts_box">
													<img 
													src="oth_user_post.do?user_id=${post.user.userId}&user_post_id=${post.userPostId}" class="post_images">
												</div>

												<div class="button_holder">
													<!---Likes---->
													<div class="likes posts_button d-inline-block">			
														<small class="like_count"></small>
														<small class="fa fa-ellipsis-h like_view"></small>

														<i class="fa fa-heart-o fa-2x like_buttons" data-post="${post.userPostId}"></i>

														<i class="fa fa-heart fa-2x dislike_buttons" data-delete-post="${post.userPostId}"></i>
													</div>

													<!--Comments-->
													<div class="d-inline-block posts_button_from2">
														<a href="index_post_view.do?post_id=${post.userPostId}&user_id=${post.user.userId}" class="fa fa-comment fa-2x posts_button  d-inline-block comments_btn " style="text-decoration:none"></a>

													</div>

													<!----share---->
													<div class="fa fa-share fa-2x share posts_button  d-inline-block posts_button_from2"></div>

													<!----Save----->
													<div
													 class="posts_button  d-inline-block posts_button_from2
													">
														<i class="fa fa-bookmark-o fa-2x saved_btns" data-post-id="${post.userPostId}"></i>

														<i class="fa fa-bookmark fa-2x
														unsave" data-unsave-post=${post.userPostId}></i>
													</div>
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>
						<!--#### Main Body End ####-->
						
						<!--#### Side Bar ####-->
						<%@ include file="side_bar.jsp" %>
						<!--#### Side Bar End ####-->	
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

		<script src="static/js/user_suggestion.js"></script>
		<script src="static/js/loader.js"></script>
		<script src="static/js/search_res.js"></script>
		<script src="static/js/all_page_notifications_count.js"></script>
		<script src="static/js/likes.js"></script>
		<script src="static/js/index.js"></script>
		<script src="static/js/save_post.js"></script>
		<script src="static/js/my_pages.js"></script>
		<script src="static/js/side_bar_slide.js"></script>
	</body>
</html>