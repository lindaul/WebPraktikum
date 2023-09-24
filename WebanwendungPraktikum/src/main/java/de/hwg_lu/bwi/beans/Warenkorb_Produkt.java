package de.hwg_lu.bwi.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.hwg_lu.bwi.jdbc.NoConnectionException;
import de.hwg_lu.bwi.jdbc.PostgreSQLAccess;

public class Warenkorb_Produkt {

	private int menge;
	private int produktid;
	private int warenkorbId;

	private String produktName;
	private String produktKategorie;
	private double preisProdukt;
	private double gesamtPreis;
	private String status;
	
	private int userid;
	
	

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	public ArrayList<Warenkorb_Produkt> getProduktFromWarenkorb() {
		return produktFromWarenkorb;
	}

	public void setProduktFromWarenkorb(ArrayList<Warenkorb_Produkt> produktFromWarenkorb) {
		this.produktFromWarenkorb = produktFromWarenkorb;
	}

	ArrayList<Warenkorb_Produkt> produktFromWarenkorb;
	

	int count = 0;
	double gesamtSumme = 0.0;

	Connection dbConn;

	public int getProduktid() {
		return produktid;
	}

	public void setProduktid(int produktid) {
		this.produktid = produktid;
	}

	public String getProduktName() {
		return produktName;
	}

	public void setProduktName(String produktName) {
		this.produktName = produktName;
	}

	public String getProduktKategorie() {
		return produktKategorie;
	}

	public void setProduktKategorie(String produktKategorie) {
		this.produktKategorie = produktKategorie;
	}

	public double getPreisProdukt() {
		return preisProdukt;
	}

	public void setPreisProdukt(double preisProdukt) {
		this.preisProdukt = preisProdukt;
	}

	public double getGesamtPreis() {
		return gesamtPreis;
	}

	public void setGesamtPreis(double gesamtPreis) {
		this.gesamtPreis = gesamtPreis;
	}

	public int getMenge() {
		return menge;
	}

