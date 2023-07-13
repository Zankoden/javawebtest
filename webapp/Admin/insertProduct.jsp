<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.Model.DatabaseConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product insert-Admin</title>
<%@ include file="adminhead.jsp" %>
</head>
<body>
<div class="sidebar">
  <a  href="adminPanel.jsp">Home</a>
  <a class="active" href="adminViewProduct.jsp">Product</a>
  <a href="#contact">Contact</a>
  <a href="#about">About</a>
</div>
<div class="content">
<form action="../Products" method="post" enctype="multipart/form-data">  
	Product Name:<input type="text" name="productName"><br>  
	Price<input type="text" name="price"><br>
	Brand<input type="text" name="brand"><br>  
	Description<input type="text" name="desc"><br>  
	Image<input type="file" name="image" value="Upload"><br>
	Stock<input type="text" name="stock"><br>
	
	<%
	
	DatabaseConnection dc = new DatabaseConnection();
	Connection con = dc.getConnect();
	String query = "select * from category";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		PreparedStatement ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();%>
		<label for="category">Category</label>
		<select name="categoryId" id="category">
		<%while (rs.next()){%>
			<option value="<%=rs.getString("CategoryId")%>"><%=rs.getString("CategoryName")%></option>
		<%}%>
		</select>		
	<%}catch(Exception e){			
		e.printStackTrace();	
	}		
	%>
<input type="submit" value="Add">	  
	
</form>
</div>
</body>
</html>