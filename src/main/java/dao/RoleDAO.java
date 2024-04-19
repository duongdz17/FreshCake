package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Role;

public class RoleDAO {
	// Phương thức lấy toàn bộ danh mục sản phẩm
	public List<Role> getAll() {
		List<Role> roles = new ArrayList<Role>();
		Connection conn = DBConnect.getConnection();
		String sql = "select * from role";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Role role = new Role();
				role.setId(rs.getInt("id"));
				role.setName(rs.getString("name"));
				roles.add(role);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return roles;
	}

	// Phương thức thêm mới danh mục sản phẩm
	public boolean insert(Role role) {
		boolean check = false;
		Connection conn = DBConnect.getConnection();
		String sql = "insert into role values (?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, role.getId());
			ps.setString(2, role.getName());
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

	// Phương thức lấy loại sản phẩm theo id
	public Role getById(int id) {
		Role role = null;
		Connection conn = DBConnect.getConnection();
		String sql = "select * from role where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				role = new Role();
				role.setId(rs.getInt("id"));
				role.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return role;
	}

	// Phương thức cập nhật loại sản phẩm
	public boolean update(Role role) {
		boolean check = false;
		Connection conn = DBConnect.getConnection();
		String sql = "update role set name = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, role.getName());
			ps.setInt(2, role.getId());
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

	// Phương thức xoá loại sản phẩm
	public void delete(int id) {
		Connection conn = DBConnect.getConnection();
		String sql = "delete from role where id = ?";
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
