package demo.data;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import demo.business.*;

public class MySQLData {
	public List<String> getProducts(String category){
		List<String> products = new ArrayList<String>();
		Connection cn = null;
		CallableStatement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?useSSL=false","root","c0nygre");
			String sql = "{ call categoryProducts(?) }";
			st = cn.prepareCall(sql);
			st.setString(1, category);
			rs = st.executeQuery();
			while(rs.next()) {
				products.add(String.format("%s costs %.2f", rs.getString(2),rs.getDouble(3)));
			}	
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error " + e.getMessage());
		} finally {
			if(cn != null) {
				try {
					if(!cn.isClosed()) {
						cn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Error " + e.getMessage());
				}
			}
		}
		return products;
	}
	
	public List<Category> getCategories(){
		List<Category> categories = new ArrayList<Category>();
		Connection cn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?useSSL=false","root","c0nygre");
			String sql = "SELECT CategoryID, CategoryName FROM Categories";
			st = cn.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
				categories.add(new Category(rs.getInt(1),rs.getString(2)));
			}	
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error " + e.getMessage());
		} finally {
			if(cn != null) {
				try {
					if(!cn.isClosed()) {
						cn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("Error " + e.getMessage());
				}
			}
		}
		return categories;
	}
}
