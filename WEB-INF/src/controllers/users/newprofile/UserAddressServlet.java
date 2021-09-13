package controllers.users.newprofile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;

import models.User;

public class UserAddressServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		if(user!=null){
			request.getRequestDispatcher("new_login_profile_step4.jsp").forward(request,response);
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		if(user!=null){
			int cityId = Integer.parseInt(request.getParameter("city_id"));
			String address = request.getParameter("address");

			if(User.saveUserAddress(cityId,address,user.getUserId())){
				response.sendRedirect("index.do");
			}else{
				request.setAttribute("error","Failed To save Address Try Again..!");
				request.getRequestDispatcher("user_login_profile_step4.jsp").forward(request,response);	
			}
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
}