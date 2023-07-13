<%-- <%@page import="com.Model.AddUserDAO"%>
<%@page import="com.Model.GetSetProduct"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%
	AddUserDAO addUserDAO = (AddUserDAO) request.getSession().getAttribute("product");
%>
</head>
<body>
<h1 style="font-color: Black; margin-bottom: 15px; margin-left:45%">Details</h1>
		<form action="../EditUserServlet?UserId=" method="post" enctype="multipart/form-data"  id="formRes">
			<label class="profilePic" for="image_input" style="width:200px; height:200px; margin-bottom:15px;">
			<img id="image" src="../Images/<%= login.getImage()%>">
		   	</label>
		   	<div class="ext" style="margin-top: 5px; margin-bottom:15px; display: flex;">
		    	<label for="image_input" style="color: black;" >Choose Photo <i class="fa-solid fa-cloud-arrow-up" style="margin-left: 7px;"></i></label>
		    	<input type="file" id="image_input" name="image" value="Upload"  required>
		    </div>
		    <div style="margin-left:38%">
			<div class="sec1">
				<div class="1">
					<label>First Name</label> <input type="text" name="firstname"
						class="textfieldA" value="<%=login.getFirstname() %>">
				</div>
				<div class="2">
					<label>Last Name</label> <input type="text" name="lastname"
						class="textfieldA"  value="<%= login.getLastname()%>">
				</div>
			</div>
			<div class="sec1">
				<div class="1">
					<label>Username</label> <input type="text" name="username"
						class="textfieldA" value="<%= login.getUsername() %>">
				</div>
				<div class="1">
					<label>Email</label> <input type="text" name="email"
						class="textfieldA" value="<%=login.getEmail() %>">
				</div>
			</div>
			<div class="sec1">
				<div class="1">
					<label>Date of Birth</label> <input type="text" name="dob"
						class="textfieldA" value="<%=login.getDob() %>">
				</div>
				<div class="6">
					<label for="textfieldA">Gender</label> <input type="text" name="gender"
						class="textfieldA" value="<%=login.getGender() %>">
				</div>
			</div>
			<div class="sec1">
				<div class="1">
					<label>Phone Number</label> <input type="text" name="phone"
						class="textfieldA" value="<%= login.getPhone() %>">
				</div>
				<div class="1">
					<label>Address</label> <input type="text" name="address"
						class="textfieldA" value="<%= login.getAddress() %>">
				</div>
			</div>
				<label>Password</label> <input type="password" name="password"
						class="textfield" value="<%= login.getPassword()%>" id="password1"
						required>

					<label>Confirm Password</label> <input type="password"
						name="confirmPassword" class="textfield"
						id="confirmPassword1" >
			<div style="margin-top:10px; margin-left:18%"><button type="submit" class="btn btn-primary">Edit</button></div>
			</div>
		</form>
		
<script>
document.getElementById("image_input").addEventListener("change", function() {
	 var reader = new FileReader();
	 reader.onload = function(e) {
	 	document.getElementById("image").src = e.target.result;
	 }
	 reader.readAsDataURL(this.files[0]);
	});

</script>
</body>
</html> --%>