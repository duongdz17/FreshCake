package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.GaleryDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Galery;
@WebServlet(urlPatterns = {"/list-galery"})
public class ListGaleryController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Galery> galeries = new ArrayList<Galery>();
		GaleryDAO galeryDAO = new GaleryDAO();
		galeries = galeryDAO.getAll();
		req.setAttribute("galeries", galeries);
		req.getRequestDispatcher("/views/admin/listGalery.jsp").forward(req, resp);
	}
}
