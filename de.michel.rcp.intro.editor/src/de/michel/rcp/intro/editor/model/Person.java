package de.michel.rcp.intro.editor.model;

public class Person {
	
	private String vorname;
	private String nachname;
	private Adresse adresse;
	private String geschlecht;
	private int id;
	

	public Person(int id, String vorname, String nachname, String geschlecht) {
		this.id = id;
		this.vorname = vorname;
		this.nachname = nachname;
		this.geschlecht = geschlecht;
	}		
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGeschlecht() {
		return geschlecht;
	}

	public void setGeschlecht(String geschlecht) {
		this.geschlecht = geschlecht;
	}
	

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {		
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}
	
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result
				+ ((geschlecht == null) ? 0 : geschlecht.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((nachname == null) ? 0 : nachname.hashCode());
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Person [adresse=" + adresse + ", geschlecht=" + geschlecht
				+ ", id=" + id + ", nachname=" + nachname + ", vorname="
				+ vorname + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (adresse == null) {
			if (other.adresse != null)
				return false;
		} else if (!adresse.equals(other.adresse))
			return false;
		if (geschlecht == null) {
			if (other.geschlecht != null)
				return false;
		} else if (!geschlecht.equals(other.geschlecht))
			return false;
		if (id != other.id)
			return false;
		if (nachname == null) {
			if (other.nachname != null)
				return false;
		} else if (!nachname.equals(other.nachname))
			return false;
		if (vorname == null) {
			if (other.vorname != null)
				return false;
		} else if (!vorname.equals(other.vorname))
			return false;
		return true;
	}
	
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result
//				+ ((vorname == null) ? 0 : vorname.hashCode());
//		result = prime * result
//				+ ((nachname == null) ? 0 : nachname.hashCode());
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Person other = (Person) obj;
//		if (vorname == null) {
//			if (other.vorname != null)
//				return false;
//		} else if (!vorname.equals(other.vorname))
//			return false;
//		if (nachname == null) {
//			if (other.nachname != null)
//				return false;
//		} else if (!nachname.equals(other.nachname))
//			return false;
//		return true;
//	}
	
	
	
	

}
