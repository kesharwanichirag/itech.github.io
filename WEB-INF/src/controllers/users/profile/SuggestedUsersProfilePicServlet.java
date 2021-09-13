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

public class SuggestedUsersProfilePicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		String userProPic = request.getParameter("user_pro_pic");

		OutputStream os = response.getOutputStream();

		String path = "/WEB-INF/uploads/"+userProPic;
		
		InputStream is = getServletContext().getResourceAsStream(path);

		byte[] by = new byte[1024];

		int count = 0;

		while((count=is.read(by))!=-1){
			os.write(by);
		}
		os.flush();
		os.close();
	}
}