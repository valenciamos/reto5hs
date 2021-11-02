package co.usa.recursosh.recursosh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan (basePackages = {"co.usa.recursosh.recursosh.model"})
@SpringBootApplication
public class RecursoshApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecursoshApplication.class, args);
	}

}
