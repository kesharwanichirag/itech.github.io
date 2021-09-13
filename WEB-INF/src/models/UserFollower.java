package models;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserFollower{
	//field summary
	
	private Integer userFollowerId;
	private Integer followerPersonId; 
	private Timestamp followerAddedTime;
	private User user;

	//constructors

	public UserFollower(){

	}

	public UserFollower(User user,Integer followerPersonId){
		this.user = user;
		this.followerPersonId = followerPersonId;
	}

	public static ArrayList<UserFollower> followersUsersList(Integer userId){
		Connection con = null;
		ArrayList<UserFollower> list = new ArrayList<UserFollower>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "select user_id,follower_person_id from user_followers where user_id=?";
			
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);
				
			ResultSet rs = pst.executeQuery();

			while(rs.next()){
				list.add(new UserFollower(new User(rs.getInt(1)),rs.getInt(2)));
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

	//delete follow
	public static boolean deletefollowUsers(Integer userId,Integer sessionUserId){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "delete from user_followers where follower_person_id=? and user_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,sessionUserId);
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

	//follow user
	public static boolean followUser(Integer userId,Integer sessionUserId){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "insert into user_followers (user_id,follower_person_id) value(?,?)";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);
			pst.setInt(2,sessionUserId);

			int count = pst.executeUpdate();
	
			if(count==1){
				flag = true;	
			}else{
				flag = false;
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
		return flag;
	}

	// getters setters
	public void setUserFollowerId(Integer userFollowerId){
		userFollowerId = this.userFollowerId;
	}
	public Integer getUserFollowerId(){
		return userFollowerId;
	}
	
	public void setFollowerPersonId(Integer followerPersonId){
		followerPersonId = this.followerPersonId;
	}
	public Integer getFollowerPersonId(){
		return followerPersonId;
	}

	public void setFollowerAddedTime(Timestamp followerAddedTime){
		followerAddedTime = this.followerAddedTime;
	}
	public Timestamp getFollowerAddedTime(){
		return followerAddedTime;
	}

	public void setUser(User user){
		user = this.user;
	}
	public User getUser(){
		return user;
	}
}