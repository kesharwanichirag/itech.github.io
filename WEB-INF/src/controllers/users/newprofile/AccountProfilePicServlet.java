package controllers.users.newprofile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileItem;

import java.io.IOException;
import java.util.List;
import java.io.File;

import models.User;

public class AccountProfilePicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");

		if(user!=null){
			request.getRequestDispatcher("new_login_profile_step1.jsp").forward(request,response);	
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");

		if(user!=null){
			if(ServletFileUpload.isMultipartContent(request)){
				DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

				ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

				try{
					List<FileItem> fileItems = servletFileUpload.parseRequest(request);
					String uploadPath = getServletContext().getRealPath("/WEB-INF/uploads/"+user.getUserName());

					for(FileItem fileItem : fileItems){
						File file = new File(uploadPath,fileItem.getName());

						try{
							fileItem.write(file);
							user.setProfilePic(user.getUserName()+"/"+fileItem.getName());
						
							user.saveProfilePic();
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				}catch(FileUploadException e){
					e.printStackTrace();
				}

				response.sendRedirect("new_account_name.do");
			}	
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
}