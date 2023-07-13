package com.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.Model.OrderDao;

@WebServlet("/cancel-order")
public class CancelOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter() ){
			
			String orderID = request.getParameter("OrderID");
			if(orderID != null) {
				OrderDao orderDao = new OrderDao();
				orderDao.cancelOrder(Integer.parseInt(orderID));
			}
			response.sendRedirect("View/order.jsp");
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
