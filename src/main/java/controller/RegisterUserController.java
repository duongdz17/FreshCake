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

@WebServlet(urlPatterns = { "/userRegister" })
public class RegisterUserController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String fullname = req.getParameter("fullname");
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			String email = req.getParameter("email");
			String phone = req.getParameter("phone");
			String address = req.getParameter("address");
			int role_id = Integer.parseInt(req.getParameter("role_id"));
			int status = Integer.parseInt(req.getParameter("status"));

			User user = new User();
			user.setFullname(fullname);
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			user.setPhonenumber(phone);
			user.setAddress(address);
			user.setRole_id(2);
			user.setStatus(1);
			HttpSession session = req.getSession();
			UserDAO userDAO = new UserDAO();
			boolean check2 = userDAO.checkUser(username);
			if(check2) {
				boolean check3 = userDAO.checkUser1(email);
				if(check3) {
					boolean check = userDAO.UserRegister(user);
					if(check) {
						session.setAttribute("succMsg", "Đăng ký thành công!");
						resp.sendRedirect("views/client/loginUser.jsp");
					}else {
						session.setAttribute("failedMsg", "Thông tin bị sai!");
						resp.sendRedirect("views/client/registerUser.jsp");
					}
				}else {
					session.setAttribute("failedMsg", "Email đã tồn tại!!");
					resp.sendRedirect("views/client/registerUser.jsp");
				}
			}else {
				session.setAttribute("failedMsg", "Tên đăng nhập đã tồn tại!!");
				resp.sendRedirect("views/client/registerUser.jsp");
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
