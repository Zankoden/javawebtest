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

@WebServlet("/remove-from-cart")
public class RemoveFromCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 	response.setContentType("text/html;charset=UTF-8");
	try(PrintWriter out = response.getWriter()){
		
		String ProductId = request.getParameter("ProductId");
		if(ProductId != null) {
			ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
			if(cart_list != null) {
				for(Cart c: cart_list) {
					if(c.getProductId() == Integer.parseInt(ProductId)) {
						cart_list.remove(cart_list.indexOf(c));
						break;
					}
				}
				response.sendRedirect("View/AddToCart.jsp");				
			}
			
		}else {
			response.sendRedirect("View/AddToCart.jsp");
		}
	}catch (Exception e) {
		e.printStackTrace();
	}
 	}
 	

}
