package controllers.users.profile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;

import com.google.gson.Gson;

import models.User;
import models.Like;

public class PostLikeCountServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		if(user!=null){
			int userPostId = Integer.parseInt(request.getParameter("user_post_id"));

			Like like = new Like();

			int count = like.postLikeCount(userPostId);

			Gson gson = new Gson();

			String resp = gson.toJson(count);

			response.getWriter().write(resp);
		}
	}
}