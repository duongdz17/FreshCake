package controller;

import java.io.IOException;

import dao.OrderDetailDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/deleteOrderDetail"})
public class DeleteOrderDetailController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		OrderDetailDAO orderdetailDAO = new OrderDetailDAO();
		orderdetailDAO.delete(id);
		resp.sendRedirect("/FreshCake/list-order");
	}
}
