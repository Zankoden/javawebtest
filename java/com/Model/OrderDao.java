package com.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
	private ResultSet rs;
	
public boolean insertOrder(Order model) {
	DatabaseConnection dc= new DatabaseConnection();
	Connection con = dc.getConnect();
	try { 
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	boolean rs = false;
	
	try {
		String query = "insert into orders(Quantity,TotalPrice,OrderDate,UserId,ProductId) values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, model.getQuantity());
		ps.setInt(2, model.getTotalPrice());
		ps.setString(3, model.getOrderDate());
		ps.setInt(4, model.getUid());
		ps.setInt(5, model.getProductId());		
		ps.executeUpdate();
		rs = true;
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	return rs;
}
public List<Order> userOrders(int uid){
	DatabaseConnection dc= new DatabaseConnection();
	Connection con = dc.getConnect();
	try { 
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	List<Order> list = new ArrayList<>();
	try {
		
		String query="select * from orders where UserId=? order by orders.OrderId desc";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, uid);		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Order order = new Order();
			ProductDAO addProductDAO = new ProductDAO();
			int productId = rs.getInt("ProductId");
			
			GetSetProduct product= addProductDAO.getSingleProduct(productId);
			order.setOrderID(rs.getInt("OrderID"));
			order.setUid(rs.getInt("UserId"));
			order.setProductId(productId);
			order.setProductName(product.getProductName());
			order.setCategoryId(product.getCategoryId());
			order.setQuantity(rs.getInt("Quantity"));
			order.setPrice(product.getPrice()*rs.getInt("Quantity"));
			order.setOrderDate(rs.getString("OrderDate"));
			list.add(order);
			
		}
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	return list;
	
	
}

public void cancelOrder(int orderID) {
	try {
		DatabaseConnection dc= new DatabaseConnection();
		Connection con = dc.getConnect();
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		String query = "delete from orders where OrderID=?";
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1, orderID);
		ps.execute();
		
	}catch (Exception e) {
		e.printStackTrace();
	}
}

}
