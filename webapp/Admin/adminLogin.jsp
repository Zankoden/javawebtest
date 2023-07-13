<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login-Admin</title>
<%@include file="adminhead.jsp" %>
</head>
<body>
<body>
		<div class="maindivLogin">
			<h style="font-size: 25px;color: Black;" ><b>Login In</b></h>
			<form action="../AdminLogin" method="post">
				<div class="a" style="margin-top: 30px;">
			    	<label>Username</label>
			        <input type="text" name="username" class="textfieldL" placeholder="Enter your username">
			    </div> 
			    <div class="a">
			    	<label>Password</label>
			    	<input type="password" name="password" class="textfieldL" placeholder="Enter your password">
			   	</div>
			   	<div class="a">
			   		<button type="submit">Login</button>
			   	</div>
			   	<div class="a">
			   		<label style="align:center; color:red">*Note: username=admin & password=admin*</label>
			   	</div>		    
			</form>
		</div>

</body>
</html>