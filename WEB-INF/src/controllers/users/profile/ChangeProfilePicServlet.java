package controllers.users.profile;

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

public class ChangeProfilePicServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");

		if(user!=null){
			if(ServletFileUpload.isMultipartContent(request)){
				DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

				ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

				List<FileItem> listItems = null;
				try{
					listItems = servletFileUpload.parseRequest(request);
				}catch(FileUploadException e){
					e.printStackTrace();
				}
				
				FileItem fileItem = listItems.get(0);
				
				String uploadPath = getServletContext().getRealPath("/WEB-INF/uploads/"+user.getUserName());
				
				File file = new File(uploadPath,fileItem.getName());

				try{
					fileItem.write(file);
					user.setProfilePic(user.getUserName()+"/"+fileItem.getName());
					
					user.saveProfilePic();
				}catch(Exception e){
					e.printStackTrace();
				}
				response.sendRedirect("user_profile.do");
			}	
		}else{
			request.getRequestDispatcher("login.jsp").forward(request,response);
		}
	}
}