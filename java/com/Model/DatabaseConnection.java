package com.Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.Model.DatabaseConnection;

public class DatabaseConnection {
	public Connection getConnect(){
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DatabaseCredentials.getDbname(),DatabaseCredentials.getUser(),DatabaseCredentials.getPassword());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}

}
