package de.michel.mysql.jList;

/**
 * Gibt als toString() den Nachnamen, Vornamen sowie die E-Mail Adresse aus
 */
public class Person
{
	public String firstName;
	public String lastName;
	String eMail;
	
	public Person(String firstName, String lastName, String eMail)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
	}
	
	public String toString()
	{
		return lastName + ", " + firstName + " (" + eMail + ")";
	}

}
