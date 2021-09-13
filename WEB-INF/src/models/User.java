package models;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Timestamp;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.jasypt.util.password.StrongPasswordEncryptor;

public class User{
	//field summary
	
	private Integer userId;
	private String userName; 
	private String accountName;
	private String profilePic;
	private String email;
	private String mobile;
	private String password;
	private String activationCode;
	private String profileBio;
	private String address;
	private Timestamp accountCreatTime;
	private String forgotPasswordCode;
	private Integer userAccountType;
	private String coverPic;
	private Status status;
	private City city;
	private UserActivity userActivity;
	
	//constructor summary
	public User(){
		super();
	}

	public User(Integer userId){
		this.userId = userId;
	}

	public User(Integer userId,String userName,String profilePic){
		this.userId = userId;
		this.userName = userName;
		this.profilePic = profilePic;
	}

	public User(Integer userId,String userName,String accountName,String profilePic){
		this.userId = userId;
		this.userName = userName;
		this.accountName = accountName;
		this.profilePic = profilePic;
	}
	
	//method summary
	public static boolean removeCoverPic(Integer userId){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "update users set cover_pic ='user//cover.png' where user_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);

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

	public ArrayList<User> getLikedPersonDetails(Integer userId){
		Connection con = null;
		ArrayList<User> userList = new ArrayList<User>();

		try{
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");

			String query = "select user_id,username,profile_pic from users where user_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);
			ResultSet rs = pst.executeQuery();

			while(rs.next()){
				User usr = new User(rs.getInt(1),rs.getString(2),rs.getString(3));
				userList.add(usr);	
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
		return userList;
	}


	public static String getProfilePicByUserId(Integer userId){
		Connection con = null;
		String pic = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "select profile_pic from users where user_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);

			ResultSet rs = pst.executeQuery();

			if(rs.next()){
				pic = rs.getString(1);
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
		return pic;
	}

	public static String getUserNameByUserId(Integer userId){
		Connection con = null;
		String userName = null;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "select username from users where user_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);

			ResultSet rs = pst.executeQuery();

			if(rs.next()){
				userName = rs.getString(1);
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
		return userName;
	}

	public static boolean removeProfilePic(Integer userId){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "update users set profile_pic ='user//user.png' where user_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);

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


	public static ArrayList<User> searchUsers(String sKey,int userId){
		Connection con = null;
		ArrayList<User> userList = new ArrayList<User>();

		try{
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");

			String query = "select user_id,username,account_name,profile_pic from users where username like'"+sKey+"%' and user_id!=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);
			ResultSet rs = pst.executeQuery();

			while(rs.next()){
				User usr = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				userList.add(usr);	
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

		return userList;
	}


	public void getOtherUserView(){
		Connection con = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "select user_id,status_id,user_activity_id,city_id,username,account_name,profile_pic,email,mobile,profile_bio,address,user_account_type,cover_pic from users where user_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
				userId = rs.getInt(1);
				status = new Status(rs.getInt(2));
				userActivity = new UserActivity(rs.getInt(3));
				city = new City(rs.getInt(4));
				userName = rs.getString(5);
				accountName = rs.getString(6);
				profilePic = rs.getString(7);
				email = rs.getString(8);
				mobile = rs.getString(9);
				profileBio = rs.getString(10);
				address = rs.getString(11);
				userAccountType = rs.getInt(12);
				coverPic = rs.getString(13);
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
	}


	public static ArrayList<User> showSuggestedUsers(int userId){
		Connection con = null;
		ArrayList<User> list = new ArrayList<User>();

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "select user_id,username,profile_pic from users where user_id!=? limit 3";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,userId);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				list.add(new User(rs.getInt(1),rs.getString(2),rs.getString(3)));
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
		return list;
	}

	public static boolean saveUserAddress(Integer cityId,String address,Integer userId){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "update users set city_id=?,address=? where user_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setInt(1,cityId);
			pst.setString(2,address);
			pst.setInt(3,userId);

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


	public boolean saveCoverPic(){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "update users set cover_pic=? where user_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,coverPic);
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



	public static boolean updateUserProfile(String updateProfileBio,String updateUserName,String updateName,Integer userId){
		Connection connection = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "update users set profile_bio =?, username =? , account_name =? where user_id=?";
			PreparedStatement pst = connection.prepareStatement(query);

			pst.setString(1,updateProfileBio);
			pst.setString(2,updateUserName);
			pst.setString(3,updateName);
			pst.setInt(4,userId);
			
			pst.executeUpdate();

			flag = true;

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return flag;
	}

	public static boolean saveUserBio(String profileBio,Integer userId){
		Connection connection = null;
		boolean flag = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			String query = "update users set profile_bio=? where user_id=?";

			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1,profileBio);
			pst.setInt(2,userId);

			pst.executeUpdate();
			flag = true;

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return flag;
	}

	public boolean saveProfilePic(){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "update users set profile_pic=? where user_id=?";

			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,profilePic);
			pst.setInt(2,userId);

			pst.executeUpdate();

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
		
	public static boolean saveUserAccountName(String accountName,Integer userId){
		Connection connection = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			String query = "update users set account_name=? where user_id=?";
			PreparedStatement pst = connection.prepareStatement(query);

			pst.setString(1,accountName);

			pst.setInt(2,userId);

			int result = pst.executeUpdate();
			
			if(result==1){
				flag = true;
			}

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return flag;
	}

	public static boolean updateAccountType(String userData){
		Connection connection = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			String query = "update users set user_account_type=2 where (username=? or mobile=?)";
			PreparedStatement pst = connection.prepareStatement(query);

			pst.setString(1,userData);

			pst.setString(2,userData);

			int result = pst.executeUpdate();
			
			if(result==1){
				flag = true;
			}

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public static boolean saveForgotedPassword(String email,String password){
		Connection connection = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			String query = "update users set password=? where email=?";

			PreparedStatement pst = connection.prepareStatement(query);
			StrongPasswordEncryptor encp = new StrongPasswordEncryptor();

			String encPassword = encp.encryptPassword(password);
			pst.setString(1,encPassword);

			pst.setString(2,email);

			int result = pst.executeUpdate();
			
			if(result==1){
				flag = true;
			}else{
				flag = false;
			}

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return flag;
	}

	public static boolean activateForgotPassword(String email,String activationCode){
		Connection connection = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			String query = "update users set forgot_password_code='' where email=?";

			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1,email);

			int result = pst.executeUpdate();
			
			if(result==1){
				flag = true;
			}else{
				flag = false;
			}

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public static boolean insertForgotCode(String email,String forgotPasswordCode){
		Connection connection = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			String query = "update users set forgot_password_code=? where email=?";

			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1,forgotPasswordCode);
			pst.setString(2,email);


			int count = pst.executeUpdate();

			if(count==1){
				flag = true;			
			}

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return flag;
	}

	public String checkForgotPasswordEmail(String email){
		Connection connection = null;
		String message = "";

		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			String query = "select user_id,username,email from users where email=?";

			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1,email);

			ResultSet rs = pst.executeQuery();

			if(rs.next()){
				userId = rs.getInt(1);
				userName = rs.getString(2);
				email = rs.getString(3);

				message += "success";
			}else{
				message += "account with email not found..";
			}

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return message;
	}

	public String loginUser(String userData,String password){
		Connection connection = null;
		String message = "";

		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");

			String query = "select password,user_id,status_id,user_activity_id,city_id,username,account_name,profile_pic,email,mobile,profile_bio,address,user_account_type,cover_pic from users where (username=? or mobile=?)";
			
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1,userData);
			pst.setString(2,userData);

			ResultSet rs = pst.executeQuery();

			if(rs.next()){
				String savedPassword = rs.getString(1);

				StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
				if(spe.checkPassword(password,savedPassword)){
					if(rs.getInt(3)==2){
						userId = rs.getInt(2);
						status = new Status(rs.getInt(3));
						userActivity = new UserActivity(rs.getInt(4));
						city = new City(rs.getInt(5));
						userName = rs.getString(6);
						accountName = rs.getString(7);
						profilePic = rs.getString(8);
						email = rs.getString(9);
						mobile = rs.getString(10);
						profileBio = rs.getString(11);
						address = rs.getString(12);
						userAccountType = rs.getInt(13);
						coverPic = rs.getString(14);

						message += "success";

					}else{
						message += "Your Account is not Activated ! Please activate Your Account to LOGIN..";
					}
				}else{
					message += "Invalid Password ! try Again.."; 
				}
			}else{
				message += "Account With This UserName/Mobile Not Available..!";
			}
	
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return message;
	}

	public static boolean checkUniqueKey(String uKey){
		Connection con = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");

			String query = "select user_id from users where username=? or email=? or mobile=? ";
			
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1,uKey);
			pst.setString(2,uKey);
			pst.setString(3,uKey);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()){
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

	public static boolean activateUserAccount(String userName,String activationCode){
		Connection connection = null;
		boolean flag = false;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "update users set status_id=2,activation_code='' where username=? and activation_code=?";
			
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1,userName);
			pst.setString(2,activationCode);

			int result = pst.executeUpdate();
			
			if(result==1){
				flag = true;
			}

		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}
		return flag;
	}
	//registeration
	public static boolean registerUser(String userName,String email,String mobile,String password,String activationCode){
		Connection connection = null;
		boolean flag = false;

		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/itech?user=root&password=1234");
			
			String query = "insert into users (username,email,mobile,password,activation_code) value (?,?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(query);
			pst.setString(1,userName);
			pst.setString(2,email);
			pst.setString(3,mobile);
			
			StrongPasswordEncryptor encp = new StrongPasswordEncryptor();

			String encPassword = encp.encryptPassword(password);
			pst.setString(4,encPassword);
			pst.setString(5,activationCode);

			pst.executeUpdate();

			flag = true;
		}catch(SQLException|ClassNotFoundException e){
			e.printStackTrace();
		}finally{
			try{
				connection.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return flag;
	}

	// getters setters
	public void setUserId(Integer userId){
		this.userId = userId;
	}
	public Integer getUserId(){
		return userId;
	}

	public void setUserName(String userName){
		this.userName = userName;
	}
	public String getUserName(){
		return userName;
	}

	public void setAccountName(String accountName){
		this.accountName = accountName;
	}
	public String getAccountName(){
		return accountName;
	}

	public void setProfilePic(String profilePic){
		this.profilePic = profilePic;
	}
	public String getProfilePic(){
		return profilePic;
	}

	public void setEmail(String email){
		this.email = email;
	}
	public String getEmail(){
		return email;
	}

	public void setMobile(String mobile){
		this.mobile = mobile;
	}
	public String getMobile(){
		return mobile;
	}

	public void setPassword(String password){
		this.password = password;
	}
	public String getPassword(){
		return password;
	}

	public void setActivationCode(String activationCode){
		this.activationCode = activationCode;
	}
	public String getActivationCode(){
		return activationCode;
	}

	public void setProfileBio(String profileBio){
		this.profileBio = profileBio;
	}
	public String getProfileBio(){
		return profileBio;
	}

	public void setAddress(String address){
		this.address = address;
	}
	public String getAddress(){
		return address;
	}
	
	public void setAccountCreatTime(Timestamp accountCreatTime){
		this.accountCreatTime = accountCreatTime;
	}
	public Timestamp getAccountCreatTime(){
		return accountCreatTime;
	}
	
	public void setStatus(Status status){
		this.status = status;
	}
	public Status getStatus(){
		return status;
	}

	public void setCity(City city){
		this.city = city;
	}
	public City getCity(){
		return city;
	}

	public void setUserActivity(UserActivity userActivity){
		this.userActivity = userActivity;
	}
	public UserActivity getUserActivity(){
		return userActivity;
	}

	public void setForgotPasswordCode(String forgotPasswordCode){
		this.forgotPasswordCode = forgotPasswordCode;
	}
	public String getForgotPasswordCode(){
		return forgotPasswordCode;
	}

	public void setUserAccountType(Integer userAccountType){
		this.userAccountType = userAccountType;
	}
	public Integer getUserAccountType(){
		return userAccountType;
	}

	public void setCoverPic(String coverPic){
		this.coverPic = coverPic;
	}
	public String getCoverPic(){
		return coverPic;
	}
}