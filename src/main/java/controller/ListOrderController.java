package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.OrderDAO;
import dao.OrderDetailDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Order;
import model.OrderDetail;
@WebServlet(urlPatterns = {"/list-order"})
public class ListOrderController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Order> orders = new ArrayList<Order>();
		OrderDAO orderDAO = new OrderDAO();
		orders = orderDAO.getAll();
		req.setAttribute("orders", orders);
		
		List<OrderDetail> orderdetails = new ArrayList<OrderDetail>();
		OrderDetailDAO orderdetailDAO = new OrderDetailDAO();
		orderdetails = orderdetailDAO.getAll();
		req.setAttribute("orderdetails", orderdetails);
		req.getRequestDispatcher("/views/admin/listOrder.jsp").forward(req, resp);
	}
}
