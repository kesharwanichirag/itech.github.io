package controllers.users.newprofile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;

import models.User;

public class AccountBIOServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		if(user!=null){
			request.getRequestDispatcher("new_login_profile_step3.jsp").forward(request,response);
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		if(user!=null){
			String accountBio = request.getParameter("account_bio");
			if(User.saveUserBio(accountBio,user.getUserId())){
				user.setProfileBio(accountBio);
				response.sendRedirect("save_address.do");
			}else{
				request.setAttribute("error","Failed To save Bio Try Again..!");
				request.getRequestDispatcher("new_login_profile_step3.jsp").forward(request,response);
			}
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}

	}
}