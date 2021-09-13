<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<!-------- meta tags ------------>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		<!-- Favicons -->
		<link href="static/images/logo.png" rel="icon">
		
		<!------------- CSS CDN bs-4.6 ---------------->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

		<!------------- CSS CDN bs-5.0 beta ---------------->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

		<!-------- css ------>
		<link rel="stylesheet" type="text/css" href="static/css/common.css">
		<link rel="stylesheet" type="text/css" href="static/css/form.css">
		<link rel="stylesheet" type="text/css" href="static/css/new_profile_pages.css">
		<link rel="stylesheet" type="text/css" href="static/css/loader.css">
	
		<!-------- font awersome ---------->
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		
		<title>step 2</title>

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

		<% String errMsg = (String)request.getAttribute("error"); %>

		<div class="modal" id="popout_validation" style='display:<%= errMsg==null?"none":"block"%>'>
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">&#9785; OOPS..!</h5>
						<span id="popup_close_button" type="button" class="btn-close" ></span>
					</div>
					<div id="error_message" class="modal-body">
						<div><%= errMsg %></div>
					</div>
				</div>
			</div>
		</div>

		<div id="body" class="">
			<section class="container wrapper align-content-center my-5">
				<div class="row">
					<!-- SVG Part -->
					
					<c:choose>
						<c:when test="${user.profilePic==null}">
							<div class="col-md-7 profile_pic_part">
								<img src="static/images/user.png" class="img-fluid ml-5 mt-1 mb-5">
							</div>
						</c:when>
						<c:otherwise>
							<div class="col-md-7 profile_pic_part">
								<div>
									<h5 class="d-inline-block" style="color: #888; margin-left: 160px; ">Your Profile Pic 
										<span style="color: #000; font-weight: 700; font-size: 25px;">
											${user.userName}
										</span>
									</h5>
								</div>
								<br>
								<img src="show_profile_pic.do" class="img-fluid ml-5 mt-1 mb-5">
							</div>
						</c:otherwise>
					</c:choose>
					<!-- SVG Part end -->

					<!-- Form Part -->
					<div class="col-md-5 mt-5" id="form_part">
						<!--<div class="mt-3 mb-3 wlcm_box">
							<span>Welcome</span>
							<b>${user.userName}</b>
						</div>-->
						<h4 class="mt-3 mb-3 d-inline-block">Enter Full Name</h4>
						<br>
						
						<form action="new_account_name.do" method="post" id="register_form">
							<div class="form-row mt-3">
								<div class="col">
									<div class="d-inline-block align-items-center input_box" style="width: 80%"> 
										<i class="fas fa-user form_icons"></i> 
										
										<input class="input" type="text" name="name" placeholder="Enter Your Full Name" autocomplete="off" autocomplete="off" style="width: 70%">
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col">
									<a href="new_account_bio.do" class="skip mt-3 float-left">
										Skip
									</a>
									<button type="submit" id="button" class="mt-3 mr-5 float-right">
										Save & Next
									</button>		
								<div>
							</div>
						</form>
					</div>
				</div>
			</section>
			<br>
		</div>
		<!------preloader------->
		<div id="pre_loader" class="text-center align-middle">
			<div class="spinner-border text-primary"
			role="status">
			  	<span class="visually-hidden">Loading...</span>
			</div>
		</div>
		<!--###################################################################-->
		<!---------------- JavaScript CDN 4.6 ----------------->
		<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
		
		<!--------------- Java Script CDN 5.0 beta------------->
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>

		<!-- Js -->
		<script src="static/js/popup.js"></script>
		<script src="static/js/loader.js"></script>
	</body>
</html>