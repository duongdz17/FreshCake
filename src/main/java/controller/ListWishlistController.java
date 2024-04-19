package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.WishlistDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Wishlist;
@WebServlet(urlPatterns = {"/list-wishlist"})
public class ListWishlistController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Wishlist> wishlists = new ArrayList<Wishlist>();
		WishlistDAO wishlistDAO = new WishlistDAO();
		wishlists = wishlistDAO.getAll();
		req.setAttribute("wishlists", wishlists);
		req.getRequestDispatcher("/views/admin/listWishlist.jsp").forward(req, resp);
	}
}
