package com.Model;

public class User {
	
	private String firstname;
	private String lastname;
	private String username;
	private String gender;
	private String dob;
	private String email;
	private String address;
	private String phone;
	private String image;
	private String password;
	
	public User() {
	}
	public User(String firstname, String lastname, String username, String gender, String dob, String email,
			String address, String phone, String image, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.image = image;
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}	
	
	public String getUsername() {
		return username;
	}
	public String getGender() {
		return gender;
	}
	public String getDob() {
		return dob;
	}
	public String getEmail() {
		return email;
	}
	public String getAddress() {
		return address;
	}
	public String getPhone() {
		return phone;
	}
	public String getImage() {
		return image;
	}
	public String getPassword() {
		return password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
