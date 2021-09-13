package models;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Timestamp;

import java.util.ArrayList;

public class SavedPost{
	//fields
	private Integer savedPostId;
	private UserPost userPost;
	private User user;
	private Timestamp savedTime;
	private Integer uploadedUserId;

	//constructors
	public SavedPost(){

	}
	public SavedPost(Integer savedPostId,User user,UserPost userPost,Timestamp savedTime,Integer uploadedUserId){
		this.savedPostId = savedPostId;
		this.user = user;
		this.userPost = userPost;
		this.savedTime = savedTime;
		this.uploadedUserId = uploadedUserId;
	}

	//methods
	public static ArrayList<SavedPost> getSavedPost(int userId){
		Connection con = null;
		ArrayList<SavedPost> list = new ArrayList<SavedPost>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");

			String query = "select saved_post_id,user_id,user_post_id,saved_time,uploaded_user_id from saved_posts where user_id=? order by saved_time desc";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);

			ResultSet rs = pst.executeQuery();

			while(rs.next()){
				list.add(new SavedPost(rs.getInt(1),new User(rs.getInt(2)),new UserPost(rs.getInt(3)),rs.getTimestamp(4),rs.getInt(5)));
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

	public static boolean deleteSavedPost(Integer postId){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "delete from saved_posts where user_post_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,postId);
			
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


	public boolean unSavePost(Integer postId,Integer userId){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "delete from saved_posts where user_post_id=? and user_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,postId);
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
	

	public boolean checkAlreadySaved(Integer postId,Integer userId){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "select user_post_id,user_id from saved_posts where user_post_id=? and user_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,postId);
			pst.setInt(2,userId);
				
			ResultSet rs = pst.executeQuery();

			while(rs.next()){
				userPost = new UserPost(rs.getInt(1));
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


	public boolean alreadySavedPost(Integer postId,Integer userId){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "select user_post_id,user_id from saved_posts where user_post_id=? and user_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,postId);
			pst.setInt(2,userId);
				
			ResultSet rs = pst.executeQuery();

			if(rs.next()){
				userPost = new UserPost(rs.getInt(1));
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
	
	public static boolean savePost(Integer postId,Integer userId,Integer uploadedUserId){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "insert into saved_posts (user_post_id,user_id,uploaded_user_id) value(?,?,?)";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,postId);
			pst.setInt(2,userId);
			pst.setInt(3,uploadedUserId);

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

	//getters setters
	public void setSavedPostId(Integer savedPostId){
		this.savedPostId = savedPostId;
	}
	public Integer getSavedPostId(){
		return savedPostId;
	}

	public void setUserPost(UserPost userPost){
		this.userPost = userPost;
	}
	public UserPost getUserPost(){
		return userPost;
	}
	
	public void setUser(User user){
		this.user = user;
	}
	public User getUser(){
		return user;
	}

	public void setSavedTime(Timestamp savedTime){
		this.savedTime = savedTime;
	}	

	public Timestamp getSavedTime(){
		return savedTime;
	}

	public void setUploadedUserId(Integer uploadedUserId){
		this.uploadedUserId = uploadedUserId;
	}
	public Integer getUploadedUserId(){
		return uploadedUserId;
	}
}	