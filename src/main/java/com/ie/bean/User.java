package com.ie.bean;

public class User {

	public static final int PAGE_SIZE=3;
	private int userid;
	private String username;
	private String userpwd;
	private String userphone;
	private String usersex;
	private String userdept;
	
	public static int getPageSize() {
		return PAGE_SIZE;
	}
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public String getUsersex() {
		return usersex;
	}

	public void setUsersex(String usersex) {
		this.usersex = usersex;
	}

	public String getUserdept() {
		return userdept;
	}

	public void setUserdept(String userdept) {
		this.userdept = userdept;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
