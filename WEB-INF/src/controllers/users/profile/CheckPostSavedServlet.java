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

public class CheckPostSavedServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		int userId = Integer.parseInt(request.getParameter("user_id"));
		
		int userPostId = Integer.parseInt(request.getParameter("user_post_id"));		
        
        SavedPost post = new SavedPost();

		boolean data = post.checkAlreadySaved(userPostId,userId);

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