package controller;

import java.io.IOException;

import dao.RoleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Role;
@WebServlet(urlPatterns = {"/add-role"})
public class AddRoleController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		Role role = new Role(id, name);
		RoleDAO roleDAO = new RoleDAO();
		roleDAO.insert(role);
		resp.sendRedirect("/FreshCake/list-role");
	}
}
