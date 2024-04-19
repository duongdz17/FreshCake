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
@WebServlet(urlPatterns = {"/deletecart"})
public class DeleteCartController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Cart> carts = new ArrayList<Cart>();
		resp.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = resp.getWriter()) {
			String id = req.getParameter("id");
			if(id!=null) {
				ArrayList<Cart> cart_list = (ArrayList<Cart>)req.getSession().getAttribute("carts"); 
				if(cart_list!=null) {
					for(Cart c:cart_list) {
						if(c.getId()==Integer.parseInt(id)) {
							cart_list.remove(cart_list.indexOf(c));
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
