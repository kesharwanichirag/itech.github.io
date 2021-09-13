
<!doctype html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Change Password</title>
		
		<!------------- CSS CDN bs-4.6 ---------------->
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">

		<!-- Favicons -->
		<link href="static/images/logo.png" rel="icon">

		<!------------- CSS CDN bs-5.0 beta ---------------->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">

		<!-------- css ------>
		<link rel="stylesheet" href="static/css/common.css">
		<link rel="stylesheet" href="static/css/form.css">
		<link rel="stylesheet" href="static/css/loader.css">
		
		<!-------- font awersome ---------->
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		
		<style>
			#success{
				color: #00bd00;
			}

			#failed{
				color: red;
			}

			#user_email_data{
				text-align: center;
			}

		</style>
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

		<div id="body" class="">
			<section class="container wrapper align-content-center my-5">
				<div class="row">
					<!-- SVG Part -->
					<div class="col-md-7 svg_part text-center">
						<img src="static/images/psw.jpg" class="img-fluid mt-4 mb-2">
						
					</div>
					<!-- SVG Part end -->

					<!-- Form Part -->
					<% String email = (String)session.getAttribute("email");%>
					<c:choose>
						<c:when test="${success!=null}">
							<div class="col-md-5" id="form_part">
								<h4 class="mt-4 mb-3 d-inline-block">Forgot Password</h4>
								<br>
								<div id="success">${success}</div>					
								
								<form action="forgot_save_password.do" method="post" id="register_form">
									<div class="form-row mt-4">
										<div class="col">
											<div class="d-inline-block align-items-center input_box"> 
												<i class="fas fa-key form_icons"></i> 
												
												<input class="d-inline-block input" type="password" name="password" placeholder="Password" autocomplete="off">
												
												<span class="tooltiptext" id="tooltip1">
													Password and Confirm Password Must Match
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
										<div class="col">
											<div class="d-inline-block align-items-center input_box"> 
												<i class="fas fa-key form_icons"></i> 
												
												<input class="d-inline-block input" type="password" name="repassword" id="pwd" placeholder="Confirm Password">
												
												<span class="tooltiptext" id="tooltip2">
													Password and Confirm Password Must Match
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
											<button type="submit" id="button" class="mt-3">
												Save Password
											</button>		
										<div>
									</div>
								</form>
							</div>
							<div class="text-center mt-4 mb-4" id="other_box">
								<span>Don't Have Account ?</span> 
								<a href="user_registeration.do" class="ml-1">Sign Up</a>
							</div>
							<div class="text-center mt-0 mb-4" id="other_box">
								<span>Remember Password ?</span> 
								<a href="login_user.do" class="ml-1">Login</a>
							</div>
						</c:when>
						<c:otherwise>
							<span id="failed">${failed}</span>
							
						</c:otherwise>
					</c:choose>
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
		<script src="static/js/change_forgot_password.js"></script>
		<script src="static/js/loader.js"></script>		
	</body>
</html>