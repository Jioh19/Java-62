package com.edutecno.model;

public class User {
	private String name;
	private String last;
	private String email;
	private String phone;
	private Gender gender;
	private String username;
	private String password;
	public User(String name, String last, String email, String phone, Gender gender, String username, String password) {
		super();
		this.name = name;
		this.last = last;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.username = username;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//Formato CSV, comma separated values
	@Override
	public String toString() {
		return name + "," + last + "," + email + "," + phone + "," + gender
				+ "," + username + "," + password;
	}
	public User() {
		super();
	}
	
	
}
