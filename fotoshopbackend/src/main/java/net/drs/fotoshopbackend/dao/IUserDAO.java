package net.drs.fotoshopbackend.dao;

import java.util.List;

import net.drs.fotoshopbackend.dto.Otp;
import net.drs.fotoshopbackend.dto.User;

public interface IUserDAO {

	
	List<User> getAllUsers();
	
	
	List<User> getAllActiveUsers();
	
	
	User getUser(Long userId);
	
	
	boolean isUserActive(Long userId);
	
	
	boolean activateUser(Long userId);
	
	
	boolean deactivateUser(Long userId);
	
	boolean updateUser(User user);
	
	
	// to send OTP
	boolean validateOTPGenerate(Long userid,char[] generatedOTP, int vaidFor,boolean isValidated);
	
	
	// to validate entered OTP
	//boolean validateOTPVerify(Long userid,String generatedOTP, String vaidFor,boolean isValidated);
	
	boolean updateUserEnteredOTP(User userid,String userEnteredOTP);
	

	Otp getOTPForUserId(Long userid);
	
}