	public void setMenge(int menge) {
		this.menge = menge;
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
	
	
	public Warenkorb_Produkt(int produktid, int warenkorbId, String produktName, String produktKategorie, int menge, 
			double preisProdukt, double gesamtPreis) {
		super();
		this.menge = menge;
		this.produktid = produktid;
		this.warenkorbId = warenkorbId;
		this.produktName = produktName;
		this.produktKategorie = produktKategorie;
		this.preisProdukt = preisProdukt;
		this.gesamtPreis = gesamtPreis;
		produktFromWarenkorb = new ArrayList<>();
	}

	public Warenkorb_Produkt(int produktid, String produktName, String produktKategorie, int menge, double preisProdukt,
			double gesamtPreis) {
		super();
		this.menge = menge;
		this.produktid = produktid;
		this.produktName = produktName;
		this.produktKategorie = produktKategorie;
		this.preisProdukt = preisProdukt;
		this.gesamtPreis = gesamtPreis;
		produktFromWarenkorb = new ArrayList<>();
	}
	
	public Warenkorb_Produkt(int produktid, String produktName, String produktKategorie, int menge, double preisProdukt,
			double gesamtPreis, String status) {
		super();
		this.menge = menge;
		this.produktid = produktid;
		this.produktName = produktName;
		this.produktKategorie = produktKategorie;
		this.preisProdukt = preisProdukt;
		this.gesamtPreis = gesamtPreis;
		this.status = status;
		produktFromWarenkorb = new ArrayList<>();
	}

	public Warenkorb_Produkt() throws NoConnectionException {
		// TODO Auto-generated constructor stub
		this.dbConn = new PostgreSQLAccess().getConnection();
		produktFromWarenkorb = new ArrayList<>();
	}


	public void addProdukttoWarenkorb(WarenkorbBean warenkorb, ArrayList<Produkt> produkts) throws SQLException {

		String sql = "INSERT INTO warenkorb_produkt (warenkorbid, produktid, menge) VALUES (?, ?,1)";

		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		int warenkorbId = warenkorb.getWarenkorbId(); // Oobtain id of warenkorb of a user
		for (Produkt prod : produkts) {
			int produitId = prod.getProduktId(); // id of produkt to be added

			prep.setInt(1, warenkorbId);
			prep.setInt(2, produitId);
			prep.setInt(3, 1);

			prep.executeUpdate();

			// Autres méthodes pour gérer les produits du panier
		}
	}

	public void updateProdukttoWarenkorb(WarenkorbBean warenkorb, ArrayList<Produkt> produkts) throws SQLException {

		String sql = "update produit_panier (panier_id, produit_id) VALUES (?, ?)";

		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		int warenkorbId = warenkorb.getWarenkorbId(); // Obtenez l'ID du panier de l'utilisateur
		for (Produkt prod : produkts) {
			int produitId = prod.getProduktId(); // Obtenez l'ID du produit à ajouter

			prep.setInt(1, warenkorbId);
			prep.setInt(2, produitId);

			prep.executeUpdate();

			// Autres méthodes pour gérer les produits du panier
		}
	}

	public void insertProdukttoWarenkorb(int userid, int produktid) throws SQLException {

		// check if user already has a shopping cart with an open status

		String selectWarenkorbSql = "SELECT warenkorbid FROM warenkorb WHERE userid = ? AND status = 'In bearbeitung'";
		System.out.println(selectWarenkorbSql);
		PreparedStatement prep = this.dbConn.prepareStatement(selectWarenkorbSql);
		prep.setInt(1, userid);
		ResultSet dbRes = prep.executeQuery();

		int warenkorbId;

		if (dbRes.next()) {
			warenkorbId = dbRes.getInt("warenkorbId");
			this.warenkorbId = dbRes.getInt("warenkorbId");
		} else {
			// if the user doesnot have an open warenkorb open one
			String insertWarenkorbSql = "INSERT INTO warenkorb (status,userid) VALUES ('In bearbeitung', ?)";
			System.out.println(insertWarenkorbSql);
			PreparedStatement insertWarenkorbprep = this.dbConn.prepareStatement(insertWarenkorbSql,
					prep.RETURN_GENERATED_KEYS);
			insertWarenkorbprep.setInt(1, userid);
			insertWarenkorbprep.executeUpdate();

			ResultSet generatedKeys = insertWarenkorbprep.getGeneratedKeys();

			if (generatedKeys.next()) {
				warenkorbId = generatedKeys.getInt(1);
				this.warenkorbId = dbRes.getInt("warenkorbId");
				
			} else {
				throw new SQLException("No Id generated for the warenkorb");
			}
		}

		// check if produkts exist in warenkorb

		String selectProduktWarenkorbSql = "SELECT menge FROM warenkorb_produkt WHERE warenkorbid = ? AND produktid = ?";
		PreparedStatement selectProduktWarenkorb = this.dbConn.prepareStatement(selectProduktWarenkorbSql);
		selectProduktWarenkorb.setInt(1, this.warenkorbId);
		selectProduktWarenkorb.setInt(2, produktid);
		ResultSet warenkorbProduktResultSet = selectProduktWarenkorb.executeQuery();

		if (warenkorbProduktResultSet.next()) {
			// if produkt exist in shopping cart increment quantity
			int mengeALt = warenkorbProduktResultSet.getInt("menge");
			int mengeNeu = mengeALt + 1;

			String updateMengeSql = "UPDATE warenkorb_produkt SET menge = ? WHERE warenkorbid = ? AND produktid = ?";
			PreparedStatement updateMengeStatement = this.dbConn.prepareStatement(updateMengeSql);
			updateMengeStatement.setInt(1, mengeNeu);
			updateMengeStatement.setLong(2, this.warenkorbId);
			updateMengeStatement.setLong(3, produktid);
			updateMengeStatement.executeUpdate();
		} else {
			// Produkt does not exist in warenkorb
			String insertProduitPanierSql = "INSERT INTO warenkorb_produkt (warenkorbid, produktid, menge) VALUES (?, ?, 1)";
			PreparedStatement insertProduitPanierStatement = this.dbConn.prepareStatement(insertProduitPanierSql);
			insertProduitPanierStatement.setLong(1, this.warenkorbId);
			insertProduitPanierStatement.setLong(2, produktid);
			insertProduitPanierStatement.executeUpdate();
		}
	}

	
	public void getProduktFromWarenkorbHTML() throws SQLException {

		// select produkt from a warenkorb with status open
		ArrayList<Warenkorb_Produkt> produktList ;
		count=0;
		gesamtSumme =0;
		
		this.produktFromWarenkorb.clear();
		
		String html = "";

		String selectProduktSql = ""
				+ " select p.produktid, p.produktname, p.kategorie, p.preis, bwi520_633040_634997.warenkorb_produkt.menge as menge, bwi520_633040_634997.warenkorb_produkt.warenkorbid as warenkorbid ,(p.preis *  bwi520_633040_634997.warenkorb_produkt.menge) AS gesamtPreis "
				+ " from bwi520_633040_634997.warenkorb"
				+ " inner join bwi520_633040_634997.warenkorb_produkt on warenkorb.warenkorbid = bwi520_633040_634997.warenkorb_produkt.warenkorbid "
				+ " inner join bwi520_633040_634997.produkt p on bwi520_633040_634997.warenkorb_produkt.produktid = p.produktid"
				+ " where bwi520_633040_634997.warenkorb.userid= ? and bwi520_633040_634997.warenkorb.status='In bearbeitung'";

		String createViewSql = "CREATE VIEW warenkorb_View AS "
				+ "SELECT p.produktid AS produkt_id, p.produktname AS produkt_name, p.preis AS produkt_preis, p.kategorie As kategorie, "
				+ "wp.menge AS Menge, (p.preis * wp.menge) AS gesamtPreis " + "FROM warenkorb_produkt wp "
				+ "JOIN produkt p ON wp.produktId = p.produktid "
				+ "where warenkorb.userid = ? and warenkorb.status='bearbeitung'";
		PreparedStatement prep = this.dbConn.prepareStatement(selectProduktSql);
		prep.setInt(1, this.userid);

		
		ResultSet dbRes = prep.executeQuery();

		while (dbRes.next()) {
			count++;
			 int prodId = dbRes.getInt("produktid");
			    boolean produktExist= false;
			
			gesamtSumme = gesamtSumme + dbRes.getDouble("gesamtPreis");
			
			 for (Warenkorb_Produkt produit : this.produktFromWarenkorb) {
			        if (produit.getProduktid() == prodId) {
			            
			        	
			        	// Produkt already exist in list
			   
			        	produktExist = true;
			            break;
			        }
			    }
			
			this.produktFromWarenkorb.add(
					new Warenkorb_Produkt(
							dbRes.getInt("produktid"),
							dbRes.getInt("warenkorbid"),
							dbRes.getString("produktname"), 
							dbRes.getString("kategorie"),
							dbRes.getInt("menge"),
					        dbRes.getDouble("preis"), 
					        dbRes.getDouble("gesamtPreis")

			)

			);

		}
		
		

		
		//System.out.println(produktList.size());
		
		
		
		
		
			
		

		System.out.println(count);

	

	}
	
	public String getSummary(){
		
		String html ="";
		
		html+="<div class=\"col-lg-4 bg-grey\">\n"
				+ "                <div class=\"p-5\">\n"
				+ "                  <h3 class=\"fw-bold mb-5 mt-2 pt-1\">Summary</h3>\n"
				+ "                  <hr class=\"my-4\">\n"
				+ "\n"
				+ "                  <div class=\"d-flex justify-content-between mb-4\">\n"
				+ "                    <h5 class=\"text-uppercase\">items " + count +"</h5>\n"
				+ "                    <h5>&euro; "+gesamtSumme+"</h5>\n"
				+ "                  </div>\n"
				+ "\n"
				+ "                 \n"
				+ "                  <hr class=\"my-4\">\n"
				+ "\n"
				+ "                  <div class=\"d-flex justify-content-between mb-5\">\n"
				+ "                    <h5 class=\"text-uppercase\">Total price</h5>\n"
				+ "                    <h5>&euro; "+gesamtSumme+"</h5>\n"
				+ "                  </div>\n"
				+ "\n"
				+ "                  <a href='./BestellungAppl.jsp?bestellen=bestellen' class='btn btn-primary'>Bestellen</a>\n"
				+ "\n"
				+ "                </div>\n"
				+ "              </div>";
		
		return html;
		
	}
	
	public String getHeaderSummary(){
		String html="";
		html+=" <div class=\"d-flex justify-content-between align-items-center mb-5\">\n"
				+ "                    <h1 class=\"fw-bold mb-0 text-black\">Shopping Cart</h1>\n"
				+ "                    <h6 class=\"mb-0 text-muted\">" + count + " items</h6>\n"
				+ "                  </div>";
		return html;
		
	}
	
public String getShoppingCart() {
		String html ="";
		
		html="";
for (Warenkorb_Produkt produkt : produktFromWarenkorb) {
			
			System.out.println("J'entre dans la boucle produit");
			
			

			
			html+="<div class=\"row mb-4 d-flex justify-content-between align-items-center\">\n"
					+ "                    <div class=\"col-md-2 col-lg-2 col-xl-2\">\n"
					+ "                      <img\n"
					+ "                        src=\"https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-shopping-carts/img5.webp\"\n"
					+ "                        class=\"img-fluid rounded-3\" alt=\"Cotton T-shirt\">\n"
					+ "                    </div>\n"
					+ "                    <div class=\"col-md-3 col-lg-3 col-xl-3\">\n"
					+ "                      <h6 class=\"text-muted\">"+ produkt.getProduktKategorie() +"</h6>\n"
					+ "                      <h6 class=\"text-black mb-0\">"+ produkt.getProduktName() + "</h6>\n"
					+ "                    </div>\n"
					+ "                    <div class=\"col-md-3 col-lg-3 col-xl-2 d-flex\">\n"
					+ "                      \n"
					+ "\n"
					+ "                      <input id=\"form1\" min=\"0\" name=\"quantity\" value="+ produkt.getMenge() +" type=\"number\"\n"
					+ "                        class=\"form-control form-control-sm\" />\n"
					+ "\n"
					+ "                      \n"
					+ "                    </div>\n"
					+ "                    <div class=\"col-md-3 col-lg-2 col-xl-2 offset-lg-1\">\n"
					+ "                      <h6 class=\"mb-0\">&euro;"+  produkt.getMenge() * produkt.getPreisProdukt()+"</h6>\n"
					+ "                    </div>\n"
					+ "                    <div class=\"col-md-1 col-lg-1 col-xl-1 text-end\">\n"
					+ "                      <a href='ShoppingCartAppl.jsp?removeProdukt=" + produkt.produktid + "&bestellen='' class=\"btn btn-sm btn-danger\"> Remove</a>\n"
					+ "                    </div>\n"
					+ "                  </div>\n"
					+ "";
			
		}

return html;
	}

public void deleteproduktInWarenkorb(int produktId) throws SQLException {
	

		
		String sql = "DELETE FROM bwi520_633040_634997.warenkorb_produkt "
				+ "WHERE warenkorbid IN ( "
				+ "    SELECT warenkorbid "
				+ "    FROM bwi520_633040_634997.warenkorb "
				+ "    WHERE userid = ?"
				+ "    AND status = 'In bearbeitung' "
				+ ")"
				+ "AND produktid = ?"
				+ "";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setInt(1, this.userid);
		prep.setInt(2, produktId);
	
		

		prep.executeUpdate();
		
		System.out.println("Produkt remove successfully from shopping cart");
		
	
	
}



public String getBestellungListe() throws SQLException {
	count=0;
	gesamtSumme =0;
	String html ="";

	ArrayList<Warenkorb_Produkt> produktUpdatedWarenkorb = new ArrayList<>();
	//this.produktFromWarenkorb.clear();
	

	String selectProduktSql = ""
			+ " select p.produktid, p.produktname, p.kategorie, p.preis, bwi520_633040_634997.warenkorb_produkt.menge as menge, bwi520_633040_634997.warenkorb_produkt.warenkorbid as warenkorbid ,(p.preis *  bwi520_633040_634997.warenkorb_produkt.menge) AS gesamtPreis "
			+ " from bwi520_633040_634997.warenkorb"
			+ " inner join bwi520_633040_634997.warenkorb_produkt on warenkorb.warenkorbid = bwi520_633040_634997.warenkorb_produkt.warenkorbid "
			+ " inner join bwi520_633040_634997.produkt p on bwi520_633040_634997.warenkorb_produkt.produktid = p.produktid"
			+ " where bwi520_633040_634997.warenkorb.userid= ? and bwi520_633040_634997.warenkorb.status='Bestellt'";
	
	
	
	
	PreparedStatement prep = this.dbConn.prepareStatement(selectProduktSql);
	prep.setInt(1, this.getUserid());

	
	ResultSet dbRes = prep.executeQuery();

	while (dbRes.next()) {
		count++;
		 int prodId = dbRes.getInt("produktid");
		    boolean produktExist= false;
		
		gesamtSumme = gesamtSumme + dbRes.getDouble("gesamtPreis");
		
		 for (Warenkorb_Produkt produit : this.produktFromWarenkorb) {
		        if (produit.getProduktid() == prodId) {
		            
		        	
		        	// Produkt already exist in list
		   
		        	produktExist = true;
		            break;
		        }
		    }
		
		 produktUpdatedWarenkorb.add(
				new Warenkorb_Produkt(
						dbRes.getInt("produktid"),
						dbRes.getInt("warenkorbid"),
						dbRes.getString("produktname"), 
						dbRes.getString("kategorie"),
						dbRes.getInt("menge"),
				        dbRes.getDouble("preis"), 
				        dbRes.getDouble("gesamtPreis")
				        
				       

		)

		);
		
		
		

	}
	
	System.out.println(count + "size arraylist" + produktUpdatedWarenkorb.size());
	for (Warenkorb_Produkt produkt : produktUpdatedWarenkorb) {
		html+="<tr>\n"
				+ "                        <td> <img\n"
				+ "	src='https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-shopping-carts/img5.webp'"
				+ "    class=img-fluid rounded-3 alt=Cotton T-shirt></td>\n"
				+ "                        <td>"+produkt.getProduktName()+"</td>\n"
				+ "                        <td>"+produkt.getProduktKategorie()+"</td>\n"
				+ "                        <td>"+produkt.getPreisProdukt()+"</td>\n"
				+ "                        <td>"+produkt.getMenge()+"</td>\n"
				+ "                        <td>"+produkt.getGesamtPreis()+"</td>\n"
				+ "                        <td><a href=\"\" class=\"btn btn-sm btn-danger\">Kommentar Schreiben</a> </td>\n"
				+ "                      </tr>";
	}

	   
	
	
	return html;
}


public void updateStatusprodukt() throws SQLException {
	
	System.out.println(this.getWarenkorbId());
	
	String selectProduktSql = ""
			+ " select userid, status"
			+ " from bwi520_633040_634997.warenkorb"
			+ " where bwi520_633040_634997.warenkorb.warenkorbid= ? and bwi520_633040_634997.warenkorb.status='In bearbeitung'";
	
	PreparedStatement prep = this.dbConn.prepareStatement(selectProduktSql);
	prep.setInt(1, this.getWarenkorbId());
	ResultSet dbRes = prep.executeQuery();
	
	
	
	while(dbRes.next()) {
		System.out.println("il y a au moins 1 element dans le panier");
		String updateProduktSql = ""
				+ " update  bwi520_633040_634997.warenkorb"
				+ "  set status='Bestellt'"
				+ " where bwi520_633040_634997.warenkorb.warenkorbid= ?" ;
		
		PreparedStatement prepUpdate= this.dbConn.prepareStatement(updateProduktSql);
		prepUpdate.setInt(1, this.getWarenkorbId());
		prepUpdate.executeUpdate();
		
		int rowsupdate = prepUpdate.executeUpdate();
		
		if (rowsupdate > 0) {
	        System.out.println("Warenkorb status updated successfully");
	    } else {
	        System.out.println("No rows updated. Warenkorb status not changed.");
	    }
		
		
		
	}
	
	
	
}

public String getBestellungenWarenkorb() {
	
	
	String html ="";
	
	for (Warenkorb_Produkt produkt : produktFromWarenkorb) {
		
		html+="<tr>\n"
				+ "                        <td> <img\n"
				+ "	src='https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-shopping-carts/img5.webp'"
				+ "    class=img-fluid rounded-3 alt=Cotton T-shirt></td>\n"
				+ "                        <td>"+produkt.getProduktName()+"</td>\n"
				+ "                        <td>"+produkt.getProduktKategorie()+"</td>\n"
				+ "                        <td>"+produkt.getPreisProdukt()+"</td>\n"
				+ "                        <td>"+produkt.getMenge()+"</td>\n"
				+ "                        <td>"+produkt.getGesamtPreis()+"</td>\n"
				+ "                        <td><a href=\"\" class=\"btn btn-sm btn-danger\">Kommentar Schreiben</a> </td>\n"
				+ "                      </tr>";
		
		
		
		
	}
	
	
	
	
	
	
	
	
	return html;



}











	public ArrayList<Warenkorb_Produkt> getProduktWarenkorbList(int user) throws SQLException {
		  
		  
		String selectProduktSql = ""
				+ " select p.produktid, p.produktname, p.kategorie, p.preis, bwi520_633040_634997.warenkorb_produkt.menge as menge,(p.preis *  bwi520_633040_634997.warenkorb_produkt.menge) AS gesamtPreis "
				+ " from bwi520_633040_634997.warenkorb"
				+ " inner join bwi520_633040_634997.warenkorb_produkt on warenkorb.warenkorbid = bwi520_633040_634997.warenkorb_produkt.warenkorbid "
				+ " inner join bwi520_633040_634997.produkt p on bwi520_633040_634997.warenkorb_produkt.produktid = p.produktid"
				+ " where bwi520_633040_634997.warenkorb.userid= ? and bwi520_633040_634997.warenkorb.status='In bearbeitung'";
		
		PreparedStatement prep = this.dbConn.prepareStatement(selectProduktSql);
		prep.setInt(1, user);

		
		ResultSet dbRes = prep.executeQuery();

		while (dbRes.next()) {
			count++;

		}
while (dbRes.next()) {
	
	count++;
			
			this.produktFromWarenkorb.add(new Warenkorb_Produkt(dbRes.getInt("produktid"),
					dbRes.getString("produktname"), dbRes.getString("kategorie"), dbRes.getInt("menge"),
					dbRes.getDouble("preis"), dbRes.getDouble("gesamtPreis")

			)

			);

		  
		  //produktFromWarenkorb =  getProduktFromWarenkkorb(user);
		
			
		  
		  
	  }

System.out.println(" ca s'est le count de la liste" + count);
return produktFromWarenkorb;
}
	
}
