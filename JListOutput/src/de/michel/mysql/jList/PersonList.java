package de.michel.mysql.jList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

/**
 * 
 */
public class PersonList
{
	
	private static PersonList pList = null;
	private Connection connection = null;
	
	public static PersonList getInstance()
	{
		if(pList == null)
		{
			pList = new PersonList();
		}
		
		return pList;
	}

	private PersonList() {
		connection = DbConnection.getInstance();
	}

	/**
	 * Liefert einen Vector<Person>
	 * @return Alle Personen in einem Vector gespeichert
	 */
	public Vector<Person> getPersons()
	{
		
		Vector<Person> personList = new Vector<Person>();
		 
		if(connection != null)
		{
			try
			{
				Statement state = connection.createStatement();
				
				String sql = "SELECT first_name, last_name, email " + "FROM customer " +
						"ORDER BY last_name";
				
				ResultSet res = state.executeQuery(sql);
				while(res.next())
				{
					String firstName = res.getString("first_name");
					String lastName = res.getString("last_name");
					String eMail = res.getString("email");
					
					Person p = new Person(firstName, lastName, eMail);
					personList.add(p);				
				}
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
		}
		
		return personList;
	}

}
