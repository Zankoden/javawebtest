package com.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

import com.Model.AdminGetSet;

@WebServlet("/admin-panel")
public class adminPanelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()){
				
			AdminGetSet login = (AdminGetSet) request.getSession().getAttribute("login");
			if(login != null) {
				response.sendRedirect("Admin/adminPanel.jsp");
			}else{
				response.sendRedirect("Admin/adminLogin.jsp");
			}
			
		}
	}


}
