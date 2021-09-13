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
		<link rel="stylesheet" href="static/css/common.css">
		<link rel="stylesheet" href="static/css/form.css">
		<link rel="stylesheet" href="static/css/loader.css">
		<link rel="stylesheet" href="static/css/all_pages_view.css">
		
		<!-------- font awersome ---------->
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		
		<!---------captcha------------>
		<script src="https://www.google.com/recaptcha/api.js"></script>

		<title>Create New Account</title>
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

		<% String errMsg = (String)request.getAttribute("errMsg"); %>
		
		<div class="modal" id="popout_validation" style='display:<%= errMsg==null?"none":"block"%>'>
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">
							<i class="fa fa-exclamation-triangle" aria-hidden="true"></i>
							&nbsp;
							<span>An Error</span>
						</h5>
						<span id="popup_close_button" type="button" class="btn-close" ></span>
					</div>
					<div id="error_message" class="modal-body">
						<div><%= errMsg %></div>
					</div>
				</div>
			</div>
		</div>

		<div id="body" class="m-md-5 m-md-0 m-sm-0 m-0">
			<section class=" container-md wrapper align-content-center">
				<div class="row">
					<!-- SVG Part -->
					<div class=" col-xl-7 col-lg-6 col-md-5 col-1 svg_part text-center">

						<img src="static/images/women.jpg" class="mt-4 mb-2 d-none d-md-block">
						<div class="mb-4 d-none d-md-block">
							<span id="svg_connect_text">Connect</span>
							<span id="svg_with_text">With</span>
							<span id="svg_your_text">Your</span>
							<span id="svg_frnd_text">Friends
							</span>
						</div>
						<!--on large screen ---->

						<div class="mt-2 d-xl-none d-none d-md-block"> 
							<div class="mt-2">
								<div class="login_with py-2">
									<a href="">
										<img src="static/images/google.jpg" class="login_images" style="height: 20px;">
										<span>Continue With Google</span>
									</a>
								</div>
							</div>		
							<div class=" mt-xxl-0 mt-2">
								<div class="login_with py-2">
									<a href="">
										<img src="static/images/facebook.png" style="height: 20px;">
										<span>Continue With Facebook</span>
									</a>
								</div>
							</div>
						</div>
					
					</div>
					<!-- SVG Part end -->

					
					<!-- Form Part -->
					<div class="col-xxl-5 col-xl-5 col-lg-6 col-md-7 col-sm-11 col-11" id="form_part">
						<h4 class="mt-4 mb-3 d-inline-block">Create New Account</h4>
						<br>
						
						<form action="user_registeration.do" method="post" id="register_form">
							<div class="form-row mt-xxl-4 mt-3">
								<div class="col-xxl-6 col-11 mb-xxl-0 mb-2">
									<div class="d-inline-block align-items-center input_box"> 
										<i class="fas fa-user form_icons"></i> 
										<input type="text" name="username" id="username" class="d-inline-block input" autocomplete="off" placeholder="UserName">
										<span class="tooltiptext" id="tooltip1">
										A-Z a-z 0-9 are Allowed in this Field
										</span>	
										<div class="d-inline-block">
											<span id="wrong1" class="wrong">
												!
											</span>
											<span id="check1" class="check">
												&#10003;
											</span>
										</div>
									</div>
								</div>
								<div class="col-xxl-6 col-11 mb-xxl-0 mb-2">
									<div class="d-inline-block align-items-center input_box"> 
										<i class="fas fa-mobile form_icons"></i> 
										<input type="number" name="mobile" id="mobile" class="d-inline-block input" autocomplete="off" placeholder="Mobile" maxlength="10" minlength="10">
										<span class="tooltiptext" id="tooltip3">
											Please Write 10 Digit Mobile Number
										</span>
										<div class="d-inline-block">
											<span id="wrong3" class="wrong">
												!
											</span>
											<span id="check3" class="check">
												&#10003;
											</span>
										</div>
										
									</div>
								</div>
							</div>
							<div class="row mt-xxl-3 mb-xxl-0 mb-2">
								<div class="col-xxl-12 col-11">
									<div class="input_box" id="email_box">
										<div class="d-inline-block align-items-center" style="width:90%"> 
											<i class="fas fa-envelope form_icons"></i> 
											<input type="email" name="email" id="email" class="d-inline-block input" autocomplete="off" placeholder="Email" style="width:80%">	
										</div>
										<span class="tooltiptext" id="tooltip2">
											Please Write Valid Email
										</span>
										<div class="d-inline-block">
											<span id="wrong2" class="wrong">
												!
											</span>
											<span id="check2" class="check">
												&#10003;
											</span>
										</div>
									</div>		
								</div>
							</div>
							<div class="form-row mt-xxl-3">
								<div class="col-xxl-6 col-11 mb-xxl-0 mb-2">
									<div class="d-inline-block align-items-center input_box"> 
										<i class="fas fa-key form_icons"></i> 
										<input type="password" name="password" id="pwd" class="d-inline-block input" autocomplete="off" placeholder="Password">		
										<span class="tooltiptext" id="tooltip4">
											Password Must Contain numeric Symbol,Uppercase Symbol,Lowercase Symbol and Special Symbol
										</span>
										<div class="d-inline-block">
											<span id="wrong4" class="wrong">
												!
											</span>
											<span id="check4" class="check">
												&#10003;
											</span>
										</div>
									</div>
								</div>
								<div class="col-xxl-6 col-11 mb-xxl-0 mb-2">
									<div class="d-inline-block align-items-center input_box"> 
										<i class="fas fa-key form_icons"></i> 
										<input type="password" name="repassword" id="Cnfpwd" class="d-inline-block input" autocomplete="off" placeholder="Confirm Password">	
										<span class="tooltiptext" id="tooltip5">
											Password and RePassword Must Match
										</span>
										<div class="d-inline-block">
											<span id="wrong5" class="wrong">
												!
											</span>
											<span id="check5" class="check">
												&#10003;
											</span>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col">
									<div class="g-recaptcha mt-xxl-4 mt-3" data-sitekey="6LdxBaMaAAAAABOAOFStgwkh_2wYw6vxGyTsPmGy" id="g_captcha_response">
									</div>
								</div>
							</div>				
							<div class="row">
								<div class="col">
									<button type="submit" id="button" class="mt-3">
										Create Account
									</button>		
								</div>
							</div>
						</form>
						<div class="row mt-xxl-3 d-xxl-block d-xl-block d-lg-none d-md-none d-sm-block ml-sm-0 mt-1"> 
							<div class="col-12 mt-2">
								<div class="login_with py-2">
									<a href="">
										<img src="static/images/google.jpg">
										<span>Continue With Google</span>
									</a>
								</div>
							</div>		
							<div class="col-12 mt-2">
								<div class="login_with py-2">
									<a href="">
										<img src="static/images/facebook.png">
										<span>Continue With Facebook
										</span>
									</a>
								</div>
							</div>
						</div>
						<!-- Account start -->
						<div class="text-center mt-4 mb-4" id="other_box">
							<span>Already Have an Account?</span> 
							<a href="login_user.do" class="ml-1">Log In</a>
						</div>
					<!-- Account end -->
					</div>
					<!-- form Part End-->
					
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

		<!----------------- JS File ------------------->
		<script src="static/js/register.js"></script>
		<script src="static/js/loader.js"></script>
	</body>
</html>