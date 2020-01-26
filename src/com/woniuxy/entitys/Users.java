package com.woniuxy.entitys;

public class Users {

	private int userId;
	private String userName;
	private String userPwd;
	private String userRole;
	private String userStatus;
	


	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Users(int userId, String userName, String userPwd, String userRole, String userStatus) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userRole = userRole;
		this.userStatus = userStatus;
	}


	
	
	
	public Users(String userName, String userRole) {
		super();
		this.userName = userName;
		this.userRole = userRole;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserPwd() {
		return userPwd;
	}


	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}


	public String getUserRole() {
		return userRole;
	}


	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}


	public String getUserStatus() {
		return userStatus;
	}


	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}


	@Override
	public String toString() {
		return "UserServlet [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", userRole="
				+ userRole + ", userStatus=" + userStatus + "]";
	}

	
	
}
