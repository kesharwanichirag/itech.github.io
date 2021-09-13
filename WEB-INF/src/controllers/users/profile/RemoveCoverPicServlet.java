package controllers.users.profile;

import javax.servlet.http.*;
import javax.servlet.*;

import java.io.IOException;

import models.User;

public class RemoveCoverPicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");

		if(user!=null){
			if(User.removeCoverPic(user.getUserId())){
				user.setCoverPic("user/cover.png");			
				
				request.getRequestDispatcher("profile.jsp").forward(request,response);
			}else{
				request.getRequestDispatcher("profile.jsp").forward(request,response);
			}
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
}