package controllers.users.profile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import models.User;
import models.UserPost;

public class SuggestedUserViewServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		if(user!=null){
			int userId = Integer.parseInt(request.getParameter("user_id"));

			User userObj = new User(userId);

			userObj.getOtherUserView();
			ArrayList<UserPost> posts = UserPost.getPostDetails(userId);

			request.setAttribute("othusers",userObj);
			request.setAttribute("posts",posts);

			request.getRequestDispatcher("user_view.jsp").forward(request,response);
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
}