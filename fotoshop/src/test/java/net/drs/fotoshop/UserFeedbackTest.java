package net.drs.fotoshop;

import static org.junit.Assert.assertEquals;

import java.util.List;

import net.drs.fotoshop.api.userdetails.ISendOTP;
import net.drs.fotoshop.api.userdetails.IUserFeedbackService;
import net.drs.fotoshop.utility.FotoshopUtility;
import net.drs.fotoshopbackend.dto.User;
import net.drs.fotoshopbackend.dto.UserFeedback;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserFeedbackTest {
	
private static AnnotationConfigApplicationContext annotationConfigApplicationContext;
	
	@Autowired
	private static IUserFeedbackService userFeedbackService;
	
		
	@BeforeClass
	public static void init(){
		
		annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("net.drs.fotoshop.api","net.drs.fotoshopbackend");
		annotationConfigApplicationContext.refresh();
		
		userFeedbackService = (IUserFeedbackService)annotationConfigApplicationContext.getBean("userFeedbackService");
	}
	
/*	@Test
	public void testAddUser(){
		
		
		for(int i=0;i<40;i++){
		boolean result = false;
		
		UserFeedback feedback = new UserFeedback();
		feedback.setUserId(new Long(1));
		feedback.setMessage("Good Work");
		feedback.setCreatedat(FotoshopUtility.getCurrentDateandTime());
		feedback.setActive(true);
		feedback.setEmailId("dummy@dummy.com");
		feedback.setName("Dummy");
		feedback.setSubject("Suggestion");
		
		result = userFeedbackService.saveUserFeedback(feedback);
		assertEquals("Success",true,result);
		}
	}*/
	
/*	@Test
	public void getAllFeedbackDetails(){
		
		int size = userFeedbackService.retriveAllFeedbacks().size();
		assertEquals("Success",true,size>1);
		
	}*/
	

	
/*	@Test
	public void deleteFeedback(){
		
		UserFeedback feedback = new UserFeedback();
		feedback.setFeedbackId(new Long(1));
		boolean result = userFeedbackService.deleteFeedback(feedback);
		assertEquals("Success",true,result);
		
	}
*/

	@Test
	public void getActiveFeedbacks(){
		
	List<UserFeedback> userFeedback = userFeedbackService.retriveAllActiveFeedbacks();
		assertEquals("Success",true,userFeedback.size()>1);
		
	}


}
