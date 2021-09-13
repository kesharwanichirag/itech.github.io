package models;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class Status{
	
	// field summary
	private Integer statusId;
	private String status;

	//constructors
	public Status(Integer statusId){
		this.statusId = statusId;
	}
	
	//methods 


	//getters and setters
	public void setStatusId(Integer statusId){
		this.statusId = statusId;
	}
	public Integer getStatusId(){
		return statusId;
	}

	public void setStatus(String status){
		this.status = status;
	}
	public String getStatus(){
		return status;
	}
}