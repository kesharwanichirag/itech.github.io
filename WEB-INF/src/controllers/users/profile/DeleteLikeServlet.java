package controllers.users.profile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import com.google.gson.Gson;

import models.Like;
import models.User;

public class DeleteLikeServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();

		int userId = Integer.parseInt(request.getParameter("user_id"));
		
		int userPostId = Integer.parseInt(request.getParameter("user_post_id"));		
		
		Like like = new Like();
	
		boolean data = like.deletePostLike(userPostId,userId);

		Gson gson = new Gson();

		String resp = gson.toJson(data);

		response.getWriter().write(resp);
	}
}