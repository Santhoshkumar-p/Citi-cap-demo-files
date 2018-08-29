package demo.data;
import java.sql.*;
import java.util.Scanner;

public class JDBCDemoCode {

	public static void main(String[] args) {
		// REMEMBER to use insingapore(n).conygre.com NOT singapore
		System.out.println("First Java Eclipse Program");
		String option = "";
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter an option\n(C)Connect to Database"+
					"\n(R)Retrieve Data\n(Q)Quit\n(A)AddProduct\n(U)Useprocs");
			option = sc.nextLine().toUpperCase();
			switch(option) {
			case "C" :
				mysqlconnect();
				break;
			case "R" :
				mysqlretrieve();
				break;
			case "P":
				addproduct();
				break;
			case "U":
				useprocs();
				break;
			case "Q" :
				System.out.print("Bye :)");
				break;
			default:
				System.out.print("OOPs try again :)\n");
			}
		}while(!option.toUpperCase().equals("Q"));
	}
	
	public static void mysqlconnect() {
		Connection cn = null;
		Statement st = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("*******MySQL Driver Loaded*******");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?useSSL=false","root","c0nygre");
			System.out.println("*******Connected to the Database :) *******");
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
	}
	public static void mysqlretrieve() {
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?useSSL=false","root","c0nygre");
			st = cn.createStatement();
			String search;
			Scanner sc = new Scanner (System.in);
			System.out.println("Enter the start of the product name:");
			search = sc.nextLine();
			rs = st.executeQuery("SELECT ProductID, ProductName FROM Products WHERE ProductName LIKE '" + search + "%'");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + ","+rs.getString(2));
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
	}
	public static void addproduct() {
		Connection cn = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?useSSL=false","root","c0nygre");
			st = cn.createStatement();
			String search, sql, product;
			double price;
			int categoryid;
			Scanner sc = new Scanner (System.in);
			System.out.println("Enter the product name:");
			product = sc.nextLine();
			System.out.println("Enter the price:");
			price = Double.parseDouble(sc.nextLine());
			System.out.println("Enter the category id:");
			categoryid = Integer.parseInt(sc.nextLine());
			sql = "INSERT INTO theproducts(name,price,categoryid) VALUES(?,?,?)";
			ps = cn.prepareStatement(sql);
			ps.setString(1, product);
			ps.setDouble(2, price);
			ps.setInt(3, categoryid);
			int rows = ps.executeUpdate();
			System.out.println(rows + "records added");
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
	}
	private static void useprocs() {
		Connection cn = null;
		CallableStatement st = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/northwind?useSSL=false","root","c0nygre");
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter a category (eg Beverages): ");
			String category = sc.nextLine();
			String sql = "{ call categoryProducts(?) }";
			st = cn.prepareCall(sql);
			st.setString(1, category);
			rs = st.executeQuery();
			while(rs.next()) {
				System.out.println(String.format("%s\t%s costs %.2f", rs.getString(1),rs.getString(2),rs.getDouble(3)));
			}
			System.out.println("Enter a customer id (eg ALFKI): ");
			String cust_id = sc.nextLine();
			sql = "{ call customerOrders(?,?) }";
			st = cn.prepareCall(sql);
			st.setString(1, cust_id);
			st.registerOutParameter(2, Types.INTEGER);
			st.execute();
			System.out.println(String.format("%s placed %d orders", cust_id,st.getInt(2)));
			
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
	}

}


