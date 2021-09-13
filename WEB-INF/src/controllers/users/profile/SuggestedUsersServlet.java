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

public class SuggestedUsersServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();	

		User user = (User)session.getAttribute("user");

		if(user!=null){
			int userId = Integer.parseInt(request.getParameter("user_id"));
			
			ArrayList<User> users = User.showSuggestedUsers(userId);

			Gson gson = new Gson();

			String rsp = gson.toJson(users);
			
			response.getWriter().write(rsp);
		}else{
			response.getWriter().write("{\"resp\":1}");
		}
	}
}
