package controllers.users.profile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;

import com.google.gson.Gson;

import models.User;
import models.UserPost;
import models.SavedPost;

public class SavePostServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		int userId = Integer.parseInt(request.getParameter("user_id"));
		int userPostId = Integer.parseInt(request.getParameter("user_post_id"));		
		int postUserId = Integer.parseInt(request.getParameter("post_user_id"));

		SavedPost post = new SavedPost();
		
		boolean data1 = post.alreadySavedPost(userPostId,userId);

		if(data1==true){
			response.getWriter().write("already Saved");
		}else{
			boolean data = SavedPost.savePost(userPostId,userId,postUserId);

			Gson gson = new Gson();

			String resp = gson.toJson(data);

			response.getWriter().write(resp);
		}
	}
}