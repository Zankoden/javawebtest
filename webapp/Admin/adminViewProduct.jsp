<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="com.Model.AdminGetSet"%>
<%@page import="com.Model.ProductDAO"%>
<%@page import="com.Model.AddProductDAO"%>
<%@page import="com.Model.GetSetProduct"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.Model.DatabaseConnection"%>
<%@page import="com.Model.Product"%>
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
    List<GetSetProduct> products = pd.getAllProducts();

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products-Admin</title>
<%@ include file="adminhead.jsp" %>
</head>
<body>
	<div class="sidebar">
	  <a href="../admin-panel">Home</a>
	  <a href="adminUserView.jsp">User</a>
	  <a class="active" href="adminViewProduct.jsp">Product</a>
	  <a href="adminOrderView.jsp">Orders</a>
	</div>

	<div class="content">
		<div class="container">
		<div class="card-header my-3">
			<lable>All products</lable>
				<!-- Trigger/Open The Modal -->
				<button id="myBtn" style="margin-left:75%" class="btn btn-primary"><span class="fa fa-plus" style="margin-right:5px;"></span>Add Product</button>
	
				<!-- The Modal -->
				<div id="myModal" class="modal">
	  			<!-- Modal content -->
				  <div class="modal-content" >
				  	<div class="modal-header">
				        <h4 class="modal-title" >Product Details</h4>
				        <button type="button" class="close" data-dismiss="modal">&times;</button>
			      	</div>
				    <div class="modal-body" style="margin-left:15px">
				    <form action="../Products" method="post" enctype="multipart/form-data">
				      	<label class="profilePic" for="image_input" style="width:200px; height:200px; margin-bottom:15px; margin-left:35px;">
							<img id="image" src="../Images/Windows_10_Default_Profile_Picture.svg.png" >
					   	</label>
					   	<div class="ext" style="margin-top: 5px; margin-bottom:15px; display: flex;">
					    	<label for="image_input" style="color: black;" >Choose Photo <i class="fa-solid fa-cloud-arrow-up" style="margin-left: 5px;"></i></label>
					    	<input type="file" id="image_input" name="image" value="Upload"  required>
					    </div>
							Product Name:<input type="text" name="productName" style="margin-bottom:10px;"><br>  
							Price:<input type="text" name="price" style="margin-bottom:10px;"><br>
							Brand:<input type="text" name="brand" style="margin-bottom:10px;"><br>  
							Description:<input type="text" name="desc" style="margin-bottom:10px;"><br>  
							Stock:<input type="text" name="stock" style="margin-bottom:10px;"><br>
							
							<%
							String query = "select * from category";
							try {
								Class.forName("com.mysql.cj.jdbc.Driver");
								PreparedStatement ps = con.prepareStatement(query);
								ResultSet rs = ps.executeQuery();%>
								<label for="category" style="margin-bottom:10px;">Category</label>
								<select name="categoryId" id="category">
								<%while (rs.next()){%>
									<option value="<%=rs.getString("CategoryId")%>"><%=rs.getString("CategoryName")%></option>
								<%}%>
								</select>		
							<%}catch(Exception e){			
								e.printStackTrace();	
							}		
							%>
						<input type="submit" class="btn btn-primary"value="Add">	  
							
						</form>
					</div>
				  </div>			
				</div>
		</div>
		<table class="table table-light">
				<thead>
					<tr>
						<th scope="col">Image</th>
						<th scope="col">Product Name</th>
						<th scope="col">Price</th>
						<th scope="col">Description</th>
						<th scope="col">Stock</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
				<%
				if (!products.isEmpty()) {
					for(GetSetProduct g : products){%>
						<tr>
						<td>
							<label class="profilePic" >
								<img id="image" src="../Images/<%= g.getImage()%>" style="border:none;">
		   					</label>
	   					</td>
						<td><%= g.getProductName()%></td>
						<td><%= g.getPrice()%></td>
						<td><%= g.getDesc()%></td>
						<td><%= g.getStock()%></td>
						<td>
						<a href="" class="btn btn-primary" style="margin-bottom:5px;">Edit</a>
						<a href="../delete-product?ProductId=<%= g.getProductId()%>" class="btn btn-primary">Delete</a></td>
					</tr><%
					}
				}
					
				%>

					
			</tbody>
			</table>
			
<script type="text/javascript">
			
			document.getElementById("image_input").addEventListener("change", function() {
				 var reader = new FileReader();
				 reader.onload = function(e) {
				 	document.getElementById("image").src = e.target.result;
				 }
				 reader.readAsDataURL(this.files[0]);
			});

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