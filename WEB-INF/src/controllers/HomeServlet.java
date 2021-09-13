package controllers;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;

import java.io.IOException;
import java.util.ArrayList;

import models.User;

import models.UserPost;

public class HomeServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		User user = (User)request.getSession().getAttribute("user");
		
		ArrayList<UserPost> list = UserPost.getAllPostDetails();

		request.setAttribute("posts_list",list);

		if(user!=null){
			request.getRequestDispatcher("index.jsp").forward(request,response);
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
}