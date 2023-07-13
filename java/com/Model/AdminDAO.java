package com.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAO {

	public AdminGetSet userLogin(String Username, String Password) {
		DatabaseConnection dc= new DatabaseConnection();
		Connection con = dc.getConnect();
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		AdminGetSet adminGetSet = null;
		try {
			String query = "select * from admin where AdminName=? and Password=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,Username);
			ps.setString(2,Password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				adminGetSet = new AdminGetSet();
				adminGetSet.setAdminId(rs.getInt("AdminId"));
				adminGetSet.setAdminname(rs.getString("AdminName"));
				adminGetSet.setGender(rs.getString("Gender"));
				adminGetSet.setDob(rs.getString("DOB"));
				adminGetSet.setEmail(rs.getString("Email"));
				adminGetSet.setAddress(rs.getString("Address"));
				adminGetSet.setPhone(rs.getString("Phone"));
				
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return adminGetSet;
		
	}
}
