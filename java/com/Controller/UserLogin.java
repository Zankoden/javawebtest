package com.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import com.Model.AddUserDAO;
import com.Model.DatabaseConnection;
import com.Model.Encryption;
import com.Model.GetSetUser;

public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Encryption e = new Encryption();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()) {
			String Username = request.getParameter("username");
			String Password = e.encrypt(request.getParameter("password"));
			
			DatabaseConnection dc= new DatabaseConnection();
			Connection con = dc.getConnect();
			try { 
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			AddUserDAO addUserDAO = new AddUserDAO();
			GetSetUser getSetUser = addUserDAO.userLogin(Username, Password);
			if(getSetUser != null) {
				request.getSession().setAttribute("login", getSetUser);
				response.sendRedirect("View/home.jsp");
				
			}else{				
				out.println("<script type=\"text/javascript\">"); 
				out.println("alert('Username or password incorrect');");
				out.println("location='View/login.jsp';");
				out.println("</script>"); 
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
