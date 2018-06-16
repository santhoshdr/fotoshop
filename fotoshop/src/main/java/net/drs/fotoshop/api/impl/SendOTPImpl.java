package net.drs.fotoshop.api.impl;

import java.util.Arrays;

import net.drs.fotoshop.api.userdetails.ISendOTP;
import net.drs.fotoshop.utility.FotoshopUtility;
import net.drs.fotoshopbackend.dao.IUserDAO;
import net.drs.fotoshopbackend.dto.Otp;
import net.drs.fotoshopbackend.dto.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository("sendOTP")
public class SendOTPImpl implements ISendOTP {


	@Autowired
	private IUserDAO userDAO; 
	
	@Override
	public boolean verifyOTPGenerate(User user, int expiryDuration,int otpLength) {
		char[] otp = FotoshopUtility.generateOTP(otpLength);
		userDAO.validateOTPGenerate(user.getUserId(), otp, expiryDuration, false);
		
		// send SMS here... 
		return true;
	}

	@Override
	public boolean verifyOTPVerify(User user, String userEnteredOTP) {
	
		boolean result = false;
		Otp otp = userDAO.getOTPForUserId(new Long(user.getUserId()));
		char [] otpChar= otp.getUniqueOTPSent();
		char [] enteredOTPChar =userEnteredOTP.toCharArray();

		boolean retval = Arrays.equals(otpChar, enteredOTPChar);
		
		if(retval){
			userDAO.activateUser(user.getUserId());
			result= true;
		}
		
		// no matter, correct or wrong - update user entered otp
		userDAO.updateUserEnteredOTP(user, userEnteredOTP);
		
		
		return result;
	}

		
	}
