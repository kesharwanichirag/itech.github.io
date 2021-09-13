package controllers.users;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.ArrayList;

import models.User;

import com.google.gson.Gson;

public class SearchUserServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();	

		User user = (User)session.getAttribute("user");

		if(user!=null){
			String sKey = request.getParameter("skey");
			int userId = Integer.parseInt(request.getParameter("user_id"));

			ArrayList<User> users = User.searchUsers(sKey,userId);

			Gson gson = new Gson();

			String resp = gson.toJson(users);

			response.getWriter().write(resp);
		}else{
			response.getWriter().write("session expired");
		}
	}
}