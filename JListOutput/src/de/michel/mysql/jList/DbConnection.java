package de.michel.mysql.jList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 
 */
public class DbConnection
{
	private static Connection connection = null;

	private static String dbHost = "192.168.0.103";
	private static String dbPort = "3306";
	private static String database = "sakila";
	private static String dbUser = "simon";
	private static String dbPassword = "toor";

	private DbConnection() {
		try {

			Class.forName("com.mysql.jdbc.Driver");

			connection = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":"
					+ dbPort + "/" + database + "?" + "user=" + dbUser + "&"
					+ "password=" + dbPassword);
		} catch (ClassNotFoundException e) {
			System.out.println("Treiber nicht gefunden");
		} catch (SQLException e) {
			System.out.println("Connect nicht moeglich");
		}
	}
	
	public static Connection getInstance()
	{
		if(connection == null)
		{
			new DbConnection();
		}
		return connection;
	}

}
