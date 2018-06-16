package net.drs.fotoshop;

import static org.junit.Assert.assertEquals;
import net.drs.fotoshop.api.userdetails.IRegistrationService;
import net.drs.fotoshop.api.userdetails.ISendOTP;
import net.drs.fotoshopbackend.api.emailNotification.ISendEmailNotification;
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
	private static ISendOTP sendOTP;
	
	@Autowired
	private static IRegistrationDAO registrationDAO;

	
	private static ISendEmailNotification sendEmailNotification;
	
	private User user;
	
	@BeforeClass
	public static void init(){
		
		annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("net.drs.fotoshop.api","net.drs.fotoshopbackend");
		annotationConfigApplicationContext.refresh();
		registrationService = (IRegistrationService)annotationConfigApplicationContext.getBean("registrationService");
		sendEmailNotification = (ISendEmailNotification)annotationConfigApplicationContext.getBean("sendEmailNotification");
		sendOTP = (ISendOTP)annotationConfigApplicationContext.getBean("sendOTP");
	}
	
	@Test
	public void testAddUser(){
		
		java.util.Date uDate = new java.util.Date();

		user = new User();
		user.setAddress("Bangalore");
		user.setDateOfCreation(new java.sql.Date(uDate.getTime()));
		user.setEmailAddress("abc@abc.com");
		user.setFirstName("FirstName");
		user.setLastName("LastName");
		user.setMobileNumber("1234567889");
		user.setPassword("Password");
		user.setLastUpdated(new java.sql.Date(uDate.getTime()));				
		
		boolean result =registrationService.adduser(user);
		if(result){
			sendEmailNotification.sendEmailNotification("sendEmailNotification", user);
			
			sendOTP.verifyOTPGenerate(user,5,5);	
		}
		
		assertEquals("Success",true,result);
	}
	
	
}
