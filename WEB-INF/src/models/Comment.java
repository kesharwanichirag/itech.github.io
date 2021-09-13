package models;

import java.sql.*;
import java.util.ArrayList;

public class Comment{
	//fields
	private Integer commentId;
	private String comment;
	private UserPost userPost;
	private Timestamp commentTime;
	private User user;
	//constructors
	public Comment(){

	}
	public Comment(Integer commentId,User user,String comment,Timestamp commentTime){
		this.commentId = commentId;
		this.user = user;
		this.comment = comment;
		this.commentTime = commentTime;
	}


	//methods
	public static boolean deletePostComments(Integer postId){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "delete from comments where user_post_id=?";

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


	public ArrayList<Comment> getComments(Integer userPostId){
		Connection con = null;
		ArrayList<Comment> comments = new ArrayList<Comment>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "select comment_id,user_id,comment,comment_time from comments where user_post_id=? order by comment_id asc";

			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1,userPostId);
			
			ResultSet rs = pst.executeQuery();

			while(rs.next()){
				comments.add(new Comment(rs.getInt(1),new User(rs.getInt(2)),rs.getString(3),rs.getTimestamp(4)));
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
		return comments;
	}

	public static boolean insertPostComment(Integer userId,String comment,Integer userPostId){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "insert into comments (user_id,comment,user_post_id) value(?,?,?)";

			PreparedStatement pst = con.prepareStatement(query);
			
			pst.setInt(1,userId);
			pst.setString(2,comment);
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

	//getters setters
	public void setCommentId(Integer commentId){
		this.commentId = commentId;
	}
	public Integer getCommentId(){
		return commentId;
	}

	public void setComment(String comment){
		this.comment = comment;
	}
	public String getComment(){
		return comment;
	}

	public void setCommentTime(Timestamp commentTime){
		this.commentTime = commentTime;
	}
	public Timestamp getCommentTime(){
		return commentTime;
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