package it.alessandro.dbconnessione1;
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
    	return new Connessione("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost/officina", "Alessandro", "coscia1994", "SELECT * FROM modello", 
    			"INSERT INTO modello (Nome_modello, Marca, Codice_modello, Alimentazione) VALUES ('Aventador', 'Lamborghini', '666', 'benzina')", 
    			"UPDATE modello SET Nome_modello= 'Spider', Marca= 'Ferrari', Alimentazione= 'GPL' WHERE modello.Codice_modello=666",
    			"DELETE FROM modello WHERE modello.Codice_modello=666");
	
	
	
}
}
