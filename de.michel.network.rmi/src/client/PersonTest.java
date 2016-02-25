package client;

import java.util.ArrayList;

public class PersonTest
{
	public static void main(String[] args)
	{
		// wir holen uns die (lokale) Personenliste
		ArrayList<String> personList = PersonListLocal.getInstance().getPersonList();
		
		// es werden alle Personen ausgegeben
		for(String person : personList)
		{
			System.out.println(person);
		}
	}
}