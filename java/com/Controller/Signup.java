package com.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.Model.AddUserDAO;
import com.Model.Encryption;
import com.Model.User;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
maxFileSize = 1024 * 1024 * 1000, // 1 GB
maxRequestSize = 1024 * 1024 * 1000)   	// 1 GB

public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		
		try(PrintWriter out = response.getWriter()) {
		Encryption aes = new Encryption();		
		
		String Fname = request.getParameter("firstname");
		String Lname = request.getParameter("lastname");
		String UName = request.getParameter("username");
		String Gender = request.getParameter("gender");
		String Dob = request.getParameter("dob");
		String Phone = request.getParameter("phone");
		String Email = request.getParameter("email");
		String Address = request.getParameter("address");
		String Password = request.getParameter("password");
		
		Part filePart = request.getPart("image");
		String fileName = filePart.getSubmittedFileName();		
        InputStream is = filePart.getInputStream();
        Files.copy(is, Paths.get("../eclipse-workspace/Saturn/src/main/webapp/Images/"+fileName), StandardCopyOption.REPLACE_EXISTING);
        
        User user = new User();
        
        user.setFirstname(Fname);
        user.setLastname(Lname);
        user.setUsername(UName);
        user.setGender(Gender);
        user.setDob(Dob);
        user.setPhone(Phone);
        user.setEmail(Email);
        user.setAddress(Address);
        user.setImage(fileName);
        user.setPassword(aes.encrypt(Password));
        
        AddUserDAO uDAO = new AddUserDAO();
        uDAO.insertUser(user);
			if (uDAO != null) {
				request.getSession().setAttribute("signup", uDAO);
				response.sendRedirect("View/home.jsp");
	
			} 
		}catch (Exception e) {
			e.printStackTrace();
		}
        
        
	}

}
