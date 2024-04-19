package controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.text.SimpleAttributeSet;

import dao.OrderDetailDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.OrderDetail;
@WebServlet(urlPatterns = {"/add-orderdetail"})
public class AddOrderDetailController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		double price = Double.parseDouble(req.getParameter("price"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		double total = Double.parseDouble(req.getParameter("total"));
		int orderdetail_id = Integer.parseInt(req.getParameter("orderdetail_id"));
		int order_id = Integer.parseInt(req.getParameter("order_id"));
		OrderDetail orderdetail = new OrderDetail(id, price, quantity, total, orderdetail_id, order_id);
		OrderDetailDAO orderdetailDAO = new OrderDetailDAO();
		orderdetailDAO.insert(orderdetail);
		resp.sendRedirect("/FreshCake/list-order");
	}
}
