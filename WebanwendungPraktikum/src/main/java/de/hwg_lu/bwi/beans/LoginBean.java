package de.hwg_lu.bwi.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpSession;

import de.hwg_lu.bwi.jdbc.NoConnectionException;
import de.hwg_lu.bwi.jdbc.PostgreSQLAccess;

public class LoginBean {
	
	String email;
	String password;
	boolean loggedIn;
	String isAdmin;
	
	Produkt produkt;
	Connection 	dbConn;



	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

	public LoginBean() throws SQLException {
		super();
		this.setLoggedIn(false);
		this.email = "";
		this.password = "";
		this.isAdmin ="";
		this.dbConn = new PostgreSQLAccess().getConnection();
		this.produkt = new Produkt();
	}
	
	public void initialize() {
		
		this.email = "";
		this.password = "";
		
	}

	/*
	 * public String getLoginCheckRedirectHtml(){ String html = ""; if
	 * (!this.isLoggedIn()){ html =
	 * "<meta http-equiv='refresh' content='0; URL=./PortalAppl.jsp'>"; } return
	 * html; }
	 */
	
	public boolean checkUseridPassword() throws SQLException{
		//true: userid/pw Kombination existiert in der Datenbank
		//false: userid/pw Kombination existiert nicht in der Datenbank
		String sql = "select userid from bwi520_633040_634997.user where email = ? and passworduser = ?";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setString(1, this.email);
		prep.setString(2, this.password);
		ResultSet dbRes = prep.executeQuery();
		System.out.println("User and password  match");
		return dbRes.next();
	}
	
	public int  useridEingeloggt() throws SQLException{
		//true: userid/pw Kombination existiert in der Datenbank
		//false: userid/pw Kombination existiert nicht in der Datenbank
		int user = 0;
		String sql = "select userid from bwi520_633040_634997.user where email = ? and passworduser = ?";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setString(1, this.email);
		prep.setString(2, this.password);
		ResultSet dbRes = prep.executeQuery();
		while(dbRes.next()) {
			
			/*
			 * user = new UserBean( dbRes.getInt("userid"), dbRes.getString("vorname"),
			 * dbRes.getString("nachname"), dbRes.getString("email"),
			 * dbRes.getString("isadmin"));
			 */
			user  =  dbRes.getInt("userid");
		}
		return user;
	}
	
	public String  usernameEingeloggt() throws SQLException{
		//true: userid/pw Kombination existiert in der Datenbank
		//false: userid/pw Kombination existiert nicht in der Datenbank
		String vorname ="";
		String nachname="";
		String sql = "select vorname, nachname, isAdmin from bwi520_633040_634997.user where email = ? and passworduser = ?";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setString(1, this.email);
		prep.setString(2, this.password);
		ResultSet dbRes = prep.executeQuery();
		while(dbRes.next()) {
			vorname = dbRes.getString("vorname");
			nachname = dbRes.getString("nachname");
			this.setIsAdmin(dbRes.getString("isAdmin"));
			/*
			 * user = new UserBean( dbRes.getInt("userid"), dbRes.getString("vorname"),
			 * dbRes.getString("nachname"), dbRes.getString("email"),
			 * dbRes.getString("isadmin"));
			 */
			
		}
		return vorname + " " +nachname  + this.getIsAdmin();
	}
	
	
	public void logout(HttpSession session) {
		
		if(session!=null) {
			session.invalidate();
		}
		
	}
	
