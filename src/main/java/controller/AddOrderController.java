package controller;

import java.io.IOException;

import dao.OrderDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Order;
@WebServlet(urlPatterns = {"/add-order"})
public class AddOrderController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		String fullname = req.getParameter("fullname");
		String email = req.getParameter("email");
		String phonenumber = req.getParameter("phonenumber");
		String address = req.getParameter("address");
		String note = req.getParameter("note");
		String orderdate = req.getParameter("orderdate");
		int status = Integer.parseInt(req.getParameter("status"));
		double total = Double.parseDouble(req.getParameter("total"));
		int user_id = Integer.parseInt(req.getParameter("user_id"));
		Order order = new Order(id, fullname, email, phonenumber, address, note, orderdate, status, total, user_id);
		OrderDAO orderDAO = new OrderDAO();
		orderDAO.insert(order);
		resp.sendRedirect("/FreshCake/list-order");
	}
}
