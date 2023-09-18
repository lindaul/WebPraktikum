package de.hwg_lu.bwi.beans;

public class Warenkorb_Produkt {

	private WarenkorbBean warenkorbId;
	private Produkt produktId;
	private int menge;
	private double desamtPreis;

	public WarenkorbBean getWarenkorbId() {
		return warenkorbId;
	}

	public void setWarenkorbId(WarenkorbBean warenkorbId) {
		this.warenkorbId = warenkorbId;
	}

	public Produkt getProduktId() {
		return produktId;
	}

	public void setProduktId(Produkt produktId) {
		this.produktId = produktId;
	}

	public int getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
	}

	public double getDesamtPreis() {
		return desamtPreis;
	}

	public void setDesamtPreis(double desamtPreis) {
		this.desamtPreis = desamtPreis;
	}

	public Warenkorb_Produkt() {
		// TODO Auto-generated constructor stub
	}

}
