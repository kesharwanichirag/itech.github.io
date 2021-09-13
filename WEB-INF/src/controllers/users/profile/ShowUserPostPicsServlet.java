package controllers.users.profile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;


import models.User;
import models.UserPost;

public class ShowUserPostPicsServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");
		OutputStream outputStream = response.getOutputStream();
		
		Integer userId = Integer.parseInt(request.getParameter("user_id"));
		Integer userPostId = Integer.parseInt(request.getParameter("user_post_id"));
		
		String image = UserPost.getPostImagePath(userId,userPostId);
		
		InputStream inputStream = getServletContext().getResourceAsStream("/WEB-INF/uploads/"+image);

		byte[] arr = new byte[1024];
		
		int count = 0;

		while((count=inputStream.read(arr))!=-1){
			outputStream.write(arr);
		}
	
		outputStream.flush();
		outputStream.close();

	}
}

