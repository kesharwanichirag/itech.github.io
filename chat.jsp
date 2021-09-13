<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Chat</title>
		
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
		<link rel="stylesheet" type="text/css" href="static/css/chat.css">
		<link rel="stylesheet" type="text/css" href="static/css/loader.css">
		<link rel="stylesheet" type="text/css" href="static/css/side_bar.css">
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
		<div id="container" class="m-5">
			<div id="contbox" class="justify-content-center px-2">
				<div class="container-fluid">
					<div class="row">
						<!----### header Directive ###----->
						<!------- Side Header --------->
						<div class="col-2">
							<div>
								<a href="index.do" class="d-inline-block mt-3" >
									<img src="static/images/logo.png" class="m-1 py-2 px-3" id="logo">
								</a>
							</div>
							<div class="menu_container mt-4">
								<div class="menu py-2 ">
									<a href="index.do"class="menu_links">
										<i class="fa fa-home menu_icons"></i>
										<span class="menu_messages ">Home</span>
									</a>
								</div>
								<div class="menu py-2 menu_selected">
									<a href="inbox.do" class="menu_links">
										<i class="fa fa-commenting menu_icons menu_selected_text"></i>
										<span class="menu_messages menu_selected_text">Messages</span>
									</a>
								</div>
								<div class="menu py-2">
									<a href="all_notification.do" class="menu_links">
										<i class="fa fa-bell menu_icons">
											
										</i>
										<span class="menu_messages">Notifications</span>
										<span id="all_count_notify" class="float-right">
											
										</span>
									</a>
								</div>
								<div class="menu py-2">
									<a href="user_profile.do" class="menu_links">
										<i class="fa fa-user menu_icons"></i>
										<span class="menu_messages">Profile</span>
									</a>
								</div>
								<div class="menu py-2">
									<a href="" class="menu_links">
										<i class="fa fa-gear menu_icons"></i>
										<span class="menu_messages">Settings</span>
									</a>
								</div>
								<div class="menu py-2">
									<a href="logout_user.do" class="menu_links">
										<i class="fa fa-sign-out menu_icons"></i>
										<span class="menu_messages">Logout</span>
									</a>
								</div>
							</div>
							<hr>
							<div class="head_text_label px-3">
								<span>Account</span>
							</div>
							<div class="session_user mx-2 mt-3">
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
		
						<!--msgs--->
						<div class="col-7 main_body msgs_box">
							<div class="mt-3 msg_head_cont">
								<div class="d-inline-block p-2">
									<a href="" class="fa fa-arrow-left back_arrow mr-2 text-decoration-none" aria-hidden="true"></a>

									<img src="static/images/maa3.jpg" class="profile_pic_msg_top">
								</div>
								<h6 class="d-inline-block msg_names">
									Chiragck
								</h6>
								<div class="d-inline-block float-right">
									<i class="fa fa-info msg_online mt-3 mr-3"></i>
								</div>
							</div>
							<div class="msg_box clearfix" >
								<div class="mt-1 py-3">
									<span class="other_msg px-3 py-2 mt-2 mb-2 ml-2">hello..!</span>
								</div>
								<div class="mt-1 py-3 float-right">
									<span class="my_msg px-3 py-2 mt-2 mb-2 mr-2">hi</span>
								</div>
							</div>
							<div class="msg_control_box clearfix">
								<i class="fa fa-file-image-o ml-3" aria-hidden="true"></i>

								<i class="fa fa-smile-o py-2 ml-2 stickers_btn"></i>

								<input class="ml-2 px-3 py-2 msg_control_input d-inline-block" placeholder="Message.." type="text">
								
								<button class="float-right mt-0 px-3 py-2 send_btn">
									<i class="fa fa-paper-plane"></i>
								</button>
							</div>
						</div>
						<!--#### Main Body End ####-->
						<%@ include file="side_bar.jsp" %>		
					</div>
				</div>
			</div>
		</div>
		<!--hidden-->
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
		<script src="static/js/my_pages.js"></script>
	</body>
</html>