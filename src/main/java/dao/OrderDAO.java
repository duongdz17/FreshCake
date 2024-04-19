package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Order;

public class OrderDAO {
	// Phương thức lấy toàn bộ order
	public List<Order> getAll() {
		List<Order> orders = new ArrayList<Order>();
		Connection conn = DBConnect.getConnection();
		String sql = "select * from `order`";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order.setId(rs.getInt("id"));
				order.setFullname(rs.getString("fullname"));
				order.setEmail(rs.getString("email"));
				order.setPhonenumber(rs.getString("phonenumber"));
				order.setAddress(rs.getString("address"));
				order.setNote(rs.getString("note"));
				order.setOrderdate(rs.getString("orderdate"));
				order.setStatus(rs.getInt("status"));
				order.setTotal(rs.getDouble("total"));
				order.setUser_id(rs.getInt("user_id"));
				orders.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orders;
	}

	// Phương thức thêm mới order
	public boolean insert(Order order) {
		boolean check = false;
		Connection conn = DBConnect.getConnection();
		String sql = "insert into `order` values (?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, order.getId());
			ps.setString(2, order.getFullname());
			ps.setString(3, order.getEmail());
			ps.setString(4, order.getPhonenumber());
			ps.setString(5, order.getAddress());
			ps.setString(6, order.getNote());
			ps.setString(7, order.getOrderdate());
			ps.setInt(8, order.getStatus());
			ps.setDouble(9, order.getTotal());
			ps.setInt(10, order.getUser_id());
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

	// Phương thức order theo id
	public Order getById(int id) {
		Order order = null;
		Connection conn = DBConnect.getConnection();
		String sql = "select * from `order` where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				order = new Order();
				order.setId(rs.getInt("id"));
				order.setFullname(rs.getString("fullname"));
				order.setEmail(rs.getString("email"));
				order.setPhonenumber(rs.getString("phonenumber"));
				order.setAddress(rs.getString("address"));
				order.setNote(rs.getString("note"));
				order.setOrderdate(rs.getString("orderdate"));
				order.setStatus(rs.getInt("status"));
				order.setTotal(rs.getDouble("total"));
				order.setUser_id(rs.getInt("user_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order;
	}

	// Phương thức cập nhật order
	public boolean update(Order order) {
		boolean check = false;
		Connection conn = DBConnect.getConnection();
		String sql = "update `order` set fullname = ?, email = ?, phonenumber = ?, address = ?, note = ?, orderdate = ?, status = ?, total = ?, user_id = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, order.getFullname());
			ps.setString(2, order.getEmail());
			ps.setString(3, order.getPhonenumber());
			ps.setString(4, order.getAddress());
			ps.setString(5, order.getNote());
			ps.setString(6, order.getOrderdate());
			ps.setInt(7, order.getStatus());
			ps.setDouble(8, order.getTotal());
			ps.setInt(9, order.getUser_id());
			ps.setInt(10, order.getId());
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

	// Phương thức xoá order
	public void delete(int id) {
		Connection conn = DBConnect.getConnection();
		String sql = "delete from `order` where id = ?";
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
