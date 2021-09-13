package models;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.PreparedStatement;

public class UserPagePost{
	//fields summary

	private Integer userPagePostId;
	private String pagePost;
	private String pagePostText;
	private Timestamp pagePostTime;
	private UserPage userPage;

	//constructors

	//methods

	// getters setters
	public void setUserPagePostId(Integer userPagePostId){
		userPagePostId = this.userPagePostId;
	}
	public Integer getUserPagePostId(){
		return userPostId;
	}
	
	public void setPagePost(String postText){
		postText = this.postText;
	}
	public String getPagePost(){
		return pagePost;
	}

	public void setPagePostText(String pagePostText){
		pagePostText = this.pagePostText;
	}
	public String getPagePostText(){
		return pagePostText;
	}

	public void setPagePostTime(Timestamp pagePostTime){
		pagePostTime = this.pagePostTime;
	}
	public Timestamp getPagePostTime(){
		return pagePostTime;
	}

	public void setUserPage(UserPage userPage){
		userPage = this.userPage;
	}
	public UserPage getUserPage(){
		return userPage;
	}
}