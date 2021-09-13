package models;

import java.sql.*;
import java.util.*;

public class LikesNotification{
	//fields
	private Integer likesnotificationId;
	private String likesNotificationType;
	private Integer sendUserId;
	private Timestamp likeNotificationTime;
	private String likeNotificationMsg;
	private User user; 
	private UserPost userPost;
	private Like like;

	//constructors
	public LikesNotification(){

	}
	public LikesNotification(Integer likesnotificationId,String likesNotificationType,User user,Integer sendUserId,UserPost userPost,Timestamp likeNotificationTime,String likeNotificationMsg){
		this.likesnotificationId = likesnotificationId;
		this.likesNotificationType = likesNotificationType;
		this.user = user;
		this.sendUserId = sendUserId;
		this.userPost = userPost;
		this.likeNotificationTime = likeNotificationTime;
		this.likeNotificationMsg = likeNotificationMsg;
	}

	//methods
	public int likeNotificationsCount(Integer userId){
		Connection con = null;
		int count = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "select count(*) from likes_notifications where user_id=? and like_notification_type=? and send_user_id!=user_id";

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

	public static boolean deleteLikesNotificationByPostId(Integer userPostId){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "delete from likes_notifications where user_post_id=?";

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
	
	public static boolean deleteLikesNotification(Integer userId,Integer sendUserId,Integer userPostId){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "delete from likes_notifications where user_id=? and send_user_id=? and user_post_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);
			pst.setInt(2,sendUserId);
			pst.setInt(3,userPostId);

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


	public static boolean updateNotificationType(Integer userId){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "update likes_notifications set like_notification_type=? where user_id=?";

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

	public static ArrayList<LikesNotification> getLikeNotifications(Integer userId){
		Connection con = null;
		ArrayList<LikesNotification> list = new ArrayList<LikesNotification>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "select likes_notification_id,like_notification_type,user_id,send_user_id,user_post_id,like_notification_time,like_notification_msg from likes_notifications where user_id=? and user_id!=send_user_id order by likes_notification_id desc";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);
			
			ResultSet rs = pst.executeQuery();

			while(rs.next()){
				list.add(new LikesNotification(rs.getInt(1),rs.getString(2),new User(rs.getInt(3)),rs.getInt(4),new UserPost(rs.getInt(5)),rs.getTimestamp(6),rs.getString(7)));
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

	public static boolean insertLikeNotification(Integer userId,Integer sendUserId,Integer userPostId,String notificationMessage){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "insert into likes_notifications (user_id,send_user_id,user_post_id,like_notification_msg) value (?,?,?,?)";

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
	public void setLikesnotificationId(Integer likesnotificationId){
		this.likesnotificationId = likesnotificationId;
	}
	public Integer getLikesnotificationId(){
		return likesnotificationId;
	}

	public void setLikesNotificationType(String likesNotificationType){
		this.likesNotificationType = likesNotificationType;
	}
	public String getLikesNotificationType(){
		return likesNotificationType;
	}

	public void setSendUserId(Integer sendUserId){
		this.sendUserId = sendUserId;
	}
	public Integer getSendUserId(){
		return sendUserId;
	}

	public void setLikeNotificationTime(Timestamp likeNotificationTime){
		this.likeNotificationTime = likeNotificationTime;
	}
	public Timestamp getLikeNotificationTime(){
		return likeNotificationTime;
	}

	public void setLikeNotificationMsg(String likeNotificationMsg){
		this.likeNotificationMsg = likeNotificationMsg;
	}
	public String getLikeNotificationMsg(){
		return likeNotificationMsg;
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

	public void setLike(Like like){
		this.like = like;
	}
	public Like getLike(){
		return like;
	}
}