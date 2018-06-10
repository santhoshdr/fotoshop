package net.drs.fotoshop;

import static org.junit.Assert.assertEquals;
import net.drs.fotoshop.api.userdetails.IRegistrationService;
import net.drs.fotoshopbackend.dao.IRegistrationDAO;
import net.drs.fotoshopbackend.dto.User;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


// at fronend.. 
// use this kind..
public class RegistrationTestService {
	
	
	private static AnnotationConfigApplicationContext annotationConfigApplicationContext;
	
	@Autowired
	private static IRegistrationService registrationService;
	
	
	@Autowired
	private static IRegistrationDAO registrationDAO;

	
	private User user;
	
	@BeforeClass
	public static void init(){
		
		annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("net.drs.fotoshop.api","net.drs.fotoshopbackend");
		annotationConfigApplicationContext.refresh();
	
		registrationService = (IRegistrationService)annotationConfigApplicationContext.getBean("registrationService");
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
		user.setLastUpdated(new java.sql.Date(uDate.getTime()));				
		
		assertEquals("Success",true,registrationService.adduser(user));
	}
	
}
