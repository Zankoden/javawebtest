<%@page import="com.Model.GetSetUser"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.Model.DatabaseConnection"%>
<%@page import="com.Model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%
    UserDAO u = new UserDAO();
    DatabaseConnection dc = new DatabaseConnection();
    Connection con = dc.getConnect();
    try {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    } catch (ClassNotFoundException e) {
    	e.printStackTrace();
    }
    List<GetSetUser> user = u.getAllUser();

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users-Admin</title>
<%@ include file="adminhead.jsp" %>
</head>
<body>
<div class="sidebar">
  <a href="../admin-panel">Home</a>
  <a class="active" href="adminUserView.jsp">User</a>
  <a href="adminViewProduct.jsp">Product</a>
  <a href="adminOrderView.jsp">Orders</a>
</div>
<div class="content">
	<div class="container">
	<div class="card-header my-3">
		<lable>All User</lable>
	</div>
	<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Profile</th>
					<th scope="col">User Id</th>
					<th scope="col">Full Name</th>
					<th scope="col">User name</th>
					<th scope="col">Gender</th>
					<th scope="col">DOB</th>
					<th scope="col">Email</th>
					<th scope="col">Address</th>
					<th scope="col">Phone</th>

				</tr>
			</thead>
			<tbody>
			<%
			if (!user.isEmpty()) {
				for (GetSetUser g : user) {
			%>
			<tr>
				<td>
					<label class="profilePic" >
					<img id="image" src="../Images/<%= g.getImage()%>" style="border:none;">
		   			</label>
	   			</td>
				<td><%= g.getUserId()%></td>
				<td><%= g.getFirstname()%> <%=g.getLastname() %></td>
				<td><%= g.getUsername()%></td>
				<td><%= g.getGender()%></td>
				<td><%= g.getDob()%></td>
				<td><%= g.getEmail()%></td>
				<td><%= g.getAddress()%></td>
				<td><%= g.getPhone()%></td>
				<td>
			</tr>	
			<%}
			}%>
		</tbody>
		</table>
		</div>
</div>	
</body>
</html>