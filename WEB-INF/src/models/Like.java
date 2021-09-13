package models;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class Like{
	//fields
	private Integer likeId;
	private UserPost userPost;
	private User user;
	
	//constructors

	//methods
	public static boolean deletePostAllLikes(Integer postId){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "delete from likes where user_post_id=?";

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

	public boolean deletePostLike(Integer postId,Integer userId){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "delete from likes where user_post_id=? and user_id=?";

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
	
	public boolean likeByUser(Integer postId,Integer userId){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "select user_post_id,user_id from likes where user_post_id=? and user_id=?";

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

	public int postLikeCount(Integer postId){
		Connection con = null;
		int count = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "select count(*) from likes where user_post_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,postId);
			
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
	

	public static boolean insertPostLike(Integer postId,Integer userId){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "insert into likes (user_post_id,user_id) value(?,?)";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,postId);
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

	//getters setters
	public void setLikeId(Integer likeId){
		this.likeId = likeId;
	}
	public Integer getlikeId(){
		return likeId;
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
}	