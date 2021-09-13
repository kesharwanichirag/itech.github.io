<!doctype html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Inbox</title>
		
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
		<link rel="stylesheet" type="text/css" href="static/css/inbox.css">
		<link rel="stylesheet" type="text/css" href="static/css/loader.css">
		<link rel="stylesheet" type="text/css" href="static/css/side_bar.css">
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
						
						<%@ include file="responsive_header.jsp"%>

						<%@ include file="top_header.jsp"%>
						
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
								<div class="menu py-2 menu_selected">
									<a href="inbox.do" class="menu_links">
										<i class="fa fa-commenting menu_icons menu_selected_text"></i>
										<span class="d-none
										d-lg-inline-block menu_messages menu_selected_text">Message</span>
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
						<!--inbox list--->
						<div class="col-10 col-lg-7 main_body inbox_list">
							<div class="mt-3 ml-3">
								<h5 class="d-inline-block">Inbox</h5>
								<!--<i class="fa fa-pencil-square-o fa-2x float-right mr-2 msg_pen" aria-hidden="true"></i>-->
							</div>
							<div style="width: 90%; margin-left:3%;">
								<input class="form-control mt-2" type="text" placeholder="Search...." aria-label="default input example">	
							</div>
							<div class="inbox_list_container mt-2">
								<a href="" class="text-decoration-none clearfix">
									<!---online---->
									<div class="inbox_msgs mt-1 mb-1">
										<div class="d-inline-block">
											<img src="static/images/maa3.jpg" class="inbox_msgs_pics mt-0 ml-2 mb-2">
										</div>
										<div class="d-inline-block">
											<div class="mt-1 ml-2 inbox_unm">
												ChiragCk
											</div>
											<div class="ml-3 d-inline-block inbox_last_msg">
												byy
											</div>
										</div>
										<i class="float-right fa fa-circle
										 inbox_online mt-4 mr-3"> </i>
									</div>
								</a>
								<!---offline---->

								<div class="inbox_msgs mt-1 mb-1">
									<div class="d-inline-block">
										<img src="static/images/maa2.jpg" class="inbox_msgs_pics mt-0 ml-2 mb-2">
									</div>
									<div class="d-inline-block">
										<div class="mt-1 ml-2  inbox_unm">
											maakali
										</div>
										<div class="ml-3 d-inline-block inbox_last_msg">
											jai mata di
										</div>
									</div>
									<i class="fa fa-circle inbox_offline mt-4 mr-3 float-right"> </i>

								</div>
							</div>	
						</div>
						<%@ include file="side_bar.jsp" %>
						<!--#### Main Body End ####-->		
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