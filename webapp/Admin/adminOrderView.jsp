<%@page import="com.Model.Order"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.Model.DatabaseConnection"%>
<%@page import="com.Model.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%
    ProductDAO pd = new ProductDAO();
    DatabaseConnection dc = new DatabaseConnection();
    Connection con = dc.getConnect();
    try {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
    	e.printStackTrace();
    }
    List<Order> products = pd.getAllOrder();

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders-Admin</title>
<%@ include file="adminhead.jsp" %>
</head>
<body>
<div class="sidebar">
  <a  href="../admin-panel">Home</a>
  <a href="adminUserView.jsp">User</a>
  <a href="adminViewProduct.jsp">Product</a>
  <a class="active" href="adminOrderView.jsp">Orders</a></div>
<div class="content">
	<div class="container">
	<div class="card-header my-3">
		<lable>All Orders</lable>
	</div>
	<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Order Date</th>
					<th scope="col">Order Id</th>
					<th scope="col">User Id</th>
					<th scope="col">Product Id</th>
					<th scope="col">Quantity </th>
					<th scope = "col">Total Cost </th>
				</tr>
			</thead>
			<tbody>
			<%
			if (!products.isEmpty()) {
				for (Order g : products) {
			%>
			<tr>
				<td><%= g.getOrderDate()%></td>
				<td><%= g.getOrderID()%></td>
				<td><%= g.getUid()%></td>
				<td><%= g.getProductId()%></td>
				<td><%= g.getQuantity()%></td>
				<td><%= g.getTotalPrice()%></td>
			</tr>	
			<%}
			}%>
		</tbody>
		</table>
		</div>
</div>	
</body>
</html>