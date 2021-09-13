package models;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Country{
	
	//field summary
	private Integer countryId;
	private String country;


	//getters and setters
	public void setCountryId(Integer countryId){
		this.countryId = countryId;
	}
	public Integer getCountryId(){
		return countryId;
	}

	public void setCountry(String country){
		this.country = country;
	}
	public String getCountry(){
		return country;
	}
}