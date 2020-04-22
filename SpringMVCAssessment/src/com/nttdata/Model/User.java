package com.nttdata.Model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class User {

	@NotEmpty(message="User name should not be Empty")
	private String user;
	@NotEmpty
	@Email
	private String email;
	
	@NotEmpty
	private int phoneNo;
	
	@NotEmpty(message="Password should not be Empty")
	
	private String password;
	
	public int getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(int phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
