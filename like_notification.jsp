<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="itech" uri="itech_tld" %>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Like Notifications</title>
		
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
		<link rel="stylesheet" type="text/css" href="static/css/side_bar.css">
		<link rel="stylesheet" type="text/css" href="static/css/loader.css">
		<link rel="stylesheet" type="text/css" href="static/css/notifications.css">
		<link rel="stylesheet" type="text/css" href="static/css/
		top_header.css">
		<link rel="stylesheet" type="text/css" href="static/css/
		resp_header.css">
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
						<!----### header Directive ###----->

						<%@ include file="responsive_header.jsp"%>

						<%@ include file="top_header.jsp"%>
						<!------- Side Header --------->
						<!------- Side Header --------->
						<div class="col-2">
							<!--<div>
								<a href="index.do" class="d-inline-block mt-3" >
									<img src="static/images/logo.png" class="m-1 py-2 px-3" id="logo">
								</a>
							</div>-->
							<div class="menu_container mt-3">
								<div class="menu py-2 ">
									<a href="index.do"class="menu_links">
										<i class="fa fa-home menu_icons "></i>
										<span class="d-none
										d-lg-inline-block menu_messages ">Home</span>
									</a>
								</div>
								<div class="menu py-2">
									<a href="inbox.do" class="menu_links">
										<i class="fa fa-commenting menu_icons "></i>
										<span class="d-none
										d-lg-inline-block menu_messages">Message</span>
									</a>
								</div>
								<div class="menu py-sm-2 menu_selected">
									<a href="all_notification.do" class="menu_links">
										<i class="fa fa-bell menu_icons menu_selected_text">
											
										</i>
										<span id="notfication_text_seperate" class="menu_messages d-none
										d-lg-inline-block menu_selected_text">Notifications</span>
										<span id="all_count_notify" class="float-right">
											
										</span>
									</a>
								</div>
								<div class="menu py-2 ">
									<a href="user_profile.do" class="menu_links">
										<i class="fa fa-user menu_icons "></i>
										<span class="d-none
										d-lg-inline-block menu_messages ">Profile</span>
									</a>
								</div>
								<div class="menu py-2">
									<a href="" class="menu_links">
										<i class="fa fa-gear menu_icons"></i>
										<span class="menu_messages d-none
										d-lg-inline-block">Settings</span>
									</a>
								</div>
								<div class="menu py-2">
									<a href="show_saved_post.do" class="menu_links">
										<i class="fa fa-bookmark menu_icons"></i>
										<span class="menu_messages d-none
										d-lg-inline-block">Saved</span>
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
							<h5 class="ml-4 mt-3 saved_posts_label ">
								Notifications
							</h5>
							<div class="mt-3 icons_container">
								<div class="fa-2x px-md-3 px-2 py-2 d-inline-block">
									<a href="all_notification.do" class="fa fa-list-alt nav_icons " aria-hidden="true"></a>
								</div>
								<div class="fa-2x px-md-3 px-2 py-2 d-inline-block">
									<a href="like_notification.do" class="fa fa-heart nav_icons d-inline-block nav_icons_active" aria-hidden="true"></a>
									<span id="likes_count" class="d-inline-block notify_count" 
									style="font-size: 10px;"></span>
								</div>
								<div class="fa-2x px-md-3 px-2 py-2 d-inline-block">
									<a href="followers_notification.do" class="fa fa-user-o nav_icons" aria-hidden="true"></a>
									<span id="followers_count" class="d-inline-block notify_count" 
									style="font-size: 10px;"></span>
								</div>
								<div class="fa-2x px-md-3 px-2 py-2 d-inline-block">
									<a href="comment_notification.do" class="fa fa-comments-o nav_icons" aria-hidden="true"></a>
									<span id="comments_count" class="d-inline-block notify_count" 
									style="font-size: 10px;"></span>
								</div>
							</div>
							<div class="notification_container my-3">
								<c:choose>
									<c:when test="${empty likes_notifications}">
										<div class="text-center" style="color:#aaa">
											<i class="fa fa-exclamation-circle fa-5x" aria-hidden="true"></i>
											<div class="mb-4" style="font-size:23px;">
												No Notification Available
											</div>
										</div>
									</c:when>
									<c:otherwise>
										<c:forEach var="notify" items="${likes_notifications}">
											
											<!---hidden---->
											<input type="hidden" value="${notify.sendUserId}" id="send_user_id" class="send_user_ids">

											<input type="hidden" value="${user.userId}" id="user_id">	

											<div class="mt-2 notifications_messages 
											py-2">
												<a href="like_notification_post_view.do?post_id=${notify.userPost.userPostId}&user_id=${notify.user.userId}" class="text-decoration-none" style="color: #555">
													<span class="send_user_pro_pic_cont">

													</span>
													
													<span class="notify_txt pl-1 pr-3 py-2">
														${notify.likeNotificationMsg}
													</span>
													<br><br>
													<span class="mr-3 px-2 py-1 notify_times">
														${itech:dateformat(notify.likeNotificationTime)}
													</span>

													<img src="saved_posts_images.do?user_post_id=${notify.userPost.userPostId}" class="notify_imgs float-right d-inline-block">
												</a>
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
		<!---------------- JavaScript CDN 4.6 ----------------->
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
		
		<!------------ Java Script CDN 5.0 beta------------->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

		<script src="static/js/user_suggestion.js"></script>
		<script src="static/js/loader.js"></script>
		<script src="static/js/search_res.js"></script>
		<script src="static/js/notifications.js"></script>
		<script src="static/js/new_notifications_counts.js"></script>
		<script src="static/js/all_page_notifications_count.js"></script>
		<script src="static/js/my_pages.js"></script>
	</body>
</html>