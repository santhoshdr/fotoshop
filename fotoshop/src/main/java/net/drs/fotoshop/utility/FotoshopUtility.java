package net.drs.fotoshop.utility;

import java.util.Random;

public class FotoshopUtility {

	
	
	public static java.sql.Date getCurrentDateandTime() {
		java.util.Date uDate = new java.util.Date();
		        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
		        return sDate;

	}

	
	
	public static char[] generateOTP(int len){
		    System.out.println("Generating OTP using random() : ");
	        System.out.print("You OTP is : ");
	        // Using numeric values
	        String numbers = "0123456789";
	        // Using random method
	        Random rndm_method = new Random();
	        char[] otp = new char[len];
	        for (int i = 0; i < len; i++)
	        {
	            otp[i] =numbers.charAt(rndm_method.nextInt(numbers.length()));
	        }
	        return otp;
	    }
		
	
	public static boolean sendSMS(String phoneNumber, String message){
		boolean result=false;
	
		
		return result;
	}

}

