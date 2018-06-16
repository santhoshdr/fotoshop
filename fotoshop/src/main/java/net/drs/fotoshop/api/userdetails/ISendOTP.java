package net.drs.fotoshop.api.userdetails;

import net.drs.fotoshopbackend.dto.User;

public interface ISendOTP {

	
	boolean verifyOTPGenerate(User userid,int expiryDuration,int otpLength);
	
	
	boolean verifyOTPVerify(User userid,String userEnteredOTP);
	
	
//	boolean updateUserEnteredOTP(User user, char [] userEnteredOTP);
	
}
