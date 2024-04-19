package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Wishlist;

public class WishlistDAO {
	// Phương thức lấy toàn bộ yêu thích
	public List<Wishlist> getAll() {
		List<Wishlist> wishlists = new ArrayList<Wishlist>();
		Connection conn = DBConnect.getConnection();
		String sql = "select * from wishlist";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Wishlist wishlist = new Wishlist();
				wishlist.setId(rs.getInt("id"));
				wishlist.setProduct_id(rs.getInt("product_id"));
				wishlist.setUser_id(rs.getInt("user_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wishlists;
	}

	// Phương thức thêm mới yêu thích
	public boolean insert(Wishlist wishlist) {
		boolean check = false;
		Connection conn = DBConnect.getConnection();
		String sql = "insert into wishlist values (?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, wishlist.getId());
			ps.setInt(2, wishlist.getProduct_id());
			ps.setInt(3, wishlist.getUser_id());
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

	// Phương thức lấy yêu thích theo id
	public Wishlist getById(int id) {
		Wishlist wishlist = null;
		Connection conn = DBConnect.getConnection();
		String sql = "select * from wishlist where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				wishlist = new Wishlist();
				wishlist.setId(rs.getInt("id"));
				wishlist.setProduct_id(rs.getInt("product_id"));
				wishlist.setUser_id(rs.getInt("user_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return wishlist;
	}

	// Phương thức cập nhật yêu thích
	public boolean update(Wishlist wishlist) {
		boolean check = false;
		Connection conn = DBConnect.getConnection();
		String sql = "update wishlist set product_id = ?, user_id = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, wishlist.getProduct_id());
			ps.setInt(2, wishlist.getUser_id());
			ps.setInt(3, wishlist.getId());
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

	// Phương thức xoá yêu thích
	public void delete(int id) {
		Connection conn = DBConnect.getConnection();
		String sql = "delete from wishlist where id = ?";
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
