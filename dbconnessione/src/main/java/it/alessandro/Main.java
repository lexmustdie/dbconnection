package it.alessandro;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.sql.*;
import it.alessandro.dbconnessione.Config;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		Connessione connessione = context.getBean(Connessione.class);
		
		
	}

}
