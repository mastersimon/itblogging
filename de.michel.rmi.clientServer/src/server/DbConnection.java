package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection 
{
	private static Connection connection = null;
	private static String dbHost = "localhost";
	private static String dbPort = "3306";
	private static String database = "sakila";
	private static String dbUser = "root";
	private static String dbPassword = "toor";
	
	public DbConnection()
	{
		if(connection != null)
		{
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":"
						+ dbPort + "/" + database + "?" + "user=" + dbUser + "&"
						+ "password=" + dbPassword);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}
	
	public static Connection getConnection() 
	{
		if (connection == null)
		{
			new DbConnection();
		}
		
		return connection;
	}
}