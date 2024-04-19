package controller;

import java.io.IOException;

import dao.GaleryDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Galery;
@WebServlet(urlPatterns = {"/updateGalery"})
public class UpdateGaleryController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(req.getParameter("id"));
		Galery galery = new Galery();
		GaleryDAO galeryDAO = new GaleryDAO();
		galery = galeryDAO.getById(id);
		req.setAttribute("galery", galery);
		req.getRequestDispatcher("/views/admin/updateGalery.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			req.setCharacterEncoding("UTF-8");
			int id = Integer.parseInt(req.getParameter("id"));
			String thumbnail = req.getParameter("thumbnail");
			int product_id = Integer.parseInt(req.getParameter("product_id"));
			Galery galery = new Galery(id, thumbnail, product_id);
			GaleryDAO galeryDAO = new GaleryDAO();
			
			galeryDAO.update(galery);
			resp.sendRedirect("/FreshCake/list-galery");
		} catch (Exception ex) {
			System.out.println("Error: "+ ex.getMessage());
		}
	}
}
