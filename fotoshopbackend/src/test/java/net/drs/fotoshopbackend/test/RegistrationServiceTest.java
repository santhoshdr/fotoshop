package net.drs.fotoshopbackend.test;

import static org.junit.Assert.*;

import java.sql.Date;

import net.drs.fotoshopbackend.dao.IRegistrationDAO;
import net.drs.fotoshopbackend.dto.User;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class RegistrationServiceTest {
	
	
	private static AnnotationConfigApplicationContext annotationConfigApplicationContext;
	
	
	@Autowired
	private static IRegistrationDAO registrationDAO;
	
	private User user;
	
	
	@BeforeClass
	public static void init(){
		
		annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("net.drs.fotoshopbackend");
		annotationConfigApplicationContext.refresh();
		annotationConfigApplicationContext.getBeanDefinitionNames();
		registrationDAO = (IRegistrationDAO) annotationConfigApplicationContext.getBean("registrationDAO");
	
	}
	
	@Test
	public void testAddUser(){
		
		
		
		java.util.Date uDate = new java.util.Date();

		user = new User();
		user.setActive(true);
		user.setAddress("Bangalore");
		user.setDateOfCreation(new java.sql.Date(uDate.getTime()));
		user.setEmailAddress("abc@abc.com");
		user.setFirstName("FirstName");
		user.setLastName("LastName");
		user.setMobileNumber("1234567889");
		user.setPassword("Password");
				
		assertEquals("Success",true,registrationDAO.addUser(user));
	}
	
}
