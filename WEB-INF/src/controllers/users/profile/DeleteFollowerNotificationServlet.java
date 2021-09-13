package controllers.users.profile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;

import models.User;
import models.FollowersNotification;

import com.google.gson.Gson;

public class DeleteFollowerNotificationServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		if(user!=null){
			Integer userId = Integer.parseInt(request.getParameter("user_id"));//get user id 
			Integer sendUserId = Integer.parseInt(request.getParameter("send_user_id"));//session user id
			
			boolean data = FollowersNotification.deleteFollowersNotification(userId,sendUserId);

			Gson gson = new Gson();

			String resp = gson.toJson(data);

			response.getWriter().write(resp);
		}else{
			response.getWriter().write("{\"resp\":1}");			
		}
	}
}