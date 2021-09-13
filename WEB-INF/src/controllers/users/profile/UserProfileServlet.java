package controllers.users.profile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import models.User;
import models.UserPost;

public class UserProfileServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();	

		User user = (User)session.getAttribute("user");

		if(user!=null){
			ArrayList<UserPost> postDetails = UserPost.getPostDetails(user.getUserId());
			request.setAttribute("user_posts",postDetails);
			
			request.getRequestDispatcher("profile.jsp").forward(request,response);
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");

		if(user!=null){
			String updateProfileBio = request.getParameter("edit_bio");
			String updateUserName = request.getParameter("edit_username");
			String updateName = request.getParameter("edit_name");
			
			if(User.updateUserProfile(updateProfileBio,updateUserName,updateName,user.getUserId())){
				user.setProfileBio(updateProfileBio);
				user.setAccountName(updateName);
				user.setUserName(updateUserName);
				
				response.sendRedirect("user_profile.do");
			}else{
				response.sendRedirect("user_profile.do");
			}

		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
}