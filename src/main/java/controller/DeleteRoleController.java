package controller;

import java.io.IOException;

import dao.RoleDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/deleteRole"})
public class DeleteRoleController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		RoleDAO roleDAO = new RoleDAO();
		roleDAO.delete(id);
		resp.sendRedirect("/FreshCake/list-role");
	}
}
