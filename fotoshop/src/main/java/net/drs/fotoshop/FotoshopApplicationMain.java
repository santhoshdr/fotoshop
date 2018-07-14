package net.drs.fotoshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// added the below @Enable... after i got the exception java.lang.ClassCastException: org.springframework.orm.jpa.EntityManagerHolder 
// cannot be cast to org.springframework.orm.hibernate5.SessionHolder
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@ComponentScan(basePackages = {"net.drs.fotoshop.controller","net.drs.fotoshop.restcontroller","net.drs.fotoshop.api","net.drs.fotoshopbackend"/* this is for rest controller */})
public class FotoshopApplicationMain implements CommandLineRunner  {

	@Autowired
    private ServerProperties serverProperties;
	
	public static void main(String[] args) {
		SpringApplication.run(FotoshopApplicationMain.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(serverProperties);
		
	}
	
	
	//http://websystique.com/springmvc/spring-mvc-4-angularjs-example/
	//http://websystique.com/springmvc/spring-mvc-4-restful-web-services-crud-example-resttemplate/
}
