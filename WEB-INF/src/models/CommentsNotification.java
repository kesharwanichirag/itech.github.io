package models;

import java.sql.*;
import java.util.*;

public class CommentsNotification{
	//fields
	private Integer commentsnotificationId;
	private String commentsNotificationType;
	private Integer sendUserId;
	private Timestamp commentsNotificationTime;
	private String commentsNotificationMsg;
	private User user; 
	private UserPost userPost;

	//constructors
	public CommentsNotification(){

	}
	public CommentsNotification(Integer commentsnotificationId,String commentsNotificationType,User user,Integer sendUserId,UserPost userPost,Timestamp commentsNotificationTime,String commentsNotificationMsg){
		this.commentsnotificationId = commentsnotificationId;
		this.commentsNotificationType = commentsNotificationType;
		this.user = user;
		this.sendUserId = sendUserId;
		this.userPost = userPost;
		this.commentsNotificationTime = commentsNotificationTime;
		this.commentsNotificationMsg = commentsNotificationMsg;
	}
	

	//methods
	public static boolean updateNotificationType(Integer userId){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "update comments_notifications set comments_notification_type=? where user_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,"mid");
			pst.setInt(2,userId);
			
			pst.executeUpdate();

			flag = true;

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return flag;
	}
	public int commentsNotificationsCount(Integer userId){
		Connection con = null;
		int count = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "select count(*) from comments_notifications where user_id=? and comments_notification_type=? and send_user_id!=user_id";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);
			pst.setString(2,"new");
			
			ResultSet rs = pst.executeQuery();

			if(rs.next()){
				count = rs.getInt("count(*)");
			}

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return count;
	}

	public static boolean deleteCommentsNotificationByPostId(Integer userPostId){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "delete from comments_notifications where user_post_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userPostId);

			pst.executeUpdate();

			flag = true;

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return flag;
	}

	public static ArrayList<CommentsNotification> getCommentNotifications(Integer userId){
		Connection con = null;
		ArrayList<CommentsNotification> list = new ArrayList<CommentsNotification>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "select comments_notification_id,comments_notification_type,user_id,send_user_id,user_post_id,comments_notification_time ,comments_notification_msg from comments_notifications where user_id=? and user_id!=send_user_id order by comments_notification_id desc";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);
			
			ResultSet rs = pst.executeQuery();

			while(rs.next()){
				list.add(new CommentsNotification(rs.getInt(1),rs.getString(2),new User(rs.getInt(3)),rs.getInt(4),new UserPost(rs.getInt(5)),rs.getTimestamp(6),rs.getString(7)));
			}

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return list;
	}

	public static boolean insertCommentsNotification(Integer userId,Integer sendUserId,Integer userPostId,String notificationMessage){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "insert into comments_notifications (user_id,send_user_id,user_post_id,comments_notification_msg) value (?,?,?,?)";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);
			pst.setInt(2,sendUserId);
			pst.setInt(3,userPostId);
			pst.setString(4,notificationMessage);

			pst.executeUpdate();

			flag = true;

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return flag;
	}



	//setters getters 
	public void setCommentsnotificationId(Integer commentsnotificationId){
		this.commentsnotificationId = commentsnotificationId;
	}
	public Integer getCommentsnotificationId(){
		return commentsnotificationId;
	}

	public void setCommentsNotificationType(String commentsNotificationType){
		this.commentsNotificationType = commentsNotificationType;
	}
	public String getCommentsNotificationType(){
		return commentsNotificationType;
	}

	public void setSendUserId(Integer sendUserId){
		this.sendUserId = sendUserId;
	}
	public Integer getSendUserId(){
		return sendUserId;
	}

	public void setCommentsNotificationTime(Timestamp commentsNotificationTime){
		this.commentsNotificationTime = commentsNotificationTime;
	}
	public Timestamp getCommentsNotificationTime(){
		return commentsNotificationTime;
	}

	public void setCommentsNotificationMsg(String commentsNotificationMsg){
		this.commentsNotificationMsg = commentsNotificationMsg;
	}
	public String getCommentsNotificationMsg(){
		return commentsNotificationMsg;
	}

	public void setUser(User user){
		this.user = user;
	}
	public User getUser(){
		return user;
	}

	public void setUserPost(UserPost userPost){
		this.userPost = userPost;
	}
	public UserPost getUserPost(){
		return userPost;
	}
}