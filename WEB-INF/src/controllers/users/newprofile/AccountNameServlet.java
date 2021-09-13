package controllers.users.newprofile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;

import models.User;

public class AccountNameServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");

		if(user!=null){
			request.getRequestDispatcher("new_login_profile_step2.jsp").forward(request,response);	
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");

		if(user!=null){
			String accountName = request.getParameter("name");
			if(User.saveUserAccountName(accountName,user.getUserId())){
				user.setAccountName(accountName);

				response.sendRedirect("new_account_bio.do");
			}else{
				request.setAttribute("error","failed to Save Name.. Try Again..!");
				request.getRequestDispatcher("new_login_profile_step2.jsp").forward(request,response);	
			}
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
}