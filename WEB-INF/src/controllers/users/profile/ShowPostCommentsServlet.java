package controllers.users.profile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.ArrayList;

import models.User;
import models.Comment;

import com.google.gson.Gson;

public class ShowPostCommentsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		if(user!=null){
			Integer userPostId = Integer.parseInt(request.getParameter("user_post_id"));

			Comment comment = new Comment();
			ArrayList<Comment> comments = comment.getComments(userPostId);	

			Gson gson = new Gson();

			String resp = gson.toJson(comments);

			response.getWriter().write(resp);
		}else{
			response.getWriter().write("{\"resp\":1}");
		}
	}
}