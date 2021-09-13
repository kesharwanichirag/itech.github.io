package controllers.users.profile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.ArrayList;

import models.User;
import models.CommentsNotification;

public class ShowCommentsNotificationServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		if(user!=null){
			ArrayList<CommentsNotification> list = CommentsNotification.getCommentNotifications(user.getUserId());
			boolean data = CommentsNotification.updateNotificationType(user.getUserId());
			request.setAttribute("comment_notifications",list);
			request.getRequestDispatcher("comment_notifications.jsp").forward(request,response);
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
}