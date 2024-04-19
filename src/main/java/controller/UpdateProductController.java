package controller;

import java.io.IOException;

import dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Product;
@WebServlet(urlPatterns = {"/updateProduct"})
public class UpdateProductController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		Product product = new Product();
		ProductDAO productDAO = new ProductDAO();
		product = productDAO.getById(id);
		req.setAttribute("product", product);
		req.getRequestDispatcher("/views/admin/updateProduct.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			String description = req.getParameter("description");
			double price = Double.parseDouble(req.getParameter("price"));
			double discount = Double.parseDouble(req.getParameter("discount"));
			int quantity = Integer.parseInt(req.getParameter("quantity"));
			String thumbnail = req.getParameter("thumbnail");
			int is_featured = Integer.parseInt(req.getParameter("is_featured"));
			int status = Integer.parseInt(req.getParameter("status"));
			int category_id = Integer.parseInt(req.getParameter("category_id"));
			String create_at = req.getParameter("create_at");
			String update_at = req.getParameter("update_at");
			
			Product product = new Product(id, name, description, price, discount, quantity, thumbnail, is_featured, status, category_id, create_at, update_at);
			ProductDAO productDAO = new ProductDAO();
			
			productDAO.update(product);
			resp.sendRedirect("/FreshCake/list-product");
		} catch (Exception ex) {
			System.out.println("Error: "+ ex.getMessage());
		}
	}
}
