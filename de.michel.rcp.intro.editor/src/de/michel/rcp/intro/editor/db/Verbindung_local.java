package de.michel.rcp.intro.editor.db;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;


public class Verbindung_local {
	private static Connection verbindung = null;
	private static String dbHost = "localhost";
	private static String dbPort = "3306";
	private static String database = "thesis";
	private static String dbUser = "root";
	private static String dbPassword = "toor";
	
	private Verbindung_local() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			verbindung = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":" + dbPort + "/"
					+ database + "?" + "user=" + dbUser + "&" + "password=" + dbPassword);			
		} catch (ClassNotFoundException e) {
			System.out.println("Treiber nicht gefunden");
		} catch (SQLException e) {
			System.out.println("Connect nicht moeglich");
		}
	}
	
	public static Connection getVerbindung() {
		if (verbindung == null)
			new Verbindung_local();
		return verbindung;
	}
}
