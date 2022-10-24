package it.alessandro;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import lombok.Data;
import lombok.ToString;

public class Connessione {
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	  static final String DB_URL = "jdbc:mysql://localhost/officina";

	  // Database credentials
	  static final String USER = "Alessandro";
	  static final String PASS = "coscia1994";
	  
	  int scelta;
	  Scanner input = new Scanner(System.in);
	  
	  public Connessione(String JDBC_DRIVER, String DB_URL, String USER, String PASS, String sql, String sql1, String sql2, String sql3) {
		  Connection conn = null;
		    Statement stmt = null;
		    try {
		      // Register JDBC driver
		      Class.forName(JDBC_DRIVER);

		      // Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      // Execute a query
	
		    } catch (SQLException se) {
		      se.printStackTrace();
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      // finally block used to close resources
		      try {
		        if (conn != null)
		        	while(scelta!=5) {
		        	System.out.println("Selezionare opzione:");
		        	System.out.println("************");
					System.out.println("*1 - Select*");
					System.out.println("*2 - Insert*");
					System.out.println("*3 - Update*");
					System.out.println("*4 - Delete*");
					System.out.println("*5 - Esci  *");
					System.out.println("************");
					scelta=Integer.parseInt(input.nextLine());
		        	
					switch(scelta) {
					case 1:
						System.out.println("Creating statement...");
					      stmt = conn.createStatement();
					      //String sql;
					      

					      ResultSet rs = stmt.executeQuery(sql);

					      // Extract data from result set
					      while (rs.next()) {
					    	  
					    	  String Nome_modello = rs.getString("Nome_modello");
					    	  String Marca = rs.getString("Marca");
					    	  String Codice_modello = rs.getString("Codice_modello");
					    	  String Alimentazione = rs.getString("Alimentazione");
					    	  
					    	  System.out.println("Nome_modello: " + Nome_modello);
					          System.out.println("Marca: " + Marca);
					          System.out.println("Codice_modello: " + Codice_modello);
					          System.out.println("Alimentazione: " + Alimentazione);
					          System.out.println(" ");
					      }
					      stmt.close();
						break;
					case 2:
						System.out.println("Creating statement...");
					      stmt = conn.createStatement();
					      stmt.execute(sql1);
					      stmt.close();
						break;
					case 3:
						System.out.println("Creating statement...");
					      stmt = conn.createStatement();
					      stmt.execute(sql2);
					      stmt.close();
						break;
					case 4:
						System.out.println("Creating statement...");
					      stmt = conn.createStatement();
					      stmt.execute(sql3);
					      stmt.close();
						break;
					case 5:
						System.out.println("Arrivederci");
						break;
					default:
						System.out.println("Scelta non valida");	
						break;
					
					}
		        	
		          
		        	}
		      } 
		      catch (SQLException se2) {
		      }
		      try {
		        if (conn != null)
		          conn.close();
		      } catch (SQLException se) {
		        se.printStackTrace();
		      }
		    }
		    System.out.println("Goodbye!");
		  
	  }

}
