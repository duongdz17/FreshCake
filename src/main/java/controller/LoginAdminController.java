package controller;

import java.io.IOException;

import dao.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;
@WebServlet(urlPatterns = {"/loginAdmin"})
public class LoginAdminController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			UserDAO userDAO = new UserDAO();
			HttpSession session = req.getSession();
			
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			int role_id = Integer.parseInt(req.getParameter("role_id"));
			User user = userDAO.AdminLogin(username, password, role_id);
			if(user!=null) {
				session.setAttribute("adminrobj", user);
				resp.sendRedirect("views/admin/index.jsp");
			}else {
				session.setAttribute("failedMsg", "Tài khoản hoặc password không tồn tại");
				resp.sendRedirect("views/admin/loginAdmin.jsp");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
