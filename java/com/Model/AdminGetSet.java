package com.Model;

public class AdminGetSet {
	private int AdminId;
	private String Adminname;
	private String gender;
	private String dob;
	private String email;
	private String address;
	private String phone;
	private String password;

	public AdminGetSet() {
	}

	public AdminGetSet(int adminId, String adminname, String gender, String dob, String email, String address,
			String phone, String password) {
		super();
		AdminId = adminId;
		Adminname = adminname;
		this.gender = gender;
		this.dob = dob;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.password = password;
	}

	public int getAdminId() {
		return AdminId;
	}

	public void setAdminId(int adminId) {
		AdminId = adminId;
	}

	public String getAdminname() {
		return Adminname;
	}

	public void setAdminname(String adminname) {
		Adminname = adminname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	


}
