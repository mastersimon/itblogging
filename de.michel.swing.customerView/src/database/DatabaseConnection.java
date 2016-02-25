package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection
{
	private static Connection connection;
	
	private static String dbHost =  "192.168.0.103"; 
	private static String dbPort = "3306";
	private static String database = "sakila";
	private static String dbUser = "simon";
	private static String dbPassword = "toor";
	
	public DatabaseConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":"
					+ dbPort + "/" + database + "?" + "user=" + dbUser + "&"
					+ "password=" + dbPassword);

		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static Connection getInstance()
	{
		if(connection == null)
		{
			new DatabaseConnection();
		}
		return connection;
	}
}
