package dev.pedrohqlimass.itauDesafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class ItauDesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItauDesafioApplication.class, args);
	}

}
