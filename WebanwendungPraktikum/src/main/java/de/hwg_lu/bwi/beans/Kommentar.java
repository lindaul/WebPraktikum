package de.hwg_lu.bwi.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.hwg_lu.bwi.jdbc.PostgreSQLAccess;

public class Kommentar {

	private String kommentarId;
	private String beschreibungKommentar;
	private String erstellungsdatum;
	private int bewertung;
	private Produkt produckt;
	private UserBean user;

	ArrayList<Kommentar> kommentarList;

	Connection dbConn;

	public void insertKommentarDB() throws SQLException {

		String sql = "insert into kommentar (beschreibungKommentar," + "erstellungsdatum," + "bewertung,"
				+ "producktId," + "userId," + ") values (?,?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.beschreibungKommentar);
		prep.setString(2, this.erstellungsdatum);
		prep.setInt(3, this.bewertung);
		prep.setInt(4, this.produckt.getProduktId());
		prep.setInt(5, this.user.getUserid());

		prep.executeUpdate();
		System.out.println("Kommentar  erfolgreich angelegt");

	}

	public void updateProduktDB(int kommentarId, String beschreibungKommentar, String erstellungsdatum, int bewertung,
			Produkt produkt, UserBean user) throws SQLException {

		String sql = "update produkt set beschreibungKommentar =?," + "erstellungsdatum =?," + "bewertung =?,"
				+ "producktId =?," + "userId=?," + ") where kommentarId = ?";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, beschreibungKommentar);
		prep.setString(2, erstellungsdatum);
		prep.setInt(3, bewertung);
		prep.setInt(5, produkt.getProduktId());
		prep.setInt(9, user.getUserid());

		prep.executeUpdate();
		System.out.println("Kommentar updated successfully");

	}

	public void deleteKommentarDB(int kommentarId) throws SQLException {

		String sql = "DELETE from produkt where id = ?";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setInt(1, kommentarId);

		prep.executeUpdate();

		System.out.println("Produkt deleted successfully");

	}

	public void getAllKommentarDB() throws SQLException {

		String sql = "select" 
		           + "beschreibungKommentar " 
				   + "erstellungsdatum," 
		           + "bewertung"  
		           + "producktId,"
				   + "userId"  
				   + " from kommentar";
		System.out.println(sql);
		ResultSet dbRes = new PostgreSQLAccess().getConnection().prepareStatement(sql).executeQuery();

		System.out.println("Produkt selected successfully");
		while (dbRes.next()) {
			
			this.kommentarList.add(
					new Kommentar(   
						   dbRes.getString("beschreibungKommentar"),
					       dbRes.getString("erstellungsdatum"),
					       dbRes.getString("bewertung"),
					       dbRes.getDouble("rabatt"),
					       dbRes.getInt("produktId"),
					       dbRes.getInt("userId")

			));
		}

	}

	public String getKommentarId() {
		return kommentarId;
	}

	public void setKommentarId(String kommentarId) {
		this.kommentarId = kommentarId;
	}

	public String getBeschreibungKommentar() {
		return beschreibungKommentar;
	}

	public void setBeschreibungKommentar(String beschreibungKommentar) {
		this.beschreibungKommentar = beschreibungKommentar;
	}

	public String getErstellungsdatum() {
		return erstellungsdatum;
	}

	public void setErstellungsdatum(String erstellungsdatum) {
		this.erstellungsdatum = erstellungsdatum;
	}

	public int getBewertung() {
		return bewertung;
	}

	public void setBewertung(int bewertung) {
		this.bewertung = bewertung;
	}

	public Produkt getProduckt() {
		return this.produckt;
	}

	public void setProducktId(Produkt producktId) {
		this.produckt = produckt;
	}

	public UserBean getUserId() {
		return this.user;
	}

	public void setUserId(UserBean userId) {
		this.user = userId;
	}

	public Kommentar() {
		// TODO Auto-generated constructor stub
	}

	public Kommentar(String string, String string2, String string3, double double1, int int1, int int2) {
		// TODO Auto-generated constructor stub
	}

}
