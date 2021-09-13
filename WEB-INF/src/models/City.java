package models;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;

public class City{
	//field summary
	
	private Integer cityId;
	private String city; 
	private State state;

	//constructors
	public City(Integer cityId){
		this.cityId = cityId;
	}

	public City(Integer cityId,State state,String city){
		this.cityId = cityId;
		this.state = state;
		this.city = city;
	}


	//methods
	public static ArrayList<City> GetAllCities(){
		ArrayList<City> list = new ArrayList<City>();
		Connection connection = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");

			String query = "select city_id,state_id,city from cities";
			PreparedStatement pst = connection.prepareStatement(query);

			ResultSet rs = pst.executeQuery();

			while(rs.next()){
				list.add(new City(rs.getInt(1),new State(rs.getInt(2)),rs.getString(3)));
			}

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();	
			}catch(SQLException e){
				
			}
		}

		return list;
	}

	// getters setters
	public void setCityId(Integer cityId){
		cityId = this.cityId;
	}
	public Integer getCityId(){
		return cityId;
	}
	
	public void setCity(String city){
		city = this.city;
	}
	public String getCity(){
		return city;
	}

	public void setState(State state){
		state = this.state;
	}
	public State getState(){
		return state;
	}

}