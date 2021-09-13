package controllers.users.account;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import models.User;

public class ActivateAccountServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		String userNameData = request.getParameter("userkey");
		String activationCode = request.getParameter("activationcode");
		
		if(User.activateUserAccount(userNameData,activationCode)){
			request.setAttribute("success","Congratulations.. Your Account Has Activated Successfully");
		}else{
			request.setAttribute("failed","OOPS! Account Activation Failed..!");
		}
		request.getRequestDispatcher("result.jsp").forward(request,response);
	}
}