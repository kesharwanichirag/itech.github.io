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

public class CheckFollowingServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		int userId = Integer.parseInt(request.getParameter("user_id"));
		
		int othUserId = Integer.parseInt(request.getParameter("oth_user_id"));		
        
        UserFollowing uf = new UserFollowing();

		boolean data = uf.checkAlreadyFollowing(othUserId,userId);

		if(data==true){
			Gson gson = new Gson();

			String resp = gson.toJson(data);

			response.getWriter().write(resp);
		}else{
			Gson gson = new Gson();

			String resp = gson.toJson(data);

			response.getWriter().write(resp);	
		}
	}
}