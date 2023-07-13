<%@page import="java.sql.Connection"%>
<%@page import="java.util.*"%>
<%@page import="com.Model.*"%>
<%
AddUserDAO signup =(AddUserDAO) request.getSession().getAttribute("signup");
if(signup != null){
	request.setAttribute("signup", signup);
}

GetSetUser login = (GetSetUser) request.getSession().getAttribute("login");
if (login != null) {
	request.setAttribute("login", login);
}

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
List<Cart> cartProduct = null;
if(cart_list != null){
	ProductDAO pDao = new ProductDAO();
	
	DatabaseConnection dc = new DatabaseConnection();
	Connection con = dc.getConnect();
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	
	cartProduct = pDao.getCartProducts(cart_list);
	int total= pDao.getTotalCartPrice(cart_list);
	request.setAttribute("cart_list", cart_list);
	request.setAttribute("total", total);
}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add To Cart</title>
<%@include file="head.jsp"%>
<style type="text/css">
.table tbody td {
	vertical-align: middle;
}

.btn-incre, .btn-decre {
	margin: 3px;
	box-shadow: none;
	font-size: 25px;
}
</style>
</head>
<body>
	
<nav class="navbar navbar-expand-lg navbar-light bg-light">
<div class="container">
  <a class="navbar-brand" href="home.jsp"><h1>Saturn</h1></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
	
   <ul class="navbar-nav ml-auto"  style="margin-left:30px;">
      <li class="nav-item ">
        <a class="nav-link" href="home.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="Blog.jsp">Blog</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="contact.jsp">Contact Us</a>
      </li>
      </ul>
     
     <ul class="navbar-nav ml-auto">
      <li>
			<form class="form-inline my-2 my-lg-0" method="post" action="search.jsp">
				<input class="form-control mr-sm-2" type="search"
					name="searchKeyword" placeholder="Search by Product name/Price/Brand " aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
	  </li>
	  </ul>

	 
	 
	  <ul class="navbar-nav ml-auto">
      	<%if(signup != null){ %>
		<%if(login != null){ %>
				   <li class="nav-item">
			        	<a class="nav-link active" href="AddToCart.jsp"> Cart <span class="badge badge-danger">${cart_list.size()}</span></a>
			       </li>
				<li class="nav-item"><a class="nav-link" id="myBtn">
					<!-- Trigger/Open The Modal -->
					<img id="image"  src="../Images/<%= login.getImage()%>" style="width:30px; height:30px;"><%= login.getFirstname()%> <%= login.getLastname()%></a>
				</li>
				<li class="nav-item"><a class="nav-link" href="order.jsp">Orders</a></li>
				<li class="nav-item"><a class="nav-link" href="../logout"><span class="fa fa-user-plus"></span>Logout</a></li>
		<%}else{%>
		<li class="nav-item"><a class="nav-link" href="login.jsp">Login</a></li>
		<%}}else{ %>
		<li class="nav-item"><a class="nav-link" href="signup.jsp">Sign Up</a></li>
		<%}%>
    </ul>	</div>
  </div>
</nav>
<section>
	<div class="container">
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Image</th>
					<th scope="col">Product Name</th>
					<th scope="col">Total Price </th>
					<th scope="col">Buy Now</th>					
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
			<%
			if(cart_list != null){
				for(Cart c:cartProduct){%>
					<tr>
					<td><img id="image"  src="../Images/<%= c.getImage()%>" style="width:80px; height:80px;"></td>
					<td><%= c.getProductName() %></td>
					<td><%= c.getPrice()%></td>		
					<td>
						<form action="../order-now" method="post" class="form-inline">
							<input type="hidden" name="ProductId" value="<%= c.getProductId()%>" class="form-input">
							<input type="hidden" name="price" value="<%= c.getPrice()%>" class="form-input">
							<div class="form-group d-flex justify-content-between w-50">
								<a class="bth btm-sm btn-decre" href="../quantity-inc-dec?action=dec&ProductId=<%= c.getProductId()%>"><i class="fas fa-minus-square" style="color:blue"></i>
								</a> <input type="text"	name="quantity" class="form-control w-50" value="<%= c.getQuantity() %>" readonly>
								<a class="bth btm-sm btn-incre" href="../quantity-inc-dec?action=inc&ProductId=<%= c.getProductId()%>"><i class="fas fa-plus-square" style="color:blue"></i></a>
							</div>
							<button type="submit" class="btn btn-primary btn-sm">Buy</button>
						</form>
					</td>
								
					<td><a class="btn btn-sm btn-danger" href="../remove-from-cart?ProductId=<%= c.getProductId()%>">Remove</a></td>
				</tr>
				<%}
			}
			
			%>
				
			</tbody>
		</table>
		<div class="d-flex py-3">
			<h3>Total Price:$ ${ (total>0)?total:0 }</h3>
		</div>
	</div>
	


	<%if (login != null){  %>
	<!-- The Modal -->
	<div id="myModal" class="modal">
		<!-- Modal content -->
		<div class="modal-content">			
			<div class="modal-header">
				<h4>Details</h4>
				<span class="close" style="margin-left:70%;">&times;</span>			
			</div>
			<form >
				<div id="detail" class="a" style="margin-top: 10px;">
						<img id="image" src="../Images/<%= login.getImage()%>" style="width:200px; height:200px; margin-left:20%">
						
						<div class="profile-detail">
						<table class="table table-light" style="margin-top:10px;">
							<tbody>
								<tr>
									<th>Name</th>
									<td><%= login.getFirstname() %> <%= login.getLastname() %></td>						
								</tr>
								<tr>
									<th>Gender</th>
									<td><%= login.getGender() %></td>						
								</tr>
								<tr>
									<th>Date of Birth</th>
									<td><%= login.getDob() %></td>						
								</tr>
								<tr>
									<th>Address</th>
									<td> <%= login.getAddress() %> </td>						
								</tr>	
								<tr>
									<th>Email</th>
									<td><%= login.getEmail() %></td>						
								</tr>										
							</tbody>						
						</table>
					</div>
					
					<div id="profile-edit" style="display:none">
						<h1>Edit</h1>			
					</div>					
					
					<a href="edit.jsp?UserId=<%= login.getUserId() %>" class="btn btn-primary" style="margin-left:40%">Edit</a>
			   	</div>		    
			</form>
		</div>
	</div>
	<%}%>
</section>	

	<script type="text/javascript">
	

	// Get the modal
	var modal = document.getElementById("myModal");

	// Get the button that opens the modal
	var btn = document.getElementById("myBtn");

	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];

	// When the user clicks on the button, open the modal
	btn.onclick = function() {
	  modal.style.display = "block";
	}

	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
	  modal.style.display = "none";
	}

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	  if (event.target == modal) {
	    modal.style.display = "none";
	  }
	}	
	
     </script>
      
</body>
</html>