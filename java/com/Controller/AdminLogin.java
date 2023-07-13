package com.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import com.Model.AdminDAO;
import com.Model.AdminGetSet;
import com.Model.DatabaseConnection;


public class AdminLogin extends HttpServlet {
private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()) {
			String Username = request.getParameter("username");
			String Password = request.getParameter("password");
			
			DatabaseConnection dc= new DatabaseConnection();
			Connection con = dc.getConnect();
			try { 
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			AdminDAO adminDAO = new AdminDAO();
			AdminGetSet adminGetSet = adminDAO.userLogin(Username, Password);
			if(adminGetSet != null) {
				request.getSession().setAttribute("login", adminGetSet);// setting login session for admin panel
				response.sendRedirect("Admin/adminPanel.jsp");
				
			}else{
				out.println("<script type=\"text/javascript\">"); 
				out.println("alert('Username or password incorrect');");
				out.println("location='Admin/adminLogin.jsp';");
				out.println("</script>");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
