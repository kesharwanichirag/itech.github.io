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

		<title>Login</title>
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
			<section class="container-md wrapper align-content-center">
				<div class="row">
					<!-- SVG Part -->
					<div class="col-xl-7 col-lg-6 col-md-5 col-1 svg_part text-center">
						<img src="static/images/login.jpg" class="d-none d-md-block mt-4 mb-2">
						
					</div>
					<!-- SVG Part end -->

					
					<!-- Form Part -->
					<div class="col-xxl-5 col-xl-5 col-lg-6 col-md-7 col-sm-11 col-11" id="form_part">
						<h4 class="mt-4 mb-3 d-inline-block">Login</h4>
						<br>
						
						<form action="login_user.do" method="post" id="register_form">
							<div class="form-row mt-4">
								<div class="col-xxl-6 col-11 mb-xxl-0 mb-2">
									<div class="d-inline-block align-items-center input_box"> 
										<i class="fas fa-user form_icons"></i> 

										<input class="input" type="text" name="user_or_mobile" id="userName" placeholder="UserName/Mobile" autocomplete="off">
									</div>
								</div>
								<div class="col-xxl-6 col-11 mb-xxl-0 mb-2">
									<div class="d-inline-block align-items-center input_box"> 
										<i class="fas fa-mobile form_icons"></i> 
										
										<input class="d-inline-block input" type="password" name="password" id="pwd" placeholder="Password" autocomplete="off">

									</div>
								</div>
							</div>
							<div class="row">
								<div class="col">
									<div class="g-recaptcha mt-xxl-4 mt-3" data-sitekey="6LdxBaMaAAAAABOAOFStgwkh_2wYw6vxGyTsPmGy" id="g_captcha_response">
									</div>
								</div>
							</div>
							<!--<div class="custom-control custom-switch mt-4">
								<input type="checkbox" class="custom-control-input" id="customCheck1">
								<label class="custom-control-label" for="customCheck1" style="color:#666;">
									Keep Me Logged In
								</label>
							</div>-->
							<div class="row">
								<div class="col">
									<button type="submit" id="button" class="mt-3">
										Login
									</button>		
								<div>
							</div>
						</form>
					</div>
					<!-- form Part End-->
					<!-- Account start -->
					<div class="text-center mt-xxl-4 mt-3 mt-lg-4 mb-2" id="other_box">
						<span>Don't Have Account ?</span> 
						<a href="user_registeration.do" class="ml-1 d-block d-sm-inline-block">Sign Up</a>
					</div>
					<div class="text-center mt-3 mb-4" id="other_box">
						<span> Did'nt Remember Password ?</span> 
						<a href="forgot_password.do" class="ml-1 d-block d-sm-inline-block">Forgot Password</a>
					</div>
					<!-- Account end -->
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
		<!--############################################-->
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