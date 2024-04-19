package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.RoleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Role;
@WebServlet(urlPatterns = {"/list-role"})
public class ListRoleController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Role> roles = new ArrayList<Role>();
		RoleDAO roleDAO = new RoleDAO();
		roles = roleDAO.getAll();
		req.setAttribute("roles", roles);
		req.getRequestDispatcher("/views/admin/listRole.jsp").forward(req, resp);
	}
}
