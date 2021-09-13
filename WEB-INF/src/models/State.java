package models;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class State{
	//field summary
	
	private Integer stateId;
	private String state; 
	private Country country;

	//constructors

	public State(){
		
	}

	public State(Integer stateId){
		this.stateId = stateId;
	}

	// getters setters
	public void setStateId(Integer stateId){
		stateId = this.stateId;
	}
	public Integer getStateId(){
		return stateId;
	}
	
	public void setState(String state){
		state = this.state;
	}
	public String getState(){
		return state;
	}

	public void setCountry(Country country){
		country = this.country;
	}
	public Country getCountry(){
		return country;
	}

}