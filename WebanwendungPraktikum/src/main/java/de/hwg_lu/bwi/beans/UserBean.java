package de.hwg_lu.bwi.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.hwg_lu.bwi.jdbc.NoConnectionException;
import de.hwg_lu.bwi.jdbc.PostgreSQLAccess;

public class UserBean {

	private int userid;
	private String vorname;
	private String nachname;
	private String email;
	private String password;
	private String isAdmin;
	private int telefonnumer;
	
	private ArrayList<UserBean> userList;

	Connection dbConn;

	public UserBean() throws NoConnectionException {
		// TODO Auto-generated constructor stub
		this.userList = new ArrayList<UserBean>();
		this.dbConn = new PostgreSQLAccess().getConnection();
		//initialize();
	}

	public UserBean(int userid, String vorname, String nachname, String email, String isAdmin) {
		// TODO Auto-generated constructor stub
		this.userid = userid;
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
		this.isAdmin = isAdmin;
	}

	public void initialize() {
		this.vorname = "";
		this.nachname ="";
		this.password = "";
		this.email = "";
		this.password = "";
		this.isAdmin = "";
	}

	public static boolean isEmailValid(String email) {
		// Check if the email contains "@" and "." character
		if (email.contains("@") && email.contains(".")) {
			// Check if "@" comes before "."
			if (email.indexOf("@") < email.lastIndexOf(".")) {
				return true;
			}
		}
		return false;
	}

	private static boolean isSpecialCharacter(char ch) {
		// Define your list of special characters here
		String specialCharacters = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";
		return specialCharacters.contains(String.valueOf(ch));
	}

	public static boolean isPasswordValid(String password) {
		// Check if the password has at least 8 characters
		if (password.length() >= 8) {
			// Check if the password contains at least one lowercase letter, one uppercase
			// letter,
			// one digit, and one special character
			boolean hasLower = false;
			boolean hasUpper = false;
			boolean hasDigit = false;
			boolean hasSpecial = false;

			for (char ch : password.toCharArray()) {
				if (Character.isLowerCase(ch)) {
					hasLower = true;
				} else if (Character.isUpperCase(ch)) {
					hasUpper = true;
				} else if (Character.isDigit(ch)) {
					hasDigit = true;
				} else if (isSpecialCharacter(ch)) {
					hasSpecial = true;
				}
			}

			return hasLower && hasUpper && hasDigit && hasSpecial;
		}

		return false;
	}

	public boolean insertUserIfNotExists() throws SQLException {

		boolean insertCorrect = false;
		boolean emailCorrect = false;
		boolean passwordCorrect = false;

	 	boolean userAlreadyExists = this.checkUserExists();

		if (userAlreadyExists == true) {
			
			System.out.println("this Email is already used");
		} else {

			  if (isEmailValid(email)) {
		            System.out.println("Email is valid.");
		            emailCorrect = true;
		        } else {
		            System.out.println("Email is invalid.");
		        }

		        if (isPasswordValid(password)) {
		        	
		            System.out.println("Password is valid.");
		            passwordCorrect =true;
		        } else {
		            System.out.println("Password is invalid.");
		        }
		        
		        if(emailCorrect && passwordCorrect) {
		        	insertCorrect = true;
					this.insertUserNoCheck();
		        	
		        }
		        
				
			}

		

		return insertCorrect;
	}

	private boolean checkUserExists() throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select email from bwi520_633040_634997.user where email = ?";
		//String sql = "select count(*) from user ";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.setString(1, this.email);

		ResultSet dbRes = prep.executeQuery();
		boolean gefunden = dbRes.next();
		System.out.println("gefunden" + gefunden);
		return gefunden;
	}

	public void insertUserNoCheck() throws SQLException {
		String sql = "insert into bwi520_633040_634997.user (vorname,nachname,email,passworduser,isadmin) values (?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		
		prep.setString(1, this.vorname);
		prep.setString(2, this.nachname);
		prep.setString(3, this.email);
		prep.setString(4,  this.password);
		prep.setString(5, this.isAdmin);

		prep.executeUpdate();
		System.out.println("User " + this.vorname + " " + this.nachname + " erfolgreich angelegt");
	}

	public void readAllUserFromDB() throws SQLException {

		String sql = "SELECT userid, vorname, nachname, email, isAdmin " + "from user";
		System.out.println();
		ResultSet dbRes = new PostgreSQLAccess().getConnection().prepareStatement(sql).executeQuery();
		while (dbRes.next()) {
			this.userList.add(
					new UserBean(			
							dbRes.getInt("userId"),
							dbRes.getString("vorname"),
							dbRes.getString("nachname"),
							dbRes.getString("email"),
							dbRes.getString("isAdmin")
					)
				);

		}
	

	}
	
	public boolean checkUseridPassword() throws SQLException{
		//true: userid/pw Kombination existiert in der Datenbank
		//false: userid/pw Kombination existiert nicht in der Datenbank
		String sql = "select vorname from bwi520_633040_634997.user where email = ? and password = ?";
		System.out.println(sql);
		Connection dbConn = new PostgreSQLAccess().getConnection();
		PreparedStatement prep = dbConn.prepareStatement(sql);
		prep.setString(1, this.email);
		prep.setString(2, this.password);
		ResultSet dbRes = prep.executeQuery();
		System.out.println("User and password  match");
		return dbRes.next();
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
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

	public int getTelefonnumer() {
		return telefonnumer;
	}

	public void setTelefonnumer(int telefonnumer) {
		this.telefonnumer = telefonnumer;
	}

	public String getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(String isAdmin) {
		this.isAdmin = isAdmin;
	}

}
