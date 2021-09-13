package controllers.users.profile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;

import com.google.gson.Gson;

import models.User;
import models.UserFollowing;
import models.UserFollower;

public class FollowUserServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		int userId = Integer.parseInt(request.getParameter("user_id"));
		
		int othUserId = Integer.parseInt(request.getParameter("oth_user_id"));		
		
		UserFollower follower = new UserFollower();
		UserFollowing following = new UserFollowing();
		
		//boolean data1 = follower.checkAlreadyFollowed(othUserId,userId);
		boolean data2 = following.checkAlreadyFollowing(othUserId,userId);

		if(data2==true){
			response.getWriter().write("{\"resp\":1}");
		}else{
			//boolean d1 = UserFollower.followUser(othUserId,userId);
			boolean d2 = UserFollowing.userFollowing(othUserId,userId);

			Gson gson = new Gson();

			//String resp1 = gson.toJson(d1);
			String resp2 = gson.toJson(d2);

			//response.getWriter().write(resp1);
			response.getWriter().write(resp2);
		}
	}
}