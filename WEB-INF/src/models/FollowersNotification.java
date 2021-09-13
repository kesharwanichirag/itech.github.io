package models;

import java.sql.*;
import java.util.*;

public class FollowersNotification{
	//fields
	private Integer followersnotificationId;
	private String followersNotificationType;
	private Integer sendUserId;
	private Timestamp followersNotificationTime;
	private String followersNotificationMsg;
	private User user; 

	//constructors
	public FollowersNotification(){

	}
	public FollowersNotification(Integer followersnotificationId,String followersNotificationType,User user,Integer sendUserId,Timestamp followersNotificationTime,String followersNotificationMsg){
		this.followersnotificationId = followersnotificationId;
		this.followersNotificationType = followersNotificationType;
		this.user = user;
		this.sendUserId = sendUserId;
		this.followersNotificationTime = followersNotificationTime;
		this.followersNotificationMsg = followersNotificationMsg;
	}

	//methods
	public static boolean updateNotificationType(Integer userId){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "update followers_notifications set followers_notification_type=? where user_id=?";

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
	public int followersNotificationsCount(Integer userId){
		Connection con = null;
		int count = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "select count(*) from followers_notifications where user_id=? and followers_notification_type=? and send_user_id!=user_id";

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

	public static ArrayList<FollowersNotification> getFollowersNotifications(Integer userId){
		Connection con = null;
		ArrayList<FollowersNotification> list = new ArrayList<FollowersNotification>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "select followers_notification_id,followers_notification_type,user_id,send_user_id,followers_notification_time,followers_notification_msg from followers_notifications where user_id=? and user_id!=send_user_id order by followers_notification_id desc";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);
			
			ResultSet rs = pst.executeQuery();

			while(rs.next()){
				list.add(new FollowersNotification(rs.getInt(1),rs.getString(2),new User(rs.getInt(3)),rs.getInt(4),rs.getTimestamp(5),rs.getString(6)));
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
	
	public static boolean deleteFollowersNotification(Integer userId,Integer sendUserId){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "delete from followers_notifications where user_id=? and send_user_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);
			pst.setInt(2,sendUserId);

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

	public static boolean insertFollowersNotification(Integer userId,Integer sendUserId,String notificationMessage){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "insert into followers_notifications (user_id,send_user_id,followers_notification_msg) value (?,?,?)";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);
			pst.setInt(2,sendUserId);
			pst.setString(3,notificationMessage);

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
	public void setSollowersnotificationId(Integer followersnotificationId){
		this.followersnotificationId = followersnotificationId;
	}
	public Integer getFollowersnotificationId(){
		return followersnotificationId;
	}

	public void setFollowersNotificationType(String followersNotificationType){
		this.followersNotificationType = followersNotificationType;
	}
	public String getFollowersNotificationType(){
		return followersNotificationType;
	}

	public void setSendUserId(Integer sendUserId){
		this.sendUserId = sendUserId;
	}
	public Integer getSendUserId(){
		return sendUserId;
	}

	public void setFollowersNotificationTime(Timestamp followersNotificationTime){
		this.followersNotificationTime = followersNotificationTime;
	}
	public Timestamp getFollowersNotificationTime(){
		return followersNotificationTime;
	}

	public void setFollowersNotificationMsg(String followersNotificationMsg){
		this.followersNotificationMsg = followersNotificationMsg;
	}
	public String getFollowersNotificationMsg(){
		return followersNotificationMsg;
	}

	public void setUser(User user){
		this.user = user;
	}
	public User getUser(){
		return user;
	}
}