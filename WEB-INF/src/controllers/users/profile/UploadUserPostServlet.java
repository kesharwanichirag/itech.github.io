package controllers.users.profile;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.ServletException;

import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import java.io.IOException;
import java.util.List;
import java.io.File;

import models.User;
import models.UserPost;

public class UploadUserPostServlet extends HttpServlet{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		
		if(user!=null){
			if(ServletFileUpload.isMultipartContent(request)){
				String postText = request.getParameter("post_text");
			
				DiskFileItemFactory dfif = new DiskFileItemFactory();
				
				ServletFileUpload sfu = new ServletFileUpload(dfif);

				List<FileItem> listItems = null;

				try{
					listItems = sfu.parseRequest(request);
				}catch(FileUploadException e){
					e.printStackTrace();
				}

				FileItem fileItem = listItems.get(0);
				
				String uploadPath = getServletContext().getRealPath("/WEB-INF/uploads/"+user.getUserName()+"/uploads");
				
				UserPost up = new UserPost();

				File file = new File(uploadPath,fileItem.getName());

				try{
					fileItem.write(file);
					up.setUserPost(user.getUserName()+"/uploads/"+fileItem.getName());
					
					UserPost.uploadPost(user.getUserName()+"/uploads/"+fileItem.getName(),user.getUserId());

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