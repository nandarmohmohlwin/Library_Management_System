package jframe;
import java.sql.*;

public class DBConnection {
	static Connection connection = null;
	
	public static Connection getConnection(){		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/librarydb";
			String username = "root";
			String password = "Password10";
			connection = DriverManager.getConnection(url, username, password);
		}catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}

}
