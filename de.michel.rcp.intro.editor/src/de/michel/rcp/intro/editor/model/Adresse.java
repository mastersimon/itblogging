package de.michel.rcp.intro.editor.model;

public class Adresse {
	
	private int per_id, plz;
	private String strasse,hnr,ort,land;
	
	public Adresse(int perId, String strasse, String hnr, int plz, String ort,
			String land) {
		super();
		per_id = perId;
		this.plz = plz;
		this.strasse = strasse;
		this.hnr = hnr;
		this.ort = ort;
		this.land = land;
	}

	public int getPer_id() {
		return per_id;
	}

	public void setPer_id(int perId) {
		per_id = perId;
	}

	public int getPlz() {
		return plz;
	}

	public void setPlz(int plz) {
		this.plz = plz;
	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getHnr() {
		return hnr;
	}

	public void setHnr(String hnr) {
		this.hnr = hnr;
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}

	public String getLand() {
		return land;
	}

	public void setLand(String land) {
		this.land = land;
	}
	
	
	

}
