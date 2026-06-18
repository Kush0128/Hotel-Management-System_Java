package project;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Connect {
	
	Connection con;
	Statement st;

	public Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hotelmanagementsystem";
			String user = "root";
			String password = "Password@123";
			
			con = DriverManager.getConnection(url, user, password);
			
			st = con.createStatement();
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
