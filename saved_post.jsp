<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Saved Posts</title>
		
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
		<link rel="stylesheet" type="text/css" href="static/css/saved_posts.css">
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
						<%@ include file="header.jsp" %>
						<!----### header Directive End ###----->
							
						<!--#### Main Body ####-->
						<div class="col-7 main_body">
							<h5 class="ml-4 mt-3">
								Saved Items
							</h5>

							<a href="user_profile.do" class="fa fa-arrow-left ml-5 mt-3 px-3 py-2" id="back_btn">
								&nbsp;&nbsp;Back
							</a>

							<div class="post_container mt-2 text-center">
								<!---Each Post--->
								<c:choose>
									<c:when test="${empty saved_posts}">
										<div class="text-center mt-5" style="color:#aaa">
											<i class="fa fa-picture-o fa-5x" aria-hidden="true"></i>
											<div class="mb-4" style="font-size:25px;">
												No Posts Available
											</div>
										</div>
									</c:when>
									<c:otherwise>
										<c:forEach var="post" items="${saved_posts}">
											<a href="saved_posts_view.do?post_id=${post.userPost.userPostId}&user_id=${post.uploadedUserId}" class="post_card mx-3 text-center mt-3 pt-4 pb-3 px-4 d-inline-block">
											  	<img src="saved_posts_images.do?user_post_id=${post.userPost.userPostId}" class="post_img">
											  	<br>
											  	<span class="mt-2 d-inline-block saved_date">
											  		${post.savedTime}
											  	</span>
											</a>
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
		
		<!--------------- Java Script CDN 5.0 beta------------->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

		<script src="static/js/user_suggestion.js"></script>
		<script src="static/js/loader.js"></script>
		<script src="static/js/search_res.js"></script>
		<script src="static/js/all_page_notifications_count.js"></script>
		<script src="static/js/my_pages.js"></script>
	</body>
</html>