package database;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class JDBCtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce","root","root");
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from eproduct");
			
			while(rs.next()) {
				
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
				
			}
			
			/*stmt.executeUpdate("insert into eproduct(name,price,date_added) values ('harddrive',2000.00,now())");
			
			stmt.executeUpdate("insert into eproduct(name,price,date_added) values ('Tablet',5800.00,now())");
			
			stmt.executeUpdate("Update eproduct set price = 6754.00 where name = 'laptop'");
			
			stmt.executeUpdate("delete from eproduct where name = 'desktop'");
			
			
			 stmt.executeUpdate("create database db2");
			
			stmt.executeUpdate("drop database db4");
			*/
			
			CallableStatement stmt1 = con.prepareCall("{call add_product(?, ?)}");
			stmt1.setString(1,"IPHONE");
			stmt1.setBigDecimal(2,new BigDecimal(98583.75));
			stmt1.executeUpdate();
			
			}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
