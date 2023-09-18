package de.hwg_lu.bwi.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.hwg_lu.bwi.jdbc.PostgreSQLAccess;

public class WarenkorbBean {
	
	private int warenkorbId;
	private String erstelldatum;
	private String bestelldatum;
	private String status;
	private UserBean user;
	
	Connection dbConn;
	
	ArrayList<WarenkorbBean> warenkorbList;
	
	public WarenkorbBean() {
		// TODO Auto-generated constructor stub
	}




	public WarenkorbBean(int warenkorbid, String erstelldatum, String bestelldatum, String status, int user) {
		// TODO Auto-generated constructor stub
		
	}
	
	public WarenkorbBean(int warenkorbId, String erstelldatum, String bestelldatum, String status, UserBean user) {
		super();
		this.warenkorbId = warenkorbId;
		this.erstelldatum = erstelldatum;
		this.bestelldatum = bestelldatum;
		this.status = status;
		this.user = user;
	}
	
	
	
	public void insertWarenkorbDB(String bestelldatum, String status, UserBean user) throws SQLException {
		
		String sql = "insert into warenkorb (bestelldatum," 
		                                 + "status,"
		                                 + "userId"                             
		                                 + ") values (?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, bestelldatum);
		prep.setString(2, status);
		prep.setInt(3, user.getUserid());
		

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
		
	String sql = "select"
			+ "warenkorbId " 
            + "bestelldatum,"
            + "status"
            + "userId"                             
            + "from warenkorb";
		System.out.println(sql);
		ResultSet dbRes = new PostgreSQLAccess().getConnection().
				prepareStatement(sql).executeQuery();
		
		System.out.println("Produkt deleted successfully");
		while (dbRes.next()){
			this.warenkorbList.add(
				new WarenkorbBean(			
						dbRes.getInt("warenkorbId"),
						dbRes.getString("erstelldatum"),
						dbRes.getString("bestelldatum"),
						dbRes.getString("status"),
						dbRes.getInt("userId")
						
						
				)
			);
		}
		
	}
	
	
	
	
	
	public int getWarenkorbId() {
		return warenkorbId;
	}


	public void setWarenkorbId(int warenkorbId) {
		this.warenkorbId = warenkorbId;
	}


	public String getBestelldatum() {
		return bestelldatum;
	}


	public void setBestelldatum(String bestelldatum) {
		this.bestelldatum = bestelldatum;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public UserBean getUser() {
		return user;
	}


	public void setUser(UserBean user) {
		this.user = user;
	}




	public String getErstelldatum() {
		return erstelldatum;
	}




	public void setErstelldatum(String erstelldatum) {
		this.erstelldatum = erstelldatum;
	}





	
	


	

}
