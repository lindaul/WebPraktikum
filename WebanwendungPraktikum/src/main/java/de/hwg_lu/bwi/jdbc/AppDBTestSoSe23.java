package de.hwg_lu.bwi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AppDBTestSoSe23 {

	Connection dbConn;
	String dbSchema = "bwi520_633040_634997";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		AppDBTestSoSe23 myAppObj = new AppDBTestSoSe23();
		myAppObj.doSomething();
	}
	
	
	public void insertintoUser() throws SQLException, SQLException{
		String sql = "insert into user (vorname, nachname,email,IsAdmin) values (?,?)"
				     + "";
		System.out.println(sql);
	
	}

	public void doSomething() throws ClassNotFoundException, SQLException {
		System.out.println("dosSomething() gestartet");
		this.createConnection();
		// this.dropSchema();
		//this.createSchema();
		this.setSchema();
		//this.dropTableUser();
		this.createTableUser();
	}

	public void dropTableUser() throws SQLException{
		String sql = "drop table if exists user ";
		System.out.println(sql);
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.executeUpdate();
		System.out.println("Table User gedropped.");
	}
	

	public void createTableUser() throws SQLException {
      String sql= "create table userTest("
    		  + "  userId   serial      	not null  primary key, "
    		  + "  vorname  varchar(100)    not null, "
    		  + "  nachname varchar(100)    not null  default 18, "
    		  + "  email    varchar(256) 	not null  default '', "
    		  + "  IsAdmin  char(1)      	not null  default  'Y' "
    		  + ");";
      
         System.out.println(sql);
         this.dbConn.prepareStatement(sql).executeUpdate();
		 System.out.println(" Table Usertest angelegt.");
	}

	public void setSchema() throws SQLException {
		String sql="set schema '" + this.dbSchema + "'";
		System.out.println(sql);
        this.dbConn.prepareStatement(sql).executeUpdate();
	    System.out.println("Schema " + this.dbSchema + " als Standard gesetzt.");
	}

	public void dropSchema() throws SQLException {

		String sql = "drop schema if exists  " + this.dbSchema + " cascade";
		System.out.println(sql);
		this.dbConn.prepareStatement(sql).executeUpdate();
		System.out.println("Schema " + this.dbSchema + " gelöscht.");

	}

	public void createSchema() throws SQLException {
		//Statement als String
		String sql = "create schema IF NOT EXISTS " + this.dbSchema + "";
		System.out.println(sql);
		//Statement als Object, Voraussetzung: dbConn
		PreparedStatement prep = this.dbConn.prepareStatement(sql);
		prep.executeUpdate();
		System.out.println("Schema " + this.dbSchema + " angelegt.");

	}

	public void createConnection() throws ClassNotFoundException, SQLException {

		Class.forName("org.postgresql.Driver");
		this.dbConn = DriverManager.getConnection(
				      "jdbc:postgresql://143.93.200.243:5435/BWUEBDB", 
				       "user1", 
				       "pgusers");

		System.out.println("JDBC-Connection hergestellt");

		// this.dbConn =????

	}

}

