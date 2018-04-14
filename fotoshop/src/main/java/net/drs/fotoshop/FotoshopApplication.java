package net.drs.fotoshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"net.drs.fotoshop.controller"})
public class FotoshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(FotoshopApplication.class, args);
	}
}
