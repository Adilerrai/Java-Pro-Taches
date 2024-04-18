package org.example.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static Connection con = null;

	static
	{
		String url = "jdbc:postgresql://localhost:5435/Bibliotheque";
		String user = "postgres";
		String pass = "sophatel";
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, pass);
		}
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection()
	{
		return con;
	}
}
