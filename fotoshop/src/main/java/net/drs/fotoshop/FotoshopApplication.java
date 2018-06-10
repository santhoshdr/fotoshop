package net.drs.fotoshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"net.drs.fotoshop.controller"})
public class FotoshopApplication implements CommandLineRunner  {

	@Autowired
    private ServerProperties serverProperties;
	
	public static void main(String[] args) {
		SpringApplication.run(FotoshopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(serverProperties);
		
	}
}
