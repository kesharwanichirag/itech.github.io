package controllers.users.profile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import com.google.gson.Gson;

import models.UserFollowing;
import models.User;

public class UnfollowUserServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();

		int userId = Integer.parseInt(request.getParameter("user_id"));
		
		int othUserId = Integer.parseInt(request.getParameter("oth_user_id"));		
		
		UserFollowing uf = new UserFollowing();
	
		boolean data = uf.unfollowUsers(othUserId,userId);

		Gson gson = new Gson();

		String resp = gson.toJson(data);

		response.getWriter().write(resp);
	}
}