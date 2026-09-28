package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String url="jdbc:postgresql://localhost:5432/ManagementDatabase";
	private static final String user="postgres";
	private static final String password="root";
	
	public static Connection getConnection()
	{
		try {
			Class.forName("org.postgresql.Driver");
			
			return DriverManager.getConnection(url,user,password);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
