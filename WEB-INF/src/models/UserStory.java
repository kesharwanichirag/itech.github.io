package models;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class UserStory{
	//fields summary

	private Integer userStoryId;
	private String story; 
	private Timestamp uploadTime;
	private User user;
	private UserFollowing userFollowing;

	// getters setters
	public void setUserStoryId(Integer userStoryId){
		userStoryId = this.userStoryId;
	}
	public Integer getUserStoryId(){
		return userStoryId;
	}
	
	public void setStory(String story){
		story = this.story;
	}
	public String getStory(){
		return story;
	}

	public void setUploadTime(Timestamp uploadTime){
		uploadTime = this.uploadTime;
	}
	public Timestamp getUploadTime(){
		return uploadTime;
	}

	public void setUser(User user){
		user = this.user;
	}
	public User getUser(){
		return user;
	}

	public void setUserFollowing(UserFollowing userFollowing){
		userFollowing = this.userFollowing;
	}
	public UserFollowing getUserFollowing(){
		return userFollowing;
	}
}