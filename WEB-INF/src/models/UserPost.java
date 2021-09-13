package models;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.LinkedList;

public class UserPost{
	//fields summary

	private Integer userPostId;
	private String postText;
	private String userPost;
	private Timestamp timeOfUpload;
	private User user;

	//constructors
	public UserPost(){
	
	}
	public UserPost(Integer userPostId){
		this.userPostId = userPostId;
	}

	public UserPost(Integer userPostId,User user){
		this.userPostId = userPostId;
		this.user = user;
	}

	public UserPost(int userPostId,String userPost,Timestamp timeOfUpload,String postText){
		this.userPostId = userPostId;
		this.userPost = userPost;
		this.timeOfUpload = timeOfUpload;
		this.postText = postText;
	}

	public UserPost(int userPostId,String userPost,Timestamp timeOfUpload,String postText,User user){
		this.userPostId = userPostId;
		this.userPost = userPost;
		this.timeOfUpload = timeOfUpload;
		this.postText = postText;
		this.user = user;
	}

	public UserPost(Integer userPostId,String userPost){
		this.userPostId = userPostId;
		this.userPost = userPost;
	}
	
	//methods
	public static ArrayList<UserPost> getAllPostDetails(){
		Connection connection = null;
		 ArrayList<UserPost> posts = new ArrayList<UserPost>();

		try{
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			String query = "select user_post_id,user_post,time_of_upload,post_text,user_id from user_posts order by rand()";

			PreparedStatement pst = connection.prepareStatement(query);
			
			ResultSet rs = pst.executeQuery();

			while(rs.next()){
				posts.add(new UserPost(rs.getInt(1),rs.getString(2),rs.getTimestamp(3),rs.getString(4),new User(rs.getInt(5))));
			}	
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return posts;
	}

	public static String getSavedImagesPath(Integer userPostId){
		Connection connection = null;
		
		String images = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			String query = "select user_post from user_posts where user_post_id=?";

			PreparedStatement pst = connection.prepareStatement(query);
			
			pst.setInt(1,userPostId);

			ResultSet rs = pst.executeQuery();

			while(rs.next()){
				images = rs.getString(1);
			}	
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return images;
	}


	public static boolean deletePostPic(Integer userId,Integer postId){
		Connection connection = null;
		boolean flag = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			String query = "delete from user_posts where user_id=? and user_post_id=?";

			PreparedStatement pst = connection.prepareStatement(query);
			
			pst.setInt(1,userId);
			pst.setInt(2,postId);

			pst.executeUpdate();

			flag = true;

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}

		return flag;
	}

	public void getOthSpecificPost(Integer postId,Integer userId){
		Connection connection = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			String query = "select user_id,user_post_id,user_post,post_text,time_of_upload from user_posts where user_post_id=? and user_id=? order by user_post_id desc";

			PreparedStatement pst = connection.prepareStatement(query);
			
			pst.setInt(1,postId);
			pst.setInt(2,userId);

			ResultSet rs = pst.executeQuery();

			while(rs.next()){
				user = new User(rs.getInt(1));
				userPostId = rs.getInt(2);
				userPost = rs.getString(3);
				postText = rs.getString(4);
				timeOfUpload = rs.getTimestamp(5);
			}	
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}


	public static String getPostImagePath(Integer userId,Integer userPostId){
		Connection connection = null;
		
		String images = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			String query = "select user_post from user_posts where user_id=? and user_post_id=? order by user_post_id desc";

			PreparedStatement pst = connection.prepareStatement(query);
			
			pst.setInt(1,userId);
			pst.setInt(2,userPostId);

			ResultSet rs = pst.executeQuery();

			while(rs.next()){
					images = rs.getString(1);
			}	
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return images;
	}

	public static ArrayList<UserPost> getPostDetails(Integer userId){
		Connection connection = null;
		 ArrayList<UserPost> posts = new ArrayList<UserPost>();

		try{
			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			String query = "select user_post_id,user_post,time_of_upload,post_text from user_posts where user_id=? order by user_post_id desc";

			PreparedStatement pst = connection.prepareStatement(query);
			
			pst.setInt(1,userId);

			ResultSet rs = pst.executeQuery();

			while(rs.next()){
				posts.add(new UserPost(rs.getInt(1),rs.getString(2),rs.getTimestamp(3),rs.getString(4)));
			}	
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return posts;
	}

	public static boolean savePostText(String postText,String userPost){
		boolean flag = false;
		Connection con = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "update user_posts set post_text=? where user_post=?";
			
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1,postText);
			pst.setString(2,userPost);

			pst.executeUpdate();
			
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

	public static boolean uploadPost(String userPost,Integer userId){
		boolean flag = false;
		Connection con = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "insert into user_posts (user_post,user_id) value(?,?)";
			
			PreparedStatement pst = con.prepareStatement(query);

			pst.setString(1,userPost);
			pst.setInt(2,userId);

			pst.executeUpdate();
			
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
	public void setUserPostId(Integer userPostId){
		userPostId = this.userPostId;
	}
	public Integer getUserPostId(){
		return userPostId;
	}
	
	public void setPostText(String postText){
		postText = this.postText;
	}
	public String getPostText(){
		return postText;
	}

	public void setUserPost(String userPost){
		userPost = this.userPost;
	}
	public String getUserPost(){
		return userPost;
	}

	public void setTimeOfUpload(Timestamp timeOfUpload){
		timeOfUpload = this.timeOfUpload;
	}
	public Timestamp getIimeOfUpload(){
		return timeOfUpload;
	}

	public void setUser(User user){
		user = this.user;
	}
	public User getUser(){
		return user;
	}
}