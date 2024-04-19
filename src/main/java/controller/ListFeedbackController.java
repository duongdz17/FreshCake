package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dao.FeedbackDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Feedback;
@WebServlet(urlPatterns = {"/list-feedback"})
public class ListFeedbackController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Feedback> feedbacks = new ArrayList<Feedback>();
		FeedbackDAO feedbackDAO = new FeedbackDAO();
		feedbacks = feedbackDAO.getAll();
		req.setAttribute("feedbacks", feedbacks);
		req.getRequestDispatcher("/views/admin/listFeedback.jsp").forward(req, resp);
	}
}
