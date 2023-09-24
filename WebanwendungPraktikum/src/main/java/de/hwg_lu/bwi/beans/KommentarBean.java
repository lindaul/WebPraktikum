package de.hwg_lu.bwi.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.hwg_lu.bwi.jdbc.NoConnectionException;
import de.hwg_lu.bwi.jdbc.PostgreSQLAccess;

public class KommentarBean {

	private int kommentarId;
	private String beschreibungKommentar;
	private String erstellungsdatum;
	private int bewertung;
	private int produktId;
	private int userId;

	ArrayList<KommentarBean> kommentarList;

	Connection dbConn;

	public KommentarBean(int kommentarId, String beschreibungKommentar, String erstellungsdatum, int bewertung,
			int produktId, int userId) throws SQLException {
		super();
		this.kommentarId = kommentarId;
		this.beschreibungKommentar = beschreibungKommentar;
		this.erstellungsdatum = erstellungsdatum;
		this.bewertung = bewertung;
		this.produktId = produktId;
		this.userId = userId;

		this.kommentarList = new ArrayList<>();
	}

	public void insertKommentarDB() throws SQLException {

		String sql = "insert into bwi520_633040_634997.kommentar (beschreibungKommentar," + "erstellungsdatum,"
				+ "bewertung," + "produktId," + "userId) values (?,current_date,?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.beschreibungKommentar);
		prep.setInt(2, this.bewertung);
		prep.setInt(3, this.produktId);
		prep.setInt(4, this.userId);

		prep.executeUpdate();
		System.out.println("Kommentar  erfolgreich angelegt");

	}

	public void updateProduktDB(int kommentarId, String beschreibungKommentar, String erstellungsdatum, int bewertung,
			Produkt produkt, UserBean user) throws SQLException {

		String sql = "update bwi520_633040_634997.kommentar set beschreibungKommentar =?," + "erstellungsdatum =?,"
				+ "bewertung =?," + "producktId =?," + "userId=?," + ") where kommentarId = ?";
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

		String sql = "DELETE from bwi520_633040_634997.kommentar where id = ?";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setInt(1, kommentarId);

		prep.executeUpdate();

		System.out.println("Produkt deleted successfully");

	}

	public void getAllKommentarDB() throws SQLException {

		String sql = "select " + "kommentarid, " + "beschreibungKommentar, " + "erstellungsdatum, " + "bewertung, "
				+ "produktId," + "userId" + " from kommentar";
		System.out.println(sql);
		ResultSet dbRes = new PostgreSQLAccess().getConnection().prepareStatement(sql).executeQuery();

		if (kommentarList == null) {
			kommentarList = new ArrayList<>();
		}
		System.out.println("Produkt selected successfully");
		while (dbRes.next()) {

			this.kommentarList.add(new KommentarBean(dbRes.getInt("kommentarid"),
					dbRes.getString("beschreibungKommentar"), dbRes.getString("erstellungsdatum"),
					dbRes.getInt("bewertung"), dbRes.getInt("produktId"), dbRes.getInt("userId")

			));
		}

	}

	public String getAllKommentar() throws SQLException {
		this.getAllKommentarDB();
		String html = "";

		for (KommentarBean komment : this.kommentarList) {

			html += "<tr>\n" + "<td>" + komment.getProduktId() + "</td>\n" + "<td>" + komment.getBeschreibungKommentar()
					+ "</td>\n" + "<td>" + komment.getBewertung() + "</td>\n" + "<td>" + komment.getErstellungsdatum()
					+ "</td>\n" + " </tr>";

		}

		return html;
	}

	public void setKommentarId(int kommentarId) {
		this.kommentarId = kommentarId;
	}

	public int getKommentarId() {
		return kommentarId;
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

	public int getProduktId() {
		return this.produktId;
	}

	public void setProducktId(int producktId) {
		this.produktId = producktId;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public KommentarBean() throws NoConnectionException {
		// TODO Auto-generated constructor stub

		this.dbConn = new PostgreSQLAccess().getConnection();
	}

}
