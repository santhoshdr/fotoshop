package net.drs.fotoshop;
import net.drs.fotoshop.api.userdetails.ISendOTP;
import net.drs.fotoshop.api.userdetails.IUserDetails;
import net.drs.fotoshopbackend.dto.User;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@PropertySource("classpath:application.properties")
@Configuration
public class OTPTest {
	
	private static AnnotationConfigApplicationContext annotationConfigApplicationContext;
	
	// in minutes
	@Value("${otp.expiry.duration}")
	private String otpexpiryduration;
	
	@Value("${otp.length}")
	private String otplength;
	
	@Autowired
	private static IUserDetails userDetails;
	
	
	@Autowired
	private static ISendOTP sendOTP;
	
/*	@Autowired
	private static IRegistrationDAO registrationDAO;
*/
	
	@BeforeClass
	public static void init(){
		
		annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("net.drs.fotoshop.api","net.drs.fotoshopbackend");
		annotationConfigApplicationContext.refresh();
	
		userDetails = (IUserDetails)annotationConfigApplicationContext.getBean("userDetails");
		
		sendOTP = (ISendOTP)annotationConfigApplicationContext.getBean("sendOTP");
	}
	
/*	@Test
	public void validateOTPForUserGenerate(){
		
		User user = userDetails.getUserById(new Long(7));
		if(user.isActive()){
			sendOTP.verifyOTPGenerate(user.getUserId(),Integer.parseInt(getOtpexpiryduration()),Integer.parseInt(getOtplength()));	
		}
	}
*/
/*	@Test
	public void validateOTPForUserVerify(){

		User user = userDetails.getUserById(new Long(12));
		String enteredPassword="88851";
		sendOTP.verifyOTPVerify(user, enteredPassword);
	}
	
	*/
	public String getOtplength() {
		return otplength ==null ? "4" : otplength;
	}

	public void setOtplength(String otplength) {
		this.otplength = otplength;
	}

	public String getOtpexpiryduration() {
		return otpexpiryduration == null ? "5" : otpexpiryduration ;
	}

	public void setOtpexpiryduration(String otpexpiryduration) {
		this.otpexpiryduration = otpexpiryduration;
	}


}
