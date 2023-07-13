package com.Controller;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.Model.ProductDAO;
import com.Model.OrderDao;

@WebServlet("/delete-product")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter() ){
			String ProductId = request.getParameter("ProductId");
			if(ProductId != null) {
				
				ProductDAO addProductDAO = new ProductDAO();
				addProductDAO.DeleteProduct(Integer.parseInt(ProductId));
			}
			response.sendRedirect("Admin/adminPanel.jsp");
			}catch (Exception e) {
				e.printStackTrace();
			}		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
