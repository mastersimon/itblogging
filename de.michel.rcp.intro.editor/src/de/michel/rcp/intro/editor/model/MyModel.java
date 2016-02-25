package de.michel.rcp.intro.editor.model;

import java.util.List;

import de.michel.rcp.intro.editor.db.DatenbankListe;

public class MyModel {
	
	private List<Person> persons;
	private static MyModel content;

	public List<Person> getPersons() {
		return persons;
	}
	
	public static synchronized MyModel getInstance() {
		if (content != null) {
			return content;
		}
		content = new MyModel();
		return content;
	}
	
	public MyModel() {
		persons = DatenbankListe.getDieDatenbank().getPersonen();
	}


}
