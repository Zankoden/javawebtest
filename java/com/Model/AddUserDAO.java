package com.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddUserDAO {
	Encryption e = new Encryption();


	public void insertUser(User user) {
		DatabaseConnection dc= new DatabaseConnection();
		Connection con = dc.getConnect();
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String query = "Insert into user (FirstName,LastName,Username,Gender,DOB,Phone,Email,Address,Image,Password) values(?,?,?,?,?,?,?,?,?,?)";
		try{
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1,user.getFirstname());
			ps.setString(2,user.getLastname());
			ps.setString(3,user.getUsername());
			ps.setString(4,user.getGender());
			ps.setString(5,user.getDob());
			ps.setString(6,user.getPhone());
			ps.setString(7,user.getEmail());
			ps.setString(8,user.getAddress());
			ps.setString(9,user.getImage());
			ps.setString(10,user.getPassword());
			ps.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}}
		
		public GetSetUser userLogin(String Username, String Password) {
			DatabaseConnection dc= new DatabaseConnection();
			Connection con = dc.getConnect();
			try { 
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			GetSetUser getSetUser = null;
			try {
				String query = "select * from user where Username=? and Password=?";
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1,Username);
				ps.setString(2,Password);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					getSetUser = new GetSetUser();
					getSetUser.setUserId(rs.getInt("UserId"));
					getSetUser.setFirstname(rs.getString("FirstName"));
					getSetUser.setLastname(rs.getString("LastName"));
					getSetUser.setUsername(rs.getString("Username"));
					getSetUser.setGender(rs.getString("Gender"));
					getSetUser.setDob(rs.getString("DOB"));
					getSetUser.setEmail(rs.getString("Email"));
					getSetUser.setAddress(rs.getString("Address"));
					getSetUser.setPhone(rs.getString("Phone"));
					getSetUser.setImage(rs.getString("Image"));
					getSetUser.setPassword(e.decrypt(rs.getString("Password")));
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
			return getSetUser;
			
		}
		public void updateUser(GetSetUser user) throws SQLException {
			try {
				DatabaseConnection dc= new DatabaseConnection();
				Connection con = dc.getConnect();
				try { 
					Class.forName("com.mysql.cj.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				String UPDATE_USERS_SQL = "update `user` set FirstName=?,LastName=?,Username=?,Gender=?,DOB=?,Email=?,Address=?,Phone=?,Image=?, Password=? where UserId = ?";
				PreparedStatement statement = con.prepareStatement(UPDATE_USERS_SQL);
				statement.setString(1, user.getFirstname());
				statement.setString(2, user.getLastname());
				statement.setString(3, user.getUsername());
				statement.setString(4, user.getGender());
				statement.setString(5, user.getDob());
				statement.setString(6, user.getEmail());
				statement.setString(7, user.getAddress());
				statement.setString(8, user.getPhone());
				statement.setString(9, user.getImage());
				statement.setString(10, e.encrypt(user.getPassword()));
				statement.setInt(11,user.getUserId());
				statement.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
}
