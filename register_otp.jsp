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
		<link rel="stylesheet" href="static/css/OTP.css">
		<link rel="stylesheet" href="static/css/loader.css">
		
		<!-------- font awersome ---------->
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		<title>OTP Verification</title>
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

		<% String errMsg = (String)request.getAttribute("otp_err_msg"); %>
		
		<div class="modal" id="popout_validation" style='display:<%= errMsg==null?"none":"block"%>'>
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">&#9785; OOPS..!</h5>
						<span id="popup_close_button" type="button" class="btn-close" aria-label="Close">&#10006;</span>
					</div>
					<div id="error_message" class="modal-body">
						<div><%= errMsg %></div>
					</div>
				</div>
			</div>
		</div>
		<div id="body" class="justify-content-center mt-5">
			<section class="container otp_wrapper align-content-center my-5">
				<div class="row">
					<!-- SVG Part -->
					<div class="col svg text-center">
						<img src="static/images/verify.jpg" class="img-fluid mt-4 mb-2">
					</div>
				</div>
				<div class="row">
					<div class="col">
						<h4 class="mt-4 mb-3 d-inline-block">OTP Verifiation</h4>
						<br>
						<div class="mobile-text">
							We Have Send you 5 Digit OTP in Your Mobile Number
						</div>
						<div style="font-weight: bold; color:#40a9ff;">XXX-XXX-XXXX</div>
						
						<form action="register_otp.do" method="post" id="register_form">
							<div class="d-flex flex-row justify-content-center mt-5">
								<input type="text" name="otp1" class="form-control otp_cont" maxlength="1" autofocus>
								<input type="text" name="otp2" class="form-control otp_cont" maxlength="1">
								<input type="text" name="otp3" class="form-control otp_cont" maxlength="1">
								<input type="text" name="otp4" class="form-control otp_cont" maxlength="1">
								<input type="text" name="otp5" class="form-control otp_cont" maxlength="1">
							</div>
							<div class="row">
								<div class="col">
									<label  class="mobile-text mt-3">
										Don't Recieve OTP
									</label>
									<span style="font-weight: 500; color:#0069bf; cursor:pointer;">
										Resend OTP?
									</span>
								<div>
							</div>
							<div class="row">
								<div class="col">
									<button type="submit" id="button" class="mt-3">
										Verify
									</button>		
								<div>
							</div>
							<br><br>
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

		<!--######## JS ########-->
		<script src="static/js/OTP.js"></script>
		<script src="static/js/popup.js"></script>
		<script src="static/js/loader.js"></script>
	</body>
</html>