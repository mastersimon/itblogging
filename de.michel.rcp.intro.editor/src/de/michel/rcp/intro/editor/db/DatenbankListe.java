package de.michel.rcp.intro.editor.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import de.michel.rcp.intro.editor.model.Adresse;
import de.michel.rcp.intro.editor.model.Person;


public class DatenbankListe {
	
	private static DatenbankListe dieDatenbankListe = null;

	public static DatenbankListe getDieDatenbank() {
		if (dieDatenbankListe == null)
			dieDatenbankListe = new DatenbankListe();
		return dieDatenbankListe;
	}

	private Connection verbindung = null;

	private DatenbankListe() {
		verbindung = Verbindung_local.getVerbindung();
	}
	
	public boolean updatePerson(Person person){
		System.out.println("updatePerson");		
		if(verbindung != null)
	    {	        
            Statement anfrage;
			try {
				anfrage = verbindung.createStatement();
				String sql;
	            	            
	            sql = "UPDATE Person SET name = '" + person.getNachname() + "', " +
	            		"vorname = '"+ person.getVorname() +"', " +
	            		"geschlecht = '" + person.getGeschlecht() + "' " +
	            		"WHERE Person.id = " + person.getId();
	            anfrage.executeUpdate(sql);
	            
	            sql = "UPDATE Adresse SET " +
	            		"strasse = '" + person.getAdresse().getStrasse() + "'," +
	            		"hnr = '" + person.getAdresse().getHnr() + "'," +
	            		"plz = " + person.getAdresse().getPlz() + "," +
	            		"ort = '" + person.getAdresse().getOrt() + "'," +
	            		"land = '" + person.getAdresse().getLand() + "' " +
	            		"WHERE per_id = " + person.getId();
	            
	            int ergebnis = anfrage.executeUpdate(sql);
	            if(ergebnis > 0){
	            	System.out.println("Datensatz von " + person.getVorname() + " " + person.getNachname()  + " erfolgreich geändert");;
	            	return true;
	            }
	            	
	            
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}       
	   }
		
		return false;		
	}
	
	public boolean insertPerson(Person person){
		System.out.println("insertPerson()");		
		if(verbindung != null)
	    {	        
            Statement anfrage;
			try {
				anfrage = verbindung.createStatement();
				String sql;	
	            	            
	            sql = "INSERT INTO Person SET " +
	            		"Person.name = '" + person.getNachname() + "', " +
	            		"Person.vorname = '" + person.getVorname() + "', " +
        				"Person.geschlecht = '" + person.getGeschlecht() + "'";
	           anfrage.executeUpdate(sql);	
	           
	           sql = "SELECT * FROM Person WHERE " +
		       			"Person.name = '" + person.getNachname() + "' AND " +
		       			"Person.vorname = '" + person.getVorname() + "' AND " +
		       			"Person.geschlecht = '" + person.getGeschlecht() + "'";
	            
	            ResultSet ergebnis = anfrage.executeQuery(sql);

				if (ergebnis.next()) {
					int id  = ergebnis.getInt("id");
					System.out.println("Neue ID: " + id);
					
					sql = "INSERT INTO Adresse SET " +
						"Adresse.per_id = '" + id + "', " +
						"Adresse.strasse = '" + person.getAdresse().getStrasse() + "', " +
						"Adresse.hnr = '" + person.getAdresse().getHnr() + "', " +
						"Adresse.plz = " + person.getAdresse().getPlz() + ", " +
						"Adresse.ort = '" + person.getAdresse().getOrt() + "', " +
						"Adresse.land = '" + person.getAdresse().getLand() + "'";
					anfrage.executeUpdate(sql);
				}
				return true;
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}       
	   }
		return false;
	}
	
	public boolean deletePerson(int id){
		System.out.println("deletePerson");		
		if(verbindung != null)
	    {	        
            Statement anfrage;
			try {
				anfrage = verbindung.createStatement();
				String sql;
	            	            
	            sql = "DELETE FROM Person WHERE Person.id = " + id;
	          	            
	            int ergebnis = anfrage.executeUpdate(sql);
	            if(ergebnis > 0){
	            	sql = "DELETE FROM Adresse WHERE Adresse.per_id = " + id + " LIMIT 1";
	            	ergebnis = anfrage.executeUpdate(sql);
	            	if(ergebnis > 0){
	            		System.out.println("Datensatz von mit der ID " + id + " erfolgreich gelöscht");
	            		return true;
	            	}
	            }
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}       
	   }	
		return false;			
	}
	
	public List<Person> getPersonen(){
		System.out.println("getPersons()");
		List<Person> persons = new ArrayList<Person>();
		
		if(verbindung != null)
	      {
	         try
	         {
	            Statement anfrage = verbindung.createStatement();
	            String sql, name, vorname, geschlecht, str, hnr, ort, land;
	            int plz, id;
	            
	            sql = "SELECT * FROM Person " +
	            		"JOIN Adresse " +
	            		"WHERE Person.id = Adresse.per_id " +
	            		"ORDER BY Person.vorname";
	            ResultSet ergebnis = anfrage.executeQuery(sql);
	            
	            while (ergebnis.next())
	            {
	            	id = ergebnis.getInt("id");	
	            	vorname = ergebnis.getString("vorname");
	            	name = ergebnis.getString("name");
	            	geschlecht = ergebnis.getString("geschlecht");
	            	land = ergebnis.getString("land");
	            	str = ergebnis.getString("strasse");
	            	hnr = ergebnis.getString("hnr");
	            	plz = ergebnis.getInt("plz");
	            	ort = ergebnis.getString("ort");
	            	land = ergebnis.getString("land");            	
	            	
	            	Person person = new Person(id, vorname, name, geschlecht);
	        		person.setAdresse(new Adresse(id, str, hnr, plz, ort, land));	        		
	        		persons.add(person);
	            }	
	            return persons;
	         }
	         catch(SQLException e)
	         {
	            System.out.println("Fehler in MyModel.java : "
	                               + e.getMessage());
	         }
	      }		
		return null;		
	}
	
}
