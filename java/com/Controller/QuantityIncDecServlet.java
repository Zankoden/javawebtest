package com.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.Model.Cart;

@WebServlet("/quantity-inc-dec")
public class QuantityIncDecServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter();){
			String action = request.getParameter("action");
			int ProductId= Integer.parseInt(request.getParameter("ProductId"));
			
			ArrayList<Cart> cart_list=(ArrayList<Cart>)request.getSession().getAttribute("cart-list");
			
			if(action != null & ProductId >= 1) {
				if(action.equals("inc")) {
					for(Cart c:cart_list) {
						if(c.getProductId() == ProductId) {
							int quantity = c.getQuantity();
							quantity ++;
							c.setQuantity(quantity);
							response.sendRedirect("View/AddToCart.jsp");
						}
					}
				}
				if(action.equals("dec")) {
					for(Cart c:cart_list) {
						if(c.getProductId() == ProductId && c.getQuantity() >1) {
							int quantity = c.getQuantity();
							quantity --;
							c.setQuantity(quantity);
							break;
						}
					}
					response.sendRedirect("View/AddToCart.jsp");
				}
				
				
			}else {
				response.sendRedirect("View/AddToCart.jsp");
			}
		}
	}

	
}
