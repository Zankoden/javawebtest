package com.Model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AddProductDAO {
	
	public void insertProduct(Product product) {
		DatabaseConnection dc= new DatabaseConnection();
		Connection con = dc.getConnect();
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String query  = "Insert into products(ProductName,ProductPrice,ProductDesc,Brand,ProductImage,ProductStock,CategoryId) values(?,?,?,?,?,?,?)";
        try{
            PreparedStatement ps = con.prepareStatement(query);       
            ps.setString(1, product.getProductName());
            ps.setInt(2, product.getPrice());
            ps.setString(3, product.getDesc());
            ps.setString(4, product.getBrand());
            ps.setString(5, product.getImage());
            ps.setInt(6, product.getStock());
            ps.setInt(7, product.getCategoryId());
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
        
	}

	
	
}
