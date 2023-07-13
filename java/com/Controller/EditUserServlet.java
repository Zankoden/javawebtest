package com.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
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
import com.Model.GetSetUser;


@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
maxFileSize = 1024 * 1024 * 1000, // 1 GB
maxRequestSize = 1024 * 1024 * 1000)   	// 1 GB

public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Encryption e = new Encryption();
		 GetSetUser login = (GetSetUser) request.getSession().getAttribute("login");
		 
		try(PrintWriter out = response.getWriter()){
			int id = login.getUserId();
			String fname= request.getParameter("firstname");
			String lname= request.getParameter("lastname");
			String uname= request.getParameter("username");
			String email= request.getParameter("email");
			String dob= request.getParameter("dob");
			String gender = request.getParameter("gender");
			String phone = request.getParameter("phone");
			String address= request.getParameter("address");
			String password=request.getParameter("password");

			Part filePart = request.getPart("image");
			String fileName = filePart.getSubmittedFileName();		
	        InputStream is = filePart.getInputStream();
	        Files.copy(is, Paths.get("../eclipse-workspace/Saturn/src/main/webapp/Images/"+fileName), StandardCopyOption.REPLACE_EXISTING);

			GetSetUser user = new GetSetUser();
			
			user.setUserId(id);
			user.setFirstname(fname);
	        user.setLastname(lname);
	        user.setUsername(uname);
	        user.setGender(gender);
	        user.setDob(dob);
	        user.setPhone(phone);
	        user.setEmail(email);
	        user.setAddress(address);
	        user.setImage(fileName);
	        user.setPassword(e.encrypt(password));
	        
	        AddUserDAO addUserDAO = new AddUserDAO();
	        addUserDAO.updateUser(user);

	        if(addUserDAO != null) {
				out.println("<script type=\"text/javascript\">"); 
				out.println("alert('Details changed successfully');");
				out.println("location='View/home.jsp';");
				out.println("</script>"); 
	        }
		}catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	

}
