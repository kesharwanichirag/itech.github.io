package controllers.users.account;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import models.User;

import utils.GoogleCaptcha;
import utils.SMS;
import utils.OTP;

public class RegisterServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		request.getRequestDispatcher("register.jsp").forward(request,response);	
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		String captchaResponse = request.getParameter("g-recaptcha-response");
		HttpSession session = request.getSession();
		
		boolean flag = true;
		
		flag = GoogleCaptcha.verifyCaptcha(captchaResponse);
		String errMsg = "";
		
		if(flag){
			//String termsCheck = request.getParameter("termscheck");
			
			String userName = request.getParameter("username");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			String password = request.getParameter("password");
			String rePassword = request.getParameter("repassword");
	
			//if(termsCheck.equals("done")){
			//########## VALIDATION ##############
				Pattern pattern = null;
				Matcher matcher = null;
			
				//userName 
				String userNamePattern = "^[a-zA-Z][a-zA-Z0-9]{5,19}$";
				pattern = Pattern.compile(userNamePattern);		
				
				matcher = pattern.matcher(userName);
				if(!matcher.matches()){
					flag = false;
					errMsg += "UserName not Valid";
				}

				//email
				String emailPattern = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
				pattern = Pattern.compile(emailPattern);		
				
				matcher = pattern.matcher(email);
				if(!matcher.matches()){
					flag = false;
					errMsg += "Email not Valid..";
				}

				//mobile
				String mobilePattern = "^[0-9]{10,10}$";
				pattern = Pattern.compile(mobilePattern);		
				
				matcher = pattern.matcher(mobile);
				if(!matcher.matches()){
					flag = false;
					errMsg += "Mobile Number not Valid..";
				}
				//passwords
				if(!password.equals(rePassword)){
					flag = false;
					errMsg += "Password and RePassword must Match..";
				}
				
				if(flag){
					session.setAttribute("userNameData",userName);
					session.setAttribute("emailData",email);
					session.setAttribute("mobileData",mobile);
					session.setAttribute("passwordData",password);

					String otpData = OTP.createOTP();
					
					String message = "Your One time Password for Signup is:"+otpData;

					String sms = SMS.sendSms(mobile,message);
					
					session.setAttribute("otpData",otpData);
					System.out.println(otpData);
					response.sendRedirect("register_otp.do");
				}

			//}else{
			//	request.setAttribute("errMsg","Please Accept The Terms and Condition to Signup");
			//	request.getRequestDispatcher("register.jsp").forward(request,response);	
			//}
		}else{
			errMsg += "Captcha Test Failed ! try Again...";
		}
		
		if(!flag){
			request.setAttribute("errMsg",errMsg);
			request.getRequestDispatcher("register.jsp").forward(request,response);
		}
	}
}