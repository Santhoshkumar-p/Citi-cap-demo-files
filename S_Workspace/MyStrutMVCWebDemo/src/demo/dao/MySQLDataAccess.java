package demo.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import demo.business.Product;
import demo.business.Category;

public class MySQLDataAccess implements ProductData{
	public List<String> getProducts(){
		List<String> products = new ArrayList<String>();
		Connection cn = null;
		ResultSet rs = null;
		try{
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			Driver d = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);
		}
		catch(SQLException ex){ // ClassNotFoundException for Class.forName
			System.out.println(ex.getMessage());
		}
		try{
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?useSSL=false","root","c0nygre");
			Statement st = cn.createStatement();
			rs = st.executeQuery("SELECT name, price FROM theproducts");
			// Process the results of the query, one row at a time
			while (rs.next()) { 
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				products.add("Name: " + name + " Price: " + price);
			}
		}
		catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
		finally{
			if(cn != null){
				try {
					if(!cn.isClosed()){
						cn.close();
					}
				} catch (SQLException ex) {
					// TODO Auto-generated catch block
					System.out.println(ex.getMessage());
				}
			}
		}
		return products;
	}
	
	public List<Category> getCategories(){
		List<Category> categories = new ArrayList<>();
		Connection cn = null;
		ResultSet rs = null;
		try{
			//Class.forName("oracle.jdbc.driver.OracleDriver");ClassNotFoundException for Class.forName
			Driver d = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?useSSL=false","root","c0nygre");
			Statement st = cn.createStatement();
			rs = st.executeQuery("SELECT CategoryID, CategoryName FROM Categories");
			// Process the results of the query, one row at a time
			while (rs.next()) { 
				categories.add(new Category(rs.getInt("CategoryID"),rs.getString("CategoryName")));
			}
		}
		catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
		finally{
			if(cn != null){
				try{
					if(!cn.isClosed()){
						cn.close();
					}
				}
				catch(SQLException ex){
					System.out.println(ex.getMessage());
				}
			}
		}
		return categories;
	}
	

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = new LinkedList<Product>();
		Connection cn = null;
		ResultSet rs = null;
		try{
			//Class.forName("oracle.jdbc.driver.OracleDriver");ClassNotFoundException for Class.forName
			Driver d = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?useSSL=false","root","c0nygre");
			Statement st = cn.createStatement();
			rs = st.executeQuery("SELECT id, name," +
								"price, categoryid FROM theproducts");
			// Process the results of the query, one row at a time
			while (rs.next()) { 
				products.add(new Product(rs.getInt("id"),rs.getString("name"),rs.getDouble("price"),rs.getInt("categoryid")));
			}
		}
		catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
		finally{
			if(cn != null){
				try{
					if(!cn.isClosed()){
						cn.close();
					}
				}
				catch(SQLException ex){
					System.out.println(ex.getMessage());
				}
			}
		}
		return products;
	}

	@Override //Implement this
	public Product getProductByID(int id) {
		Product aproduct = null;
		ResultSet rs = null;
		try {
			Driver d = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?useSSL=false","root","c0nygre");) {
			PreparedStatement ps = cn.prepareStatement("SELECT * FROM theproducts WHERE "
					+ "id = ?");
			ps.setInt(1,id);
			rs = ps.executeQuery();
			if(rs.next()){
				aproduct = new Product(rs.getInt("id"), 
						rs.getString("name"),
						rs.getDouble("price"),
						rs.getInt("categoryid"));
			}
		} catch (SQLException ex) {
			System.err.println("IOException occurred: " + ex);
		}
		return aproduct;
	}


	@Override
	public int addProduct(Product p) {
		int rows = 0;
		try {
			Driver d = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?useSSL=false","root","c0nygre")) {
			PreparedStatement ps = cn.prepareStatement("INSERT INTO theproducts(name," +
						"price,categoryid) VALUES(?,?,?)");
			ps.setString(1, p.getMake());
			ps.setDouble(2, p.getPrice());
			ps.setInt(3, p.getCategoryid());
			rows = ps.executeUpdate();
		} catch (SQLException ex) {
			System.err.println("IOException occurred: " + ex);
		}
		return rows;
	}

	@Override
	public int updateProduct(Product p) {
		int rows = 0;
		
		try {
			Driver d = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		try (Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?useSSL=false","root","c0nygre");) {
			PreparedStatement ps = cn.prepareStatement("UPDATE theproducts SET categoryid = ?," +
						"name = ? ,price = ? WHERE id = ?");
			ps.setInt(1, p.getCategoryid());
			ps.setString(2, p.getMake());
			ps.setDouble(3, p.getPrice());
			ps.setInt(4, p.getId());
			rows = ps.executeUpdate();
		} catch (SQLException ex) {
			System.err.println("IOException occurred: " + ex);
		}
		return rows;
	}

	@Override
	public int deleteProduct(int id) {
		// TODO Auto-generated method stub
		int rows = 0;
		try {
			Driver d = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?useSSL=false","root","c0nygre");) {
			PreparedStatement ps = cn.prepareStatement("DELETE theproducts WHERE id = ?");
			ps.setInt(1, id);
			rows = ps.executeUpdate();
		} catch (SQLException ex) {
			System.err.println("Exception occurred: " + ex);
		}
		return rows;
	}
	

	public Product getMostExpensiveProduct() {
		Product aproduct = null;
		ResultSet rs = null;
		try {
			Driver d = new com.mysql.jdbc.Driver();
			DriverManager.registerDriver(d);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?useSSL=false","root","c0nygre");) {
			Statement st = cn.createStatement();
			rs = st.executeQuery("SELECT * FROM theproducts ORDER BY price DESC LIMIT 1");
									
			if(rs.next()){
				aproduct = new Product(rs.getInt("id"), 
						rs.getString("name"),
						rs.getDouble("price"),
						0);
			}
		} catch (SQLException ex) {
			System.err.println("IOException occurred: " + ex);
		}
		return aproduct;
	}
}
