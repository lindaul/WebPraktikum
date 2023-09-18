package de.hwg_lu.bwi.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.hwg_lu.bwi.jdbc.PostgreSQLAccess;

public class Produkt {

	private int produktId;
	private String produktNummer;
	private String produktName;
	private String beschreibungProdukt;
	private double preis;
	private int bestand;
	private double rabatt;
	private String kategorie;
	private String marke;
	
	private ArrayList<Produkt> produktlist;
	Connection dbConn;

	public Produkt() {

	}

	public Produkt(int produktId, String produktNummer, String produktName, String beschreibungProdukt, double preis, int bestand,
			double rabatt, String kategorie, String marke) {
		super();
		this.produktId = produktId;
		this.produktNummer = produktNummer;
		this.produktName = produktName;
		this.beschreibungProdukt = beschreibungProdukt;
		this.preis = preis;
		this.bestand = bestand;
		this.rabatt = rabatt;
		this.kategorie = kategorie;
		this.marke = marke;
	}
	
	

	
	
	



	public void insertProduktDB(String produktNummer, String produktName, String beschreibungProdukt, double preis,
			int bestand, double rabatt, String kategorie, String marke) throws SQLException {
		
		String sql = "insert into produkt (produktNummer," 
		                                 + "produktName,"
		                                 + "beschreibungProdukt,"                             
		                                 + "preis,"
		                                 + "bestand,"
		                                 + "rabatt,"
		                                 + "kategorie,"
		                                 + "marke"
		                                 + ") values (?,?,?,?,?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.produktNummer);
		prep.setString(2, this.produktName);
		prep.setString(3, this.beschreibungProdukt);
		prep.setDouble(4, this.preis);
		prep.setInt(5, this.bestand);
		prep.setDouble(6, this.rabatt);
		prep.setString(7, this.kategorie);
		prep.setString(8, this.marke);

		prep.executeUpdate();
		System.out.println("Produkt " + this.produktNummer + " " + this.produktName + " erfolgreich angelegt");
		
	}
	public void updateProduktDB(int produktId,String produktNummer, String produktName, String beschreibungProdukt, double preis,
			int bestand, double rabatt, String kategorie, String marke) throws SQLException {
		
		String sql = "update produkt set produktNummer =?," 
		                                 + "produktName =?,"
		                                 + "beschreibungProdukt=?,"                             
		                                 + "preis =?,"
		                                 + "bestand =?,"
		                                 + "rabatt=?,"
		                                 + "kategorie=?,"
		                                 + "marke=?"
		                                 + ") where produktid = ?";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, produktNummer);
		prep.setString(2, produktName);
		prep.setString(3, beschreibungProdukt);
		prep.setDouble(4, preis);
		prep.setInt(5, bestand);
		prep.setDouble(6, rabatt);
		prep.setString(7, kategorie);
		prep.setString(8, marke);
		prep.setInt(9, produktId);

		prep.executeUpdate();
		System.out.println("Produkt " + this.produktNummer + " " + this.produktName + " updated successfully");
		
	}
	
	
	public void deleteProduktDB(int produktId) throws SQLException {
		
		String sql = "DELETE from produkt where id = ?";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setInt(1, produktId);
		

		prep.executeUpdate();
		
		System.out.println("Produkt deleted successfully");
		
	}
	
public void getAllProduktDB() throws SQLException {
		
	String sql = "select"
			+ "produktid " 
            + "produktName,"
            + "produktNummer"
            + "beschreibungProdukt,"                             
            + "preis,"
            + "bestand,"
            + "rabatt,"
            + "kategorie,"
            + "marke"
            + "from artikel";
		System.out.println(sql);
		ResultSet dbRes = new PostgreSQLAccess().getConnection().
				prepareStatement(sql).executeQuery();
		
		System.out.println("Produkt deleted successfully");
		while (dbRes.next()){
			this.produktlist.add(
				new Produkt(			
						dbRes.getInt("produktid"),
						dbRes.getString("produktName"),
						dbRes.getString("produktNummer"),
						dbRes.getString("beschreibungProdukt"),
						dbRes.getDouble("preis"),
						dbRes.getInt("bestand"),
						dbRes.getDouble("rabatt"),
						dbRes.getString("kategorie"),
						dbRes.getString("marke")
						
						
				)
			);
		}
		
	}
	
	
	
	

	public int getProduktId() {
		return produktId;
	}

	public void setProduktId(int produktId) {
		this.produktId = produktId;
	}

	public String getProduktName() {
		return produktName;
	}

	public void setProduktName(String produktName) {
		this.produktName = produktName;
	}

	public String getBeschreibungProdukt() {
		return beschreibungProdukt;
	}

	public void setBeschreibungProdukt(String beschreibungProdukt) {
		this.beschreibungProdukt = beschreibungProdukt;
	}

	public double getPreis() {
		return preis;
	}

	public void setPreis(double preis) {
		this.preis = preis;
	}

	public int getBestand() {
		return bestand;
	}

	public void setBestand(int bestand) {
		this.bestand = bestand;
	}

	public double getRabatt() {
		return rabatt;
	}

	public void setRabatt(double rabatt) {
		this.rabatt = rabatt;
	}

	public String getKategorie() {
		return kategorie;
	}

	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}

	public String getMarke() {
		return marke;
	}

	public void setMarke(String marke) {
		this.marke = marke;
	}

}
