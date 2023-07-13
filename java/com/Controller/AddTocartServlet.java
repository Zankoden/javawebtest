package com.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.Model.AddUserDAO;
import com.Model.Cart;
import com.Model.GetSetUser;
import com.Model.User;

@WebServlet("/addToCart")
public class AddTocartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter() ){
			ArrayList<Cart> cartList = new ArrayList<>(); // creating cartlist to hold Cart element
			
			int id =Integer.parseInt(request.getParameter("ProductId"));
			Cart cm = new Cart();
			cm.setProductId(id);
			cm.setQuantity(1);
			
			HttpSession session = request.getSession();
			ArrayList<Cart> cart_list= (ArrayList<Cart>) session.getAttribute("cart-list"); // getting cart-list session and storing in cart_list
			GetSetUser login = (GetSetUser) request.getSession().getAttribute("login");// getting login session and storing in login 
			AddUserDAO signup =(AddUserDAO) request.getSession().getAttribute("signup");// getting signup session attrribute and storing in signup
			if(signup != null) {
			if(login != null) {// checking session login is null or not
				if(cart_list == null) {
					cartList.add(cm);
					session.setAttribute("cart-list", cartList);
					response.sendRedirect("View/home.jsp");
				}else{
					cartList = cart_list;
					boolean exist =false;
					
					
					for(Cart c:cartList) {
						if(c.getProductId() == id) {
							exist = true;
							out.println("<script type=\"text/javascript\">"); 
							out.println("alert('Item already in cart');");
							out.println("location='View/AddToCart.jsp';");
							out.println("</script>");
						}
					}
					if(!exist) {
						cartList.add(cm);
						response.sendRedirect("View/home.jsp");
					}
					
				}
			}else {
				response.sendRedirect("View/login.jsp");
			}
			}else {
				response.sendRedirect("View/signup.jsp");
			}
		}
	}

}
