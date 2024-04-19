package controller;

import java.io.IOException;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;
@WebServlet(urlPatterns = {"/add-user"})
public class AddUserController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		String fullname = req.getParameter("fullname");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String phonenumber = req.getParameter("phonenumber");
		String address = req.getParameter("address");
		int role_id = Integer.parseInt(req.getParameter("role_id"));
		int status = Integer.parseInt(req.getParameter("status"));
		User user = new User(id, fullname, username, password, email, phonenumber, address, role_id, status);
		UserDAO userDAO = new UserDAO();
		userDAO.insert(user);
		resp.sendRedirect("/FreshCake/list-user");
	}
}
