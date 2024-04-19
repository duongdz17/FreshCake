package controller;

import java.io.IOException;

import dao.WishlistDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/deleteWishlist"})
public class DeleteWishlistController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		WishlistDAO wishlistDAO = new WishlistDAO();
		wishlistDAO.delete(id);
		resp.sendRedirect("/FreshCake/list-wishlist");
	}
}
