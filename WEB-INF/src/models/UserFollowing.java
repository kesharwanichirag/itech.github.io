package models;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;

import java.util.ArrayList;

public class UserFollowing{
	//fields summary

	private Integer userFollowingId;
	private Integer followingPersonId; 
	private Timestamp followingAddedTime;
	private User user;

	//constructors
	public UserFollowing(){

	}

	public UserFollowing(Integer userFollowingId){
		this.userFollowingId = userFollowingId;
	}

	public UserFollowing(User user,Integer userFollowingId){
		this.user = user;
		this.userFollowingId = userFollowingId;
	}

	//methods
	public static ArrayList<UserFollowing> followingUsersList(Integer userId){
		Connection con = null;
		ArrayList<UserFollowing> list = new ArrayList<UserFollowing>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "select user_id,following_user_id from user_following where user_id=?";
			
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);
				
			ResultSet rs = pst.executeQuery();

			while(rs.next()){
				list.add(new UserFollowing(new User(rs.getInt(1)),rs.getInt(2)));
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


	public boolean unfollowUsers(Integer othUserId,Integer userId){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "delete from user_following where following_user_id=? and user_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,othUserId);
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


	public boolean checkAlreadyFollowing(Integer sgUserId,Integer userId){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "select user_id,following_user_id from user_following where following_user_id=? and user_id=?";
			
			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,sgUserId);
			pst.setInt(2,userId);
				
			ResultSet rs = pst.executeQuery();

			if(rs.next()){
				followingPersonId = rs.getInt(1);
				user = new User(rs.getInt(2));
			
				flag = true;
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

	public static boolean userFollowing(Integer sgUserId,Integer userId){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "insert into user_following (following_user_id,user_id) value(?,?)";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,sgUserId);
			pst.setInt(2,userId);

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
	public void setUserFollowingId(Integer userFollowingId){
		userFollowingId = this.userFollowingId;
	}
	public Integer getUserFollowingId(){
		return userFollowingId;
	}
	
	public void setFollowingPersonId(Integer followingPersonId){
		followingPersonId = this.followingPersonId;
	}
	public Integer getFollowingPersonId(){
		return followingPersonId;
	}

	public void setFollowingAddedTime(Timestamp followingAddedTime){
		followingAddedTime = this.followingAddedTime;
	}
	public Timestamp getFollowingAddedTime(){
		return followingAddedTime;
	}

	public void setUser(User user){
		user = this.user;
	}
	public User getUser(){
		return user;
	}
}