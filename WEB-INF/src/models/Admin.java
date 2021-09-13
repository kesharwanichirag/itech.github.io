package models;

public class Admin{
	//fields
	private Integer adminId;
	private String adminMail;
	private String adminPsw;
	private String adminProfilePic;
	//constructors

	//methods

	//getters setters
	public void setAdminId(Integer adminId){
		this adminId = adminId;
	}
	public Integer getAdminId(){
		return adminId;
	}

	public void setAdminMail(String adminMail){
		this adminMail = adminMail;
	}
	public String getAdminMail(){
		return adminMail;
	}

	public void setAdminPsw(String adminPsw){
		this adminPsw = adminPsw;
	}
	public String getAdminPsw(){
		return adminPsw;
	}
	
	public void setadminProfilePic(String adminProfilePic){
		this.adminProfilePic = adminProfilePic;
	}
	public void getAdminProfilePic(){
		return adminProfilePic;
	}
}	
