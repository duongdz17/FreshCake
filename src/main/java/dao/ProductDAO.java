package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cart;
import model.Product;

public class ProductDAO {
	// Phương thức lấy toàn bộ sản phẩm
	public List<Product> getAll() {
		List<Product> products = new ArrayList<Product>();
		Connection conn = DBConnect.getConnection();
		String sql = "select * from product";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setDiscount(rs.getDouble("discount"));
				product.setQuantity(rs.getInt("quantity"));
				product.setThumbnail(rs.getString("thumbnail"));
				product.setIs_featured(rs.getInt("is_featured"));
				product.setStatus(rs.getInt("status"));
				product.setCategory_id(rs.getInt("category_id"));
				product.setCreate_at(rs.getString("create_at"));
				product.setUpdate_at(rs.getString("update_at"));
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	// Phương thức lấy các sản phẩm mới
	public List<Product> getNewProduct() {
		List<Product> products = new ArrayList<Product>();
		Connection conn = DBConnect.getConnection();
		String sql = "select * from product order by create_at desc limit 8";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setDiscount(rs.getDouble("discount"));
				product.setQuantity(rs.getInt("quantity"));
				product.setThumbnail(rs.getString("thumbnail"));
				product.setIs_featured(rs.getInt("is_featured"));
				product.setStatus(rs.getInt("status"));
				product.setCategory_id(rs.getInt("category_id"));
				product.setCreate_at(rs.getString("create_at"));
				product.setUpdate_at(rs.getString("update_at"));
				products.add(product);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	// Phương thức thêm mới sản phẩm
	public boolean insert(Product product) {
		boolean check = false;
		Connection conn = DBConnect.getConnection();
		String sql = "insert into product values (?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, product.getId());
			ps.setString(2, product.getName());
			ps.setString(3, product.getDescription());
			ps.setDouble(4, product.getPrice());
			ps.setDouble(5, product.getDiscount());
			ps.setInt(6, product.getQuantity());
			ps.setString(7, product.getThumbnail());
			ps.setInt(8, product.getIs_featured());
			ps.setInt(9, product.getStatus());
			ps.setInt(10, product.getCategory_id());
			ps.setString(11, product.getCreate_at());
			ps.setString(12, product.getUpdate_at());
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

	// Phương thức lấy sản phẩm theo id
	public Product getById(int id) {
		Product product = null;
		Connection conn = DBConnect.getConnection();
		String sql = "select * from product where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setDiscount(rs.getDouble("discount"));
				product.setQuantity(rs.getInt("quantity"));
				product.setThumbnail(rs.getString("thumbnail"));
				product.setIs_featured(rs.getInt("is_featured"));
				product.setStatus(rs.getInt("status"));
				product.setCategory_id(rs.getInt("category_id"));
				product.setCreate_at(rs.getString("create_at"));
				product.setUpdate_at(rs.getString("update_at"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

	// Phương thức cập nhật sản phẩm
	public boolean update(Product product) {
		boolean check = false;
		Connection conn = DBConnect.getConnection();
		String sql = "update product set name = ?, description = ?, price = ?, discount= ?, quantity = ?, thumbnail = ?, is_featured = ?, status = ?, category_id = ?, create_at = ?, update_at = ? where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, product.getName());
			ps.setString(2, product.getDescription());
			ps.setDouble(3, product.getPrice());
			ps.setDouble(4, product.getDiscount());
			ps.setInt(5, product.getQuantity());
			ps.setString(6, product.getThumbnail());
			ps.setInt(7, product.getIs_featured());
			ps.setInt(8, product.getStatus());
			ps.setInt(9, product.getCategory_id());
			ps.setString(10, product.getCreate_at());
			ps.setString(11, product.getUpdate_at());
			ps.setInt(12, product.getId());
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

	// Phương thức xoá sản phẩm
	public void delete(int id) {
		Connection conn = DBConnect.getConnection();
		String sql = "delete from product where id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Lấy danh sách theo danh mục
	public List<Product> getProductByCat(String category_id) {
		Connection conn = DBConnect.getConnection();
		String sql = "select * from product where category_id=?";
		List<Product> products = new ArrayList<Product>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, category_id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setDiscount(rs.getDouble("discount"));
				product.setQuantity(rs.getInt("quantity"));
				product.setThumbnail(rs.getString("thumbnail"));
				product.setIs_featured(rs.getInt("is_featured"));
				product.setStatus(rs.getInt("status"));
				product.setCategory_id(rs.getInt("category_id"));
				product.setCreate_at(rs.getString("create_at"));
				product.setUpdate_at(rs.getString("update_at"));
				products.add(product);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}

	public List<Product> getProductSearch(String search) {
		Connection conn = DBConnect.getConnection();
		String sql = "select * from product where name like? or category_id like?";
		List<Product> products = new ArrayList<Product>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + search + "%");
			ps.setString(2, "%" + search + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setDescription(rs.getString("description"));
				product.setPrice(rs.getDouble("price"));
				product.setDiscount(rs.getDouble("discount"));
				product.setQuantity(rs.getInt("quantity"));
				product.setThumbnail(rs.getString("thumbnail"));
				product.setIs_featured(rs.getInt("is_featured"));
				product.setStatus(rs.getInt("status"));
				product.setCategory_id(rs.getInt("category_id"));
				product.setCreate_at(rs.getString("create_at"));
				product.setUpdate_at(rs.getString("update_at"));
				products.add(product);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return products;
	}
	//Tổng tiền của giỏ hàng
	public double getTotal(ArrayList<Cart> cartList) {
		double sum = 0;
		Connection conn = DBConnect.getConnection();
		try {
			if(cartList.size()>0) {
				for(Cart item:cartList) {
					String sql ="select price from product where id=?";
					PreparedStatement ps =conn.prepareStatement(sql);
					ps.setInt(1, item.getId());
					ResultSet rs =ps.executeQuery();
					while(rs.next()) {
						sum+=rs.getDouble("price")*item.getQuantity();
					}
				}
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sum;
	}
}
