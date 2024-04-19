package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDAO {
	// Phương thức lấy toàn bộ user
	public List<User> getAll() {
		List<User> users = new ArrayList<User>();
		Connection conn = DBConnect.getConnection();
		String sql = "select * from user";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setFullname(rs.getString("fullname"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setPhonenumber(rs.getString("phonenumber"));
				user.setAddress(rs.getString("address"));
				user.setRole_id(rs.getInt("role_id"));
				user.setStatus(rs.getInt("status"));
				users.add(user);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;

	}

	// Phương thức thêm mới user
	public boolean insert(User user) {
		boolean check = false;
		Connection conn = DBConnect.getConnection();
		String sql = "insert into user values (?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.setString(2, user.getFullname());
			ps.setString(3, user.getUsername());
			ps.setString(4, user.getPassword());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getPhonenumber());
			ps.setString(7, user.getAddress());
			ps.setInt(8, user.getRole_id());
			ps.setInt(9, user.getStatus());
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

	// Phương thức lấy user theo id
	public User getById(int id) {
		User user = null;
		Connection conn = DBConnect.getConnection();
		String sql = "select * from user where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setFullname(rs.getString("fullname"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setPhonenumber(rs.getString("phonenumber"));
				user.setAddress(rs.getString("address"));
				user.setRole_id(rs.getInt("role_id"));
				user.setStatus(rs.getInt("status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	// Phương thức cập nhật user
	public boolean update(User user) {
		boolean check = false;
		Connection conn = DBConnect.getConnection();
		String sql = "update user set fullname = ?, username = ?, password = ?, email = ?, phonenumber = ?, address = ?, role_id = ?, status = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, user.getFullname());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPhonenumber());
			ps.setString(6, user.getAddress());
			ps.setInt(7, user.getRole_id());
			ps.setInt(8, user.getStatus());
			ps.setInt(9, user.getId());
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

	// Phương thức xoá user
	public void delete(int id) {
		Connection conn = DBConnect.getConnection();
		String sql = "delete from user where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Đăng nhập admin
			public User AdminLogin(String username, String password, int role_id) {
				User user = null;
				Connection conn = DBConnect.getConnection();
				try {
					String sql= "select * from user where username=? and password=? and role_id=?";
					PreparedStatement ps = conn.prepareStatement(sql);
					ps.setString(1, username);
					ps.setString(2, password);
					ps.setInt(3, role_id);
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
						user = new User();
						user.setId(rs.getInt(1));
						user.setFullname(rs.getString(2));
						user.setUsername(rs.getString(3));
						user.setPassword(rs.getString(4));
						user.setEmail(rs.getString(5));
						user.setPhonenumber(rs.getString(6));
						user.setAddress(rs.getString(7));
						user.setRole_id(1);
						user.setStatus(rs.getInt(9));
						
						
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				return user;
				
			}

	// Đăng ký khách hàng
	public boolean UserRegister(User user) {
		boolean check = false;
		Connection conn = DBConnect.getConnection();

		try {
			String sql = "insert into user(fullname, username, password, email, phonenumber, address, role_id, status) values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFullname());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getEmail());
			ps.setString(5, user.getPhonenumber());
			ps.setString(6, user.getAddress());
			ps.setInt(7, 2);
			ps.setInt(8, 1);
			int i = ps.executeUpdate();
			if (i == 1) {
				check = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return check;
	}

	// Đăng nhập khách hàng
	public User UserLogin(String username, String password, int role_id) {
		User user = null;
		Connection conn = DBConnect.getConnection();
		try {
			String sql = "select * from user where username=? and password=? and role_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setInt(3, role_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setFullname(rs.getString(2));
				user.setUsername(rs.getString(3));
				user.setPassword(rs.getString(4));
				user.setEmail(rs.getString(5));
				user.setPhonenumber(rs.getString(6));
				user.setAddress(rs.getString(7));
				user.setRole_id(2);
				user.setStatus(rs.getInt(9));

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return user;
	}

	// Không để khách hàng trùng tên đăng nhập
	public boolean checkUser(String checkingUserName) {
		Connection conn = DBConnect.getConnection();
		boolean check = true;
		try {
			String sql = "select * from user where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, checkingUserName);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				check = false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return check;
	}

	// Không để khách hàng trùng email
	public boolean checkUser1(String checkingUserEmail) {
		Connection conn = DBConnect.getConnection();
		boolean check = true;
		try {
			String sql = "select * from user where email = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, checkingUserEmail);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				check = false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return check;
	}
}
