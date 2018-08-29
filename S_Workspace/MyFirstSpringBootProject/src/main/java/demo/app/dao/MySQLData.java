package demo.app.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import demo.app.business.Shipper;
@Component
public  class MySQLData implements IShipper {
	@Override
	public List<Shipper> allShippers () {
		
			List<Shipper> shippers = new ArrayList<>();
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
				rs = st.executeQuery("SELECT * FROM Shippers");
				// Process the results of the query, one row at a time
				while (rs.next()) { 
					shippers.add(new Shipper(rs.getInt(1), rs.getString(2), rs.getString(3)));
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
			return shippers;
		}
		
		
	}


