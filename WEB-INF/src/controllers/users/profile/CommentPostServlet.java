package controllers.users.profile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;

import models.User;
import models.UserPost;
import models.Comment;

import com.google.gson.Gson;

public class CommentPostServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		if(user!=null){	
			int userId = Integer.parseInt(request.getParameter("user_id"));
			String comment = request.getParameter("comment");
			int userPostId = Integer.parseInt(request.getParameter("user_post_id"));	

			boolean data = Comment.insertPostComment(userId,comment,userPostId);

			if(data==true){
				Gson gson = new Gson();

				String resp = gson.toJson(data);
				response.getWriter().write(resp);
			}else{
				Gson gson = new Gson();

				String resp = gson.toJson(data);
				response.getWriter().write(resp);
			}
		}else{
			response.getWriter().write("{\"resp\":1}");
		}
	}
}