	public String getLoggedHeaderImage() {
		String html ="";
		
		
		if(!this.isLoggedIn()) {
			html += "<a href='loginView.jsp?logout=''><img src='../img/register.png' alt='' width='18px'>Login</a>\n"
					+ "            <a href='registerView.jsp'><img src='../img/register.png' alt='' width='18px'>Register</a>";
			
		}else {
			
			html += "<a href='LogoutAppl.jsp?logout=''> <img src='../img/register.png' alt='' width='18px'>Logout</a>\n";
			
		}
		
		return html;
		
		
	}
	
	
	public String getNavbar() throws NoConnectionException, SQLException {
		
		String html ="";
		
		if(!this.isLoggedIn()) {
			
			html+="<div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n"
					+ "    <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\n"
					+ "      <li class=\"nav-item\">\n"
					+ "        <a class=\"nav-link active\" aria-current=\"page\" href=\"index.jsp\">Home</a>\n"
					+ "      </li>\n"
					+ "      <li class=\"nav-item dropdown\">\n"
					+ "        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n"
					+ "          Category\n"
					+ "        </a>\n"
					+ "        <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\" style=\"background-color: rgb(67 0 86);\">\n";
	                 
			 html+=produkt.getCategory();
					html+="</ul>\n"
					+ "      </li>\n"
					+ "    \n"
					+ "    </ul>\n"
					+ "  </div>\n";
				
			
			
			
		}else if(this.isLoggedIn() && this.getIsAdmin().equals("Y")) {
			html+="<div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n"
					+ "    <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\n"
					+ "      <li class=\"nav-item\">\n"
					+ "        <a class=\"nav-link active\" aria-current=\"page\" href=\"index.jsp\">Home</a>\n"
					+ "      </li>\n"
					+ "      <li class=\"nav-item dropdown\">\n"
					+ "        <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdownProduct\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\n"
					+ "          Product\n"
					+ "        </a>\n"
					+ "        <ul class=\"dropdown-menu\" aria-labelledby=\"navbarDropdownProduct\" style=\"background-color: rgb(67 0 86);\">\n"
					+ "          <li><a class=\"dropdown-item\" href=\"Produkt.jsp\">Add Product</a></li>\n"
					+ "          <li><a class=\"dropdown-item\" href=\"#\">View Product List</a></li>\n"
					+ "        </ul>\n"
					+ "      </li>\n"
					+ "      \n"
					+ "      <li class=\"nav-item\">\n"
					+ "        <a class=\"nav-link\" href=\"Bestellung.jsp\"> All Orders </a>\n"
					+ "      </li>\n"
					+ "      <li class=\"nav-item\">\n"
					+ "        <a class=\"nav-link\" href=\"KommentarListeView.jsp\">All Products Review</a>\n"
					+ "      </li>\n"
					+ "    </ul>\n"
					+ "  </div>";
		
		}else
		{
			
			
			html="<div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\n"
					+ "  <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\n"
					+ "    <li class=\"nav-item\">\n"
					+ "      <a class=\"nav-link active\" aria-current=\"page\" href=\"index.jsp\">Home</a>\n"
					+ "    </li>\n"
					+ "\n"
					+ "    <li class=\"nav-item dropdown\">\n"
					+ "      <a\n"
					+ "        class=\"nav-link dropdown-toggle\"\n"
					+ "        href=\"#\"\n"
					+ "        id=\"navbarDropdown\"\n"
					+ "        role=\"button\"\n"
					+ "        data-bs-toggle=\"dropdown\"\n"
					+ "        aria-expanded=\"false\"\n"
					+ "      >\n"
					+ "        Category\n"
					+ "      </a>\n"
					+ "      <ul\n"
					+ "        class=\"dropdown-menu\"\n"
					+ "        aria-labelledby=\"navbarDropdown\"\n"
					+ "        style=\"background-color: rgb(67 0 86)\"\n"
					+ "      >\n";
			                         html+=produkt.getCategory();
					html+= "      </ul>\n"
					+ "    </li>\n"
					+ "    <li class=\"nav-item\">\n"
					+ "      <a class=\"nav-link\" href=\"BestellungAppl.jsp\">Meine Bestellungen</a>\n"
					+ "    </li>\n"
					+ "  </ul>\n"
					+ "</div>\n"
					+ "";
		}
		return html;
		
		
	}
	
	public String getWelcomeMessage() throws SQLException {
		String html ="";
		
		
		
		
		if(!this.isLoggedIn()) {
			html +="<p>WELCOME TO QEMSOH ELECTRONICS SHOP</p>";
			
		}else {
			
			html +="<p>WELCOME "+ this.usernameEingeloggt() + "</p> ";
			
		}
		
		return html;
		
		
	}

	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public boolean isLoggedIn() {
		return loggedIn;
	}



	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	
	public String getIsAdmin() {
		return isAdmin;
	}




}
