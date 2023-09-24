package de.hwg_lu.bwi.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.hwg_lu.bwi.jdbc.PostgreSQLAccess;

public class Produkt {

	private int produktId;
	private String produktName;
	private String produktNummer;
	
	private String beschreibungProdukt;
	private double preis;
	private int bestand;
	private double rabatt;
	private String kategorie;
	private String marke;
	
	private ArrayList<Produkt> produktlist;
	private ArrayList<Produkt> produktSelectedList;
	Connection dbConn;

	public Produkt() throws SQLException {
		this.produktlist = new  ArrayList<Produkt>();
		this.produktSelectedList = new ArrayList<Produkt>();
		this.getAllProduktDB();

	}

	public ArrayList<Produkt> getProduktSelectedList() {
		return produktSelectedList;
	}

	public void setProduktSelectedList(ArrayList<Produkt> produktSelectedList) {
		this.produktSelectedList = produktSelectedList;
	}

	public Produkt(int produktId,String produktName, String produktNummer, String beschreibungProdukt, double preis, int bestand,
			double rabatt, String kategorie, String marke) {
		super();
		this.produktId = produktId;
		this.produktName = produktName;
		this.produktNummer = produktNummer;
		
		this.beschreibungProdukt = beschreibungProdukt;
		this.preis = preis;
		this.bestand = bestand;
		this.rabatt = rabatt;
		this.kategorie = kategorie;
		this.marke = marke;
	
		
	}
	
	
	
	

	
	
	



