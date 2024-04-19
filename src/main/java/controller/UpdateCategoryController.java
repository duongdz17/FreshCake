package controller;

import java.io.IOException;

import dao.CategoryDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Category;
@WebServlet(urlPatterns = {"/updateCategory"})
public class UpdateCategoryController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		Category category = new Category();
		CategoryDAO categoryDAO = new CategoryDAO();
		category = categoryDAO.getById(id);
		req.setAttribute("category", category);
		req.getRequestDispatcher("/views/admin/updateCategory.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("name");
			
			Category category = new Category(id, name);
			CategoryDAO categoryDAO = new CategoryDAO();
			
			categoryDAO.update(category);
			resp.sendRedirect("/FreshCake/list-category");
		} catch (Exception ex) {
			System.out.println("Error: "+ ex.getMessage());
		}
	}
}
