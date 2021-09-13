package controllers.users.account;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import models.User;

public class ForgotActivationLinkServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		String email = request.getParameter("email");
		String activationCode = request.getParameter("activationcode");
		
		if(User.activateForgotPassword(email,activationCode)){
			request.getSession().setAttribute("email",email);
			request.setAttribute("success","Congratulations.. ! your Email Account Has Successfully Verified..");
		}else{
			request.setAttribute("failed","activation failed");
		}
		request.getRequestDispatcher("change_forgot_password.jsp").forward(request,response);
	}
}