package controllers.users.profile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.ArrayList;

import models.User;
import models.UserPost;
import models.LikesNotification;

public class LikeNotificationPostViewServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		if(user!=null){
			Integer userId = Integer.parseInt(request.getParameter("user_id"));
			Integer postId = Integer.parseInt(request.getParameter("post_id"));

			UserPost up = new UserPost();
			User userObj = new User(userId);

			userObj.getOtherUserView();
			up.getOthSpecificPost(postId,userId);
			
			request.setAttribute("post_view",up);
			request.setAttribute("othusers",userObj);

			request.getRequestDispatcher("like_notification_post_view.jsp").forward(request,response);

		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
}