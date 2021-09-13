package controllers.users.profile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.Gson;

import models.User;
import models.UserFollowing;

public class FollowingUsersListServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		int userId = Integer.parseInt(request.getParameter("user_id"));
	
		ArrayList<UserFollowing> list = UserFollowing.followingUsersList(userId);
		
		Gson gson = new Gson();

		String resp = gson.toJson(list);

		response.getWriter().write(resp);
	}
}