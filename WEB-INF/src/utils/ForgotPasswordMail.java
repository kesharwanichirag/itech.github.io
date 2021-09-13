package utils;

public class ForgotPasswordMail{
	public static String sendMail(String email,String activationCode){
		String message = 	"<style>"+	
								"body{"+
									"margin: 0px auto;"+
									"font-family: arial;"+
								"}"+
								"#header{"+
									"height: 120px;"+
									"border-bottom: 2px solid #cf3c48;"+
									"margin: 0px auto;"+
								"}"+
								"#logo{"+
									"height: 120px;"+
									"margin-left: 30px;"+
								"}"+
								"#main_body{"+
									"text-align: center;"+
								"}"+
								"h3{"+
									"color: #cf3c48;"+
								"}"+
								"h4{"+
									"font-size: 22px;"+
								"}"+
								"h5{"+
									"font-size: 20px;"+
									"color: green;"+
								"}"+
								"a{"+
									"border: 1px solid green;"+
									"padding: 8px 20px;"+
									"background-color: #aaffaa;"+
									"color: black;"+
									"text-decoration: none;"+
									"font-size: 17px;"+
								"}"+
							"</style>"+
								"<div id='container'>"+
									"<div id='header'>"+
										"<img src='http://localhost:8080/itech/static/images/logo.png' id='logo'>"+
									"</div>"+
									"<div id='main_body'>"+
										"<h3>Welcome to Itech</h3>"+
										
										"<h5>click over activation link to activate forgot password</h5>"+
										
										"<a href='http://localhost:8080/itech/activate_forgot_password.do?email="+email+"&activationcode="+activationCode+"'>Link For Reset Password</a>"+
									"</div>"+
								"</div>";
				
	return message;
	}
}