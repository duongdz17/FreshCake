package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cart;
@WebServlet(urlPatterns = {"/updown"})
public class UpdownQuantityCartController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Cart> carts = new ArrayList<Cart>();
		resp.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = resp.getWriter();){
			String action = req.getParameter("action");
			int id = Integer.parseInt(req.getParameter("id"));
			ArrayList<Cart> cart_list = (ArrayList<Cart>)req.getSession().getAttribute("carts");
			if(action!=null && id>=1) {
				if(action.equals("tang")) {
					for(Cart c:cart_list) {
						if(c.getId()==id) {
							int quantity = c.getQuantity();
							quantity++;
							c.setQuantity(quantity);
							resp.sendRedirect("/FreshCake/views/client/cart.jsp");
						}
					}
				}
				
				if(action.equals("giam")) {
					for(Cart c:cart_list) {
						if(c.getId()==id && c.getQuantity() >1) {
							int quantity = c.getQuantity();
							quantity--;
							c.setQuantity(quantity);
							break;
							
						}
					}
					resp.sendRedirect("/FreshCake/views/client/cart.jsp");
				}
			}else {
				resp.sendRedirect("/FreshCake/views/client/cart.jsp");
			
	}
		}
	}
}
