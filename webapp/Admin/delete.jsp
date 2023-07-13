<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.Model.DatabaseConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete-Products-Admin</title>
</head>
<body> 
<%
Class.forName("com.mysql.cj.jdbc.Driver");
DatabaseConnection dc = new DatabaseConnection();
Connection con = dc.getConnect();

String productName = request.getParameter("productName");

String query="delete from products where ProductName = ?";

try{
    PreparedStatement ps = con.prepareStatement(query);
    ps.setString(1, productName);
    ps.executeUpdate();
}catch(Exception e){
    e.printStackTrace();
}
%>
</body>
</html>