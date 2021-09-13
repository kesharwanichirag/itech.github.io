package controllers.users.profile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.ArrayList;

import models.User;
import models.UserPage;

import com.google.gson.Gson;

public class GetMyPagesServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");

		if(user!=null){
			Integer userId = Integer.parseInt(request.getParameter("user_id"));
			ArrayList data = UserPage.getMyPages(userId);

			Gson gson = new Gson();

			String resp = gson.toJson(data);

			response.getWriter().write(resp);
		}else{
			response.getWriter().write("{\"resp\":1}");			
		}
	}
}