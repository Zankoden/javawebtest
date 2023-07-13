<%@page import="java.sql.Connection"%>
<%@page import="com.Model.DatabaseConnection"%>
<%@page import="com.Model.AddUserDAO"%>
<%@page import="com.Model.GetSetUser"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
DatabaseConnection dc = new DatabaseConnection();
Connection con = dc.getConnect();
try {
	Class.forName("com.mysql.cj.jdbc.Driver");
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}

GetSetUser login = (GetSetUser) request.getSession().getAttribute("login");
if (login != null) {
	request.setAttribute("login", login);
}else{
	response.sendRedirect("login.jsp");
}
AddUserDAO au = new AddUserDAO();

AddUserDAO signup =(AddUserDAO) request.getSession().getAttribute("signup");
if(signup != null){
	request.setAttribute("signup", signup);
}

%>
<!DOCTYPE html>
<html>
	<head>
		<style>
			body{
				font-family: 'Montserrat', sans-serif;
				font-family: 'Prompt', sans-serif;
			}

			#blog .description{
				line-height: 1.5;
				font-size: 19px;
				margin-left: 20px;
				margin-right: 20px;
			}

			#ball{
				display: none;
			}

			#cat{
				padding: 10px;
				font-size: 15px;
				margin-bottom: 30px;
			}
		</style>
		<%@include file="head.jsp"%>
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
       <li class="nav-item active">
        <a class="nav-link" href="Blog.jsp">Blog</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="contact.jsp">Contact</a>
      </li>
      </ul>
     
     <ul class="navbar-nav ml-auto">
      <li>
			<form class="form-inline my-2 my-lg-0" method="post" action="search.jsp">
				<input class="form-control mr-sm-2" type="search"
					name="searchKeyword" placeholder="Search by Product name/Price/Brand" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			</form>
	  </li>
	  </ul>
	 <ul class="navbar-nav ml-auto"> 
		<%if(signup != null){
			
			%>      	
			<%if(login != null){ %>
					   <li class="nav-item">
				        	<a class="nav-link" href="AddToCart.jsp"> Cart <span class="badge badge-danger">${cart_list.size()}</span></a>
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
		 <li><a class="nav-link" href="../admin-panel" style="text-color:blue;">Admin</a></li>
		<li class="nav-item"><a class="nav-link" href="signup.jsp">Sign Up</a></li>
		<%}%>
    </ul>
	</div>
  </div>
</nav>
		<section id="blog">
			<div class="container">
				<div class="description">
					<h1 style="text-align: center; font-size: 30px; margin-top: 20px;">Affect of technology in our daily life.</h1>
						<p style="font-size: 14px; text-align: left;"><i class="fa-solid fa-clock"></i> May 07,2023</p>
						<p style="text-align: justify;">
						Over the last years, our society has changed a lot by becoming more technological. Now, almost every population 
						in the world has access to the technologies. Technology affects almost every aspect of life in this modern era 
						and has changed it in countless ways. Technology has become more and more a part of our daily lives, to that point 
						where it has taken over our lives. It has changed the way we do our everyday task made our lives are far more convenient
						and easier.<br/><br/>
						<img src="../Images/Information-Technology-and-Cloud-Computing-1024x870-e1422276882760-1.jpg" width="100%" height="400px"><br/><br/>
						Generally, technology refers to the use of scientific knowledge to create or design tools or equipment which are used by
						 us in order to make our life easier. Some examples of technology are; television, internet, cell phones, computer, solar panel,
						  batteries, mechanical tools, vehicles etc.<span id="apple">...</span><span id="ball"> These technologies are found in various 
						  shape and size and made our lives much easier and more convenient. Being said that it not only has its pros it has its cons as well. <br/><br/>
						<img src="../Images/technology-importance.jpg" width="100%" height="500px"><br/><br/>
						While talking about the pros of technology in our lives we cannot miss internet. Internet helps us to connect with people even when 
						they are far from us. Internet also provide us with many information that we need. Internet has played very important role in time of 
						the pandemic. We took our academic year learning through online which was only possible with the help of internet. Through the technology 
						our education has changed a lot. Student all around globe can now learn without going to class physically. Thanks to the technology like 
						washing machine, dishwasher, refrigerator which made our day-to-day activities easier. Another main advantage of technologies are means of 
						transportation. It has made so much easier for us to travel from here and there. Not only for moving people technologies are used in many 
						industrial works for moving equipment and instrument. <br/><br/>
						<img src="../Images/Importance-of-Technology-in-Modern-Invention.jpg" width="100%" height="500px"><br/><br/>
						Everything has its positive as well as negative effect. Due to advancement in technology, we are mostly dependent on technologies for 
						day-to-day activities. We use to wash our clothes by ourselves, now we use washing machine for washing clothes. We used to wash dishes
						 by ourselves now we use dishwasher to wash the dishes. We are becoming lazy day by day compared to our parents and ancestors. 
						 People now a days are addicted to use technology. We see more technology addiction than the drugs addiction now a days.<br/>							Due to the advancement in technologies, our lives have been comfortable. It is clear that the positive effect of technologies outweighs the negative effect by far. We just need to be smart and make the best out of the what is offered, while minimizing the negative impact as much as possible.</span><br/>
						</p>
						<button onclick="dog()" id="cat" style="margin-left:90%;" class="btn btn-primary">Read more</button>
				</div>		
			</div>
		</section>

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
					
					<a href="" class="btn btn-primary" style="margin-left:40%">Edit</a>
			   	</div>		    
			</form>
		</div>
	</div>
	<%}%>
		
		
		<%@ include file="footer.jsp" %>
		<script>
		
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