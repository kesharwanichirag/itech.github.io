package models;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class UserActivity{
	//field summary
	
	private Integer userActivityId;
	private String activity; 
	
	//constructors
	public UserActivity(Integer userActivityId){
		this.userActivityId = userActivityId;
	}

	// getters setters
	public void setUserActivityId(Integer userActivityId){
		userActivityId = this.userActivityId;
	}
	public Integer getUserActivityId(){
		return userActivityId;
	}
	
	public void setActivity(String activity){
		activity = this.activity;
	}
	public String getActivity(){
		return activity;
	}
}