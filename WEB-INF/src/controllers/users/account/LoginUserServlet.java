package controllers.users.account;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import models.User;

import utils.GoogleCaptcha;

public class LoginUserServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		request.getRequestDispatcher("login.jsp").forward(request,response);
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		String captchaResponse = request.getParameter("g-recaptcha-response");
		
		HttpSession session = request.getSession();

		boolean flag = true;

		flag = GoogleCaptcha.verifyCaptcha(captchaResponse);
		String errorMessage = "";

		if(flag){
			String userData = request.getParameter("user_or_mobile");
			String password = request.getParameter("password");

			User user = new User();

			String loginData = user.loginUser(userData,password);
			Integer accountType = user.getUserAccountType();
			
			if(loginData.equals("success")){
				if(accountType==1){	
					session.setAttribute("user",user);
					session.setMaxInactiveInterval(86400);
					
					User.updateAccountType(userData);
					
					response.sendRedirect("new_account_pic.do");
				}else{
					session.setAttribute("user",user);
					session.setMaxInactiveInterval(86400);
					
					response.sendRedirect("index.do");
				}
			}else{
				request.setAttribute("error",loginData);
				request.getRequestDispatcher("login.jsp").forward(request,response);
			}
		}else{
			errorMessage += "Captcha Test Failed ! try Again...";
			request.setAttribute("error",errorMessage);
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
}