	public Produkt(int produktId, String produktName, double preis, String kategorie) {
		super();
		this.produktId = produktId;
		this.produktName = produktName;
		
		this.preis = preis;
		this.kategorie = kategorie;
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
		
	String sql = "select "
			+ "produktid," 
            + "produktname,"
            + "produktnummer,"
            + "beschreibungprodukt,"                             
            + "preis, "
            + "bestand, "
            + "rabatt, "
            + "kategorie,"
            + "marke "
            + "from bwi520_633040_634997.produkt";
		System.out.println(sql);
		ResultSet dbRes = new PostgreSQLAccess().getConnection().
				prepareStatement(sql).executeQuery();
		
		System.out.println(dbRes + "Produkt selected successfully");
		while (dbRes.next()){
			this.produktlist.add(
				new Produkt(			
						dbRes.getInt("produktid"),
						dbRes.getString("produktname"),
						dbRes.getString("produktnummer"),
						dbRes.getString("beschreibungprodukt"),
						dbRes.getDouble("preis"),
						dbRes.getInt("bestand"),
						dbRes.getDouble("rabatt"),
						dbRes.getString("kategorie"),
						dbRes.getString("marke")
						
						
				)
			);
		}
		
	}

public void getOneProduktDB(int produktId) throws SQLException {
	
	String sql = "select "
			+ "produktid, "
			
            + "produktname,"
            + "produktnummer,"
            + "beschreibungprodukt,"                             
            + "preis, "
            + "bestand, "
            + "rabatt, "
            + "kategorie,"
            + "marke "
            + "from bwi520_633040_634997.produkt"
            + " where produktid =" + produktId;
		System.out.println(sql);
		ResultSet dbRes = new PostgreSQLAccess().getConnection().
				prepareStatement(sql).executeQuery();
		
		System.out.println(dbRes + "Produkt selected successfully");
		while (dbRes.next()){
			this.produktlist.add(
				new Produkt(			
						dbRes.getInt("produktid"),
						dbRes.getString("produktname"),
						dbRes.getString("produktnummer"),
						dbRes.getString("beschreibungprodukt"),
						dbRes.getDouble("preis"),
						dbRes.getInt("bestand"),
						dbRes.getDouble("rabatt"),
						dbRes.getString("kategorie"),
						dbRes.getString("marke")
						
						
				)
			);
		}
		
	}

public Produkt getOneProduktFromDB(int produktId) throws SQLException {
	
	Produkt produktNew = null ;
	String sql = "select "
			+ "produktid, "
			
            + "produktname,"
            + "produktnummer,"
            + "beschreibungprodukt,"                             
            + "preis, "
            + "bestand, "
            + "rabatt, "
            + "kategorie,"
            + "marke "
            + "from bwi520_633040_634997.produkt"
            + " where produktid =" + produktId;
		System.out.println(sql);
		ResultSet dbRes = new PostgreSQLAccess().getConnection().
				prepareStatement(sql).executeQuery();
		
		System.out.println(dbRes + "Produkt selected successfully");
		while (dbRes.next()){
	
			produktNew =	new Produkt(			
						dbRes.getInt("produktid"),
						dbRes.getString("produktname"),
						dbRes.getString("produktnummer"),
						dbRes.getString("beschreibungprodukt"),
						dbRes.getDouble("preis"),
						dbRes.getInt("bestand"),
						dbRes.getDouble("rabatt"),
						dbRes.getString("kategorie"),
						dbRes.getString("marke")
						
						
				);
			
			
		}
		
		return produktNew;
		
	}


public String getProduktWarenkorb() {
	
	String html = "";
	for (Produkt produkt : produktSelectedList) {
		
		html+= "<div class=\"row mb-4 d-flex justify-content-between align-items-center\">\n"
				+ "                    <div class=\"col-md-2 col-lg-2 col-xl-2\">\n"
				+ "                      <img\n"
				+ "                        src=\"https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-shopping-carts/img5.webp\"\n"
				+ "                        class=\"img-fluid rounded-3\" alt=\"Cotton T-shirt\">\n"
				+ "                    </div>\n"
				+ "                    <div class=\"col-md-3 col-lg-3 col-xl-3\">\n"
				+ "                      <h6 class=\"text-muted\">" + produkt.getKategorie() +"</h6>\n" 
				+ "                      <h6 class=\"text-black mb-0\">"+ produkt.getProduktName() + "</h6>\n"
				+ "                    </div>\n"
				+ "                    <div class=\"col-md-3 col-lg-3 col-xl-2 d-flex\">\n"
				+ "                    <form action=\"\" name=\"\" class=\"form-inline\">\n"
				+ "                \n"
				+ "                     <input id=\"form1\" min=\"0\" name=\"quantity\" value=\"1\" type=\"number\"\n"
				+ "                        class=\"form-control form-control-sm\" />\n"
				+ "                    \n"
				+ "                     \n"
				+ "                    \n"
				+ "                    </form>\n"
				+ "                   \n"
				+ "\n"
				+ "                     \n"
				+ "                    </div>\n"
				+ "                    <div class=\"col-md-3 col-lg-2 col-xl-2 offset-lg-1\">\n"
				+ "                      <h6 class=\"mb-0\">&euro;"+ produkt.getPreis()+"</h6>\n"
				+ "                    </div>\n"
				+ "                    <div class=\"col-md-1 col-lg-1 col-xl-1 text-end\">\n"
				+ "                      <a href=\"#!\" class=\"btn btn-sm btn-danger\">Remove</a>\n"
				+ "                    </div>\n"
				+ "                  </div>"
				+ "";
		
	}
	
	return html;
}





@Override
public String toString() {
	return "Produkt [produktId=" + produktId + ", produktName=" + produktName + ", produktNummer=" + produktNummer
			+ ", beschreibungProdukt=" + beschreibungProdukt + ", preis=" + preis + ", bestand=" + bestand + ", rabatt="
			+ rabatt + ", kategorie=" + kategorie + ", marke=" + marke + ", produktlist=" + produktlist + "]";
}

public String getProductCard() throws SQLException {
	String html = "";
	
	
	for (Produkt produkt : produktlist) {
		
		html += "<div class='col-md-3 py-3 py-md-0'>"
				+ "<div class='card' id=" + produkt.produktId +">"
				+ "<img src='../img/p6.png' alt=''>"
				+ "<div class='card-body'>"
				+ "<h3 class='text-center'>"+ produkt.produktName + "</h3>"
						+ " <p class='text-center'>" + produkt.beschreibungProdukt + "</p>"
								+ "<h2>" + produkt.preis + "&euro; <span>"
										+ " <form action='ShoppingCartAppl.jsp'>"
										+ "<button name='btnProduktid' value='" + produkt.produktId +"' type='submit' class='no-background-button'><li class='fa-solid fa-cart-shopping'></li></button></span></h2>"
										+ "</form>"
								+ "</div>"
								+ "</div>"
								+ "</div>";
	} 
	
	
	
          /*  <div class='star text-center'>
              <i class="fa-solid fa-star checked"></i>
              <i class="fa-solid fa-star checked"></i>
              <i class="fa-solid fa-star checked"></i>
              <i class="fa-solid fa-star checked"></i>
              <i class="fa-solid fa-star checked"></i>
            </div>*/
    
	return html;
      
}

public void addProdukttoProduktList(Produkt produkt){
	
	
	this.produktSelectedList.add(produkt);
	
	
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
