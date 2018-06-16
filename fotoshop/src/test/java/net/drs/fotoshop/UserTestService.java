package net.drs.fotoshop;

import static org.junit.Assert.assertEquals;
import net.drs.fotoshop.api.userdetails.IUserDetails;
import net.drs.fotoshopbackend.dto.User;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserTestService {

	private static AnnotationConfigApplicationContext annotationConfigApplicationContext;
	
	@Autowired
	private static IUserDetails userDetails;
	
/*	@Autowired
	private static IRegistrationDAO registrationDAO;
*/
	
	@BeforeClass
	public static void init(){
		
		annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("net.drs.fotoshop.api","net.drs.fotoshopbackend");
		annotationConfigApplicationContext.refresh();
	
		userDetails = (IUserDetails)annotationConfigApplicationContext.getBean("userDetails");
	}
	
	/*@Test
	public void getAllUsers(){
		assertEquals("Success",true,userDetails.getAllUsers().size()>1);
	}
	
	
	@Test
	public void getActiveUsers(){
		assertEquals("Success",true,userDetails.getAllActiveUsers().size()>1);
	}
	*/
/*	@Test
	public void getUserBasedonUserId(){
		assertEquals("Success",true,userDetails.getUserById(1).getFirstName().equals("FirstName"));
	}*/
	

	@Test
	public void updateUserbyID(){
		User user = userDetails.getUserById(new Long(4));
		user.setFirstName("SecondUpdate");
		user.setEmailAddress("sec@sec.com");
		assertEquals("Success",true,userDetails.updateUserDetails(user));
	}
	
	
	
	// delete user
	@Test
	public void deactivateUser(){
		
		assertEquals("Success",true,userDetails.deactiveUser(new Long(4)));
	}
	
}
