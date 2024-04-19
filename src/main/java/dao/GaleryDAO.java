package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Galery;

public class GaleryDAO {
	// Phương thức lấy toàn bộ galery
	public List<Galery> getAll() {
		List<Galery> galeries = new ArrayList<Galery>();
		Connection conn = DBConnect.getConnection();
		String sql = "select * from galery";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Galery galery = new Galery();
				galery.setId(rs.getInt("id"));
				galery.setThumbnail(rs.getString("thumbnail"));
				galery.setProduct_id(rs.getInt("product_id"));
				galeries.add(galery);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return galeries;
	}

	// Phương thức thêm mới galery
	public boolean insert(Galery galery) {
		boolean check = false;
		Connection conn = DBConnect.getConnection();
		String sql = "insert into galery values (?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, galery.getId());
			ps.setString(2, galery.getThumbnail());
			ps.setInt(3, galery.getProduct_id());
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

	// Phương thức lấy galery theo id
	public Galery getById(int id) {
		Galery galery = null;
		Connection conn = DBConnect.getConnection();
		String sql = "select * from galery where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				galery = new Galery();
				galery.setId(rs.getInt("id"));
				galery.setThumbnail(rs.getString("thumbnail"));
				galery.setProduct_id(rs.getInt("product_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return galery;
	}

	// Phương thức cập nhật galery
	public boolean update(Galery galery) {
		boolean check = false;
		Connection conn = DBConnect.getConnection();
		String sql = "update galery set thumbnail = ?, product_id = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, galery.getThumbnail());
			ps.setInt(2, galery.getProduct_id());
			ps.setInt(3, galery.getId());
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

	// Phương thức xoá galery
	public void delete(int id) {
		Connection conn = DBConnect.getConnection();
		String sql = "delete from galery where id = ?";
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
