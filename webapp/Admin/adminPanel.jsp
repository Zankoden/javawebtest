<%@page import="com.Model.AdminGetSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard-Admin</title>
<style>


</style>
<%@include file="adminhead.jsp"%>
</head>

<body>
<div class="sidebar">
  <a class="active" href="../adminHome">Home</a>
  <a href="adminUserView.jsp">User</a>
  <a href="adminViewProduct.jsp">Product</a>
  <a href="adminOrderView.jsp">Orders</a>
</div>

<div class="content" style="  margin-left: 200px; padding: 1px 16px; height: 800px;">
	<div style=" border-radius: 15px;  background-color: #f1f1f1; margin-top: 20px; padding: 5px;">
		<p>DashBoard</p>
	</div>
	<div>
		<img src="../Images/stat.png" style="width: 1200px; margin-top: 40px;">
	</div>
	
	<div class="inside">
		<div>
			<img src="../Images/bar-grpah.png" style="border:2px solid black;">
		</div>
		<div>
			<img src="../Images/line-graph.png">
		</div>
	</div>
	
</div> 

</body>
</html>