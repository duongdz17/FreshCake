package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.OrderDetail;

public class OrderDetailDAO {
	// Phương thức lấy toàn bộ orderdetail
	public List<OrderDetail> getAll() {
		List<OrderDetail> orderdetails = new ArrayList<OrderDetail>();
		Connection conn = DBConnect.getConnection();
		String sql = "select * from orderdetail";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderDetail orderdetail = new OrderDetail();
				orderdetail.setId(rs.getInt("id"));
				orderdetail.setPrice(rs.getDouble("price"));
				orderdetail.setQuantity(rs.getInt("quantity"));
				orderdetail.setTotal(rs.getDouble("total"));
				orderdetail.setProduct_id(rs.getInt("product_id"));
				orderdetail.setOrder_id(rs.getInt("order_id"));
				orderdetails.add(orderdetail);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderdetails;
	}

	// Phương thức thêm mới orderdetail
	public boolean insert(OrderDetail orderdetail) {
		boolean check = false;
		Connection conn = DBConnect.getConnection();
		String sql = "insert into orderdetail values (?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, orderdetail.getId());
			ps.setDouble(2, orderdetail.getPrice());
			ps.setInt(3, orderdetail.getQuantity());
			ps.setDouble(4, orderdetail.getTotal());
			ps.setInt(5, orderdetail.getProduct_id());
			ps.setInt(6, orderdetail.getOrder_id());
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

	// Phương thức lấy orderdetail theo id
	public OrderDetail getById(int id) {
		OrderDetail orderdetail = null;
		Connection conn = DBConnect.getConnection();
		String sql = "select * from orderdetail where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				orderdetail = new OrderDetail();
				orderdetail.setId(rs.getInt("id"));
				orderdetail.setPrice(rs.getDouble("price"));
				orderdetail.setQuantity(rs.getInt("quantity"));
				orderdetail.setTotal(rs.getDouble("total"));
				orderdetail.setProduct_id(rs.getInt("product_id"));
				orderdetail.setOrder_id(rs.getInt("order_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderdetail;
	}

	// Phương thức cập nhật orderdetail
	public boolean update(OrderDetail orderdetail) {
		boolean check = false;
		Connection conn = DBConnect.getConnection();
		String sql = "update orderdetail set price = ?, quantity = ?, total= ?, product_id = ?, order_id = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, orderdetail.getPrice());
			ps.setInt(2, orderdetail.getQuantity());
			ps.setDouble(3, orderdetail.getTotal());
			ps.setInt(4, orderdetail.getProduct_id());
			ps.setInt(5, orderdetail.getOrder_id());
			ps.setInt(6, orderdetail.getId());
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

	// Phương thức xoá orderdetail
	public void delete(int id) {
		Connection conn = DBConnect.getConnection();
		String sql = "delete from orderdetail where id = ?";
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
