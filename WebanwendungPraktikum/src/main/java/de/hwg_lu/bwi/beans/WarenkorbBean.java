package de.hwg_lu.bwi.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.hwg_lu.bwi.jdbc.NoConnectionException;
import de.hwg_lu.bwi.jdbc.PostgreSQLAccess;

public class WarenkorbBean {

	private int warenkorbId;
	private String status;
	private int userid;
	

	Connection dbConn;

	ArrayList<WarenkorbBean> warenkorbList;
	ArrayList<Produkt> produktList;

	public WarenkorbBean() throws NoConnectionException {
		// TODO Auto-generated constructor stub
		this.dbConn = new PostgreSQLAccess().getConnection();
		produktList = new ArrayList<Produkt>();
	}

	public WarenkorbBean(int warenkorbid, String status, int user) {
		// TODO Auto-generated constructor stub
		super();
		this.warenkorbId = warenkorbid;
		this.userid = user;

	}
	

	



	public boolean insertcheckWarenkorbDB(int userid) throws SQLException {

		boolean insertCorrectly = false;
		boolean warenkorbExists = checkWarenkorbUserExists(userid);
		if (warenkorbExists == true) {

			insertCorrectly = true;
			System.out.println("Warenkorb schon exist");

		} else {

			insertNocheckWarenkorb();
		}

		return insertCorrectly;

	}

	public void insertNocheckWarenkorb() throws SQLException {
		String sql = "insert into warenkorb (status," + "userId"
				+ ") values (?,?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		
		prep.setString(3, this.status);
		prep.setInt(4, this.userid);

		prep.executeUpdate();
		System.out.println("Warenkorb   erfolgreich angelegt");

	}

	public void deleteWarenkorbDB(int warenkorbId) throws SQLException {

		String sql = "DELETE from warenkorb where id = ?";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setInt(1, warenkorbId);

		prep.executeUpdate();

		System.out.println("Warenkorb deleted successfully");

	}

	public void getAllWarenkorbDB() throws SQLException {

		String sql = "select" + "warenkorbId "  + "status" + "userId" + "from warenkorb";
		System.out.println(sql);
		ResultSet dbRes = new PostgreSQLAccess().getConnection().prepareStatement(sql).executeQuery();

		System.out.println("Produkt deleted successfully");
		while (dbRes.next()) {
			this.warenkorbList.add(new WarenkorbBean(dbRes.getInt("warenkorbId"),
					 dbRes.getString("status"), dbRes.getInt("userId")

			));
		}

	}

	/* check if an open warenkorb exists for user with */
	private boolean checkWarenkorbUserExists(int userId) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select warenkorbid from bwi520_633040_634997.warenkorb where userid = ? and status='bearbeitung' ";
		// String sql = "select count(*) from user ";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setInt(1, userId);

		ResultSet dbRes = prep.executeQuery();
		while (dbRes.next()) {
			this.warenkorbId = dbRes.getInt("warenkorbid");

		}
		boolean gefunden = dbRes.next();
		System.out.println("gefunden" + gefunden);
		return gefunden;
	}
	
	public int getWarenkorbDBId(int userId) throws SQLException {
		
		
		int warenkorbid = 0;
		String sql = "select warenkorbid,"   + "status" + "userId" +  "from bwi520_633040_634997.warenkorb where userid = ? and status='bearbeitung' ";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setInt(1, userId);
		
		ResultSet dbRes = prep.executeQuery();
		while (dbRes.next()) {
			this.warenkorbId = dbRes.getInt("warenkorbid");
			this.status = dbRes.getString("status");
			warenkorbid = dbRes.getInt("warenkorbid");

		}
		
		
		return  warenkorbid;
		
		
	}
	
public WarenkorbBean getOneWarenkorbDB(int userId) throws SQLException {
		
		WarenkorbBean warenkorb = null;
		
		String sql = "select warenkorbid, status" + "userId" +  "from bwi520_633040_634997.warenkorb where userid = ? and status='bearbeitung' ";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setInt(1, userId);
		
		ResultSet dbRes = prep.executeQuery();
		while (dbRes.next()) {
			warenkorb = new WarenkorbBean(
					    dbRes.getInt("warenkorbid"), 
					    dbRes.getString("status"),
					    dbRes.getInt("userid"));
			

		}
		
		
		return  warenkorb;
		
		
	}
	

	public int getWarenkorbId() {
		return warenkorbId;
	}

	public void setWarenkorbId(int warenkorbId) {
		this.warenkorbId = warenkorbId;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	

}
