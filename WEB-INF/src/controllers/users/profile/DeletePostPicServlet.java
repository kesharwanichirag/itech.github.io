package controllers.users.profile;

import javax.servlet.http.*;
import javax.servlet.*;

import java.io.IOException;

import com.google.gson.Gson;

import models.UserPost;
import models.User;
import models.Like;
import models.Comment;
import models.SavedPost;
import models.LikesNotification;
import models.CommentsNotification;

public class DeletePostPicServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");

		if(user!=null){
			Integer postId = Integer.parseInt(request.getParameter("user_post_id"));
			Integer userId = Integer.parseInt(request.getParameter("user_id"));

			boolean like = Like.deletePostAllLikes(postId);
			boolean data = Comment.deletePostComments(postId);
			boolean saved = SavedPost.deleteSavedPost(postId);
			boolean notifyLike = LikesNotification.deleteLikesNotificationByPostId(postId);
			boolean notifyCmnt = CommentsNotification.deleteCommentsNotificationByPostId(postId);
			if(like&&data&&saved&&notifyLike&&notifyCmnt==true){
				boolean post = UserPost.deletePostPic(userId,postId);
			
				Gson gson = new Gson();

				String resp = gson.toJson(post);

				response.getWriter().write(resp);
			}else{
				response.getWriter().write("failed to delete post");
			}

		}else{
			response.getWriter().write("{\"resp\":1}");
		}
	}
}