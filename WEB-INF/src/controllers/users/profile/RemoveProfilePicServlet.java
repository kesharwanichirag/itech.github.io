package controllers.users.profile;

import javax.servlet.http.*;
import javax.servlet.*;

import java.io.IOException;

import models.User;

public class RemoveProfilePicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");

		if(user!=null){
			if(User.removeProfilePic(user.getUserId())){
				user.setProfilePic("user/user.png");			
				
				request.getRequestDispatcher("profile.jsp").forward(request,response);
			}else{
				request.getRequestDispatcher("profile.jsp").forward(request,response);
			}
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
}