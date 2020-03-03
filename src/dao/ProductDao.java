package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Amount;
import model.Product;

public class ProductDao {
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	private String sql;

	public ProductDao() {
		// TODO Auto-generated constructor stub
		conn = MyConnection.getConnection();
	}

	public List<Amount> TotalAmount(String from, String to) {
		List<Amount> amount = new ArrayList<>();
		try {
			sql = "select category, SUM(price) as total from product  where dates BETWEEN ? AND ? group by category";
			pst = conn.prepareStatement(sql);
			pst.setString(1, from);
			pst.setString(2, to);
			rs = pst.executeQuery();
			while (rs.next()) {
				Amount pm = new Amount();
				pm.setCategory(rs.getString("CATEGORY"));
				pm.setPrice(rs.getFloat("total"));
				amount.add(pm);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(ProductDao.class.getCanonicalName() + " -> " + e.toString());
		}
		System.out.println(amount);
		return amount;
	}

	public Integer Register(Product p) throws SQLException {
		int i = 0;
		sql = "insert into register1 values (user_id.nextval,?, ?, ? )";
		// Parameters start with 1
		pst = conn.prepareStatement(sql);
		pst.setString(1, p.getName());
		pst.setString(2, p.getUsername());
		pst.setString(3, p.getPassword());
		i = pst.executeUpdate();
		return i;

		// TODO Auto-generated method stub

	}

	public Integer Login(Product p) throws SQLException {
		int i = 0;
		sql = "SELECT * FROM register1 WHERE USERNAME = ? AND PASSWORD = ?";
		// Parameters start with 1
		pst = conn.prepareStatement(sql);
		pst.setString(1, p.getUsername());
		pst.setString(2, p.getPassword());
		i = pst.executeUpdate();
		return i;

		// TODO Auto-generated method stub

	}

	public Integer AddProduct(Product p) throws SQLException {
		int i = 0;
		sql = "insert into product values (product_id.nextval,?, ?, ?,? )";
		// Parameters start with 1

		pst = conn.prepareStatement(sql);
		pst.setString(1, p.getCategory());
		pst.setString(2, p.getName());
		pst.setFloat(3, p.getPrice());
		pst.setString(4, p.getDates());
		i = pst.executeUpdate();
		return i;

		// TODO Auto-generated method stub

	}

	public Integer delete(Product p) throws SQLException {
		int i = 0;
		sql = "delete from product where product_id=?";
		// Parameters start with 1
		pst = conn.prepareStatement(sql);
		pst.setInt(1, p.getProduct_id());
		i = pst.executeUpdate();
		return i;

		// TODO Auto-generated method stub

	}

	public Integer update(Product p) throws SQLException {
		int i = 0;
		sql = "update product set category=?,name=?,price=?,dates=? where product_id=?";
		// Parameters start with 1
		pst = conn.prepareStatement(sql);
		pst.setString(1, p.getCategory());
		pst.setString(2, p.getName());
		pst.setFloat(3, p.getPrice());
		pst.setString(4, p.getDates());
		pst.setInt(5, p.getProduct_id());
		i = pst.executeUpdate();
		return i;

		// TODO Auto-generated method stu
	}

	public Product getRecordById(int Product_id) {

		Product pm = null;
		try {
			sql = "select * from product where product_id=?";

			pst = conn.prepareStatement(sql);
			pst.setInt(1, Product_id);
			rs = pst.executeQuery();
			while (rs.next()) {
				pm = new Product();
				pm.setProduct_id(rs.getInt("product_id"));
				pm.setCategory(rs.getString("CATEGORY"));
				pm.setName(rs.getString("name"));
				pm.setPrice(rs.getFloat("price"));
				pm.setDates(rs.getString("dates"));
			}

		} catch (Exception e) {
			// TODO: handle exception

		}
		return pm;

	}

	public List<Product> findRecode(String from, String to) {
		List<Product> products = new ArrayList<>();
		try {
			sql = "select * from product where dates BETWEEN ? AND ?";
			pst = conn.prepareStatement(sql);
			pst.setString(1, from);
			pst.setString(2, to);
			rs = pst.executeQuery();
			while (rs.next()) {
				Product pm = new Product();
				pm.setProduct_id(rs.getInt("product_id"));
				pm.setCategory(rs.getString("CATEGORY"));
				pm.setName(rs.getString("name"));
				pm.setPrice(rs.getFloat("price"));
				pm.setDates(rs.getString("dates"));
				products.add(pm);

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(ProductDao.class.getCanonicalName() + " -> " + e.toString());
		}
		return products;
	}

	public List<Product> showAllDetail() {
		List<Product> products = new ArrayList<>();
		try {
			sql = "select * from product ";
			pst = conn.prepareStatement(sql);

			rs = pst.executeQuery();
			while (rs.next()) {
				Product pm = new Product();
				pm.setProduct_id(rs.getInt("product_id"));
				pm.setCategory(rs.getString("CATEGORY"));
				pm.setName(rs.getString("name"));
				pm.setPrice(rs.getFloat("price"));
				pm.setDates(rs.getString("dates"));
				products.add(pm);

			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(ProductDao.class.getCanonicalName() + " -> " + e.toString());
		}
		return products;
	}

	public static List<Product> getAllRecords() {
		List<Product> list = new ArrayList<Product>();

		try {
			Connection con = MyConnection.getConnection();
			;
			PreparedStatement ps = con.prepareStatement("select * from product");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setProduct_id(rs.getInt("product_id"));
				p.setCategory(rs.getString("category"));
				p.setName(rs.getString("name"));
				p.setPrice(rs.getFloat("price"));
				p.setDates(rs.getString("dates"));
				list.add(p);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

}
