package controller;

import java.io.IOException;

import dao.GaleryDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = {"/deleteGalery"})
public class DeleteGaleryController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		GaleryDAO galeryDAO = new GaleryDAO();
		galeryDAO.delete(id);
		resp.sendRedirect("/FreshCake/list-galery");
	}
}
