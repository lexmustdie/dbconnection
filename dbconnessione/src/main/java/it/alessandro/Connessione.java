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
		
		public Connessione(String JDBC_DRIVER, String DB_URL, String USER, String PASS) {
			Connection conn = null;
			Statement stmt = null;
		    try {
		      // Register JDBC driver
		      Class.forName(JDBC_DRIVER);

		      // Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      
		    } catch (SQLException se) {
		      se.printStackTrace();
		    } catch (Exception e) {
		      e.printStackTrace();
		    } finally {
		      // finally block used to close resources
		      
		      try {
		       
				if (conn != null) 
					
					System.out.println("Selezionare opzione:");
					System.out.println("1 - Select");
					System.out.println("2 - Insert");
					System.out.println("3 - Update");
					System.out.println("4 - Delete");
					System.out.println("5 - Esci");
					scelta=Integer.parseInt(input.nextLine());
					
					if(scelta==1) {
					String codModello;
					int trovato=0;
					
					System.out.println("Inserire codice modello");
						codModello=input.nextLine();
						stmt = conn.createStatement();
					      String sql;
					      sql = "SELECT Nome_modello, Marca, Codice_modello, Alimentazione FROM modello WHERE modello.Codice_modello= " + codModello;
					      
					      ResultSet rs = stmt.executeQuery(sql);
					      
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
					          trovato++;
					    	  }
					      if(trovato==0)
					      {
					    	  System.out.println("Modello non trovato");
					      }
					     
					      // Clean-up environment
					      rs.close();
					      stmt.close();
					      conn.close();
					}
					if(scelta==2)
					{
						String nomeModello;
						String marca;
						String codiceModello;
						String alimentazione;
						
						System.out.println("Inserisci nome modello");
						nomeModello=input.nextLine();
						System.out.println("Inserisci marca");
						marca=input.nextLine();
						System.out.println("Inserisci codice modello");
						codiceModello=input.nextLine();
						System.out.println("Inserisci alimentazione");
						alimentazione=input.nextLine();
						
						stmt = conn.createStatement();
					      String sql;
					      stmt.execute("INSERT INTO `modello`(`Nome_modello`, `Marca`, `Codice_modello`, `Alimentazione`) VALUES ('" + nomeModello + "','" + marca + "','" + codiceModello + "','" + alimentazione + "')");
					   
					}
					if(scelta==3) {
						String codModello;
						System.out.println("Inserire codice modello");
						int trovato=0;
						
						codModello=input.nextLine();
						stmt = conn.createStatement();
					      String sql;
					      sql = "SELECT Nome_modello, Marca, Codice_modello, Alimentazione FROM modello WHERE modello.Codice_modello= " + codModello;
					      ResultSet rs = stmt.executeQuery(sql);
					      
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
				          trovato++;
				    	  }
				    	  if(trovato==0)
					      {
					    	  System.out.println("Modello non trovato");
					      }
				    	  if(trovato==1) {
				    		  String nomeModello;
								String marca;
								
								String alimentazione;
								
								System.out.println("Inserisci nuovo nome modello");
								nomeModello=input.nextLine();
								System.out.println("Inserisci nuova marca");
								marca=input.nextLine();
								System.out.println("Modifica alimentazione");
								alimentazione=input.nextLine();
								
								stmt = conn.createStatement();
							      stmt.executeUpdate("UPDATE `modello` SET `Nome_modello`='" + nomeModello + "',`Marca`='"+ marca + "',`Alimentazione`='" + alimentazione + "' WHERE modello.Codice_modello=" + codModello);
				    	  }
						      
						
					}
					if(scelta==4)
					{
						String codModello;
						System.out.println("Inserire codice modello");
						int trovato=0;
						
						codModello=input.nextLine();
						stmt = conn.createStatement();
					      String sql;
					      sql = "SELECT Nome_modello, Marca, Codice_modello, Alimentazione FROM modello WHERE modello.Codice_modello= " + codModello;
					      ResultSet rs = stmt.executeQuery(sql);
					      
				    	  while (rs.next()) {
				    	  
				    	  String Nome_modello = rs.getString("Nome_modello");
				    	  String Marca = rs.getString("Marca");
				    	  String Codice_modello = rs.getString("Codice_modello");
				    	  String Alimentazione = rs.getString("Alimentazione");
				    	  
				          trovato++;
				    	  }
				    	  if(trovato==0)
					      {
					    	  System.out.println("Modello non trovato");
					      }
				    	  if(trovato==1) {
				    		  stmt = conn.createStatement();
						      stmt.executeUpdate("DELETE FROM `modello` WHERE modello.Codice_modello=" + codModello);
				    	  }
						
						
						
						
						
					}
						
						
					
		          conn.close();
		      } 
				catch (SQLException se) 
				{
		        se.printStackTrace();
		      }
		    }
		    
		  }

		
	
	}


