package net.drs.fotoshop;

import static org.junit.Assert.assertEquals;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import net.drs.fotoshop.api.userdetails.IFotographerService;
import net.drs.fotoshop.api.userdetails.IRegistrationService;
import net.drs.fotoshop.api.userdetails.ISendOTP;
import net.drs.fotoshopbackend.api.emailNotification.ISendEmailNotification;
import net.drs.fotoshopbackend.dao.IRegistrationDAO;
import net.drs.fotoshopbackend.dto.Address;
import net.drs.fotoshopbackend.dto.Fotographer;
import net.drs.fotoshopbackend.dto.User;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FotographerTest {
	
private static AnnotationConfigApplicationContext annotationConfigApplicationContext;
	
	@Autowired
	private static IRegistrationService registrationService;
	
	
	@Autowired
	private static ISendOTP sendOTP;
	
	@Autowired
	private static IRegistrationDAO registrationDAO;

	@Autowired
	private static ISendEmailNotification sendEmailNotification;
	
	private User user;
	
	private static IFotographerService fotographerService;
	
	
	
	@BeforeClass
	public static void init(){
		
		annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("net.drs.fotoshop.api","net.drs.fotoshopbackend");
		annotationConfigApplicationContext.refresh();
		registrationService = (IRegistrationService)annotationConfigApplicationContext.getBean("registrationService");
		sendEmailNotification = (ISendEmailNotification)annotationConfigApplicationContext.getBean("sendEmailNotification");
		sendOTP = (ISendOTP)annotationConfigApplicationContext.getBean("sendOTP");
		fotographerService = (IFotographerService)annotationConfigApplicationContext.getBean("fotographerService");
	}
	
	@Test
	public void testAddUser(){

		Address address = null;
		Set<Address> addressset = new HashSet<Address>();
		
		address = new Address();		
		address.setAddress("Full Address");
		address.setCity("Bangalore");
		address.setState("State");
		address.setCountry("India");
		address.setLandMark("LandMark");
		address.setPincode("5600098");
		addressset.add(address);
		
		address = new Address();		
		address.setAddress("Full Address1");
		address.setCity("Bangalore1");
		address.setState("State1");
		address.setCountry("India1");
		address.setLandMark("LandMark1");
		address.setPincode("56000981");
		addressset.add(address);
		
		
		
		Fotographer fotographer = new Fotographer();
		fotographer.setFirstName("FirstName");
		fotographer.setMiddleName("MiddleName");
		fotographer.setLastName("LastName");
		fotographer.setIsactive(false);
		fotographer.setRegisteredDate(new Date(1));
		fotographer.setMobilenumber("1233453444");
		fotographer.setAddress(addressset);
		
		
		assertEquals("Success",true,registrationService.addFotographer(fotographer));
	}
	

/*	
	@Test
	public void getFotographerDetails(){
		
		Fotographer fotographer = new Fotographer();
		fotographer.setFotographerId(new Long(2));
		
		fotographer = fotographerService.getFotographerbyId(fotographer);
		
	}
	
	
	@Test
	public void deactivateFotographer(){
		
		Fotographer fotographer = new Fotographer();
		fotographer.setFotographerId(new Long(2));
		
		boolean result = fotographerService.deactivateFotographer(fotographer);
		
	}
	
	
	@Test
	public void activateFotographer(){
		
		Fotographer fotographer = new Fotographer();
		fotographer.setFotographerId(new Long(2));
		
		boolean result = fotographerService.activateFotographer(fotographer);
		
	}
	
	
	@Test
	public void updateFotographerDetails(){
		
		Fotographer fotographer = new Fotographer();
		fotographer.setFotographerId(new Long(4));
		
		fotographer = fotographerService.getFotographerbyId(fotographer);
		fotographer.setFirstName("FirstNameChanged");
		
		fotographerService.updateFotographer(fotographer);
	}
	
	
	@Test
	public void getAllActiveFotograper(){
		fotographerService.getAllActiveFotographers();
	}
*/	
}
