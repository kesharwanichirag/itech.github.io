<!doctype html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Profile</title>
		
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
		<link rel="stylesheet" type="text/css" href="static/css/profile.css">
		<link rel="stylesheet" type="text/css" href="static/css/side_bar.css">
		<link rel="stylesheet" href="static/css/loader.css">
		<link rel="stylesheet" type="text/css" href="static/css/
		top_header.css">
		<link rel="stylesheet" type="text/css" href="static/css/resp_header.css">
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
						<!------- Side Header --------->
						<%@ include file="responsive_header.jsp"%>

						<%@ include file="top_header.jsp"%>

						<!---side mean---->
						<%@ include file="header.jsp" %>	

						<!----### header Directive End ###----->
							
						<!--#### Main Body ####-->
						<div class="col-10 col-lg-7 main_body">
							<!--<div id="liked_message">Liked Successfully..</div>-->
							<div class="profile_box">
								<!--######## cover Pic ########-->
								<img src="sg_user_cover.do?sg_cover_pic=${othusers.coverPic}" class="cover_pic" id="cover_pic_btn" style="cursor: pointer;">

								<!---bio--->
								<c:choose>
									<c:when test="${othusers.profileBio	ne null}">
										<div class="bio_box border text-center mb-3">
											<h6 class="py-2" style="border-bottom: 1px solid #ddd;">
												<i>About me..</i>
											</h6>
											<div class="bio py-1">
												<i>
													${othusers.profileBio}
												</i>
											</div>
										</div>		
									</c:when>
									<c:otherwise>
										<div class="bio_box border text-center mb-3">
											<h6 class="py-2" style="border-bottom: 1px solid #ddd;">
												<i>About me..</i>
											</h6>
											<div class="bio py-1 pb-2">
												<span class="fa fa-exclamation">
													Not Available	
												</span>

											</div>
										</div>
									</c:otherwise>
								</c:choose>
								
							</div>
							<!--#### profile Pic ########-->
								<div class="pro_cont">
								<img src="show_sg_usr_pro_pic.do?user_pro_pic=${othusers.profilePic}" class="profile_pic" id="prof_pic_btn" 
								style=" cursor: pointer;">
								
							</div>
							<!-----name box------>
							<div class="name_box">
								<i class="ml-sm-2 ml-0 username_profile">
									${othusers.userName}
								</i>
								
								<br>

								<small class="ml-sm-4 ml-1 name_profile">
									${othusers.accountName}
								</small>
							</div>

							<div class="profile_name_other_box">
								<!----profile data---->
								
								<div class="text-center pro_data_box">
									<div class="d-inline-block mt-lg-5 mt-md-2 mt-4 mx-xxl-5 mx-xl-4 mx-3"
									id="followers_btn" style="cursor: pointer;">
										<span class="user_profile_acadamic"  id="followers_count"></span>
										<span class="user_profile_acadamic_heads">Followers</span>
									</div>
									<div id="following_btn" class="d-inline-block mt-lg-5 mt-md-2 mt-4 mx-xxl-5 mx-xl-4 mx-3" style="cursor: pointer;">
										<span class="user_profile_acadamic"
										 id="following"></span>
										<span class="user_profile_acadamic_heads">Following</span>
									</div>
									<div class="d-inline-block mt-lg-5 mt-sm-4 mt-md-2 mt-1 mx-xl-5 mx-3">
										<span class="user_profile_acadamic">
											${posts.size()}
										</span>
										<span class="user_profile_acadamic_heads">Posts</span>
									</div>
								</div>
								
								<div class="text-center">
									<button class="btn btn-primary follow_btns"
									 id="follow_btn">
										Follow
									</button>
									<button class="btn unfollow_btns"
									 id="unfollow_btn">
										Following
									</button>
								</div>
								<hr style="margin-bottom: 0px; width: 94%; margin-left: 3%;">
								<div class="profile_btn_box text-left">
									<span class="d-inline-block  btn_prof_drop_downs btn_prof_drop_downs_active mx-1 py-2 px-xl-4 px-2">
										<i class="fa fa-picture-o" aria-hidden="true"></i>
										<span class="ml-1">Feeds</span>
									</span>

									<span class="d-inline-block btn_prof_drop_downs mx-1 py-2 px-xl-4 px-2">
										<i class="fa fa-info" aria-hidden="true"></i>
										<span class="ml-1">About</span>
									</span>
								</div>
							</div>
							<!-----hidden------->	
								<input type="hidden" value="${othusers.userId}" 
								id="oth_user_id">

							<!----hidden end------>
								
							<div class="mt-1 my_feeds_profile_container clearfix">
								<input type="hidden" value="${othusers.userId}" id="cur_user_id">
								<br><br>
								<input type="hidden" value="${user.userName}"
								id="user_name">

								<c:choose>
									<c:when test="${empty posts}">
										<div class="text-center" style="color:#aaa">
											<i class="fa fa-picture-o fa-5x" aria-hidden="true"></i>
											<div class="mb-4" style="font-size:25px;">
												No Posts Available
											</div>
										</div>
									</c:when>
									<c:otherwise>
										<c:forEach var="post" items="${posts}">
											<div class="post_container mt-2 mb-5 text-center">
												
												<input type="hidden" value="${user.userId}" id="user_id">

												<input type="hidden" value="${post.userPostId}" id="user_post_id" class="user_post_ids">

												<div class="post_u_dt text-left">
													<img src="show_sg_usr_pro_pic.do?user_pro_pic=${othusers.profilePic}" class="post_uprofpc">
													<span class="post_unn ml-1">${othusers.userName}</span>

												</div>
												<div>
													<div class="posts_box">
														<img 
														src="oth_user_post.do?user_id=${othusers.userId}&user_post_id=${post.userPostId}" class="post_images">
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
															<a href="oth_post_view.do?post_id=${post.userPostId}&user_id=${othusers.userId}" class="fa fa-comment fa-2x posts_button  d-inline-block comments_btn " style="text-decoration:none"></a>

														</div>

														<!----share---->
														<div class="fa fa-share fa-2x share posts_button  d-inline-block posts_button_from2"></div>

														<!----Save----->
														<div
														 class="posts_button  d-inline-block 
														 posts_button_from2
														">
															<i class="fa fa-bookmark-o fa-2x saved_btns" data-post-id="${post.userPostId}"></i>

															<i class="fa fa-bookmark fa-2x
															unsave" data-unsave-post=${post.userPostId}></i>
														</div>
													</div>
												</div>
											</div>	
										</c:forEach>
									</c:otherwise>
								</c:choose>
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

		<!---- following ----->
		<div id="following_box" class="followers_boxes">
			<span class="float-right mt-2 mr-2" id="close_following" style="color: #ccc; cursor: pointer;">
				<i class="fa fa-times fa-2x"></i>
			</span>
			<div class="ml-4 py-2 px-4 mt-4 text-center d-inline-block" style="background: #fff; border-radius: 10px">
				<span id="following_counts">
					
				</span>
				<label id="following_lbl">
					Following
				</label>
				 
			</div>
			<div id="all_following_box">
				

			</div>
		</div>

		<!---- followers ----->
		<div id="followers_box" class="followers_boxes">
			<span class="float-right mt-2 mr-2" id="close_followers" style="color: #ccc; cursor: pointer;">
				<i class="fa fa-times fa-2x"></i>
			</span>
			<div class="ml-4 py-2 px-4 mt-4 text-center d-inline-block" style="background: #fff; border-radius: 10px">
				<span id="followers_counts">
					
				</span>
				<label id="followers_lbl">
					Followers
				</label>
				 
			</div>
			<div id="all_followers_box">
				

			</div>
		</div>
		<input type="hidden" value="${user.userId}" id="session_user_id">
		<!---------------- JavaScript CDN 4.6 ----------------->
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
		
		<!--------------- Java Script CDN 5.0 beta------------->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
		<!-------------------------------------->
		<script src="static/js/likes.js"></script>
		<script src="static/js/comments.js"></script>
		<script src="static/js/user_suggestion.js"></script>
		<script src="static/js/loader.js"></script>
		<script src="static/js/follow.js"></script>
		<script src="static/js/search_res.js"></script>
		<script src="static/js/followers_data.js"></script>
		<script src="static/js/other_user.js"></script>
		<script src="static/js/save_post.js"></script>
		<script src="static/js/all_page_notifications_count.js"></script>
		<script src="static/js/my_pages.js"></script>
	</body>
</html>