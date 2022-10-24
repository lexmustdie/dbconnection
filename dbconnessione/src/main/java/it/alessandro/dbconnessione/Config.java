package it.alessandro.dbconnessione;
import java.io.File;
import java.sql.Statement;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import it.alessandro.Connessione;

@Configuration
@ComponentScan(basePackageClasses = Connessione.class)

public class Config {
	@Bean
	public Connessione getDatabase() {
    	return new Connessione("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost/officina", "Alessandro", "coscia1994");
	
	
	
}
}
