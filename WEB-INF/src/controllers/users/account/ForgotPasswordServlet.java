package controllers.users.account;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import models.User;

import utils.GoogleCaptcha;
import utils.ActivationCodeGenerator;
import utils.EmailSend;
import utils.ForgotPasswordMail;

public class ForgotPasswordServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		request.getRequestDispatcher("forgot_password.jsp").forward(request,response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		String captchaResponse = request.getParameter("g-recaptcha-response");

		boolean flag = true;
		flag = GoogleCaptcha.verifyCaptcha(captchaResponse);

		if(flag){
			String email = request.getParameter("forgot_email");

			User user = new User();
			String data = user.checkForgotPasswordEmail(email);

			if(data.equals("success")){
				String forgotPasswordCode = ActivationCodeGenerator.getActivationCode();

				if(User.insertForgotCode(email,forgotPasswordCode)){
					String message = ForgotPasswordMail.sendMail(email,forgotPasswordCode);
					EmailSend.sendEmail(email,"Link For Forgot Password",message,"legecyprezzie@gmail.com","Prezzie@1legecy");
					
					request.setAttribute("done","mail Send Successfully");
					request.getRequestDispatcher("forgot_password.jsp").forward(request,response);
				}else{
					request.setAttribute("error","Failed.. Try Again..");
					request.getRequestDispatcher("forgot_password.jsp").forward(request,response);
				}
			}else{
				request.setAttribute("error","account with this email not Exists");
				request.getRequestDispatcher("forgot_password.jsp").forward(request,response);
			}
		}else{
			request.setAttribute("error","Captcha test failed");
				request.getRequestDispatcher("forgot_password.jsp").forward(request,response);
		}
	}
}