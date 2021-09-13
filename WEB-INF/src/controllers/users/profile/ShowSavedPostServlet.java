package controllers.users.profile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.ArrayList;

import models.User;
import models.SavedPost;

public class ShowSavedPostServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		if(user!=null){
			ArrayList<SavedPost> posts = SavedPost.getSavedPost(user.getUserId());

			request.setAttribute("saved_posts",posts);
			request.getRequestDispatcher("saved_post.jsp").forward(request,response);		
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
}