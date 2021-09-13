package controllers.users.account;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import models.User;

public class SaveForgotedPasswordServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		
		String email = (String)request.getSession().getAttribute("email");
		String password = request.getParameter("password");

		if(User.saveForgotedPassword(email,password)){
			response.sendRedirect("login_user.do");	
		}else{
			response.sendRedirect("index.do");
		}
	}
}