package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Feedback;

public class FeedbackDAO {
	// Phương thức lấy toàn bộ feedback
	public List<Feedback> getAll() {
		List<Feedback> feedbacks = new ArrayList<Feedback>();
		Connection conn = DBConnect.getConnection();
		String sql = "select * from feedback";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Feedback feedback = new Feedback();
				feedback.setId(rs.getInt("id"));
				feedback.setFullname(rs.getString("fullname"));
				feedback.setEmail(rs.getString("email"));
				feedback.setSubject(rs.getString("subject"));
				feedback.setMessage(rs.getString("message"));
				feedback.setCreated_at(rs.getString("created_at"));
				feedback.setStatus(rs.getInt("status"));
				feedback.setUser_id(rs.getInt("used_id"));
				feedbacks.add(feedback);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return feedbacks;
	}

	// Phương thức thêm mới feedback
	public boolean insert(Feedback feedback) {
		boolean check = false;
		Connection conn = DBConnect.getConnection();
		String sql = "insert into feedback values (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, feedback.getId());
			ps.setString(2, feedback.getFullname());
			ps.setString(3, feedback.getEmail());
			ps.setString(4, feedback.getSubject());
			ps.setString(5, feedback.getMessage());
			ps.setString(6, feedback.getCreated_at());
			ps.setInt(7, feedback.getStatus());
			ps.setInt(8, feedback.getUser_id());
			int row = ps.executeUpdate();
			if (row > 0) {
				check = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}

	// Phương thức lấy feedback theo id
	public Feedback getById(int id) {
		Feedback feedback = null;
		Connection conn = DBConnect.getConnection();
		String sql = "select * from feedback where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				feedback = new Feedback();
				feedback.setId(rs.getInt("id"));
				feedback.setFullname(rs.getString("fullname"));
				feedback.setEmail(rs.getString("email"));
				feedback.setSubject(rs.getString("subject"));
				feedback.setMessage(rs.getString("message"));
				feedback.setCreated_at(rs.getString("created_at"));
				feedback.setStatus(rs.getInt("status"));
				feedback.setUser_id(rs.getInt("used_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return feedback;
	}

	// Phương thức cập nhật feedback
	public boolean update(Feedback feedback) {
		boolean check = false;
		Connection conn = DBConnect.getConnection();
		String sql = "update feedback set fullname = ?, email = ?, subject = ?, message = ?, created_at = ?, status = ?, used_id = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, feedback.getFullname());
			ps.setString(2, feedback.getEmail());
			ps.setString(3, feedback.getSubject());
			ps.setString(4, feedback.getMessage());
			ps.setString(5, feedback.getCreated_at());
			ps.setInt(6, feedback.getStatus());
			ps.setInt(7, feedback.getUser_id());
			ps.setInt(8, feedback.getId());
			int row = ps.executeUpdate();
			if (row > 0) {
				check = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}

	// Phương thức xoá feedback
	public void delete(int id) {
		Connection conn = DBConnect.getConnection();
		String sql = "delete from feedback where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
