package controllers.users.account;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;

import models.User;

public class UniqueCheckServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		String uKey = request.getParameter("ukey");
		
		boolean flag = User.checkUniqueKey(uKey);

		response.getWriter().write(flag+"");
	}
}