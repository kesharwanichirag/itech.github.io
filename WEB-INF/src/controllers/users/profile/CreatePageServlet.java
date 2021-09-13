package controllers.users.profile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;

import models.User;
import models.UserPage;

public class CreatePageServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");	

		if(user!=null){
			String pageName = request.getParameter("page_name");
			String pageDescription = request.getParameter("page_description");
			String pageType = request.getParameter("page_type");

			UserPage.createPage(user.getUserId(),pageName,pageDescription,pageType);

			response.sendRedirect("user_profile.do");
		}else{
			request.getRequestDispatcher("user_login.do").forward(request,response);
		}
	}
}