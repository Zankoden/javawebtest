package com.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
	
	public List<GetSetUser> getAllUser(){
		List<GetSetUser> user = new ArrayList<>();
		
		DatabaseConnection dc= new DatabaseConnection();
		Connection con = dc.getConnect();
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
		String query = "select * from user";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			GetSetUser row = new GetSetUser();
			row.setUserId(Integer.parseInt(rs.getString("UserId")));
			row.setFirstname(rs.getString("FirstName"));
			row.setLastname(rs.getString("LastName"));
			row.setUsername(rs.getString("UserName"));
			row.setGender(rs.getString("Gender"));
			row.setDob(rs.getString("DOB"));
			row.setEmail(rs.getString("Email"));
			row.setAddress(rs.getString("Address"));
			row.setPhone(rs.getString("Phone"));
			row.setImage(rs.getString("Image"));
			
			user.add(row);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return user;
		
	}

}
