package controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.UUID;

import dao.OrderDAO;
import dao.OrderDetailDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Cart;
import model.Order;
import model.OrderDetail;
import model.User;
@WebServlet(urlPatterns = {"/order"})
public class OrderController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String fullname = req.getParameter("fullname");
		String phonenumber = req.getParameter("phonenumber");
		String email = req.getParameter("email");
		String address = req.getParameter("address");
		String note = req.getParameter("note");
		String orderdate = req.getParameter("orderdate");
		Double total = Double.parseDouble(req.getParameter("total")); 
		int status = Integer.parseInt(req.getParameter("status"));
		User user = (User)req.getSession().getAttribute("userobj");
		//Lấy thông tin từ giỏ hàng
		ArrayList<Cart> cart_list = (ArrayList<Cart>)req.getSession().getAttribute("carts");
		if (cart_list != null) {
			Order order = new Order();
			order.setId(UUID.randomUUID().hashCode());
			order.setFullname(fullname);
			order.setEmail(email);
			order.setPhonenumber(phonenumber);
			order.setAddress(address);
			order.setNote(note);
			order.setOrderdate(orderdate);
			order.setStatus(status);
			order.setTotal(total);
			if (user == null) {
				order.setUser_id(9);
			} else {
				order.setUser_id(user.getId());
			}
			OrderDAO orderDAO = new OrderDAO();
			orderDAO.insert(order);
			
			for(Cart cart: cart_list) {
				OrderDetail orderDetail = new OrderDetail();
				orderDetail.setId(UUID.randomUUID().hashCode());
				orderDetail.setTotal(cart.getPrice());
				orderDetail.setPrice(cart.getPrice());
				orderDetail.setQuantity(cart.getQuantity());
				orderDetail.setProduct_id(cart.getId());
				orderDetail.setOrder_id(order.getId());
				//Tương tự các cột khác
				OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
				orderDetailDAO.insert(orderDetail);
			}
			cart_list.clear();//Xoá giỏ hàng
			resp.sendRedirect("/FreshCake/views/client/index.jsp");
		}
	}
}
