package de.hwg_lu.bwi.jdbc;

import java.sql.SQLException;

public class PostgreSQLAccess extends JDBCAccess {

	public PostgreSQLAccess() throws NoConnectionException {
		super();
	}
	public void setDBParms(){
		dbDrivername = "org.postgresql.Driver";
		dbURL        = "jdbc:postgresql://143.93.200.243:5435/BWUEBDB";
		dbUser       = "user1";
		dbPassword   = "pgusers";
//		dbURL        = "jdbc:postgresql://localhost:5432/BWUEBDB";
//		dbUser       = "postgres";
//		dbPassword   = "pgadmin";
		dbSchema     = "bwi520_633040_634997"; // hier Matrikelnummer eintragen
		
	}
	public void setSchema() throws NoConnectionException {
		this.setSchema(dbSchema);
	}
	public void setSchema(String currentSchema) throws NoConnectionException {
		try{
			String sql = "SET SCHEMA '" + currentSchema + "'";
			System.out.println(sql);
			dbConn.createStatement().executeUpdate(sql);
			System.out.println("Schema " + currentSchema + " erfolgreich gesetzt");
		}catch(SQLException se){
			se.printStackTrace();
			throw new NoConnectionException();
		}
	}
	public PostgreSQLAccess(String currentSchema) throws NoConnectionException {
		super();
		this.setSchema(currentSchema);
	}
	public static void main(String[] args) throws NoConnectionException { 
		new PostgreSQLAccess().getConnection();
	}
}
