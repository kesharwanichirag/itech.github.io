package models;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

public class UserPage{
	//fields summary

	private Integer userPageId;
	private String userPageName;
	private String description;
	private String pageProfilePic;
	private String pageType;
	private Timestamp pageTime;
	private User user;

	//constructors
	public UserPage(){

	}
	public UserPage(Integer userPageId,User user,String userPageName,String pageType){
		this.userPageId = userPageId;
		this.user = user;
		this.userPageName = userPageName;
		this.pageType = pageType;
	}

	//methods
	public static ArrayList<UserPage> getMyPages(Integer userId){
		Connection con = null;
		ArrayList<UserPage> pages = new ArrayList<UserPage>();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "select user_page_id,user_id,user_page_name,page_type from user_pages where user_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);

			ResultSet rs = pst.executeQuery();

			while(rs.next()){
				pages.add(new UserPage(rs.getInt(1),new User(rs.getInt(2)),rs.getString(3),rs.getString(4)));
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
		return pages;
	}

	public static boolean createPage(Integer userId,String pageName,String description,String pageType){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "insert into user_pages (user_id,user_page_name,description,page_type) value (?,?,?,?)";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);
			pst.setString(2,pageName);
			pst.setString(3,description);
			pst.setString(4,pageType);

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
	// getters setters
	public void setUserPageId(Integer userPageId){
		userPageId = this.userPageId;
	}
	public Integer getUserPageId(){
		return userPageId;
	}
	
	public void setUserPageName(String userPageName){
		userPageName = this.userPageName;
	}
	public String getUserPageName(){
		return userPageName;
	}

	public void setDescription(String description){
		description = this.description;
	}
	public String getDescription(){
		return description;
	}

	public void setPageProfilePic(String pageProfilePic){
		pageProfilePic = this.pageProfilePic;
	}
	public String getPageProfilePic(){
		return pageProfilePic;
	}

	public void setPageType(String pageType){
		pageType = this.pageType;
	}
	public String getPageType(){
		return pageType;
	}

	public void setPageTime(Timestamp pageTime){
		pageTime = this.pageTime;
	}
	public Timestamp getPageTime(){
		return pageTime;
	}

	public void setUser(User user){
		user = this.user;
	}
	public User getUser(){
		return user;
	}
}