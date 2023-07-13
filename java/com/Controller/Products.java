package com.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import com.Model.AddProductDAO;
import com.Model.Product;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
maxFileSize = 1024 * 1024 * 1000, // 1 GB
maxRequestSize = 1024 * 1024 * 1000)   	// 1 GB

public class Products extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   public Products() {
	        super();
	    }
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
		
		String Pname = request.getParameter("productName");
		String price = request.getParameter("price");
		String desc = request.getParameter("desc");
		String brand = request.getParameter("brand");
		String stock = request.getParameter("stock");
		String Category = request.getParameter("categoryId");
		
		Part filePart = request.getPart("image");
		String fileName = filePart.getSubmittedFileName();		
        InputStream is = filePart.getInputStream();
        Files.copy(is, Paths.get("../eclipse-workspace/Saturn/src/main/webapp/Images/"+fileName), StandardCopyOption.REPLACE_EXISTING);
		
		Product product = new Product();
		
		product.setProductName(Pname);
		product.setPrice(Integer.parseInt(price));
		product.setDesc(desc);
		product.setBrand(brand);
		product.setImage(fileName);
		product.setStock(Integer.parseInt(stock));
		product.setCategoryId(Integer.parseInt(Category));
		
		AddProductDAO pDao = new AddProductDAO();
		pDao.insertProduct(product);
		if(pDao != null) {
		response.sendRedirect("Admin/adminViewProduct.jsp");
			request.getSession().setAttribute("product", pDao);
		}
	}
}