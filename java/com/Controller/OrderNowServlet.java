package com.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.Model.Cart;
import com.Model.DatabaseConnection;
import com.Model.GetSetUser;
import com.Model.Order;
import com.Model.OrderDao;

@WebServlet("/order-now")
public class OrderNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseConnection dc= new DatabaseConnection();
		Connection con = dc.getConnect();
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try(PrintWriter out = response.getWriter()){
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			
			Date orderDate = new Date();
			
			GetSetUser login = (GetSetUser) request.getSession().getAttribute("login");
			if(login != null) {
				
				String ProductId = request.getParameter("ProductId");
				int price = Integer.parseInt(request.getParameter("price"));
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				if(quantity <=0) {
					quantity = 1;
				}
				
				Order orderModel = new Order();
				orderModel.setProductId(Integer.parseInt(ProductId));
				orderModel.setTotalPrice(price);
				orderModel.setUid(login.getUserId());
				orderModel.setQuantity(quantity);
				orderModel.setOrderDate(formatter.format(orderDate));
				
				OrderDao orderDao = new OrderDao();
				boolean rs = orderDao.insertOrder(orderModel);
				
				
				if(rs) {
					ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
					if(cart_list != null) {
						for(Cart c: cart_list) {
							if(c.getProductId() == Integer.parseInt(ProductId)) {
								cart_list.remove(cart_list.indexOf(c));
								break;
							}
						}		
					}
					response.sendRedirect("View/AddToCart.jsp");
				}else {
					out.println("<script type=\"text/javascript\">"); 
					out.println("alert('Order Failed');");
					out.println("location='View/AddToCart.jsp';");
					out.println("</script>");
				}
			}else {
				response.sendRedirect("View/login.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
