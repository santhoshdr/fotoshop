package net.drs.fotoshopbackend.api.emailNotification.impl;

import java.util.ArrayList;

import net.drs.fotoshopbackend.api.emailNotification.ISendEmailNotification;
import net.drs.fotoshopbackend.dto.User;

public class SendEmailNotificationImpl implements ISendEmailNotification {

	
	
	static{
		
		
		
		
	}
	
	
	public boolean sendEmailNotification(String emailNotificationtemplate,
			User user, ArrayList extraEmailsNotifications) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean sendEmailNotification(String emailNotificationtemplate,
			User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean sendErrorEmailNotificationsToAppAdmin(
			String emailNotificationtemplate, ArrayList extraEmailsNotifications) {
		// TODO Auto-generated method stub
		return false;
	}

}
