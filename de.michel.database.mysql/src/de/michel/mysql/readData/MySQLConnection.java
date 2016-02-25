package de.michel.mysql.readData;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {

	private static Connection conn = null;

	// Hostname
	private static String dbHost = "192.168.0.110";

	// Port -- Standard: 3306
	private static String dbPort = "3306";

	// Datenbankname
	private static String database = "sakila";

	// Datenbankuser
	private static String dbUser = "simon";

	// Datenbankpasswort
	private static String dbPassword = "toor";

	private MySQLConnection() {
		try {

			// Datenbanktreiber für ODBC Schnittstellen laden.
			// Für verschiedene ODBC-Datenbanken muss dieser Treiber
			// nur einmal geladen werden.
			Class.forName("com.mysql.jdbc.Driver");
			
			// Verbindung zur ODBC-Datenbank 'sakila' herstellen.
			// Es wird die JDBC-ODBC-Brücke verwendet.
			conn = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":"
					+ dbPort + "/" + database + "?" + "user=" + dbUser + "&"
					+ "password=" + dbPassword);
		} catch (ClassNotFoundException e) {
			System.out.println("Treiber nicht gefunden");
		} catch (SQLException e) {
			System.out.println("Connect nicht moeglich");
		}
	}
	
	private static Connection getInstance()
	{
		if(conn == null)
			new MySQLConnection();
		return conn;
	}

	/**
	 * Schreibt die Namensliste in die Konsole
	 */
	public static void printNameList() 
	{
		conn = getInstance();
		
		if(conn != null)
		{
			// Anfrage-Statement erzeugen.
			Statement query;
			try {
				query = conn.createStatement();

				// Ergebnistabelle erzeugen und abholen.
				String sql = "SELECT first_name, last_name " + "FROM actor "
						+ "ORDER BY last_name";
				ResultSet result = query.executeQuery(sql);

				// Ergebnissätze durchfahren.
				while (result.next()) {
					String first_name = result.getString("first_name"); // Alternativ: result.getString(1);
					String last_name = result.getString("last_name"); // Alternativ: result.getString(2);
					String name = last_name + ", " + first_name;
					System.out.println(name);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Fügt einen neuen Datensatz hinzu 
	 */
	public static void insertName(String firstName, String lastName)
	{
		conn = getInstance();
		
		if(conn != null)
		{
			// Anfrage-Statement erzeugen.
			Statement query;
			try {
				query = conn.createStatement();

				// Ergebnistabelle erzeugen und abholen.
				String sql = "INSERT INTO actor(first_name, last_name) VALUES('" + firstName + "', '" + lastName +"')";
				query.executeUpdate(sql);
				
				// Es wird der letzte Datensatz abgefragt
				ResultSet result = query.executeQuery("SELECT actor_id, first_name, last_name FROM actor ORDER BY actor_id desc LIMIT 1");
				
				// Wenn ein Datensatz gefunden wurde, wird auf diesen Zugegriffen 
				if(result.next())
				{
					System.out.println("(" + result.getInt(1) + ")" + result.getString(2) + " " + result.getString(3));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Aktualisiert den Datensatz mit der übergebenen actorId 
	 */
	public static void updateName(String firstName, String lastName, int actorId)
	{
		conn = getInstance();
		
		if(conn != null)
		{
			// Anfrage-Statement erzeugen.
			Statement query;
			try {
				query = conn.createStatement();
				
				String querySql = "SELECT actor_id, first_name, last_name FROM actor WHERE actor_id = " + actorId;
				ResultSet result = query.executeQuery(querySql);
				
				if(result.next())
				{
					// Vorher
					System.out.println("VORHER: (" + result.getInt(1) + ")" + result.getString(2) + " " + result.getString(3));
				}

				// Ergebnistabelle erzeugen und abholen.
				String updateSql = "UPDATE actor SET first_name = '" + firstName + "', last_name = '" + lastName + "' WHERE actor_id = " + actorId;
				query.executeUpdate(updateSql);
				
				// Es wird der letzte Datensatz abgefragt
				result = query.executeQuery(querySql);
				
				if(result.next())
				{
					System.out.println("NACHHER: (" + result.getInt(1) + ")" + result.getString(2) + " " + result.getString(3));
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
