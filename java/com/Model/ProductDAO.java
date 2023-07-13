package com.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {	
	
	public List<GetSetProduct> getAllProducts(){
		List<GetSetProduct> products = new ArrayList<>();
		
		DatabaseConnection dc= new DatabaseConnection();
		Connection con = dc.getConnect();
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
		String query = "select * from products";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			GetSetProduct row = new GetSetProduct();
			row.setProductId(Integer.parseInt(rs.getString("ProductId")));
			row.setProductName(rs.getString("ProductName"));
			row.setPrice(rs.getInt("ProductPrice"));
			row.setDesc(rs.getString("ProductDesc"));
			row.setImage(rs.getString("ProductImage"));
			row.setStock(rs.getInt("ProductStock"));
			row.setCategoryId(rs.getInt("CategoryId"));	
			
			products.add(row);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return products;
		
	}
	
	
	public List<Order> getAllOrder(){
		List<Order> order = new ArrayList<>();
		
		DatabaseConnection dc= new DatabaseConnection();
		Connection con = dc.getConnect();
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
		String query = "select * from orders";
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Order row = new Order();
			row.setOrderID(Integer.parseInt(rs.getString("OrderId")));
			row.setUid(Integer.parseInt(rs.getString("UserId")));
			row.setProductId(Integer.parseInt(rs.getString("ProductId")));
			row.setQuantity(Integer.parseInt(rs.getString("Quantity")));
			row.setTotalPrice(Integer.parseInt(rs.getString("TotalPrice")));
			row.setOrderDate(rs.getString("OrderDate"));
			order.add(row);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return order;
		
	}
	
	public List<Cart> getCartProducts(ArrayList<Cart> cartList){
		DatabaseConnection dc= new DatabaseConnection();
		Connection con = dc.getConnect();
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		List<Cart> products = new ArrayList<Cart>();
		
		try {
			if(cartList.size()>0) {
				for(Cart item: cartList) {
					String query = "select * from products where ProductId=?";
					PreparedStatement ps = con.prepareStatement(query);
					ps.setInt(1, item.getProductId());
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						Cart row = new Cart();
						row.setProductId(rs.getInt("ProductId"));
						row.setProductName(rs.getString("ProductName"));
						row.setCategoryId(rs.getInt("CategoryId"));
						row.setPrice(rs.getInt("ProductPrice")*item.getQuantity());
						row.setQuantity(item.getQuantity());
						row.setImage(rs.getString("ProductImage"));
						products.add(row);
						
					}
				}
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return products;
	}
	
	public GetSetProduct getSingleProduct(int ProductId) {
		GetSetProduct row = null;
		
		try {
			DatabaseConnection dc= new DatabaseConnection();
			Connection con = dc.getConnect();
			try { 
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			String query = "select * from products where ProductId=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, ProductId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				row = new GetSetProduct();
				row.setProductId(rs.getInt("ProductId"));
				row.setProductName(rs.getString("ProductName"));
				row.setCategoryId(rs.getInt("CategoryId"));
				row.setPrice(rs.getInt("ProductPrice"));
				row.setImage(rs.getString("ProductImage"));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return row;
		
	}
	
	public int getTotalCartPrice(ArrayList<Cart> cartList) {
		int sum =0;
		
		DatabaseConnection dc= new DatabaseConnection();
		Connection con = dc.getConnect();
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			if(cartList.size()>0) {
				for(Cart item: cartList) {
					String query = "select ProductPrice from products where ProductId=?";
					PreparedStatement ps =con.prepareStatement(query);
					ps.setInt(1,item.getProductId());
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						sum += rs.getInt("ProductPrice")*item.getQuantity();
						
					}
					
				}
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return sum;
		
	}
	public void DeleteProduct(int ProductId) {
		try {
			DatabaseConnection dc= new DatabaseConnection();
			Connection con = dc.getConnect();
			try { 
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			String query = "delete from products where ProductID=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, ProductId);
			ps.execute();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
